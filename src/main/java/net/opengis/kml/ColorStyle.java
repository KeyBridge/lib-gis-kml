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
 * &lt;ColorStyle&gt;
 * <p>
 * This is an abstract element and cannot be used directly in a KML file. It
 * provides elements for specifying the color and color mode of extended style
 * types. Syntax:
 * <pre>&lt;!-- abstract element; do not create --&gt;
 *  &lt;strong&gt;&lt;! &lt;em&gt;-- ColorStyle &lt;/em&gt; id="ID" --&gt; &lt;/strong&gt;          &lt;!-- IconStyle,LabelStyle,LineStyle,PolyStyle --&gt;
 *   &lt;color&gt;ffffffff&lt;/color&gt;            &lt;!-- kml:color --&gt;
 *   &lt;colorMode&gt;normal&lt;/colorMode&gt;      &lt;!-- kml:colorModeEnum: normal  &lt;em&gt;or &lt;/em&gt; random --&gt;
 *  &lt;strong&gt;&lt;!-- / &lt;em&gt;ColorStyle &lt;/em&gt; --&gt; &lt;/strong&gt;
 * </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Object&gt;
 *
 * Extended By:
 * @see: &lt;IconStyle&gt;
 * @see: &lt;LabelStyle&gt;
 * @see: &lt;LineStyle&gt;
 * @see: PolyStyle
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractColorStyleType", propOrder = {
  "color",
  "colorMode",
  "colorStyleSimpleExtension",
  "colorStyleObjectExtension"
})
@XmlSeeAlso({
  IconStyle.class,
  LabelStyle.class,
  LineStyle.class,
  PolyStyle.class
})
public abstract class ColorStyle
  extends SubStyle
  implements Cloneable {

  /**
   * &lt;color&gt;
   * <p>
   * Color and opacity (alpha) values are expressed in hexadecimal notation. The
   * range of values for any one color is 0 to 255 (00 to ff). For alpha, 00 is
   * fully transparent and ff is fully opaque. The order of expression is
   * aabbggrr, where aa=alpha (00 to ff); bb=blue (00 to ff); gg=green (00 to
   * ff); rr=red (00 to ff). For example, if you want to apply a blue color with
   * 50 percent opacity to an overlay, you would specify the following:
   * &lt;color&gt;7fff0000 &lt;/color&gt;, where alpha=0x7f, blue=0xff,
   * green=0x00, and red=0x00. Color values are expressed in hexadecimal
   * notation, including opacity (alpha) values. The order of expression is
   * alpha, blue, green, red (aabbggrr). The range of values for any one color
   * is 0 to 255 (00 to ff). For opacity, 00 is fully transparent and ff is
   * fully opaque. For example, if you want to apply a blue color with 50
   * percent opacity to an overlay, you would specify the following:
   * &lt;color&gt;7fff0000 &lt;/color&gt; Note: The &lt;geomColor&gt; element
   * has been deprecated. Use &lt;color&gt; instead.
   */
  @XmlElement(defaultValue = "ffffffff")

  protected String color;
  /**
   * ColorMode
   * <p>
   * normal, random See Also: See any element that extends &lt;ColorStyle&gt;
   * <p>
   */
  @XmlElement(defaultValue = "normal")
  protected ColorMode colorMode;
  @XmlElement(name = "AbstractColorStyleSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> colorStyleSimpleExtension;
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
  @XmlElement(name = "AbstractColorStyleObjectExtensionGroup")
  protected List<AbstractObject> colorStyleObjectExtension;

  public ColorStyle() {
    super();
  }

  /**
   * @see color
   *
   * @return possible object is {@link String}
   *
   */
  public String getColor() {
    return color;
  }

  /**
   * @see color
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setColor(String value) {
    this.color = value;
  }

  /**
   * @see colorMode
   *
   * @return possible object is {@link ColorMode}
   *
   */
  public ColorMode getColorMode() {
    return colorMode;
  }

  /**
   * @see colorMode
   *
   * @param value allowed object is {@link ColorMode}
   *
   */
  public void setColorMode(ColorMode value) {
    this.colorMode = value;
  }

  /**
   * @see colorStyleSimpleExtension
   *
   */
  public List<Object> getColorStyleSimpleExtension() {
    if (colorStyleSimpleExtension == null) {
      colorStyleSimpleExtension = new ArrayList<>();
    }
    return this.colorStyleSimpleExtension;
  }

  /**
   * @see colorStyleObjectExtension
   *
   */
  public List<AbstractObject> getColorStyleObjectExtension() {
    if (colorStyleObjectExtension == null) {
      colorStyleObjectExtension = new ArrayList<>();
    }
    return this.colorStyleObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((color == null) ? 0 : color.hashCode()));
    result = ((prime * result) + ((colorMode == null) ? 0 : colorMode.hashCode()));
    result = ((prime * result) + ((colorStyleSimpleExtension == null) ? 0 : colorStyleSimpleExtension.hashCode()));
    result = ((prime * result) + ((colorStyleObjectExtension == null) ? 0 : colorStyleObjectExtension.hashCode()));
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
    if ((obj instanceof ColorStyle) == false) {
      return false;
    }
    ColorStyle other = ((ColorStyle) obj);
    if (color == null) {
      if (other.color != null) {
        return false;
      }
    } else if (color.equals(other.color) == false) {
      return false;
    }
    if (colorMode == null) {
      if (other.colorMode != null) {
        return false;
      }
    } else if (colorMode.equals(other.colorMode) == false) {
      return false;
    }
    if (colorStyleSimpleExtension == null) {
      if (other.colorStyleSimpleExtension != null) {
        return false;
      }
    } else if (colorStyleSimpleExtension.equals(other.colorStyleSimpleExtension) == false) {
      return false;
    }
    if (colorStyleObjectExtension == null) {
      if (other.colorStyleObjectExtension != null) {
        return false;
      }
    } else if (colorStyleObjectExtension.equals(other.colorStyleObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see colorStyleSimpleExtension
   *
   * @param colorStyleSimpleExtension
   */
  public void setColorStyleSimpleExtension(final List<Object> colorStyleSimpleExtension) {
    this.colorStyleSimpleExtension = colorStyleSimpleExtension;
  }

  /**
   * add a value to the colorStyleSimpleExtension property collection
   *
   * @param colorStyleSimpleExtension Objects of the following type are allowed
   *                                  in the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public ColorStyle addToColorStyleSimpleExtension(final Object colorStyleSimpleExtension) {
    this.getColorStyleSimpleExtension().add(colorStyleSimpleExtension);
    return this;
  }

  /**
   * @see colorStyleObjectExtension
   *
   * @param colorStyleObjectExtension
   */
  public void setColorStyleObjectExtension(final List<AbstractObject> colorStyleObjectExtension) {
    this.colorStyleObjectExtension = colorStyleObjectExtension;
  }

  /**
   * add a value to the colorStyleObjectExtension property collection
   *
   * @param colorStyleObjectExtension Objects of the following type are allowed
   *                                  in the list: {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public ColorStyle addToColorStyleObjectExtension(final AbstractObject colorStyleObjectExtension) {
    this.getColorStyleObjectExtension().add(colorStyleObjectExtension);
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
  public ColorStyle addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public ColorStyle addToSubStyleSimpleExtension(final Object subStyleSimpleExtension) {
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
  public ColorStyle addToSubStyleObjectExtension(final AbstractObject subStyleObjectExtension) {
    super.getSubStyleObjectExtension().add(subStyleObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setColor(String)
   *
   * @param color required parameter
   */
  public ColorStyle withColor(final String color) {
    this.setColor(color);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setColorMode(ColorMode)
   *
   * @param colorMode required parameter
   */
  public ColorStyle withColorMode(final ColorMode colorMode) {
    this.setColorMode(colorMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setColorStyleSimpleExtension(List &lt;Object&gt;)
   *
   * @param colorStyleSimpleExtension required parameter
   */
  public ColorStyle withColorStyleSimpleExtension(final List<Object> colorStyleSimpleExtension) {
    this.setColorStyleSimpleExtension(colorStyleSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setColorStyleObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param colorStyleObjectExtension required parameter
   */
  public ColorStyle withColorStyleObjectExtension(final List<AbstractObject> colorStyleObjectExtension) {
    this.setColorStyleObjectExtension(colorStyleObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public ColorStyle withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public ColorStyle withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public ColorStyle withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public ColorStyle withSubStyleSimpleExtension(final List<Object> subStyleSimpleExtension) {
    super.withSubStyleSimpleExtension(subStyleSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public ColorStyle withSubStyleObjectExtension(final List<AbstractObject> subStyleObjectExtension) {
    super.withSubStyleObjectExtension(subStyleObjectExtension);
    return this;
  }

  @Override
  public ColorStyle clone() {
    ColorStyle copy;
    copy = ((ColorStyle) super.clone());
    copy.colorStyleSimpleExtension = new ArrayList<>((getColorStyleSimpleExtension().size()));
    for (Object iter : colorStyleSimpleExtension) {
      copy.colorStyleSimpleExtension.add(iter);
    }
    copy.colorStyleObjectExtension = new ArrayList<>((getColorStyleObjectExtension().size()));
    for (AbstractObject iter : colorStyleObjectExtension) {
      copy.colorStyleObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
