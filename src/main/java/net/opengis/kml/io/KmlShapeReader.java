/*
 * Copyright 2018 Key Bridge.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.opengis.kml.io;

import org.locationtech.jts.geom.GeometryCollection;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import java.util.*;
import net.opengis.kml.*;

/**
 * KML reader.
 * <p>
 * This utility reads KML files and returns a collection of
 * {@code GISFeatureCollection} and {@code GISFeature} DTO object instances.
 *
 * @author Key Bridge
 * @since v1.4.0 added 05/08/18 to support KML ETL; rewrite 05/09/18 using
 * recursion
 */
public class KmlShapeReader {

  /**
   * Supplies a set of utility methods for building Geometry objects from lists
   * of Coordinates.
   * <p>
   * This factory is constructed with a precision model supporting up to 6
   * significant digits. Precision is decimal places + 1.
   */
  private final GeometryFactory geometryFactory;

  public KmlShapeReader() {
    /**
     * Initialize the GeometryFactory with a precision model.
     */
    this.geometryFactory = new GeometryFactory(new PrecisionModel(Math.pow(10, 7)));
  }

  /**
   * Transform a KML file into a collection of well-formed GIS DTO objects.
   * <p>
   * This transformer converts Kml {@code Folder} into
   * {@code GISFeatureCollection} DTO and Kml {@code Placemark} into
   * {@code GISFeature} DTO.
   * <p>
   * Use the {@code unmarshal} methods in the Kml file to read files.
   *
   * @param kml a KML document object
   * @return a non-null ArrayList
   */
  public List<KmlShape> read(Kml kml) {
    /**
     * Recursively transform the top level Kml Feature element into a collection
     * of GIS DTO features. The top level feature could be anything, but is
     * typically a Document or Folder.
     */
    List<KmlShape> shapes = transformFeature(kml.getFeature());
    return shapes;
//    GISFeatureCollection featureCollection = transformFeature(kml.getFeature());
//    return featureCollection;
    /**
     * Here we capture only three feature types. Others are for display and eye
     * candy and ignored.
     * <pre>
     * Container
     * Document         (capture)  (recursive docs are allowed)
     * Folder           (capture)
     * GroundOverlay
     * NetworkLink
     * Overlay
     * PhotoOverlay
     * Placemark        (capture)
     * ScreenOverlay
     * Tour
     * </pre>
     */
  }

  /**
   * Recursively transform a {@code Feature} into a GISFeatureCollection
   * instance.
   * <p>
   * Supported Feature instances are {@code Folder}, {@code Document},
   * {@code Placemark}.
   * <p>
   * A Folder is used to arrange other Features hierarchically (Folders,
   * Placemarks, NetworkLinks, or Overlays). A Feature is visible only if it and
   * all its ancestors are visible.
   *
   * @param feature a KML Folder
   * @return a GISFeatureCollection instance.
   */
  protected List<KmlShape> transformFeature(Feature feature) {
    /**
     * Construct a new GIS Feature. If the feature has extended data then set
     * the feature properties.
     */
    List<KmlShape> shapes = new ArrayList<>();

//    GISFeatureCollection featureCollection = new GISFeatureCollection();
//    featureCollection.setId(feature.getId());
//    featureCollection.setName(feature.getName());
//    featureCollection.setDescription(feature.getDescription());
//    featureCollection.addProperties(transformExtendedData(feature));
//    Map<String, String> data = transformExtendedData(feature);
    /**
     * Recursively seek into documents. Flatten into one feature collection.
     */
    if (feature instanceof Document) {
      for (Feature f : ((Document) feature).getFeature()) {
        shapes.addAll(transformFeature(f));
        //        featureCollection.getFeatures().addAll(transformFeature(f).getFeatures());
      }
    }
    /**
     * Recursively seek into Folders. Flatten into one feature collection.
     */
    if (feature instanceof Folder) {
      for (Feature f : ((Folder) feature).getFeature()) {
        shapes.addAll(transformFeature(f));
//        featureCollection.getFeatures().addAll(transformFeature(f).getFeatures());
      }
    }
    /**
     * Transform the feature if it is a Placemark.
     */
    if (feature instanceof Placemark) {
      shapes.add(transformPlacemark((Placemark) feature));
//      featureCollection.addFeatures(transformPlacemark((Placemark) feature));
    }
    /**
     * Copy the parent feature properties to each shape. This typically includes
     * top-level parameters like file name, version, creation date, etc.
     */
    transformExtendedData(feature).entrySet().forEach(e -> shapes.forEach(s -> s.setProperty(e.getKey(), e.getValue())));
    /**
     * HACK: GISFeatureCollection does not requires a unique ID but we should
     * provide one anyway. If the KML entry does not have an ID then generate
     * one. Note that the {@code CollapsedStringAdapter} produces a "null"
     * string when the field is not present, so we must also check for "null"
     * here.
     */
//    if (featureCollection.getId() == null || featureCollection.getId().isEmpty() || featureCollection.getId().equalsIgnoreCase("null")) {
//      featureCollection.setId(Math.abs(Objects.hashCode(feature)));
//    }
    return shapes;
  }

