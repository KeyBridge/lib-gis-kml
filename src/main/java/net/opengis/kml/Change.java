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
import net.opengis.kml.gx.*;

/**
 * &lt;change&gt;
 * <p>
 * Children of this element are the element(s) to be modified, which are
 * identified by the targetId attribute. Modifies the values in an element that
 * has already been loaded with a &lt;NetworkLink&gt;. Within the Change
 * element, the child to be modified must include a targetId attribute that
 * references the original element's id. This update can be considered a "sparse
 * update": in the modified element, only the values listed in &lt;Change&gt;
 * are replaced; all other values remained untouched. When &lt;Change&gt; is
 * applied to a set of coordinates, the new coordinates replace the current
 * coordinates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeType", propOrder = {
  "abstractObject"
})
@XmlRootElement(name = "Change", namespace = "http://www.opengis.net/kml/2.2")
public class Change implements Cloneable {

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
  @XmlElementRef(name = "AbstractObjectGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected List<AbstractObject> abstractObject;

  public Change() {
    super();
  }

  /**
   * @see abstractObject
   *
   */
  public List<AbstractObject> getAbstractObject() {
    if (abstractObject == null) {
      abstractObject = new ArrayList<>();
    }
    return this.abstractObject;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((abstractObject == null) ? 0 : abstractObject.hashCode()));
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
    if ((obj instanceof Change) == false) {
      return false;
    }
    Change other = ((Change) obj);
    if (abstractObject == null) {
      if (other.abstractObject != null) {
        return false;
      }
    } else if (abstractObject.equals(other.abstractObject) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see abstractObject
   *
   * @param abstractObject
   */
  public void setAbstractObject(final List<AbstractObject> abstractObject) {
    this.abstractObject = abstractObject;
  }

  /**
   * add a value to the abstractObject property collection
   *
   * @param abstractObject Objects of the following type are allowed in the
   *                       list:
   *                       {@code LatLonAltBox}{@code JAXBElement}{@code Alias}{@code JAXBElement}{@code Camera}{@code JAXBElement}{@code Placemark}{@code JAXBElement}{@code Orientation}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code Folder}{@code JAXBElement}{@code PhotoOverlay}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code TimeSpan}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code TimeStamp}{@code JAXBElement}{@code ResourceMap}{@code JAXBElement}{@code ScreenOverlay}{@code JAXBElement}{@code Scale}{@code JAXBElement}{@code FlyTo}{@code JAXBElement}{@code LabelStyle}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code ViewVolume}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code TourPrimitive}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code Data}{@code JAXBElement}{@code PolyStyle}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code ItemIcon}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code Wait}{@code JAXBElement}{@code MultiTrack}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code TourControl}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code Link}{@code JAXBElement}{@code Geometry}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code NetworkLink}{@code JAXBElement}{@code Model}{@code JAXBElement}{@code ColorStyle}{@code JAXBElement}{@code ViewerOptions}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code SubStyle}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code MultiGeometry}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code LinearRing}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code Document}{@code JAXBElement}{@code TimeStamp}{@code JAXBElement}{@code ListStyle}{@code JAXBElement}{@code Location}{@code JAXBElement}{@code Feature}{@code JAXBElement}{@code StyleSelector}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code Link}{@code JAXBElement}{@code Style}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code TimeSpan}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code IconStyle}{@code JAXBElement}{@code StyleMap}{@code JAXBElement}{@code Overlay}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code GroundOverlay}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code SoundCue}{@code JAXBElement}{@code Polygon}{@code JAXBElement}{@code Track}{@code JAXBElement}{@code AnimatedUpdate}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code Playlist}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code Link}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code ImagePyramid}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code Point}{@code JAXBElement}{@code LatLonBox}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code LineString}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code TimePrimitive}{@code JAXBElement}{@code LineStyle}{@code JAXBElement}{@code Container}{@code JAXBElement}{@code Lod}{@code JAXBElement}{@code Tour}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code LatLonQuad}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code Pair}{@code JAXBElement}{@code AbstractView}{@code JAXBElement}{@code LookAt}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code BalloonStyle}{@code JAXBElement}{@code Region}{@code JAXBElement}{@code AbstractObject}{@code JAXBElement}{@code SchemaData}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Change addToAbstractObject(final AbstractObject abstractObject) {
    this.getAbstractObject().add(abstractObject);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAbstractObject(List &lt;AbstractObject&gt;)
   *
   * @param abstractObject required parameter
   */
  public Change withAbstractObject(final List<AbstractObject> abstractObject) {
    this.setAbstractObject(abstractObject);
    return this;
  }

  @Override
  public Change clone() {
    Change copy;
    try {
      copy = ((Change) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.abstractObject = new ArrayList<>((getAbstractObject().size()));
    for (AbstractObject iter : abstractObject) {
      copy.abstractObject.add(iter.clone());
    }
    return copy;
  }

}
