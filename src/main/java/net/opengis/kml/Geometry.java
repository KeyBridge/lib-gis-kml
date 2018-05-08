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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import net.opengis.kml.annotations.Obvious;
import net.opengis.kml.gx.MultiTrack;
import net.opengis.kml.gx.Track;

/**
 * Geometry
 * <p>
 * This is an abstract element and cannot be used directly in a KML file. It
 * provides a placeholder object for all derived Geometry objects.
 * <p>
 * Syntax:
 * <pre>&lt;!-- abstract element; do not create --&gt;
 *  &lt;strong&gt;&lt;! &lt;em&gt;-- Geometry &lt;/em&gt; id="ID" --&gt;                 &lt;!-- Point,LineString,LinearRing,
 *                                                Polygon,MultiGeometry,Model --&gt; &lt;/strong&gt;
 *  &lt;strong&gt;&lt;!-- / &lt;em&gt;Geometry -- &lt;/em&gt;&gt; &lt;/strong&gt;
 * </pre>
 * <p>
 * Extends:
 *
 * @see: Object
 *
 * Extended By:
 * @see: LineString
 * @see: LinearRing
 * @see: Model
 * @see: Point
 * @see: MultiGeometry
 * @see: Polygon
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractGeometryType", propOrder = {
  "geometrySimpleExtension",
  "geometryObjectExtension"
})
@XmlSeeAlso({
  LinearRing.class,
  LineString.class,
  Model.class,
  MultiGeometry.class,
  MultiTrack.class,
  Point.class,
  Polygon.class,
  Track.class
})
public abstract class Geometry extends AbstractObject implements Cloneable {

  /**
   * This is an abstract base class and cannot be used directly in a KML file.
   * It provides the id attribute, which allows unique identification of a KML
   * element, and the targetId attribute, which is used to reference objects
   * that have already been loaded into Google Earth. The id attribute must be
   * assigned if the &lt;Update&gt; mechanism is to be used.
   * <p>
   * Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt; &lt;strong&gt;
   * &lt;!--  &lt;em&gt;Object &lt;/em&gt; id="ID" targetId="NCName" --&gt;
   * &lt;!-- / &lt;em&gt;Object &lt;/em&gt;&gt; --&gt; &lt;/strong&gt; </pre>
   */
  @XmlElement(name = "AbstractGeometrySimpleExtensionGroup")
  protected List<Object> geometrySimpleExtension;
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
  @XmlElement(name = "AbstractGeometryObjectExtensionGroup")
  protected List<AbstractObject> geometryObjectExtension;

  public Geometry() {
    super();
  }

  public static Geometry getInstance(com.vividsolutions.jts.geom.Geometry jtsGeometry) {
    Geometry geometry = null;

    switch (jtsGeometry.getClass().getSimpleName()) {
      /**
       * A closed line string, typically the outer boundary of a Polygon.
       */
      case "LinearRing": {
        geometry = LinearRing.getInstance((com.vividsolutions.jts.geom.LinearRing) jtsGeometry);
        break;
      }
      /**
       * A connected set of line segments.
       */
      case "LineString": {
        geometry = LineString.getInstance((com.vividsolutions.jts.geom.LineString) jtsGeometry);
        break;
      }
      /**
       * A container for zero or more geometry primitives associated with the
       * same feature.
       */
      case "GeometryCollection": {
        geometry = new MultiGeometry();
        for (int i = 0; i < jtsGeometry.getNumGeometries(); i++) {
          ((MultiGeometry) geometry).getGeometry().add(getInstance(jtsGeometry.getGeometryN(i)));
        }
        break;
      }
      /**
       * A geographic location defined by longitude, latitude, and (optional)
       * altitude.
       */
      case "Point": {
        geometry = Point.getInstance((com.vividsolutions.jts.geom.Point) jtsGeometry);
        break;
      }
      /**
       * A Polygon is defined by an outer boundary and 0 or more inner
       * boundaries. The boundaries, in turn, are defined by LinearRings.
       */
      case "Polygon": {
        geometry = Polygon.getInstance((com.vividsolutions.jts.geom.Polygon) jtsGeometry);
        break;
      }

      default: {
        throw new IllegalArgumentException("Geometry type " + jtsGeometry.getClass().getSimpleName() + " not supported yet.");
      }

    }

    return geometry;

  }

  /**
   * @see geometrySimpleExtension
   *
   */
  public List<Object> getGeometrySimpleExtension() {
    if (geometrySimpleExtension == null) {
      geometrySimpleExtension = new ArrayList<>();
    }
    return this.geometrySimpleExtension;
  }

  /**
   * @see geometryObjectExtension
   *
   */
  public List<AbstractObject> getGeometryObjectExtension() {
    if (geometryObjectExtension == null) {
      geometryObjectExtension = new ArrayList<>();
    }
    return this.geometryObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((geometrySimpleExtension == null) ? 0 : geometrySimpleExtension.hashCode()));
    result = ((prime * result) + ((geometryObjectExtension == null) ? 0 : geometryObjectExtension.hashCode()));
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
    if ((obj instanceof Geometry) == false) {
      return false;
    }
    Geometry other = ((Geometry) obj);
    if (geometrySimpleExtension == null) {
      if (other.geometrySimpleExtension != null) {
        return false;
      }
    } else if (geometrySimpleExtension.equals(other.geometrySimpleExtension) == false) {
      return false;
    }
    if (geometryObjectExtension == null) {
      if (other.geometryObjectExtension != null) {
        return false;
      }
    } else if (geometryObjectExtension.equals(other.geometryObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see geometrySimpleExtension
   *
   * @param geometrySimpleExtension
   */
  public void setGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
    this.geometrySimpleExtension = geometrySimpleExtension;
  }

  /**
   * add a value to the geometrySimpleExtension property collection
   *
   * @param geometrySimpleExtension Objects of the following type are allowed in
   *                                the list:
   *                                {@link Object}{@link JAXBElement}{@link BigInteger}{@link JAXBElement}{@link Double}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Geometry addToGeometrySimpleExtension(final Object geometrySimpleExtension) {
    this.getGeometrySimpleExtension().add(geometrySimpleExtension);
    return this;
  }

  /**
   * @see geometryObjectExtension
   *
   * @param geometryObjectExtension
   */
  public void setGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
    this.geometryObjectExtension = geometryObjectExtension;
  }

  /**
   * add a value to the geometryObjectExtension property collection
   *
   * @param geometryObjectExtension Objects of the following type are allowed in
   *                                the list: {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Geometry addToGeometryObjectExtension(final AbstractObject geometryObjectExtension) {
    this.getGeometryObjectExtension().add(geometryObjectExtension);
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
  public Geometry addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setGeometrySimpleExtension(List &lt;Object&gt;)
   *
   * @param geometrySimpleExtension required parameter
   */
  public Geometry withGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
    this.setGeometrySimpleExtension(geometrySimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setGeometryObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param geometryObjectExtension required parameter
   */
  public Geometry withGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
    this.setGeometryObjectExtension(geometryObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Geometry withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Geometry withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Geometry withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public Geometry clone() {
    Geometry copy;
    copy = ((Geometry) super.clone());
    copy.geometrySimpleExtension = new ArrayList<>((getGeometrySimpleExtension().size()));
    for (Object iter : geometrySimpleExtension) {
      copy.geometrySimpleExtension.add(iter);
    }
    copy.geometryObjectExtension = new ArrayList<>((getGeometryObjectExtension().size()));
    for (AbstractObject iter : geometryObjectExtension) {
      copy.geometryObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
