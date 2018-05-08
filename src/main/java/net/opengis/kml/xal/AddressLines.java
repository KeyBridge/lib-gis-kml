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
package net.opengis.kml.xal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

/*
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressLinesType", propOrder = {
  "addressLine",
  "any"
})
@XmlRootElement(name = "AddressLines", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
public class AddressLines implements Cloneable {

  @XmlElement(name = "AddressLine", required = true)
  protected List<AddressLine> addressLine;
  @XmlAnyElement(lax = true)
  protected List<Object> any;
  @XmlAnyAttribute
  private Map<QName, String> otherAttributes = new HashMap<>();

  /**
   * Value constructor with only mandatory fields
   *
   * @param addressLine required parameter
   */
  public AddressLines(final List<AddressLine> addressLine) {
    super();
    this.addressLine = addressLine;
  }

  /**
   * Default no-arg constructor is private. Use overloaded constructor instead!
   * (Temporary solution, till a better and more suitable ObjectFactory is
   * created.)
   * <p>
   */
  @Deprecated
  private AddressLines() {
    super();
  }

  /*
   *
   */
  public List<AddressLine> getAddressLine() {
    if (addressLine == null) {
      addressLine = new ArrayList<>();
    }
    return this.addressLine;
  }

  /*
   *
   */
  public List<Object> getAny() {
    if (any == null) {
      any = new ArrayList<>();
    }
    return this.any;
  }

  /**
   * @return always non-null
   */
  public Map<QName, String> getOtherAttributes() {
    return otherAttributes;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((addressLine == null) ? 0 : addressLine.hashCode()));
    result = ((prime * result) + ((any == null) ? 0 : any.hashCode()));
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
    if ((obj instanceof AddressLines) == false) {
      return false;
    }
    AddressLines other = ((AddressLines) obj);
    if (addressLine == null) {
      if (other.addressLine != null) {
        return false;
      }
    } else if (addressLine.equals(other.addressLine) == false) {
      return false;
    }
    if (any == null) {
      if (other.any != null) {
        return false;
      }
    } else if (any.equals(other.any) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link AddressLine} and adds it to addressLine.
   * This method is a short version for: &lt;code&gt; AddressLine addressLine =
   * new AddressLine(); this.getAddressLine().add(addressLine); &lt;/code&gt;
   */
  public AddressLine createAndAddAddressLine() {
    AddressLine newValue = new AddressLine();
    this.getAddressLine().add(newValue);
    return newValue;
  }

  /**
   * Sets the value of the addressLine property Objects of the following type(s)
   * are allowed in the list List &lt;AddressLine&gt;.
   * <p>
   * Note:
   * <p>
   * This method does not make use of the fluent pattern.If you would like to
   * make it fluent, use {@link #withAddressLine} instead.
   *
   * @param addressLine
   */
  public void setAddressLine(final List<AddressLine> addressLine) {
    this.addressLine = addressLine;
  }

  /**
   * add a value to the addressLine property collection
   *
   * @param addressLine Objects of the following type are allowed in the list:
   *                    {@link AddressLine}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public AddressLines addToAddressLine(final AddressLine addressLine) {
    this.getAddressLine().add(addressLine);
    return this;
  }

  /**
   * Sets the value of the any property Objects of the following type(s) are
   * allowed in the list List &lt;Object&gt;.
   * <p>
   * Note:
   * <p>
   * This method does not make use of the fluent pattern.If you would like to
   * make it fluent, use {@link #withAny} instead.
   *
   * @param any
   */
  public void setAny(final List<Object> any) {
    this.any = any;
  }

  /**
   * add a value to the any property collection
   *
   * @param any Objects of the following type are allowed in the list:
   *            {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public AddressLines addToAny(final Object any) {
    this.getAny().add(any);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAny(List &lt;Object&gt;)
   *
   * @param any required parameter
   */
  public AddressLines withAny(final List<Object> any) {
    this.setAny(any);
    return this;
  }

  @Override
  public AddressLines clone() {
    AddressLines copy;
    try {
      copy = ((AddressLines) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.addressLine = new ArrayList<>((getAddressLine().size()));
    for (AddressLine iter : addressLine) {
      copy.addressLine.add(iter.clone());
    }
    copy.any = new ArrayList<>((getAny().size()));
    for (Object iter : any) {
      copy.any.add(iter);
    }
    return copy;
  }

}
