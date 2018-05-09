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
 * &lt;latlonbox&gt;
 * <p>
 * Specifies where the top, bottom, right, and left sides of a bounding box for
 * the ground overlay are aligned. &lt;north&gt; Specifies the latitude of the
 * north edge of the bounding box, in decimal degrees from 0 to ±90.
 * &lt;south&gt; Specifies the latitude of the south edge of the bounding box,
 * in decimal degrees from 0 to ±90. &lt;east&gt; Specifies the longitude of the
 * east edge of the bounding box, in decimal degrees from 0 to ±180. (For
 * overlays that overlap the meridian of 180° longitude, values can extend
 * beyond that range.) &lt;west&gt; Specifies the longitude of the west edge of
 * the bounding box, in decimal degrees from 0 to ±180. (For overlays that
 * overlap the meridian of 180° longitude, values can extend beyond that range.)
 * &lt;rotation&gt; Specifies a rotation of the overlay about its center, in
 * degrees. Values can be ±180. The default is 0 (north). Rotations are
 * specified in a counterclockwise direction. &lt;LatLonBox&gt;
 * &lt;north&gt;48.25475939255556 &lt;/north&gt; &lt;south&gt;48.25207367852141
 * &lt;/south&gt; &lt;east&gt;-90.86591508839973 &lt;/east&gt;
 * &lt;west&gt;-90.8714285289695 &lt;/west&gt; &lt;rotation&gt;39.37878630116985
 * &lt;/rotation&gt; &lt;/LatLonBox&gt;
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractLatLonBoxType", propOrder = {
  "north",
  "south",
  "east",
  "west",
  "abstractLatLonBoxSimpleExtension",
  "abstractLatLonBoxObjectExtension"
})
@XmlSeeAlso({
  LatLonAltBox.class,
  LatLonBox.class
})
public abstract class AbstractLatLonBox
  extends AbstractObject
  implements Cloneable {

  /**
   * &lt;north&gt; (required)
   * <p>
   * Specifies the latitude of the north edge of the bounding box, in decimal
   * degrees from 0 to ±90.
   */
  @XmlElement(defaultValue = "180.0")
  protected double north;
  /**
   * &lt;south&gt; (required)
   * <p>
   * Specifies the latitude of the south edge of the bounding box, in decimal
   * degrees from 0 to ±90.
   */
  @XmlElement(defaultValue = "-180.0")
  protected double south;
  /**
   * &lt;east&gt; (required)
   */
  @XmlElement(defaultValue = "180.0")
  protected double east;
  /**
   * &lt;west&gt; (required)
   * <p>
   * Specifies the longitude of the west edge of the bounding box, in decimal
   * degrees from 0 to ±180.
   */
  @XmlElement(defaultValue = "-180.0")
  protected double west;
  @XmlElement(name = "AbstractLatLonBoxSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> abstractLatLonBoxSimpleExtension;
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
  @XmlElement(name = "AbstractLatLonBoxObjectExtensionGroup")
  protected List<AbstractObject> abstractLatLonBoxObjectExtension;

  public AbstractLatLonBox() {
    super();
  }

  /**
   * @see north
   *
   * @return possible object is {@code Double}
   *
   */
  public double getNorth() {
    return north;
  }

  /**
   * @see north
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setNorth(double value) {
    this.north = value;
  }

  /**
   * @see south
   *
   * @return possible object is {@code Double}
   *
   */
  public double getSouth() {
    return south;
  }

  /**
   * @see south
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setSouth(double value) {
    this.south = value;
  }

  /**
   * @see east
   *
   * @return possible object is {@code Double}
   *
   */
  public double getEast() {
    return east;
  }

  /**
   * @see east
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setEast(double value) {
    this.east = value;
  }

  /**
   * @see west
   *
   * @return possible object is {@code Double}
   *
   */
  public double getWest() {
    return west;
  }

  /**
   * @see west
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setWest(double value) {
    this.west = value;
  }

  /**
   * @see abstractLatLonBoxSimpleExtension
   *
   */
  public List<Object> getAbstractLatLonBoxSimpleExtension() {
    if (abstractLatLonBoxSimpleExtension == null) {
      abstractLatLonBoxSimpleExtension = new ArrayList<>();
    }
    return this.abstractLatLonBoxSimpleExtension;
  }

  /**
   * @see abstractLatLonBoxObjectExtension
   *
   */
  public List<AbstractObject> getAbstractLatLonBoxObjectExtension() {
    if (abstractLatLonBoxObjectExtension == null) {
      abstractLatLonBoxObjectExtension = new ArrayList<>();
    }
    return this.abstractLatLonBoxObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(north);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(south);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(east);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(west);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((abstractLatLonBoxSimpleExtension == null) ? 0 : abstractLatLonBoxSimpleExtension.hashCode()));
    result = ((prime * result) + ((abstractLatLonBoxObjectExtension == null) ? 0 : abstractLatLonBoxObjectExtension.hashCode()));
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
    if ((obj instanceof AbstractLatLonBox) == false) {
      return false;
    }
    AbstractLatLonBox other = ((AbstractLatLonBox) obj);
    if (north != other.north) {
      return false;
    }
    if (south != other.south) {
      return false;
    }
    if (east != other.east) {
      return false;
    }
    if (west != other.west) {
      return false;
    }
    if (abstractLatLonBoxSimpleExtension == null) {
      if (other.abstractLatLonBoxSimpleExtension != null) {
        return false;
      }
    } else if (abstractLatLonBoxSimpleExtension.equals(other.abstractLatLonBoxSimpleExtension) == false) {
      return false;
    }
    if (abstractLatLonBoxObjectExtension == null) {
      if (other.abstractLatLonBoxObjectExtension != null) {
        return false;
      }
    } else if (abstractLatLonBoxObjectExtension.equals(other.abstractLatLonBoxObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see abstractLatLonBoxSimpleExtension
   *
   * @param abstractLatLonBoxSimpleExtension
   */
  public void setAbstractLatLonBoxSimpleExtension(final List<Object> abstractLatLonBoxSimpleExtension) {
    this.abstractLatLonBoxSimpleExtension = abstractLatLonBoxSimpleExtension;
  }

  /**
   * add a value to the abstractLatLonBoxSimpleExtension property collection
   *
   * @param abstractLatLonBoxSimpleExtension Objects of the following type are
   *                                         allowed in the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public AbstractLatLonBox addToAbstractLatLonBoxSimpleExtension(final Object abstractLatLonBoxSimpleExtension) {
    this.getAbstractLatLonBoxSimpleExtension().add(abstractLatLonBoxSimpleExtension);
    return this;
  }

  /**
   * @see abstractLatLonBoxObjectExtension
   *
   * @param abstractLatLonBoxObjectExtension
   */
  public void setAbstractLatLonBoxObjectExtension(final List<AbstractObject> abstractLatLonBoxObjectExtension) {
    this.abstractLatLonBoxObjectExtension = abstractLatLonBoxObjectExtension;
  }

  /**
   * add a value to the abstractLatLonBoxObjectExtension property collection
   *
   * @param abstractLatLonBoxObjectExtension Objects of the following type are
   *                                         allowed in the list:
   *                                         {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public AbstractLatLonBox addToAbstractLatLonBoxObjectExtension(final AbstractObject abstractLatLonBoxObjectExtension) {
    this.getAbstractLatLonBoxObjectExtension().add(abstractLatLonBoxObjectExtension);
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
  public AbstractLatLonBox addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setNorth(double)
   *
   * @param north required parameter
   */
  public AbstractLatLonBox withNorth(final double north) {
    this.setNorth(north);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSouth(double)
   *
   * @param south required parameter
   */
  public AbstractLatLonBox withSouth(final double south) {
    this.setSouth(south);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setEast(double)
   *
   * @param east required parameter
   */
  public AbstractLatLonBox withEast(final double east) {
    this.setEast(east);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setWest(double)
   *
   * @param west required parameter
   */
  public AbstractLatLonBox withWest(final double west) {
    this.setWest(west);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAbstractLatLonBoxSimpleExtension(List &lt;Object&gt;)
   *
   * @param abstractLatLonBoxSimpleExtension required parameter
   */
  public AbstractLatLonBox withAbstractLatLonBoxSimpleExtension(final List<Object> abstractLatLonBoxSimpleExtension) {
    this.setAbstractLatLonBoxSimpleExtension(abstractLatLonBoxSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAbstractLatLonBoxObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param abstractLatLonBoxObjectExtension required parameter
   */
  public AbstractLatLonBox withAbstractLatLonBoxObjectExtension(final List<AbstractObject> abstractLatLonBoxObjectExtension) {
    this.setAbstractLatLonBoxObjectExtension(abstractLatLonBoxObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public AbstractLatLonBox withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public AbstractLatLonBox withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public AbstractLatLonBox withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public AbstractLatLonBox clone() {
    AbstractLatLonBox copy;
    copy = ((AbstractLatLonBox) super.clone());
    copy.abstractLatLonBoxSimpleExtension = new ArrayList<>((getAbstractLatLonBoxSimpleExtension().size()));
    for (Object iter : abstractLatLonBoxSimpleExtension) {
      copy.abstractLatLonBoxSimpleExtension.add(iter);
    }
    copy.abstractLatLonBoxObjectExtension = new ArrayList<>((getAbstractLatLonBoxObjectExtension().size()));
    for (AbstractObject iter : abstractLatLonBoxObjectExtension) {
      copy.abstractLatLonBoxObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
