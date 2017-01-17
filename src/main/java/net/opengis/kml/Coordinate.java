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
package net.opengis.kml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlRootElement(name = "Coordinate", namespace = "http://www.opengis.net/kml/2.2")
public class Coordinate implements Cloneable {

  protected double longitude;

  protected double latitude;

  protected double altitude;

  /**
   * Default no-arg constructor is private. Use overloaded constructor instead!
   * (Temporary solution, till a better and more suitable ObjectFactory is
   * created.)
   * <p>
   */
  @Deprecated
  private Coordinate() {
  }

  public Coordinate(final double longitude, final double latitude) {
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public Coordinate(final double longitude, final double latitude, final double altitude) {
    this.longitude = longitude;
    this.latitude = latitude;
    this.altitude = altitude;
  }

  public Coordinate(final String coordinates) {
    String[] coords = coordinates.replaceAll(",\\s+", ",").trim().split(",");
    if ((coords.length < 1) && (coords.length > 3)) {
      throw new IllegalArgumentException();
    }
    this.longitude = Double.parseDouble((coords[0]));
    this.latitude = Double.parseDouble((coords[1]));
    if (coords.length == 3) {
      this.altitude = Double.parseDouble((coords[2]));
    }
  }

  /**
   *
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(longitude);
    sb.append(",");
    sb.append(latitude);
    if (altitude != 0.0D) {
      sb.append(",");
      sb.append(altitude);
    }
    return sb.toString();
  }

  /**
   *
   */
  public double getLongitude() {
    return longitude;
  }

  /**
   *
   */
  public Coordinate setLongitude(final double longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   *
   */
  public double getLatitude() {
    return latitude;
  }

  /**
   *
   */
  public Coordinate setLatitude(final double latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   *
   */
  public double getAltitude() {
    return altitude;
  }

  /**
   *
   */
  public Coordinate setAltitude(final double altitude) {
    this.altitude = altitude;
    return this;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = java.lang.Double.doubleToLongBits(longitude);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = java.lang.Double.doubleToLongBits(latitude);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = java.lang.Double.doubleToLongBits(altitude);
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
    if ((obj instanceof Coordinate) == false) {
      return false;
    }
    Coordinate other = ((Coordinate) obj);
    if (longitude != other.longitude) {
      return false;
    }
    if (latitude != other.latitude) {
      return false;
    }
    if (altitude != other.altitude) {
      return false;
    }
    return true;
  }

  /**
   * fluent setter
   *
   * @see #setLongitude(double)
   *
   * @param longitude required parameter
   */
  public Coordinate withLongitude(final double longitude) {
    this.setLongitude(longitude);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLatitude(double)
   *
   * @param latitude required parameter
   */
  public Coordinate withLatitude(final double latitude) {
    this.setLatitude(latitude);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAltitude(double)
   *
   * @param altitude required parameter
   */
  public Coordinate withAltitude(final double altitude) {
    this.setAltitude(altitude);
    return this;
  }

  @Override
  public Coordinate clone() {
    Coordinate copy;
    try {
      copy = ((Coordinate) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    return copy;
  }

}
