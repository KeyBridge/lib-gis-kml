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
 * &lt;Style&gt;
 * <p>
 * A Style defines an addressable style group that can be referenced by
 * StyleMaps and Features. Styles affect how Geometry is presented in the 3D
 * viewer and how Features appear in the Places panel of the List view. Shared
 * styles are collected in a &lt;Document&gt; and must have an id defined for
 * them so that they can be referenced by the individual Features that use them.
 * A Style defines an addressable style group that can be referenced by
 * StyleMaps and Features. Styles affect how Geometry is presented in the 3D
 * viewer and how Features appear in the Places panel of the List view. Shared
 * styles are collected in a &lt;Document&gt; and must have an id defined for
 * them so that they can be referenced by the individual Features that use them.
 * Use an id to refer to the style from a &lt;styleUrl&gt;. Syntax:
 * <pre> &lt;strong&gt;&lt;Style id="ID"&gt;
 *  &lt;/strong&gt;&lt;!-- extends StyleSelector --&gt;
 *
 * &lt;!-- specific to Style --&gt;
 *   &lt;IconStyle&gt;...&lt;/IconStyle&gt;
 *   &lt;LabelStyle&gt;...&lt;/LabelStyle&gt;
 *   &lt;LineStyle&gt;...&lt;/LineStyle&gt;
 *   &lt;PolyStyle&gt;...&lt;/PolyStyle&gt;
 *   &lt;BalloonStyle&gt;...&lt;/BalloonStyle&gt;
 *   &lt;ListStyle&gt; &lt;strong&gt;... &lt;/strong&gt;&lt;/ListStyle&gt; &lt;strong&gt;
 * &lt;/Style&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;StyleSelector&gt;
 *
 * Contained By:
 * @see: &lt;Feature&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StyleType", propOrder = {
  "iconStyle",
  "labelStyle",
  "lineStyle",
  "polyStyle",
  "balloonStyle",
  "listStyle",
  "styleSimpleExtension",
  "styleObjectExtension"
})
@XmlRootElement(name = "Style", namespace = "http://www.opengis.net/kml/2.2")
public class Style
  extends StyleSelector
  implements Cloneable {

  /**
   * &lt;IconStyle&gt;
   * <p>
   * Specifies how icons for point Placemarks are drawn, both in the Places
   * panel and in the 3D viewer of Google Earth. The &lt;Icon&gt; element
   * specifies the icon image. The &lt;scale&gt; element specifies the x, y
   * scaling of the icon. The color specified in the &lt;color&gt; element of
   * &lt;IconStyle&gt; is blended with the color of the &lt;Icon&gt;. Syntax:
   * &lt;pre&gt; &lt;strong&gt;&lt;IconStyle id="ID"&gt; &lt;/strong&gt; &lt;!--
   * inherited from &lt;em&gt;ColorStyle &lt;/em&gt; --&gt;
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
  @XmlElement(name = "IconStyle")
  protected IconStyle iconStyle;
  /**
   * &lt;LabelStyle&gt;
   * <p>
   * Note: The &lt;labelColor&gt; tag is deprecated. Use &lt;LabelStyle&gt;
   * instead. Specifies how the &lt;name&gt; of a Feature is drawn in the 3D
   * viewer. A custom color, color mode, and scale for the label (name) can be
   * specified. Syntax: &lt;pre&gt; &lt;strong&gt;&lt;LabelStyle id="ID"&gt;
   * &lt;/strong&gt; &lt;!-- inherited from &lt;em&gt;ColorStyle &lt;/em&gt;
   * --&gt; &lt;color&gt;ffffffff&lt;/color&gt; &lt;!-- kml:color --&gt;
   * &lt;colorMode&gt;normal&lt;/colorMode&gt; &lt;!-- kml:colorModeEnum: normal
   * &lt;em&gt;or &lt;/em&gt; random --&gt;
   * <p>
   * &lt;!-- specific to LabelStyle --&gt; &lt;scale&gt;1&lt;/scale&gt; &lt;!--
   * float --&gt; &lt;strong&gt;&lt;/LabelStyle&gt; &lt;/strong&gt; </pre>
   * <p>
   * Extends:
   *
   * @see: &lt;ColorStyle&gt;
   *
   * Contained By:
   * @see: &lt;Style&gt;
   *
   */
  @XmlElement(name = "LabelStyle")
  protected LabelStyle labelStyle;
  /**
   * &lt;LineStyle&gt;
   * <p>
   * Specifies the drawing style (color, color mode, and line width) for all
   * line geometry. Line geometry includes the outlines of outlined polygons and
   * the extruded "tether" of Placemark icons (if extrusion is enabled). Syntax:
   * &lt;pre&gt; &lt;strong&gt;&lt;LineStyle id="ID"&gt; &lt;/strong&gt; &lt;!--
   * inherited from &lt;em&gt;ColorStyle &lt;/em&gt; --&gt;
   * &lt;color&gt;ffffffff&lt;/color&gt; &lt;!-- kml:color --&gt;
   * &lt;colorMode&gt;normal&lt;/colorMode&gt; &lt;!-- colorModeEnum: normal
   * &lt;em&gt;or &lt;/em&gt; random --&gt;
   * <p>
   * &lt;!-- specific to LineStyle --&gt; &lt;width&gt;1&lt;/width&gt; &lt;!--
   * float --&gt; &lt;strong&gt;&lt;/LineStyle&gt; &lt;/strong&gt; </pre>
   * <p>
   * Extends:
   *
   * @see: &lt;ColorStyle&gt;
   *
   * Contained By:
   * @see: &lt;Style&gt;
   *
   */
  @XmlElement(name = "LineStyle")
  protected LineStyle lineStyle;
  /**
   * &lt;PolyStyle&gt; Syntax: &lt;pre&gt; &lt;strong&gt;&lt;PolyStyle
   * id="ID"&gt; &lt;/strong&gt; &lt;!-- inherited from &lt;em&gt;ColorStyle
   * &lt;/em&gt; --&gt; &lt;color&gt;ffffffff&lt;/color&gt; &lt;!-- kml:color
   * --&gt; &lt;colorMode&gt;normal&lt;/colorMode&gt; &lt;!-- kml:colorModeEnum:
   * normal &lt;em&gt;or &lt;/em&gt; random --&gt;
   * <p>
   * &lt;!-- specific to PolyStyle --&gt; &lt;fill&gt;1&lt;/fill&gt; &lt;!--
   * boolean --&gt; &lt;outline&gt;1&lt;/outline&gt; &lt;!-- boolean --&gt;
   * &lt;strong&gt;&lt;/PolyStyle&gt; &lt;/strong&gt; </pre>
   * <p>
   * Extends:
   *
   * @see: &lt;ColorStyle&gt;
   *
   * Contained By:
   * @see: &lt;Style&gt;
   *
   */
  @XmlElement(name = "PolyStyle")
  protected PolyStyle polyStyle;
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
   * kml:color --&gt; &lt;text&gt; &lt;em&gt;... &lt;/em&gt;&lt;/text&gt;
   * &lt;!-- string --&gt;
   * &lt;span&gt;&lt;displayMode&gt;default&lt;/displayMode&gt; &lt;strong&gt;
   * &lt;/strong&gt;&lt;!-- kml:displayModeEnum --&gt; &lt;/span&gt;
   * &lt;strong&gt; &lt;/BalloonStyle&gt; &lt;/strong&gt; </pre>
   * <p>
   * Extends:
   *
   * @see: &lt;ColorStyle&gt;
   *
   * Contained By:
   * @see: &lt;Style&gt;
   *
   */
  @XmlElement(name = "BalloonStyle")
  protected BalloonStyle balloonStyle;
  /**
   * &lt;ListStyle&gt;
   * <p>
   * Specifies how a Feature is displayed in the list view. The list view is a
   * hierarchy of containers and children; in Google Earth, this is the Places
   * panel. Syntax: &lt;pre&gt; &lt;strong&gt;&lt;ListStyle id="ID"&gt;
   * &lt;/strong&gt; &lt;!-- specific to ListStyle --&gt;
   * &lt;listItemType&gt;check&lt;/listItemType&gt; &lt;!--
   * kml:listItemTypeEnum:check, checkOffOnly,checkHideChildren, radioFolder
   * --&gt; &lt;bgColor&gt;ffffffff&lt;/bgColor&gt; &lt;!-- kml:color --&gt;
   * &lt;ItemIcon&gt; &lt;!-- 0 or more ItemIcon elements --&gt;
   * &lt;state&gt;open&lt;/state&gt; &lt;!-- kml:itemIconModeEnum:open, closed,
   * error, fetching0, fetching1, &lt;em&gt;or &lt;/em&gt; fetching2 --&gt;
   * &lt;href&gt;...&lt;/href&gt; &lt;!-- anyURI --&gt; &lt;/ItemIcon&gt;
   * &lt;strong&gt;&lt;/ListStyle&gt; &lt;/strong&gt; </pre>
   * <p>
   * Extends:
   *
   * @see: &lt;Object&gt;
   *
   * Contained By:
   * @see: &lt;Style&gt;
   *
   */
  @XmlElement(name = "ListStyle")
  protected ListStyle listStyle;
  @XmlElement(name = "StyleSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> styleSimpleExtension;
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
  @XmlElement(name = "StyleObjectExtensionGroup")
  protected List<AbstractObject> styleObjectExtension;

  public Style() {
    super();
  }

  /**
   * @see iconStyle
   *
   * @return possible object is {@code IconStyle}
   *
   */
  public IconStyle getIconStyle() {
    return iconStyle;
  }

  /**
   * @see iconStyle
   *
   * @param value allowed object is {@code IconStyle}
   *
   */
  public void setIconStyle(IconStyle value) {
    this.iconStyle = value;
  }

  /**
   * @see labelStyle
   *
   * @return possible object is {@code LabelStyle}
   *
   */
  public LabelStyle getLabelStyle() {
    return labelStyle;
  }

  /**
   * @see labelStyle
   *
   * @param value allowed object is {@code LabelStyle}
   *
   */
  public void setLabelStyle(LabelStyle value) {
    this.labelStyle = value;
  }

  /**
   * @see lineStyle
   *
   * @return possible object is {@code LineStyle}
   *
   */
  public LineStyle getLineStyle() {
    return lineStyle;
  }

  /**
   * @see lineStyle
   *
   * @param value allowed object is {@code LineStyle}
   *
   */
  public void setLineStyle(LineStyle value) {
    this.lineStyle = value;
  }

  /**
   * @see polyStyle
   *
   * @return possible object is {@code PolyStyle}
   *
   */
  public PolyStyle getPolyStyle() {
    return polyStyle;
  }

  /**
   * @see polyStyle
   *
   * @param value allowed object is {@code PolyStyle}
   *
   */
  public void setPolyStyle(PolyStyle value) {
    this.polyStyle = value;
  }

  /**
   * @see balloonStyle
   *
   * @return possible object is {@code BalloonStyle}
   *
   */
  public BalloonStyle getBalloonStyle() {
    return balloonStyle;
  }

  /**
   * @see balloonStyle
   *
   * @param value allowed object is {@code BalloonStyle}
   *
   */
  public void setBalloonStyle(BalloonStyle value) {
    this.balloonStyle = value;
  }

  /**
   * @see listStyle
   *
   * @return possible object is {@code ListStyle}
   *
   */
  public ListStyle getListStyle() {
    return listStyle;
  }

  /**
   * @see listStyle
   *
   * @param value allowed object is {@code ListStyle}
   *
   */
  public void setListStyle(ListStyle value) {
    this.listStyle = value;
  }

  /**
   * @see styleSimpleExtension
   *
   */
  public List<Object> getStyleSimpleExtension() {
    if (styleSimpleExtension == null) {
      styleSimpleExtension = new ArrayList<>();
    }
    return this.styleSimpleExtension;
  }

  /**
   * @see styleObjectExtension
   *
   */
  public List<AbstractObject> getStyleObjectExtension() {
    if (styleObjectExtension == null) {
      styleObjectExtension = new ArrayList<>();
    }
    return this.styleObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((iconStyle == null) ? 0 : iconStyle.hashCode()));
    result = ((prime * result) + ((labelStyle == null) ? 0 : labelStyle.hashCode()));
    result = ((prime * result) + ((lineStyle == null) ? 0 : lineStyle.hashCode()));
    result = ((prime * result) + ((polyStyle == null) ? 0 : polyStyle.hashCode()));
    result = ((prime * result) + ((balloonStyle == null) ? 0 : balloonStyle.hashCode()));
    result = ((prime * result) + ((listStyle == null) ? 0 : listStyle.hashCode()));
    result = ((prime * result) + ((styleSimpleExtension == null) ? 0 : styleSimpleExtension.hashCode()));
    result = ((prime * result) + ((styleObjectExtension == null) ? 0 : styleObjectExtension.hashCode()));
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
    if ((obj instanceof Style) == false) {
      return false;
    }
    Style other = ((Style) obj);
    if (iconStyle == null) {
      if (other.iconStyle != null) {
        return false;
      }
    } else if (iconStyle.equals(other.iconStyle) == false) {
      return false;
    }
    if (labelStyle == null) {
      if (other.labelStyle != null) {
        return false;
      }
    } else if (labelStyle.equals(other.labelStyle) == false) {
      return false;
    }
    if (lineStyle == null) {
      if (other.lineStyle != null) {
        return false;
      }
    } else if (lineStyle.equals(other.lineStyle) == false) {
      return false;
    }
    if (polyStyle == null) {
      if (other.polyStyle != null) {
        return false;
      }
    } else if (polyStyle.equals(other.polyStyle) == false) {
      return false;
    }
    if (balloonStyle == null) {
      if (other.balloonStyle != null) {
        return false;
      }
    } else if (balloonStyle.equals(other.balloonStyle) == false) {
      return false;
    }
    if (listStyle == null) {
      if (other.listStyle != null) {
        return false;
      }
    } else if (listStyle.equals(other.listStyle) == false) {
      return false;
    }
    if (styleSimpleExtension == null) {
      if (other.styleSimpleExtension != null) {
        return false;
      }
    } else if (styleSimpleExtension.equals(other.styleSimpleExtension) == false) {
      return false;
    }
    if (styleObjectExtension == null) {
      if (other.styleObjectExtension != null) {
        return false;
      }
    } else if (styleObjectExtension.equals(other.styleObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code IconStyle} and set it to iconStyle.
   * <p>
   * This method is a short version for: &lt;code&gt; IconStyle iconStyle = new
   * IconStyle(); this.setIconStyle(iconStyle); &lt;/code&gt;
   */
  public IconStyle createAndSetIconStyle() {
    IconStyle newValue = new IconStyle();
    this.setIconStyle(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code LabelStyle} and set it to labelStyle.
   * <p>
   * This method is a short version for: &lt;code&gt; LabelStyle labelStyle =
   * new LabelStyle(); this.setLabelStyle(labelStyle); &lt;/code&gt;
   */
  public LabelStyle createAndSetLabelStyle() {
    LabelStyle newValue = new LabelStyle();
    this.setLabelStyle(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code LineStyle} and set it to lineStyle.
   * <p>
   * This method is a short version for: &lt;code&gt; LineStyle lineStyle = new
   * LineStyle(); this.setLineStyle(lineStyle); &lt;/code&gt;
   */
  public LineStyle createAndSetLineStyle() {
    LineStyle newValue = new LineStyle();
    this.setLineStyle(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code PolyStyle} and set it to polyStyle.
   * <p>
   * This method is a short version for: &lt;code&gt; PolyStyle polyStyle = new
   * PolyStyle(); this.setPolyStyle(polyStyle); &lt;/code&gt;
   */
  public PolyStyle createAndSetPolyStyle() {
    PolyStyle newValue = new PolyStyle();
    this.setPolyStyle(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code BalloonStyle} and set it to balloonStyle.
   * <p>
   * This method is a short version for: &lt;code&gt; BalloonStyle balloonStyle
   * = new BalloonStyle(); this.setBalloonStyle(balloonStyle); &lt;/code&gt;
   */
  public BalloonStyle createAndSetBalloonStyle() {
    BalloonStyle newValue = new BalloonStyle();
    this.setBalloonStyle(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code ListStyle} and set it to listStyle.
   * <p>
   * This method is a short version for: &lt;code&gt; ListStyle listStyle = new
   * ListStyle(); this.setListStyle(listStyle); &lt;/code&gt;
   */
  public ListStyle createAndSetListStyle() {
    ListStyle newValue = new ListStyle();
    this.setListStyle(newValue);
    return newValue;
  }

  /**
   * @see styleSimpleExtension
   *
   * @param styleSimpleExtension
   */
  public void setStyleSimpleExtension(final List<Object> styleSimpleExtension) {
    this.styleSimpleExtension = styleSimpleExtension;
  }

  /**
   * add a value to the styleSimpleExtension property collection
   *
   * @param styleSimpleExtension Objects of the following type are allowed in
   *                             the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Style addToStyleSimpleExtension(final Object styleSimpleExtension) {
    this.getStyleSimpleExtension().add(styleSimpleExtension);
    return this;
  }

  /**
   * @see styleObjectExtension
   *
   * @param styleObjectExtension
   */
  public void setStyleObjectExtension(final List<AbstractObject> styleObjectExtension) {
    this.styleObjectExtension = styleObjectExtension;
  }

  /**
   * add a value to the styleObjectExtension property collection
   *
   * @param styleObjectExtension Objects of the following type are allowed in
   *                             the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Style addToStyleObjectExtension(final AbstractObject styleObjectExtension) {
    this.getStyleObjectExtension().add(styleObjectExtension);
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
  public Style addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * @see styleSelectorSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setStyleSelectorSimpleExtension(final List<Object> styleSelectorSimpleExtension) {
    super.setStyleSelectorSimpleExtension(styleSelectorSimpleExtension);
  }

  @Obvious
  @Override
  public Style addToStyleSelectorSimpleExtension(final Object styleSelectorSimpleExtension) {
    super.getStyleSelectorSimpleExtension().add(styleSelectorSimpleExtension);
    return this;
  }

  /**
   * @see styleSelectorObjectExtension
   *
   */
  @Obvious
  @Override
  public void setStyleSelectorObjectExtension(final List<AbstractObject> styleSelectorObjectExtension) {
    super.setStyleSelectorObjectExtension(styleSelectorObjectExtension);
  }

  @Obvious
  @Override
  public Style addToStyleSelectorObjectExtension(final AbstractObject styleSelectorObjectExtension) {
    super.getStyleSelectorObjectExtension().add(styleSelectorObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setIconStyle(IconStyle)
   *
   * @param iconStyle required parameter
   */
  public Style withIconStyle(final IconStyle iconStyle) {
    this.setIconStyle(iconStyle);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLabelStyle(LabelStyle)
   *
   * @param labelStyle required parameter
   */
  public Style withLabelStyle(final LabelStyle labelStyle) {
    this.setLabelStyle(labelStyle);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLineStyle(LineStyle)
   *
   * @param lineStyle required parameter
   */
  public Style withLineStyle(final LineStyle lineStyle) {
    this.setLineStyle(lineStyle);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPolyStyle(PolyStyle)
   *
   * @param polyStyle required parameter
   */
  public Style withPolyStyle(final PolyStyle polyStyle) {
    this.setPolyStyle(polyStyle);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setBalloonStyle(BalloonStyle)
   *
   * @param balloonStyle required parameter
   */
  public Style withBalloonStyle(final BalloonStyle balloonStyle) {
    this.setBalloonStyle(balloonStyle);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setListStyle(ListStyle)
   *
   * @param listStyle required parameter
   */
  public Style withListStyle(final ListStyle listStyle) {
    this.setListStyle(listStyle);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setStyleSimpleExtension(List &lt;Object&gt;)
   *
   * @param styleSimpleExtension required parameter
   */
  public Style withStyleSimpleExtension(final List<Object> styleSimpleExtension) {
    this.setStyleSimpleExtension(styleSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setStyleObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param styleObjectExtension required parameter
   */
  public Style withStyleObjectExtension(final List<AbstractObject> styleObjectExtension) {
    this.setStyleObjectExtension(styleObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Style withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Style withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Style withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public Style withStyleSelectorSimpleExtension(final List<Object> styleSelectorSimpleExtension) {
    super.withStyleSelectorSimpleExtension(styleSelectorSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Style withStyleSelectorObjectExtension(final List<AbstractObject> styleSelectorObjectExtension) {
    super.withStyleSelectorObjectExtension(styleSelectorObjectExtension);
    return this;
  }

  @Override
  public Style clone() {
    Style copy;
    copy = ((Style) super.clone());
    copy.iconStyle = ((iconStyle == null) ? null : ((IconStyle) iconStyle.clone()));
    copy.labelStyle = ((labelStyle == null) ? null : ((LabelStyle) labelStyle.clone()));
    copy.lineStyle = ((lineStyle == null) ? null : ((LineStyle) lineStyle.clone()));
    copy.polyStyle = ((polyStyle == null) ? null : ((PolyStyle) polyStyle.clone()));
    copy.balloonStyle = ((balloonStyle == null) ? null : ((BalloonStyle) balloonStyle.clone()));
    copy.listStyle = ((listStyle == null) ? null : ((ListStyle) listStyle.clone()));
    copy.styleSimpleExtension = new ArrayList<>((getStyleSimpleExtension().size()));
    for (Object iter : styleSimpleExtension) {
      copy.styleSimpleExtension.add(iter);
    }
    copy.styleObjectExtension = new ArrayList<>((getStyleObjectExtension().size()));
    for (AbstractObject iter : styleObjectExtension) {
      copy.styleObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
