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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import net.opengis.kml.gx.*;

/**
 * &lt;Object&gt;
 * <p>
 * This is an abstract base class and cannot be used directly in a KML file. It
 * provides the id attribute, which allows unique identification of a KML
 * element, and the targetId attribute, which is used to reference objects that
 * have already been loaded into Google Earth. The id attribute must be assigned
 * if the &lt;Update&gt; mechanism is to be used. Syntax:
 * <pre>&lt;!-- abstract element; do not create --&gt; &lt;strong&gt;
 * &lt;!--  &lt;em&gt;Object &lt;/em&gt; id="ID" targetId="NCName" --&gt;
 * &lt;!-- / &lt;em&gt;Object &lt;/em&gt;&gt; --&gt; &lt;/strong&gt; </pre>
 * <p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractObjectType", propOrder = {
  "objectSimpleExtension"
})
@XmlSeeAlso({
  Playlist.class,
  SimpleArrayData.class,
  ViewerOptions.class,
  TourPrimitive.class,
  LatLonQuad.class,
  Region.class,
  TimePrimitive.class,
  ItemIcon.class,
  Scale.class,
  Pair.class,
  ViewVolume.class,
  Alias.class,
  Location.class,
  Lod.class,
  ResourceMap.class,
  ImagePyramid.class,
  SchemaData.class,
  Orientation.class,
  Feature.class,
  StyleSelector.class,
  AbstractView.class,
  SubStyle.class,
  Data.class,
  Geometry.class,
  AbstractLatLonBox.class,
  BasicLink.class
})
public abstract class AbstractObject implements Cloneable {

  @XmlElement(name = "ObjectSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> objectSimpleExtension;
  @XmlAttribute(name = "id")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlID
  @XmlSchemaType(name = "ID")
  protected String id;
  @XmlAttribute(name = "targetId")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "NCName")
  protected String targetId;

  public AbstractObject() {
    super();
  }

  /**
   * @see objectSimpleExtension
   *
   */
  public List<Object> getObjectSimpleExtension() {
    if (objectSimpleExtension == null) {
      objectSimpleExtension = new ArrayList<>();
    }
    return this.objectSimpleExtension;
  }

  /**
   * @see id
   *
   * @return possible object is {@link String}
   *
   */
  public String getId() {
    return id;
  }

  /**
   * @see id
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setId(String value) {
    this.id = value;
  }

  /**
   * @see targetId
   *
   * @return possible object is {@link String}
   *
   */
  public String getTargetId() {
    return targetId;
  }

  /**
   * @see targetId
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setTargetId(String value) {
    this.targetId = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((objectSimpleExtension == null) ? 0 : objectSimpleExtension.hashCode()));
    result = ((prime * result) + ((id == null) ? 0 : id.hashCode()));
    result = ((prime * result) + ((targetId == null) ? 0 : targetId.hashCode()));
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
    if ((obj instanceof AbstractObject) == false) {
      return false;
    }
    AbstractObject other = ((AbstractObject) obj);
    if (objectSimpleExtension == null) {
      if (other.objectSimpleExtension != null) {
        return false;
      }
    } else if (objectSimpleExtension.equals(other.objectSimpleExtension) == false) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (id.equals(other.id) == false) {
      return false;
    }
    if (targetId == null) {
      if (other.targetId != null) {
        return false;
      }
    } else if (targetId.equals(other.targetId) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see objectSimpleExtension
   *
   * @param objectSimpleExtension
   */
  public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    this.objectSimpleExtension = objectSimpleExtension;
  }

  /**
   * add a value to the objectSimpleExtension property collection
   *
   * @param objectSimpleExtension Objects of the following type are allowed in
   *                              the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public AbstractObject addToObjectSimpleExtension(final Object objectSimpleExtension) {
    this.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setObjectSimpleExtension(List &lt;Object&gt;)
   *
   * @param objectSimpleExtension required parameter
   */
  public AbstractObject withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    this.setObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setId(String)
   *
   * @param id required parameter
   */
  public AbstractObject withId(final String id) {
    this.setId(id);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTargetId(String)
   *
   * @param targetId required parameter
   */
  public AbstractObject withTargetId(final String targetId) {
    this.setTargetId(targetId);
    return this;
  }

  @Override
  public AbstractObject clone() {
    AbstractObject copy;
    try {
      copy = ((AbstractObject) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.objectSimpleExtension = new ArrayList<>((getObjectSimpleExtension().size()));
    for (Object iter : objectSimpleExtension) {
      copy.objectSimpleExtension.add(iter);
    }
    return copy;
  }

}
