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
 * &lt;BalloonStyle&gt;
 * <p>
 * Specifies how the description balloon for placemarks is drawn. The
 * &lt;bgColor&gt;, if specified, is used as the background color of the
 * balloon. See &lt;Feature&gt; for a diagram illustrating how the default
 * description balloon appears in Google Earth. Syntax: &lt;pre&gt;
 * &lt;strong&gt;&lt;BalloonStyle id="ID"&gt; &lt;/strong&gt; &lt;!-- specific
 * to BalloonStyle --&gt; &lt;bgColor&gt;ffffffff&lt;/bgColor&gt; &lt;!--
 * kml:color --&gt; &lt;textColor&gt;ff000000&lt;/textColor&gt; &lt;!--
 * kml:color --&gt; &lt;text&gt; &lt;em&gt;... &lt;/em&gt;&lt;/text&gt; &lt;!--
 * string --&gt; &lt;span&gt;&lt;displayMode&gt;default&lt;/displayMode&gt;
 * &lt;strong&gt; &lt;/strong&gt;&lt;!-- kml:displayModeEnum --&gt;
 * &lt;/span&gt; &lt;strong&gt; &lt;/BalloonStyle&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;ColorStyle&gt;
 *
 * Contained By:
 * @see: &lt;Style&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalloonStyleType", propOrder = {
  "color",
  "bgColor",
  "textColor",
  "text",
  "displayMode",
  "balloonStyleSimpleExtension",
  "balloonStyleObjectExtension"
})
@XmlRootElement(name = "BalloonStyle", namespace = "http://www.opengis.net/kml/2.2")
public class BalloonStyle
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

  @Deprecated
  protected String color;
  /**
   * &lt;bgcolor&gt;
   * <p>
   * Background color for the Snippet. Color and opacity values are expressed in
   * hexadecimal notation. The range of values for any one color is 0 to 255 (00
   * to ff). For alpha, 00 is fully transparent and ff is fully opaque. The
   * order of expression is aabbggrr, where aa=alpha (00 to ff); bb=blue (00 to
   * ff); gg=green (00 to ff); rr=red (00 to ff). For example, if you want to
   * apply a blue color with 50 percent opacity to an overlay, you would specify
   * the following: &lt;color&gt;7fff0000 &lt;/color&gt;, where alpha=0x7f,
   * blue=0xff, green=0x00, and red=0x00. Background color of the balloon
   * (optional). Color and opacity (alpha) values are expressed in hexadecimal
   * notation. The range of values for any one color is 0 to 255 (00 to ff). The
   * order of expression is aabbggrr, where aa=alpha (00 to ff); bb=blue (00 to
   * ff); gg=green (00 to ff); rr=red (00 to ff). For alpha, 00 is fully
   * transparent and ff is fully opaque. For example, if you want to apply a
   * blue color with 50 percent opacity to an overlay, you would specify the
   * following: &lt;bgColor&gt;7fff0000 &lt;/bgColor&gt;, where alpha=0x7f,
   * blue=0xff, green=0x00, and red=0x00. The default is opaque white
   * (ffffffff). Note: The use of the &lt;color&gt; element within
   * &lt;BalloonStyle&gt; has been deprecated. Use &lt;bgColor&gt; instead.
   */
  @XmlElement(defaultValue = "ffffffff")

  protected String bgColor;
  /**
   * &lt;textcolor&gt;
   * <p>
   * Foreground color for text. The default is black (ff000000).
   */
  @XmlElement(defaultValue = "ff000000")

  protected String textColor;
  /**
   * &lt;text&gt;
   * <p>
   * For example, in the following KML excerpt, $[name] and $[description]
   * fields will be replaced by the &lt;name&gt; and &lt;description&gt; fields
   * found in the Feature elements that use this BalloonStyle: &lt;text&gt;This
   * is $[name], whose description is: &lt;br/&gt;$[description] &lt;/text&gt;
   * Text displayed in the balloon. If no text is specified, Google Earth draws
   * the default balloon (with the Feature &lt;name&gt; in boldface, the Feature
   * &lt;description&gt;, links for driving directions, a white background, and
   * a tail that is attached to the point coordinates of the Feature, if
   * specified). You can add entities to the &lt;text&gt; tag using the
   * following format to refer to a child element of Feature: $[name],
   * $[description], $[address], $[id], $[Snippet]. Google Earth looks in the
   * current Feature for the corresponding string entity and substitutes that
   * information in the balloon. To include To here - From here driving
   * directions in the balloon, use the $[geDirections] tag. To prevent the
   * driving directions links from appearing in a balloon, include the
   * &lt;text&gt; element with some content, or with $[description] to
   * substitute the basic Feature &lt;description&gt;.
   */
  protected String text;
  /**
   * DisplayMode
   * <p>
   * default, hide See Also: See &lt;BalloonStyle&gt;
   * <p>
   */
  @XmlElement(defaultValue = "default")
  protected DisplayMode displayMode;
  @XmlElement(name = "BalloonStyleSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> balloonStyleSimpleExtension;
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
  @XmlElement(name = "BalloonStyleObjectExtensionGroup")
  protected List<AbstractObject> balloonStyleObjectExtension;

  public BalloonStyle() {
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
   * @see bgColor
   *
   * @return possible object is {@link String}
   *
   */
  public String getBgColor() {
    return bgColor;
  }

  /**
   * @see bgColor
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setBgColor(String value) {
    this.bgColor = value;
  }

  /**
   * @see textColor
   *
   * @return possible object is {@link String}
   *
   */
  public String getTextColor() {
    return textColor;
  }

  /**
   * @see textColor
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setTextColor(String value) {
    this.textColor = value;
  }

  /**
   * @see text
   *
   * @return possible object is {@link String}
   *
   */
  public String getText() {
    return text;
  }

  /**
   * @see text
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setText(String value) {
    this.text = value;
  }

  /**
   * @see displayMode
   *
   * @return possible object is {@link DisplayMode}
   *
   */
  public DisplayMode getDisplayMode() {
    return displayMode;
  }

  /**
   * @see displayMode
   *
   * @param value allowed object is {@link DisplayMode}
   *
   */
  public void setDisplayMode(DisplayMode value) {
    this.displayMode = value;
  }

  /**
   * @see balloonStyleSimpleExtension
   *
   */
  public List<Object> getBalloonStyleSimpleExtension() {
    if (balloonStyleSimpleExtension == null) {
      balloonStyleSimpleExtension = new ArrayList<>();
    }
    return this.balloonStyleSimpleExtension;
  }

  /**
   * @see balloonStyleObjectExtension
   *
   */
  public List<AbstractObject> getBalloonStyleObjectExtension() {
    if (balloonStyleObjectExtension == null) {
      balloonStyleObjectExtension = new ArrayList<>();
    }
    return this.balloonStyleObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((color == null) ? 0 : color.hashCode()));
    result = ((prime * result) + ((bgColor == null) ? 0 : bgColor.hashCode()));
    result = ((prime * result) + ((textColor == null) ? 0 : textColor.hashCode()));
    result = ((prime * result) + ((text == null) ? 0 : text.hashCode()));
    result = ((prime * result) + ((displayMode == null) ? 0 : displayMode.hashCode()));
    result = ((prime * result) + ((balloonStyleSimpleExtension == null) ? 0 : balloonStyleSimpleExtension.hashCode()));
    result = ((prime * result) + ((balloonStyleObjectExtension == null) ? 0 : balloonStyleObjectExtension.hashCode()));
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
    if ((obj instanceof BalloonStyle) == false) {
      return false;
    }
    BalloonStyle other = ((BalloonStyle) obj);
    if (color == null) {
      if (other.color != null) {
        return false;
      }
    } else if (color.equals(other.color) == false) {
      return false;
    }
    if (bgColor == null) {
      if (other.bgColor != null) {
        return false;
      }
    } else if (bgColor.equals(other.bgColor) == false) {
      return false;
    }
    if (textColor == null) {
      if (other.textColor != null) {
        return false;
      }
    } else if (textColor.equals(other.textColor) == false) {
      return false;
    }
    if (text == null) {
      if (other.text != null) {
        return false;
      }
    } else if (text.equals(other.text) == false) {
      return false;
    }
    if (displayMode == null) {
      if (other.displayMode != null) {
        return false;
      }
    } else if (displayMode.equals(other.displayMode) == false) {
      return false;
    }
    if (balloonStyleSimpleExtension == null) {
      if (other.balloonStyleSimpleExtension != null) {
        return false;
      }
    } else if (balloonStyleSimpleExtension.equals(other.balloonStyleSimpleExtension) == false) {
      return false;
    }
    if (balloonStyleObjectExtension == null) {
      if (other.balloonStyleObjectExtension != null) {
        return false;
      }
    } else if (balloonStyleObjectExtension.equals(other.balloonStyleObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see balloonStyleSimpleExtension
   *
   * @param balloonStyleSimpleExtension
   */
  public void setBalloonStyleSimpleExtension(final List<Object> balloonStyleSimpleExtension) {
    this.balloonStyleSimpleExtension = balloonStyleSimpleExtension;
  }

  /**
   * add a value to the balloonStyleSimpleExtension property collection
   *
   * @param balloonStyleSimpleExtension Objects of the following type are
   *                                    allowed in the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public BalloonStyle addToBalloonStyleSimpleExtension(final Object balloonStyleSimpleExtension) {
    this.getBalloonStyleSimpleExtension().add(balloonStyleSimpleExtension);
    return this;
  }

  /**
   * @see balloonStyleObjectExtension
   *
   * @param balloonStyleObjectExtension
   */
  public void setBalloonStyleObjectExtension(final List<AbstractObject> balloonStyleObjectExtension) {
    this.balloonStyleObjectExtension = balloonStyleObjectExtension;
  }

  /**
   * add a value to the balloonStyleObjectExtension property collection
   *
   * @param balloonStyleObjectExtension Objects of the following type are
   *                                    allowed in the list:
   *                                    {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public BalloonStyle addToBalloonStyleObjectExtension(final AbstractObject balloonStyleObjectExtension) {
    this.getBalloonStyleObjectExtension().add(balloonStyleObjectExtension);
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
  public BalloonStyle addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public BalloonStyle addToSubStyleSimpleExtension(final Object subStyleSimpleExtension) {
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
  public BalloonStyle addToSubStyleObjectExtension(final AbstractObject subStyleObjectExtension) {
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
  public BalloonStyle withColor(final String color) {
    this.setColor(color);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setBgColor(String)
   *
   * @param bgColor required parameter
   */
  public BalloonStyle withBgColor(final String bgColor) {
    this.setBgColor(bgColor);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTextColor(String)
   *
   * @param textColor required parameter
   */
  public BalloonStyle withTextColor(final String textColor) {
    this.setTextColor(textColor);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setText(String)
   *
   * @param text required parameter
   */
  public BalloonStyle withText(final String text) {
    this.setText(text);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setDisplayMode(DisplayMode)
   *
   * @param displayMode required parameter
   */
  public BalloonStyle withDisplayMode(final DisplayMode displayMode) {
    this.setDisplayMode(displayMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setBalloonStyleSimpleExtension(List &lt;Object&gt;)
   *
   * @param balloonStyleSimpleExtension required parameter
   */
  public BalloonStyle withBalloonStyleSimpleExtension(final List<Object> balloonStyleSimpleExtension) {
    this.setBalloonStyleSimpleExtension(balloonStyleSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setBalloonStyleObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param balloonStyleObjectExtension required parameter
   */
  public BalloonStyle withBalloonStyleObjectExtension(final List<AbstractObject> balloonStyleObjectExtension) {
    this.setBalloonStyleObjectExtension(balloonStyleObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public BalloonStyle withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public BalloonStyle withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public BalloonStyle withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public BalloonStyle withSubStyleSimpleExtension(final List<Object> subStyleSimpleExtension) {
    super.withSubStyleSimpleExtension(subStyleSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public BalloonStyle withSubStyleObjectExtension(final List<AbstractObject> subStyleObjectExtension) {
    super.withSubStyleObjectExtension(subStyleObjectExtension);
    return this;
  }

  @Override
  public BalloonStyle clone() {
    BalloonStyle copy;
    copy = ((BalloonStyle) super.clone());
    copy.balloonStyleSimpleExtension = new ArrayList<>((getBalloonStyleSimpleExtension().size()));
    for (Object iter : balloonStyleSimpleExtension) {
      copy.balloonStyleSimpleExtension.add(iter);
    }
    copy.balloonStyleObjectExtension = new ArrayList<>((getBalloonStyleObjectExtension().size()));
    for (AbstractObject iter : balloonStyleObjectExtension) {
      copy.balloonStyleObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
