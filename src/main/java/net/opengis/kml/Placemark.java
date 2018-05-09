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
import net.opengis.kml.atom.Author;
import net.opengis.kml.atom.Link;
import net.opengis.kml.gx.MultiTrack;
import net.opengis.kml.gx.Track;
import net.opengis.kml.xal.AddressDetails;

/**
 * &lt;Placemark&gt;
 * <p>
 * A Placemark is a Feature with associated Geometry. In Google Earth, a
 * Placemark appears as a list item in the Places panel. A Placemark with a
 * Point has an icon associated with it that marks a point on the Earth in the
 * 3D viewer. (In the Google Earth 3D viewer, a Point Placemark is the only
 * object you can click or roll over. Other Geometry objects do not have an icon
 * in the 3D viewer. To give the user something to click in the 3D viewer, you
 * would need to create a MultiGeometry object that contains both a Point and
 * the other Geometry object.) Syntax: &lt;pre&gt; &lt;strong&gt;&lt;Placemark
 * id="ID"&gt; &lt;/strong&gt; &lt;!-- inherited from &lt;em&gt;Feature
 * &lt;/em&gt; element --&gt; &lt;name&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/name&gt; &lt;!-- string --&gt;
 * &lt;visibility&gt;1&lt;/visibility&gt; &lt;!-- boolean --&gt;
 * &lt;open&gt;0&lt;/open&gt; &lt;!-- boolean --&gt;
 * &lt;span&gt;&lt;atom:author&gt;...&lt;atom:author&gt; &lt;!-- xmlns:atom
 * --&gt; &lt;atom:link&gt;...&lt;/atom:link&gt; &lt;/span&gt; &lt;span&gt;
 * &lt;!-- xmlns:atom --&gt; &lt;/span&gt; &lt;address&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/address&gt; &lt;!-- string --&gt;
 * &lt;xal:AddressDetails&gt;...&lt;/xal:AddressDetails&gt; &lt;!-- xmlns:xal
 * --&gt; &lt;br&gt; &lt;phoneNumber&gt;...&lt;/phoneNumber&gt; &lt;!-- string
 * --&gt; &lt;br&gt; &lt;Snippet maxLines="2"&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/Snippet&gt; &lt;!-- string --&gt; &lt;description&gt;
 * &lt;em&gt;... &lt;/em&gt;&lt;/description&gt; &lt;!-- string --&gt;
 * &lt;span&gt; &lt;em&gt;&lt;AbstractView&gt;...&lt;/AbstractView&gt;
 * &lt;/em&gt; &lt;!-- Camera &lt;em&gt;or &lt;/em&gt; LookAt --&gt;
 * &lt;/span&gt; &lt; &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;...&lt;/
 * &lt;em&gt;TimePrimitive &lt;/em&gt;&gt; &lt;styleUrl&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/styleUrl&gt; &lt;!-- anyURI --&gt; &lt;
 * &lt;em&gt;StyleSelector&gt;...&lt;/StyleSelector&gt; &lt;/em&gt;
 * &lt;Region&gt;...&lt;/Region&gt;
 * &lt;span&gt;&lt;Metadata&gt;...&lt;/Metadata&gt; &lt;!-- deprecated in KML
 * 2.2 --&gt; &lt;ExtendedData&gt;...&lt;/ExtendedData&gt; &lt;!-- new in KML
 * 2.2 --&gt; &lt;/span&gt; &lt;br&gt; &lt;!-- specific to Placemark element
 * --&gt; &lt;em&gt;&lt;Geometry&gt;...&lt;/Geometry&gt; &lt;/em&gt;
 * &lt;strong&gt;&lt;/Placemark&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Feature&gt;
 *
 * Contained By:
 * @see: &lt;Document&gt;
 * @see: &lt;Folder&gt;
 *
 * See Also: &lt;Icon&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlacemarkType", propOrder = {
  "geometry",
  "placemarkSimpleExtension",
  "placemarkObjectExtension"
})
@XmlRootElement(name = "Placemark", namespace = "http://www.opengis.net/kml/2.2")
public class Placemark extends Feature implements Cloneable {

  /**
   * &lt;Geometry&gt;
   * <p>
   * This is an abstract element and cannot be used directly in a KML file. It
   * provides a placeholder object for all derived Geometry objects. Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt;
   *  &lt;strong&gt;&lt;! &lt;em&gt;-- Geometry &lt;/em&gt; id="ID" --&gt;                 &lt;!-- Point,LineString,LinearRing,
   *                                                Polygon,MultiGeometry,Model --&gt; &lt;/strong&gt;
   *  &lt;strong&gt;&lt;!-- / &lt;em&gt;Geometry -- &lt;/em&gt;&gt; &lt;/strong&gt;
   * </pre>
   * <p>
   * Extends:
   *
   * @see: &lt;Object&gt;
   *
   * Extended By:
   * @see: &lt;LineString&gt;
   * @see: &lt;LinearRing&gt;
   * @see: &lt;Model&gt;
   * @see: &lt;Point&gt;
   * @see: MultiGeometry
   * @see: Polygon
   *
   */
  @XmlElementRef(name = "AbstractGeometryGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected Geometry geometry;
  @XmlElement(name = "PlacemarkSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> placemarkSimpleExtension;
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
  @XmlElement(name = "PlacemarkObjectExtensionGroup")
  protected List<AbstractObject> placemarkObjectExtension;

  public Placemark() {
    super();
  }

  /**
   * @see geometry
   *
   * @return possible object is null null null null null null null null null   {@code Geometry}
     *     {@code Point}
   *     {@code LinearRing}
   *     {@code Polygon}
   *     {@code Track}
   *     {@code MultiTrack}
   *     {@code Model}
   *     {@code LineString}
   *     {@code MultiGeometry}
   *
   */
  public Geometry getGeometry() {
    return geometry;
  }

  /**
   * @see geometry
   *
   * @param value allowed object is null null null null null null null null null   {@code Geometry}
     *     {@code Point}
   *     {@code LinearRing}
   *     {@code Polygon}
   *     {@code Track}
   *     {@code MultiTrack}
   *     {@code Model}
   *     {@code LineString}
   *     {@code MultiGeometry}
   *
   */
  public void setGeometry(Geometry value) {
    this.geometry = ((Geometry) value);
  }

  /**
   * @see placemarkSimpleExtension
   *
   */
  public List<Object> getPlacemarkSimpleExtension() {
    if (placemarkSimpleExtension == null) {
      placemarkSimpleExtension = new ArrayList<>();
    }
    return this.placemarkSimpleExtension;
  }

  /**
   * @see placemarkObjectExtension
   *
   */
  public List<AbstractObject> getPlacemarkObjectExtension() {
    if (placemarkObjectExtension == null) {
      placemarkObjectExtension = new ArrayList<>();
    }
    return this.placemarkObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((geometry == null) ? 0 : geometry.hashCode()));
    result = ((prime * result) + ((placemarkSimpleExtension == null) ? 0 : placemarkSimpleExtension.hashCode()));
    result = ((prime * result) + ((placemarkObjectExtension == null) ? 0 : placemarkObjectExtension.hashCode()));
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
    if ((obj instanceof Placemark) == false) {
      return false;
    }
    Placemark other = ((Placemark) obj);
    if (geometry == null) {
      if (other.geometry != null) {
        return false;
      }
    } else if (geometry.equals(other.geometry) == false) {
      return false;
    }
    if (placemarkSimpleExtension == null) {
      if (other.placemarkSimpleExtension != null) {
        return false;
      }
    } else if (placemarkSimpleExtension.equals(other.placemarkSimpleExtension) == false) {
      return false;
    }
    if (placemarkObjectExtension == null) {
      if (other.placemarkObjectExtension != null) {
        return false;
      }
    } else if (placemarkObjectExtension.equals(other.placemarkObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code MultiTrack} and set it to geometry.
   * <p>
   * This method is a short version for: &lt;code&gt; MultiTrack multiTrack =
   * new MultiTrack(); this.setGeometry(multiTrack); &lt;/code&gt;
   */
  public MultiTrack createAndSetMultiTrack() {
    MultiTrack newValue = new MultiTrack();
    this.setGeometry(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Track} and set it to geometry.
   * <p>
   * This method is a short version for: &lt;code&gt; Track track = new Track();
   * this.setGeometry(track); &lt;/code&gt;
   */
  public Track createAndSetTrack() {
    Track newValue = new Track();
    this.setGeometry(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code LinearRing} and set it to geometry.
   * <p>
   * This method is a short version for: &lt;code&gt; LinearRing linearRing =
   * new LinearRing(); this.setGeometry(linearRing); &lt;/code&gt;
   */
  public LinearRing createAndSetLinearRing() {
    LinearRing newValue = new LinearRing();
    this.setGeometry(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Point} and set it to geometry.
   * <p>
   * This method is a short version for: &lt;code&gt; Point point = new Point();
   * this.setGeometry(point); &lt;/code&gt;
   */
  public Point createAndSetPoint() {
    Point newValue = new Point();
    this.setGeometry(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Model} and set it to geometry.
   * <p>
   * This method is a short version for: &lt;code&gt; Model model = new Model();
   * this.setGeometry(model); &lt;/code&gt;
   */
  public Model createAndSetModel() {
    Model newValue = new Model();
    this.setGeometry(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code MultiGeometry} and set it to geometry.
   * <p>
   * This method is a short version for: &lt;code&gt; MultiGeometry
   * multiGeometry = new MultiGeometry(); this.setGeometry(multiGeometry);
   * &lt;/code&gt;
   */
  public MultiGeometry createAndSetMultiGeometry() {
    MultiGeometry newValue = new MultiGeometry();
    this.setGeometry(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code LineString} and set it to geometry.
   * <p>
   * This method is a short version for: &lt;code&gt; LineString lineString =
   * new LineString(); this.setGeometry(lineString); &lt;/code&gt;
   */
  public LineString createAndSetLineString() {
    LineString newValue = new LineString();
    this.setGeometry(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Polygon} and set it to geometry.
   * <p>
   * This method is a short version for: &lt;code&gt; Polygon polygon = new
   * Polygon(); this.setGeometry(polygon); &lt;/code&gt;
   */
  public Polygon createAndSetPolygon() {
    Polygon newValue = new Polygon();
    this.setGeometry(newValue);
    return newValue;
  }

  /**
   * @see placemarkSimpleExtension
   *
   * @param placemarkSimpleExtension
   */
  public void setPlacemarkSimpleExtension(final List<Object> placemarkSimpleExtension) {
    this.placemarkSimpleExtension = placemarkSimpleExtension;
  }

  /**
   * add a value to the placemarkSimpleExtension property collection
   *
   * @param placemarkSimpleExtension Objects of the following type are allowed
   *                                 in the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Placemark addToPlacemarkSimpleExtension(final Object placemarkSimpleExtension) {
    this.getPlacemarkSimpleExtension().add(placemarkSimpleExtension);
    return this;
  }

  /**
   * @see placemarkObjectExtension
   *
   * @param placemarkObjectExtension
   */
  public void setPlacemarkObjectExtension(final List<AbstractObject> placemarkObjectExtension) {
    this.placemarkObjectExtension = placemarkObjectExtension;
  }

  /**
   * add a value to the placemarkObjectExtension property collection
   *
   * @param placemarkObjectExtension Objects of the following type are allowed
   *                                 in the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Placemark addToPlacemarkObjectExtension(final AbstractObject placemarkObjectExtension) {
    this.getPlacemarkObjectExtension().add(placemarkObjectExtension);
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
  public Placemark addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * @see styleSelector
   *
   */
  @Obvious
  @Override
  public void setStyleSelector(final List<StyleSelector> styleSelector) {
    super.setStyleSelector(styleSelector);
  }

  @Obvious
  @Override
  public Placemark addToStyleSelector(final StyleSelector styleSelector) {
    super.getStyleSelector().add(styleSelector);
    return this;
  }

  /**
   * @see featureSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.setFeatureSimpleExtension(featureSimpleExtension);
  }

  @Obvious
  @Override
  public Placemark addToFeatureSimpleExtension(final Object featureSimpleExtension) {
    super.getFeatureSimpleExtension().add(featureSimpleExtension);
    return this;
  }

  /**
   * @see featureObjectExtension
   *
   */
  @Obvious
  @Override
  public void setFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.setFeatureObjectExtension(featureObjectExtension);
  }

  @Obvious
  @Override
  public Placemark addToFeatureObjectExtension(final AbstractObject featureObjectExtension) {
    super.getFeatureObjectExtension().add(featureObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setGeometry(Geometry)
   *
   * @param geometry required parameter
   */
  public Placemark withGeometry(final Geometry geometry) {
    this.setGeometry(geometry);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPlacemarkSimpleExtension(List &lt;Object&gt;)
   *
   * @param placemarkSimpleExtension required parameter
   */
  public Placemark withPlacemarkSimpleExtension(final List<Object> placemarkSimpleExtension) {
    this.setPlacemarkSimpleExtension(placemarkSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPlacemarkObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param placemarkObjectExtension required parameter
   */
  public Placemark withPlacemarkObjectExtension(final List<AbstractObject> placemarkObjectExtension) {
    this.setPlacemarkObjectExtension(placemarkObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Placemark withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Placemark withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Placemark withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public Placemark withName(final String name) {
    super.withName(name);
    return this;
  }

  @Obvious
  @Override
  public Placemark withVisibility(final Boolean visibility) {
    super.withVisibility(visibility);
    return this;
  }

  @Obvious
  @Override
  public Placemark withOpen(final Boolean open) {
    super.withOpen(open);
    return this;
  }

  @Obvious
  @Override
  public Placemark withAtomAuthor(final Author atomAuthor) {
    super.withAtomAuthor(atomAuthor);
    return this;
  }

  @Obvious
  @Override
  public Placemark withAtomLink(final Link atomLink) {
    super.withAtomLink(atomLink);
    return this;
  }

  @Obvious
  @Override
  public Placemark withAddress(final String address) {
    super.withAddress(address);
    return this;
  }

  @Obvious
  @Override
  public Placemark withXalAddressDetails(final AddressDetails xalAddressDetails) {
    super.withXalAddressDetails(xalAddressDetails);
    return this;
  }

  @Obvious
  @Override
  public Placemark withPhoneNumber(final String phoneNumber) {
    super.withPhoneNumber(phoneNumber);
    return this;
  }

  @Obvious
  @Override
  public Placemark withSnippet(final Snippet snippet) {
    super.withSnippet(snippet);
    return this;
  }

  @Obvious
  @Override
  public Placemark withSnippetd(final String snippetd) {
    super.withSnippetd(snippetd);
    return this;
  }

  @Obvious
  @Override
  public Placemark withDescription(final String description) {
    super.withDescription(description);
    return this;
  }

  @Obvious
  @Override
  public Placemark withAbstractView(final AbstractView abstractView) {
    super.withAbstractView(abstractView);
    return this;
  }

  @Obvious
  @Override
  public Placemark withTimePrimitive(final TimePrimitive timePrimitive) {
    super.withTimePrimitive(timePrimitive);
    return this;
  }

  @Obvious
  @Override
  public Placemark withStyleUrl(final String styleUrl) {
    super.withStyleUrl(styleUrl);
    return this;
  }

  @Obvious
  @Override
  public Placemark withStyleSelector(final List<StyleSelector> styleSelector) {
    super.withStyleSelector(styleSelector);
    return this;
  }

  @Obvious
  @Override
  public Placemark withRegion(final Region region) {
    super.withRegion(region);
    return this;
  }

  @Obvious
  @Override
  public Placemark withMetadata(final Metadata metadata) {
    super.withMetadata(metadata);
    return this;
  }

  @Obvious
  @Override
  public Placemark withExtendedData(final ExtendedData extendedData) {
    super.withExtendedData(extendedData);
    return this;
  }

  @Obvious
  @Override
  public Placemark withFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.withFeatureSimpleExtension(featureSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Placemark withFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.withFeatureObjectExtension(featureObjectExtension);
    return this;
  }

  @Override
  public Placemark clone() {
    Placemark copy;
    copy = ((Placemark) super.clone());
    copy.geometry = ((geometry == null) ? null : ((Geometry) geometry.clone()));
    copy.placemarkSimpleExtension = new ArrayList<>((getPlacemarkSimpleExtension().size()));
    for (Object iter : placemarkSimpleExtension) {
      copy.placemarkSimpleExtension.add(iter);
    }
    copy.placemarkObjectExtension = new ArrayList<>((getPlacemarkObjectExtension().size()));
    for (AbstractObject iter : placemarkObjectExtension) {
      copy.placemarkObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
