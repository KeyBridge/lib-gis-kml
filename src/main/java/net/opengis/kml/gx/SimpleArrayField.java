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
package net.opengis.kml.gx;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;

/*
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleArrayFieldType", propOrder = {
  "displayName",
  "simpleArrayFieldExtension"
})
@XmlRootElement(name = "SimpleArrayField", namespace = "http://www.google.com/kml/ext/2.2")
public class SimpleArrayField implements Cloneable {

  @XmlElement(namespace = "http://www.opengis.net/kml/2.2")
  protected String displayName;
  @XmlElement(name = "SimpleArrayFieldExtension")
  protected List<Object> simpleArrayFieldExtension;
  @XmlAttribute(name = "type")
  protected String type;
  @XmlAttribute(name = "name")
  protected String name;

  public SimpleArrayField() {
    super();
  }

  /**
   * @return possible object is {@link String}
   *
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * @param value allowed object is {@link String}
   *
   */
  public void setDisplayName(String value) {
    this.displayName = value;
  }

  /*
   *
   */
  public List<Object> getSimpleArrayFieldExtension() {
    if (simpleArrayFieldExtension == null) {
      simpleArrayFieldExtension = new ArrayList<>();
    }
    return this.simpleArrayFieldExtension;
  }

  /**
   * @return possible object is {@link String}
   *
   */
  public String getType() {
    return type;
  }

  /**
   * @param value allowed object is {@link String}
   *
   */
  public void setType(String value) {
    this.type = value;
  }

  /**
   * @return possible object is {@link String}
   *
   */
  public String getName() {
    return name;
  }

  /**
   * @param value allowed object is {@link String}
   *
   */
  public void setName(String value) {
    this.name = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((displayName == null) ? 0 : displayName.hashCode()));
    result = ((prime * result) + ((simpleArrayFieldExtension == null) ? 0 : simpleArrayFieldExtension.hashCode()));
    result = ((prime * result) + ((type == null) ? 0 : type.hashCode()));
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
    if ((obj instanceof SimpleArrayField) == false) {
      return false;
    }
    SimpleArrayField other = ((SimpleArrayField) obj);
    if (displayName == null) {
      if (other.displayName != null) {
        return false;
      }
    } else if (displayName.equals(other.displayName) == false) {
      return false;
    }
    if (simpleArrayFieldExtension == null) {
      if (other.simpleArrayFieldExtension != null) {
        return false;
      }
    } else if (simpleArrayFieldExtension.equals(other.simpleArrayFieldExtension) == false) {
      return false;
    }
    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (type.equals(other.type) == false) {
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
   * Sets the value of the simpleArrayFieldExtension property Objects of the
   * following type(s) are allowed in the list List &lt;Object&gt;.
   *   
   * Note:
   *   
   * This method does not make use of the fluent pattern.If you would like to
   * make it fluent, use {@link #withSimpleArrayFieldExtension} instead.
   *
   * @param simpleArrayFieldExtension
   */
  public void setSimpleArrayFieldExtension(final List<Object> simpleArrayFieldExtension) {
    this.simpleArrayFieldExtension = simpleArrayFieldExtension;
  }

  /**
   * add a value to the simpleArrayFieldExtension property collection
   *
   * @param simpleArrayFieldExtension Objects of the following type are allowed
   *                                  in the list: {@link Object}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public SimpleArrayField addToSimpleArrayFieldExtension(final Object simpleArrayFieldExtension) {
    this.getSimpleArrayFieldExtension().add(simpleArrayFieldExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setDisplayName(String)
   *
   * @param displayName required parameter
   */
  public SimpleArrayField withDisplayName(final String displayName) {
    this.setDisplayName(displayName);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSimpleArrayFieldExtension(List &lt;Object&gt;)
   *
   * @param simpleArrayFieldExtension required parameter
   */
  public SimpleArrayField withSimpleArrayFieldExtension(final List<Object> simpleArrayFieldExtension) {
    this.setSimpleArrayFieldExtension(simpleArrayFieldExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setType(String)
   *
   * @param type required parameter
   */
  public SimpleArrayField withType(final String type) {
    this.setType(type);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setName(String)
   *
   * @param name required parameter
   */
  public SimpleArrayField withName(final String name) {
    this.setName(name);
    return this;
  }

  @Override
  public SimpleArrayField clone() {
    SimpleArrayField copy;
    try {
      copy = ((SimpleArrayField) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.simpleArrayFieldExtension = new ArrayList<>((getSimpleArrayFieldExtension().size()));
    for (Object iter : simpleArrayFieldExtension) {
      copy.simpleArrayFieldExtension.add(iter);
    }
    return copy;
  }

}
