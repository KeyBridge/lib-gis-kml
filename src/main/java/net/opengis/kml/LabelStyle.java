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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LabelStyleType", propOrder = {
  "scale",
  "labelStyleSimpleExtension",
  "labelStyleObjectExtension"
})
@XmlRootElement(name = "LabelStyle", namespace = "http://www.opengis.net/kml/2.2")
public class LabelStyle
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
  @XmlElement(name = "LabelStyleSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> labelStyleSimpleExtension;
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
  @XmlElement(name = "LabelStyleObjectExtensionGroup")
  protected List<AbstractObject> labelStyleObjectExtension;

  public LabelStyle() {
    super();
  }

  /**
   * @see scale
   *
   * @return possible object is {@code Double}
   *
   */
  public double getScale() {
    return scale;
  }

  /**
   * @see scale
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setScale(double value) {
    this.scale = value;
  }

  /**
   * @see labelStyleSimpleExtension
   *
   */
  public List<Object> getLabelStyleSimpleExtension() {
    if (labelStyleSimpleExtension == null) {
      labelStyleSimpleExtension = new ArrayList<>();
    }
    return this.labelStyleSimpleExtension;
  }

  /**
   * @see labelStyleObjectExtension
   *
   */
  public List<AbstractObject> getLabelStyleObjectExtension() {
    if (labelStyleObjectExtension == null) {
      labelStyleObjectExtension = new ArrayList<>();
    }
    return this.labelStyleObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(scale);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((labelStyleSimpleExtension == null) ? 0 : labelStyleSimpleExtension.hashCode()));
    result = ((prime * result) + ((labelStyleObjectExtension == null) ? 0 : labelStyleObjectExtension.hashCode()));
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
    if ((obj instanceof LabelStyle) == false) {
      return false;
    }
    LabelStyle other = ((LabelStyle) obj);
    if (scale != other.scale) {
      return false;
    }
    if (labelStyleSimpleExtension == null) {
      if (other.labelStyleSimpleExtension != null) {
        return false;
      }
    } else if (labelStyleSimpleExtension.equals(other.labelStyleSimpleExtension) == false) {
      return false;
    }
    if (labelStyleObjectExtension == null) {
      if (other.labelStyleObjectExtension != null) {
        return false;
      }
    } else if (labelStyleObjectExtension.equals(other.labelStyleObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see labelStyleSimpleExtension
   *
   * @param labelStyleSimpleExtension
   */
  public void setLabelStyleSimpleExtension(final List<Object> labelStyleSimpleExtension) {
    this.labelStyleSimpleExtension = labelStyleSimpleExtension;
  }

  /**
   * add a value to the labelStyleSimpleExtension property collection
   *
   * @param labelStyleSimpleExtension Objects of the following type are allowed
   *                                  in the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LabelStyle addToLabelStyleSimpleExtension(final Object labelStyleSimpleExtension) {
    this.getLabelStyleSimpleExtension().add(labelStyleSimpleExtension);
    return this;
  }

  /**
   * @see labelStyleObjectExtension
   *
   * @param labelStyleObjectExtension
   */
  public void setLabelStyleObjectExtension(final List<AbstractObject> labelStyleObjectExtension) {
    this.labelStyleObjectExtension = labelStyleObjectExtension;
  }

  /**
   * add a value to the labelStyleObjectExtension property collection
   *
   * @param labelStyleObjectExtension Objects of the following type are allowed
   *                                  in the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LabelStyle addToLabelStyleObjectExtension(final AbstractObject labelStyleObjectExtension) {
    this.getLabelStyleObjectExtension().add(labelStyleObjectExtension);
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
  public LabelStyle addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public LabelStyle addToSubStyleSimpleExtension(final Object subStyleSimpleExtension) {
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
  public LabelStyle addToSubStyleObjectExtension(final AbstractObject subStyleObjectExtension) {
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
  public LabelStyle addToColorStyleSimpleExtension(final Object colorStyleSimpleExtension) {
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
  public LabelStyle addToColorStyleObjectExtension(final AbstractObject colorStyleObjectExtension) {
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
  public LabelStyle withScale(final double scale) {
    this.setScale(scale);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLabelStyleSimpleExtension(List &lt;Object&gt;)
   *
   * @param labelStyleSimpleExtension required parameter
   */
  public LabelStyle withLabelStyleSimpleExtension(final List<Object> labelStyleSimpleExtension) {
    this.setLabelStyleSimpleExtension(labelStyleSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLabelStyleObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param labelStyleObjectExtension required parameter
   */
  public LabelStyle withLabelStyleObjectExtension(final List<AbstractObject> labelStyleObjectExtension) {
    this.setLabelStyleObjectExtension(labelStyleObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public LabelStyle withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public LabelStyle withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public LabelStyle withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public LabelStyle withSubStyleSimpleExtension(final List<Object> subStyleSimpleExtension) {
    super.withSubStyleSimpleExtension(subStyleSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public LabelStyle withSubStyleObjectExtension(final List<AbstractObject> subStyleObjectExtension) {
    super.withSubStyleObjectExtension(subStyleObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public LabelStyle withColor(final String color) {
    super.withColor(color);
    return this;
  }

  @Obvious
  @Override
  public LabelStyle withColorMode(final ColorMode colorMode) {
    super.withColorMode(colorMode);
    return this;
  }

  @Obvious
  @Override
  public LabelStyle withColorStyleSimpleExtension(final List<Object> colorStyleSimpleExtension) {
    super.withColorStyleSimpleExtension(colorStyleSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public LabelStyle withColorStyleObjectExtension(final List<AbstractObject> colorStyleObjectExtension) {
    super.withColorStyleObjectExtension(colorStyleObjectExtension);
    return this;
  }

  @Override
  public LabelStyle clone() {
    LabelStyle copy;
    copy = ((LabelStyle) super.clone());
    copy.labelStyleSimpleExtension = new ArrayList<>((getLabelStyleSimpleExtension().size()));
    for (Object iter : labelStyleSimpleExtension) {
      copy.labelStyleSimpleExtension.add(iter);
    }
    copy.labelStyleObjectExtension = new ArrayList<>((getLabelStyleObjectExtension().size()));
    for (AbstractObject iter : labelStyleObjectExtension) {
      copy.labelStyleObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
