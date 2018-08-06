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

import ch.keybridge.lib.gis.dto.AbstractGISFeature;
import ch.keybridge.lib.gis.dto.GISFeature;
import ch.keybridge.lib.gis.dto.GISFeatureCollection;
import ch.keybridge.xml.JaxbUtility;
import java.io.IOException;
import java.util.Map;
import javax.xml.bind.JAXBException;
import net.opengis.kml.*;

/**
 * KML writer.
 * <p>
 * This utility reads {@code GISFeature} DTO object instances and returns a KML
 * instance.
 * <p>
 * TODO: If possible, this writer utility should be abandoned in favor of the
 * GeoTool XML Encoder utility. Do this as soon as the GeoTools OSGI bug is
 * fixed.
 *
 * @author Key Bridge LLC
 * @since v1.0.0 create 01/16/17 based upon GeoTools, Java API for KML, etc.
 * @since v1.4.0 rewrite with Folder support; add toText method
 */
public class KmlWriter {

  /**
   * Private constructor. Static methods only.
   */
  private KmlWriter() {
  }

  /**
   * Write the {@code GIS Feature} instance to a KML formatted string.
   *
   * @param feature the GIS Feature instance
   * @return a formatted KML string
   * @throws IOException if the feature collection cannot be unmarshaled to a
   *                     string
   */
  public static String toText(AbstractGISFeature feature) throws IOException {
    try {
      if (feature instanceof GISFeatureCollection) {
        return JaxbUtility.marshal(transformGisFeatureCollection((GISFeatureCollection) feature));
      }
      if (feature instanceof GISFeature) {
        return JaxbUtility.marshal(transformFeature((GISFeature) feature));
      }
    } catch (JAXBException jAXBException) {
      throw new IOException(jAXBException.getMessage());
    }
    throw new IllegalArgumentException("Unsupported feature class: " + feature.getClass().getSimpleName());
  }

  /**
   * Write the {@code GISFeature} instance to a KML formatted string.
   *
   * @param feature the GIS Feature instance
   * @return a formatted KML string
   * @throws IOException if the feature cannot be unmarshaled to a string
   */
  public static Kml write(AbstractGISFeature feature) throws IOException {
    if (feature instanceof GISFeatureCollection) {
      return transformGisFeatureCollection((GISFeatureCollection) feature);
    }
    if (feature instanceof GISFeature) {
      return transformFeature((GISFeature) feature);
    }
    throw new IllegalArgumentException("Unsupported feature class: " + feature.getClass().getSimpleName());
  }

  /**
   * Convert a Feature to KML
   *
   * @param feature a feature
   * @return a KML object
   */
  private static Kml transformFeature(GISFeature feature) {
    Kml kml = new Kml();
    Document document = new Document();
    document.setName(feature.getName() + ".kml");
    document.getStyleSelector().add(generateDefaultStyle());

    /**
     * Transform the feature into a Placemark, then add the Placemark to the
     * document.
     */
    Placemark placemark = transformGisFeature(feature);
    /**
     * Add the placemark to the document and the document to the Kml.
     */
    document.getFeature().add(placemark);
    kml.setFeature(document);
    return kml;
  }

  /**
   * Convert a Feature Collection to KML
   *
   * @param featureCollection a feature collection
   * @return a KML object
   */
  private static Kml transformGisFeatureCollection(GISFeatureCollection featureCollection) {
    Kml kml = new Kml();
    Document document = new Document();
    document.setName(featureCollection.getName() + ".kml");
    document.getStyleSelector().add(generateDefaultStyle());

    Folder folder = new Folder();
    folder.setId(featureCollection.getId());
    folder.setName(featureCollection.getName());
    folder.setDescription(featureCollection.getDescription());
    folder.setExtendedData(transformProperties(featureCollection.getProperties()));
    /**
     * Transform each feature into a Placemark, then add the Placemark to the
     * folder.
     */
    featureCollection.getFeatures().forEach(feature -> {
      Placemark placemark = transformGisFeature(feature);
      folder.getFeature().add(placemark);
    });
    /**
     * Add the folder to the document and the document to the Kml.
     */
    document.getFeature().add(folder);
    kml.setFeature(document);
    return kml;
  }

  /**
   * Transform a GISFeature into a Kml Placemark instance.
   *
   * @param feature a GISFeature
   * @return a Kml Placemark instance.
   */
  private static Placemark transformGisFeature(GISFeature feature) {
    Placemark placemark = new Placemark();
    placemark.setId(feature.getId());
    placemark.setName(feature.getName());
    placemark.setDescription(feature.getDescription());
    placemark.setGeometry(Geometry.getInstance(feature.getShape()));
    placemark.setExtendedData(transformProperties(feature.getProperties()));
    placemark.getExtendedData().addToData(new Data("featureType", feature.getFeatureType()));
    placemark.getExtendedData().addToData(new Data("country", feature.getIso2()));
    if (feature.isSetAddress()) {
      placemark.setAddress(feature.getAddress().format());
    }
    return placemark;
  }

  /**
   * Build an Extended Data object from a GISFeature configuration
   *
   * @param properties the feature properties
   * @return an ExtendedData container
   */
  private static ExtendedData transformProperties(Map<String, String> properties) {
    ExtendedData extendedData = new ExtendedData();
    properties.entrySet().stream()
      .filter((entry) -> (!entry.getKey().equals("description")))
      .forEach((entry) -> {
        extendedData.addToData(new Data(entry.getKey(), entry.getValue()));
      });
    return extendedData;
  }

  /**
   * Generate a default KML style.
   *
   * @return a default KML style.
   */
  private static Style generateDefaultStyle() {
    Style style = new Style();
    /**
     * Instantiate a temporary GISFeature to capture the default properties.
     */
    GISFeature f = new GISFeature();

    LineStyle lineStyle = style.createAndSetLineStyle();
    lineStyle.setColor(f.getStroke() != null ? f.getStroke() : "999999");  // TODO: append opacity
    lineStyle.setWidth(f.getStrokeWidth() != null ? f.getStrokeWidth() : 2.0);

    PolyStyle polyStyle = style.createAndSetPolyStyle();
    polyStyle.setColor(f.getFill() != null ? f.getFill() : "55555"); // TODO: append opacity
    polyStyle.setFill(true);

    return style;
  }

}
