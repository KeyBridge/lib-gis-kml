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

import org.locationtech.jts.geom.Geometry;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A simple, generic Shape container. This is used when manually extracting
 * records from a database with shape information.
 *
 * @author Key Bridge
 * @since v5.0.0 gis-boundary-entity created 10/12/19 to support reading generic
 * shape records from a database table.
 * @since v0.1.0 copied to cbrs boundary
 */
public class KmlShape implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * The GDAL/OGR feature ID.
   * <p>
   * This is automatically created when the shape file is extracted as assigned
   * as a unique key.
   * <p>
   * OGR originally abbreviated "OpenGIS Simple Features Reference
   * Implementation". However OGR is not fully compliant with the OpenGIS Simple
   * Feature specification and the name was subsequently changed to "OGR Simple
   * Features Library". "OGR" as a name prefix is a historical artifact.
   */
  private Long id;
  /**
   * The shape name. This is typically a place mark name.
   */
  private String name;
  /**
   * The placemark ID.
   */
  private String placemarkId;
  /**
   * The shape description. This is typically a place mark name.
   */
  private String description;
  /**
   * The geographic representation of the feature.
   * <p>
   * Expect POLYGON.
   */
  private Geometry shape;
  /**
   * The shape metadata properties.
   */
  private Map<String, String> properties;

  public KmlShape() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPlacemarkId() {
    return placemarkId;
  }

  public void setPlacemarkId(String placemarkId) {
    this.placemarkId = placemarkId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Geometry getShape() {
    return shape;
  }

  public void setShape(Geometry shape) {
    this.shape = shape;
  }

  public Map<String, String> getProperties() {
    if (properties == null) {
      properties = new HashMap<>();
    }
    return properties;
  }

  public String getProperty(String key) {
    return getProperties().get(key);
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

  public void setProperty(String key, String property) {
    getProperties().put(key, property);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 19 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final KmlShape other = (KmlShape) obj;
    return Objects.equals(this.id, other.id);
  }

  @Override
  public String toString() {
    return "Shape{" + "ogrFid=" + id + '}';
  }

}
