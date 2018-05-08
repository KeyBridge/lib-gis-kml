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
import net.opengis.kml.annotations.Obvious;

/**
 * &lt;Region&gt;
 * <p>
 * A region contains a bounding box ( &lt;LatLonAltBox&gt;) that describes an
 * area of interest defined by geographic coordinates and altitudes. In
 * addition, a Region contains an LOD (level of detail) extent ( &lt;Lod&gt;)
 * that defines a validity range of the associated Region in terms of projected
 * screen size. A Region is said to be "active" when the bounding box is within
 * the user's view and the LOD requirements are met. Objects associated with a
 * Region are drawn only when the Region is active. When the
 * &lt;viewRefreshMode&gt; is onRegion, the Link or Icon is loaded only when the
 * Region is active. See the "Topics in KML" page on Regions for more details.
 * In a Container or NetworkLink hierarchy, this calculation uses the Region
 * that is the closest ancestor in the hierarchy. Features and geometry
 * associated with a Region are drawn only when the Region is active. See
 * &lt;Region&gt;. Syntax: &lt;pre&gt; &lt;strong&gt;&lt;Region id="ID"&gt;
 * &lt;/strong&gt; &lt;LatLonAltBox&gt; &lt;north&gt;&lt;/north&gt; &lt;!--
 * required; kml:angle90 --&gt; &lt;south&gt;&lt;/south&gt; &lt;!-- required;
 * kml:angle90 --&gt; &lt;east&gt;&lt;/east&gt; &lt;!-- required; kml:angle180
 * --&gt; &lt;west&gt;&lt;/west&gt; &lt;!-- required; kml:angle180 --&gt;
 * &lt;minAltitude&gt;0&lt;/minAltitude&gt; &lt;!-- float --&gt;
 * &lt;maxAltitude&gt;0&lt;/maxAltitude&gt; &lt;!-- float --&gt;
 * &lt;altitudeMode&gt;clampToGround&lt;/altitudeMode&gt; &lt;!--
 * kml:altitudeModeEnum: clampToGround, relativeToGround, or absolute --&gt;
 * &lt;!-- or, substitute gx:altitudeMode: clampToSeaFloor, relativeToSeaFloor
 * --&gt; &lt;/LatLonAltBox&gt; &lt;Lod&gt;
 * &lt;minLodPixels&gt;0&lt;/minLodPixels&gt; &lt;!-- float --&gt;
 * &lt;maxLodPixels&gt;-1&lt;/maxLodPixels&gt; &lt;!-- float --&gt;
 * &lt;minFadeExtent&gt;0&lt;/minFadeExtent&gt; &lt;!-- float --&gt;
 * &lt;maxFadeExtent&gt;0&lt;/maxFadeExtent&gt; &lt;!-- float --&gt;
 * &lt;/Lod&gt; &lt;strong&gt;&lt;/Region&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Object&gt;
 *
 * Contained By:
 * @see: &lt;Feature&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegionType", propOrder = {
  "latLonAltBox",
  "lod",
  "regionSimpleExtension",
  "regionObjectExtension"
})
@XmlRootElement(name = "Region", namespace = "http://www.opengis.net/kml/2.2")
public class Region
  extends AbstractObject
  implements Cloneable {

  /**
   * &lt;latlonaltbox&gt;(required)
   * <p>
   * A bounding box that describes an area of interest defined by geographic
   * coordinates and altitudes. Default values and required fields are as
   * follows:
   */
  @XmlElement(name = "LatLonAltBox")
  protected LatLonAltBox latLonAltBox;
  /**
   * &lt;lod&gt;
   * <p>
   * &lt;minLodPixels&gt; (required) Measurement in screen pixels that
   * represents the minimum limit of the visibility range for a given Region.
   * Google Earth calculates the size of the Region when projected onto screen
   * space. Then it computes the square root of the Region's area (if, for
   * example, the Region is square and the viewpoint is directly above the
   * Region, and the Region is not tilted, this measurement is equal to the
   * width of the projected Region). If this measurement falls within the limits
   * defined by &lt;minLodPixels&gt; and &lt;maxLodPixels&gt; (and if the
   * &lt;LatLonAltBox&gt; is in view), the Region is active. If this limit is
   * not reached, the associated geometry is considered to be too far from the
   * user's viewpoint to be drawn. &lt;maxLodPixels&gt; Measurement in screen
   * pixels that represents the maximum limit of the visibility range for a
   * given Region. A value of −1, the default, indicates "active to infinite
   * size." &lt;minFadeExtent&gt; Distance over which the geometry fades, from
   * fully opaque to fully transparent. This ramp value, expressed in screen
   * pixels, is applied at the minimum end of the LOD (visibility) limits.
   * &lt;maxFadeExtent&gt; Distance over which the geometry fades, from fully
   * transparent to fully opaque. This ramp value, expressed in screen pixels,
   * is applied at the maximum end of the LOD (visibility) limits.
   */
  @XmlElement(name = "Lod")
  protected Lod lod;
  @XmlElement(name = "RegionSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> regionSimpleExtension;
  /**
   * &lt;Object&gt;
   * <p>
   * This is an abstract base class and cannot be used directly in a KML file.
   * It provides the id attribute, which allows unique identification of a KML
   * element, and the targetId attribute, which is used to reference objects
   * that have already been loaded into Google Earth. The id attribute must be
   * assigned if the &lt;Update&gt; mechanism is to be used. Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt; &lt;strong&gt;
   * &lt;!--  &lt;em&gt;Object &lt;/em&gt; id="ID" targetId="NCName" --&gt;
   * &lt;!-- / &lt;em&gt;Object &lt;/em&gt;&gt; --&gt; &lt;/strong&gt; </pre>
   * <p>
   */
  @XmlElement(name = "RegionObjectExtensionGroup")
  protected List<AbstractObject> regionObjectExtension;

  public Region() {
    super();
  }

  /**
   * @see latLonAltBox
   *
   * @return possible object is {@link LatLonAltBox}
   *
   */
  public LatLonAltBox getLatLonAltBox() {
    return latLonAltBox;
  }

  /**
   * @see latLonAltBox
   *
   * @param value allowed object is {@link LatLonAltBox}
   *
   */
  public void setLatLonAltBox(LatLonAltBox value) {
    this.latLonAltBox = value;
  }

  /**
   * @see lod
   *
   * @return possible object is {@link Lod}
   *
   */
  public Lod getLod() {
    return lod;
  }

  /**
   * @see lod
   *
   * @param value allowed object is {@link Lod}
   *
   */
  public void setLod(Lod value) {
    this.lod = value;
  }

  /**
   * @see regionSimpleExtension
   *
   */
  public List<Object> getRegionSimpleExtension() {
    if (regionSimpleExtension == null) {
      regionSimpleExtension = new ArrayList<>();
    }
    return this.regionSimpleExtension;
  }

  /**
   * @see regionObjectExtension
   *
   */
  public List<AbstractObject> getRegionObjectExtension() {
    if (regionObjectExtension == null) {
      regionObjectExtension = new ArrayList<>();
    }
    return this.regionObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((latLonAltBox == null) ? 0 : latLonAltBox.hashCode()));
    result = ((prime * result) + ((lod == null) ? 0 : lod.hashCode()));
    result = ((prime * result) + ((regionSimpleExtension == null) ? 0 : regionSimpleExtension.hashCode()));
    result = ((prime * result) + ((regionObjectExtension == null) ? 0 : regionObjectExtension.hashCode()));
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
    if ((obj instanceof Region) == false) {
      return false;
    }
    Region other = ((Region) obj);
    if (latLonAltBox == null) {
      if (other.latLonAltBox != null) {
        return false;
      }
    } else if (latLonAltBox.equals(other.latLonAltBox) == false) {
      return false;
    }
    if (lod == null) {
      if (other.lod != null) {
        return false;
      }
    } else if (lod.equals(other.lod) == false) {
      return false;
    }
    if (regionSimpleExtension == null) {
      if (other.regionSimpleExtension != null) {
        return false;
      }
    } else if (regionSimpleExtension.equals(other.regionSimpleExtension) == false) {
      return false;
    }
    if (regionObjectExtension == null) {
      if (other.regionObjectExtension != null) {
        return false;
      }
    } else if (regionObjectExtension.equals(other.regionObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link LatLonAltBox} and set it to latLonAltBox.
   * <p>
   * This method is a short version for: &lt;code&gt; LatLonAltBox latLonAltBox
   * = new LatLonAltBox(); this.setLatLonAltBox(latLonAltBox); &lt;/code&gt;
   */
  public LatLonAltBox createAndSetLatLonAltBox() {
    LatLonAltBox newValue = new LatLonAltBox();
    this.setLatLonAltBox(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Lod} and set it to lod.
   * <p>
   * This method is a short version for: &lt;code&gt; Lod lod = new Lod();
   * this.setLod(lod); &lt;/code&gt;
   */
  public Lod createAndSetLod() {
    Lod newValue = new Lod();
    this.setLod(newValue);
    return newValue;
  }

  /**
   * @see regionSimpleExtension
   *
   * @param regionSimpleExtension
   */
  public void setRegionSimpleExtension(final List<Object> regionSimpleExtension) {
    this.regionSimpleExtension = regionSimpleExtension;
  }

  /**
   * add a value to the regionSimpleExtension property collection
   *
   * @param regionSimpleExtension Objects of the following type are allowed in
   *                              the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Region addToRegionSimpleExtension(final Object regionSimpleExtension) {
    this.getRegionSimpleExtension().add(regionSimpleExtension);
    return this;
  }

  /**
   * @see regionObjectExtension
   *
   * @param regionObjectExtension
   */
  public void setRegionObjectExtension(final List<AbstractObject> regionObjectExtension) {
    this.regionObjectExtension = regionObjectExtension;
  }

  /**
   * add a value to the regionObjectExtension property collection
   *
   * @param regionObjectExtension Objects of the following type are allowed in
   *                              the list: {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Region addToRegionObjectExtension(final AbstractObject regionObjectExtension) {
    this.getRegionObjectExtension().add(regionObjectExtension);
    return this;
  }

  /**
   * @see objectSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.setObjectSimpleExtension(objectSimpleExtension);
  }

  @Obvious
  @Override
  public Region addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLatLonAltBox(LatLonAltBox)
   *
   * @param latLonAltBox required parameter
   */
  public Region withLatLonAltBox(final LatLonAltBox latLonAltBox) {
    this.setLatLonAltBox(latLonAltBox);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLod(Lod)
   *
   * @param lod required parameter
   */
  public Region withLod(final Lod lod) {
    this.setLod(lod);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setRegionSimpleExtension(List &lt;Object&gt;)
   *
   * @param regionSimpleExtension required parameter
   */
  public Region withRegionSimpleExtension(final List<Object> regionSimpleExtension) {
    this.setRegionSimpleExtension(regionSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setRegionObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param regionObjectExtension required parameter
   */
  public Region withRegionObjectExtension(final List<AbstractObject> regionObjectExtension) {
    this.setRegionObjectExtension(regionObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Region withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Region withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Region withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public Region clone() {
    Region copy;
    copy = ((Region) super.clone());
    copy.latLonAltBox = ((latLonAltBox == null) ? null : ((LatLonAltBox) latLonAltBox.clone()));
    copy.lod = ((lod == null) ? null : ((Lod) lod.clone()));
    copy.regionSimpleExtension = new ArrayList<>((getRegionSimpleExtension().size()));
    for (Object iter : regionSimpleExtension) {
      copy.regionSimpleExtension.add(iter);
    }
    copy.regionObjectExtension = new ArrayList<>((getRegionObjectExtension().size()));
    for (AbstractObject iter : regionObjectExtension) {
      copy.regionObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
