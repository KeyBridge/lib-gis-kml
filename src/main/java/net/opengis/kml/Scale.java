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
 * &lt;scale&gt;
 * <p>
 * Note: The &lt;geomScale&gt; tag has been deprecated. Use &lt;scale&gt;
 * instead. Resizes the icon. Scales a model along the x, y, and z axes in the
 * model's coordinate space. &lt;Scale&gt; &lt;x&gt;2.5 &lt;/x&gt; &lt;y&gt;2.5
 * &lt;/y&gt; &lt;z&gt;3.5 &lt;/z&gt; &lt;/Scale&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScaleType", propOrder = {
  "x",
  "y",
  "z",
  "scaleSimpleExtension",
  "scaleObjectExtension"
})
@XmlRootElement(name = "Scale", namespace = "http://www.opengis.net/kml/2.2")
public class Scale
  extends AbstractObject
  implements Cloneable {

  /**
   * &lt;x&gt;, &lt;y&gt;, &lt;w&gt;, &lt;h&gt;
   * <p>
   * Use of these elements within &lt;Icon&gt; has been deprecated.
   */
  @XmlElement(defaultValue = "1.0")
  protected double x;
  @XmlElement(defaultValue = "1.0")
  protected double y;
  @XmlElement(defaultValue = "1.0")
  protected double z;
  @XmlElement(name = "ScaleSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> scaleSimpleExtension;
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
  @XmlElement(name = "ScaleObjectExtensionGroup")
  protected List<AbstractObject> scaleObjectExtension;

  public Scale() {
    super();
  }

  /**
   * @see x
   *
   * @return possible object is {@link Double}
   *
   */
  public double getX() {
    return x;
  }

  /**
   * @see x
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setX(double value) {
    this.x = value;
  }

  /**
   * @see y
   *
   * @return possible object is {@link Double}
   *
   */
  public double getY() {
    return y;
  }

  /**
   * @see y
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setY(double value) {
    this.y = value;
  }

  /**
   * @see z
   *
   * @return possible object is {@link Double}
   *
   */
  public double getZ() {
    return z;
  }

  /**
   * @see z
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setZ(double value) {
    this.z = value;
  }

  /**
   * @see scaleSimpleExtension
   *
   */
  public List<Object> getScaleSimpleExtension() {
    if (scaleSimpleExtension == null) {
      scaleSimpleExtension = new ArrayList<>();
    }
    return this.scaleSimpleExtension;
  }

  /**
   * @see scaleObjectExtension
   *
   */
  public List<AbstractObject> getScaleObjectExtension() {
    if (scaleObjectExtension == null) {
      scaleObjectExtension = new ArrayList<>();
    }
    return this.scaleObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(x);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(y);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(z);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((scaleSimpleExtension == null) ? 0 : scaleSimpleExtension.hashCode()));
    result = ((prime * result) + ((scaleObjectExtension == null) ? 0 : scaleObjectExtension.hashCode()));
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
    if ((obj instanceof Scale) == false) {
      return false;
    }
    Scale other = ((Scale) obj);
    if (x != other.x) {
      return false;
    }
    if (y != other.y) {
      return false;
    }
    if (z != other.z) {
      return false;
    }
    if (scaleSimpleExtension == null) {
      if (other.scaleSimpleExtension != null) {
        return false;
      }
    } else if (scaleSimpleExtension.equals(other.scaleSimpleExtension) == false) {
      return false;
    }
    if (scaleObjectExtension == null) {
      if (other.scaleObjectExtension != null) {
        return false;
      }
    } else if (scaleObjectExtension.equals(other.scaleObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see scaleSimpleExtension
   *
   * @param scaleSimpleExtension
   */
  public void setScaleSimpleExtension(final List<Object> scaleSimpleExtension) {
    this.scaleSimpleExtension = scaleSimpleExtension;
  }

  /**
   * add a value to the scaleSimpleExtension property collection
   *
   * @param scaleSimpleExtension Objects of the following type are allowed in
   *                             the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Scale addToScaleSimpleExtension(final Object scaleSimpleExtension) {
    this.getScaleSimpleExtension().add(scaleSimpleExtension);
    return this;
  }

  /**
   * @see scaleObjectExtension
   *
   * @param scaleObjectExtension
   */
  public void setScaleObjectExtension(final List<AbstractObject> scaleObjectExtension) {
    this.scaleObjectExtension = scaleObjectExtension;
  }

  /**
   * add a value to the scaleObjectExtension property collection
   *
   * @param scaleObjectExtension Objects of the following type are allowed in
   *                             the list: {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Scale addToScaleObjectExtension(final AbstractObject scaleObjectExtension) {
    this.getScaleObjectExtension().add(scaleObjectExtension);
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
  public Scale addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setX(double)
   *
   * @param x required parameter
   */
  public Scale withX(final double x) {
    this.setX(x);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setY(double)
   *
   * @param y required parameter
   */
  public Scale withY(final double y) {
    this.setY(y);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setZ(double)
   *
   * @param z required parameter
   */
  public Scale withZ(final double z) {
    this.setZ(z);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setScaleSimpleExtension(List &lt;Object&gt;)
   *
   * @param scaleSimpleExtension required parameter
   */
  public Scale withScaleSimpleExtension(final List<Object> scaleSimpleExtension) {
    this.setScaleSimpleExtension(scaleSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setScaleObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param scaleObjectExtension required parameter
   */
  public Scale withScaleObjectExtension(final List<AbstractObject> scaleObjectExtension) {
    this.setScaleObjectExtension(scaleObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Scale withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Scale withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Scale withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public Scale clone() {
    Scale copy;
    copy = ((Scale) super.clone());
    copy.scaleSimpleExtension = new ArrayList<>((getScaleSimpleExtension().size()));
    for (Object iter : scaleSimpleExtension) {
      copy.scaleSimpleExtension.add(iter);
    }
    copy.scaleObjectExtension = new ArrayList<>((getScaleObjectExtension().size()));
    for (AbstractObject iter : scaleObjectExtension) {
      copy.scaleObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
