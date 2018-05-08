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
 * &lt;snippet maxlines="2" &gt;
 * <p>
 * A short description of the feature. In Google Earth, this description is
 * displayed in the Places panel under the name of the feature. If a Snippet is
 * not supplied, the first two lines of the &lt;description&gt; are used. In
 * Google Earth, if a Placemark contains both a description and a Snippet, the
 * &lt;Snippet&gt; appears beneath the Placemark in the Places panel, and the
 * &lt;description&gt; appears in the Placemark's description balloon. This tag
 * does not support HTML markup. &lt;Snippet&gt; has a maxLines attribute, an
 * integer that specifies the maximum number of lines to display.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SnippetType", propOrder = {
  "value"
})
@Deprecated
@XmlRootElement(name = "Snippet", namespace = "http://www.opengis.net/kml/2.2")
public class Snippet implements Cloneable {

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
  @XmlAttribute(name = "maxLines")
  protected int maxLines;

  public Snippet() {
    super();
  }

  /**
   * @see value
   *
   * @return possible object is {@link String}
   *
   */
  public String getValue() {
    return value;
  }

  /**
   * @see value
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * @see maxLines
   *
   */
  public int getMaxLines() {
    return maxLines;
  }

  /**
   * @see maxLines
   *
   */
  public void setMaxLines(int value) {
    this.maxLines = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((value == null) ? 0 : value.hashCode()));
    result = ((prime * result) + maxLines);
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
    if ((obj instanceof Snippet) == false) {
      return false;
    }
    Snippet other = ((Snippet) obj);
    if (value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (value.equals(other.value) == false) {
      return false;
    }
    if (maxLines != other.maxLines) {
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
  public Snippet withValue(final String value) {
    this.setValue(value);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setMaxLines(int)
   *
   * @param maxLines required parameter
   */
  public Snippet withMaxLines(final int maxLines) {
    this.setMaxLines(maxLines);
    return this;
  }

  @Override
  public Snippet clone() {
    Snippet copy;
    try {
      copy = ((Snippet) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    return copy;
  }

}
