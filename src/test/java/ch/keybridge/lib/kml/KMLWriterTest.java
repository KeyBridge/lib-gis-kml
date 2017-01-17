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
import net.opengis.kml.Polygon;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.junit.Test;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

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

//    String kml = KMLWriter.write(geometry);
//    System.out.println("KML");
//    System.out.println(kml);
  }

  @Test
  public void testF() throws IOException, ParseException, JAXBException {
    GISFeature feature = buildGISFeature();

    String kml = KMLWriter.write(feature);
    System.out.println("GIS Feature");
    System.out.println(kml);
  }

  @Test
  public void testFC() throws IOException, ParseException, JAXBException {
    GISFeatureCollection featureCollection = buildFeatureCollection();

    String kml = KMLWriter.write(featureCollection);
    System.out.println("GIS FeatureCollection");
    System.out.println(kml);
  }

  private GISFeature buildGISFeature() throws ParseException {
    String polyWKT = "POLYGON((-118.16327459206458 32.53051522923972,-118.16327459206458 33.715278650109425,-116.03675535110257 33.715278650109425,-116.03675535110257 32.53051522923972,-118.16327459206458 32.53051522923972))";
    WKTReader wktReader = new WKTReader();
    return new GISFeature("id", "featureType", "GISFeature-name", wktReader.read(polyWKT));
  }

  private GISFeatureCollection buildFeatureCollection() throws ParseException {
    WKTReader wktReader = new WKTReader();
    GeometryFactory gf = new GeometryFactory();
    String polyWKT = "POLYGON((-118.16327459206458 32.53051522923972,-118.16327459206458 33.715278650109425,-116.03675535110257 33.715278650109425,-116.03675535110257 32.53051522923972,-118.16327459206458 32.53051522923972))";

    GISFeature feature1 = new GISFeature("id1", "featureType1", "GISFeature-1", wktReader.read(polyWKT));

    GISFeature feature2 = new GISFeature("id2", "featureType2", "GISFeature-2", gf.createPoint(new Coordinate(-124, 52)));

    GISFeature feature3 = new GISFeature("id3", "featureType3", "GISFeature-3", gf.createPoint(new Coordinate(-124, 52)).buffer(5));

    GISFeatureCollection featureCollection = GISFeatureCollection.getInstance("fc",
                                                                              "collection",
                                                                              "fc-name",
                                                                              Arrays.asList(feature1, feature2, feature3));
    return featureCollection;
  }

  private SimpleFeature buildSimpleFeature1() throws IOException, ParseException {
    SimpleFeatureTypeBuilder b = new SimpleFeatureTypeBuilder();
//set the name
    b.setName("property");

//add some properties
    b.add("name", String.class);
    b.add("classification", Integer.class);
    b.add("height", Double.class);
    //set the coordinate reference system
    b.setCRS(DefaultGeographicCRS.WGS84);

    //add some geometry properties (first added is the default)
    b.add("geometry", Polygon.class);

    //set the default geometry
//    b.setDefaultGeometry("region");
    SimpleFeatureType featureType = b.buildFeatureType();
    SimpleFeatureBuilder builder = new SimpleFeatureBuilder(featureType);
    builder.add("contour1");
    builder.add(200);
    builder.add(300.55);

    String polyWKT = "POLYGON((-118.16327459206458 32.53051522923972,-118.16327459206458 33.715278650109425,-116.03675535110257 33.715278650109425,-116.03675535110257 32.53051522923972,-118.16327459206458 32.53051522923972))";
    WKTReader wktReader = new WKTReader();
    builder.add(wktReader.read(polyWKT));

    SimpleFeature feature = builder.buildFeature("id1");

    return feature;

  }
}