  /**
   * Transform a KML Placemark into a GISFeature entity.
   * <p>
   * A Placemark is a Feature with associated Geometry.
   *
   * @param placemark a KML Placemark
   * @return a GISFeature instance
   */
  protected KmlShape transformPlacemark(Placemark placemark) {
    /**
     * Construct a new GIS Feature. If the feature has extended data then set
     * the feature properties.
     */
    KmlShape shape = new KmlShape();

//    GISFeature shape = new GISFeature();
    shape.setPlacemarkId(placemark.getId());
    shape.setName(placemark.getName());
    shape.setDescription(placemark.getDescription());
    shape.setProperties(transformExtendedData(placemark));
    /**
     * A string value representing an unstructured address written as a standard
     * street, city, state address, and/or as a postal code. You can use the
     * <address> tag to specify the location of a point instead of using
     * latitude and longitude coordinates.
     */
//    String address = placemark.getAddress();
    /**
     * Set the geometry.
     */
    shape.setShape(transformGeometry(placemark.getGeometry()));
    /**
     * HACK: GISFeature requires a unique ID. If the KML entry does not have an
     * ID then generate one. Note that the {@code CollapsedStringAdapter}
     * produces a "null" string when the field is not present, so we must also
     * check for "null" here.
     */
    if (shape.getId() == null) {
      shape.setId((long) Math.abs(Objects.hashCode(shape.getShape())));
    }
    /**
     * Done.
     */
    return shape;
  }

  /**
   * Transform a Feature ExtendedData element to a simple Map. This method
   * copies the extended data [name, value] elements into a simple HashMap.
   *
   * @param feature a Feature instance
   * @return a non-null HashMap
   */
  protected Map<String, String> transformExtendedData(Feature feature) {
    Map<String, String> properties = new HashMap<>();
    if (feature.getExtendedData() != null) {
      for (Data data : feature.getExtendedData().getData()) {
        properties.put(data.getName(), data.getValue());
      }
    }
    return properties;
  }

  /**
   * Transform a KML geometry type to a JTS geometry type
   *
   * @param kmlGeometry a KML geometry type
   * @return a JTS geometry type
   */
  protected org.locationtech.jts.geom.Geometry transformGeometry(Geometry kmlGeometry) {
    org.locationtech.jts.geom.Geometry geometry = null;

    switch (kmlGeometry.getClass().getSimpleName()) {
      /**
       * A closed line string, typically the outer boundary of a Polygon.
       */
      case "LinearRing": {
        geometry = transformLinearRing((LinearRing) kmlGeometry);
        break;
      }
      /**
       * A connected set of line segments.
       */
      case "LineString": {
        geometry = transformLineString((LineString) kmlGeometry);
        break;
      }
      /**
       * Model is a Google Earth proprietary 3D object described in a COLLADA
       * file. Models are created in their own coordinate space and then
       * located, positioned, and scaled in Google Earth.
       */
      case "Model": {
        // NOT SUPPORTED
        break;
      }
      /**
       * A container for zero or more geometry primitives associated with the
       * same feature.
       */
      case "MultiGeometry": {
        geometry = transformMultiGeometry((MultiGeometry) kmlGeometry);
        break;
      }
      /**
       * Track is Google Earth proprietary object.
       */
      case "MultiTrack": {
        // NOT SUPPORTED
        break;
      }
      /**
       * A geographic location defined by longitude, latitude, and (optional)
       * altitude.
       */
      case "Point": {
        geometry = transformPoint((Point) kmlGeometry);
        break;
      }
      /**
       * A Polygon is defined by an outer boundary and 0 or more inner
       * boundaries. The boundaries, in turn, are defined by LinearRings.
       */
      case "Polygon": {
        geometry = transformPolygon((Polygon) kmlGeometry);
        break;
      }
      /**
       * Track is Google Earth proprietary object.
       */
      case "Track": {
        // NOT SUPPORTED
      }
      default: {
        throw new IllegalArgumentException("Geometry type " + kmlGeometry.getClass().getSimpleName() + " not supported yet.");
      }

    }
    /**
     * Done.
     */
    return geometry;

  }

