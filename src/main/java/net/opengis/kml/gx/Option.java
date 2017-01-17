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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.opengis.kml.gx;

import javax.xml.bind.annotation.*;

/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "optionType")
@XmlRootElement(name = "Option", namespace = "http://www.google.com/kml/ext/2.2")
public class Option implements Cloneable {

  @XmlAttribute(name = "name")
  protected String name;
  @XmlAttribute(name = "enabled")
  protected boolean enabled;

  public Option() {
    super();
  }

  /**
   *
   * @return possible object is {@link String}
   *
   */
  public String getName() {
    return name;
  }

  /**
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   *
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   *
   */
  public void setEnabled(boolean value) {
    this.enabled = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((name == null) ? 0 : name.hashCode()));
    result = ((prime * result) + (new Boolean(enabled).hashCode()));
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
    if ((obj instanceof Option) == false) {
      return false;
    }
    Option other = ((Option) obj);
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (name.equals(other.name) == false) {
      return false;
    }
    if (enabled != other.enabled) {
      return false;
    }
    return true;
  }

  /**
   * fluent setter
   *
   * @see #setName(String)
   *
   * @param name required parameter
   */
  public Option withName(final String name) {
    this.setName(name);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setEnabled(boolean)
   *
   * @param enabled required parameter
   */
  public Option withEnabled(final boolean enabled) {
    this.setEnabled(enabled);
    return this;
  }

  @Override
  public Option clone() {
    Option copy;
    try {
      copy = ((Option) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    return copy;
  }

}
