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
 *  &lt;change&gt;
 *   
 * Children of this element are the element(s) to be modified, which are
 * identified by the targetId attribute. Modifies the values in an element that
 * has already been loaded with a
 *  &lt;NetworkLink&gt;. Within the Change element, the child to be modified must
 * include a targetId attribute that references the original element's id. This
 * update can be considered a "sparse update": in the modified element, only the
 * values listed in  &lt;Change&gt; are replaced; all other values remained untouched.
 * When
 *  &lt;Change&gt; is applied to a set of coordinates, the new coordinates replace the
 * current coordinates.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeType", propOrder = {
  "abstractObject"
})
@XmlRootElement(name = "Change", namespace = "http://www.opengis.net/kml/2.2")
public class Change implements Cloneable {

  /**
   *  &lt;Object&gt;
   *   
   * This is an abstract base class and cannot be used directly in a KML file.
   * It provides the id attribute, which allows unique identification of a KML
   * element, and the targetId attribute, which is used to reference objects
   * that have already been loaded into Google Earth. The id attribute must be
   * assigned if the  &lt;Update&gt; mechanism is to be used. Syntax:
   *  <pre>&lt;!-- abstract element; do not create --&gt; &lt;strong&gt;
   * &lt;!--  &lt;em&gt;Object &lt;/em&gt; id="ID" targetId="NCName" --&gt;
   * &lt;!-- / &lt;em&gt;Object &lt;/em&gt;&gt; --&gt; &lt;/strong&gt; </pre>
   *   
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
   *                       {@link LatLonAltBox}{@link JAXBElement}{@link Alias}{@link JAXBElement}{@link Camera}{@link JAXBElement}{@link Placemark}{@link JAXBElement}{@link Orientation}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link Folder}{@link JAXBElement}{@link PhotoOverlay}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link TimeSpan}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link TimeStamp}{@link JAXBElement}{@link ResourceMap}{@link JAXBElement}{@link ScreenOverlay}{@link JAXBElement}{@link Scale}{@link JAXBElement}{@link FlyTo}{@link JAXBElement}{@link LabelStyle}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link ViewVolume}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link TourPrimitive}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link Data}{@link JAXBElement}{@link PolyStyle}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link ItemIcon}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link Wait}{@link JAXBElement}{@link MultiTrack}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link TourControl}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link Link}{@link JAXBElement}{@link Geometry}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link NetworkLink}{@link JAXBElement}{@link Model}{@link JAXBElement}{@link ColorStyle}{@link JAXBElement}{@link ViewerOptions}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link SubStyle}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link MultiGeometry}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link LinearRing}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link Document}{@link JAXBElement}{@link TimeStamp}{@link JAXBElement}{@link ListStyle}{@link JAXBElement}{@link Location}{@link JAXBElement}{@link Feature}{@link JAXBElement}{@link StyleSelector}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link Link}{@link JAXBElement}{@link Style}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link TimeSpan}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link IconStyle}{@link JAXBElement}{@link StyleMap}{@link JAXBElement}{@link Overlay}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link GroundOverlay}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link SoundCue}{@link JAXBElement}{@link Polygon}{@link JAXBElement}{@link Track}{@link JAXBElement}{@link AnimatedUpdate}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link Playlist}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link Link}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link ImagePyramid}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link Point}{@link JAXBElement}{@link LatLonBox}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link LineString}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link TimePrimitive}{@link JAXBElement}{@link LineStyle}{@link JAXBElement}{@link Container}{@link JAXBElement}{@link Lod}{@link JAXBElement}{@link Tour}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link LatLonQuad}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link Pair}{@link JAXBElement}{@link AbstractView}{@link JAXBElement}{@link LookAt}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link BalloonStyle}{@link JAXBElement}{@link Region}{@link JAXBElement}{@link AbstractObject}{@link JAXBElement}{@link SchemaData}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
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
