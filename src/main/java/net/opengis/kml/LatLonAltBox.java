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
 * &lt;latlonaltbox&gt;(required)
 * <p>
 * A bounding box that describes an area of interest defined by geographic
 * coordinates and altitudes. Default values and required fields are as follows:
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LatLonAltBoxType", propOrder = {
  "minAltitude",
  "maxAltitude",
  "altitudeMode",
  "latLonAltBoxSimpleExtension",
  "latLonAltBoxObjectExtension"
})
@XmlRootElement(name = "LatLonAltBox", namespace = "http://www.opengis.net/kml/2.2")
public class LatLonAltBox
  extends AbstractLatLonBox
  implements Cloneable {

  /**
   * &lt;minaltitude&gt;
   * <p>
   * Specified in meters (and is affected by the altitude mode specification).
   */
  @XmlElement(defaultValue = "0.0")
  protected double minAltitude;
  /**
   * &lt;maxaltitude&gt;
   * <p>
   * Specified in meters (and is affected by the altitude mode specification).
   */
  @XmlElement(defaultValue = "0.0")
  protected double maxAltitude;
  /**
   * AltitudeMode
   * <p>
   * clampToGround, relativeToGround, absolute See Also: See &lt;LookAt&gt; and
   * &lt;Region&gt;
   * <p>
   */
  @XmlElement(defaultValue = "clampToGround")
  protected AltitudeMode altitudeMode;
  @XmlElement(name = "LatLonAltBoxSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> latLonAltBoxSimpleExtension;
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
  @XmlElement(name = "LatLonAltBoxObjectExtensionGroup")
  protected List<AbstractObject> latLonAltBoxObjectExtension;

  public LatLonAltBox() {
    super();
  }

  /**
   * @see minAltitude
   *
   * @return possible object is {@code Double}
   *
   */
  public double getMinAltitude() {
    return minAltitude;
  }

  /**
   * @see minAltitude
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setMinAltitude(double value) {
    this.minAltitude = value;
  }

  /**
   * @see maxAltitude
   *
   * @return possible object is {@code Double}
   *
   */
  public double getMaxAltitude() {
    return maxAltitude;
  }

  /**
   * @see maxAltitude
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setMaxAltitude(double value) {
    this.maxAltitude = value;
  }

  /**
   * @see altitudeMode
   *
   * @return possible object is null null null null null null null null null null   {@code Object}
     *     {@code net.opengis.kml.AltitudeMode}
   *     {@code de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}
   *
   */
  public AltitudeMode getAltitudeMode() {
    return altitudeMode;
  }

  /**
   * @see altitudeMode
   *
   * @param value allowed object is null null null null null null null null null null   {@code Object}
     *     {@code net.opengis.kml.AltitudeMode}
   *     {@code de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}
   *
   */
  public void setAltitudeMode(AltitudeMode value) {
    this.altitudeMode = value;
  }

  /**
   * @see latLonAltBoxSimpleExtension
   *
   */
  public List<Object> getLatLonAltBoxSimpleExtension() {
    if (latLonAltBoxSimpleExtension == null) {
      latLonAltBoxSimpleExtension = new ArrayList<>();
    }
    return this.latLonAltBoxSimpleExtension;
  }

  /**
   * @see latLonAltBoxObjectExtension
   *
   */
  public List<AbstractObject> getLatLonAltBoxObjectExtension() {
    if (latLonAltBoxObjectExtension == null) {
      latLonAltBoxObjectExtension = new ArrayList<>();
    }
    return this.latLonAltBoxObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(minAltitude);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(maxAltitude);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((altitudeMode == null) ? 0 : altitudeMode.hashCode()));
    result = ((prime * result) + ((latLonAltBoxSimpleExtension == null) ? 0 : latLonAltBoxSimpleExtension.hashCode()));
    result = ((prime * result) + ((latLonAltBoxObjectExtension == null) ? 0 : latLonAltBoxObjectExtension.hashCode()));
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
    if ((obj instanceof LatLonAltBox) == false) {
      return false;
    }
    LatLonAltBox other = ((LatLonAltBox) obj);
    if (minAltitude != other.minAltitude) {
      return false;
    }
    if (maxAltitude != other.maxAltitude) {
      return false;
    }
    if (altitudeMode == null) {
      if (other.altitudeMode != null) {
        return false;
      }
    } else if (altitudeMode.equals(other.altitudeMode) == false) {
      return false;
    }
    if (latLonAltBoxSimpleExtension == null) {
      if (other.latLonAltBoxSimpleExtension != null) {
        return false;
      }
    } else if (latLonAltBoxSimpleExtension.equals(other.latLonAltBoxSimpleExtension) == false) {
      return false;
    }
    if (latLonAltBoxObjectExtension == null) {
      if (other.latLonAltBoxObjectExtension != null) {
        return false;
      }
    } else if (latLonAltBoxObjectExtension.equals(other.latLonAltBoxObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see latLonAltBoxSimpleExtension
   *
   * @param latLonAltBoxSimpleExtension
   */
  public void setLatLonAltBoxSimpleExtension(final List<Object> latLonAltBoxSimpleExtension) {
    this.latLonAltBoxSimpleExtension = latLonAltBoxSimpleExtension;
  }

  /**
   * add a value to the latLonAltBoxSimpleExtension property collection
   *
   * @param latLonAltBoxSimpleExtension Objects of the following type are
   *                                    allowed in the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LatLonAltBox addToLatLonAltBoxSimpleExtension(final Object latLonAltBoxSimpleExtension) {
    this.getLatLonAltBoxSimpleExtension().add(latLonAltBoxSimpleExtension);
    return this;
  }

  /**
   * @see latLonAltBoxObjectExtension
   *
   * @param latLonAltBoxObjectExtension
   */
  public void setLatLonAltBoxObjectExtension(final List<AbstractObject> latLonAltBoxObjectExtension) {
    this.latLonAltBoxObjectExtension = latLonAltBoxObjectExtension;
  }

  /**
   * add a value to the latLonAltBoxObjectExtension property collection
   *
   * @param latLonAltBoxObjectExtension Objects of the following type are
   *                                    allowed in the list:
   *                                    {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public LatLonAltBox addToLatLonAltBoxObjectExtension(final AbstractObject latLonAltBoxObjectExtension) {
    this.getLatLonAltBoxObjectExtension().add(latLonAltBoxObjectExtension);
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
  public LatLonAltBox addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * @see abstractLatLonBoxSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setAbstractLatLonBoxSimpleExtension(final List<Object> abstractLatLonBoxSimpleExtension) {
    super.setAbstractLatLonBoxSimpleExtension(abstractLatLonBoxSimpleExtension);
  }

  @Obvious
  @Override
  public LatLonAltBox addToAbstractLatLonBoxSimpleExtension(final Object abstractLatLonBoxSimpleExtension) {
    super.getAbstractLatLonBoxSimpleExtension().add(abstractLatLonBoxSimpleExtension);
    return this;
  }

  /**
   * @see abstractLatLonBoxObjectExtension
   *
   */
  @Obvious
  @Override
  public void setAbstractLatLonBoxObjectExtension(final List<AbstractObject> abstractLatLonBoxObjectExtension) {
    super.setAbstractLatLonBoxObjectExtension(abstractLatLonBoxObjectExtension);
  }

  @Obvious
  @Override
  public LatLonAltBox addToAbstractLatLonBoxObjectExtension(final AbstractObject abstractLatLonBoxObjectExtension) {
    super.getAbstractLatLonBoxObjectExtension().add(abstractLatLonBoxObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setMinAltitude(double)
   *
   * @param minAltitude required parameter
   */
  public LatLonAltBox withMinAltitude(final double minAltitude) {
    this.setMinAltitude(minAltitude);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setMaxAltitude(double)
   *
   * @param maxAltitude required parameter
   */
  public LatLonAltBox withMaxAltitude(final double maxAltitude) {
    this.setMaxAltitude(maxAltitude);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAltitudeMode(Object)
   *
   * @param altitudeMode required parameter
   */
  public LatLonAltBox withAltitudeMode(final AltitudeMode altitudeMode) {
    this.setAltitudeMode(altitudeMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLatLonAltBoxSimpleExtension(List &lt;Object&gt;)
   *
   * @param latLonAltBoxSimpleExtension required parameter
   */
  public LatLonAltBox withLatLonAltBoxSimpleExtension(final List<Object> latLonAltBoxSimpleExtension) {
    this.setLatLonAltBoxSimpleExtension(latLonAltBoxSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLatLonAltBoxObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param latLonAltBoxObjectExtension required parameter
   */
  public LatLonAltBox withLatLonAltBoxObjectExtension(final List<AbstractObject> latLonAltBoxObjectExtension) {
    this.setLatLonAltBoxObjectExtension(latLonAltBoxObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public LatLonAltBox withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public LatLonAltBox withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public LatLonAltBox withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public LatLonAltBox withNorth(final double north) {
    super.withNorth(north);
    return this;
  }

  @Obvious
  @Override
  public LatLonAltBox withSouth(final double south) {
    super.withSouth(south);
    return this;
  }

  @Obvious
  @Override
  public LatLonAltBox withEast(final double east) {
    super.withEast(east);
    return this;
  }

  @Obvious
  @Override
  public LatLonAltBox withWest(final double west) {
    super.withWest(west);
    return this;
  }

  @Obvious
  @Override
  public LatLonAltBox withAbstractLatLonBoxSimpleExtension(final List<Object> abstractLatLonBoxSimpleExtension) {
    super.withAbstractLatLonBoxSimpleExtension(abstractLatLonBoxSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public LatLonAltBox withAbstractLatLonBoxObjectExtension(final List<AbstractObject> abstractLatLonBoxObjectExtension) {
    super.withAbstractLatLonBoxObjectExtension(abstractLatLonBoxObjectExtension);
    return this;
  }

  @Override
  public LatLonAltBox clone() {
    LatLonAltBox copy;
    copy = ((LatLonAltBox) super.clone());
    copy.latLonAltBoxSimpleExtension = new ArrayList<>((getLatLonAltBoxSimpleExtension().size()));
    for (Object iter : latLonAltBoxSimpleExtension) {
      copy.latLonAltBoxSimpleExtension.add(iter);
    }
    copy.latLonAltBoxObjectExtension = new ArrayList<>((getLatLonAltBoxObjectExtension().size()));
    for (AbstractObject iter : latLonAltBoxObjectExtension) {
      copy.latLonAltBoxObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
