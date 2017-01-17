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

import javax.xml.bind.annotation.*;

/**
 * Vec2
 * <p>
 * x=double xunits=kml:unitsEnum y=double yunits=kml:unitsEnum
 * </p>
 * <p>
 * See Also: See <hotSpot> in <IconStyle>, <ScreenOverlay>
 * <p>
 * <p>
 * <p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vec2Type")
@XmlRootElement(name = "Vec2", namespace = "http://www.opengis.net/kml/2.2")
public class Vec2 implements Cloneable {

  /**
   * <x>, <y>, <w>, <h>
   * <p>
   * Use of these elements within <Icon> has been deprecated.
   * </p>
   * <p>
   * <p>
   * <p>
   */
  @XmlAttribute(name = "x")
  protected double x;
  @XmlAttribute(name = "y")
  protected double y;
  /**
   * Units
   * <p>
   * fraction, pixels, insetPixels
   * </p>
   * <p>
   * See Also: See <hotSpot> in <IconStyle>, <ScreenOverlay>
   * <p>
   * <p>
   * <p>
   */
  @XmlAttribute(name = "xunits")
  protected Units xunits;
  /**
   * Units
   * <p>
   * fraction, pixels, insetPixels
   * </p>
   * <p>
   * See Also: See <hotSpot> in <IconStyle>, <ScreenOverlay>
   * <p>
   * <p>
   * <p>
   */
  @XmlAttribute(name = "yunits")
  protected Units yunits;

  public Vec2() {
    super();
  }

  /**
   * @see x
   *
   */
  public double getX() {
    return x;
  }

  /**
   * @see x
   *
   */
  public void setX(double value) {
    this.x = value;
  }

  /**
   * @see y
   *
   */
  public double getY() {
    return y;
  }

  /**
   * @see y
   *
   */
  public void setY(double value) {
    this.y = value;
  }

  /**
   * @see xunits
   *
   * @return possible object is {@link Units}
   *
   */
  public Units getXunits() {
    if (xunits == null) {
      return Units.FRACTION;
    } else {
      return xunits;
    }
  }

  /**
   * @see xunits
   *
   * @param value allowed object is {@link Units}
   *
   */
  public void setXunits(Units value) {
    this.xunits = value;
  }

  /**
   * @see yunits
   *
   * @return possible object is {@link Units}
   *
   */
  public Units getYunits() {
    if (yunits == null) {
      return Units.FRACTION;
    } else {
      return yunits;
    }
  }

  /**
   * @see yunits
   *
   * @param value allowed object is {@link Units}
   *
   */
  public void setYunits(Units value) {
    this.yunits = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(x);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(y);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((xunits == null) ? 0 : xunits.hashCode()));
    result = ((prime * result) + ((yunits == null) ? 0 : yunits.hashCode()));
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
    if ((obj instanceof Vec2) == false) {
      return false;
    }
    Vec2 other = ((Vec2) obj);
    if (x != other.x) {
      return false;
    }
    if (y != other.y) {
      return false;
    }
    if (xunits == null) {
      if (other.xunits != null) {
        return false;
      }
    } else if (xunits.equals(other.xunits) == false) {
      return false;
    }
    if (yunits == null) {
      if (other.yunits != null) {
        return false;
      }
    } else if (yunits.equals(other.yunits) == false) {
      return false;
    }
    return true;
  }

  /**
   * fluent setter
   *
   * @see #setX(double)
   *
   * @param x required parameter
   */
  public Vec2 withX(final double x) {
    this.setX(x);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setY(double)
   *
   * @param y required parameter
   */
  public Vec2 withY(final double y) {
    this.setY(y);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setXunits(Units)
   *
   * @param xunits required parameter
   */
  public Vec2 withXunits(final Units xunits) {
    this.setXunits(xunits);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setYunits(Units)
   *
   * @param yunits required parameter
   */
  public Vec2 withYunits(final Units yunits) {
    this.setYunits(yunits);
    return this;
  }

  @Override
  public Vec2 clone() {
    Vec2 copy;
    try {
      copy = ((Vec2) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    return copy;
  }

}
