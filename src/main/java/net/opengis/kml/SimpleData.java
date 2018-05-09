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

import javax.xml.bind.annotation.*;

/**
 * &lt;simpledata name="string"&gt;
 * <p>
 * &lt;SimpleData name="string"&gt; This element assigns a value to the custom
 * data field identified by the name attribute. The type and name of this custom
 * data field are declared in the &lt;Schema&gt; element. Here is an example of
 * defining two custom data elements: &lt;Placemark&gt; &lt;name&gt;Easy trail
 * &lt;/name&gt; &lt;ExtendedData&gt; &lt;SchemaData
 * schemaUrl="#TrailHeadTypeId"&gt; &lt;SimpleData name="TrailHeadName"&gt;Pi in
 * the sky &lt;/SimpleData&gt; &lt;SimpleData name="TrailLength"&gt;3.14159
 * &lt;/SimpleData&gt; &lt;SimpleData name="ElevationGain"&gt;10
 * &lt;/SimpleData&gt; &lt;/SchemaData&gt; &lt;/ExtendedData&gt; &lt;Point&gt;
 * &lt;coordinates&gt;-122.000,37.002 &lt;/coordinates&gt; &lt;/Point&gt;
 * &lt;/Placemark&gt; &lt;Placemark&gt; &lt;name&gt;Difficult trail
 * &lt;/name&gt; &lt;ExtendedData&gt; &lt;SchemaData
 * schemaUrl="#TrailHeadTypeId"&gt; &lt;SimpleData name="TrailHeadName"&gt;Mount
 * Everest &lt;/SimpleData&gt; &lt;SimpleData name="TrailLength"&gt;347.45
 * &lt;/SimpleData&gt; &lt;SimpleData name="ElevationGain"&gt;10000
 * &lt;/SimpleData&gt; &lt;/SchemaData&gt; &lt;/ExtendedData&gt; &lt;Point&gt;
 * &lt;coordinates&gt;-122.000,37.002 &lt;/coordinates&gt; &lt;/Point&gt;
 * &lt;/Placemark&gt; Here is an example of defining two custom data elements:
 * This element assigns a value to the custom data field identified by the name
 * attribute. The type and name of this custom data field are declared in the
 * &lt;Schema&gt; element.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleDataType", propOrder = {
  "value"
})
@XmlRootElement(name = "SimpleData", namespace = "http://www.opengis.net/kml/2.2")
public class SimpleData implements Cloneable {

  /**
   * &lt;value&gt;
   * <p>
   * &lt;Placemark&gt; &lt;name&gt;Club house &lt;/name&gt; &lt;ExtendedData&gt;
   * &lt;Data name="holeNumber"&gt; &lt;value&gt;1 &lt;/value&gt; &lt;/Data&gt;
   * &lt;Data name="holeYardage"&gt; &lt;value&gt;234 &lt;/value&gt;
   * &lt;/Data&gt; &lt;Data name="holePar"&gt; &lt;value&gt;4 &lt;/value&gt;
   * &lt;/Data&gt; &lt;/ExtendedData&gt; &lt;/Placemark&gt; &lt;displayName&gt;
   * An optional formatted version of name, to be used for display purposes.
   * &lt;value&gt; Value of the data pair. &lt;Placemark&gt; &lt;name&gt;Club
   * house &lt;/name&gt; &lt;ExtendedData&gt; &lt;Data name="holeNumber"&gt;
   * &lt;value&gt;1 &lt;/value&gt; &lt;/Data&gt; &lt;Data name="holeYardage"&gt;
   * &lt;value&gt;234 &lt;/value&gt; &lt;/Data&gt; &lt;Data name="holePar"&gt;
   * &lt;value&gt;4 &lt;/value&gt; &lt;/Data&gt; &lt;/ExtendedData&gt;
   * &lt;/Placemark&gt; Value of the data pair.
   */
  @XmlValue
  protected String value;
  /**
   * &lt;name&gt;
   * <p>
   * User-defined text displayed in the 3D viewer as the label for the object
   * (for example, for a Placemark, Folder, or NetworkLink).
   */
  @XmlAttribute(name = "name", required = true)
  protected String name;

  /**
   * Value constructor with only mandatory fields
   *
   * @param name required parameter
   */
  public SimpleData(final String name) {
    super();
    this.name = name;
  }

  /**
   * Default no-arg constructor is private. Use overloaded constructor instead!
   * (Temporary solution, till a better and more suitable ObjectFactory is
   * created.)
   * <p>
   */
  @Deprecated
  private SimpleData() {
    super();
  }

  /**
   * @see value
   *
   * @return possible object is {@code String}
   *
   */
  public String getValue() {
    return value;
  }

  /**
   * @see value
   *
   * @param value allowed object is {@code String}
   *
   */
  public void setValue(String value) {
    this.value = value;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((value == null) ? 0 : value.hashCode()));
    result = ((prime * result) + ((name == null) ? 0 : name.hashCode()));
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
    if ((obj instanceof SimpleData) == false) {
      return false;
    }
    SimpleData other = ((SimpleData) obj);
    if (value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (value.equals(other.value) == false) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (name.equals(other.name) == false) {
      return false;
    }
    return true;
  }

  /**
   * fluent setter
   *
   * @see #setValue(String)
   *
   * @param value required parameter
   */
  public SimpleData withValue(final String value) {
    this.setValue(value);
    return this;
  }

  @Override
  public SimpleData clone() {
    SimpleData copy;
    try {
      copy = ((SimpleData) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    return copy;
  }

}
