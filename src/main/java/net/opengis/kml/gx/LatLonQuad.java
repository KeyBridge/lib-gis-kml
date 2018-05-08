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
import net.opengis.kml.Coordinate;
import net.opengis.kml.CoordinatesConverter;
import net.opengis.kml.annotations.Obvious;

/**
 *  &lt;gx:LatLonQuad&gt;
 *   
 * Allows non-rectangular quadrilateral ground overlays. If a third value is
 * inserted into any tuple (representing altitude) it will be ignored. Altitude
 * is set using  &lt;altitude&gt; and  &lt;altitudeMode&gt; (or
 *  &lt;gx:altitudeMode&gt;) extending
 *  &lt;GroundOverlay&gt;. Allowed altitude modes are absolute, clampToGround, and
 * clampToSeaFloor. Specifies the coordinates of the four corner points of a
 * quadrilateral defining the overlay area. Exactly four coordinate tuples have
 * to be provided, each consisting of floating point values for longitude and
 * latitude. Insert a space between tuples. Do not include spaces within a
 * tuple. The coordinates must be specified in counter-clockwise order with the
 * first coordinate corresponding to the lower-left corner of the overlayed
 * image. The shape described by these corners must be convex. Syntax:
 *  <pre>&lt;GroundOverlay id="ID"&gt;
 *   ...
 *   &lt;Icon&gt;...&lt;/Icon&gt;
 *   &lt;altitude&gt;0&lt;/altitude&gt;
 *   &lt;altitudeMode&gt;clampToGround&lt;/altitudeMode&gt;                   &lt;!-- or  &lt;em&gt;absolute &lt;/em&gt; --&gt;
 *          &lt;!-- can substitute  &lt;em&gt;&lt;gx:altitudeMode&gt;clampToSeaFloor&lt;/gx:altitudeMode&gt; &lt;/em&gt; --&gt;
 *
 *    &lt;strong&gt;&lt;gx:LatLonQuad&gt;
 *     &lt;coordinates&gt;...&lt;/coordinates&gt;              &lt;!-- four lon,lat tuples --&gt;
 *   &lt;/gx:LatLonQuad&gt; &lt;/strong&gt;
 * &lt;/GroundOverlay&gt; </pre>
 *   
 * Extends:
 *
 * @see:  &lt;Object&gt;
 *
 * Contained By:
 * @see:  &lt;GroundOverlay&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LatLonQuadType", propOrder = {
  "coordinates"
})
@XmlRootElement(name = "LatLonQuad", namespace = "http://www.google.com/kml/ext/2.2")
public class LatLonQuad
  extends AbstractObject
  implements Cloneable {

  /**
   *  &lt;coordinates&gt; (required)
   *   
   * A single tuple consisting of floating point values for longitude, latitude,
   * and altitude (in that order). Longitude and latitude values are in degrees,
   * where longitude ≥ −180 and  &lt;= 180 latitude ≥ −90 and ≤ 90 altitude values
   * (optional) are in meters above sea level Do not include spaces between the
   * three values that describe a coordinate.     &lt;/
   * p
   * &gt;
   *    T wo or more coordinate tuples, each consisting of floating point
   * values for longitude, latitude, and altitude. The altitude component is
   * optional. I
   * n
   * sert a space between tuples. Do not include spaces within a tuple.
   */
  @XmlElement(namespace = "http://www.opengis.net/kml/2.2", type = String.class)
  @XmlJavaTypeAdapter(CoordinatesConverter.class)
  protected List<Coordinate> coordinates;

  public LatLonQuad() {
    super();
  }

  /**
   * @see coordinates
   *
   */
  public List<Coordinate> getCoordinates() {
    if (coordinates == null) {
      coordinates = new ArrayList<>();
    }
    return coordinates;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((coordinates == null) ? 0 : coordinates.hashCode()));
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
    if ((obj instanceof LatLonQuad) == false) {
      return false;
    }
    LatLonQuad other = ((LatLonQuad) obj);
    if (coordinates == null) {
      if (other.coordinates != null) {
        return false;
      }
    } else if (coordinates.equals(other.coordinates) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see coordinates
   *
   * @param coordinates
   */
  public void setCoordinates(final List<Coordinate> coordinates) {
    this.coordinates = coordinates;
  }

  /**
   * add a value to the coordinates property collection
   *
   * @param longitude required parameter
   * @param latitude  required parameter
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LatLonQuad addToCoordinates(final double longitude, final double latitude) {
    this.getCoordinates().add(new Coordinate(longitude, latitude));
    return this;
  }

  /**
   * add a value to the coordinates property collection
   *
   * @param longitude required parameter
   * @param latitude  required parameter
   * @param altitude  required parameter
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LatLonQuad addToCoordinates(final double longitude, final double latitude, final double altitude) {
    this.getCoordinates().add(new Coordinate(longitude, latitude, altitude));
    return this;
  }

  /**
   * add a value to the coordinates property collection
   *
   * @param coordinates required parameter
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LatLonQuad addToCoordinates(final String coordinates) {
    this.getCoordinates().add(new Coordinate(coordinates));
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
  public LatLonQuad addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setCoordinates(List &lt;Coordinate&gt;)
   *
   * @param coordinates required parameter
   */
  public LatLonQuad withCoordinates(final List<Coordinate> coordinates) {
    this.setCoordinates(coordinates);
    return this;
  }

  @Obvious
  @Override
  public LatLonQuad withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public LatLonQuad withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public LatLonQuad withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  /**
   * Creates a new instance of {@link List}{@link Coordinate} and set it to
   * this.coordinates.
   *   
   * This method is a short version for:
   *  <pre>
   *  &lt;code&gt;
   * List &lt;Coordinate&gt; newValue = new List &lt;Coordinate&gt;();
   * this.setCoordinates(newValue);  &lt;/code&gt;
   *  </pre>
   */
  public List<Coordinate> createAndSetCoordinates() {
    List<Coordinate> newValue = new ArrayList<>();
    this.setCoordinates(newValue);
    return newValue;
  }

  @Override
  public LatLonQuad clone() {
    LatLonQuad copy;
    copy = ((LatLonQuad) super.clone());
    copy.coordinates = new ArrayList<>((getCoordinates().size()));
    for (Coordinate iter : coordinates) {
      copy.coordinates.add(iter.clone());
    }
    return copy;
  }

}
