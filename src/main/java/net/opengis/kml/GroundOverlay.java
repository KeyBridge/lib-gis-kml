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
import net.opengis.kml.atom.Author;
import net.opengis.kml.atom.Link;
import net.opengis.kml.gx.LatLonQuad;
import net.opengis.kml.xal.AddressDetails;

/**
 * &lt;GroundOverlay&gt;
 * <p>
 * This element draws an image overlay draped onto the terrain. The &lt;href&gt;
 * child of &lt;Icon&gt; specifies the image to be used as the overlay. This
 * file can be either on a local file system or on a web server. If this element
 * is omitted or contains no &lt;href&gt;, a rectangle is drawn using the color
 * and LatLonBox bounds defined by the ground overlay. Syntax: &lt;pre&gt;
 * &lt;strong&gt;&lt;GroundOverlay id="ID"&gt; &lt;/strong&gt; &lt;!-- inherited
 * from &lt;em&gt;Feature &lt;/em&gt; element --&gt; &lt;name&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/name&gt; &lt;!-- string --&gt;
 * &lt;visibility&gt;1&lt;/visibility&gt; &lt;!-- boolean --&gt;
 * &lt;open&gt;0&lt;/open&gt; &lt;!-- boolean --&gt;
 * &lt;span&gt;&lt;atom:author&gt;...&lt;atom:author&gt; &lt;!-- xmlns:atom
 * --&gt; &lt;atom:link&gt;...&lt;/atom:link&gt; &lt;/span&gt; &lt;span&gt;
 * &lt;!-- xmlns:atom --&gt; &lt;/span&gt; &lt;address&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/address&gt; &lt;!-- string --&gt;
 * &lt;xal:AddressDetails&gt;...&lt;/xal:AddressDetails&gt; &lt;!-- xmlns:xal
 * --&gt; &lt;br&gt; &lt;phoneNumber&gt;...&lt;/phoneNumber&gt; &lt;!-- string
 * --&gt; &lt;br&gt; &lt;Snippet maxLines="2"&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/Snippet&gt; &lt;!-- string --&gt; &lt;description&gt;
 * &lt;em&gt;... &lt;/em&gt;&lt;/description&gt; &lt;!-- string --&gt;
 * &lt;span&gt; &lt;em&gt;&lt;AbstractView&gt;...&lt;/AbstractView&gt;
 * &lt;/em&gt; &lt;!-- Camera &lt;em&gt;or &lt;/em&gt; LookAt --&gt;
 * &lt;/span&gt; &lt; &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;...&lt;/
 * &lt;em&gt;TimePrimitive &lt;/em&gt;&gt; &lt;styleUrl&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/styleUrl&gt; &lt;!-- anyURI --&gt; &lt;
 * &lt;em&gt;StyleSelector&gt;...&lt;/StyleSelector&gt; &lt;/em&gt;
 * &lt;Region&gt;...&lt;/Region&gt;
 * &lt;span&gt;&lt;Metadata&gt;...&lt;/Metadata&gt; &lt;!-- deprecated in KML
 * 2.2 --&gt; &lt;ExtendedData&gt;...&lt;/ExtendedData&gt; &lt;!-- new in KML
 * 2.2 --&gt; &lt;/span&gt;
 * <p>
 * &lt;!-- inherited from &lt;em&gt;Overlay &lt;/em&gt; element --&gt;
 * &lt;color&gt;ffffffff&lt;/color&gt; &lt;!-- kml:color --&gt;
 * &lt;drawOrder&gt;0&lt;/drawOrder&gt; &lt;!-- int --&gt;
 * &lt;Icon&gt;...&lt;/Icon&gt;
 * <p>
 * &lt;!-- specific to GroundOverlay --&gt; &lt;altitude&gt;0&lt;/altitude&gt;
 * &lt;!-- double --&gt; &lt;altitudeMode&gt;clampToGround&lt;/altitudeMode&gt;
 * &lt;!-- kml:altitudeModeEnum: clampToGround or absolute --&gt; &lt;!-- or,
 * substitute gx:altitudeMode: clampToSeaFloor or relativeToSeaFloor --&gt;
 * &lt;LatLonBox&gt; &lt;north&gt;...&lt;/north&gt; &lt;! kml:angle90 --&gt;
 * &lt;south&gt; &lt;em&gt;... &lt;/em&gt;&lt;/south&gt; &lt;! kml:angle90
 * --&gt; &lt;east&gt; &lt;em&gt;... &lt;/em&gt;&lt;/east&gt; &lt;! kml:angle180
 * --&gt; &lt;west&gt; &lt;em&gt;... &lt;/em&gt;&lt;/west&gt; &lt;! kml:angle180
 * --&gt; &lt;rotation&gt;0&lt;/rotation&gt; &lt;! kml:angle180 --&gt;
 * &lt;/LatLonBox&gt; &lt;strong&gt;&lt;/GroundOverlay&gt; &lt;/strong&gt;
 * </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Feature&gt;
 * @see: &lt;Overlay&gt;
 *
 * Contained By:
 * @see: &lt;Document&gt;
 * @see: &lt;Folder&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroundOverlayType", propOrder = {
  "altitude",
  "altitudeMode",
  "latLonBox",
  "groundOverlaySimpleExtension",
  "groundOverlayObjectExtension"
})
@XmlRootElement(name = "GroundOverlay", namespace = "http://www.opengis.net/kml/2.2")
public class GroundOverlay
  extends Overlay
  implements Cloneable {

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
   * AltitudeMode
   * <p>
   * clampToGround, relativeToGround, absolute See Also: See &lt;LookAt&gt; and
   * &lt;Region&gt;
   * <p>
   */
  @XmlElement(defaultValue = "clampToGround")
  protected AltitudeMode altitudeMode;
  /**
   * &lt;latlonbox&gt;
   * <p>
   * Specifies where the top, bottom, right, and left sides of a bounding box
   * for the ground overlay are aligned. &lt;north&gt; Specifies the latitude of
   * the north edge of the bounding box, in decimal degrees from 0 to ±90.
   * &lt;south&gt; Specifies the latitude of the south edge of the bounding box,
   * in decimal degrees from 0 to ±90. &lt;east&gt; Specifies the longitude of
   * the east edge of the bounding box, in decimal degrees from 0 to ±180. (For
   * overlays that overlap the meridian of 180° longitude, values can extend
   * beyond that range.) &lt;west&gt; Specifies the longitude of the west edge
   * of the bounding box, in decimal degrees from 0 to ±180. (For overlays that
   * overlap the meridian of 180° longitude, values can extend beyond that
   * range.) &lt;rotation&gt; Specifies a rotation of the overlay about its
   * center, in degrees. Values can be ±180. The default is 0 (north). Rotations
   * are specified in a counterclockwise direction. &lt;LatLonBox&gt;
   * &lt;north&gt;48.25475939255556 &lt;/north&gt;
   * &lt;south&gt;48.25207367852141 &lt;/south&gt;
   * &lt;east&gt;-90.86591508839973 &lt;/east&gt; &lt;west&gt;-90.8714285289695
   * &lt;/west&gt; &lt;rotation&gt;39.37878630116985 &lt;/rotation&gt;
   * &lt;/LatLonBox&gt;
   */
  @XmlElement(name = "LatLonBox")
  protected LatLonBox latLonBox;
  @XmlElement(name = "GroundOverlaySimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> groundOverlaySimpleExtension;
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
  @XmlElementRef(name = "GroundOverlayObjectExtensionGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected List<AbstractObject> groundOverlayObjectExtension;

  public GroundOverlay() {
    super();
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
   * @see altitudeMode
   *
   * @return possible object is null null null null null null null null   {@link Object}
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
   * @param value allowed object is null null null null null null null null   {@link Object}
     *     {@link net.opengis.kml.AltitudeMode}
   *     {@link de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}
   *
   */
  public void setAltitudeMode(AltitudeMode value) {
    this.altitudeMode = value;
  }

  /**
   * @see latLonBox
   *
   * @return possible object is {@link LatLonBox}
   *
   */
  public LatLonBox getLatLonBox() {
    return latLonBox;
  }

  /**
   * @see latLonBox
   *
   * @param value allowed object is {@link LatLonBox}
   *
   */
  public void setLatLonBox(LatLonBox value) {
    this.latLonBox = value;
  }

  /**
   * @see groundOverlaySimpleExtension
   *
   */
  public List<Object> getGroundOverlaySimpleExtension() {
    if (groundOverlaySimpleExtension == null) {
      groundOverlaySimpleExtension = new ArrayList<>();
    }
    return this.groundOverlaySimpleExtension;
  }

  /**
   * @see groundOverlayObjectExtension
   *
   */
  public List<AbstractObject> getGroundOverlayObjectExtension() {
    if (groundOverlayObjectExtension == null) {
      groundOverlayObjectExtension = new ArrayList<>();
    }
    return this.groundOverlayObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(altitude);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((altitudeMode == null) ? 0 : altitudeMode.hashCode()));
    result = ((prime * result) + ((latLonBox == null) ? 0 : latLonBox.hashCode()));
    result = ((prime * result) + ((groundOverlaySimpleExtension == null) ? 0 : groundOverlaySimpleExtension.hashCode()));
    result = ((prime * result) + ((groundOverlayObjectExtension == null) ? 0 : groundOverlayObjectExtension.hashCode()));
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
    if ((obj instanceof GroundOverlay) == false) {
      return false;
    }
    GroundOverlay other = ((GroundOverlay) obj);
    if (altitude != other.altitude) {
      return false;
    }
    if (altitudeMode == null) {
      if (other.altitudeMode != null) {
        return false;
      }
    } else if (altitudeMode.equals(other.altitudeMode) == false) {
      return false;
    }
    if (latLonBox == null) {
      if (other.latLonBox != null) {
        return false;
      }
    } else if (latLonBox.equals(other.latLonBox) == false) {
      return false;
    }
    if (groundOverlaySimpleExtension == null) {
      if (other.groundOverlaySimpleExtension != null) {
        return false;
      }
    } else if (groundOverlaySimpleExtension.equals(other.groundOverlaySimpleExtension) == false) {
      return false;
    }
    if (groundOverlayObjectExtension == null) {
      if (other.groundOverlayObjectExtension != null) {
        return false;
      }
    } else if (groundOverlayObjectExtension.equals(other.groundOverlayObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link LatLonBox} and set it to latLonBox.
   * <p>
   * This method is a short version for: &lt;code&gt; LatLonBox latLonBox = new
   * LatLonBox(); this.setLatLonBox(latLonBox); &lt;/code&gt;
   */
  public LatLonBox createAndSetLatLonBox() {
    LatLonBox newValue = new LatLonBox();
    this.setLatLonBox(newValue);
    return newValue;
  }

  /**
   * @see groundOverlaySimpleExtension
   *
   * @param groundOverlaySimpleExtension
   */
  public void setGroundOverlaySimpleExtension(final List<Object> groundOverlaySimpleExtension) {
    this.groundOverlaySimpleExtension = groundOverlaySimpleExtension;
  }

  /**
   * add a value to the groundOverlaySimpleExtension property collection
   *
   * @param groundOverlaySimpleExtension Objects of the following type are
   *                                     allowed in the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public GroundOverlay addToGroundOverlaySimpleExtension(final Object groundOverlaySimpleExtension) {
    this.getGroundOverlaySimpleExtension().add(groundOverlaySimpleExtension);
    return this;
  }

  /**
   * @see groundOverlayObjectExtension
   *
   * @param groundOverlayObjectExtension
   */
  public void setGroundOverlayObjectExtension(final List<AbstractObject> groundOverlayObjectExtension) {
    this.groundOverlayObjectExtension = groundOverlayObjectExtension;
  }

  /**
   * add a value to the groundOverlayObjectExtension property collection
   *
   * @param groundOverlayObjectExtension Objects of the following type are
   *                                     allowed in the list:
   *                                     {@link LatLonQuad}{@link JAXBElement}{@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public GroundOverlay addToGroundOverlayObjectExtension(final AbstractObject groundOverlayObjectExtension) {
    this.getGroundOverlayObjectExtension().add(groundOverlayObjectExtension);
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
  public GroundOverlay addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * @see styleSelector
   *
   */
  @Obvious
  @Override
  public void setStyleSelector(final List<StyleSelector> styleSelector) {
    super.setStyleSelector(styleSelector);
  }

  @Obvious
  @Override
  public GroundOverlay addToStyleSelector(final StyleSelector styleSelector) {
    super.getStyleSelector().add(styleSelector);
    return this;
  }

  /**
   * @see featureSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.setFeatureSimpleExtension(featureSimpleExtension);
  }

  @Obvious
  @Override
  public GroundOverlay addToFeatureSimpleExtension(final Object featureSimpleExtension) {
    super.getFeatureSimpleExtension().add(featureSimpleExtension);
    return this;
  }

  /**
   * @see featureObjectExtension
   *
   */
  @Obvious
  @Override
  public void setFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.setFeatureObjectExtension(featureObjectExtension);
  }

  @Obvious
  @Override
  public GroundOverlay addToFeatureObjectExtension(final AbstractObject featureObjectExtension) {
    super.getFeatureObjectExtension().add(featureObjectExtension);
    return this;
  }

  /**
   * @see overlaySimpleExtension
   *
   */
  @Obvious
  @Override
  public void setOverlaySimpleExtension(final List<Object> overlaySimpleExtension) {
    super.setOverlaySimpleExtension(overlaySimpleExtension);
  }

  @Obvious
  @Override
  public GroundOverlay addToOverlaySimpleExtension(final Object overlaySimpleExtension) {
    super.getOverlaySimpleExtension().add(overlaySimpleExtension);
    return this;
  }

  /**
   * @see overlayObjectExtension
   *
   */
  @Obvious
  @Override
  public void setOverlayObjectExtension(final List<AbstractObject> overlayObjectExtension) {
    super.setOverlayObjectExtension(overlayObjectExtension);
  }

  @Obvious
  @Override
  public GroundOverlay addToOverlayObjectExtension(final AbstractObject overlayObjectExtension) {
    super.getOverlayObjectExtension().add(overlayObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAltitude(double)
   *
   * @param altitude required parameter
   */
  public GroundOverlay withAltitude(final double altitude) {
    this.setAltitude(altitude);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAltitudeMode(Object)
   *
   * @param altitudeMode required parameter
   */
  public GroundOverlay withAltitudeMode(final AltitudeMode altitudeMode) {
    this.setAltitudeMode(altitudeMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLatLonBox(LatLonBox)
   *
   * @param latLonBox required parameter
   */
  public GroundOverlay withLatLonBox(final LatLonBox latLonBox) {
    this.setLatLonBox(latLonBox);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setGroundOverlaySimpleExtension(List &lt;Object&gt;)
   *
   * @param groundOverlaySimpleExtension required parameter
   */
  public GroundOverlay withGroundOverlaySimpleExtension(final List<Object> groundOverlaySimpleExtension) {
    this.setGroundOverlaySimpleExtension(groundOverlaySimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setGroundOverlayObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param groundOverlayObjectExtension required parameter
   */
  public GroundOverlay withGroundOverlayObjectExtension(final List<AbstractObject> groundOverlayObjectExtension) {
    this.setGroundOverlayObjectExtension(groundOverlayObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withName(final String name) {
    super.withName(name);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withVisibility(final Boolean visibility) {
    super.withVisibility(visibility);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withOpen(final Boolean open) {
    super.withOpen(open);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withAtomAuthor(final Author atomAuthor) {
    super.withAtomAuthor(atomAuthor);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withAtomLink(final Link atomLink) {
    super.withAtomLink(atomLink);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withAddress(final String address) {
    super.withAddress(address);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withXalAddressDetails(final AddressDetails xalAddressDetails) {
    super.withXalAddressDetails(xalAddressDetails);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withPhoneNumber(final String phoneNumber) {
    super.withPhoneNumber(phoneNumber);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withSnippet(final Snippet snippet) {
    super.withSnippet(snippet);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withSnippetd(final String snippetd) {
    super.withSnippetd(snippetd);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withDescription(final String description) {
    super.withDescription(description);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withAbstractView(final AbstractView abstractView) {
    super.withAbstractView(abstractView);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withTimePrimitive(final TimePrimitive timePrimitive) {
    super.withTimePrimitive(timePrimitive);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withStyleUrl(final String styleUrl) {
    super.withStyleUrl(styleUrl);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withStyleSelector(final List<StyleSelector> styleSelector) {
    super.withStyleSelector(styleSelector);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withRegion(final Region region) {
    super.withRegion(region);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withMetadata(final Metadata metadata) {
    super.withMetadata(metadata);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withExtendedData(final ExtendedData extendedData) {
    super.withExtendedData(extendedData);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.withFeatureSimpleExtension(featureSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.withFeatureObjectExtension(featureObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withColor(final String color) {
    super.withColor(color);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withDrawOrder(final int drawOrder) {
    super.withDrawOrder(drawOrder);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withIcon(final Icon icon) {
    super.withIcon(icon);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withOverlaySimpleExtension(final List<Object> overlaySimpleExtension) {
    super.withOverlaySimpleExtension(overlaySimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public GroundOverlay withOverlayObjectExtension(final List<AbstractObject> overlayObjectExtension) {
    super.withOverlayObjectExtension(overlayObjectExtension);
    return this;
  }

  @Override
  public GroundOverlay clone() {
    GroundOverlay copy;
    copy = ((GroundOverlay) super.clone());
    copy.latLonBox = ((latLonBox == null) ? null : ((LatLonBox) latLonBox.clone()));
    copy.groundOverlaySimpleExtension = new ArrayList<>((getGroundOverlaySimpleExtension().size()));
    for (Object iter : groundOverlaySimpleExtension) {
      copy.groundOverlaySimpleExtension.add(iter);
    }
    copy.groundOverlayObjectExtension = new ArrayList<>((getGroundOverlayObjectExtension().size()));
    for (AbstractObject iter : groundOverlayObjectExtension) {
      copy.groundOverlayObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
