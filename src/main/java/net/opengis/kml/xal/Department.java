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
@XmlType(name = "", propOrder = {
  "addressLine",
  "departmentName",
  "mailStop",
  "postalCode",
  "any"
})
@XmlRootElement(name = "Department")
public class Department implements Cloneable {

  @XmlElement(name = "AddressLine")
  protected List<AddressLine> addressLine;
  @XmlElement(name = "DepartmentName")
  protected List<Department.DepartmentName> departmentName;
  @XmlElement(name = "MailStop")
  protected MailStop mailStop;
  @XmlElement(name = "PostalCode")
  protected PostalCode postalCode;
  @XmlAnyElement(lax = true)
  protected List<Object> any;
  @XmlAttribute(name = "Type")
  @XmlSchemaType(name = "anySimpleType")
  protected String underscore;
  @XmlAnyAttribute
  private Map<QName, String> otherAttributes = new HashMap<>();

  public Department() {
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
  public List<Department.DepartmentName> getDepartmentName() {
    if (departmentName == null) {
      departmentName = new ArrayList<>();
    }
    return this.departmentName;
  }

  /**
   * @return possible object is {@link MailStop}
   *
   */
  public MailStop getMailStop() {
    return mailStop;
  }

  /**
   * @param value allowed object is {@link MailStop}
   *
   */
  public void setMailStop(MailStop value) {
    this.mailStop = value;
  }

  /**
   * @return possible object is {@link PostalCode}
   *
   */
  public PostalCode getPostalCode() {
    return postalCode;
  }

  /**
   * @param value allowed object is {@link PostalCode}
   *
   */
  public void setPostalCode(PostalCode value) {
    this.postalCode = value;
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
   * @return possible object is {@link String}
   *
   */
  public String getUnderscore() {
    return underscore;
  }

  /**
   * @param value allowed object is {@link String}
   *
   */
  public void setUnderscore(String value) {
    this.underscore = value;
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
    result = ((prime * result) + ((departmentName == null) ? 0 : departmentName.hashCode()));
    result = ((prime * result) + ((mailStop == null) ? 0 : mailStop.hashCode()));
    result = ((prime * result) + ((postalCode == null) ? 0 : postalCode.hashCode()));
    result = ((prime * result) + ((any == null) ? 0 : any.hashCode()));
    result = ((prime * result) + ((underscore == null) ? 0 : underscore.hashCode()));
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
    if ((obj instanceof Department) == false) {
      return false;
    }
    Department other = ((Department) obj);
    if (addressLine == null) {
      if (other.addressLine != null) {
        return false;
      }
    } else if (addressLine.equals(other.addressLine) == false) {
      return false;
    }
    if (departmentName == null) {
      if (other.departmentName != null) {
        return false;
      }
    } else if (departmentName.equals(other.departmentName) == false) {
      return false;
    }
    if (mailStop == null) {
      if (other.mailStop != null) {
        return false;
      }
    } else if (mailStop.equals(other.mailStop) == false) {
      return false;
    }
    if (postalCode == null) {
      if (other.postalCode != null) {
        return false;
      }
    } else if (postalCode.equals(other.postalCode) == false) {
      return false;
    }
    if (any == null) {
      if (other.any != null) {
        return false;
      }
    } else if (any.equals(other.any) == false) {
      return false;
    }
    if (underscore == null) {
      if (other.underscore != null) {
        return false;
      }
    } else if (underscore.equals(other.underscore) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link AddressLine} and adds it to addressLine.
   * This method is a short version for:     &lt;code&gt;
   * AddressLine addressLine = new AddressLine();
   * this.getAddressLine().add(addressLine);  &lt;/code&gt;
   */
  public AddressLine createAndAddAddressLine() {
    AddressLine newValue = new AddressLine();
    this.getAddressLine().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Department.DepartmentName} and adds it to
   * departmentName. This method is a short version for:     &lt;code&gt;
   * DepartmentName departmentName = new DepartmentName();
   * this.getDepartmentName().add(departmentName);  &lt;/code&gt;
   */
  public Department.DepartmentName createAndAddDepartmentName() {
    Department.DepartmentName newValue = new Department.DepartmentName();
    this.getDepartmentName().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link MailStop} and set it to mailStop.
   *   
   * This method is a short version for:     &lt;code&gt;
   * MailStop mailStop = new MailStop();
   * this.setMailStop(mailStop);  &lt;/code&gt;
   */
  public MailStop createAndSetMailStop() {
    MailStop newValue = new MailStop();
    this.setMailStop(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link PostalCode} and set it to postalCode.
   *   
   * This method is a short version for:     &lt;code&gt;
   * PostalCode postalCode = new PostalCode();
   * this.setPostalCode(postalCode);  &lt;/code&gt;
   */
  public PostalCode createAndSetPostalCode() {
    PostalCode newValue = new PostalCode();
    this.setPostalCode(newValue);
    return newValue;
  }

  /**
   * Sets the value of the addressLine property Objects of the following type(s)
   * are allowed in the list List &lt;AddressLine&gt;.
   *   
   * Note:
   *   
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
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Department addToAddressLine(final AddressLine addressLine) {
    this.getAddressLine().add(addressLine);
    return this;
  }

  /**
   * Sets the value of the departmentName property Objects of the following
   * type(s) are allowed in the list List &lt;DepartmentName&gt;.
   *   
   * Note:
   *   
   * This method does not make use of the fluent pattern.If you would like to
   * make it fluent, use {@link #withDepartmentName} instead.
   *
   * @param departmentName
   */
  public void setDepartmentName(final List<Department.DepartmentName> departmentName) {
    this.departmentName = departmentName;
  }

  /**
   * add a value to the departmentName property collection
   *
   * @param departmentName Objects of the following type are allowed in the
   *                       list: {@link Department.DepartmentName}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Department addToDepartmentName(final Department.DepartmentName departmentName) {
    this.getDepartmentName().add(departmentName);
    return this;
  }

  /**
   * Sets the value of the any property Objects of the following type(s) are
   * allowed in the list List &lt;Object&gt;.
   *   
   * Note:
   *   
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
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Department addToAny(final Object any) {
    this.getAny().add(any);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAddressLine(List &lt;AddressLine&gt;)
   *
   * @param addressLine required parameter
   */
  public Department withAddressLine(final List<AddressLine> addressLine) {
    this.setAddressLine(addressLine);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setDepartmentName(List &lt;DepartmentName&gt;)
   *
   * @param departmentName required parameter
   */
  public Department withDepartmentName(final List<Department.DepartmentName> departmentName) {
    this.setDepartmentName(departmentName);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setMailStop(MailStop)
   *
   * @param mailStop required parameter
   */
  public Department withMailStop(final MailStop mailStop) {
    this.setMailStop(mailStop);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPostalCode(PostalCode)
   *
   * @param postalCode required parameter
   */
  public Department withPostalCode(final PostalCode postalCode) {
    this.setPostalCode(postalCode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAny(List &lt;Object&gt;)
   *
   * @param any required parameter
   */
  public Department withAny(final List<Object> any) {
    this.setAny(any);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setUnderscore(String)
   *
   * @param underscore required parameter
   */
  public Department withUnderscore(final String underscore) {
    this.setUnderscore(underscore);
    return this;
  }

  @Override
  public Department clone() {
    Department copy;
    try {
      copy = ((Department) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.addressLine = new ArrayList<>((getAddressLine().size()));
    for (AddressLine iter : addressLine) {
      copy.addressLine.add(iter.clone());
    }
    copy.departmentName = new ArrayList<>((getDepartmentName().size()));
    for (Department.DepartmentName iter : departmentName) {
      copy.departmentName.add(iter.clone());
    }
    copy.mailStop = ((mailStop == null) ? null : ((MailStop) mailStop.clone()));
    copy.postalCode = ((postalCode == null) ? null : ((PostalCode) postalCode.clone()));
    copy.any = new ArrayList<>((getAny().size()));
    for (Object iter : any) {
      copy.any.add(iter);
    }
    return copy;
  }

  /*
   *
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = {
    "content"
  })
  @XmlRootElement(name = "DepartmentName", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
  public static class DepartmentName implements Cloneable {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "Type")
    @XmlSchemaType(name = "anySimpleType")
    protected String underscore;
    @XmlAttribute(name = "Code")
    @XmlSchemaType(name = "anySimpleType")
    protected String code;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<>();

    public DepartmentName() {
      super();
    }

    /**
     * @return possible object is {@link String}
     *
     */
    public String getContent() {
      return content;
    }

    /**
     * @param value allowed object is {@link String}
     *
     */
    public void setContent(String value) {
      this.content = value;
    }

    /**
     * @return possible object is {@link String}
     *
     */
    public String getUnderscore() {
      return underscore;
    }

    /**
     * @param value allowed object is {@link String}
     *
     */
    public void setUnderscore(String value) {
      this.underscore = value;
    }

    /**
     * @return possible object is {@link String}
     *
     */
    public String getCode() {
      return code;
    }

    /**
     * @param value allowed object is {@link String}
     *
     */
    public void setCode(String value) {
      this.code = value;
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
      result = ((prime * result) + ((content == null) ? 0 : content.hashCode()));
      result = ((prime * result) + ((underscore == null) ? 0 : underscore.hashCode()));
      result = ((prime * result) + ((code == null) ? 0 : code.hashCode()));
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
      if ((obj instanceof Department.DepartmentName) == false) {
        return false;
      }
      Department.DepartmentName other = ((Department.DepartmentName) obj);
      if (content == null) {
        if (other.content != null) {
          return false;
        }
      } else if (content.equals(other.content) == false) {
        return false;
      }
      if (underscore == null) {
        if (other.underscore != null) {
          return false;
        }
      } else if (underscore.equals(other.underscore) == false) {
        return false;
      }
      if (code == null) {
        if (other.code != null) {
          return false;
        }
      } else if (code.equals(other.code) == false) {
        return false;
      }
      return true;
    }

    /**
     * fluent setter
     *
     * @see #setContent(String)
     *
     * @param content required parameter
     */
    public Department.DepartmentName withContent(final String content) {
      this.setContent(content);
      return this;
    }

    /**
     * fluent setter
     *
     * @see #setUnderscore(String)
     *
     * @param underscore required parameter
     */
    public Department.DepartmentName withUnderscore(final String underscore) {
      this.setUnderscore(underscore);
      return this;
    }

    /**
     * fluent setter
     *
     * @see #setCode(String)
     *
     * @param code required parameter
     */
    public Department.DepartmentName withCode(final String code) {
      this.setCode(code);
      return this;
    }

    @Override
    public Department.DepartmentName clone() {
      Department.DepartmentName copy;
      try {
        copy = ((Department.DepartmentName) super.clone());
      } catch (CloneNotSupportedException _x) {
        throw new InternalError((_x.toString()));
      }
      return copy;
    }

  }

}
