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
import net.opengis.kml.xal.AddressDetails;

/**
 * &lt;ScreenOverlay&gt;
 * <p>
 * The &lt;href&gt; child of &lt;Icon&gt; specifies the image to be used as the
 * overlay. This file can be either on a local file system or on a web server.
 * If this element is omitted or contains no &lt;href&gt;, a rectangle is drawn
 * using the color and size defined by the screen overlay. This element draws an
 * image overlay fixed to the screen. Sample uses for ScreenOverlays are
 * compasses, logos, and heads-up displays. ScreenOverlay sizing is determined
 * by the &lt;size&gt; element. Positioning of the overlay is handled by mapping
 * a point in the image specified by &lt;overlayXY&gt; to a point on the screen
 * specified by &lt;screenXY&gt;. Then the image is rotated by &lt;rotation&gt;
 * degrees about a point relative to the screen specified by &lt;rotationXY&gt;.
 * This element draws an image overlay fixed to the screen. Sample uses for
 * ScreenOverlays are compasses, logos, and heads-up displays. ScreenOverlay
 * sizing is determined by the &lt;size&gt; element. Positioning of the overlay
 * is handled by mapping a point in the image specified by &lt;overlayXY&gt; to
 * a point on the screen specified by &lt;screenXY&gt;. Then the image is
 * rotated by &lt;rotation&gt; degrees about a point relative to the screen
 * specified by &lt;rotationXY&gt;. Syntax: &lt;pre&gt;
 * &lt;strong&gt;&lt;ScreenOverlay id="ID"&gt; &lt;/strong&gt; &lt;!-- inherited
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
 * 2.2 --&gt;
 * <p>
 * &lt;/span&gt;&lt;!-- inherited from &lt;em&gt;Overlay &lt;/em&gt; element
 * --&gt; &lt;color&gt;ffffffff&lt;/color&gt; &lt;!-- kml:color --&gt;
 * &lt;drawOrder&gt;0&lt;/drawOrder&gt; &lt;!-- int --&gt;
 * &lt;Icon&gt;...&lt;/Icon&gt;
 * <p>
 * &lt;!-- specific to ScreenOverlay --&gt; &lt;overlayXY x="double" y="double"
 * xunits="fraction" yunits="fraction"/&gt; &lt;!-- vec2 --&gt; &lt;!-- xunits
 * and yunits can be one of: fraction, pixels, &lt;em&gt;or &lt;/em&gt;
 * insetPixels --&gt; &lt;screenXY x="double" y="double" xunits="fraction"
 * yunits="fraction" &lt;em&gt;/ &lt;/em&gt;&gt; &lt;!-- vec2 --&gt;
 * &lt;rotationXY x="double" y="double" xunits="fraction" yunits"fraction"
 * &lt;em&gt;/ &lt;/em&gt;&gt; &lt;!-- vec2 --&gt; &lt;size x="double"
 * y="double" xunits="fraction" yunits="fraction" &lt;em&gt;/ &lt;/em&gt;&gt;
 * &lt;!-- vec2 --&gt; &lt;rotation&gt;0&lt;/rotation&gt; &lt;!-- float --&gt;
 * &lt;strong&gt;&lt;/ScreenOverlay&gt; &lt;/strong&gt; </pre>
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
@XmlType(name = "ScreenOverlayType", propOrder = {
  "overlayXY",
  "screenXY",
  "rotationXY",
  "size",
  "rotation",
  "screenOverlaySimpleExtension",
  "screenOverlayObjectExtension"
})
@XmlRootElement(name = "ScreenOverlay", namespace = "http://www.opengis.net/kml/2.2")
public class ScreenOverlay
  extends Overlay
  implements Cloneable {

  /**
   * &lt;overlayxy&gt;
   * <p>
   * Specifies a point on (or outside of) the overlay image that is mapped to
   * the screen coordinate ( &lt;screenXY&gt;). It requires x and y values, and
   * the units for those values. The x and y values can be specified in three
   * different ways: as pixels ("pixels"), as fractions of the image
   * ("fraction"), or as inset pixels ("insetPixels"), which is an offset in
   * pixels from the upper right corner of the image. The x and y positions can
   * be specified in different ways—for example, x can be in pixels and y can be
   * a fraction. The origin of the coordinate system is in the lower left corner
   * of the image. x - Either the number of pixels, a fractional component of
   * the image, or a pixel inset indicating the x component of a point on the
   * overlay image. y - Either the number of pixels, a fractional component of
   * the image, or a pixel inset indicating the y component of a point on the
   * overlay image. xunits - Units in which the x value is specified. A value of
   * "fraction" indicates the x value is a fraction of the image. A value of
   * "pixels" indicates the x value in pixels. A value of "insetPixels"
   * indicates the indent from the right edge of the image. yunits - Units in
   * which the y value is specified. A value of "fraction" indicates the y value
   * is a fraction of the image. A value of "pixels" indicates the y value in
   * pixels. A value of "insetPixels" indicates the indent from the top edge of
   * the image.
   */
  protected Vec2 overlayXY;
  /**
   * &lt;screenxy&gt;
   * <p>
   * Center the image: Center the image: &lt;ScreenOverlay&gt; &lt;overlayXY
   * x="0.5" y="0.5" xunits="fraction" yunits="fraction"/&gt; &lt;screenXY
   * x="0.5" y="0.5" xunits="fraction" yunits="fraction"/&gt;
   * &lt;/ScreenOverlay&gt; Place the image on the top left:
   * &lt;ScreenOverlay&gt; &lt;overlayXY x="0" y="1" xunits="fraction"
   * yunits="fraction"/&gt; &lt;screenXY x="0" y="1" xunits="fraction"
   * yunits="fraction"/&gt; &lt;/ScreenOverlay&gt; Place the image at the right
   * of the screen: &lt;ScreenOverlay&gt; &lt;overlayXY x="1" y="1"
   * xunits="fraction" yunits="fraction"/&gt; &lt;screenXY x="1" y="1"
   * xunits="fraction" yunits="fraction"/&gt; &lt;/ScreenOverlay&gt; For
   * example, &lt;screenXY x=".5" y=".5" xunits="fraction"
   * yunits="fraction"/&gt; indicates a point in the middle of the screen. Here
   * are some examples: Place the image at the right of the screen: Place the
   * image on the top left: Specifies a point relative to the screen origin that
   * the overlay image is mapped to. The x and y values can be specified in
   * three different ways: as pixels ("pixels"), as fractions of the screen
   * ("fraction"), or as inset pixels ("insetPixels"), which is an offset in
   * pixels from the upper right corner of the screen. The x and y positions can
   * be specified in different ways—for example, x can be in pixels and y can be
   * a fraction. The origin of the coordinate system is in the lower left corner
   * of the screen. x - Either the number of pixels, a fractional component of
   * the screen, or a pixel inset indicating the x component of a point on the
   * screen. y - Either the number of pixels, a fractional component of the
   * screen, or a pixel inset indicating the y component of a point on the
   * screen. xunits - Units in which the x value is specified. A value of
   * "fraction" indicates the x value is a fraction of the screen. A value of
   * "pixels" indicates the x value in pixels. A value of "insetPixels"
   * indicates the indent from the right edge of the screen. yunits - Units in
   * which the y value is specified. A value of fraction indicates the y value
   * is a fraction of the screen. A value of "pixels" indicates the y value in
   * pixels. A value of "insetPixels" indicates the indent from the top edge of
   * the screen.
   */
  protected Vec2 screenXY;
  /**
   * &lt;rotationxy&gt;
   * <p>
   * Point relative to the screen about which the screen overlay is rotated.
   */
  protected Vec2 rotationXY;
  /**
   * &lt;size&gt;
   * <p>
   * For example: Specifies the size of the image for the screen overlay, as
   * follows: A value of −1 indicates to use the native dimension A value of 0
   * indicates to maintain the aspect ratio A value of n sets the value of the
   * dimension To force the image to resize to 100px by 500px: To force the
   * image to retain its horizontal dimension, but to take up 20 percent of the
   * vertical screen space: To force the image to retain its original x and y
   * dimensions, set the values to −1: To force the image to retain its original
   * x and y dimensions, set the values to −1: &lt;size x="-1" y="-1"
   * xunits="fraction" yunits="fraction"/&gt; To force the image to retain its
   * horizontal dimension, but to take up 20 percent of the vertical screen
   * space: &lt;size x="-1" y="0.2" xunits="fraction" yunits="fraction"/&gt; To
   * force the image to resize to 100px by 500px: &lt;size x="100" y="500"
   * xunits="pixels" yunits="pixels"/&gt;
   */
  protected Vec2 size;
  /**
   * &lt;rotation&gt;
   * <p>
   * Adjusts how the photo is placed inside the field of view. This element is
   * useful if your photo has been rotated and deviates slightly from a desired
   * horizontal view. Indicates the angle of rotation of the parent object. A
   * value of 0 means no rotation. The value is an angle in degrees
   * counterclockwise starting from north. Use ±180 to indicate the rotation of
   * the parent object from 0. The center of the &lt;rotation&gt;, if not
   * (.5,.5), is specified in &lt;rotationXY&gt;.
   */
  @XmlElement(defaultValue = "0.0")
  protected double rotation;
  @XmlElement(name = "ScreenOverlaySimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> screenOverlaySimpleExtension;
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
  @XmlElement(name = "ScreenOverlayObjectExtensionGroup")
  protected List<AbstractObject> screenOverlayObjectExtension;

  public ScreenOverlay() {
    super();
  }

  /**
   * @see overlayXY
   *
   * @return possible object is {@code Vec2}
   *
   */
  public Vec2 getOverlayXY() {
    return overlayXY;
  }

  /**
   * @see overlayXY
   *
   * @param value allowed object is {@code Vec2}
   *
   */
  public void setOverlayXY(Vec2 value) {
    this.overlayXY = value;
  }

  /**
   * @see screenXY
   *
   * @return possible object is {@code Vec2}
   *
   */
  public Vec2 getScreenXY() {
    return screenXY;
  }

  /**
   * @see screenXY
   *
   * @param value allowed object is {@code Vec2}
   *
   */
  public void setScreenXY(Vec2 value) {
    this.screenXY = value;
  }

  /**
   * @see rotationXY
   *
   * @return possible object is {@code Vec2}
   *
   */
  public Vec2 getRotationXY() {
    return rotationXY;
  }

  /**
   * @see rotationXY
   *
   * @param value allowed object is {@code Vec2}
   *
   */
  public void setRotationXY(Vec2 value) {
    this.rotationXY = value;
  }

  /**
   * @see size
   *
   * @return possible object is {@code Vec2}
   *
   */
  public Vec2 getSize() {
    return size;
  }

  /**
   * @see size
   *
   * @param value allowed object is {@code Vec2}
   *
   */
  public void setSize(Vec2 value) {
    this.size = value;
  }

  /**
   * @see rotation
   *
   * @return possible object is {@code Double}
   *
   */
  public double getRotation() {
    return rotation;
  }

  /**
   * @see rotation
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setRotation(double value) {
    this.rotation = value;
  }

  /**
   * @see screenOverlaySimpleExtension
   *
   */
  public List<Object> getScreenOverlaySimpleExtension() {
    if (screenOverlaySimpleExtension == null) {
      screenOverlaySimpleExtension = new ArrayList<>();
    }
    return this.screenOverlaySimpleExtension;
  }

  /**
   * @see screenOverlayObjectExtension
   *
   */
  public List<AbstractObject> getScreenOverlayObjectExtension() {
    if (screenOverlayObjectExtension == null) {
      screenOverlayObjectExtension = new ArrayList<>();
    }
    return this.screenOverlayObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    result = ((prime * result) + ((overlayXY == null) ? 0 : overlayXY.hashCode()));
    result = ((prime * result) + ((screenXY == null) ? 0 : screenXY.hashCode()));
    result = ((prime * result) + ((rotationXY == null) ? 0 : rotationXY.hashCode()));
    result = ((prime * result) + ((size == null) ? 0 : size.hashCode()));
    temp = Double.doubleToLongBits(rotation);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((screenOverlaySimpleExtension == null) ? 0 : screenOverlaySimpleExtension.hashCode()));
    result = ((prime * result) + ((screenOverlayObjectExtension == null) ? 0 : screenOverlayObjectExtension.hashCode()));
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
    if ((obj instanceof ScreenOverlay) == false) {
      return false;
    }
    ScreenOverlay other = ((ScreenOverlay) obj);
    if (overlayXY == null) {
      if (other.overlayXY != null) {
        return false;
      }
    } else if (overlayXY.equals(other.overlayXY) == false) {
      return false;
    }
    if (screenXY == null) {
      if (other.screenXY != null) {
        return false;
      }
    } else if (screenXY.equals(other.screenXY) == false) {
      return false;
    }
    if (rotationXY == null) {
      if (other.rotationXY != null) {
        return false;
      }
    } else if (rotationXY.equals(other.rotationXY) == false) {
      return false;
    }
    if (size == null) {
      if (other.size != null) {
        return false;
      }
    } else if (size.equals(other.size) == false) {
      return false;
    }
    if (rotation != other.rotation) {
      return false;
    }
    if (screenOverlaySimpleExtension == null) {
      if (other.screenOverlaySimpleExtension != null) {
        return false;
      }
    } else if (screenOverlaySimpleExtension.equals(other.screenOverlaySimpleExtension) == false) {
      return false;
    }
    if (screenOverlayObjectExtension == null) {
      if (other.screenOverlayObjectExtension != null) {
        return false;
      }
    } else if (screenOverlayObjectExtension.equals(other.screenOverlayObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code Vec2} and set it to overlayXY.
   * <p>
   * This method is a short version for: &lt;code&gt; Vec2 vec2 = new Vec2();
   * this.setOverlayXY(vec2); &lt;/code&gt;
   */
  public Vec2 createAndSetOverlayXY() {
    Vec2 newValue = new Vec2();
    this.setOverlayXY(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Vec2} and set it to screenXY.
   * <p>
   * This method is a short version for: &lt;code&gt; Vec2 vec2 = new Vec2();
   * this.setScreenXY(vec2); &lt;/code&gt;
   */
  public Vec2 createAndSetScreenXY() {
    Vec2 newValue = new Vec2();
    this.setScreenXY(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Vec2} and set it to rotationXY.
   * <p>
   * This method is a short version for: &lt;code&gt; Vec2 vec2 = new Vec2();
   * this.setRotationXY(vec2); &lt;/code&gt;
   */
  public Vec2 createAndSetRotationXY() {
    Vec2 newValue = new Vec2();
    this.setRotationXY(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Vec2} and set it to size.
   * <p>
   * This method is a short version for: &lt;code&gt; Vec2 vec2 = new Vec2();
   * this.setSize(vec2); &lt;/code&gt;
   */
  public Vec2 createAndSetSize() {
    Vec2 newValue = new Vec2();
    this.setSize(newValue);
    return newValue;
  }

  /**
   * @see screenOverlaySimpleExtension
   *
   * @param screenOverlaySimpleExtension
   */
  public void setScreenOverlaySimpleExtension(final List<Object> screenOverlaySimpleExtension) {
    this.screenOverlaySimpleExtension = screenOverlaySimpleExtension;
  }

  /**
   * add a value to the screenOverlaySimpleExtension property collection
   *
   * @param screenOverlaySimpleExtension Objects of the following type are
   *                                     allowed in the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public ScreenOverlay addToScreenOverlaySimpleExtension(final Object screenOverlaySimpleExtension) {
    this.getScreenOverlaySimpleExtension().add(screenOverlaySimpleExtension);
    return this;
  }

  /**
   * @see screenOverlayObjectExtension
   *
   * @param screenOverlayObjectExtension
   */
  public void setScreenOverlayObjectExtension(final List<AbstractObject> screenOverlayObjectExtension) {
    this.screenOverlayObjectExtension = screenOverlayObjectExtension;
  }

  /**
   * add a value to the screenOverlayObjectExtension property collection
   *
   * @param screenOverlayObjectExtension Objects of the following type are
   *                                     allowed in the list:
   *                                     {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public ScreenOverlay addToScreenOverlayObjectExtension(final AbstractObject screenOverlayObjectExtension) {
    this.getScreenOverlayObjectExtension().add(screenOverlayObjectExtension);
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
  public ScreenOverlay addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public ScreenOverlay addToStyleSelector(final StyleSelector styleSelector) {
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
  public ScreenOverlay addToFeatureSimpleExtension(final Object featureSimpleExtension) {
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
  public ScreenOverlay addToFeatureObjectExtension(final AbstractObject featureObjectExtension) {
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
  public ScreenOverlay addToOverlaySimpleExtension(final Object overlaySimpleExtension) {
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
  public ScreenOverlay addToOverlayObjectExtension(final AbstractObject overlayObjectExtension) {
    super.getOverlayObjectExtension().add(overlayObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setOverlayXY(Vec2)
   *
   * @param overlayXY required parameter
   */
  public ScreenOverlay withOverlayXY(final Vec2 overlayXY) {
    this.setOverlayXY(overlayXY);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setScreenXY(Vec2)
   *
   * @param screenXY required parameter
   */
  public ScreenOverlay withScreenXY(final Vec2 screenXY) {
    this.setScreenXY(screenXY);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setRotationXY(Vec2)
   *
   * @param rotationXY required parameter
   */
  public ScreenOverlay withRotationXY(final Vec2 rotationXY) {
    this.setRotationXY(rotationXY);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSize(Vec2)
   *
   * @param size required parameter
   */
  public ScreenOverlay withSize(final Vec2 size) {
    this.setSize(size);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setRotation(double)
   *
   * @param rotation required parameter
   */
  public ScreenOverlay withRotation(final double rotation) {
    this.setRotation(rotation);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setScreenOverlaySimpleExtension(List &lt;Object&gt;)
   *
   * @param screenOverlaySimpleExtension required parameter
   */
  public ScreenOverlay withScreenOverlaySimpleExtension(final List<Object> screenOverlaySimpleExtension) {
    this.setScreenOverlaySimpleExtension(screenOverlaySimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setScreenOverlayObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param screenOverlayObjectExtension required parameter
   */
  public ScreenOverlay withScreenOverlayObjectExtension(final List<AbstractObject> screenOverlayObjectExtension) {
    this.setScreenOverlayObjectExtension(screenOverlayObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withName(final String name) {
    super.withName(name);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withVisibility(final Boolean visibility) {
    super.withVisibility(visibility);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withOpen(final Boolean open) {
    super.withOpen(open);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withAtomAuthor(final Author atomAuthor) {
    super.withAtomAuthor(atomAuthor);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withAtomLink(final Link atomLink) {
    super.withAtomLink(atomLink);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withAddress(final String address) {
    super.withAddress(address);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withXalAddressDetails(final AddressDetails xalAddressDetails) {
    super.withXalAddressDetails(xalAddressDetails);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withPhoneNumber(final String phoneNumber) {
    super.withPhoneNumber(phoneNumber);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withSnippet(final Snippet snippet) {
    super.withSnippet(snippet);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withSnippetd(final String snippetd) {
    super.withSnippetd(snippetd);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withDescription(final String description) {
    super.withDescription(description);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withAbstractView(final AbstractView abstractView) {
    super.withAbstractView(abstractView);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withTimePrimitive(final TimePrimitive timePrimitive) {
    super.withTimePrimitive(timePrimitive);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withStyleUrl(final String styleUrl) {
    super.withStyleUrl(styleUrl);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withStyleSelector(final List<StyleSelector> styleSelector) {
    super.withStyleSelector(styleSelector);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withRegion(final Region region) {
    super.withRegion(region);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withMetadata(final Metadata metadata) {
    super.withMetadata(metadata);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withExtendedData(final ExtendedData extendedData) {
    super.withExtendedData(extendedData);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.withFeatureSimpleExtension(featureSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.withFeatureObjectExtension(featureObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withColor(final String color) {
    super.withColor(color);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withDrawOrder(final int drawOrder) {
    super.withDrawOrder(drawOrder);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withIcon(final Icon icon) {
    super.withIcon(icon);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withOverlaySimpleExtension(final List<Object> overlaySimpleExtension) {
    super.withOverlaySimpleExtension(overlaySimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public ScreenOverlay withOverlayObjectExtension(final List<AbstractObject> overlayObjectExtension) {
    super.withOverlayObjectExtension(overlayObjectExtension);
    return this;
  }

  @Override
  public ScreenOverlay clone() {
    ScreenOverlay copy;
    copy = ((ScreenOverlay) super.clone());
    copy.overlayXY = ((overlayXY == null) ? null : ((Vec2) overlayXY.clone()));
    copy.screenXY = ((screenXY == null) ? null : ((Vec2) screenXY.clone()));
    copy.rotationXY = ((rotationXY == null) ? null : ((Vec2) rotationXY.clone()));
    copy.size = ((size == null) ? null : ((Vec2) size.clone()));
    copy.screenOverlaySimpleExtension = new ArrayList<>((getScreenOverlaySimpleExtension().size()));
    for (Object iter : screenOverlaySimpleExtension) {
      copy.screenOverlaySimpleExtension.add(iter);
    }
    copy.screenOverlayObjectExtension = new ArrayList<>((getScreenOverlayObjectExtension().size()));
    for (AbstractObject iter : screenOverlayObjectExtension) {
      copy.screenOverlayObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
