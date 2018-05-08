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
import net.opengis.kml.annotations.Obvious;
import net.opengis.kml.gx.MultiTrack;
import net.opengis.kml.gx.Track;

/**
 *  &lt;MultiGeometry&gt;
 *   
 * A container for zero or more geometry primitives associated with the same
 * feature. Note: The  &lt;GeometryCollection&gt; tag has been deprecated. Use
 *  &lt;MultiGeometry&gt;
 * instead. Syntax:
 *  &lt;pre&gt; &lt;strong&gt;&lt;MultiGeometry id="ID"&gt; &lt;/strong&gt;
 *   &lt;!-- specific to MultiGeometry --&gt;
 *   &lt;!-- 0 or more  &lt;em&gt;Geometry &lt;/em&gt; elements --&gt;
 *  &lt;strong&gt;&lt;/MultiGeometry&gt; &lt;/strong&gt; </pre>
 *   
 * Extends:
 *
 * @see:  &lt;Geometry&gt;
 *
 * Contained By:
 * @see:  &lt;MultiGeometry&gt;
 * @see:  &lt;Placemark&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiGeometryType", propOrder = {
  "geometry",
  "multiGeometrySimpleExtension",
  "multiGeometryObjectExtension"
})
@XmlRootElement(name = "MultiGeometry", namespace = "http://www.opengis.net/kml/2.2")
public class MultiGeometry extends Geometry implements Cloneable {

  /**
   *  &lt;Geometry&gt;
   *   
   * This is an abstract element and cannot be used directly in a KML file. It
   * provides a placeholder object for all derived Geometry objects. Syntax:
   *  <pre>&lt;!-- abstract element; do not create --&gt;
   *  &lt;strong&gt;&lt;! &lt;em&gt;-- Geometry &lt;/em&gt; id="ID" --&gt;                 &lt;!-- Point,LineString,LinearRing,
   *                                                Polygon,MultiGeometry,Model --&gt; &lt;/strong&gt;
   *  &lt;strong&gt;&lt;!-- / &lt;em&gt;Geometry -- &lt;/em&gt;&gt; &lt;/strong&gt; </pre>
   *   
   * Extends:
   *
   * @see:  &lt;Object&gt;
   *
   * Extended By:
   * @see:  &lt;LineString&gt;
   * @see:  &lt;LinearRing&gt;
   * @see:  &lt;Model&gt;
   * @see:  &lt;Point&gt;
   * @see: MultiGeometry
   * @see: Polygon
   *
   */
  @XmlElementRef(name = "AbstractGeometryGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected List<Geometry> geometry;
  @XmlElement(name = "MultiGeometrySimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> multiGeometrySimpleExtension;
  /**
   *  &lt;Object&gt;
   *   
   * This is an abstract base class and cannot be used directly in a KML file.
   * It provides the id attribute, which allows unique identification of a KML
   * element, and the targetId attribute, which is used to reference objects
   * that have already been loaded into Google Earth. The id attribute must be
   * assigned if the  &lt;Update&gt; mechanism is to be used. Syntax:
   *  <pre>&lt;!-- abstract element; do not create --&gt; &lt;strong&gt;
   * &lt;!--  &lt;em&gt;Object &lt;/em&gt; id="ID" targetId="NCName" --&gt;
   * &lt;!-- / &lt;em&gt;Object &lt;/em&gt;&gt; --&gt; &lt;/strong&gt; </pre>
   *   
   */
  @XmlElement(name = "MultiGeometryObjectExtensionGroup")
  protected List<AbstractObject> multiGeometryObjectExtension;

  public MultiGeometry() {
    super();
  }

  /**
   * @see geometry
   *
   */
  public List<Geometry> getGeometry() {
    if (geometry == null) {
      geometry = new ArrayList<>();
    }
    return this.geometry;
  }

  /**
   * @see multiGeometrySimpleExtension
   *
   */
  public List<Object> getMultiGeometrySimpleExtension() {
    if (multiGeometrySimpleExtension == null) {
      multiGeometrySimpleExtension = new ArrayList<>();
    }
    return this.multiGeometrySimpleExtension;
  }

  /**
   * @see multiGeometryObjectExtension
   *
   */
  public List<AbstractObject> getMultiGeometryObjectExtension() {
    if (multiGeometryObjectExtension == null) {
      multiGeometryObjectExtension = new ArrayList<>();
    }
    return this.multiGeometryObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((geometry == null) ? 0 : geometry.hashCode()));
    result = ((prime * result) + ((multiGeometrySimpleExtension == null) ? 0 : multiGeometrySimpleExtension.hashCode()));
    result = ((prime * result) + ((multiGeometryObjectExtension == null) ? 0 : multiGeometryObjectExtension.hashCode()));
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
    if ((obj instanceof MultiGeometry) == false) {
      return false;
    }
    MultiGeometry other = ((MultiGeometry) obj);
    if (geometry == null) {
      if (other.geometry != null) {
        return false;
      }
    } else if (geometry.equals(other.geometry) == false) {
      return false;
    }
    if (multiGeometrySimpleExtension == null) {
      if (other.multiGeometrySimpleExtension != null) {
        return false;
      }
    } else if (multiGeometrySimpleExtension.equals(other.multiGeometrySimpleExtension) == false) {
      return false;
    }
    if (multiGeometryObjectExtension == null) {
      if (other.multiGeometryObjectExtension != null) {
        return false;
      }
    } else if (multiGeometryObjectExtension.equals(other.multiGeometryObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link MultiTrack} and adds it to geometry. This
   * method is a short version for:     &lt;code&gt;
   * MultiTrack multiTrack = new MultiTrack();
   * this.getGeometry().add(multiTrack);  &lt;/code&gt;
   */
  public MultiTrack createAndAddMultiTrack() {
    MultiTrack newValue = new MultiTrack();
    this.getGeometry().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Track} and adds it to geometry. This
   * method is a short version for:     &lt;code&gt;
   * Track track = new Track();
   * this.getGeometry().add(track);  &lt;/code&gt;
   */
  public Track createAndAddTrack() {
    Track newValue = new Track();
    this.getGeometry().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link LinearRing} and adds it to geometry. This
   * method is a short version for:     &lt;code&gt;
   * LinearRing linearRing = new LinearRing();
   * this.getGeometry().add(linearRing);  &lt;/code&gt;
   */
  public LinearRing createAndAddLinearRing() {
    LinearRing newValue = new LinearRing();
    this.getGeometry().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Point} and adds it to geometry. This
   * method is a short version for:     &lt;code&gt;
   * Point point = new Point();
   * this.getGeometry().add(point);  &lt;/code&gt;
   */
  public Point createAndAddPoint() {
    Point newValue = new Point();
    this.getGeometry().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Model} and adds it to geometry. This
   * method is a short version for:     &lt;code&gt;
   * Model model = new Model();
   * this.getGeometry().add(model);  &lt;/code&gt;
   */
  public Model createAndAddModel() {
    Model newValue = new Model();
    this.getGeometry().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link MultiGeometry} and adds it to geometry.
   * This method is a short version for:     &lt;code&gt;
   * MultiGeometry multiGeometry = new MultiGeometry();
   * this.getGeometry().add(multiGeometry);  &lt;/code&gt;
   */
  public MultiGeometry createAndAddMultiGeometry() {
    MultiGeometry newValue = new MultiGeometry();
    this.getGeometry().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link LineString} and adds it to geometry. This
   * method is a short version for:     &lt;code&gt;
   * LineString lineString = new LineString();
   * this.getGeometry().add(lineString);  &lt;/code&gt;
   */
  public LineString createAndAddLineString() {
    LineString newValue = new LineString();
    this.getGeometry().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Polygon} and adds it to geometry. This
   * method is a short version for:     &lt;code&gt;
   * Polygon polygon = new Polygon();
   * this.getGeometry().add(polygon);  &lt;/code&gt;
   */
  public Polygon createAndAddPolygon() {
    Polygon newValue = new Polygon();
    this.getGeometry().add(newValue);
    return newValue;
  }

  /**
   * @see geometry
   *
   * @param geometry
   */
  public void setGeometry(final List<Geometry> geometry) {
    this.geometry = geometry;
  }

  /**
   * add a value to the geometry property collection
   *
   * @param geometry Objects of the following type are allowed in the list:
   *                 {@link Geometry}{@link JAXBElement}{@link Point}{@link JAXBElement}{@link LinearRing}{@link JAXBElement}{@link Polygon}{@link JAXBElement}{@link Track}{@link JAXBElement}{@link MultiTrack}{@link JAXBElement}{@link Model}{@link JAXBElement}{@link LineString}{@link JAXBElement}{@link MultiGeometry}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public MultiGeometry addToGeometry(final Geometry geometry) {
    this.getGeometry().add(geometry);
    return this;
  }

  /**
   * @see multiGeometrySimpleExtension
   *
   * @param multiGeometrySimpleExtension
   */
  public void setMultiGeometrySimpleExtension(final List<Object> multiGeometrySimpleExtension) {
    this.multiGeometrySimpleExtension = multiGeometrySimpleExtension;
  }

  /**
   * add a value to the multiGeometrySimpleExtension property collection
   *
   * @param multiGeometrySimpleExtension Objects of the following type are
   *                                     allowed in the list: {@link Object}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public MultiGeometry addToMultiGeometrySimpleExtension(final Object multiGeometrySimpleExtension) {
    this.getMultiGeometrySimpleExtension().add(multiGeometrySimpleExtension);
    return this;
  }

  /**
   * @see multiGeometryObjectExtension
   *
   * @param multiGeometryObjectExtension
   */
  public void setMultiGeometryObjectExtension(final List<AbstractObject> multiGeometryObjectExtension) {
    this.multiGeometryObjectExtension = multiGeometryObjectExtension;
  }

  /**
   * add a value to the multiGeometryObjectExtension property collection
   *
   * @param multiGeometryObjectExtension Objects of the following type are
   *                                     allowed in the list:
   *                                     {@link AbstractObject}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public MultiGeometry addToMultiGeometryObjectExtension(final AbstractObject multiGeometryObjectExtension) {
    this.getMultiGeometryObjectExtension().add(multiGeometryObjectExtension);
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
  public MultiGeometry addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public MultiGeometry addToGeometrySimpleExtension(final Object geometrySimpleExtension) {
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
  public MultiGeometry addToGeometryObjectExtension(final AbstractObject geometryObjectExtension) {
    super.getGeometryObjectExtension().add(geometryObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setGeometry(List &lt;Geometry&gt;)
   *
   * @param geometry required parameter
   */
  public MultiGeometry withGeometry(final List<Geometry> geometry) {
    this.setGeometry(geometry);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setMultiGeometrySimpleExtension(List &lt;Object&gt;)
   *
   * @param multiGeometrySimpleExtension required parameter
   */
  public MultiGeometry withMultiGeometrySimpleExtension(final List<Object> multiGeometrySimpleExtension) {
    this.setMultiGeometrySimpleExtension(multiGeometrySimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setMultiGeometryObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param multiGeometryObjectExtension required parameter
   */
  public MultiGeometry withMultiGeometryObjectExtension(final List<AbstractObject> multiGeometryObjectExtension) {
    this.setMultiGeometryObjectExtension(multiGeometryObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public MultiGeometry withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public MultiGeometry withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public MultiGeometry withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public MultiGeometry withGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
    super.withGeometrySimpleExtension(geometrySimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public MultiGeometry withGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
    super.withGeometryObjectExtension(geometryObjectExtension);
    return this;
  }

  @Override
  public MultiGeometry clone() {
    MultiGeometry copy;
    copy = ((MultiGeometry) super.clone());
    copy.geometry = new ArrayList<>((getGeometry().size()));
    for (Geometry iter : geometry) {
      copy.geometry.add(iter.clone());
    }
    copy.multiGeometrySimpleExtension = new ArrayList<>((getMultiGeometrySimpleExtension().size()));
    for (Object iter : multiGeometrySimpleExtension) {
      copy.multiGeometrySimpleExtension.add(iter);
    }
    copy.multiGeometryObjectExtension = new ArrayList<>((getMultiGeometryObjectExtension().size()));
    for (AbstractObject iter : multiGeometryObjectExtension) {
      copy.multiGeometryObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
