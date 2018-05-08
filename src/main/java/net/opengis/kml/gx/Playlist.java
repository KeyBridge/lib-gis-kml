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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import net.opengis.kml.AbstractObject;
import net.opengis.kml.annotations.Obvious;

/*
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlaylistType", propOrder = {
  "tourPrimitive"
})
@XmlRootElement(name = "Playlist", namespace = "http://www.google.com/kml/ext/2.2")
public class Playlist
  extends AbstractObject
  implements Cloneable {

  @XmlElementRef(name = "AbstractTourPrimitiveGroup", namespace = "http://www.google.com/kml/ext/2.2", required = false)
  protected List<TourPrimitive> tourPrimitive;

  public Playlist() {
    super();
  }

  /*
   *
   */
  public List<TourPrimitive> getTourPrimitive() {
    if (tourPrimitive == null) {
      tourPrimitive = new ArrayList<>();
    }
    return this.tourPrimitive;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((tourPrimitive == null) ? 0 : tourPrimitive.hashCode()));
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
    if (super.equals(obj) == false) {
      return false;
    }
    if ((obj instanceof Playlist) == false) {
      return false;
    }
    Playlist other = ((Playlist) obj);
    if (tourPrimitive == null) {
      if (other.tourPrimitive != null) {
        return false;
      }
    } else if (tourPrimitive.equals(other.tourPrimitive) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link Wait} and adds it to tourPrimitive. This
   * method is a short version for: &lt;code&gt; Wait wait = new Wait();
   * this.getTourPrimitive().add(wait); &lt;/code&gt;
   */
  public Wait createAndAddWait() {
    Wait newValue = new Wait();
    this.getTourPrimitive().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link AnimatedUpdate} and adds it to
   * tourPrimitive. This method is a short version for: &lt;code&gt;
   * AnimatedUpdate animatedUpdate = new AnimatedUpdate();
   * this.getTourPrimitive().add(animatedUpdate); &lt;/code&gt;
   */
  public AnimatedUpdate createAndAddAnimatedUpdate() {
    AnimatedUpdate newValue = new AnimatedUpdate();
    this.getTourPrimitive().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link TourControl} and adds it to tourPrimitive.
   * This method is a short version for: &lt;code&gt; TourControl tourControl =
   * new TourControl(); this.getTourPrimitive().add(tourControl); &lt;/code&gt;
   */
  public TourControl createAndAddTourControl() {
    TourControl newValue = new TourControl();
    this.getTourPrimitive().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link FlyTo} and adds it to tourPrimitive. This
   * method is a short version for: &lt;code&gt; FlyTo flyTo = new FlyTo();
   * this.getTourPrimitive().add(flyTo); &lt;/code&gt;
   */
  public FlyTo createAndAddFlyTo() {
    FlyTo newValue = new FlyTo();
    this.getTourPrimitive().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link SoundCue} and adds it to tourPrimitive.
   * This method is a short version for: &lt;code&gt; SoundCue soundCue = new
   * SoundCue(); this.getTourPrimitive().add(soundCue); &lt;/code&gt;
   */
  public SoundCue createAndAddSoundCue() {
    SoundCue newValue = new SoundCue();
    this.getTourPrimitive().add(newValue);
    return newValue;
  }

  /**
   * Sets the value of the tourPrimitive property Objects of the following
   * type(s) are allowed in the list List &lt;TourPrimitive&gt;.
   * <p>
   * Note:
   * <p>
   * This method does not make use of the fluent pattern.If you would like to
   * make it fluent, use {@link #withTourPrimitive} instead.
   *
   * @param tourPrimitive
   */
  public void setTourPrimitive(final List<TourPrimitive> tourPrimitive) {
    this.tourPrimitive = tourPrimitive;
  }

  /**
   * add a value to the tourPrimitive property collection
   *
   * @param tourPrimitive Objects of the following type are allowed in the list:
   *                      {@link AnimatedUpdate}{@link JAXBElement}{@link Wait}{@link JAXBElement}{@link SoundCue}{@link JAXBElement}{@link TourPrimitive}{@link JAXBElement}{@link FlyTo}{@link JAXBElement}{@link TourControl}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Playlist addToTourPrimitive(final TourPrimitive tourPrimitive) {
    this.getTourPrimitive().add(tourPrimitive);
    return this;
  }

  @Obvious
  @Override
  public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.setObjectSimpleExtension(objectSimpleExtension);
  }

  @Obvious
  @Override
  public Playlist addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTourPrimitive(List &lt;TourPrimitive&gt;)
   *
   * @param tourPrimitive required parameter
   */
  public Playlist withTourPrimitive(final List<TourPrimitive> tourPrimitive) {
    this.setTourPrimitive(tourPrimitive);
    return this;
  }

  @Obvious
  @Override
  public Playlist withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Playlist withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Playlist withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public Playlist clone() {
    Playlist copy;
    copy = ((Playlist) super.clone());
    copy.tourPrimitive = new ArrayList<>((getTourPrimitive().size()));
    for (TourPrimitive iter : tourPrimitive) {
      copy.tourPrimitive.add(iter.clone());
    }
    return copy;
  }

}
