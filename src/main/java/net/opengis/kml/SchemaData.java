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
import net.opengis.kml.gx.SimpleArrayData;

/**
 * &lt;schemadata schemaurl="anyuri"&gt;
 * <p>
 * The &lt;schemaURL&gt; can be a full URL, a reference to a Schema ID defined
 * in an external KML file, or a reference to a Schema ID defined in the same
 * KML file. All of the following specifications are acceptable: The Schema
 * element is always a child of Document. The ExtendedData element is a child of
 * the Feature that contains the custom data. This element is used in
 * conjunction with &lt;Schema&gt; to add typed custom data to a KML Feature.
 * The Schema element (identified by the schemaUrl attribute) declares the
 * custom data type. The actual data objects ("instances" of the custom data)
 * are defined using the SchemaData element.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchemaDataType", propOrder = {
  "simpleData",
  "schemaDataExtension"
})
@XmlRootElement(name = "SchemaData", namespace = "http://www.opengis.net/kml/2.2")
public class SchemaData
  extends AbstractObject
  implements Cloneable {

  /**
   * &lt;simpledata name="string"&gt;
   * <p>
   * &lt;SimpleData name="string"&gt; This element assigns a value to the custom
   * data field identified by the name attribute. The type and name of this
   * custom data field are declared in the &lt;Schema&gt; element. Here is an
   * example of defining two custom data elements: &lt;Placemark&gt;
   * &lt;name&gt;Easy trail &lt;/name&gt; &lt;ExtendedData&gt; &lt;SchemaData
   * schemaUrl="#TrailHeadTypeId"&gt; &lt;SimpleData name="TrailHeadName"&gt;Pi
   * in the sky &lt;/SimpleData&gt; &lt;SimpleData name="TrailLength"&gt;3.14159
   * &lt;/SimpleData&gt; &lt;SimpleData name="ElevationGain"&gt;10
   * &lt;/SimpleData&gt; &lt;/SchemaData&gt; &lt;/ExtendedData&gt; &lt;Point&gt;
   * &lt;coordinates&gt;-122.000,37.002 &lt;/coordinates&gt; &lt;/Point&gt;
   * &lt;/Placemark&gt; &lt;Placemark&gt; &lt;name&gt;Difficult trail
   * &lt;/name&gt; &lt;ExtendedData&gt; &lt;SchemaData
   * schemaUrl="#TrailHeadTypeId"&gt; &lt;SimpleData
   * name="TrailHeadName"&gt;Mount Everest &lt;/SimpleData&gt; &lt;SimpleData
   * name="TrailLength"&gt;347.45 &lt;/SimpleData&gt; &lt;SimpleData
   * name="ElevationGain"&gt;10000 &lt;/SimpleData&gt; &lt;/SchemaData&gt;
   * &lt;/ExtendedData&gt; &lt;Point&gt; &lt;coordinates&gt;-122.000,37.002
   * &lt;/coordinates&gt; &lt;/Point&gt; &lt;/Placemark&gt; Here is an example
   * of defining two custom data elements: This element assigns a value to the
   * custom data field identified by the name attribute. The type and name of
   * this custom data field are declared in the &lt;Schema&gt; element.
   */
  @XmlElement(name = "SimpleData")
  protected List<SimpleData> simpleData;
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
  @XmlElement(name = "SchemaDataExtension")
  protected List<Object> schemaDataExtension;
  @XmlAttribute(name = "schemaUrl")
  @XmlSchemaType(name = "anyURI")
  protected String schemaUrl;

  public SchemaData() {
    super();
  }

  /**
   * @see simpleData
   *
   */
  public List<SimpleData> getSimpleData() {
    if (simpleData == null) {
      simpleData = new ArrayList<>();
    }
    return this.simpleData;
  }

  /**
   * @see schemaDataExtension
   *
   */
  public List<Object> getSchemaDataExtension() {
    if (schemaDataExtension == null) {
      schemaDataExtension = new ArrayList<>();
    }
    return this.schemaDataExtension;
  }

  /**
   * @see schemaUrl
   *
   * @return possible object is {@code String}
   *
   */
  public String getSchemaUrl() {
    return schemaUrl;
  }

  /**
   * @see schemaUrl
   *
   * @param value allowed object is {@code String}
   *
   */
  public void setSchemaUrl(String value) {
    this.schemaUrl = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((simpleData == null) ? 0 : simpleData.hashCode()));
    result = ((prime * result) + ((schemaDataExtension == null) ? 0 : schemaDataExtension.hashCode()));
    result = ((prime * result) + ((schemaUrl == null) ? 0 : schemaUrl.hashCode()));
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
    if ((obj instanceof SchemaData) == false) {
      return false;
    }
    SchemaData other = ((SchemaData) obj);
    if (simpleData == null) {
      if (other.simpleData != null) {
        return false;
      }
    } else if (simpleData.equals(other.simpleData) == false) {
      return false;
    }
    if (schemaDataExtension == null) {
      if (other.schemaDataExtension != null) {
        return false;
      }
    } else if (schemaDataExtension.equals(other.schemaDataExtension) == false) {
      return false;
    }
    if (schemaUrl == null) {
      if (other.schemaUrl != null) {
        return false;
      }
    } else if (schemaUrl.equals(other.schemaUrl) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code SimpleData} and adds it to simpleData.
   * This method is a short version for: &lt;code&gt; SimpleData simpleData =
   * new SimpleData(); this.getSimpleData().add(simpleData); &lt;/code&gt;
   *
   * @param name required parameter
   */
  public SimpleData createAndAddSimpleData(final String name) {
    SimpleData newValue = new SimpleData(name);
    this.getSimpleData().add(newValue);
    return newValue;
  }

  /**
   * @see simpleData
   *
   * @param simpleData
   */
  public void setSimpleData(final List<SimpleData> simpleData) {
    this.simpleData = simpleData;
  }

  /**
   * add a value to the simpleData property collection
   *
   * @param simpleData Objects of the following type are allowed in the list:
   *                   {@code SimpleData}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public SchemaData addToSimpleData(final SimpleData simpleData) {
    this.getSimpleData().add(simpleData);
    return this;
  }

  /**
   * @see schemaDataExtension
   *
   * @param schemaDataExtension
   */
  public void setSchemaDataExtension(final List<Object> schemaDataExtension) {
    this.schemaDataExtension = schemaDataExtension;
  }

  /**
   * add a value to the schemaDataExtension property collection
   *
   * @param schemaDataExtension Objects of the following type are allowed in the
   *                            list:
   *                            {@code SimpleArrayData}{@code JAXBElement}{@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public SchemaData addToSchemaDataExtension(final Object schemaDataExtension) {
    this.getSchemaDataExtension().add(schemaDataExtension);
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
  public SchemaData addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSimpleData(List &lt;SimpleData&gt;)
   *
   * @param simpleData required parameter
   */
  public SchemaData withSimpleData(final List<SimpleData> simpleData) {
    this.setSimpleData(simpleData);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSchemaDataExtension(List &lt;Object&gt;)
   *
   * @param schemaDataExtension required parameter
   */
  public SchemaData withSchemaDataExtension(final List<Object> schemaDataExtension) {
    this.setSchemaDataExtension(schemaDataExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSchemaUrl(String)
   *
   * @param schemaUrl required parameter
   */
  public SchemaData withSchemaUrl(final String schemaUrl) {
    this.setSchemaUrl(schemaUrl);
    return this;
  }

  @Obvious
  @Override
  public SchemaData withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public SchemaData withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public SchemaData withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public SchemaData clone() {
    SchemaData copy;
    copy = ((SchemaData) super.clone());
    copy.simpleData = new ArrayList<>((getSimpleData().size()));
    for (SimpleData iter : simpleData) {
      copy.simpleData.add(iter.clone());
    }
    copy.schemaDataExtension = new ArrayList<>((getSchemaDataExtension().size()));
    for (Object iter : schemaDataExtension) {
      copy.schemaDataExtension.add(iter);
    }
    return copy;
  }

}
