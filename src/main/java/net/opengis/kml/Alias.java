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
 * &lt;alias&gt; contains a mapping from a &lt;sourcehref&gt; to a
 * &lt;targethref&gt;:
 * <p>
 * &lt;targetHref&gt; Specifies the texture file to be fetched by Google Earth.
 * This reference can be a relative reference to an image file within the .kmz
 * archive, or it can be an absolute reference to the file (for example, a URL).
 * &lt;sourceHref&gt; Is the path specified for the texture file in the Collada
 * .dae file.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AliasType", propOrder = {
  "targetHref",
  "sourceHref",
  "aliasSimpleExtension",
  "aliasObjectExtension"
})
@XmlRootElement(name = "Alias", namespace = "http://www.opengis.net/kml/2.2")
public class Alias
  extends AbstractObject
  implements Cloneable {

  /**
   * &lt;targethref&gt; (required)
   * <p>
   * A URL that specifies the .kml or .kmz file whose data (within Google Earth)
   * is to be modified by an &lt;Update&gt; element. This KML file must already
   * have been loaded via a &lt;NetworkLink&gt;. In that file, the element to be
   * modified must already have an explicit id attribute defined for it.
   * Specifies the texture file to be fetched by Google Earth. This reference
   * can be a relative reference to an image file within the .kmz archive, or it
   * can be an absolute reference to the file (for example, a URL).
   */
  @XmlSchemaType(name = "anyURI")
  protected String targetHref;
  /**
   * &lt;sourcehref&gt;
   * <p>
   * &lt;targetHref&gt; Specifies the texture file to be fetched by Google
   * Earth. This reference can be a relative reference to an image file within
   * the .kmz archive, or it can be an absolute reference to the file (for
   * example, a URL). &lt;sourceHref&gt; Is the path specified for the texture
   * file in the Collada .dae file. In Google Earth, if this mapping is not
   * supplied, the following rules are used to locate the textures referenced in
   * the Collada (.dae) file: No path: If the texture name does not include a
   * path, Google Earth looks for the texture in the same directory as the .dae
   * file that references it. Relative path: If the texture name includes a
   * relative path (for example, ../images/mytexture.jpg), Google Earth
   * interprets the path as being relative to the .dae file that references it.
   * Absolute path: If the texture name is an absolute path (c:\mytexture.jpg)
   * or a network path (for example, http://myserver.com/mytexture.jpg), Google
   * Earth looks for the file in the specified location, regardless of where the
   * .dae file is located. Is the path specified for the texture file in the
   * Collada .dae file. Is the path specified for the texture file in the
   * Collada .dae file.
   */
  @XmlSchemaType(name = "anyURI")
  protected String sourceHref;
  @XmlElement(name = "AliasSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> aliasSimpleExtension;
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
  @XmlElement(name = "AliasObjectExtensionGroup")
  protected List<AbstractObject> aliasObjectExtension;

  public Alias() {
    super();
  }

  /**
   * @see targetHref
   *
   * @return possible object is {@link String}
   *
   */
  public String getTargetHref() {
    return targetHref;
  }

  /**
   * @see targetHref
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setTargetHref(String value) {
    this.targetHref = value;
  }

  /**
   * @see sourceHref
   *
   * @return possible object is {@link String}
   *
   */
  public String getSourceHref() {
    return sourceHref;
  }

  /**
   * @see sourceHref
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setSourceHref(String value) {
    this.sourceHref = value;
  }

  /**
   * @see aliasSimpleExtension
   *
   */
  public List<Object> getAliasSimpleExtension() {
    if (aliasSimpleExtension == null) {
      aliasSimpleExtension = new ArrayList<>();
    }
    return this.aliasSimpleExtension;
  }

  /**
   * @see aliasObjectExtension
   *
   */
  public List<AbstractObject> getAliasObjectExtension() {
    if (aliasObjectExtension == null) {
      aliasObjectExtension = new ArrayList<>();
    }
    return this.aliasObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((targetHref == null) ? 0 : targetHref.hashCode()));
    result = ((prime * result) + ((sourceHref == null) ? 0 : sourceHref.hashCode()));
    result = ((prime * result) + ((aliasSimpleExtension == null) ? 0 : aliasSimpleExtension.hashCode()));
    result = ((prime * result) + ((aliasObjectExtension == null) ? 0 : aliasObjectExtension.hashCode()));
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
    if ((obj instanceof Alias) == false) {
      return false;
    }
    Alias other = ((Alias) obj);
    if (targetHref == null) {
      if (other.targetHref != null) {
        return false;
      }
    } else if (targetHref.equals(other.targetHref) == false) {
      return false;
    }
    if (sourceHref == null) {
      if (other.sourceHref != null) {
        return false;
      }
    } else if (sourceHref.equals(other.sourceHref) == false) {
      return false;
    }
    if (aliasSimpleExtension == null) {
      if (other.aliasSimpleExtension != null) {
        return false;
      }
    } else if (aliasSimpleExtension.equals(other.aliasSimpleExtension) == false) {
      return false;
    }
    if (aliasObjectExtension == null) {
      if (other.aliasObjectExtension != null) {
        return false;
      }
    } else if (aliasObjectExtension.equals(other.aliasObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see aliasSimpleExtension
   *
   * @param aliasSimpleExtension
   */
  public void setAliasSimpleExtension(final List<Object> aliasSimpleExtension) {
    this.aliasSimpleExtension = aliasSimpleExtension;
  }

  /**
   * add a value to the aliasSimpleExtension property collection
   *
   * @param aliasSimpleExtension Objects of the following type are allowed in
   *                             the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Alias addToAliasSimpleExtension(final Object aliasSimpleExtension) {
    this.getAliasSimpleExtension().add(aliasSimpleExtension);
    return this;
  }

  /**
   * @see aliasObjectExtension
   *
   * @param aliasObjectExtension
   */
  public void setAliasObjectExtension(final List<AbstractObject> aliasObjectExtension) {
    this.aliasObjectExtension = aliasObjectExtension;
  }

  /**
   * add a value to the aliasObjectExtension property collection
   *
   * @param aliasObjectExtension Objects of the following type are allowed in
   *                             the list: {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Alias addToAliasObjectExtension(final AbstractObject aliasObjectExtension) {
    this.getAliasObjectExtension().add(aliasObjectExtension);
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
  public Alias addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTargetHref(String)
   *
   * @param targetHref required parameter
   */
  public Alias withTargetHref(final String targetHref) {
    this.setTargetHref(targetHref);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSourceHref(String)
   *
   * @param sourceHref required parameter
   */
  public Alias withSourceHref(final String sourceHref) {
    this.setSourceHref(sourceHref);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAliasSimpleExtension(List &lt;Object&gt;)
   *
   * @param aliasSimpleExtension required parameter
   */
  public Alias withAliasSimpleExtension(final List<Object> aliasSimpleExtension) {
    this.setAliasSimpleExtension(aliasSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAliasObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param aliasObjectExtension required parameter
   */
  public Alias withAliasObjectExtension(final List<AbstractObject> aliasObjectExtension) {
    this.setAliasObjectExtension(aliasObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Alias withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Alias withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Alias withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public Alias clone() {
    Alias copy;
    copy = ((Alias) super.clone());
    copy.aliasSimpleExtension = new ArrayList<>((getAliasSimpleExtension().size()));
    for (Object iter : aliasSimpleExtension) {
      copy.aliasSimpleExtension.add(iter);
    }
    copy.aliasObjectExtension = new ArrayList<>((getAliasObjectExtension().size()));
    for (AbstractObject iter : aliasObjectExtension) {
      copy.aliasObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
