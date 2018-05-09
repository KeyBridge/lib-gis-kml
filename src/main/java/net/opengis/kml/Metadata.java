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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import org.w3c.dom.Element;

/**
 * &lt;metadata&gt; (deprecated in kml 2.2; use &lt;extendeddata&gt; instead)
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetadataType", propOrder = {
  "any"
})
@Deprecated
@XmlRootElement(name = "Metadata", namespace = "http://www.opengis.net/kml/2.2")
public class Metadata implements Cloneable {

  @XmlAnyElement(lax = true)
  protected List<Object> any;

  public Metadata() {
    super();
  }

  /**
   * @see any
   *
   */
  public List<Object> getAny() {
    if (any == null) {
      any = new ArrayList<>();
    }
    return this.any;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    if ((obj instanceof Metadata) == false) {
      return false;
    }
    Metadata other = ((Metadata) obj);
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
   * @see any
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
   *            {@code Object}{@code Element}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Metadata addToAny(final Object any) {
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
  public Metadata withAny(final List<Object> any) {
    this.setAny(any);
    return this;
  }

  @Override
  public Metadata clone() {
    Metadata copy;
    try {
      copy = ((Metadata) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.any = new ArrayList<>((getAny().size()));
    for (Object iter : any) {
      copy.any.add(iter);
    }
    return copy;
  }

}
