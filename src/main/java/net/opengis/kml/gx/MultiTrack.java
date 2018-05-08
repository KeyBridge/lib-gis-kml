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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import net.opengis.kml.AbstractObject;
import net.opengis.kml.AltitudeMode;
import net.opengis.kml.BooleanConverter;
import net.opengis.kml.Geometry;
import net.opengis.kml.annotations.Obvious;

/*
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiTrackType", propOrder = {
  "altitudeMode",
  "interpolate",
  "track"
})
@XmlRootElement(name = "MultiTrack", namespace = "http://www.google.com/kml/ext/2.2")
public class MultiTrack
  extends Geometry
  implements Cloneable {

  @XmlElement(defaultValue = "clampToGround")
  protected AltitudeMode altitudeMode;
  @XmlElement(defaultValue = "false")
  @XmlJavaTypeAdapter(BooleanConverter.class)
  protected Boolean interpolate;
  @XmlElement(name = "Track")
  protected List<Track> track;

  public MultiTrack() {
    super();
  }

  /**
   * @return possible object is null null null null null null null null null   {@link Object}
     *     {@link net.opengis.kml.AltitudeMode}
   *     {@link de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}
   *
   */
  public AltitudeMode getAltitudeMode() {
    return altitudeMode;
  }

  /**
   * @param value allowed object is null null null null null null null null null   {@link Object}
     *     {@link net.opengis.kml.AltitudeMode}
   *     {@link de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}
   *
   */
  public void setAltitudeMode(AltitudeMode value) {
    this.altitudeMode = value;
  }

  /**
   * @return possible object is {@link Boolean}
   *
   */
  public Boolean isInterpolate() {
    return interpolate;
  }

  /**
   * @param value allowed object is {@link Boolean}
   *
   */
  public void setInterpolate(Boolean value) {
    this.interpolate = value;
  }

  /*
   *
   */
  public List<Track> getTrack() {
    if (track == null) {
      track = new ArrayList<>();
    }
    return this.track;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((altitudeMode == null) ? 0 : altitudeMode.hashCode()));
    result = ((prime * result) + ((interpolate == null) ? 0 : interpolate.hashCode()));
    result = ((prime * result) + ((track == null) ? 0 : track.hashCode()));
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
    if ((obj instanceof MultiTrack) == false) {
      return false;
    }
    MultiTrack other = ((MultiTrack) obj);
    if (altitudeMode == null) {
      if (other.altitudeMode != null) {
        return false;
      }
    } else if (altitudeMode.equals(other.altitudeMode) == false) {
      return false;
    }
    if (interpolate == null) {
      if (other.interpolate != null) {
        return false;
      }
    } else if (interpolate.equals(other.interpolate) == false) {
      return false;
    }
    if (track == null) {
      if (other.track != null) {
        return false;
      }
    } else if (track.equals(other.track) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link Track} and adds it to track. This method
   * is a short version for: &lt;code&gt; Track track = new Track();
   * this.getTrack().add(track); &lt;/code&gt;
   */
  public Track createAndAddTrack() {
    Track newValue = new Track();
    this.getTrack().add(newValue);
    return newValue;
  }

  /**
   * Sets the value of the track property Objects of the following type(s) are
   * allowed in the list List &lt;Track&gt;.
   * <p>
   * Note:
   * <p>
   * This method does not make use of the fluent pattern.If you would like to
   * make it fluent, use {@link #withTrack} instead.
   *
   * @param track
   */
  public void setTrack(final List<Track> track) {
    this.track = track;
  }

  /**
   * add a value to the track property collection
   *
   * @param track Objects of the following type are allowed in the list:
   *              {@link Track}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public MultiTrack addToTrack(final Track track) {
    this.getTrack().add(track);
    return this;
  }

  @Obvious
  @Override
  public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.setObjectSimpleExtension(objectSimpleExtension);
  }

  @Obvious
  @Override
  public MultiTrack addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public void setGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
    super.setGeometrySimpleExtension(geometrySimpleExtension);
  }

  @Obvious
  @Override
  public MultiTrack addToGeometrySimpleExtension(final Object geometrySimpleExtension) {
    super.getGeometrySimpleExtension().add(geometrySimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public void setGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
    super.setGeometryObjectExtension(geometryObjectExtension);
  }

  @Obvious
  @Override
  public MultiTrack addToGeometryObjectExtension(final AbstractObject geometryObjectExtension) {
    super.getGeometryObjectExtension().add(geometryObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAltitudeMode(Object)
   *
   * @param altitudeMode required parameter
   */
  public MultiTrack withAltitudeMode(final AltitudeMode altitudeMode) {
    this.setAltitudeMode(altitudeMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setInterpolate(Boolean)
   *
   * @param interpolate required parameter
   */
  public MultiTrack withInterpolate(final Boolean interpolate) {
    this.setInterpolate(interpolate);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTrack(List &lt;Track&gt;)
   *
   * @param track required parameter
   */
  public MultiTrack withTrack(final List<Track> track) {
    this.setTrack(track);
    return this;
  }

  @Obvious
  @Override
  public MultiTrack withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public MultiTrack withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public MultiTrack withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public MultiTrack withGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
    super.withGeometrySimpleExtension(geometrySimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public MultiTrack withGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
    super.withGeometryObjectExtension(geometryObjectExtension);
    return this;
  }

  @Override
  public MultiTrack clone() {
    MultiTrack copy;
    copy = ((MultiTrack) super.clone());
    copy.track = new ArrayList<>((getTrack().size()));
    for (Track iter : track) {
      copy.track.add(iter.clone());
    }
    return copy;
  }

}
