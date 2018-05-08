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
import net.opengis.kml.AbstractObject;
import net.opengis.kml.annotations.Obvious;

/*
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleArrayDataType", propOrder = {
  "value",
  "simpleArrayDataExtension"
})
@XmlRootElement(name = "SimpleArrayData", namespace = "http://www.google.com/kml/ext/2.2")
public class SimpleArrayData
  extends AbstractObject
  implements Cloneable {

  protected List<String> value;
  @XmlElement(name = "SimpleArrayDataExtension")
  protected List<Object> simpleArrayDataExtension;
  @XmlAttribute(name = "name")
  protected String name;

  public SimpleArrayData() {
    super();
  }

  /*
   *
   */
  public List<String> getValue() {
    if (value == null) {
      value = new ArrayList<>();
    }
    return this.value;
  }

  /*
   *
   */
  public List<Object> getSimpleArrayDataExtension() {
    if (simpleArrayDataExtension == null) {
      simpleArrayDataExtension = new ArrayList<>();
    }
    return this.simpleArrayDataExtension;
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
    int result = super.hashCode();
    result = ((prime * result) + ((value == null) ? 0 : value.hashCode()));
    result = ((prime * result) + ((simpleArrayDataExtension == null) ? 0 : simpleArrayDataExtension.hashCode()));
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
    if (super.equals(obj) == false) {
      return false;
    }
    if ((obj instanceof SimpleArrayData) == false) {
      return false;
    }
    SimpleArrayData other = ((SimpleArrayData) obj);
    if (value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (value.equals(other.value) == false) {
      return false;
    }
    if (simpleArrayDataExtension == null) {
      if (other.simpleArrayDataExtension != null) {
        return false;
      }
    } else if (simpleArrayDataExtension.equals(other.simpleArrayDataExtension) == false) {
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
   * Sets the value of the value property Objects of the following type(s) are
   * allowed in the list List &lt;String&gt;.
   * <p>
   * Note:
   * <p>
   * This method does not make use of the fluent pattern.If you would like to
   * make it fluent, use {@link #withValue} instead.
   *
   * @param value
   */
  public void setValue(final List<String> value) {
    this.value = value;
  }

  /**
   * add a value to the value property collection
   *
   * @param value Objects of the following type are allowed in the list:
   *              {@link String}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public SimpleArrayData addToValue(final String value) {
    this.getValue().add(value);
    return this;
  }

  /**
   * Sets the value of the simpleArrayDataExtension property Objects of the
   * following type(s) are allowed in the list List &lt;Object&gt;.
   * <p>
   * Note:
   * <p>
   * This method does not make use of the fluent pattern.If you would like to
   * make it fluent, use {@link #withSimpleArrayDataExtension} instead.
   *
   * @param simpleArrayDataExtension
   */
  public void setSimpleArrayDataExtension(final List<Object> simpleArrayDataExtension) {
    this.simpleArrayDataExtension = simpleArrayDataExtension;
  }

  /**
   * add a value to the simpleArrayDataExtension property collection
   *
   * @param simpleArrayDataExtension Objects of the following type are allowed
   *                                 in the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public SimpleArrayData addToSimpleArrayDataExtension(final Object simpleArrayDataExtension) {
    this.getSimpleArrayDataExtension().add(simpleArrayDataExtension);
    return this;
  }

  @Obvious
  @Override
  public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.setObjectSimpleExtension(objectSimpleExtension);
  }

  @Obvious
  @Override
  public SimpleArrayData addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setValue(List &lt;String&gt;)
   *
   * @param value required parameter
   */
  public SimpleArrayData withValue(final List<String> value) {
    this.setValue(value);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSimpleArrayDataExtension(List &lt;Object&gt;)
   *
   * @param simpleArrayDataExtension required parameter
   */
  public SimpleArrayData withSimpleArrayDataExtension(final List<Object> simpleArrayDataExtension) {
    this.setSimpleArrayDataExtension(simpleArrayDataExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setName(String)
   *
   * @param name required parameter
   */
  public SimpleArrayData withName(final String name) {
    this.setName(name);
    return this;
  }

  @Obvious
  @Override
  public SimpleArrayData withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public SimpleArrayData withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public SimpleArrayData withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public SimpleArrayData clone() {
    SimpleArrayData copy;
    copy = ((SimpleArrayData) super.clone());
    copy.value = new ArrayList<>((getValue().size()));
    for (String iter : value) {
      copy.value.add(iter);
    }
    copy.simpleArrayDataExtension = new ArrayList<>((getSimpleArrayDataExtension().size()));
    for (Object iter : simpleArrayDataExtension) {
      copy.simpleArrayDataExtension.add(iter);
    }
    return copy;
  }

}
