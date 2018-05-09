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
 * &lt;orientation&gt;
 * <p>
 * Describes rotation of a 3D model's coordinate system to position the object
 * in Google Earth. See diagram below. &lt;Orientation&gt; &lt;heading&gt;45.0
 * &lt;/heading&gt; &lt;tilt&gt;10.0 &lt;/tilt&gt; &lt;roll&gt;0.0 &lt;/roll&gt;
 * &lt;/Orientation&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrientationType", propOrder = {
  "heading",
  "tilt",
  "roll",
  "orientationSimpleExtension",
  "orientationObjectExtension"
})
@XmlRootElement(name = "Orientation", namespace = "http://www.opengis.net/kml/2.2")
public class Orientation
  extends AbstractObject
  implements Cloneable {

  /**
   * &lt;heading&gt;
   * <p>
   * Direction (azimuth) of the camera, in degrees. Default=0 (true North). (See
   * diagram.) Values range from 0 to 360 degrees. Direction (that is, North,
   * South, East, West), in degrees. Default=0 (North). (See diagram below.)
   * Values range from 0 to 360 degrees. Direction (that is, North, South, East,
   * West), in degrees. Default=0 (North). (See diagram.) Values range from 0 to
   * 360 degrees. Rotation about the z axis (normal to the Earth's surface). A
   * value of 0 (the default) equals North. A positive rotation is clockwise
   * around the z axis and specified in degrees from 0 to 360.
   */
  @XmlElement(defaultValue = "0.0")
  protected double heading;
  /**
   * &lt;tilt&gt;
   * <p>
   * Angle between the direction of the LookAt position and the normal to the
   * surface of the earth. (See diagram below.) Values range from 0 to 90
   * degrees. Values for &lt;tilt&gt; cannot be negative. A &lt;tilt&gt; value
   * of 0 degrees indicates viewing from directly above. A &lt;tilt&gt; value of
   * 90 degrees indicates viewing along the horizon. Rotation about the x axis.
   * A positive rotation is clockwise around the x axis and specified in degrees
   * from 0 to 360. Rotation, in degrees, of the camera around the X axis. A
   * value of 0 indicates that the view is aimed straight down toward the earth
   * (the most common case). A value for 90 for &lt;tilt&gt; indicates that the
   * view is aimed toward the horizon. Values greater than 90 indicate that the
   * view is pointed up into the sky. Values for &lt;tilt&gt; are clamped at
   * +180 degrees.
   */
  @XmlElement(defaultValue = "0.0")
  protected double tilt;
  /**
   * &lt;roll&gt;
   * <p>
   * &lt;heading&gt; Rotation about the z axis (normal to the Earth's surface).
   * A value of 0 (the default) equals North. A positive rotation is clockwise
   * around the z axis and specified in degrees from 0 to 360. &lt;tilt&gt;
   * Rotation about the x axis. A positive rotation is clockwise around the x
   * axis and specified in degrees from 0 to 360. &lt;roll&gt; Rotation about
   * the y axis. A positive rotation is clockwise around the y axis and
   * specified in degrees from 0 to 360. This diagram illustrates the typical
   * orientation of a model's axes: Rotation about the y axis. A positive
   * rotation is clockwise around the y axis and specified in degrees from 0 to
   * 360. Rotation, in degrees, of the camera around the Z axis. Values range
   * from −180 to +180 degrees. This diagram illustrates the typical orientation
   * of a model's axes:
   */
  @XmlElement(defaultValue = "0.0")
  protected double roll;
  @XmlElement(name = "OrientationSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> orientationSimpleExtension;
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
  @XmlElement(name = "OrientationObjectExtensionGroup")
  protected List<AbstractObject> orientationObjectExtension;

  public Orientation() {
    super();
  }

  /**
   * @see heading
   *
   * @return possible object is {@code Double}
   *
   */
  public double getHeading() {
    return heading;
  }

  /**
   * @see heading
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setHeading(double value) {
    this.heading = value;
  }

  /**
   * @see tilt
   *
   * @return possible object is {@code Double}
   *
   */
  public double getTilt() {
    return tilt;
  }

  /**
   * @see tilt
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setTilt(double value) {
    this.tilt = value;
  }

  /**
   * @see roll
   *
   * @return possible object is {@code Double}
   *
   */
  public double getRoll() {
    return roll;
  }

  /**
   * @see roll
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setRoll(double value) {
    this.roll = value;
  }

  /**
   * @see orientationSimpleExtension
   *
   */
  public List<Object> getOrientationSimpleExtension() {
    if (orientationSimpleExtension == null) {
      orientationSimpleExtension = new ArrayList<>();
    }
    return this.orientationSimpleExtension;
  }

  /**
   * @see orientationObjectExtension
   *
   */
  public List<AbstractObject> getOrientationObjectExtension() {
    if (orientationObjectExtension == null) {
      orientationObjectExtension = new ArrayList<>();
    }
    return this.orientationObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(heading);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(tilt);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(roll);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((orientationSimpleExtension == null) ? 0 : orientationSimpleExtension.hashCode()));
    result = ((prime * result) + ((orientationObjectExtension == null) ? 0 : orientationObjectExtension.hashCode()));
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
    if ((obj instanceof Orientation) == false) {
      return false;
    }
    Orientation other = ((Orientation) obj);
    if (heading != other.heading) {
      return false;
    }
    if (tilt != other.tilt) {
      return false;
    }
    if (roll != other.roll) {
      return false;
    }
    if (orientationSimpleExtension == null) {
      if (other.orientationSimpleExtension != null) {
        return false;
      }
    } else if (orientationSimpleExtension.equals(other.orientationSimpleExtension) == false) {
      return false;
    }
    if (orientationObjectExtension == null) {
      if (other.orientationObjectExtension != null) {
        return false;
      }
    } else if (orientationObjectExtension.equals(other.orientationObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see orientationSimpleExtension
   *
   * @param orientationSimpleExtension
   */
  public void setOrientationSimpleExtension(final List<Object> orientationSimpleExtension) {
    this.orientationSimpleExtension = orientationSimpleExtension;
  }

  /**
   * add a value to the orientationSimpleExtension property collection
   *
   * @param orientationSimpleExtension Objects of the following type are allowed
   *                                   in the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Orientation addToOrientationSimpleExtension(final Object orientationSimpleExtension) {
    this.getOrientationSimpleExtension().add(orientationSimpleExtension);
    return this;
  }

  /**
   * @see orientationObjectExtension
   *
   * @param orientationObjectExtension
   */
  public void setOrientationObjectExtension(final List<AbstractObject> orientationObjectExtension) {
    this.orientationObjectExtension = orientationObjectExtension;
  }

  /**
   * add a value to the orientationObjectExtension property collection
   *
   * @param orientationObjectExtension Objects of the following type are allowed
   *                                   in the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Orientation addToOrientationObjectExtension(final AbstractObject orientationObjectExtension) {
    this.getOrientationObjectExtension().add(orientationObjectExtension);
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
  public Orientation addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setHeading(double)
   *
   * @param heading required parameter
   */
  public Orientation withHeading(final double heading) {
    this.setHeading(heading);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTilt(double)
   *
   * @param tilt required parameter
   */
  public Orientation withTilt(final double tilt) {
    this.setTilt(tilt);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setRoll(double)
   *
   * @param roll required parameter
   */
  public Orientation withRoll(final double roll) {
    this.setRoll(roll);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setOrientationSimpleExtension(List &lt;Object&gt;)
   *
   * @param orientationSimpleExtension required parameter
   */
  public Orientation withOrientationSimpleExtension(final List<Object> orientationSimpleExtension) {
    this.setOrientationSimpleExtension(orientationSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setOrientationObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param orientationObjectExtension required parameter
   */
  public Orientation withOrientationObjectExtension(final List<AbstractObject> orientationObjectExtension) {
    this.setOrientationObjectExtension(orientationObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Orientation withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Orientation withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Orientation withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public Orientation clone() {
    Orientation copy;
    copy = ((Orientation) super.clone());
    copy.orientationSimpleExtension = new ArrayList<>((getOrientationSimpleExtension().size()));
    for (Object iter : orientationSimpleExtension) {
      copy.orientationSimpleExtension.add(iter);
    }
    copy.orientationObjectExtension = new ArrayList<>((getOrientationObjectExtension().size()));
    for (AbstractObject iter : orientationObjectExtension) {
      copy.orientationObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
