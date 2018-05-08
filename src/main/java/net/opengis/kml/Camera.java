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
 * &lt;Camera&gt;
 * <p>
 * &lt;Camera&gt; can also contain a TimePrimitive ( &lt;gx:TimeSpan&gt; or
 * &lt;gx:TimeStamp&gt;). Time values in Camera affect historical imagery,
 * sunlight, and the display of time-stamped features. For more information,
 * read Time with AbstractViews in the Time and Animation chapter of the
 * Developer's Guide. &lt;Camera&gt; provides full six-degrees-of-freedom
 * control over the view, so you can position the Camera in space and then
 * rotate it around the X, Y, and Z axes. Most importantly, you can tilt the
 * camera view so that you're looking above the horizon into the sky. Defines
 * the virtual camera that views the scene. This element defines the position of
 * the camera relative to the Earth's surface as well as the viewing direction
 * of the camera. The camera position is defined by &lt;longitude&gt;,
 * &lt;latitude&gt;, &lt;altitude&gt;, and either &lt;altitudeMode&gt; or
 * &lt;gx:altitudeMode&gt;. The viewing direction of the camera is defined by
 * &lt;heading&gt;, &lt;tilt&gt;, and &lt;roll&gt;. &lt;Camera&gt; can be a
 * child element of any Feature or of &lt;NetworkLinkControl&gt;. A parent
 * element cannot contain both a &lt;Camera&gt; and a &lt;LookAt&gt; at the same
 * time. Defining a View The X axis points toward the right of the camera and is
 * called the right vector. The Y axis defines the "up" direction relative to
 * the screen and is called the up vector. The Z axis points from the center of
 * the screen toward the eye point. The camera looks down the −Z axis, which is
 * called the view vector. The following diagram shows the X, Y, and Z axes,
 * which are attached to the virtual camera. Within a Feature or
 * &lt;NetworkLinkControl&gt;, use either a &lt;Camera&gt; or a &lt;LookAt&gt;
 * object (but not both in the same object). The &lt;Camera&gt; object defines
 * the viewpoint in terms of the viewer's position and orientation. The
 * &lt;Camera&gt; object allows you to specify a view that is not on the Earth's
 * surface. The &lt;LookAt&gt; object defines the viewpoint in terms of what is
 * being viewed. The &lt;LookAt&gt; object is more limited in scope than
 * &lt;Camera&gt; and generally requires that the view direction intersect the
 * Earth's surface. Syntax: &lt;pre&gt; &lt;strong&gt;&lt;Camera id="ID"&gt;
 * &lt;/strong&gt; &lt;!-- inherited from AbstractView element --&gt;
 * &lt;em&gt;&lt;TimePrimitive&gt;...&lt;/TimePrimitive&gt; &lt;/em&gt; &lt;!--
 * gx:TimeSpan or gx:TimeStamp --&gt;
 * <p>
 * &lt;!-- specific to Camera --&gt; &lt;longitude&gt;0&lt;/longitude&gt;
 * &lt;!-- kml:angle180 --&gt; &lt;latitude&gt;0&lt;/latitude&gt; &lt;!--
 * kml:angle90 --&gt; &lt;altitude&gt;0&lt;/altitude&gt; &lt;!-- double --&gt;
 * &lt;heading&gt;0&lt;/heading&gt; &lt;!-- kml:angle360 --&gt;
 * &lt;tilt&gt;0&lt;/tilt&gt; &lt;!-- kml:anglepos180 --&gt;
 * &lt;roll&gt;0&lt;/roll&gt; &lt;!-- kml:angle180 --&gt;
 * &lt;altitudeMode&gt;clampToGround&lt;/altitudeMode&gt; &lt;!--
 * kml:altitudeModeEnum: relativeToGround, clampToGround, or absolute --&gt;
 * &lt;!-- or, gx:altitudeMode can be substituted: clampToSeaFloor,
 * relativeToSeaFloor --&gt; &lt;strong&gt;&lt;/Camera&gt; &lt;/strong&gt;
 * </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;AbstractView&gt;
 *
 * Contained By:
 * @see: &lt;Feature&gt;
 * @see: &lt;NetworkLinkControl&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CameraType", propOrder = {
  "longitude",
  "latitude",
  "altitude",
  "heading",
  "tilt",
  "roll",
  "altitudeMode",
  "cameraSimpleExtension",
  "cameraObjectExtension"
})
@XmlRootElement(name = "Camera", namespace = "http://www.opengis.net/kml/2.2")
public class Camera
  extends AbstractView
  implements Cloneable {

  /**
   * &lt;longitude&gt;
   * <p>
   * Longitude of the point the camera is looking at. Angular distance in
   * degrees, relative to the Prime Meridian. Values west of the Meridian range
   * from −180 to 0 degrees. Values east of the Meridian range from 0 to 180
   * degrees. Longitude of the virtual camera (eye point). Angular distance in
   * degrees, relative to the Prime Meridian. Values west of the Meridian range
   * from −180 to 0 degrees. Values east of the Meridian range from 0 to 180
   * degrees.
   */
  @XmlElement(defaultValue = "0.0")
  protected double longitude;
  /**
   * &lt;latitude&gt;
   * <p>
   * Latitude of the point the camera is looking at. Degrees north or south of
   * the Equator (0 degrees). Values range from −90 degrees to 90 degrees.
   * Latitude of the virtual camera. Degrees north or south of the Equator (0
   * degrees). Values range from −90 degrees to 90 degrees.
   */
  @XmlElement(defaultValue = "0.0")
  protected double latitude;
  /**
   * &lt;altitude&gt;
   * <p>
   * Distance from the earth's surface, in meters. Interpreted according to the
   * LookAt's altitude mode. Distance of the camera from the earth's surface, in
   * meters. Interpreted according to the Camera's &lt;altitudeMode&gt; or
   * &lt;gx:altitudeMode&gt;. Specifies the distance above the earth's surface,
   * in meters, and is interpreted according to the altitude mode.
   */
  @XmlElement(defaultValue = "0.0")
  protected double altitude;
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
  /**
   * AltitudeMode
   * <p>
   * clampToGround, relativeToGround, absolute See Also: See &lt;LookAt&gt; and
   * &lt;Region&gt;
   * <p>
   */
  @XmlElement(defaultValue = "clampToGround")
  protected AltitudeMode altitudeMode;
  @XmlElement(name = "CameraSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> cameraSimpleExtension;
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
  @XmlElement(name = "CameraObjectExtensionGroup")
  protected List<AbstractObject> cameraObjectExtension;

  public Camera() {
    super();
  }

  /**
   * @see longitude
   *
   * @return possible object is {@link Double}
   *
   */
  public double getLongitude() {
    return longitude;
  }

  /**
   * @see longitude
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setLongitude(double value) {
    this.longitude = value;
  }

  /**
   * @see latitude
   *
   * @return possible object is {@link Double}
   *
   */
  public double getLatitude() {
    return latitude;
  }

  /**
   * @see latitude
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setLatitude(double value) {
    this.latitude = value;
  }

  /**
   * @see altitude
   *
   * @return possible object is {@link Double}
   *
   */
  public double getAltitude() {
    return altitude;
  }

  /**
   * @see altitude
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setAltitude(double value) {
    this.altitude = value;
  }

  /**
   * @see heading
   *
   * @return possible object is {@link Double}
   *
   */
  public double getHeading() {
    return heading;
  }

  /**
   * @see heading
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setHeading(double value) {
    this.heading = value;
  }

  /**
   * @see tilt
   *
   * @return possible object is {@link Double}
   *
   */
  public double getTilt() {
    return tilt;
  }

  /**
   * @see tilt
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setTilt(double value) {
    this.tilt = value;
  }

  /**
   * @see roll
   *
   * @return possible object is {@link Double}
   *
   */
  public double getRoll() {
    return roll;
  }

  /**
   * @see roll
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setRoll(double value) {
    this.roll = value;
  }

  /**
   * @see altitudeMode
   *
   * @return possible object is null null null null null null null null null null   {@link Object}
     *     {@link net.opengis.kml.AltitudeMode}
   *     {@link de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}
   *
   */
  public AltitudeMode getAltitudeMode() {
    return altitudeMode;
  }

  /**
   * @see altitudeMode
   *
   * @param value allowed object is null null null null null null null null null null   {@link Object}
     *     {@link net.opengis.kml.AltitudeMode}
   *     {@link de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}
   *
   */
  public void setAltitudeMode(AltitudeMode value) {
    this.altitudeMode = value;
  }

  /**
   * @see cameraSimpleExtension
   *
   */
  public List<Object> getCameraSimpleExtension() {
    if (cameraSimpleExtension == null) {
      cameraSimpleExtension = new ArrayList<>();
    }
    return this.cameraSimpleExtension;
  }

  /**
   * @see cameraObjectExtension
   *
   */
  public List<AbstractObject> getCameraObjectExtension() {
    if (cameraObjectExtension == null) {
      cameraObjectExtension = new ArrayList<>();
    }
    return this.cameraObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(longitude);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(latitude);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(altitude);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(heading);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(tilt);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(roll);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((altitudeMode == null) ? 0 : altitudeMode.hashCode()));
    result = ((prime * result) + ((cameraSimpleExtension == null) ? 0 : cameraSimpleExtension.hashCode()));
    result = ((prime * result) + ((cameraObjectExtension == null) ? 0 : cameraObjectExtension.hashCode()));
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
    if ((obj instanceof Camera) == false) {
      return false;
    }
    Camera other = ((Camera) obj);
    if (longitude != other.longitude) {
      return false;
    }
    if (latitude != other.latitude) {
      return false;
    }
    if (altitude != other.altitude) {
      return false;
    }
    if (heading != other.heading) {
      return false;
    }
    if (tilt != other.tilt) {
      return false;
    }
    if (roll != other.roll) {
      return false;
    }
    if (altitudeMode == null) {
      if (other.altitudeMode != null) {
        return false;
      }
    } else if (altitudeMode.equals(other.altitudeMode) == false) {
      return false;
    }
    if (cameraSimpleExtension == null) {
      if (other.cameraSimpleExtension != null) {
        return false;
      }
    } else if (cameraSimpleExtension.equals(other.cameraSimpleExtension) == false) {
      return false;
    }
    if (cameraObjectExtension == null) {
      if (other.cameraObjectExtension != null) {
        return false;
      }
    } else if (cameraObjectExtension.equals(other.cameraObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see cameraSimpleExtension
   *
   * @param cameraSimpleExtension
   */
  public void setCameraSimpleExtension(final List<Object> cameraSimpleExtension) {
    this.cameraSimpleExtension = cameraSimpleExtension;
  }

  /**
   * add a value to the cameraSimpleExtension property collection
   *
   * @param cameraSimpleExtension Objects of the following type are allowed in
   *                              the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Camera addToCameraSimpleExtension(final Object cameraSimpleExtension) {
    this.getCameraSimpleExtension().add(cameraSimpleExtension);
    return this;
  }

  /**
   * @see cameraObjectExtension
   *
   * @param cameraObjectExtension
   */
  public void setCameraObjectExtension(final List<AbstractObject> cameraObjectExtension) {
    this.cameraObjectExtension = cameraObjectExtension;
  }

  /**
   * add a value to the cameraObjectExtension property collection
   *
   * @param cameraObjectExtension Objects of the following type are allowed in
   *                              the list: {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Camera addToCameraObjectExtension(final AbstractObject cameraObjectExtension) {
    this.getCameraObjectExtension().add(cameraObjectExtension);
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
  public Camera addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * @see abstractViewSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setAbstractViewSimpleExtension(final List<Object> abstractViewSimpleExtension) {
    super.setAbstractViewSimpleExtension(abstractViewSimpleExtension);
  }

  @Obvious
  @Override
  public Camera addToAbstractViewSimpleExtension(final Object abstractViewSimpleExtension) {
    super.getAbstractViewSimpleExtension().add(abstractViewSimpleExtension);
    return this;
  }

  /**
   * @see abstractViewObjectExtension
   *
   */
  @Obvious
  @Override
  public void setAbstractViewObjectExtension(final List<AbstractObject> abstractViewObjectExtension) {
    super.setAbstractViewObjectExtension(abstractViewObjectExtension);
  }

  @Obvious
  @Override
  public Camera addToAbstractViewObjectExtension(final AbstractObject abstractViewObjectExtension) {
    super.getAbstractViewObjectExtension().add(abstractViewObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLongitude(double)
   *
   * @param longitude required parameter
   */
  public Camera withLongitude(final double longitude) {
    this.setLongitude(longitude);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLatitude(double)
   *
   * @param latitude required parameter
   */
  public Camera withLatitude(final double latitude) {
    this.setLatitude(latitude);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAltitude(double)
   *
   * @param altitude required parameter
   */
  public Camera withAltitude(final double altitude) {
    this.setAltitude(altitude);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setHeading(double)
   *
   * @param heading required parameter
   */
  public Camera withHeading(final double heading) {
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
  public Camera withTilt(final double tilt) {
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
  public Camera withRoll(final double roll) {
    this.setRoll(roll);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAltitudeMode(Object)
   *
   * @param altitudeMode required parameter
   */
  public Camera withAltitudeMode(final AltitudeMode altitudeMode) {
    this.setAltitudeMode(altitudeMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setCameraSimpleExtension(List &lt;Object&gt;)
   *
   * @param cameraSimpleExtension required parameter
   */
  public Camera withCameraSimpleExtension(final List<Object> cameraSimpleExtension) {
    this.setCameraSimpleExtension(cameraSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setCameraObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param cameraObjectExtension required parameter
   */
  public Camera withCameraObjectExtension(final List<AbstractObject> cameraObjectExtension) {
    this.setCameraObjectExtension(cameraObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Camera withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Camera withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Camera withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public Camera withAbstractViewSimpleExtension(final List<Object> abstractViewSimpleExtension) {
    super.withAbstractViewSimpleExtension(abstractViewSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Camera withAbstractViewObjectExtension(final List<AbstractObject> abstractViewObjectExtension) {
    super.withAbstractViewObjectExtension(abstractViewObjectExtension);
    return this;
  }

  @Override
  public Camera clone() {
    Camera copy;
    copy = ((Camera) super.clone());
    copy.cameraSimpleExtension = new ArrayList<>((getCameraSimpleExtension().size()));
    for (Object iter : cameraSimpleExtension) {
      copy.cameraSimpleExtension.add(iter);
    }
    copy.cameraObjectExtension = new ArrayList<>((getCameraObjectExtension().size()));
    for (AbstractObject iter : cameraObjectExtension) {
      copy.cameraObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
