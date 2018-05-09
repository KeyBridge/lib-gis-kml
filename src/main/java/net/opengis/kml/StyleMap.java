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
 * &lt;StyleMap&gt;
 * <p>
 * A &lt;StyleMap&gt; maps between two different Styles. Typically a
 * &lt;StyleMap&gt; element is used to provide separate normal and highlighted
 * styles for a placemark, so that the highlighted version appears when the user
 * mouses over the icon in Google Earth. Syntax: &lt;pre&gt;
 * &lt;strong&gt;&lt;StyleMap id="ID"&gt; &lt;/strong&gt; &lt;!-- extends
 * &lt;em&gt;StyleSelector &lt;/em&gt; --&gt; &lt;!-- elements specific to
 * StyleMap --&gt; &lt;Pair id="ID"&gt; &lt;key&gt;normal&lt;/key&gt; &lt;!--
 * kml:styleStateEnum: normal &lt;em&gt; or &lt;/em&gt; highlight --&gt;
 * &lt;styleUrl&gt; &lt;em&gt;... &lt;/em&gt;&lt;/styleUrl&gt; or
 * &lt;Style&gt;...&lt;/Style&gt; &lt;/Pair&gt; &lt;strong&gt;&lt;/StyleMap&gt;
 * &lt;/strong&gt; </pre>
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
@XmlType(name = "StyleMapType", propOrder = {
  "pair",
  "styleMapSimpleExtension",
  "styleMapObjectExtension"
})
@XmlRootElement(name = "StyleMap", namespace = "http://www.opengis.net/kml/2.2")
public class StyleMap
  extends StyleSelector
  implements Cloneable {

  /**
   * &lt;pair&gt; (required)
   * <p>
   * Defines a key/value pair that maps a mode (normal or highlight) to the
   * predefined &lt;styleUrl&gt;. &lt;Pair&gt; contains two elements (both are
   * required): &lt;key&gt;, which identifies the key &lt;styleUrl&gt; or
   * &lt;Style&gt;, which references the style. In &lt;styleUrl&gt;, for
   * referenced style elements that are local to the KML document, a simple #
   * referencing is used. For styles that are contained in external files, use a
   * full URL along with # referencing. For example: &lt;Pair&gt;
   * &lt;key&gt;normal &lt;/key&gt;
   * &lt;styleUrl&gt;http://myserver.com/populationProject.xml#example_style_off
   * &lt;/styleUrl&gt; &lt;/Pair&gt;
   */
  @XmlElement(name = "Pair")
  protected List<Pair> pair;
  @XmlElement(name = "StyleMapSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> styleMapSimpleExtension;
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
  @XmlElement(name = "StyleMapObjectExtensionGroup")
  protected List<AbstractObject> styleMapObjectExtension;

  public StyleMap() {
    super();
  }

  /**
   * @see pair
   *
   */
  public List<Pair> getPair() {
    if (pair == null) {
      pair = new ArrayList<>();
    }
    return this.pair;
  }

  /**
   * @see styleMapSimpleExtension
   *
   */
  public List<Object> getStyleMapSimpleExtension() {
    if (styleMapSimpleExtension == null) {
      styleMapSimpleExtension = new ArrayList<>();
    }
    return this.styleMapSimpleExtension;
  }

  /**
   * @see styleMapObjectExtension
   *
   */
  public List<AbstractObject> getStyleMapObjectExtension() {
    if (styleMapObjectExtension == null) {
      styleMapObjectExtension = new ArrayList<>();
    }
    return this.styleMapObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((pair == null) ? 0 : pair.hashCode()));
    result = ((prime * result) + ((styleMapSimpleExtension == null) ? 0 : styleMapSimpleExtension.hashCode()));
    result = ((prime * result) + ((styleMapObjectExtension == null) ? 0 : styleMapObjectExtension.hashCode()));
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
    if ((obj instanceof StyleMap) == false) {
      return false;
    }
    StyleMap other = ((StyleMap) obj);
    if (pair == null) {
      if (other.pair != null) {
        return false;
      }
    } else if (pair.equals(other.pair) == false) {
      return false;
    }
    if (styleMapSimpleExtension == null) {
      if (other.styleMapSimpleExtension != null) {
        return false;
      }
    } else if (styleMapSimpleExtension.equals(other.styleMapSimpleExtension) == false) {
      return false;
    }
    if (styleMapObjectExtension == null) {
      if (other.styleMapObjectExtension != null) {
        return false;
      }
    } else if (styleMapObjectExtension.equals(other.styleMapObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code Pair} and adds it to pair. This method is
   * a short version for: &lt;code&gt; Pair pair = new Pair();
   * this.getPair().add(pair); &lt;/code&gt;
   */
  public Pair createAndAddPair() {
    Pair newValue = new Pair();
    this.getPair().add(newValue);
    return newValue;
  }

  /**
   * @see pair
   *
   * @param pair
   */
  public void setPair(final List<Pair> pair) {
    this.pair = pair;
  }

  /**
   * add a value to the pair property collection
   *
   * @param pair Objects of the following type are allowed in the list:
   *             {@code Pair}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public StyleMap addToPair(final Pair pair) {
    this.getPair().add(pair);
    return this;
  }

  /**
   * @see styleMapSimpleExtension
   *
   * @param styleMapSimpleExtension
   */
  public void setStyleMapSimpleExtension(final List<Object> styleMapSimpleExtension) {
    this.styleMapSimpleExtension = styleMapSimpleExtension;
  }

  /**
   * add a value to the styleMapSimpleExtension property collection
   *
   * @param styleMapSimpleExtension Objects of the following type are allowed in
   *                                the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public StyleMap addToStyleMapSimpleExtension(final Object styleMapSimpleExtension) {
    this.getStyleMapSimpleExtension().add(styleMapSimpleExtension);
    return this;
  }

  /**
   * @see styleMapObjectExtension
   *
   * @param styleMapObjectExtension
   */
  public void setStyleMapObjectExtension(final List<AbstractObject> styleMapObjectExtension) {
    this.styleMapObjectExtension = styleMapObjectExtension;
  }

  /**
   * add a value to the styleMapObjectExtension property collection
   *
   * @param styleMapObjectExtension Objects of the following type are allowed in
   *                                the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public StyleMap addToStyleMapObjectExtension(final AbstractObject styleMapObjectExtension) {
    this.getStyleMapObjectExtension().add(styleMapObjectExtension);
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
  public StyleMap addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public StyleMap addToStyleSelectorSimpleExtension(final Object styleSelectorSimpleExtension) {
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
  public StyleMap addToStyleSelectorObjectExtension(final AbstractObject styleSelectorObjectExtension) {
    super.getStyleSelectorObjectExtension().add(styleSelectorObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPair(List &lt;Pair&gt;)
   *
   * @param pair required parameter
   */
  public StyleMap withPair(final List<Pair> pair) {
    this.setPair(pair);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setStyleMapSimpleExtension(List &lt;Object&gt;)
   *
   * @param styleMapSimpleExtension required parameter
   */
  public StyleMap withStyleMapSimpleExtension(final List<Object> styleMapSimpleExtension) {
    this.setStyleMapSimpleExtension(styleMapSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setStyleMapObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param styleMapObjectExtension required parameter
   */
  public StyleMap withStyleMapObjectExtension(final List<AbstractObject> styleMapObjectExtension) {
    this.setStyleMapObjectExtension(styleMapObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public StyleMap withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public StyleMap withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public StyleMap withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public StyleMap withStyleSelectorSimpleExtension(final List<Object> styleSelectorSimpleExtension) {
    super.withStyleSelectorSimpleExtension(styleSelectorSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public StyleMap withStyleSelectorObjectExtension(final List<AbstractObject> styleSelectorObjectExtension) {
    super.withStyleSelectorObjectExtension(styleSelectorObjectExtension);
    return this;
  }

  @Override
  public StyleMap clone() {
    StyleMap copy;
    copy = ((StyleMap) super.clone());
    copy.pair = new ArrayList<>((getPair().size()));
    for (Pair iter : pair) {
      copy.pair.add(iter.clone());
    }
    copy.styleMapSimpleExtension = new ArrayList<>((getStyleMapSimpleExtension().size()));
    for (Object iter : styleMapSimpleExtension) {
      copy.styleMapSimpleExtension.add(iter);
    }
    copy.styleMapObjectExtension = new ArrayList<>((getStyleMapObjectExtension().size()));
    for (AbstractObject iter : styleMapObjectExtension) {
      copy.styleMapObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
