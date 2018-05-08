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
@XmlType(name = "PostalRouteType", propOrder = {
  "addressLine",
  "postalRouteName",
  "postalRouteNumber",
  "postBox",
  "any"
})
@XmlRootElement(name = "PostalRoute", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
public class PostalRoute implements Cloneable {

  @XmlElement(name = "AddressLine")
  protected List<AddressLine> addressLine;
  @XmlElement(name = "PostalRouteName")
  protected List<PostalRoute.PostalRouteName> postalRouteName;
  @XmlElement(name = "PostalRouteNumber")
  protected PostalRoute.PostalRouteNumber postalRouteNumber;
  @XmlElement(name = "PostBox")
  protected PostBox postBox;
  @XmlAnyElement(lax = true)
  protected List<Object> any;
  @XmlAttribute(name = "Type")
  @XmlSchemaType(name = "anySimpleType")
  protected String underscore;
  @XmlAnyAttribute
  private Map<QName, String> otherAttributes = new HashMap<>();

  /**
   * Value constructor with only mandatory fields
   *
   * @param postalRouteName   required parameter
   * @param postalRouteNumber required parameter
   */
  public PostalRoute(final List<PostalRoute.PostalRouteName> postalRouteName, final PostalRoute.PostalRouteNumber postalRouteNumber) {
    super();
    this.postalRouteName = postalRouteName;
    this.postalRouteNumber = postalRouteNumber;
  }

  /**
   * Default no-arg constructor is private. Use overloaded constructor instead!
   * (Temporary solution, till a better and more suitable ObjectFactory is
   * created.)
   * <p>
   */
  @Deprecated
  private PostalRoute() {
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
  public List<PostalRoute.PostalRouteName> getPostalRouteName() {
    if (postalRouteName == null) {
      postalRouteName = new ArrayList<>();
    }
    return this.postalRouteName;
  }

  /**
   * @return possible object is {@link PostalRoute.PostalRouteNumber}
   *
   */
  public PostalRoute.PostalRouteNumber getPostalRouteNumber() {
    return postalRouteNumber;
  }

  /**
   * @param value allowed object is {@link PostalRoute.PostalRouteNumber}
   *
   */
  public void setPostalRouteNumber(PostalRoute.PostalRouteNumber value) {
    this.postalRouteNumber = value;
  }

  /**
   * @return possible object is {@link PostBox}
   *
   */
  public PostBox getPostBox() {
    return postBox;
  }

  /**
   * @param value allowed object is {@link PostBox}
   *
   */
  public void setPostBox(PostBox value) {
    this.postBox = value;
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
    result = ((prime * result) + ((postalRouteName == null) ? 0 : postalRouteName.hashCode()));
    result = ((prime * result) + ((postalRouteNumber == null) ? 0 : postalRouteNumber.hashCode()));
    result = ((prime * result) + ((postBox == null) ? 0 : postBox.hashCode()));
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
    if ((obj instanceof PostalRoute) == false) {
      return false;
    }
    PostalRoute other = ((PostalRoute) obj);
    if (addressLine == null) {
      if (other.addressLine != null) {
        return false;
      }
    } else if (addressLine.equals(other.addressLine) == false) {
      return false;
    }
    if (postalRouteName == null) {
      if (other.postalRouteName != null) {
        return false;
      }
    } else if (postalRouteName.equals(other.postalRouteName) == false) {
      return false;
    }
    if (postalRouteNumber == null) {
      if (other.postalRouteNumber != null) {
        return false;
      }
    } else if (postalRouteNumber.equals(other.postalRouteNumber) == false) {
      return false;
    }
    if (postBox == null) {
      if (other.postBox != null) {
        return false;
      }
    } else if (postBox.equals(other.postBox) == false) {
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
   * This method is a short version for: &lt;code&gt; AddressLine addressLine =
   * new AddressLine(); this.getAddressLine().add(addressLine); &lt;/code&gt;
   */
  public AddressLine createAndAddAddressLine() {
    AddressLine newValue = new AddressLine();
    this.getAddressLine().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link PostalRoute.PostalRouteName} and adds it
   * to postalRouteName. This method is a short version for: &lt;code&gt;
   * PostalRouteName postalRouteName = new PostalRouteName();
   * this.getPostalRouteName().add(postalRouteName); &lt;/code&gt;
   */
  public PostalRoute.PostalRouteName createAndAddPostalRouteName() {
    PostalRoute.PostalRouteName newValue = new PostalRoute.PostalRouteName();
    this.getPostalRouteName().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link PostalRoute.PostalRouteNumber} and set it
   * to postalRouteNumber.
   * <p>
   * This method is a short version for: &lt;code&gt; PostalRouteNumber
   * postalRouteNumber = new PostalRouteNumber();
   * this.setPostalRouteNumber(postalRouteNumber); &lt;/code&gt;
   */
  public PostalRoute.PostalRouteNumber createAndSetPostalRouteNumber() {
    PostalRoute.PostalRouteNumber newValue = new PostalRoute.PostalRouteNumber();
    this.setPostalRouteNumber(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link PostBox} and set it to postBox.
   * <p>
   * This method is a short version for: &lt;code&gt; PostBox postBox = new
   * PostBox(); this.setPostBox(postBox); &lt;/code&gt;
   *
   * @param postBoxNumber required parameter
   */
  public PostBox createAndSetPostBox(final PostBox.PostBoxNumber postBoxNumber) {
    PostBox newValue = new PostBox(postBoxNumber);
    this.setPostBox(newValue);
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
  public PostalRoute addToAddressLine(final AddressLine addressLine) {
    this.getAddressLine().add(addressLine);
    return this;
  }

  /**
   * Sets the value of the postalRouteName property Objects of the following
   * type(s) are allowed in the list List &lt;PostalRouteName&gt;.
   * <p>
   * Note:
   * <p>
   * This method does not make use of the fluent pattern.If you would like to
   * make it fluent, use {@link #withPostalRouteName} instead.
   *
   * @param postalRouteName
   */
  public void setPostalRouteName(final List<PostalRoute.PostalRouteName> postalRouteName) {
    this.postalRouteName = postalRouteName;
  }

  /**
   * add a value to the postalRouteName property collection
   *
   * @param postalRouteName Objects of the following type are allowed in the
   *                        list: {@link PostalRoute.PostalRouteName}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public PostalRoute addToPostalRouteName(final PostalRoute.PostalRouteName postalRouteName) {
    this.getPostalRouteName().add(postalRouteName);
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
  public PostalRoute addToAny(final Object any) {
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
  public PostalRoute withAddressLine(final List<AddressLine> addressLine) {
    this.setAddressLine(addressLine);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPostBox(PostBox)
   *
   * @param postBox required parameter
   */
  public PostalRoute withPostBox(final PostBox postBox) {
    this.setPostBox(postBox);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAny(List &lt;Object&gt;)
   *
   * @param any required parameter
   */
  public PostalRoute withAny(final List<Object> any) {
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
  public PostalRoute withUnderscore(final String underscore) {
    this.setUnderscore(underscore);
    return this;
  }

  @Override
  public PostalRoute clone() {
    PostalRoute copy;
    try {
      copy = ((PostalRoute) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.addressLine = new ArrayList<>((getAddressLine().size()));
    for (AddressLine iter : addressLine) {
      copy.addressLine.add(iter.clone());
    }
    copy.postalRouteName = new ArrayList<>((getPostalRouteName().size()));
    for (PostalRoute.PostalRouteName iter : postalRouteName) {
      copy.postalRouteName.add(iter.clone());
    }
    copy.postalRouteNumber = ((postalRouteNumber == null) ? null : ((PostalRoute.PostalRouteNumber) postalRouteNumber.clone()));
    copy.postBox = ((postBox == null) ? null : ((PostBox) postBox.clone()));
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
  @XmlRootElement(name = "PostalRouteName", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
  public static class PostalRouteName implements Cloneable {

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

    public PostalRouteName() {
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
      if ((obj instanceof PostalRoute.PostalRouteName) == false) {
        return false;
      }
      PostalRoute.PostalRouteName other = ((PostalRoute.PostalRouteName) obj);
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
    public PostalRoute.PostalRouteName withContent(final String content) {
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
    public PostalRoute.PostalRouteName withUnderscore(final String underscore) {
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
    public PostalRoute.PostalRouteName withCode(final String code) {
      this.setCode(code);
      return this;
    }

    @Override
    public PostalRoute.PostalRouteName clone() {
      PostalRoute.PostalRouteName copy;
      try {
        copy = ((PostalRoute.PostalRouteName) super.clone());
      } catch (CloneNotSupportedException _x) {
        throw new InternalError((_x.toString()));
      }
      return copy;
    }

  }

  /*
   *
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = {
    "content"
  })
  @XmlRootElement(name = "PostalRouteNumber", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
  public static class PostalRouteNumber implements Cloneable {

    @XmlValue
    protected String content;
    @XmlAttribute(name = "Code")
    @XmlSchemaType(name = "anySimpleType")
    protected String code;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<>();

    public PostalRouteNumber() {
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
      if ((obj instanceof PostalRoute.PostalRouteNumber) == false) {
        return false;
      }
      PostalRoute.PostalRouteNumber other = ((PostalRoute.PostalRouteNumber) obj);
      if (content == null) {
        if (other.content != null) {
          return false;
        }
      } else if (content.equals(other.content) == false) {
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
    public PostalRoute.PostalRouteNumber withContent(final String content) {
      this.setContent(content);
      return this;
    }

    /**
     * fluent setter
     *
     * @see #setCode(String)
     *
     * @param code required parameter
     */
    public PostalRoute.PostalRouteNumber withCode(final String code) {
      this.setCode(code);
      return this;
    }

    @Override
    public PostalRoute.PostalRouteNumber clone() {
      PostalRoute.PostalRouteNumber copy;
      try {
        copy = ((PostalRoute.PostalRouteNumber) super.clone());
      } catch (CloneNotSupportedException _x) {
        throw new InternalError((_x.toString()));
      }
      return copy;
    }

  }

}
