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
 * &lt;TimeStamp&gt;
 * <p>
 * Represents a single moment in time. This is a simple element and contains no
 * children. Its value is a dateTime, specified in XML time (see XML Schema Part
 * 2: Datatypes Second Edition). The precision of the TimeStamp is dictated by
 * the dateTime value in the &lt;when&gt; element. Syntax: &lt;pre&gt;
 * &lt;strong&gt;&lt;TimeStamp id=ID&gt; &lt;/strong&gt;
 * &lt;when&gt;...&lt;/when&gt; &lt;!-- kml:dateTime --&gt;
 * &lt;strong&gt;&lt;/TimeStamp&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;TimePrimitive&gt;
 *
 * Contained By:
 * @see: &lt;Feature&gt;
 * @see: A copy of the &lt;TimeSpan&gt; and &lt;TimeStamp&gt; elements, in the
 * extension namespace. This allows for the inclusion of time values in
 * AbstractViews ( &lt;Camera&gt; and &lt;LookAt&gt;). Time values are used to
 * control historical imagery, sunlight, and visibility of time-stamped
 * Features.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeStampType", propOrder = {
  "when",
  "timeStampSimpleExtension",
  "timeStampObjectExtension"
})
@XmlRootElement(name = "TimeStamp", namespace = "http://www.opengis.net/kml/2.2")
public class TimeStamp
  extends TimePrimitive
  implements Cloneable {

  /**
   * &lt;when&gt;
   * <p>
   * Specifies a single moment in time. The value is a dateTime, which can be
   * one of the following: dateTime gives second resolution date gives day
   * resolution gYearMonth gives month resolution gYear gives year resolution
   */
  protected String when;
  @XmlElement(name = "TimeStampSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> timeStampSimpleExtension;
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
  @XmlElement(name = "TimeStampObjectExtensionGroup")
  protected List<AbstractObject> timeStampObjectExtension;

  public TimeStamp() {
    super();
  }

  /**
   * @see when
   *
   * @return possible object is {@code String}
   *
   */
  public String getWhen() {
    return when;
  }

  /**
   * @see when
   *
   * @param value allowed object is {@code String}
   *
   */
  public void setWhen(String value) {
    this.when = value;
  }

  /**
   * @see timeStampSimpleExtension
   *
   */
  public List<Object> getTimeStampSimpleExtension() {
    if (timeStampSimpleExtension == null) {
      timeStampSimpleExtension = new ArrayList<>();
    }
    return this.timeStampSimpleExtension;
  }

  /**
   * @see timeStampObjectExtension
   *
   */
  public List<AbstractObject> getTimeStampObjectExtension() {
    if (timeStampObjectExtension == null) {
      timeStampObjectExtension = new ArrayList<>();
    }
    return this.timeStampObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((when == null) ? 0 : when.hashCode()));
    result = ((prime * result) + ((timeStampSimpleExtension == null) ? 0 : timeStampSimpleExtension.hashCode()));
    result = ((prime * result) + ((timeStampObjectExtension == null) ? 0 : timeStampObjectExtension.hashCode()));
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
    if ((obj instanceof TimeStamp) == false) {
      return false;
    }
    TimeStamp other = ((TimeStamp) obj);
    if (when == null) {
      if (other.when != null) {
        return false;
      }
    } else if (when.equals(other.when) == false) {
      return false;
    }
    if (timeStampSimpleExtension == null) {
      if (other.timeStampSimpleExtension != null) {
        return false;
      }
    } else if (timeStampSimpleExtension.equals(other.timeStampSimpleExtension) == false) {
      return false;
    }
    if (timeStampObjectExtension == null) {
      if (other.timeStampObjectExtension != null) {
        return false;
      }
    } else if (timeStampObjectExtension.equals(other.timeStampObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see timeStampSimpleExtension
   *
   * @param timeStampSimpleExtension
   */
  public void setTimeStampSimpleExtension(final List<Object> timeStampSimpleExtension) {
    this.timeStampSimpleExtension = timeStampSimpleExtension;
  }

  /**
   * add a value to the timeStampSimpleExtension property collection
   *
   * @param timeStampSimpleExtension Objects of the following type are allowed
   *                                 in the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public TimeStamp addToTimeStampSimpleExtension(final Object timeStampSimpleExtension) {
    this.getTimeStampSimpleExtension().add(timeStampSimpleExtension);
    return this;
  }

  /**
   * @see timeStampObjectExtension
   *
   * @param timeStampObjectExtension
   */
  public void setTimeStampObjectExtension(final List<AbstractObject> timeStampObjectExtension) {
    this.timeStampObjectExtension = timeStampObjectExtension;
  }

  /**
   * add a value to the timeStampObjectExtension property collection
   *
   * @param timeStampObjectExtension Objects of the following type are allowed
   *                                 in the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public TimeStamp addToTimeStampObjectExtension(final AbstractObject timeStampObjectExtension) {
    this.getTimeStampObjectExtension().add(timeStampObjectExtension);
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
  public TimeStamp addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * @see timePrimitiveSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setTimePrimitiveSimpleExtension(final List<Object> timePrimitiveSimpleExtension) {
    super.setTimePrimitiveSimpleExtension(timePrimitiveSimpleExtension);
  }

  @Obvious
  @Override
  public TimeStamp addToTimePrimitiveSimpleExtension(final Object timePrimitiveSimpleExtension) {
    super.getTimePrimitiveSimpleExtension().add(timePrimitiveSimpleExtension);
    return this;
  }

  /**
   * @see timePrimitiveObjectExtension
   *
   */
  @Obvious
  @Override
  public void setTimePrimitiveObjectExtension(final List<AbstractObject> timePrimitiveObjectExtension) {
    super.setTimePrimitiveObjectExtension(timePrimitiveObjectExtension);
  }

  @Obvious
  @Override
  public TimeStamp addToTimePrimitiveObjectExtension(final AbstractObject timePrimitiveObjectExtension) {
    super.getTimePrimitiveObjectExtension().add(timePrimitiveObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setWhen(String)
   *
   * @param when required parameter
   */
  public TimeStamp withWhen(final String when) {
    this.setWhen(when);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTimeStampSimpleExtension(List &lt;Object&gt;)
   *
   * @param timeStampSimpleExtension required parameter
   */
  public TimeStamp withTimeStampSimpleExtension(final List<Object> timeStampSimpleExtension) {
    this.setTimeStampSimpleExtension(timeStampSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTimeStampObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param timeStampObjectExtension required parameter
   */
  public TimeStamp withTimeStampObjectExtension(final List<AbstractObject> timeStampObjectExtension) {
    this.setTimeStampObjectExtension(timeStampObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public TimeStamp withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public TimeStamp withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public TimeStamp withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public TimeStamp withTimePrimitiveSimpleExtension(final List<Object> timePrimitiveSimpleExtension) {
    super.withTimePrimitiveSimpleExtension(timePrimitiveSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public TimeStamp withTimePrimitiveObjectExtension(final List<AbstractObject> timePrimitiveObjectExtension) {
    super.withTimePrimitiveObjectExtension(timePrimitiveObjectExtension);
    return this;
  }

  @Override
  public TimeStamp clone() {
    TimeStamp copy;
    copy = ((TimeStamp) super.clone());
    copy.timeStampSimpleExtension = new ArrayList<>((getTimeStampSimpleExtension().size()));
    for (Object iter : timeStampSimpleExtension) {
      copy.timeStampSimpleExtension.add(iter);
    }
    copy.timeStampObjectExtension = new ArrayList<>((getTimeStampObjectExtension().size()));
    for (AbstractObject iter : timeStampObjectExtension) {
      copy.timeStampObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
