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
 * &lt;LineStyle&gt;
 * <p>
 * Specifies the drawing style (color, color mode, and line width) for all line
 * geometry. Line geometry includes the outlines of outlined polygons and the
 * extruded "tether" of Placemark icons (if extrusion is enabled). Syntax:
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineStyleType", propOrder = {
  "width",
  "lineStyleSimpleExtension",
  "lineStyleObjectExtension"
})
@XmlRootElement(name = "LineStyle", namespace = "http://www.opengis.net/kml/2.2")
public class LineStyle
  extends ColorStyle
  implements Cloneable {

  /**
   * &lt;width&gt;
   * <p>
   * Width of the line, in pixels.
   */
  @XmlElement(defaultValue = "1.0")
  protected double width;
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
  @XmlElement(name = "LineStyleSimpleExtensionGroup")
  protected List<Object> lineStyleSimpleExtension;
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
  @XmlElement(name = "LineStyleObjectExtensionGroup")
  protected List<AbstractObject> lineStyleObjectExtension;

  public LineStyle() {
    super();
  }

  /**
   * @see width
   *
   * @return possible object is {@code Double}
   *
   */
  public double getWidth() {
    return width;
  }

  /**
   * @see width
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setWidth(double value) {
    this.width = value;
  }

  /**
   * @see lineStyleSimpleExtension
   *
   */
  public List<Object> getLineStyleSimpleExtension() {
    if (lineStyleSimpleExtension == null) {
      lineStyleSimpleExtension = new ArrayList<>();
    }
    return this.lineStyleSimpleExtension;
  }

  /**
   * @see lineStyleObjectExtension
   *
   */
  public List<AbstractObject> getLineStyleObjectExtension() {
    if (lineStyleObjectExtension == null) {
      lineStyleObjectExtension = new ArrayList<>();
    }
    return this.lineStyleObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(width);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((lineStyleSimpleExtension == null) ? 0 : lineStyleSimpleExtension.hashCode()));
    result = ((prime * result) + ((lineStyleObjectExtension == null) ? 0 : lineStyleObjectExtension.hashCode()));
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
    if ((obj instanceof LineStyle) == false) {
      return false;
    }
    LineStyle other = ((LineStyle) obj);
    if (width != other.width) {
      return false;
    }
    if (lineStyleSimpleExtension == null) {
      if (other.lineStyleSimpleExtension != null) {
        return false;
      }
    } else if (lineStyleSimpleExtension.equals(other.lineStyleSimpleExtension) == false) {
      return false;
    }
    if (lineStyleObjectExtension == null) {
      if (other.lineStyleObjectExtension != null) {
        return false;
      }
    } else if (lineStyleObjectExtension.equals(other.lineStyleObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see lineStyleSimpleExtension
   *
   * @param lineStyleSimpleExtension
   */
  public void setLineStyleSimpleExtension(final List<Object> lineStyleSimpleExtension) {
    this.lineStyleSimpleExtension = lineStyleSimpleExtension;
  }

  /**
   * add a value to the lineStyleSimpleExtension property collection
   *
   * @param lineStyleSimpleExtension Objects of the following type are allowed
   *                                 in the list:
   *                                 {@code Object}{@code JAXBElement}{@code byte[]}{@code &gt;}{@code JAXBElement}{@code Float}{@code JAXBElement}{@code Float}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LineStyle addToLineStyleSimpleExtension(final Object lineStyleSimpleExtension) {
    this.getLineStyleSimpleExtension().add(lineStyleSimpleExtension);
    return this;
  }

  /**
   * @see lineStyleObjectExtension
   *
   * @param lineStyleObjectExtension
   */
  public void setLineStyleObjectExtension(final List<AbstractObject> lineStyleObjectExtension) {
    this.lineStyleObjectExtension = lineStyleObjectExtension;
  }

  /**
   * add a value to the lineStyleObjectExtension property collection
   *
   * @param lineStyleObjectExtension Objects of the following type are allowed
   *                                 in the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LineStyle addToLineStyleObjectExtension(final AbstractObject lineStyleObjectExtension) {
    this.getLineStyleObjectExtension().add(lineStyleObjectExtension);
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
  public LineStyle addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public LineStyle addToSubStyleSimpleExtension(final Object subStyleSimpleExtension) {
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
  public LineStyle addToSubStyleObjectExtension(final AbstractObject subStyleObjectExtension) {
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
  public LineStyle addToColorStyleSimpleExtension(final Object colorStyleSimpleExtension) {
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
  public LineStyle addToColorStyleObjectExtension(final AbstractObject colorStyleObjectExtension) {
    super.getColorStyleObjectExtension().add(colorStyleObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setWidth(double)
   *
   * @param width required parameter
   */
  public LineStyle withWidth(final double width) {
    this.setWidth(width);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLineStyleSimpleExtension(List &lt;Object&gt;)
   *
   * @param lineStyleSimpleExtension required parameter
   */
  public LineStyle withLineStyleSimpleExtension(final List<Object> lineStyleSimpleExtension) {
    this.setLineStyleSimpleExtension(lineStyleSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLineStyleObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param lineStyleObjectExtension required parameter
   */
  public LineStyle withLineStyleObjectExtension(final List<AbstractObject> lineStyleObjectExtension) {
    this.setLineStyleObjectExtension(lineStyleObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public LineStyle withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public LineStyle withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public LineStyle withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public LineStyle withSubStyleSimpleExtension(final List<Object> subStyleSimpleExtension) {
    super.withSubStyleSimpleExtension(subStyleSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public LineStyle withSubStyleObjectExtension(final List<AbstractObject> subStyleObjectExtension) {
    super.withSubStyleObjectExtension(subStyleObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public LineStyle withColor(final String color) {
    super.withColor(color);
    return this;
  }

  @Obvious
  @Override
  public LineStyle withColorMode(final ColorMode colorMode) {
    super.withColorMode(colorMode);
    return this;
  }

  @Obvious
  @Override
  public LineStyle withColorStyleSimpleExtension(final List<Object> colorStyleSimpleExtension) {
    super.withColorStyleSimpleExtension(colorStyleSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public LineStyle withColorStyleObjectExtension(final List<AbstractObject> colorStyleObjectExtension) {
    super.withColorStyleObjectExtension(colorStyleObjectExtension);
    return this;
  }

  @Override
  public LineStyle clone() {
    LineStyle copy;
    copy = ((LineStyle) super.clone());
    copy.lineStyleSimpleExtension = new ArrayList<>((getLineStyleSimpleExtension().size()));
    for (Object iter : lineStyleSimpleExtension) {
      copy.lineStyleSimpleExtension.add(iter);
    }
    copy.lineStyleObjectExtension = new ArrayList<>((getLineStyleObjectExtension().size()));
    for (AbstractObject iter : lineStyleObjectExtension) {
      copy.lineStyleObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
