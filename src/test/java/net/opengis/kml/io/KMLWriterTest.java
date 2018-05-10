/*
 * Copyright 2017 Key Bridge. All rights reserved.
 * Use is subject to license terms.
 *
 * Software Code is protected by Copyrights. Author hereby reserves all rights
 * in and to Copyrights and no license is granted under Copyrights in this
 * Software License Agreement.
 *
 * Key Bridge generally licenses Copyrights for commercialization pursuant to
 * the terms of either a Standard Software Source Code License Agreement or a
 * Standard Product License Agreement. A copy of either Agreement can be
 * obtained upon request from: info@keybridgewireless.com
 */
package net.opengis.kml.io;

import ch.keybridge.lib.gis.dto.GISFeature;
import ch.keybridge.lib.gis.dto.GISFeatureCollection;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import java.io.IOException;
import java.util.Arrays;
import javax.xml.bind.JAXBException;
import net.opengis.kml.Kml;
import org.junit.Test;

/**
 *
 * @author Key Bridge LLC
 */
public class KMLWriterTest {

  public KMLWriterTest() {
  }

//  @Test
  public void testSomeMethod() throws IOException, ParseException {
    WKTReader reader = new WKTReader();
    Geometry geometry = reader.read("POLYGON((0 0, 10 20, 20 0, 0 0))");

//    String kml = KmlWriter.write(geometry);
//    System.out.println("KML");
//    System.out.println(kml);
  }

  @Test
  public void testF() throws IOException, ParseException, JAXBException {
    GISFeature feature = buildGISFeature();

    String kml = KmlWriter.toText(feature);
    System.out.println("GIS Feature");
    System.out.println(kml);
  }

  @Test
  public void testFC() throws IOException, ParseException, JAXBException {
    GISFeatureCollection featureCollection = buildFeatureCollection();

    Kml kml = KmlWriter.write(featureCollection);
    System.out.println("GIS FeatureCollection");
    System.out.println(kml);
  }

  private GISFeature buildGISFeature() throws ParseException {
    String polyWKT = "POLYGON((-118.16327459206458 32.53051522923972,-118.16327459206458 33.715278650109425,-116.03675535110257 33.715278650109425,-116.03675535110257 32.53051522923972,-118.16327459206458 32.53051522923972))";
    WKTReader wktReader = new WKTReader();
    return GISFeature.getInstance("GISFeature-name", wktReader.read(polyWKT));
  }

  private GISFeatureCollection buildFeatureCollection() throws ParseException {
    WKTReader wktReader = new WKTReader();
    GeometryFactory gf = new GeometryFactory();
    String polyWKT = "POLYGON((-118.16327459206458 32.53051522923972,-118.16327459206458 33.715278650109425,-116.03675535110257 33.715278650109425,-116.03675535110257 32.53051522923972,-118.16327459206458 32.53051522923972))";

    GISFeature feature1 = GISFeature.getInstance("GISFeature-1", wktReader.read(polyWKT));

    GISFeature feature2 = GISFeature.getInstance("GISFeature-2", gf.createPoint(new Coordinate(-124, 52)));

    GISFeature feature3 = GISFeature.getInstance("GISFeature-3", gf.createPoint(new Coordinate(-124, 52)).buffer(5));

    GISFeatureCollection featureCollection = GISFeatureCollection.getInstance("fc",
                                                                              "collection",
                                                                              "fc-name",
                                                                              Arrays.asList(feature1, feature2, feature3));
    return featureCollection;
  }

}
