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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import net.opengis.kml.Kml;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

/**
 *
 * @author Key Bridge LLC
 */
public class KMLShapeWriterTest {

  public KMLShapeWriterTest() {
  }

//  @Test
  public void testSomeMethod() throws IOException, ParseException {
    WKTReader reader = new WKTReader();
    Geometry geometry = reader.read("POLYGON((0 0, 10 20, 20 0, 0 0))");

//    String kml = KmlShapeWriter.write(geometry);
//    System.out.println("KML");
//    System.out.println(kml);
  }

  @Test
  public void testF() throws IOException, ParseException, JAXBException {
    KmlShape shape = buildShape();

    Kml kml = KmlShapeWriter.write(shape);
    System.out.println("GIS Feature");
    System.out.println(kml);

//    kml.marshal();
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    kml.marshal(os);
    System.out.println("OS: " + os.toString());

  }

  @Test
  public void testFC() throws IOException, ParseException, JAXBException {
    List<KmlShape> shapes = buildShapes();

    Kml kml = KmlShapeWriter.write(shapes);
    System.out.println("GIS FeatureCollection");
    System.out.println(kml);
  }

  private KmlShape buildShape() throws ParseException {
    String polyWKT = "POLYGON((-118.16327459206458 32.53051522923972,-118.16327459206458 33.715278650109425,-116.03675535110257 33.715278650109425,-116.03675535110257 32.53051522923972,-118.16327459206458 32.53051522923972))";
    WKTReader wktReader = new WKTReader();

    return buildShape("shape name", wktReader.read(polyWKT));

  }

  private List<KmlShape> buildShapes() throws ParseException {
    WKTReader wktReader = new WKTReader();
    GeometryFactory gf = new GeometryFactory();
    String polyWKT = "POLYGON((-118.16327459206458 32.53051522923972,-118.16327459206458 33.715278650109425,-116.03675535110257 33.715278650109425,-116.03675535110257 32.53051522923972,-118.16327459206458 32.53051522923972))";
    List<KmlShape> shapes = new ArrayList<>();

    shapes.add(buildShape("shape-1", wktReader.read(polyWKT)));

    shapes.add(buildShape("shape-2", gf.createPoint(new Coordinate(-124, 52))));
    shapes.add(buildShape("shape-3", gf.createPoint(new Coordinate(-124, 52)).buffer(5)));

    return shapes;
  }

  private KmlShape buildShape(String name, Geometry geometry) {
    KmlShape shape = new KmlShape();
    shape.setName(name);
    shape.setShape(geometry);
    return shape;
  }

}
