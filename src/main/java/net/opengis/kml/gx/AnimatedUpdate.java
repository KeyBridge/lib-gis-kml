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
import net.opengis.kml.Update;
import net.opengis.kml.annotations.Obvious;

/**
 * &lt;gx:AnimatedUpdate&gt;
 * <p>
 * &lt;gx:AnimatedUpdate&gt; controls changes during a tour to KML features,
 * using &lt;Update&gt;. Changes to KML features will not modify the DOM - that
 * is, any changes will be reverted when the tour is over, and will not be saved
 * in the KML at any time. &lt;gx:AnimatedUpdate&gt; should also contain a
 * &lt;gx:duration&gt; value to specify the length of time in seconds over which
 * the update takes place. Integer, float, and color fields are smoothly
 * animated from original to new value across the duration; boolean, string, and
 * other values that don't lend to interpolation are updated at the end of the
 * duration. Refer to Tour timelines in the Touring chapter of the KML
 * Developer's Guide for information about &lt;gx:AnimatedUpdate&gt; and the
 * tour timeline. Syntax:
 * <pre>&lt;gx:AnimatedUpdate&gt;
 *   &lt;gx:duration&gt;0.0&lt;/gx:duration&gt;    &lt;!-- double, specifies time in seconds --&gt;
 *   &lt;Update&gt;
 *     &lt;targetHref&gt;...&lt;/targetHref&gt;    &lt;!-- required; can contain a URL or be left blank --&gt;
 *                                                 &lt;!-- (to target elements within the same file --&gt;
 *     &lt;Change&gt;...&lt;/Change&gt;
 *     &lt;Create&gt;...&lt;/Create&gt;
 *     &lt;Delete&gt;...&lt;/Delete&gt;
 *   &lt;/Update&gt;
 * &lt;/gx:AnimatedUpdate&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;gx:TourPrimitive&gt;
 *
 * Contains:
 * @see: &lt;Update&gt;
 * @see: &lt;gx:duration&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnimatedUpdateType", propOrder = {
  "duration",
  "update",
  "delayedStart"
})
@XmlRootElement(name = "AnimatedUpdate", namespace = "http://www.google.com/kml/ext/2.2")
public class AnimatedUpdate
  extends TourPrimitive
  implements Cloneable {

  /**
   * &lt;gx:duration&gt;
   * <p>
   * &lt;gx:AnimatedUpdate&gt; &lt;gx:duration&gt;5.0 &lt;/gx:duration&gt;
   * &lt;Update&gt; .... &lt;/Update&gt; &lt;/gx:AnimatedUpdate&gt;
   * &lt;gx:FlyTo&gt; &lt;gx:flyToMode&gt;bounce &lt;/gx:flyToMode&gt;
   * &lt;gx:duration&gt;10.2 &lt;/gx:duration&gt; &lt;!-- AbstractView --&gt;
   * ... &lt;!-- /AbstractView --&gt; &lt;/gx:FlyTo&gt; &lt;gx:duration&gt;
   * extends gx:TourPrimitive by specifying a time-span for events. The time is
   * written as seconds using XML's double datatype. Duration and
   * &lt;gx:AnimatedUpdate&gt; Duration and &lt;gx:FlyTo&gt; Specifies the
   * length of time over which the update takes place. Integer, float, and color
   * fields are smoothly animated from original to new value across the
   * duration; boolean, string, and other values that don't lend to
   * interpolation are updated at the end of the duration. When a duration is
   * included within a &lt;gx:FlyTo&gt; element, it specifies the length of time
   * that the browser takes to fly from the previous point to the specified
   * point. Syntax:
   * <pre>&lt;gx:duration&gt;0.0&lt;/gx:duration&gt;            &lt;!-- double --&gt;
   * </pre>
   * <p>
   */
  @XmlElement(defaultValue = "0.0")
  protected double duration;
  /**
   * &lt;Update&gt;
   * <p>
   * Specifies an addition, change, or deletion to KML data that has already
   * been loaded using the specified URL. The &lt;targetHref&gt; specifies the
   * .kml or .kmz file whose data (within Google Earth) is to be modified.
   * &lt;Update&gt; is always contained in a NetworkLinkControl. Furthermore,
   * the file containing the NetworkLinkControl must have been loaded by a
   * NetworkLink. See the "Topics in KML" page on Updates for a detailed example
   * of how Update works. With &lt;Update&gt;, you can specify any number of
   * Change, Create, and Delete tags for a .kml file or .kmz archive that has
   * previously been loaded with a network link. See &lt;Update&gt;. Syntax:
   * <pre> &lt;strong&gt;&lt;Update&gt;
   *    &lt;/strong&gt;&lt;targetHref&gt;...&lt;targetHref&gt;    &lt;!-- URL --&gt;
   *   &lt;Change&gt;...&lt;/Change&gt;
   *   &lt;Create&gt;...&lt;/Create&gt;
   *   &lt;Delete&gt;...&lt;/Delete&gt;
   *  &lt;strong&gt;&lt;/Update&gt; &lt;/strong&gt; </pre>
   * <p>
   * Contained By:
   *
   * @see: &lt;NetworkLinkControl&gt;
   * @see: Note: This element was deprecated in KML Release 2.1 and is replaced
   * by &lt;Link&gt;, which provides the additional functionality of Regions.
   * The &lt;Url&gt; tag will still work in Google Earth, but use of the newer
   * &lt;Link&gt; tag is encouraged.
   * @see: Use this element to set the location of the link to the KML file, to
   * define the refresh options for the server and viewer changes, and to
   * populate a variable to return useful client information to the server.
   *
   */
  @XmlElement(name = "Update", namespace = "http://www.opengis.net/kml/2.2")
  protected Update update;
  @XmlElement(defaultValue = "0.0")
  protected double delayedStart;

  public AnimatedUpdate() {
    super();
  }

  /**
   * @see duration
   *
   * @return possible object is {@code Double}
   *
   */
  public double getDuration() {
    return duration;
  }

  /**
   * @see duration
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setDuration(double value) {
    this.duration = value;
  }

  /**
   * @see update
   *
   * @return possible object is {@code Update}
   *
   */
  public Update getUpdate() {
    return update;
  }

  /**
   * @see update
   *
   * @param value allowed object is {@code Update}
   *
   */
  public void setUpdate(Update value) {
    this.update = value;
  }

  /**
   * @see delayedStart
   *
   * @return possible object is {@code Double}
   *
   */
  public double getDelayedStart() {
    return delayedStart;
  }

  /**
   * @see delayedStart
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setDelayedStart(double value) {
    this.delayedStart = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(duration);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((update == null) ? 0 : update.hashCode()));
    temp = Double.doubleToLongBits(delayedStart);
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
    if ((obj instanceof AnimatedUpdate) == false) {
      return false;
    }
    AnimatedUpdate other = ((AnimatedUpdate) obj);
    if (duration != other.duration) {
      return false;
    }
    if (update == null) {
      if (other.update != null) {
        return false;
      }
    } else if (update.equals(other.update) == false) {
      return false;
    }
    if (delayedStart != other.delayedStart) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code Update} and set it to update.
   * <p>
   * This method is a short version for: &lt;code&gt; Update update = new
   * Update(); this.setUpdate(update); &lt;/code&gt;
   *
   * @param createOrDeleteOrChange required parameter
   * @param targetHref             required parameter
   */
  public Update createAndSetUpdate(final String targetHref, final List<Object> createOrDeleteOrChange) {
    Update newValue = new Update(targetHref, createOrDeleteOrChange);
    this.setUpdate(newValue);
    return newValue;
  }

  /**
   * fluent setter
   *
   * @see #setDuration(double)
   *
   * @param duration required parameter
   */
  public AnimatedUpdate withDuration(final double duration) {
    this.setDuration(duration);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setUpdate(Update)
   *
   * @param update required parameter
   */
  public AnimatedUpdate withUpdate(final Update update) {
    this.setUpdate(update);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setDelayedStart(double)
   *
   * @param delayedStart required parameter
   */
  public AnimatedUpdate withDelayedStart(final double delayedStart) {
    this.setDelayedStart(delayedStart);
    return this;
  }

  @Obvious
  @Override
  public AnimatedUpdate withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public AnimatedUpdate withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public AnimatedUpdate withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public AnimatedUpdate clone() {
    AnimatedUpdate copy;
    copy = ((AnimatedUpdate) super.clone());
    copy.update = ((update == null) ? null : ((Update) update.clone()));
    return copy;
  }

}
