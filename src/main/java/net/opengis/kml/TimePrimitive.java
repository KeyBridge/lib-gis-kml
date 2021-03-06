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

/**
 * &lt;TimePrimitive&gt;
 * <p>
 * Associates this Feature with a period of time ( &lt;TimeSpan&gt;) or a point
 * in time ( &lt;TimeStamp&gt;). This is an abstract element and cannot be used
 * directly in a KML file. This element is extended by the &lt;TimeSpan&gt; and
 * &lt;TimeStamp&gt; elements. Syntax:
 * <pre>&lt;!-- abstract element; do not create --&gt;
 *  &lt;strong&gt;&lt;!-- TimePrimitive id="ID" --&gt;            &lt;!-- TimeSpan,TimeStamp --&gt;
 *   &lt;/strong&gt; &lt;!-- extends Object --&gt; &lt;strong&gt;
 * &lt;!-- /TimePrimitive --&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Object&gt;
 *
 * Extended By:
 * @see: &lt;TimeSpan&gt;
 * @see: &lt;TimeStamp&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractTimePrimitiveType", propOrder = {
  "timePrimitiveSimpleExtension",
  "timePrimitiveObjectExtension"
})
@XmlSeeAlso({
  TimeSpan.class,
  TimeStamp.class
})
public abstract class TimePrimitive
  extends AbstractObject
  implements Cloneable {

  @XmlElement(name = "AbstractTimePrimitiveSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> timePrimitiveSimpleExtension;
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
  @XmlElement(name = "AbstractTimePrimitiveObjectExtensionGroup")
  protected List<AbstractObject> timePrimitiveObjectExtension;

  public TimePrimitive() {
    super();
  }

  /**
   * @see timePrimitiveSimpleExtension
   *
   */
  public List<Object> getTimePrimitiveSimpleExtension() {
    if (timePrimitiveSimpleExtension == null) {
      timePrimitiveSimpleExtension = new ArrayList<>();
    }
    return this.timePrimitiveSimpleExtension;
  }

  /**
   * @see timePrimitiveObjectExtension
   *
   */
  public List<AbstractObject> getTimePrimitiveObjectExtension() {
    if (timePrimitiveObjectExtension == null) {
      timePrimitiveObjectExtension = new ArrayList<>();
    }
    return this.timePrimitiveObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((timePrimitiveSimpleExtension == null) ? 0 : timePrimitiveSimpleExtension.hashCode()));
    result = ((prime * result) + ((timePrimitiveObjectExtension == null) ? 0 : timePrimitiveObjectExtension.hashCode()));
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
    if ((obj instanceof TimePrimitive) == false) {
      return false;
    }
    TimePrimitive other = ((TimePrimitive) obj);
    if (timePrimitiveSimpleExtension == null) {
      if (other.timePrimitiveSimpleExtension != null) {
        return false;
      }
    } else if (timePrimitiveSimpleExtension.equals(other.timePrimitiveSimpleExtension) == false) {
      return false;
    }
    if (timePrimitiveObjectExtension == null) {
      if (other.timePrimitiveObjectExtension != null) {
        return false;
      }
    } else if (timePrimitiveObjectExtension.equals(other.timePrimitiveObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see timePrimitiveSimpleExtension
   *
   * @param timePrimitiveSimpleExtension
   */
  public void setTimePrimitiveSimpleExtension(final List<Object> timePrimitiveSimpleExtension) {
    this.timePrimitiveSimpleExtension = timePrimitiveSimpleExtension;
  }

  /**
   * add a value to the timePrimitiveSimpleExtension property collection
   *
   * @param timePrimitiveSimpleExtension Objects of the following type are
   *                                     allowed in the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public TimePrimitive addToTimePrimitiveSimpleExtension(final Object timePrimitiveSimpleExtension) {
    this.getTimePrimitiveSimpleExtension().add(timePrimitiveSimpleExtension);
    return this;
  }

  /**
   * @see timePrimitiveObjectExtension
   *
   * @param timePrimitiveObjectExtension
   */
  public void setTimePrimitiveObjectExtension(final List<AbstractObject> timePrimitiveObjectExtension) {
    this.timePrimitiveObjectExtension = timePrimitiveObjectExtension;
  }

  /**
   * add a value to the timePrimitiveObjectExtension property collection
   *
   * @param timePrimitiveObjectExtension Objects of the following type are
   *                                     allowed in the list:
   *                                     {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public TimePrimitive addToTimePrimitiveObjectExtension(final AbstractObject timePrimitiveObjectExtension) {
    this.getTimePrimitiveObjectExtension().add(timePrimitiveObjectExtension);
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
  public TimePrimitive addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTimePrimitiveSimpleExtension(List &lt;Object&gt;)
   *
   * @param timePrimitiveSimpleExtension required parameter
   */
  public TimePrimitive withTimePrimitiveSimpleExtension(final List<Object> timePrimitiveSimpleExtension) {
    this.setTimePrimitiveSimpleExtension(timePrimitiveSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTimePrimitiveObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param timePrimitiveObjectExtension required parameter
   */
  public TimePrimitive withTimePrimitiveObjectExtension(final List<AbstractObject> timePrimitiveObjectExtension) {
    this.setTimePrimitiveObjectExtension(timePrimitiveObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public TimePrimitive withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public TimePrimitive withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public TimePrimitive withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public TimePrimitive clone() {
    TimePrimitive copy;
    copy = ((TimePrimitive) super.clone());
    copy.timePrimitiveSimpleExtension = new ArrayList<>((getTimePrimitiveSimpleExtension().size()));
    for (Object iter : timePrimitiveSimpleExtension) {
      copy.timePrimitiveSimpleExtension.add(iter);
    }
    copy.timePrimitiveObjectExtension = new ArrayList<>((getTimePrimitiveObjectExtension().size()));
    for (AbstractObject iter : timePrimitiveObjectExtension) {
      copy.timePrimitiveObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
