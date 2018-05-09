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
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import net.opengis.kml.annotations.Obvious;

/**
 * &lt;Point&gt;
 * <p>
 * A geographic location defined by longitude, latitude, and (optional)
 * altitude. When a Point is contained by a Placemark, the point itself
 * determines the position of the Placemark's name and icon. When a Point is
 * extruded, it is connected to the ground with a line. This "tether" uses the
 * current LineStyle. The &lt;Point&gt; element acts as a &lt;Point&gt; inside a
 * &lt;Placemark&gt; element. It draws an icon to mark the position of the
 * PhotoOverlay. The icon drawn is specified by the &lt;styleUrl&gt; and
 * &lt;StyleSelector&gt; fields, just as it is for &lt;Placemark&gt;. Syntax:
 * &lt;pre&gt; &lt;strong&gt;&lt;Point id="ID"&gt; &lt;/strong&gt; &lt;!--
 * specific to Point --&gt; &lt;extrude&gt;0&lt;/extrude&gt; &lt;!-- boolean
 * --&gt; &lt;altitudeMode&gt;clampToGround&lt;/altitudeMode&gt; &lt;!--
 * kml:altitudeModeEnum: clampToGround, relativeToGround, or absolute --&gt;
 * &lt;!-- or, substitute gx:altitudeMode: clampToSeaFloor, relativeToSeaFloor
 * --&gt; &lt;coordinates&gt; &lt;em&gt;... &lt;/em&gt;&lt;/coordinates&gt;
 * &lt;span class="style1"&gt; &lt;em&gt; &lt;/em&gt; &lt;/span&gt;&lt;!--
 * lon,lat[,alt] --&gt; &lt;strong&gt;&lt;/Point&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Geometry&gt;
 *
 * Contained By:
 * @see: &lt;MultiGeometry&gt;
 * @see: &lt;Placemark&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PointType", propOrder = {
  "extrude",
  "altitudeMode",
  "coordinates",
  "pointSimpleExtension",
  "pointObjectExtension"
})
@XmlRootElement(name = "Point", namespace = "http://www.opengis.net/kml/2.2")
public class Point extends Geometry implements Cloneable {

  /**
   * Boolean value. Specifies whether to connect the LineString to the ground.
   * To extrude a LineString, the altitude mode must be either relativeToGround,
   * relativeToSeaFloor, or absolute. The vertices in the LineString are
   * extruded toward the center of the Earth's sphere.
   * <p>
   * Boolean value. Specifies whether to connect the LinearRing to the ground.
   * To extrude this geometry, the altitude mode must be either
   * relativeToGround, relativeToSeaFloor, or absolute. Only the vertices of the
   * LinearRing are extruded, not the center of the geometry. The vertices are
   * extruded toward the center of the Earth's sphere.
   * <p>
   * Boolean value. Specifies whether to connect the Polygon to the ground. To
   * extrude a Polygon, the altitude mode must be either relativeToGround,
   * relativeToSeaFloor, or absolute. Only the vertices are extruded, not the
   * geometry itself (for example, a rectangle turns into a box with five faces.
   * The vertices of the Polygon are extruded toward the center of the Earth's
   * sphere.
   * <p>
   * Boolean value. Specifies whether to connect the point to the ground with a
   * line. To extrude a Point, the value for {@code altitudeMode} must be either
   * relativeToGround, relativeToSeaFloor, or absolute. The point is extruded
   * toward the center of the Earth's sphere.
   */
  @XmlElement(defaultValue = "0")
  @XmlJavaTypeAdapter(BooleanConverter.class)
  protected Boolean extrude;
  /**
   * AltitudeMode
   * <p>
   * clampToGround, relativeToGround, absolute See Also: See &lt;LookAt&gt; and
   * &lt;Region&gt;
   * <p>
   */
  @XmlElement(defaultValue = "clampToGround")
  protected AltitudeMode altitudeMode;
  /**
   * A single tuple consisting of floating point values for longitude, latitude,
   * and altitude (in that order). Longitude and latitude values are in degrees,
   * where longitude&gt;= −180 and &lt;= 180 latitude&gt;= −90 and &lt;-≤ 90
   * altitude values (optional) are in meters above sea level
   * <p>
   * Do not include spaces between the three values that describe a coordinate.
   * <p>
   * Two or more coordinate tuples, each consisting of floating point values for
   * longitude, latitude, and altitude. The altitude component is optional.
   * Insert a space between tuples. Do not include spaces within a tuple.
   */
  @XmlElement(namespace = "http://www.opengis.net/kml/2.2", type = String.class)
  @XmlJavaTypeAdapter(CoordinatesConverter.class)
  protected List<Coordinate> coordinates;
  @XmlElement(name = "PointSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> pointSimpleExtension;
  /**
   * This is an abstract base class and cannot be used directly in a KML file.
   * It provides the id attribute, which allows unique identification of a KML
   * element, and the targetId attribute, which is used to reference objects
   * that have already been loaded into Google Earth. The id attribute must be
   * assigned if the Update mechanism is to be used.
   * <p>
   * Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt; &lt;strong&gt;
   * &lt;!--  &lt;em&gt;Object &lt;/em&gt; id="ID" targetId="NCName" --&gt;
   * &lt;!-- / &lt;em&gt;Object &lt;/em&gt;&gt; --&gt; &lt;/strong&gt; </pre>
   */
  @XmlElement(name = "PointObjectExtensionGroup")
  protected List<AbstractObject> pointObjectExtension;

  public Point() {
    super();
  }

  public static Point getInstance(com.vividsolutions.jts.geom.Point point) {
    Point p = new Point();
    p.getCoordinates().add(new Coordinate(point.getX(), point.getY()));
    return p;
  }

  /**
   * @return possible object is {@code Boolean}
   *
   */
  public Boolean isExtrude() {
    return extrude;
  }

  /**
   * @see extrude
   *
   * @param value allowed object is {@code Boolean}
   *
   */
  public void setExtrude(Boolean value) {
    this.extrude = value;
  }

  /**
   * @see altitudeMode
   *
   * @return possible object is null null null null null null null null   {@code Object}
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
   * @param value allowed object is null null null null null null null null   {@code Object}
     *     {@code net.opengis.kml.AltitudeMode}
   *     {@code de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}
   *
   */
  public void setAltitudeMode(AltitudeMode value) {
    this.altitudeMode = value;
  }

  /**
   * @see pointSimpleExtension
   *
   */
  public List<Object> getPointSimpleExtension() {
    if (pointSimpleExtension == null) {
      pointSimpleExtension = new ArrayList<>();
    }
    return this.pointSimpleExtension;
  }

  /**
   * @see pointObjectExtension
   *
   */
  public List<AbstractObject> getPointObjectExtension() {
    if (pointObjectExtension == null) {
      pointObjectExtension = new ArrayList<>();
    }
    return this.pointObjectExtension;
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
    result = ((prime * result) + ((extrude == null) ? 0 : extrude.hashCode()));
    result = ((prime * result) + ((altitudeMode == null) ? 0 : altitudeMode.hashCode()));
    result = ((prime * result) + ((coordinates == null) ? 0 : coordinates.hashCode()));
    result = ((prime * result) + ((pointSimpleExtension == null) ? 0 : pointSimpleExtension.hashCode()));
    result = ((prime * result) + ((pointObjectExtension == null) ? 0 : pointObjectExtension.hashCode()));
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
    if ((obj instanceof Point) == false) {
      return false;
    }
    Point other = ((Point) obj);
    if (extrude == null) {
      if (other.extrude != null) {
        return false;
      }
    } else if (extrude.equals(other.extrude) == false) {
      return false;
    }
    if (altitudeMode == null) {
      if (other.altitudeMode != null) {
        return false;
      }
    } else if (altitudeMode.equals(other.altitudeMode) == false) {
      return false;
    }
    if (coordinates == null) {
      if (other.coordinates != null) {
        return false;
      }
    } else if (coordinates.equals(other.coordinates) == false) {
      return false;
    }
    if (pointSimpleExtension == null) {
      if (other.pointSimpleExtension != null) {
        return false;
      }
    } else if (pointSimpleExtension.equals(other.pointSimpleExtension) == false) {
      return false;
    }
    if (pointObjectExtension == null) {
      if (other.pointObjectExtension != null) {
        return false;
      }
    } else if (pointObjectExtension.equals(other.pointObjectExtension) == false) {
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
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Point addToCoordinates(final double longitude, final double latitude) {
    this.getCoordinates().add(new Coordinate(longitude, latitude));
    return this;
  }

  /**
   * add a value to the coordinates property collection
   *
   * @param longitude required parameter
   * @param latitude  required parameter
   * @param altitude  required parameter
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Point addToCoordinates(final double longitude, final double latitude, final double altitude) {
    this.getCoordinates().add(new Coordinate(longitude, latitude, altitude));
    return this;
  }

  /**
   * add a value to the coordinates property collection
   *
   * @param coordinates required parameter
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Point addToCoordinates(final String coordinates) {
    this.getCoordinates().add(new Coordinate(coordinates));
    return this;
  }

  /**
   * @see pointSimpleExtension
   *
   * @param pointSimpleExtension
   */
  public void setPointSimpleExtension(final List<Object> pointSimpleExtension) {
    this.pointSimpleExtension = pointSimpleExtension;
  }

  /**
   * add a value to the pointSimpleExtension property collection
   *
   * @param pointSimpleExtension Objects of the following type are allowed in
   *                             the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Point addToPointSimpleExtension(final Object pointSimpleExtension) {
    this.getPointSimpleExtension().add(pointSimpleExtension);
    return this;
  }

  /**
   * @see pointObjectExtension
   *
   * @param pointObjectExtension
   */
  public void setPointObjectExtension(final List<AbstractObject> pointObjectExtension) {
    this.pointObjectExtension = pointObjectExtension;
  }

  /**
   * add a value to the pointObjectExtension property collection
   *
   * @param pointObjectExtension Objects of the following type are allowed in
   *                             the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Point addToPointObjectExtension(final AbstractObject pointObjectExtension) {
    this.getPointObjectExtension().add(pointObjectExtension);
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
  public Point addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * @see geometrySimpleExtension
   *
   */
  @Obvious
  @Override
  public void setGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
    super.setGeometrySimpleExtension(geometrySimpleExtension);
  }

  @Obvious
  @Override
  public Point addToGeometrySimpleExtension(final Object geometrySimpleExtension) {
    super.getGeometrySimpleExtension().add(geometrySimpleExtension);
    return this;
  }

  /**
   * @see geometryObjectExtension
   *
   */
  @Obvious
  @Override
  public void setGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
    super.setGeometryObjectExtension(geometryObjectExtension);
  }

  @Obvious
  @Override
  public Point addToGeometryObjectExtension(final AbstractObject geometryObjectExtension) {
    super.getGeometryObjectExtension().add(geometryObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setExtrude(Boolean)
   *
   * @param extrude required parameter
   */
  public Point withExtrude(final Boolean extrude) {
    this.setExtrude(extrude);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAltitudeMode(Object)
   *
   * @param altitudeMode required parameter
   */
  public Point withAltitudeMode(final AltitudeMode altitudeMode) {
    this.setAltitudeMode(altitudeMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setCoordinates(List &lt;Coordinate&gt;)
   *
   * @param coordinates required parameter
   */
  public Point withCoordinates(final List<Coordinate> coordinates) {
    this.setCoordinates(coordinates);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPointSimpleExtension(List &lt;Object&gt;)
   *
   * @param pointSimpleExtension required parameter
   */
  public Point withPointSimpleExtension(final List<Object> pointSimpleExtension) {
    this.setPointSimpleExtension(pointSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPointObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param pointObjectExtension required parameter
   */
  public Point withPointObjectExtension(final List<AbstractObject> pointObjectExtension) {
    this.setPointObjectExtension(pointObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Point withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Point withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Point withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public Point withGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
    super.withGeometrySimpleExtension(geometrySimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Point withGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
    super.withGeometryObjectExtension(geometryObjectExtension);
    return this;
  }

  /**
   * Creates a new instance of {@code List}{@code Coordinate} and set it to
   * this.coordinates.
   * <p>
   * This method is a short version for:
   * <pre>
   *  &lt;code&gt;
   * List &lt;Coordinate&gt; newValue = new List &lt;Coordinate&gt;();
   * this.setCoordinates(newValue);  &lt;/code&gt;
   * </pre>
   */
  public List<Coordinate> createAndSetCoordinates() {
    List<Coordinate> newValue = new ArrayList<>();
    this.setCoordinates(newValue);
    return newValue;
  }

  @Override
  public Point clone() {
    Point copy;
    copy = ((Point) super.clone());
    copy.coordinates = new ArrayList<>((getCoordinates().size()));
    for (Coordinate iter : coordinates) {
      copy.coordinates.add(iter.clone());
    }
    copy.pointSimpleExtension = new ArrayList<>((getPointSimpleExtension().size()));
    for (Object iter : pointSimpleExtension) {
      copy.pointSimpleExtension.add(iter);
    }
    copy.pointObjectExtension = new ArrayList<>((getPointObjectExtension().size()));
    for (AbstractObject iter : pointObjectExtension) {
      copy.pointObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
