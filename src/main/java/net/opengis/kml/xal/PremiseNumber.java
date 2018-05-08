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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

/*
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
  "content"
})
@XmlRootElement(name = "PremiseNumber")
public class PremiseNumber implements Cloneable {

  @XmlValue
  protected String content;
  @XmlAttribute(name = "NumberType")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String number;
  @XmlAttribute(name = "Type")
  @XmlSchemaType(name = "anySimpleType")
  protected String underscore;
  @XmlAttribute(name = "Indicator")
  @XmlSchemaType(name = "anySimpleType")
  protected String indicator;
  @XmlAttribute(name = "IndicatorOccurrence")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String indicatorOccurrence;
  @XmlAttribute(name = "NumberTypeOccurrence")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  protected String numberTypeOccurrence;
  @XmlAttribute(name = "Code")
  @XmlSchemaType(name = "anySimpleType")
  protected String code;
  @XmlAnyAttribute
  private Map<QName, String> otherAttributes = new HashMap<>();

  public PremiseNumber() {
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
  public String getNumber() {
    return number;
  }

  /**
   * @param value allowed object is {@link String}
   *
   */
  public void setNumber(String value) {
    this.number = value;
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
  public String getIndicator() {
    return indicator;
  }

  /**
   * @param value allowed object is {@link String}
   *
   */
  public void setIndicator(String value) {
    this.indicator = value;
  }

  /**
   * @return possible object is {@link String}
   *
   */
  public String getIndicatorOccurrence() {
    return indicatorOccurrence;
  }

  /**
   * @param value allowed object is {@link String}
   *
   */
  public void setIndicatorOccurrence(String value) {
    this.indicatorOccurrence = value;
  }

  /**
   * @return possible object is {@link String}
   *
   */
  public String getNumberTypeOccurrence() {
    return numberTypeOccurrence;
  }

  /**
   * @param value allowed object is {@link String}
   *
   */
  public void setNumberTypeOccurrence(String value) {
    this.numberTypeOccurrence = value;
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
    result = ((prime * result) + ((number == null) ? 0 : number.hashCode()));
    result = ((prime * result) + ((underscore == null) ? 0 : underscore.hashCode()));
    result = ((prime * result) + ((indicator == null) ? 0 : indicator.hashCode()));
    result = ((prime * result) + ((indicatorOccurrence == null) ? 0 : indicatorOccurrence.hashCode()));
    result = ((prime * result) + ((numberTypeOccurrence == null) ? 0 : numberTypeOccurrence.hashCode()));
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
    if ((obj instanceof PremiseNumber) == false) {
      return false;
    }
    PremiseNumber other = ((PremiseNumber) obj);
    if (content == null) {
      if (other.content != null) {
        return false;
      }
    } else if (content.equals(other.content) == false) {
      return false;
    }
    if (number == null) {
      if (other.number != null) {
        return false;
      }
    } else if (number.equals(other.number) == false) {
      return false;
    }
    if (underscore == null) {
      if (other.underscore != null) {
        return false;
      }
    } else if (underscore.equals(other.underscore) == false) {
      return false;
    }
    if (indicator == null) {
      if (other.indicator != null) {
        return false;
      }
    } else if (indicator.equals(other.indicator) == false) {
      return false;
    }
    if (indicatorOccurrence == null) {
      if (other.indicatorOccurrence != null) {
        return false;
      }
    } else if (indicatorOccurrence.equals(other.indicatorOccurrence) == false) {
      return false;
    }
    if (numberTypeOccurrence == null) {
      if (other.numberTypeOccurrence != null) {
        return false;
      }
    } else if (numberTypeOccurrence.equals(other.numberTypeOccurrence) == false) {
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
  public PremiseNumber withContent(final String content) {
    this.setContent(content);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setNumber(String)
   *
   * @param number required parameter
   */
  public PremiseNumber withNumber(final String number) {
    this.setNumber(number);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setUnderscore(String)
   *
   * @param underscore required parameter
   */
  public PremiseNumber withUnderscore(final String underscore) {
    this.setUnderscore(underscore);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setIndicator(String)
   *
   * @param indicator required parameter
   */
  public PremiseNumber withIndicator(final String indicator) {
    this.setIndicator(indicator);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setIndicatorOccurrence(String)
   *
   * @param indicatorOccurrence required parameter
   */
  public PremiseNumber withIndicatorOccurrence(final String indicatorOccurrence) {
    this.setIndicatorOccurrence(indicatorOccurrence);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setNumberTypeOccurrence(String)
   *
   * @param numberTypeOccurrence required parameter
   */
  public PremiseNumber withNumberTypeOccurrence(final String numberTypeOccurrence) {
    this.setNumberTypeOccurrence(numberTypeOccurrence);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setCode(String)
   *
   * @param code required parameter
   */
  public PremiseNumber withCode(final String code) {
    this.setCode(code);
    return this;
  }

  @Override
  public PremiseNumber clone() {
    PremiseNumber copy;
    try {
      copy = ((PremiseNumber) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    return copy;
  }

}
