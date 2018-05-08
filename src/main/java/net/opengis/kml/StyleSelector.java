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
 * &lt;StyleSelector&gt;
 * <p>
 * One or more Styles and StyleMaps can be defined to customize the appearance
 * of any element derived from Feature or of the Geometry in a Placemark. (See
 * &lt;BalloonStyle&gt;, &lt;ListStyle&gt;, &lt;StyleSelector&gt;, and the
 * styles derived from &lt;ColorStyle&gt;.) A style defined within a Feature is
 * called an "inline style" and applies only to the Feature that contains it. A
 * style defined as the child of a &lt;Document&gt; is called a "shared style."
 * A shared style must have an id defined for it. This id is referenced by one
 * or more Features within the &lt;Document&gt;. In cases where a style element
 * is defined both in a shared style and in an inline style for a Feature—that
 * is, a Folder, GroundOverlay, NetworkLink, Placemark, or ScreenOverlay—the
 * value for the Feature's inline style takes precedence over the value for the
 * shared style. Syntax:
 * <pre>&lt;!-- abstract element; do not create --&gt;
 *  &lt;strong&gt;&lt;!--  &lt;em&gt;StyleSelector &lt;/em&gt; id="ID" --&gt;                &lt;/strong&gt;  &lt;!-- Style,StyleMap --&gt; &lt;strong&gt;
 * &lt;!-- / &lt;em&gt;StyleSelector &lt;/em&gt; --&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Object&gt;
 *
 * Extended By:
 * @see: &lt;Style&gt;
 * @see: &lt;StyleMap&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractStyleSelectorType", propOrder = {
  "styleSelectorSimpleExtension",
  "styleSelectorObjectExtension"
})
@XmlSeeAlso({
  Style.class,
  StyleMap.class
})
public abstract class StyleSelector extends AbstractObject implements Cloneable {

  @XmlElement(name = "AbstractStyleSelectorSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> styleSelectorSimpleExtension;
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
  @XmlElement(name = "AbstractStyleSelectorObjectExtensionGroup")
  protected List<AbstractObject> styleSelectorObjectExtension;

  public StyleSelector() {
    super();
  }

  /**
   * @see styleSelectorSimpleExtension
   *
   */
  public List<Object> getStyleSelectorSimpleExtension() {
    if (styleSelectorSimpleExtension == null) {
      styleSelectorSimpleExtension = new ArrayList<>();
    }
    return this.styleSelectorSimpleExtension;
  }

  /**
   * @see styleSelectorObjectExtension
   *
   */
  public List<AbstractObject> getStyleSelectorObjectExtension() {
    if (styleSelectorObjectExtension == null) {
      styleSelectorObjectExtension = new ArrayList<>();
    }
    return this.styleSelectorObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((styleSelectorSimpleExtension == null) ? 0 : styleSelectorSimpleExtension.hashCode()));
    result = ((prime * result) + ((styleSelectorObjectExtension == null) ? 0 : styleSelectorObjectExtension.hashCode()));
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
    if ((obj instanceof StyleSelector) == false) {
      return false;
    }
    StyleSelector other = ((StyleSelector) obj);
    if (styleSelectorSimpleExtension == null) {
      if (other.styleSelectorSimpleExtension != null) {
        return false;
      }
    } else if (styleSelectorSimpleExtension.equals(other.styleSelectorSimpleExtension) == false) {
      return false;
    }
    if (styleSelectorObjectExtension == null) {
      if (other.styleSelectorObjectExtension != null) {
        return false;
      }
    } else if (styleSelectorObjectExtension.equals(other.styleSelectorObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see styleSelectorSimpleExtension
   *
   * @param styleSelectorSimpleExtension
   */
  public void setStyleSelectorSimpleExtension(final List<Object> styleSelectorSimpleExtension) {
    this.styleSelectorSimpleExtension = styleSelectorSimpleExtension;
  }

  /**
   * add a value to the styleSelectorSimpleExtension property collection
   *
   * @param styleSelectorSimpleExtension Objects of the following type are
   *                                     allowed in the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public StyleSelector addToStyleSelectorSimpleExtension(final Object styleSelectorSimpleExtension) {
    this.getStyleSelectorSimpleExtension().add(styleSelectorSimpleExtension);
    return this;
  }

  /**
   * @see styleSelectorObjectExtension
   *
   * @param styleSelectorObjectExtension
   */
  public void setStyleSelectorObjectExtension(final List<AbstractObject> styleSelectorObjectExtension) {
    this.styleSelectorObjectExtension = styleSelectorObjectExtension;
  }

  /**
   * add a value to the styleSelectorObjectExtension property collection
   *
   * @param styleSelectorObjectExtension Objects of the following type are
   *                                     allowed in the list:
   *                                     {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public StyleSelector addToStyleSelectorObjectExtension(final AbstractObject styleSelectorObjectExtension) {
    this.getStyleSelectorObjectExtension().add(styleSelectorObjectExtension);
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
  public StyleSelector addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setStyleSelectorSimpleExtension(List &lt;Object&gt;)
   *
   * @param styleSelectorSimpleExtension required parameter
   */
  public StyleSelector withStyleSelectorSimpleExtension(final List<Object> styleSelectorSimpleExtension) {
    this.setStyleSelectorSimpleExtension(styleSelectorSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setStyleSelectorObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param styleSelectorObjectExtension required parameter
   */
  public StyleSelector withStyleSelectorObjectExtension(final List<AbstractObject> styleSelectorObjectExtension) {
    this.setStyleSelectorObjectExtension(styleSelectorObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public StyleSelector withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public StyleSelector withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public StyleSelector withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public StyleSelector clone() {
    StyleSelector copy;
    copy = ((StyleSelector) super.clone());
    copy.styleSelectorSimpleExtension = new ArrayList<>((getStyleSelectorSimpleExtension().size()));
    for (Object iter : styleSelectorSimpleExtension) {
      copy.styleSelectorSimpleExtension.add(iter);
    }
    copy.styleSelectorObjectExtension = new ArrayList<>((getStyleSelectorObjectExtension().size()));
    for (AbstractObject iter : styleSelectorObjectExtension) {
      copy.styleSelectorObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
