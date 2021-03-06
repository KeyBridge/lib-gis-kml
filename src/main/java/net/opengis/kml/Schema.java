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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import net.opengis.kml.gx.SimpleArrayField;

/**
 * &lt;Schema&gt;
 * <p>
 * Specifies a custom KML schema that is used to add custom data to KML
 * Features. The "id" attribute is required and must be unique within the KML
 * file. &lt;Schema&gt; is always a child of &lt;Document&gt;. Syntax:
 * <pre>&lt;Schema name="string" id="ID"&gt;
 *   &lt;SimpleField type="string" name="string"&gt;
 *     &lt;displayName&gt;...&lt;/displayName&gt;            &lt;!-- string --&gt;
 *   &lt;/SimpleField&gt;
 * &lt;/Schema&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: This is a root element.
 *
 * Contained By:
 * @see: &lt;Document&gt;
 *
 * See Also: &lt;SchemaData&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchemaType", propOrder = {
  "simpleField",
  "schemaExtension"
})
@XmlRootElement(name = "Schema", namespace = "http://www.opengis.net/kml/2.2")
public class Schema implements Cloneable {

  @XmlElement(name = "SimpleField")
  protected List<SimpleField> simpleField;
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
  @XmlElement(name = "SchemaExtension")
  protected List<Object> schemaExtension;
  /**
   * &lt;name&gt;
   * <p>
   * User-defined text displayed in the 3D viewer as the label for the object
   * (for example, for a Placemark, Folder, or NetworkLink).
   */
  @XmlAttribute(name = "name")
  protected String name;
  @XmlAttribute(name = "id")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlID
  @XmlSchemaType(name = "ID")
  protected String id;

  public Schema() {
    super();
  }

  /**
   * @see simpleField
   *
   */
  public List<SimpleField> getSimpleField() {
    if (simpleField == null) {
      simpleField = new ArrayList<>();
    }
    return this.simpleField;
  }

  /**
   * @see schemaExtension
   *
   */
  public List<Object> getSchemaExtension() {
    if (schemaExtension == null) {
      schemaExtension = new ArrayList<>();
    }
    return this.schemaExtension;
  }

  /**
   * @see name
   *
   * @return possible object is {@code String}
   *
   */
  public String getName() {
    return name;
  }

  /**
   * @see name
   *
   * @param value allowed object is {@code String}
   *
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * @see id
   *
   * @return possible object is {@code String}
   *
   */
  public String getId() {
    return id;
  }

  /**
   * @see id
   *
   * @param value allowed object is {@code String}
   *
   */
  public void setId(String value) {
    this.id = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((simpleField == null) ? 0 : simpleField.hashCode()));
    result = ((prime * result) + ((schemaExtension == null) ? 0 : schemaExtension.hashCode()));
    result = ((prime * result) + ((name == null) ? 0 : name.hashCode()));
    result = ((prime * result) + ((id == null) ? 0 : id.hashCode()));
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
    if ((obj instanceof Schema) == false) {
      return false;
    }
    Schema other = ((Schema) obj);
    if (simpleField == null) {
      if (other.simpleField != null) {
        return false;
      }
    } else if (simpleField.equals(other.simpleField) == false) {
      return false;
    }
    if (schemaExtension == null) {
      if (other.schemaExtension != null) {
        return false;
      }
    } else if (schemaExtension.equals(other.schemaExtension) == false) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (name.equals(other.name) == false) {
      return false;
    }
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (id.equals(other.id) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code SimpleField} and adds it to simpleField.
   * This method is a short version for: &lt;code&gt; SimpleField simpleField =
   * new SimpleField(); this.getSimpleField().add(simpleField); &lt;/code&gt;
   */
  public SimpleField createAndAddSimpleField() {
    SimpleField newValue = new SimpleField();
    this.getSimpleField().add(newValue);
    return newValue;
  }

  /**
   * @see simpleField
   *
   * @param simpleField
   */
  public void setSimpleField(final List<SimpleField> simpleField) {
    this.simpleField = simpleField;
  }

  /**
   * add a value to the simpleField property collection
   *
   * @param simpleField Objects of the following type are allowed in the list:
   *                    {@code SimpleField}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Schema addToSimpleField(final SimpleField simpleField) {
    this.getSimpleField().add(simpleField);
    return this;
  }

  /**
   * @see schemaExtension
   *
   * @param schemaExtension
   */
  public void setSchemaExtension(final List<Object> schemaExtension) {
    this.schemaExtension = schemaExtension;
  }

  /**
   * add a value to the schemaExtension property collection
   *
   * @param schemaExtension Objects of the following type are allowed in the
   *                        list:
   *                        {@code SimpleArrayField}{@code JAXBElement}{@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Schema addToSchemaExtension(final Object schemaExtension) {
    this.getSchemaExtension().add(schemaExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSimpleField(List &lt;SimpleField&gt;)
   *
   * @param simpleField required parameter
   */
  public Schema withSimpleField(final List<SimpleField> simpleField) {
    this.setSimpleField(simpleField);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSchemaExtension(List &lt;Object&gt;)
   *
   * @param schemaExtension required parameter
   */
  public Schema withSchemaExtension(final List<Object> schemaExtension) {
    this.setSchemaExtension(schemaExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setName(String)
   *
   * @param name required parameter
   */
  public Schema withName(final String name) {
    this.setName(name);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setId(String)
   *
   * @param id required parameter
   */
  public Schema withId(final String id) {
    this.setId(id);
    return this;
  }

  @Override
  public Schema clone() {
    Schema copy;
    try {
      copy = ((Schema) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.simpleField = new ArrayList<>((getSimpleField().size()));
    for (SimpleField iter : simpleField) {
      copy.simpleField.add(iter.clone());
    }
    copy.schemaExtension = new ArrayList<>((getSchemaExtension().size()));
    for (Object iter : schemaExtension) {
      copy.schemaExtension.add(iter);
    }
    return copy;
  }

}
