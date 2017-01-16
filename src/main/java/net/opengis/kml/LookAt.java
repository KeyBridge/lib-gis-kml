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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.opengis.kml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.kml.annotations.Obvious;


/**
 * <LookAt>
 * <p>
 * Defines a virtual camera that is associated with any element derived from Feature. 
 * The LookAt element positions the "camera" in relation to the object that is being 
 * viewed. In Google Earth, the view "flies to" this LookAt viewpoint when the user 
 * double-clicks an item in the Places panel or double-clicks an icon in the 3D viewer. 
 * </p>
 * 
 * Syntax: 
 * <pre><strong>&lt;LookAt id="ID"&gt;</strong>
 *   &lt;!-- inherited from AbstractView element --&gt;
 *   <em>&lt;TimePrimitive&gt;...&lt;/TimePrimitive&gt;</em>  &lt;!-- gx:TimeSpan or gx:TimeStamp --&gt;
 *    
 *   &lt;!-- specific to LookAt --&gt;
 *   &lt;longitude&gt;0&lt;/longitude&gt;            &lt;!-- kml:angle180 --&gt;
 *   &lt;latitude&gt;0&lt;/latitude&gt;              &lt;!-- kml:angle90 --&gt;
 *   &lt;altitude&gt;0&lt;/altitude&gt;              &lt;!-- double --&gt; 
 *   &lt;heading&gt;0&lt;/heading&gt;                &lt;!-- kml:angle360 --&gt;
 *   &lt;tilt&gt;0&lt;/tilt&gt;                      &lt;!-- kml:anglepos90 --&gt;
 *   &lt;range&gt;&lt;/range&gt;                     &lt;!-- double --&gt;
 *   &lt;altitudeMode&gt;clampToGround&lt;/altitudeMode&gt; 
 *           &lt;!--kml:altitudeModeEnum:clampToGround, relativeToGround, absolute --&gt;
 *           &lt;!-- or, gx:altitudeMode can be substituted: clampToSeaFloor, relativeToSeaFloor --&gt;
 * 
 * <strong>&lt;/LookAt&gt;</strong></pre>
 * 
 * Extends: 
 * @see: <AbstractView>
 * 
 * Contained By: 
 * @see: <Feature>
 * @see: <NetworkLinkControl>
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LookAtType", propOrder = {
    "longitude",
    "latitude",
    "altitude",
    "heading",
    "tilt",
    "range",
    "altitudeMode",
    "lookAtSimpleExtension",
    "lookAtObjectExtension"
})
@XmlRootElement(name = "LookAt", namespace = "http://www.opengis.net/kml/2.2")
public class LookAt
    extends AbstractView
    implements Cloneable
{

    /**
     * <longitude>
     * <p>
     * Longitude of the point the camera is looking at. Angular distance in degrees, relative 
     * to the Prime Meridian. Values west of the Meridian range from −180 to 0 degrees. 
     * Values east of the Meridian range from 0 to 180 degrees. 
     * </p>
     * <p>
     * Longitude of the virtual camera (eye point). Angular distance in degrees, relative 
     * to the Prime Meridian. Values west of the Meridian range from −180 to 0 degrees. 
     * Values east of the Meridian range from 0 to 180 degrees. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double longitude;
    /**
     * <latitude>
     * <p>
     * Latitude of the point the camera is looking at. Degrees north or south of the Equator 
     * (0 degrees). Values range from −90 degrees to 90 degrees. 
     * </p>
     * <p>
     * Latitude of the virtual camera. Degrees north or south of the Equator (0 degrees). 
     * Values range from −90 degrees to 90 degrees. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double latitude;
    /**
     * <altitude>
     * <p>
     * Distance from the earth's surface, in meters. Interpreted according to the LookAt's 
     * altitude mode. 
     * </p>
     * <p>
     * Distance of the camera from the earth's surface, in meters. Interpreted according 
     * to the Camera's <altitudeMode> or <gx:altitudeMode>. 
     * </p>
     * <p>
     * Specifies the distance above the earth's surface, in meters, and is interpreted 
     * according to the altitude mode. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double altitude;
    /**
     * <heading>
     * <p>
     * Direction (azimuth) of the camera, in degrees. Default=0 (true North). (See diagram.) 
     * Values range from 0 to 360 degrees. 
     * </p>
     * <p>
     * Direction (that is, North, South, East, West), in degrees. Default=0 (North). (See 
     * diagram below.) Values range from 0 to 360 degrees. 
     * </p>
     * <p>
     * Direction (that is, North, South, East, West), in degrees. Default=0 (North). (See 
     * diagram.) Values range from 0 to 360 degrees. 
     * </p>
     * <p>
     * Rotation about the z axis (normal to the Earth's surface). A value of 0 (the default) 
     * equals North. A positive rotation is clockwise around the z axis and specified in 
     * degrees from 0 to 360. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double heading;
    /**
     * <tilt>
     * <p>
     * Angle between the direction of the LookAt position and the normal to the surface 
     * of the earth. (See diagram below.) Values range from 0 to 90 degrees. Values for 
     * <tilt> cannot be negative. A <tilt> value of 0 degrees indicates viewing from directly 
     * above. A <tilt> value of 90 degrees indicates viewing along the horizon. 
     * </p>
     * <p>
     * Rotation about the x axis. A positive rotation is clockwise around the x axis and 
     * specified in degrees from 0 to 360. 
     * </p>
     * <p>
     * Rotation, in degrees, of the camera around the X axis. A value of 0 indicates that 
     * the view is aimed straight down toward the earth (the most common case). A value 
     * for 90 for <tilt> indicates that the view is aimed toward the horizon. Values greater 
     * than 90 indicate that the view is pointed up into the sky. Values for <tilt> are 
     * clamped at +180 degrees. 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double tilt;
    /**
     * <range> (required)
     * <p>
     * Distance in meters from the point specified by <longitude>, <latitude>, and <altitude> 
     * to the LookAt position. (See diagram below.) 
     * </p>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "0.0")
    protected double range;
    /**
     * AltitudeMode
     * <p>
     * clampToGround, relativeToGround, absolute 
     * </p>
     * 
     * See Also: 
     * See <LookAt> and <Region>
     * 
     * 
     * 
     */
    @XmlElement(defaultValue = "clampToGround")
    protected AltitudeMode altitudeMode;
    @XmlElement(name = "LookAtSimpleExtensionGroup")
    @XmlSchemaType(name = "anySimpleType")
    protected List<Object> lookAtSimpleExtension;
    /**
     * <Object>
     * <p>
     * This is an abstract base class and cannot be used directly in a KML file. It provides 
     * the id attribute, which allows unique identification of a KML element, and the targetId 
     * attribute, which is used to reference objects that have already been loaded into 
     * Google Earth. The id attribute must be assigned if the <Update> mechanism is to 
     * be used. 
     * </p>
     * 
     * Syntax: 
     * <pre>&lt;!-- abstract element; do not create --&gt;<strong>
     * &lt;!-- <em>Object</em> id="ID" targetId="NCName" --&gt;
     * &lt;!-- /<em>Object</em>&gt; --&gt;</strong></pre>
     * 
     * 
     * 
     */
    @XmlElement(name = "LookAtObjectExtensionGroup")
    protected List<AbstractObject> lookAtObjectExtension;

    public LookAt() {
        super();
    }

    /**
     * @see longitude
     * 
     * @return
     *     possible object is
     *     {@link Double}
     *     
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @see longitude
     * 
     * @param value
     *     allowed object is
     *     {@link Double}
     *     
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

    /**
     * @see latitude
     * 
     * @return
     *     possible object is
     *     {@link Double}
     *     
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @see latitude
     * 
     * @param value
     *     allowed object is
     *     {@link Double}
     *     
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * @see altitude
     * 
     * @return
     *     possible object is
     *     {@link Double}
     *     
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * @see altitude
     * 
     * @param value
     *     allowed object is
     *     {@link Double}
     *     
     */
    public void setAltitude(double value) {
        this.altitude = value;
    }

    /**
     * @see heading
     * 
     * @return
     *     possible object is
     *     {@link Double}
     *     
     */
    public double getHeading() {
        return heading;
    }

    /**
     * @see heading
     * 
     * @param value
     *     allowed object is
     *     {@link Double}
     *     
     */
    public void setHeading(double value) {
        this.heading = value;
    }

    /**
     * @see tilt
     * 
     * @return
     *     possible object is
     *     {@link Double}
     *     
     */
    public double getTilt() {
        return tilt;
    }

    /**
     * @see tilt
     * 
     * @param value
     *     allowed object is
     *     {@link Double}
     *     
     */
    public void setTilt(double value) {
        this.tilt = value;
    }

    /**
     * @see range
     * 
     * @return
     *     possible object is
     *     {@link Double}
     *     
     */
    public double getRange() {
        return range;
    }

    /**
     * @see range
     * 
     * @param value
     *     allowed object is
     *     {@link Double}
     *     
     */
    public void setRange(double value) {
        this.range = value;
    }

    /**
     * @see altitudeMode
     * 
     * @return
     *     possible object is
     *     {@code <}{@link Object}{@code>}
     *     {@code <}{@link net.opengis.kml.AltitudeMode}{@code>}
     *     {@code <}{@link de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}{@code>}
     *     
     */
    public AltitudeMode getAltitudeMode() {
        return altitudeMode;
    }

    /**
     * @see altitudeMode
     * 
     * @param value
     *     allowed object is
     *     {@code <}{@link Object}{@code>}
     *     {@code <}{@link net.opengis.kml.AltitudeMode}{@code>}
     *     {@code <}{@link de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}{@code>}
     *     
     */
    public void setAltitudeMode(AltitudeMode value) {
        this.altitudeMode = value;
    }

    /**
     * @see lookAtSimpleExtension
     * 
     */
    public List<Object> getLookAtSimpleExtension() {
        if (lookAtSimpleExtension == null) {
            lookAtSimpleExtension = new ArrayList<Object>();
        }
        return this.lookAtSimpleExtension;
    }

    /**
     * @see lookAtObjectExtension
     * 
     */
    public List<AbstractObject> getLookAtObjectExtension() {
        if (lookAtObjectExtension == null) {
            lookAtObjectExtension = new ArrayList<AbstractObject>();
        }
        return this.lookAtObjectExtension;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(longitude);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(latitude);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(altitude);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(heading);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(tilt);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        temp = Double.doubleToLongBits(range);
        result = ((prime*result)+((int)(temp^(temp >>>(32)))));
        result = ((prime*result)+((altitudeMode == null)? 0 :altitudeMode.hashCode()));
        result = ((prime*result)+((lookAtSimpleExtension == null)? 0 :lookAtSimpleExtension.hashCode()));
        result = ((prime*result)+((lookAtObjectExtension == null)? 0 :lookAtObjectExtension.hashCode()));
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
        if ((obj instanceof LookAt) == false) {
            return false;
        }
        LookAt other = ((LookAt) obj);
        if (longitude!= other.longitude) {
            return false;
        }
        if (latitude!= other.latitude) {
            return false;
        }
        if (altitude!= other.altitude) {
            return false;
        }
        if (heading!= other.heading) {
            return false;
        }
        if (tilt!= other.tilt) {
            return false;
        }
        if (range!= other.range) {
            return false;
        }
        if (altitudeMode == null) {
            if (other.altitudeMode!= null) {
                return false;
            }
        } else {
            if (altitudeMode.equals(other.altitudeMode) == false) {
                return false;
            }
        }
        if (lookAtSimpleExtension == null) {
            if (other.lookAtSimpleExtension!= null) {
                return false;
            }
        } else {
            if (lookAtSimpleExtension.equals(other.lookAtSimpleExtension) == false) {
                return false;
            }
        }
        if (lookAtObjectExtension == null) {
            if (other.lookAtObjectExtension!= null) {
                return false;
            }
        } else {
            if (lookAtObjectExtension.equals(other.lookAtObjectExtension) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * @see lookAtSimpleExtension
     * 
     * @param lookAtSimpleExtension
     */
    public void setLookAtSimpleExtension(final List<Object> lookAtSimpleExtension) {
        this.lookAtSimpleExtension = lookAtSimpleExtension;
    }

    /**
     * add a value to the lookAtSimpleExtension property collection
     * 
     * @param lookAtSimpleExtension
     *     Objects of the following type are allowed in the list: {@link Object}
     * @return
     *     <tt>true</tt> (as general contract of <tt>Collection.add</tt>). 
     */
    public LookAt addToLookAtSimpleExtension(final Object lookAtSimpleExtension) {
        this.getLookAtSimpleExtension().add(lookAtSimpleExtension);
        return this;
    }

    /**
     * @see lookAtObjectExtension
     * 
     * @param lookAtObjectExtension
     */
    public void setLookAtObjectExtension(final List<AbstractObject> lookAtObjectExtension) {
        this.lookAtObjectExtension = lookAtObjectExtension;
    }

    /**
     * add a value to the lookAtObjectExtension property collection
     * 
     * @param lookAtObjectExtension
     *     Objects of the following type are allowed in the list: {@link AbstractObject}
     * @return
     *     <tt>true</tt> (as general contract of <tt>Collection.add</tt>). 
     */
    public LookAt addToLookAtObjectExtension(final AbstractObject lookAtObjectExtension) {
        this.getLookAtObjectExtension().add(lookAtObjectExtension);
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
    public LookAt addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
    public LookAt addToAbstractViewSimpleExtension(final Object abstractViewSimpleExtension) {
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
    public LookAt addToAbstractViewObjectExtension(final AbstractObject abstractViewObjectExtension) {
        super.getAbstractViewObjectExtension().add(abstractViewObjectExtension);
        return this;
    }

    /**
     * fluent setter
     * @see #setLongitude(double)
     * 
     * @param longitude
     *     required parameter
     */
    public LookAt withLongitude(final double longitude) {
        this.setLongitude(longitude);
        return this;
    }

    /**
     * fluent setter
     * @see #setLatitude(double)
     * 
     * @param latitude
     *     required parameter
     */
    public LookAt withLatitude(final double latitude) {
        this.setLatitude(latitude);
        return this;
    }

    /**
     * fluent setter
     * @see #setAltitude(double)
     * 
     * @param altitude
     *     required parameter
     */
    public LookAt withAltitude(final double altitude) {
        this.setAltitude(altitude);
        return this;
    }

    /**
     * fluent setter
     * @see #setHeading(double)
     * 
     * @param heading
     *     required parameter
     */
    public LookAt withHeading(final double heading) {
        this.setHeading(heading);
        return this;
    }

    /**
     * fluent setter
     * @see #setTilt(double)
     * 
     * @param tilt
     *     required parameter
     */
    public LookAt withTilt(final double tilt) {
        this.setTilt(tilt);
        return this;
    }

    /**
     * fluent setter
     * @see #setRange(double)
     * 
     * @param range
     *     required parameter
     */
    public LookAt withRange(final double range) {
        this.setRange(range);
        return this;
    }

    /**
     * fluent setter
     * @see #setAltitudeMode(Object)
     * 
     * @param altitudeMode
     *     required parameter
     */
    public LookAt withAltitudeMode(final  AltitudeMode altitudeMode) {
        this.setAltitudeMode(altitudeMode);
        return this;
    }

    /**
     * fluent setter
     * @see #setLookAtSimpleExtension(List<Object>)
     * 
     * @param lookAtSimpleExtension
     *     required parameter
     */
    public LookAt withLookAtSimpleExtension(final List<Object> lookAtSimpleExtension) {
        this.setLookAtSimpleExtension(lookAtSimpleExtension);
        return this;
    }

    /**
     * fluent setter
     * @see #setLookAtObjectExtension(List<AbstractObject>)
     * 
     * @param lookAtObjectExtension
     *     required parameter
     */
    public LookAt withLookAtObjectExtension(final List<AbstractObject> lookAtObjectExtension) {
        this.setLookAtObjectExtension(lookAtObjectExtension);
        return this;
    }

    @Obvious
    @Override
    public LookAt withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
        super.withObjectSimpleExtension(objectSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public LookAt withId(final String id) {
        super.withId(id);
        return this;
    }

    @Obvious
    @Override
    public LookAt withTargetId(final String targetId) {
        super.withTargetId(targetId);
        return this;
    }

    @Obvious
    @Override
    public LookAt withAbstractViewSimpleExtension(final List<Object> abstractViewSimpleExtension) {
        super.withAbstractViewSimpleExtension(abstractViewSimpleExtension);
        return this;
    }

    @Obvious
    @Override
    public LookAt withAbstractViewObjectExtension(final List<AbstractObject> abstractViewObjectExtension) {
        super.withAbstractViewObjectExtension(abstractViewObjectExtension);
        return this;
    }

    @Override
    public LookAt clone() {
        LookAt copy;
        copy = ((LookAt) super.clone());
        copy.lookAtSimpleExtension = new ArrayList<Object>((getLookAtSimpleExtension().size()));
        for (Object iter: lookAtSimpleExtension) {
            copy.lookAtSimpleExtension.add(iter);
        }
        copy.lookAtObjectExtension = new ArrayList<AbstractObject>((getLookAtObjectExtension().size()));
        for (AbstractObject iter: lookAtObjectExtension) {
            copy.lookAtObjectExtension.add(iter.clone());
        }
        return copy;
    }

}
