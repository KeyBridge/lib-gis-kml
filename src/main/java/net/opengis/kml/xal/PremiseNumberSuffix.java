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

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

/*
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
  "content"
})
@XmlRootElement(name = "PremiseNumberSuffix")
public class PremiseNumberSuffix implements Cloneable {

  @XmlValue
  protected String content;
  @XmlAttribute(name = "NumberSuffixSeparator")
  @XmlSchemaType(name = "anySimpleType")
  protected String numberSuffixSeparator;
  @XmlAttribute(name = "Type")
  @XmlSchemaType(name = "anySimpleType")
  protected String underscore;
  @XmlAttribute(name = "Code")
  @XmlSchemaType(name = "anySimpleType")
  protected String code;
  @XmlAnyAttribute
  private Map<QName, String> otherAttributes = new HashMap<>();

  public PremiseNumberSuffix() {
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
  public String getNumberSuffixSeparator() {
    return numberSuffixSeparator;
  }

  /**
   * @param value allowed object is {@link String}
   *
   */
  public void setNumberSuffixSeparator(String value) {
    this.numberSuffixSeparator = value;
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
    result = ((prime * result) + ((numberSuffixSeparator == null) ? 0 : numberSuffixSeparator.hashCode()));
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
    if ((obj instanceof PremiseNumberSuffix) == false) {
      return false;
    }
    PremiseNumberSuffix other = ((PremiseNumberSuffix) obj);
    if (content == null) {
      if (other.content != null) {
        return false;
      }
    } else if (content.equals(other.content) == false) {
      return false;
    }
    if (numberSuffixSeparator == null) {
      if (other.numberSuffixSeparator != null) {
        return false;
      }
    } else if (numberSuffixSeparator.equals(other.numberSuffixSeparator) == false) {
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
  public PremiseNumberSuffix withContent(final String content) {
    this.setContent(content);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setNumberSuffixSeparator(String)
   *
   * @param numberSuffixSeparator required parameter
   */
  public PremiseNumberSuffix withNumberSuffixSeparator(final String numberSuffixSeparator) {
    this.setNumberSuffixSeparator(numberSuffixSeparator);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setUnderscore(String)
   *
   * @param underscore required parameter
   */
  public PremiseNumberSuffix withUnderscore(final String underscore) {
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
  public PremiseNumberSuffix withCode(final String code) {
    this.setCode(code);
    return this;
  }

  @Override
  public PremiseNumberSuffix clone() {
    PremiseNumberSuffix copy;
    try {
      copy = ((PremiseNumberSuffix) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    return copy;
  }

}
