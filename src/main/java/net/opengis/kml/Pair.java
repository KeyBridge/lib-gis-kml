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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.opengis.kml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import net.opengis.kml.annotations.Obvious;

/**
 * <pair> (required)
 * <p>
 * Defines a key/value pair that maps a mode (normal or highlight) to the
 * predefined
 * <styleUrl>. <Pair> contains two elements (both are required): <key>, which
 * identifies the key <styleUrl> or <Style>, which references the style. In
 * <styleUrl>, for referenced style elements that are local to the KML document,
 * a simple # referencing is used. For styles that are contained in external
 * files, use a full URL along with # referencing. For example: <Pair>
 * <key>normal</key>
 * <styleUrl>http://myserver.com/populationProject.xml#example_style_off</styleUrl>
 * </Pair>
 * </p>
 * <p>
 * <p>
 * <p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PairType", propOrder = {
  "key",
  "styleUrl",
  "styleSelector",
  "pairSimpleExtension",
  "pairObjectExtension"
})
@XmlRootElement(name = "Pair", namespace = "http://www.opengis.net/kml/2.2")
public class Pair
        extends AbstractObject
        implements Cloneable {

  /**
   * StyleState
   * <p>
   * normal, highlight
   * </p>
   * <p>
   * See Also: See <StyleMap>
   * <p>
   * <p>
   * <p>
   */
  @XmlElement(defaultValue = "normal")
  protected StyleState key;
  /**
   * <styleurl>
   * <p>
   * URL of a <Style> or <StyleMap> defined in a Document. If the style is in
   * the same file, use a # reference. If the style is defined in an external
   * file, use a full URL along with # referencing. Examples are
   * <styleUrl>#myIconStyleID</styleUrl>
   * <styleUrl>http://someserver.com/somestylefile.xml#restaurant</styleUrl>
   * <styleUrl>eateries.kml#my-lunch-spot</styleUrl>
   * </p>
   * <p>
   * <p>
   * <p>
   */
  @XmlSchemaType(name = "anyURI")
  protected String styleUrl;
  /**
   * <StyleSelector>
   * <p>
   * One or more Styles and StyleMaps can be defined to customize the appearance
   * of any element derived from Feature or of the Geometry in a Placemark. (See
   * <BalloonStyle>,
   * <ListStyle>, <StyleSelector>, and the styles derived from <ColorStyle>.) A
   * style defined within a Feature is called an "inline style" and applies only
   * to the Feature that contains it. A style defined as the child of a
   * <Document> is called a "shared style." A shared style must have an id
   * defined for it. This id is referenced by one or more Features within the
   * <Document>. In cases where a style element is defined both in a shared
   * style and in an inline style for a Feature—that is, a Folder,
   * GroundOverlay, NetworkLink, Placemark, or ScreenOverlay—the value for the
   * Feature's inline style takes precedence over the value for the shared
   * style.
   * </p>
   * <p>
   * Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt;
   * <strong>&lt;!-- <em>StyleSelector</em> id="ID" --&gt;               </strong>  &lt;!-- Style,StyleMap --&gt;<strong>
   * &lt;!-- /<em>StyleSelector</em> --&gt;</strong></pre>
   * <p>
   * Extends:
   *
   * @see: <Object>
   *
   * Extended By:
   * @see: <Style>
   * @see: <StyleMap>
   *
   *
   *
   */
  @XmlElementRef(name = "AbstractStyleSelectorGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected StyleSelector styleSelector;
  @XmlElement(name = "PairSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> pairSimpleExtension;
  /**
   * <Object>
   * <p>
   * This is an abstract base class and cannot be used directly in a KML file.
   * It provides the id attribute, which allows unique identification of a KML
   * element, and the targetId attribute, which is used to reference objects
   * that have already been loaded into Google Earth. The id attribute must be
   * assigned if the <Update> mechanism is to be used.
   * </p>
   * <p>
   * Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt;<strong>
   * &lt;!-- <em>Object</em> id="ID" targetId="NCName" --&gt;
   * &lt;!-- /<em>Object</em>&gt; --&gt;</strong></pre>
   * <p>
   * <p>
   * <p>
   */
  @XmlElement(name = "PairObjectExtensionGroup")
  protected List<AbstractObject> pairObjectExtension;

  public Pair() {
    super();
  }

  /**
   * @see key
   *
   * @return possible object is {@link StyleState}
   *
   */
  public StyleState getKey() {
    return key;
  }

  /**
   * @see key
   *
   * @param value allowed object is {@link StyleState}
   *
   */
  public void setKey(StyleState value) {
    this.key = value;
  }

  /**
   * @see styleUrl
   *
   * @return possible object is {@link String}
   *
   */
  public String getStyleUrl() {
    return styleUrl;
  }

  /**
   * @see styleUrl
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setStyleUrl(String value) {
    this.styleUrl = value;
  }

  /**
   * @see styleSelector
   *
   * @return possible object is null   {@code <}{@link Style}{@code>}
     *     {@code <}{@link StyleSelector}{@code>}
   *     {@code <}{@link StyleMap}{@code>}
   *
   */
  public StyleSelector getStyleSelector() {
    return styleSelector;
  }

  /**
   * @see styleSelector
   *
   * @param value allowed object is null   {@code <}{@link Style}{@code>}
     *     {@code <}{@link StyleSelector}{@code>}
   *     {@code <}{@link StyleMap}{@code>}
   *
   */
  public void setStyleSelector(StyleSelector value) {
    this.styleSelector = ((StyleSelector) value);
  }

  /**
   * @see pairSimpleExtension
   *
   */
  public List<Object> getPairSimpleExtension() {
    if (pairSimpleExtension == null) {
      pairSimpleExtension = new ArrayList<>();
    }
    return this.pairSimpleExtension;
  }

  /**
   * @see pairObjectExtension
   *
   */
  public List<AbstractObject> getPairObjectExtension() {
    if (pairObjectExtension == null) {
      pairObjectExtension = new ArrayList<>();
    }
    return this.pairObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((key == null) ? 0 : key.hashCode()));
    result = ((prime * result) + ((styleUrl == null) ? 0 : styleUrl.hashCode()));
    result = ((prime * result) + ((styleSelector == null) ? 0 : styleSelector.hashCode()));
    result = ((prime * result) + ((pairSimpleExtension == null) ? 0 : pairSimpleExtension.hashCode()));
    result = ((prime * result) + ((pairObjectExtension == null) ? 0 : pairObjectExtension.hashCode()));
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
    if ((obj instanceof Pair) == false) {
      return false;
    }
    Pair other = ((Pair) obj);
    if (key == null) {
      if (other.key != null) {
        return false;
      }
    } else if (key.equals(other.key) == false) {
      return false;
    }
    if (styleUrl == null) {
      if (other.styleUrl != null) {
        return false;
      }
    } else if (styleUrl.equals(other.styleUrl) == false) {
      return false;
    }
    if (styleSelector == null) {
      if (other.styleSelector != null) {
        return false;
      }
    } else if (styleSelector.equals(other.styleSelector) == false) {
      return false;
    }
    if (pairSimpleExtension == null) {
      if (other.pairSimpleExtension != null) {
        return false;
      }
    } else if (pairSimpleExtension.equals(other.pairSimpleExtension) == false) {
      return false;
    }
    if (pairObjectExtension == null) {
      if (other.pairObjectExtension != null) {
        return false;
      }
    } else if (pairObjectExtension.equals(other.pairObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link Style} and set it to styleSelector.
   * <p>
   * This method is a short version for:    <code>
   * Style style = new Style();
   * this.setStyleSelector(style); </code>
   * <p>
   * <p>
   */
  public Style createAndSetStyle() {
    Style newValue = new Style();
    this.setStyleSelector(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link StyleMap} and set it to styleSelector.
   * <p>
   * This method is a short version for:    <code>
   * StyleMap styleMap = new StyleMap();
   * this.setStyleSelector(styleMap); </code>
   * <p>
   * <p>
   */
  public StyleMap createAndSetStyleMap() {
    StyleMap newValue = new StyleMap();
    this.setStyleSelector(newValue);
    return newValue;
  }

  /**
   * @see pairSimpleExtension
   *
   * @param pairSimpleExtension
   */
  public void setPairSimpleExtension(final List<Object> pairSimpleExtension) {
    this.pairSimpleExtension = pairSimpleExtension;
  }

  /**
   * add a value to the pairSimpleExtension property collection
   *
   * @param pairSimpleExtension Objects of the following type are allowed in the
   *                            list: {@link Object}
   * @return <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
   */
  public Pair addToPairSimpleExtension(final Object pairSimpleExtension) {
    this.getPairSimpleExtension().add(pairSimpleExtension);
    return this;
  }

  /**
   * @see pairObjectExtension
   *
   * @param pairObjectExtension
   */
  public void setPairObjectExtension(final List<AbstractObject> pairObjectExtension) {
    this.pairObjectExtension = pairObjectExtension;
  }

  /**
   * add a value to the pairObjectExtension property collection
   *
   * @param pairObjectExtension Objects of the following type are allowed in the
   *                            list: {@link AbstractObject}
   * @return <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
   */
  public Pair addToPairObjectExtension(final AbstractObject pairObjectExtension) {
    this.getPairObjectExtension().add(pairObjectExtension);
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
  public Pair addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setKey(StyleState)
   *
   * @param key required parameter
   */
  public Pair withKey(final StyleState key) {
    this.setKey(key);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setStyleUrl(String)
   *
   * @param styleUrl required parameter
   */
  public Pair withStyleUrl(final String styleUrl) {
    this.setStyleUrl(styleUrl);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setStyleSelector(StyleSelector)
   *
   * @param styleSelector required parameter
   */
  public Pair withStyleSelector(final StyleSelector styleSelector) {
    this.setStyleSelector(styleSelector);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPairSimpleExtension(List<Object>)
   *
   * @param pairSimpleExtension required parameter
   */
  public Pair withPairSimpleExtension(final List<Object> pairSimpleExtension) {
    this.setPairSimpleExtension(pairSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPairObjectExtension(List<AbstractObject>)
   *
   * @param pairObjectExtension required parameter
   */
  public Pair withPairObjectExtension(final List<AbstractObject> pairObjectExtension) {
    this.setPairObjectExtension(pairObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Pair withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Pair withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Pair withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public Pair clone() {
    Pair copy;
    copy = ((Pair) super.clone());
    copy.styleSelector = ((styleSelector == null) ? null : ((StyleSelector) styleSelector.clone()));
    copy.pairSimpleExtension = new ArrayList<>((getPairSimpleExtension().size()));
    for (Object iter : pairSimpleExtension) {
      copy.pairSimpleExtension.add(iter);
    }
    copy.pairObjectExtension = new ArrayList<>((getPairObjectExtension().size()));
    for (AbstractObject iter : pairObjectExtension) {
      copy.pairObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