  /**
   * Transform a KML Point to a JS Point.
   *
   * @param point a KML Point
   * @return a JS Point
   */
  protected org.locationtech.jts.geom.Point transformPoint(Point point) {
    Coordinate coordinate = point.getCoordinates().get(0);
    return geometryFactory.createPoint(transformCoordinate(coordinate));
  }

  /**
   * Transform a KML MultiGeometry to a JTS GeometryCollection.
   * <p>
   * MultiGeometry is a container for zero or more geometry primitives
   * associated with the same feature.
   *
   * @param multiGeometry a KML MultiGeometry
   * @return a JTS GeometryCollection
   */
  protected GeometryCollection transformMultiGeometry(MultiGeometry multiGeometry) {
    Collection<org.locationtech.jts.geom.Geometry> geometries = new ArrayList<>();
    for (Geometry geometry : multiGeometry.getGeometry()) {
      geometries.add(transformGeometry(geometry));
    }
    return geometryFactory.createGeometryCollection(geometries.toArray(new org.locationtech.jts.geom.Geometry[geometries.size()]));
  }

  /**
   * Transform a KML LineString to a JTS LineString geometry.
   *
   * @param lineString a KML LineString
   * @return a JTS LineString
   */
  protected org.locationtech.jts.geom.LineString transformLineString(LineString lineString) {
    Collection<org.locationtech.jts.geom.Coordinate> coordinates = new ArrayList<>();
    for (Coordinate coordinate : lineString.getCoordinates()) {
      coordinates.add(transformCoordinate(coordinate));
    }
    return geometryFactory.createLineString(coordinates.toArray(new org.locationtech.jts.geom.Coordinate[coordinates.size()]));
  }

  /**
   * Transform a KML LinearRing to a JTS LinearRing geometry.
   *
   * @param linearRing a KML LinearRing
   * @return a JTS LinearRing
   */
  protected org.locationtech.jts.geom.LinearRing transformLinearRing(LinearRing linearRing) {
    Collection<org.locationtech.jts.geom.Coordinate> coordinates = new ArrayList<>();
    for (Coordinate coordinate : linearRing.getCoordinates()) {
      coordinates.add(transformCoordinate(coordinate));
    }
    return geometryFactory.createLinearRing(coordinates.toArray(new org.locationtech.jts.geom.Coordinate[coordinates.size()]));
  }

  /**
   * Transform a KML Polygon to a JTS polygon geometry.
   *
   * @param polygon a KML Polygon
   * @return a JTS polygon
   */
  protected org.locationtech.jts.geom.Polygon transformPolygon(Polygon polygon) {
    /**
     * Outer ring
     */
    org.locationtech.jts.geom.LinearRing outerRing = transformLinearRing(polygon.getOuterBoundaryIs().getLinearRing());
    /**
     * Inner rings. A Polygon can contain multiple innerBoundaryIs elements,
     * which create multiple cut-outs inside the Polygon.
     */
    Collection<org.locationtech.jts.geom.LinearRing> innerRings = new ArrayList<>();
    for (Boundary innerBoundary : polygon.getInnerBoundaryIs()) {
      org.locationtech.jts.geom.LinearRing innerRing = transformLinearRing(innerBoundary.getLinearRing());
      innerRings.add(innerRing);
    }
    /**
     * Constructs a Polygon with the given exterior boundary and interior
     * boundaries.
     */
    return geometryFactory.createPolygon(outerRing, innerRings.toArray(new org.locationtech.jts.geom.LinearRing[innerRings.size()]));
  }

  /**
   * Transform a KML coordinate to a JTS coordinate.
   *
   * @param coordinate a KML coordinate
   * @return a JTS coordinate.
   */
  protected org.locationtech.jts.geom.Coordinate transformCoordinate(Coordinate coordinate) {
    return new org.locationtech.jts.geom.Coordinate(coordinate.getLongitude(),
                                                      coordinate.getLatitude(),
                                                      coordinate.getAltitude());
  }

}
