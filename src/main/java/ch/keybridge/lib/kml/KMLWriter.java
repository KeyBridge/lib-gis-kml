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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ch.keybridge.lib.kml;

import ch.keybridge.lib.gis.dto.GISFeature;
import ch.keybridge.lib.gis.dto.GISFeatureCollection;
import ch.keybridge.lib.xml.JaxbUtility;
import java.io.IOException;
import javax.xml.bind.JAXBException;
import net.opengis.kml.*;

/**
 * Utility class to simplify the writing of KML-formatted objects.
 * <p>
 * @TODO: If possible, this library should be abandoned in favor of the GeoTool
 * XML Encoder utility. Do this as soon as the GeoTools OSGI bug is fixed.
 *
 * @author Key Bridge LLC
 * @since 1.0.0 create 01/16/17 based upon GeoTools, Java API for KML, etc.
 */
public class KMLWriter {

  /**
   * Internal contruction - only.
   */
  private KMLWriter() {
  }

  /**
   * Write the {@code GISFeatureCollection} instance to a KML formatted string.
   *
   * @param featureCollection the GISFeatureCollection instance
   * @return a formatted KML string
   * @throws IOException if the feature collection cannot be unmarshaled to a
   *                     string
   */
  public static String write(GISFeatureCollection featureCollection) throws IOException {
    try {
      return JaxbUtility.marshal(convertFeatureCollection(featureCollection));
    } catch (JAXBException jAXBException) {
      throw new IOException(jAXBException.getMessage());
    }
  }

  /**
   * Write the {@code GISFeature} instance to a KML formatted string.
   *
   * @param feature the GIS Feature instance
   * @return a formatted KML string
   * @throws IOException if the feature cannot be unmarshaled to a string
   */
  public static String write(GISFeature feature) throws IOException {
    try {
      return JaxbUtility.marshal(convertFeature(feature));
    } catch (JAXBException jAXBException) {
      throw new IOException(jAXBException.getMessage());
    }
  }

  /**
   * Convert a Feature to KML
   *
   * @param feature a feature
   * @return a KML object
   */
  private static Kml convertFeature(GISFeature feature) {
    Kml kml = new Kml();
    Document document = new Document();
    document.setName(feature.getName() + ".kml");
    Placemark placemark = new Placemark();
    placemark.setGeometry(Geometry.getInstance((com.vividsolutions.jts.geom.Geometry) feature.getGeometry()));
    placemark.setExtendedData(buildExtendedData(feature));
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
  private static Kml convertFeatureCollection(GISFeatureCollection featureCollection) {
    Kml kml = new Kml();
    Document document = new Document();
    document.setName(featureCollection.getName() + ".kml");

    featureCollection.getFeatures().stream().forEach(feature -> {
      Placemark placemark = new Placemark();
      placemark.setGeometry(Geometry.getInstance((com.vividsolutions.jts.geom.Geometry) feature.getGeometry()));
      placemark.setExtendedData(buildExtendedData(feature));
      /**
       * Add the placemark to the document.
       */
      document.getFeature().add(placemark);
    });

    kml.setFeature(document);
    return kml;
  }

  /**
   * Build an Extended Data object from a GISFeature configuration
   *
   * @param feature the feature
   * @return an extended data container
   */
  private static ExtendedData buildExtendedData(GISFeature feature) {
    ExtendedData extendedData = new ExtendedData();
    if (feature.getId() != null) {
      extendedData.addToData(new Data("id", feature.getId()));
    }
    if (feature.getName() != null) {
      extendedData.addToData(new Data("name", feature.getName()));
    }
    if (feature.getFeatureType() != null) {
      extendedData.addToData(new Data("featureType", feature.getFeatureType()));
    }
    if (feature.isSetAddress()) {
      extendedData.addToData(new Data("address", feature.getAddress().format()));
    }
    feature.getExtensions().entrySet().stream().forEach((entry) -> {
      extendedData.addToData(new Data(entry.getKey(), entry.getValue()));
    });
    return extendedData;
  }

}
