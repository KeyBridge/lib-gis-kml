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
package ch.keybridge.lib.kml;

/**
 *
 * @author Key Bridge LLC
 */
public class KMLWriterTest {

//  public KMLWriterTest() {
//  }
//
////  @Test
//  public void testSomeMethod() throws IOException, ParseException {
//    WKTReader reader = new WKTReader();
//    Geometry geometry = reader.read("POLYGON((0 0, 10 20, 20 0, 0 0))");
//
//    String kml = KMLWriter.write(geometry);
//
//    System.out.println("KML");
//    System.out.println(kml);
//
//  }
//
//  @Test
//  public void testFC() throws IOException, ParseException {
//    DefaultFeatureCollection featureCollection = new DefaultFeatureCollection("defaultID");
//    featureCollection.add(buildSimpleFeature1());
//
//    String kml = KMLWriter.write(featureCollection);
//    System.out.println("FeatureCollection");
//    System.out.println(kml);
//
//  }
//
//  private SimpleFeature buildSimpleFeature1() throws IOException, ParseException {
//    SimpleFeatureTypeBuilder b = new SimpleFeatureTypeBuilder();
////set the name
//    b.setName("property");
//
////add some properties
//    b.add("name", String.class);
//    b.add("classification", Integer.class);
//    b.add("height", Double.class);
//    //set the coordinate reference system
//    b.setCRS(DefaultGeographicCRS.WGS84);
//
//    //add some geometry properties (first added is the default)
//    b.add("geometry", Polygon.class);
//
//    //set the default geometry
////    b.setDefaultGeometry("region");
//    SimpleFeatureType featureType = b.buildFeatureType();
//    SimpleFeatureBuilder builder = new SimpleFeatureBuilder(featureType);
//    builder.add("contour1");
//    builder.add(200);
//    builder.add(300.55);
//
//    String polyWKT = "POLYGON((-118.16327459206458 32.53051522923972,-118.16327459206458 33.715278650109425,-116.03675535110257 33.715278650109425,-116.03675535110257 32.53051522923972,-118.16327459206458 32.53051522923972))";
//    WKTReader wktReader = new WKTReader();
//    builder.add(wktReader.read(polyWKT));
//
//    SimpleFeature feature = builder.buildFeature("id1");
//
//    return feature;
//
//  }
}
