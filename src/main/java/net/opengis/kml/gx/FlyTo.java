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
import net.opengis.kml.AbstractView;
import net.opengis.kml.Camera;
import net.opengis.kml.LookAt;
import net.opengis.kml.annotations.Obvious;

/**
 * &lt;gx:FlyTo&gt;
 * <p>
 * &lt;gx:FlyTo&gt; specifies a point in space to which the browser will fly
 * during a tour. It must contain one AbstractView, and should contain
 * &lt;gx:duration&gt; and &lt;gx:flyToMode&gt; elements, which specify the time
 * it takes to fly to the defined point from the current point, and the method
 * of flight, respectively. Syntax:
 * <pre>&lt;gx:FlyTo&gt;
 *   &lt;gx:duration&gt;0.0&lt;/gx:duration&gt;         &lt;!-- double --&gt;
 *   &lt;gx:flyToMode&gt;bounce&lt;/gx:duration&gt;      &lt;!--  &lt;em&gt;smooth &lt;/em&gt; or  &lt;em&gt;bounce &lt;/em&gt; --&gt;
 *   &lt;!-- AbstractView --&gt;                   &lt;!--  &lt;em&gt;Camera &lt;/em&gt; or  &lt;em&gt;LookAt &lt;/em&gt; --&gt;
 *     ...
 *   &lt;!-- /AbstractView --&gt;
 * &lt;/gx:FlyTo&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;gx:TourPrimitive&gt;
 *
 * Contains:
 * @see: &lt;AbstractView&gt;
 * @see: &lt;gx:duration&gt;
 * @see: &lt;gx:flyToMode&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlyToType", propOrder = {
  "duration",
  "flyToMode",
  "abstractView"
})
@XmlRootElement(name = "FlyTo", namespace = "http://www.google.com/kml/ext/2.2")
public class FlyTo
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
  @XmlElement(defaultValue = "bounce")
  protected FlyToMode flyToMode;
  /**
   * &lt;abstractview&gt;
   * <p>
   * Defines a viewpoint associated with any element derived from Feature. See
   * &lt;Camera&gt; and &lt;LookAt&gt;. This is an abstract element and cannot
   * be used directly in a KML file. This element is extended by the
   * &lt;Camera&gt; and &lt;LookAt&gt; elements. Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt;
   *  &lt;strong&gt;&lt;!-- &lt;em&gt; AbstractView &lt;/em&gt; --&gt; &lt;/strong&gt;                   &lt;!-- Camera, LookAt --&gt;
   *   &lt;!-- extends  &lt;span class="style1"&gt;Object &lt;/span&gt; --&gt;
   *    &lt;em&gt;&lt;TimePrimitive&gt;...&lt;/TimePrimitive&gt; &lt;/em&gt;                        &lt;!-- gx:TimeSpan or gx:TimeStamp --&gt;
   *  &lt;strong&gt;&lt;-- / &lt;em&gt;AbstractView &lt;/em&gt; --&gt; &lt;/strong&gt;
   * </pre>
   * <p>
   * Extends:
   *
   * @see: &lt;Object&gt;
   *
   * Extended By:
   * @see: &lt;Camera&gt;
   * @see: &lt;LookAt&gt;
   *
   */
  @XmlElementRef(name = "AbstractViewGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected AbstractView abstractView;

  public FlyTo() {
    super();
  }

  /**
   * @see duration
   *
   * @return possible object is {@link Double}
   *
   */
  public double getDuration() {
    return duration;
  }

  /**
   * @see duration
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setDuration(double value) {
    this.duration = value;
  }

  /**
   * @see flyToMode
   *
   * @return possible object is {@link FlyToMode}
   *
   */
  public FlyToMode getFlyToMode() {
    return flyToMode;
  }

  /**
   * @see flyToMode
   *
   * @param value allowed object is {@link FlyToMode}
   *
   */
  public void setFlyToMode(FlyToMode value) {
    this.flyToMode = value;
  }

  /**
   * @see abstractView
   *
   * @return possible object is null null null null null null null null null null   {@link AbstractView}
     *     {@link LookAt}
   *     {@link Camera}
   *
   */
  public AbstractView getAbstractView() {
    return abstractView;
  }

  /**
   * @see abstractView
   *
   * @param value allowed object is null null null null null null null null null null   {@link AbstractView}
     *     {@link LookAt}
   *     {@link Camera}
   *
   */
  public void setAbstractView(AbstractView value) {
    this.abstractView = ((AbstractView) value);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(duration);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((flyToMode == null) ? 0 : flyToMode.hashCode()));
    result = ((prime * result) + ((abstractView == null) ? 0 : abstractView.hashCode()));
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
    if ((obj instanceof FlyTo) == false) {
      return false;
    }
    FlyTo other = ((FlyTo) obj);
    if (duration != other.duration) {
      return false;
    }
    if (flyToMode == null) {
      if (other.flyToMode != null) {
        return false;
      }
    } else if (flyToMode.equals(other.flyToMode) == false) {
      return false;
    }
    if (abstractView == null) {
      if (other.abstractView != null) {
        return false;
      }
    } else if (abstractView.equals(other.abstractView) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link LookAt} and set it to abstractView.
   * <p>
   * This method is a short version for: &lt;code&gt; LookAt lookAt = new
   * LookAt(); this.setAbstractView(lookAt); &lt;/code&gt;
   */
  public LookAt createAndSetLookAt() {
    LookAt newValue = new LookAt();
    this.setAbstractView(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Camera} and set it to abstractView.
   * <p>
   * This method is a short version for: &lt;code&gt; Camera camera = new
   * Camera(); this.setAbstractView(camera); &lt;/code&gt;
   */
  public Camera createAndSetCamera() {
    Camera newValue = new Camera();
    this.setAbstractView(newValue);
    return newValue;
  }

  /**
   * fluent setter
   *
   * @see #setDuration(double)
   *
   * @param duration required parameter
   */
  public FlyTo withDuration(final double duration) {
    this.setDuration(duration);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setFlyToMode(FlyToMode)
   *
   * @param flyToMode required parameter
   */
  public FlyTo withFlyToMode(final FlyToMode flyToMode) {
    this.setFlyToMode(flyToMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAbstractView(AbstractView)
   *
   * @param abstractView required parameter
   */
  public FlyTo withAbstractView(final AbstractView abstractView) {
    this.setAbstractView(abstractView);
    return this;
  }

  @Obvious
  @Override
  public FlyTo withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public FlyTo withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public FlyTo withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public FlyTo clone() {
    FlyTo copy;
    copy = ((FlyTo) super.clone());
    copy.abstractView = ((abstractView == null) ? null : ((AbstractView) abstractView.clone()));
    return copy;
  }

}
