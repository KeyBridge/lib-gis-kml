/*
 * Copyright (C) 2017 Key Bridge LLC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see  http://www.gnu.org/licenses.
 */
package net.opengis.kml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import net.opengis.kml.annotations.Obvious;

/**
 * &lt;LinearRing&gt;
 * <p>
 * Defines a closed line string, typically the outer boundary of a Polygon.
 * Optionally, a LinearRing can also be used as the inner boundary of a Polygon
 * to create holes in the Polygon. A Polygon can contain multiple
 * &lt;LinearRing&gt; elements used as inner boundaries. Note: In Google Earth,
 * a Polygon with an &lt;altitudeMode&gt; of clampToGround follows the great
 * circle; however, a LinearRing (by itself) with an &lt;altitudeMode&gt; of
 * clampToGround follows lines of constant latitude. Syntax: &lt;pre&gt;
 * &lt;strong&gt;&lt;LinearRing id="ID"&gt; &lt;/strong&gt; &lt;!-- specific to
 * LinearRing --&gt; &lt;extrude&gt;0&lt;/extrude&gt; &lt;!-- boolean --&gt;
 * &lt;tessellate&gt;0&lt;/tessellate&gt; &lt;!-- boolean --&gt;
 * &lt;altitudeMode&gt;clampToGround&lt;/altitudeMode&gt; &lt;!--
 * kml:altitudeModeEnum: clampToGround, relativeToGround, &lt;em&gt;or
 * &lt;/em&gt; absolute --&gt; &lt;!-- or, substitute gx:altitudeMode:
 * clampToSeaFloor, relativeToSeaFloor --&gt; &lt;coordinates&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/coordinates&gt; &lt;!-- lon,lat[,alt] tuples --&gt;
 * &lt;strong&gt;&lt;/LinearRing&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Geometry&gt;
 *
 * Contained By:
 * @see: &lt;MultiGeometry&gt;
 * @see: &lt;Placemark&gt;
 * @see: &lt;innerBoundaryIs&gt;
 * @see: &lt;outerBoundaryIs&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinearRingType", propOrder = {
  "extrude",
  "tessellate",
  "altitudeMode",
  "coordinates",
  "linearRingSimpleExtension",
  "linearRingObjectExtension"
})
@XmlRootElement(name = "LinearRing", namespace = "http://www.opengis.net/kml/2.2")
public class LinearRing
  extends Geometry
  implements Cloneable {

  /**
   * &lt;extrude&gt;
   * <p>
   * Boolean value. Specifies whether to connect the LineString to the ground.
   * To extrude a LineString, the altitude mode must be either relativeToGround,
   * relativeToSeaFloor, or absolute. The vertices in the LineString are
   * extruded toward the center of the Earth's sphere. Boolean value. Specifies
   * whether to connect the LinearRing to the ground. To extrude this geometry,
   * the altitude mode must be either relativeToGround, relativeToSeaFloor, or
   * absolute. Only the vertices of the LinearRing are extruded, not the center
   * of the geometry. The vertices are extruded toward the center of the Earth's
   * sphere. Boolean value. Specifies whether to connect the Polygon to the
   * ground. To extrude a Polygon, the altitude mode must be either
   * relativeToGround, relativeToSeaFloor, or absolute. Only the vertices are
   * extruded, not the geometry itself (for example, a rectangle turns into a
   * box with five faces. The vertices of the Polygon are extruded toward the
   * center of the Earth's sphere. Boolean value. Specifies whether to connect
   * the point to the ground with a line. To extrude a Point, the value for
   * &lt;altitudeMode&gt; must be either relativeToGround, relativeToSeaFloor,
   * or absolute. The point is extruded toward the center of the Earth's sphere.
   */
  @XmlElement(defaultValue = "0")
  @XmlJavaTypeAdapter(BooleanConverter.class)
  protected Boolean extrude;
  /**
   * &lt;tessellate&gt;
   * <p>
   * Boolean value. Specifies whether to allow the LineString to follow the
   * terrain. To enable tessellation, the altitude mode must be clampToGround or
   * clampToSeaFloor. Very large LineStrings should enable tessellation so that
   * they follow the curvature of the earth (otherwise, they may go underground
   * and be hidden). Boolean value. Specifies whether to allow the LinearRing to
   * follow the terrain. To enable tessellation, the value for
   * &lt;altitudeMode&gt; must be clampToGround or clampToSeaFloor. Very large
   * LinearRings should enable tessellation so that they follow the curvature of
   * the earth (otherwise, they may go underground and be hidden). Boolean
   * value. Specifies whether to allow the Polygon to follow the terrain. To
   * enable tessellation, the Polygon must have an altitude mode of
   * clampToGround or clampToSeaFloor. Very large Polygons should enable
   * tessellation so that they follow the curvature of the earth (otherwise,
   * they may go underground and be hidden).
   */
  @XmlElement(defaultValue = "0")
  @XmlJavaTypeAdapter(BooleanConverter.class)
  protected Boolean tessellate;
  /**
   * AltitudeMode
   * <p>
   * clampToGround, relativeToGround, absolute See Also: See &lt;LookAt&gt; and
   * &lt;Region&gt;
   * <p>
   */
  @XmlElement(defaultValue = "clampToGround")
  protected AltitudeMode altitudeMode;
  /**
   * &lt;coordinates&gt; (required)
   * <p>
   * A single tuple consisting of floating point values for longitude, latitude,
   * and altitude (in that order). Longitude and latitude values are in degrees,
   * where longitude ≥ −180 and &lt;= 180 latitude ≥ −90 and ≤ 90 altitude
   * values (optional) are in meters above sea level Do not include spaces
   * between the three values that describe a coordinate. &lt;/ p &gt; T wo or
   * more coordinate tuples, each consisting of floating point values for
   * longitude, latitude, and altitude. The altitude component is optional. I n
   * sert a space between tuples. Do not include spaces within a tuple.
   */

  @XmlElement(namespace = "http://www.opengis.net/kml/2.2", type = String.class)
  @XmlJavaTypeAdapter(CoordinatesConverter.class)
  protected List<Coordinate> coordinates;
  @XmlElement(name = "LinearRingSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> linearRingSimpleExtension;
  /**
   * &lt;Object&gt;
   * <p>
   * This is an abstract base class and cannot be used directly in a KML file.
   * It provides the id attribute, which allows unique identification of a KML
   * element, and the targetId attribute, which is used to reference objects
   * that have already been loaded into Google Earth. The id attribute must be
   * assigned if the &lt;Update&gt; mechanism is to be used. Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt; &lt;strong&gt;
   * &lt;!--  &lt;em&gt;Object &lt;/em&gt; id="ID" targetId="NCName" --&gt;
   * &lt;!-- / &lt;em&gt;Object &lt;/em&gt;&gt; --&gt; &lt;/strong&gt; </pre>
   * <p>
   */
  @XmlElement(name = "LinearRingObjectExtensionGroup")
  protected List<AbstractObject> linearRingObjectExtension;

  public LinearRing() {
    super();
  }

  public static LinearRing getInstance(com.vividsolutions.jts.geom.LinearRing linearRing) {
    LinearRing lr = new LinearRing();
    for (com.vividsolutions.jts.geom.Coordinate coordinate : linearRing.getCoordinates()) {
      lr.getCoordinates().add(new Coordinate(coordinate.x, coordinate.y));
    }
    return lr;
  }

  public static LinearRing getInstance(com.vividsolutions.jts.geom.LineString lineString) {
    LinearRing lr = new LinearRing();
    for (com.vividsolutions.jts.geom.Coordinate coordinate : lineString.getCoordinates()) {
      lr.getCoordinates().add(new Coordinate(coordinate.x, coordinate.y));
    }
    return lr;
  }

  /**
   * @return possible object is {@code Boolean}
   *
   */
  public Boolean isExtrude() {
    return extrude;
  }

  /**
   * @see extrude
   *
   * @param value allowed object is {@code Boolean}
   *
   */
  public void setExtrude(Boolean value) {
    this.extrude = value;
  }

  /**
   * @return possible object is {@code Boolean}
   *
   */
  public Boolean isTessellate() {
    return tessellate;
  }

  /**
   * @see tessellate
   *
   * @param value allowed object is {@code Boolean}
   *
   */
  public void setTessellate(Boolean value) {
    this.tessellate = value;
  }

  /**
   * @see altitudeMode
   *
   * @return possible object is null null null null null null null null null   {@code Object}
     *     {@code net.opengis.kml.AltitudeMode}
   *     {@code de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}
   *
   */
  public AltitudeMode getAltitudeMode() {
    return altitudeMode;
  }

  /**
   * @see altitudeMode
   *
   * @param value allowed object is null null null null null null null null null   {@code Object}
     *     {@code net.opengis.kml.AltitudeMode}
   *     {@code de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}
   *
   */
  public void setAltitudeMode(AltitudeMode value) {
    this.altitudeMode = value;
  }

  /**
   * @see linearRingSimpleExtension
   *
   */
  public List<Object> getLinearRingSimpleExtension() {
    if (linearRingSimpleExtension == null) {
      linearRingSimpleExtension = new ArrayList<>();
    }
    return this.linearRingSimpleExtension;
  }

  /**
   * @see linearRingObjectExtension
   *
   */
  public List<AbstractObject> getLinearRingObjectExtension() {
    if (linearRingObjectExtension == null) {
      linearRingObjectExtension = new ArrayList<>();
    }
    return this.linearRingObjectExtension;
  }

  /**
   * @see coordinates
   *
   */
  public List<Coordinate> getCoordinates() {
    if (coordinates == null) {
      coordinates = new ArrayList<>();
    }
    return coordinates;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((extrude == null) ? 0 : extrude.hashCode()));
    result = ((prime * result) + ((tessellate == null) ? 0 : tessellate.hashCode()));
    result = ((prime * result) + ((altitudeMode == null) ? 0 : altitudeMode.hashCode()));
    result = ((prime * result) + ((coordinates == null) ? 0 : coordinates.hashCode()));
    result = ((prime * result) + ((linearRingSimpleExtension == null) ? 0 : linearRingSimpleExtension.hashCode()));
    result = ((prime * result) + ((linearRingObjectExtension == null) ? 0 : linearRingObjectExtension.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (super.equals(obj) == false) {
      return false;
    }
    if ((obj instanceof LinearRing) == false) {
      return false;
    }
    LinearRing other = ((LinearRing) obj);
    if (extrude == null) {
      if (other.extrude != null) {
        return false;
      }
    } else if (extrude.equals(other.extrude) == false) {
      return false;
    }
    if (tessellate == null) {
      if (other.tessellate != null) {
        return false;
      }
    } else if (tessellate.equals(other.tessellate) == false) {
      return false;
    }
    if (altitudeMode == null) {
      if (other.altitudeMode != null) {
        return false;
      }
    } else if (altitudeMode.equals(other.altitudeMode) == false) {
      return false;
    }
    if (coordinates == null) {
      if (other.coordinates != null) {
        return false;
      }
    } else if (coordinates.equals(other.coordinates) == false) {
      return false;
    }
    if (linearRingSimpleExtension == null) {
      if (other.linearRingSimpleExtension != null) {
        return false;
      }
    } else if (linearRingSimpleExtension.equals(other.linearRingSimpleExtension) == false) {
      return false;
    }
    if (linearRingObjectExtension == null) {
      if (other.linearRingObjectExtension != null) {
        return false;
      }
    } else if (linearRingObjectExtension.equals(other.linearRingObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see coordinates
   *
   * @param coordinates
   */
  public void setCoordinates(final List<Coordinate> coordinates) {
    this.coordinates = coordinates;
  }

  /**
   * add a value to the coordinates property collection
   *
   * @param longitude required parameter
   * @param latitude  required parameter
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LinearRing addToCoordinates(final double longitude, final double latitude) {
    this.getCoordinates().add(new Coordinate(longitude, latitude));
    return this;
  }

  /**
   * add a value to the coordinates property collection
   *
   * @param longitude required parameter
   * @param latitude  required parameter
   * @param altitude  required parameter
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LinearRing addToCoordinates(final double longitude, final double latitude, final double altitude) {
    this.getCoordinates().add(new Coordinate(longitude, latitude, altitude));
    return this;
  }

  /**
   * add a value to the coordinates property collection
   *
   * @param coordinates required parameter
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LinearRing addToCoordinates(final String coordinates) {
    this.getCoordinates().add(new Coordinate(coordinates));
    return this;
  }

  /**
   * @see linearRingSimpleExtension
   *
   * @param linearRingSimpleExtension
   */
  public void setLinearRingSimpleExtension(final List<Object> linearRingSimpleExtension) {
    this.linearRingSimpleExtension = linearRingSimpleExtension;
  }

  /**
   * add a value to the linearRingSimpleExtension property collection
   *
   * @param linearRingSimpleExtension Objects of the following type are allowed
   *                                  in the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LinearRing addToLinearRingSimpleExtension(final Object linearRingSimpleExtension) {
    this.getLinearRingSimpleExtension().add(linearRingSimpleExtension);
    return this;
  }

  /**
   * @see linearRingObjectExtension
   *
   * @param linearRingObjectExtension
   */
  public void setLinearRingObjectExtension(final List<AbstractObject> linearRingObjectExtension) {
    this.linearRingObjectExtension = linearRingObjectExtension;
  }

  /**
   * add a value to the linearRingObjectExtension property collection
   *
   * @param linearRingObjectExtension Objects of the following type are allowed
   *                                  in the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LinearRing addToLinearRingObjectExtension(final AbstractObject linearRingObjectExtension) {
    this.getLinearRingObjectExtension().add(linearRingObjectExtension);
    return this;
  }

  /**
   * @see objectSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.setObjectSimpleExtension(objectSimpleExtension);
  }

  @Obvious
  @Override
  public LinearRing addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * @see geometrySimpleExtension
   *
   */
  @Obvious
  @Override
  public void setGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
    super.setGeometrySimpleExtension(geometrySimpleExtension);
  }

  @Obvious
  @Override
  public LinearRing addToGeometrySimpleExtension(final Object geometrySimpleExtension) {
    super.getGeometrySimpleExtension().add(geometrySimpleExtension);
    return this;
  }

  /**
   * @see geometryObjectExtension
   *
   */
  @Obvious
  @Override
  public void setGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
    super.setGeometryObjectExtension(geometryObjectExtension);
  }

  @Obvious
  @Override
  public LinearRing addToGeometryObjectExtension(final AbstractObject geometryObjectExtension) {
    super.getGeometryObjectExtension().add(geometryObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setExtrude(Boolean)
   *
   * @param extrude required parameter
   */
  public LinearRing withExtrude(final Boolean extrude) {
    this.setExtrude(extrude);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTessellate(Boolean)
   *
   * @param tessellate required parameter
   */
  public LinearRing withTessellate(final Boolean tessellate) {
    this.setTessellate(tessellate);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAltitudeMode(Object)
   *
   * @param altitudeMode required parameter
   */
  public LinearRing withAltitudeMode(final AltitudeMode altitudeMode) {
    this.setAltitudeMode(altitudeMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setCoordinates(List &lt;Coordinate&gt;)
   *
   * @param coordinates required parameter
   */
  public LinearRing withCoordinates(final List<Coordinate> coordinates) {
    this.setCoordinates(coordinates);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLinearRingSimpleExtension(List &lt;Object&gt;)
   *
   * @param linearRingSimpleExtension required parameter
   */
  public LinearRing withLinearRingSimpleExtension(final List<Object> linearRingSimpleExtension) {
    this.setLinearRingSimpleExtension(linearRingSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLinearRingObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param linearRingObjectExtension required parameter
   */
  public LinearRing withLinearRingObjectExtension(final List<AbstractObject> linearRingObjectExtension) {
    this.setLinearRingObjectExtension(linearRingObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public LinearRing withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public LinearRing withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public LinearRing withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public LinearRing withGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
    super.withGeometrySimpleExtension(geometrySimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public LinearRing withGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
    super.withGeometryObjectExtension(geometryObjectExtension);
    return this;
  }

  /**
   * Creates a new instance of {@code List}{@code Coordinate} and set it to
   * this.coordinates.
   * <p>
   * This method is a short version for:
   * <pre>
   *  &lt;code&gt;
   * List &lt;Coordinate&gt; newValue = new List &lt;Coordinate&gt;();
   * this.setCoordinates(newValue);  &lt;/code&gt;
   * </pre>
   */
  public List<Coordinate> createAndSetCoordinates() {
    List<Coordinate> newValue = new ArrayList<>();
    this.setCoordinates(newValue);
    return newValue;
  }

  @Override
  public LinearRing clone() {
    LinearRing copy;
    copy = ((LinearRing) super.clone());
    copy.coordinates = new ArrayList<>((getCoordinates().size()));
    for (Coordinate iter : coordinates) {
      copy.coordinates.add(iter.clone());
    }
    copy.linearRingSimpleExtension = new ArrayList<>((getLinearRingSimpleExtension().size()));
    for (Object iter : linearRingSimpleExtension) {
      copy.linearRingSimpleExtension.add(iter);
    }
    copy.linearRingObjectExtension = new ArrayList<>((getLinearRingObjectExtension().size()));
    for (AbstractObject iter : linearRingObjectExtension) {
      copy.linearRingObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
