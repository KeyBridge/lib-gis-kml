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

import java.util.List;
import javax.xml.bind.annotation.*;
import net.opengis.kml.annotations.Obvious;

/*
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaitType", propOrder = {
  "duration"
})
@XmlRootElement(name = "Wait", namespace = "http://www.google.com/kml/ext/2.2")
public class Wait
  extends TourPrimitive
  implements Cloneable {

  @XmlElement(defaultValue = "0.0")
  protected double duration;

  public Wait() {
    super();
  }

  /**
   * @return possible object is {@link Double}
   *
   */
  public double getDuration() {
    return duration;
  }

  /**
   * @param value allowed object is {@link Double}
   *
   */
  public void setDuration(double value) {
    this.duration = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(duration);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
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
    if ((obj instanceof Wait) == false) {
      return false;
    }
    Wait other = ((Wait) obj);
    if (duration != other.duration) {
      return false;
    }
    return true;
  }

  /**
   * fluent setter
   *
   * @see #setDuration(double)
   *
   * @param duration required parameter
   */
  public Wait withDuration(final double duration) {
    this.setDuration(duration);
    return this;
  }

  @Obvious
  @Override
  public Wait withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Wait withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Wait withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public Wait clone() {
    Wait copy;
    copy = ((Wait) super.clone());
    return copy;
  }

}
