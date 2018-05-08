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
 * &lt;IconStyle&gt;
 * <p>
 * Specifies how icons for point Placemarks are drawn, both in the Places panel
 * and in the 3D viewer of Google Earth. The &lt;Icon&gt; element specifies the
 * icon image. The &lt;scale&gt; element specifies the x, y scaling of the icon.
 * The color specified in the &lt;color&gt; element of &lt;IconStyle&gt; is
 * blended with the color of the &lt;Icon&gt;. Syntax: &lt;pre&gt;
 * &lt;strong&gt;&lt;IconStyle id="ID"&gt; &lt;/strong&gt; &lt;!-- inherited
 * from &lt;em&gt;ColorStyle &lt;/em&gt; --&gt;
 * &lt;color&gt;ffffffff&lt;/color&gt; &lt;!-- kml:color --&gt;
 * &lt;colorMode&gt;normal&lt;/colorMode&gt; &lt;!-- kml:colorModeEnum:normal
 * &lt;em&gt;or &lt;/em&gt; random --&gt;
 * <p>
 * &lt;!-- specific to IconStyle --&gt; &lt;scale&gt;1&lt;/scale&gt; &lt;!--
 * float --&gt; &lt;heading&gt;0&lt;/heading&gt; &lt;!-- float --&gt;
 * &lt;Icon&gt; &lt;href&gt;...&lt;/href&gt; &lt;/Icon&gt; &lt;hotSpot x="0.5"
 * y="0.5" xunits="fraction" yunits="fraction"/&gt; &lt;!-- kml:vec2 --&gt;
 * &lt;strong&gt;&lt;/IconStyle&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;ColorStyle&gt;
 *
 * Contains:
 * @see: &lt;Icon&gt;
 * @see: &lt;href&gt;
 *
 * Contained By:
 * @see: &lt;Style&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IconStyleType", propOrder = {
  "scale",
  "heading",
  "icon",
  "hotSpot",
  "iconStyleSimpleExtension",
  "iconStyleObjectExtension"
})
@XmlRootElement(name = "IconStyle", namespace = "http://www.opengis.net/kml/2.2")
public class IconStyle
  extends ColorStyle
  implements Cloneable {

  /**
   * &lt;scale&gt;
   * <p>
   * Note: The &lt;geomScale&gt; tag has been deprecated. Use &lt;scale&gt;
   * instead. Resizes the icon. Scales a model along the x, y, and z axes in the
   * model's coordinate space. &lt;Scale&gt; &lt;x&gt;2.5 &lt;/x&gt;
   * &lt;y&gt;2.5 &lt;/y&gt; &lt;z&gt;3.5 &lt;/z&gt; &lt;/Scale&gt;
   */
  @XmlElement(defaultValue = "1.0")
  protected double scale;
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
   * &lt;icon&gt; see also &lt;icon&gt;.
   * <p>
   * &lt;Icon&gt; &lt;href&gt;Sunset.jpg &lt;/href&gt; &lt;/Icon&gt; A custom
   * Icon. In &lt;IconStyle&gt;, the only child element of &lt;Icon&gt; is
   * &lt;href&gt;: &lt;href&gt;: An HTTP address or a local file specification
   * used to load an icon. Defines an image associated with an Icon style or
   * overlay. &lt;Icon&gt; has the same child elements as &lt;Link&gt;. The
   * required &lt;href&gt; child element defines the location of the image to be
   * used as the overlay or as the icon for the placemark. This location can
   * either be on a local file system or a remote web server. Defines the image
   * associated with the Overlay. The &lt;href&gt; element defines the location
   * of the image to be used as the Overlay. This location can be either on a
   * local file system or on a web server. If this element is omitted or
   * contains no &lt;href&gt;, a rectangle is drawn using the color and size
   * defined by the ground or screen overlay. &lt;Icon&gt; &lt;href&gt;icon.jpg
   * &lt;/href&gt; &lt;/Icon&gt; Syntax: &lt;pre&gt; &lt;strong&gt;&lt;Icon
   * id="ID"&gt; &lt;/strong&gt; &lt;!-- specific to Icon --&gt; &lt;href&gt;
   * &lt;em&gt;... &lt;/em&gt;&lt;/href&gt; &lt;!-- anyURI --&gt;
   * &lt;refreshMode&gt;onChange&lt;/refreshMode&gt; &lt;!--
   * kml:refreshModeEnum: onChange, onInterval, &lt;em&gt;or &lt;/em&gt;
   * onExpire --&gt; &lt;refreshInterval&gt;4&lt;/refreshInterval&gt; &lt;!--
   * float --&gt; &lt;viewRefreshMode&gt;never&lt;/viewRefreshMode&gt; &lt;!--
   * kml:viewRefreshModeEnum: never, onStop, onRequest, onRegion --&gt;
   * &lt;viewRefreshTime&gt;4&lt;/viewRefreshTime&gt; &lt;!-- float --&gt;
   * &lt;viewBoundScale&gt;1&lt;/viewBoundScale&gt; &lt;!-- float --&gt;
   * &lt;viewFormat&gt;...&lt;/viewFormat&gt; &lt;!-- string --&gt;
   * &lt;httpQuery&gt;...&lt;/httpQuery&gt; &lt;!-- string --&gt;
   * &lt;strong&gt;&lt;/Icon&gt; &lt;/strong&gt; </pre>
   * <p>
   * Contained By:
   *
   * @see: &lt;GroundOverlay&gt;
   * @see: &lt;IconStyle&gt;
   * @see: &lt;ScreenOverlay&gt;
   *
   */
  @XmlElement(name = "Icon")
  protected Icon icon;
  /**
   * &lt;hotspot x="0.5" y="0.5" xunits="fraction" yunits="fraction"&gt;
   * <p>
   * Specifies the position within the Icon that is "anchored" to the
   * &lt;Point&gt; specified in the Placemark. The x and y values can be
   * specified in three different ways: as pixels ("pixels"), as fractions of
   * the icon ("fraction"), or as inset pixels ("insetPixels"), which is an
   * offset in pixels from the upper right corner of the icon. The x and y
   * positions can be specified in different ways—for example, x can be in
   * pixels and y can be a fraction. The origin of the coordinate system is in
   * the lower left corner of the icon. x - Either the number of pixels, a
   * fractional component of the icon, or a pixel inset indicating the x
   * component of a point on the icon. y - Either the number of pixels, a
   * fractional component of the icon, or a pixel inset indicating the y
   * component of a point on the icon. xunits - Units in which the x value is
   * specified. A value of fraction indicates the x value is a fraction of the
   * icon. A value of pixels indicates the x value in pixels. A value of
   * insetPixels indicates the indent from the right edge of the icon. yunits -
   * Units in which the y value is specified. A value of fraction indicates the
   * y value is a fraction of the icon. A value of pixels indicates the y value
   * in pixels. A value of insetPixels indicates the indent from the top edge of
   * the icon.
   */
  protected Vec2 hotSpot;
  @XmlElement(name = "IconStyleSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> iconStyleSimpleExtension;
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
  @XmlElement(name = "IconStyleObjectExtensionGroup")
  protected List<AbstractObject> iconStyleObjectExtension;

  public IconStyle() {
    super();
  }

  /**
   * @see scale
   *
   * @return possible object is {@link Double}
   *
   */
  public double getScale() {
    return scale;
  }

  /**
   * @see scale
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setScale(double value) {
    this.scale = value;
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
   * @see icon
   *
   * @return possible object is {@link BasicLink}
   *
   */
  public Icon getIcon() {
    return icon;
  }

  /**
   * @see icon
   *
   * @param value allowed object is {@link BasicLink}
   *
   */
  public void setIcon(Icon value) {
    this.icon = value;
  }

  /**
   * @see hotSpot
   *
   * @return possible object is {@link Vec2}
   *
   */
  public Vec2 getHotSpot() {
    return hotSpot;
  }

  /**
   * @see hotSpot
   *
   * @param value allowed object is {@link Vec2}
   *
   */
  public void setHotSpot(Vec2 value) {
    this.hotSpot = value;
  }

  /**
   * @see iconStyleSimpleExtension
   *
   */
  public List<Object> getIconStyleSimpleExtension() {
    if (iconStyleSimpleExtension == null) {
      iconStyleSimpleExtension = new ArrayList<>();
    }
    return this.iconStyleSimpleExtension;
  }

  /**
   * @see iconStyleObjectExtension
   *
   */
  public List<AbstractObject> getIconStyleObjectExtension() {
    if (iconStyleObjectExtension == null) {
      iconStyleObjectExtension = new ArrayList<>();
    }
    return this.iconStyleObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(scale);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(heading);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((icon == null) ? 0 : icon.hashCode()));
    result = ((prime * result) + ((hotSpot == null) ? 0 : hotSpot.hashCode()));
    result = ((prime * result) + ((iconStyleSimpleExtension == null) ? 0 : iconStyleSimpleExtension.hashCode()));
    result = ((prime * result) + ((iconStyleObjectExtension == null) ? 0 : iconStyleObjectExtension.hashCode()));
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
    if ((obj instanceof IconStyle) == false) {
      return false;
    }
    IconStyle other = ((IconStyle) obj);
    if (scale != other.scale) {
      return false;
    }
    if (heading != other.heading) {
      return false;
    }
    if (icon == null) {
      if (other.icon != null) {
        return false;
      }
    } else if (icon.equals(other.icon) == false) {
      return false;
    }
    if (hotSpot == null) {
      if (other.hotSpot != null) {
        return false;
      }
    } else if (hotSpot.equals(other.hotSpot) == false) {
      return false;
    }
    if (iconStyleSimpleExtension == null) {
      if (other.iconStyleSimpleExtension != null) {
        return false;
      }
    } else if (iconStyleSimpleExtension.equals(other.iconStyleSimpleExtension) == false) {
      return false;
    }
    if (iconStyleObjectExtension == null) {
      if (other.iconStyleObjectExtension != null) {
        return false;
      }
    } else if (iconStyleObjectExtension.equals(other.iconStyleObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link Icon} and set it to icon.
   * <p>
   * This method is a short version for: &lt;code&gt; Icon icon = new Icon();
   * this.setIcon(icon); &lt;/code&gt;
   */
  public Icon createAndSetIcon() {
    Icon newValue = new Icon();
    this.setIcon(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Vec2} and set it to hotSpot.
   * <p>
   * This method is a short version for: &lt;code&gt; Vec2 vec2 = new Vec2();
   * this.setHotSpot(vec2); &lt;/code&gt;
   */
  public Vec2 createAndSetHotSpot() {
    Vec2 newValue = new Vec2();
    this.setHotSpot(newValue);
    return newValue;
  }

  /**
   * @see iconStyleSimpleExtension
   *
   * @param iconStyleSimpleExtension
   */
  public void setIconStyleSimpleExtension(final List<Object> iconStyleSimpleExtension) {
    this.iconStyleSimpleExtension = iconStyleSimpleExtension;
  }

  /**
   * add a value to the iconStyleSimpleExtension property collection
   *
   * @param iconStyleSimpleExtension Objects of the following type are allowed
   *                                 in the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public IconStyle addToIconStyleSimpleExtension(final Object iconStyleSimpleExtension) {
    this.getIconStyleSimpleExtension().add(iconStyleSimpleExtension);
    return this;
  }

  /**
   * @see iconStyleObjectExtension
   *
   * @param iconStyleObjectExtension
   */
  public void setIconStyleObjectExtension(final List<AbstractObject> iconStyleObjectExtension) {
    this.iconStyleObjectExtension = iconStyleObjectExtension;
  }

  /**
   * add a value to the iconStyleObjectExtension property collection
   *
   * @param iconStyleObjectExtension Objects of the following type are allowed
   *                                 in the list: {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public IconStyle addToIconStyleObjectExtension(final AbstractObject iconStyleObjectExtension) {
    this.getIconStyleObjectExtension().add(iconStyleObjectExtension);
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
  public IconStyle addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * @see subStyleSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setSubStyleSimpleExtension(final List<Object> subStyleSimpleExtension) {
    super.setSubStyleSimpleExtension(subStyleSimpleExtension);
  }

  @Obvious
  @Override
  public IconStyle addToSubStyleSimpleExtension(final Object subStyleSimpleExtension) {
    super.getSubStyleSimpleExtension().add(subStyleSimpleExtension);
    return this;
  }

  /**
   * @see subStyleObjectExtension
   *
   */
  @Obvious
  @Override
  public void setSubStyleObjectExtension(final List<AbstractObject> subStyleObjectExtension) {
    super.setSubStyleObjectExtension(subStyleObjectExtension);
  }

  @Obvious
  @Override
  public IconStyle addToSubStyleObjectExtension(final AbstractObject subStyleObjectExtension) {
    super.getSubStyleObjectExtension().add(subStyleObjectExtension);
    return this;
  }

  /**
   * @see colorStyleSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setColorStyleSimpleExtension(final List<Object> colorStyleSimpleExtension) {
    super.setColorStyleSimpleExtension(colorStyleSimpleExtension);
  }

  @Obvious
  @Override
  public IconStyle addToColorStyleSimpleExtension(final Object colorStyleSimpleExtension) {
    super.getColorStyleSimpleExtension().add(colorStyleSimpleExtension);
    return this;
  }

  /**
   * @see colorStyleObjectExtension
   *
   */
  @Obvious
  @Override
  public void setColorStyleObjectExtension(final List<AbstractObject> colorStyleObjectExtension) {
    super.setColorStyleObjectExtension(colorStyleObjectExtension);
  }

  @Obvious
  @Override
  public IconStyle addToColorStyleObjectExtension(final AbstractObject colorStyleObjectExtension) {
    super.getColorStyleObjectExtension().add(colorStyleObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setScale(double)
   *
   * @param scale required parameter
   */
  public IconStyle withScale(final double scale) {
    this.setScale(scale);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setHeading(double)
   *
   * @param heading required parameter
   */
  public IconStyle withHeading(final double heading) {
    this.setHeading(heading);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setIcon(Icon)
   *
   * @param icon required parameter
   */
  public IconStyle withIcon(final Icon icon) {
    this.setIcon(icon);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setHotSpot(Vec2)
   *
   * @param hotSpot required parameter
   */
  public IconStyle withHotSpot(final Vec2 hotSpot) {
    this.setHotSpot(hotSpot);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setIconStyleSimpleExtension(List &lt;Object&gt;)
   *
   * @param iconStyleSimpleExtension required parameter
   */
  public IconStyle withIconStyleSimpleExtension(final List<Object> iconStyleSimpleExtension) {
    this.setIconStyleSimpleExtension(iconStyleSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setIconStyleObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param iconStyleObjectExtension required parameter
   */
  public IconStyle withIconStyleObjectExtension(final List<AbstractObject> iconStyleObjectExtension) {
    this.setIconStyleObjectExtension(iconStyleObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public IconStyle withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public IconStyle withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public IconStyle withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public IconStyle withSubStyleSimpleExtension(final List<Object> subStyleSimpleExtension) {
    super.withSubStyleSimpleExtension(subStyleSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public IconStyle withSubStyleObjectExtension(final List<AbstractObject> subStyleObjectExtension) {
    super.withSubStyleObjectExtension(subStyleObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public IconStyle withColor(final String color) {
    super.withColor(color);
    return this;
  }

  @Obvious
  @Override
  public IconStyle withColorMode(final ColorMode colorMode) {
    super.withColorMode(colorMode);
    return this;
  }

  @Obvious
  @Override
  public IconStyle withColorStyleSimpleExtension(final List<Object> colorStyleSimpleExtension) {
    super.withColorStyleSimpleExtension(colorStyleSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public IconStyle withColorStyleObjectExtension(final List<AbstractObject> colorStyleObjectExtension) {
    super.withColorStyleObjectExtension(colorStyleObjectExtension);
    return this;
  }

  @Override
  public IconStyle clone() {
    IconStyle copy;
    copy = ((IconStyle) super.clone());
    copy.icon = ((icon == null) ? null : ((Icon) icon.clone()));
    copy.hotSpot = ((hotSpot == null) ? null : ((Vec2) hotSpot.clone()));
    copy.iconStyleSimpleExtension = new ArrayList<>((getIconStyleSimpleExtension().size()));
    for (Object iter : iconStyleSimpleExtension) {
      copy.iconStyleSimpleExtension.add(iter);
    }
    copy.iconStyleObjectExtension = new ArrayList<>((getIconStyleObjectExtension().size()));
    for (AbstractObject iter : iconStyleObjectExtension) {
      copy.iconStyleObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
