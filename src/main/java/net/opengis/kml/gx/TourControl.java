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
@XmlType(name = "TourControlType", propOrder = {
  "playMode"
})
@XmlRootElement(name = "TourControl", namespace = "http://www.google.com/kml/ext/2.2")
public class TourControl
  extends TourPrimitive
  implements Cloneable {

  @XmlElement(defaultValue = "pause")
  protected PlayMode playMode;

  public TourControl() {
    super();
  }

  /**
   * @return possible object is {@link PlayMode}
   *
   */
  public PlayMode getPlayMode() {
    return playMode;
  }

  /**
   * @param value allowed object is {@link PlayMode}
   *
   */
  public void setPlayMode(PlayMode value) {
    this.playMode = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((playMode == null) ? 0 : playMode.hashCode()));
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
    if ((obj instanceof TourControl) == false) {
      return false;
    }
    TourControl other = ((TourControl) obj);
    if (playMode == null) {
      if (other.playMode != null) {
        return false;
      }
    } else if (playMode.equals(other.playMode) == false) {
      return false;
    }
    return true;
  }

  /**
   * fluent setter
   *
   * @see #setPlayMode(PlayMode)
   *
   * @param playMode required parameter
   */
  public TourControl withPlayMode(final PlayMode playMode) {
    this.setPlayMode(playMode);
    return this;
  }

  @Obvious
  @Override
  public TourControl withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public TourControl withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public TourControl withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public TourControl clone() {
    TourControl copy;
    copy = ((TourControl) super.clone());
    return copy;
  }

}
