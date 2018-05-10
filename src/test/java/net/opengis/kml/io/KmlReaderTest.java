/*
 * Copyright 2018 Key Bridge. All rights reserved. Use is subject to license
 * terms.
 *
 * This software code is protected by Copyrights and remains the property of
 * Key Bridge and its suppliers, if any. Key Bridge reserves all rights in and to
 * Copyrights and no license is granted under Copyrights in this Software
 * License Agreement.
 *
 * Key Bridge generally licenses Copyrights for commercialization pursuant to
 * the terms of either a Standard Software Source Code License Agreement or a
 * Standard Product License Agreement. A copy of either Agreement can be
 * obtained upon request by sending an email to info@keybridgewireless.com.
 *
 * All information contained herein is the property of Key Bridge and its
 * suppliers, if any. The intellectual and technical concepts contained herein
 * are proprietary.
 */
package net.opengis.kml.io;

import ch.keybridge.lib.gis.dto.GISFeatureCollection;
import java.io.File;
import java.net.URL;
import net.opengis.kml.Kml;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Key Bridge
 */
public class KmlReaderTest {

  private KmlReader reader;

  public KmlReaderTest() {
  }

  @Before
  public void setUp() {
    this.reader = new KmlReader();

  }

  @Test
  public void testUnmarshal() throws Exception {
//    URL uri = getClass().getClassLoader().getResource("exampledata/ntia/Portal_DPAs.kml"); // collection of GISFeature
    URL uri = getClass().getClassLoader().getResource("exampledata/worldBorders.kml"); // collection of GISFeature
    Kml kml = Kml.unmarshal(new File(uri.toURI()));

    GISFeatureCollection fc = reader.read(kml);

    System.out.println("GISFeatureCollection " + fc.getName() + " size " + fc.getFeatures().size());
//    System.out.println(JaxbUtility.marshal(fc));
    Assert.assertEquals(244, fc.getFeatures().size());
    System.out.println("KmlReaderTest success");

  }

}
