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
 * &lt;Model&gt;
 * <p>
 * A 3D object described in a COLLADA file (referenced in the &lt;Link&gt; tag).
 * COLLADA files have a .dae file extension. Models are created in their own
 * coordinate space and then located, positioned, and scaled in Google Earth.
 * See the "Topics in KML" page on Regions for more detail. Google Earth
 * supports only triangles and lines as primitive types. The maximum number of
 * triangles allowed is 21845. Google Earth does not support animation or
 * skinning. Google Earth does not support external geometry references. Google
 * Earth supports the COLLADA common profile, with the following exceptions:
 * Syntax: &lt;pre&gt; &lt;strong&gt;&lt;Model id="ID"&gt; &lt;/strong&gt;
 * &lt;!-- specific to Model --&gt;
 * &lt;altitudeMode&gt;clampToGround&lt;/altitudeMode&gt; &lt;!--
 * kml:altitudeModeEnum: clampToGround,relativeToGround, &lt;em&gt;or
 * &lt;/em&gt; absolute --&gt; &lt;!-- or, substitute gx:altitudeMode:
 * clampToSeaFloor, relativeToSeaFloor --&gt; &lt;Location&gt;
 * &lt;longitude&gt;&lt;/longitude&gt; &lt;!-- kml:angle180 --&gt;
 * &lt;latitude&gt;&lt;/latitude&gt; &lt;!-- kml:angle90 --&gt;
 * &lt;altitude&gt;0&lt;/altitude&gt; &lt;!-- double --&gt; &lt;/Location&gt;
 * &lt;Orientation&gt; &lt;heading&gt;0&lt;/heading&gt; &lt;!-- kml:angle360
 * --&gt; &lt;tilt&gt;0&lt;/tilt&gt; &lt;!-- kml:angle360 --&gt;
 * &lt;roll&gt;0&lt;/roll&gt; &lt;!-- kml:angle360 --&gt; &lt;/Orientation&gt;
 * &lt;Scale&gt; &lt;x&gt;1&lt;/x&gt; &lt;!-- double --&gt; &lt;y&gt;1&lt;/y&gt;
 * &lt;!-- double --&gt; &lt;z&gt;1&lt;/z&gt; &lt;!-- double --&gt;
 * &lt;/Scale&gt; &lt;Link&gt;...&lt;/Link&gt; &lt;span&gt;&lt;ResourceMap&gt;
 * &lt;Alias&gt; &lt;targetHref&gt;...&lt;/targetHref&gt; &lt;!-- anyURI --&gt;
 * &lt;sourceHref&gt;...&lt;/sourceHref&gt; &lt;!-- anyURI --&gt; &lt;/Alias&gt;
 * &lt;/ResourceMap&gt; &lt;/span&gt; &lt;strong&gt;&lt;/Model&gt;
 * &lt;/strong&gt; </pre>
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
@XmlType(name = "ModelType", propOrder = {
  "altitudeMode",
  "location",
  "orientation",
  "scale",
  "link",
  "resourceMap",
  "modelSimpleExtension",
  "modelObjectExtension"
})
@XmlRootElement(name = "Model", namespace = "http://www.opengis.net/kml/2.2")
public class Model extends Geometry implements Cloneable {

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
   * &lt;location&gt;
   * <p>
   * Specifies the exact coordinates of the Model's origin in latitude,
   * longitude, and altitude. Latitude and longitude measurements are standard
   * lat-lon projection with WGS84 datum. Altitude is distance above the earth's
   * surface, in meters, and is interpreted according to &lt;altitudeMode&gt; or
   * &lt;gx:altitudeMode&gt;. &lt;Location&gt;
   * &lt;longitude&gt;39.55375305703105 &lt;/longitude&gt;
   * &lt;latitude&gt;-118.9813220168456 &lt;/latitude&gt; &lt;altitude&gt;1223
   * &lt;/altitude&gt; &lt;/Location&gt;
   */
  @XmlElement(name = "Location")
  protected Location location;
  /**
   * &lt;orientation&gt;
   * <p>
   * Describes rotation of a 3D model's coordinate system to position the object
   * in Google Earth. See diagram below. &lt;Orientation&gt; &lt;heading&gt;45.0
   * &lt;/heading&gt; &lt;tilt&gt;10.0 &lt;/tilt&gt; &lt;roll&gt;0.0
   * &lt;/roll&gt; &lt;/Orientation&gt;
   */
  @XmlElement(name = "Orientation")
  protected Orientation orientation;
  /**
   * &lt;scale&gt;
   * <p>
   * Note: The &lt;geomScale&gt; tag has been deprecated. Use &lt;scale&gt;
   * instead. Resizes the icon. Scales a model along the x, y, and z axes in the
   * model's coordinate space. &lt;Scale&gt; &lt;x&gt;2.5 &lt;/x&gt;
   * &lt;y&gt;2.5 &lt;/y&gt; &lt;z&gt;3.5 &lt;/z&gt; &lt;/Scale&gt;
   */
  @XmlElement(name = "Scale")
  protected Scale scale;
  /**
   * &lt;link&gt; (required). see &lt;link&gt;.
   * <p>
   * &lt;Link&gt; specifies the location of any of the following: If the file
   * specified in &lt;href&gt; is a local file, the &lt;viewFormat&gt; and
   * &lt;httpQuery&gt; elements are not used. KML files fetched by network links
   * Image files used in any Overlay (the &lt;Icon&gt; element specifies the
   * image in an Overlay; &lt;Icon&gt; has the same fields as &lt;Link&gt;)
   * Model files used in the &lt;Model&gt; element Specifies the URL of the
   * website containing this KML or KMZ file. Be sure to include the namespace
   * for this element in any KML file that uses it:
   * xmlns:atom="http://www.w3.org/2005/Atom" (see the sample that follows).
   * Specifies the file to load and optional refresh parameters. See
   * &lt;Link&gt;. The &lt;Link&gt; element replaces the &lt;Url&gt; element of
   * &lt;NetworkLink&gt; contained in earlier KML releases and adds
   * functionality for the &lt;Region&gt; element (introduced in KML 2.1). In
   * Google Earth releases 3.0 and earlier, the &lt;Link&gt; element is ignored.
   * The file is conditionally loaded and refreshed, depending on the refresh
   * parameters supplied here. Two different sets of refresh parameters can be
   * specified: one set is based on time ( &lt;refreshMode&gt; and
   * &lt;refreshInterval&gt;) and one is based on the current "camera" view (
   * &lt;viewRefreshMode&gt; and &lt;viewRefreshTime&gt;). In addition, Link
   * specifies whether to scale the bounding box parameters that are sent to the
   * server ( &lt;viewBoundScale&gt; and provides a set of optional viewing
   * parameters that can be sent to the server ( &lt;viewFormat&gt;) as well as
   * a set of optional parameters containing version and language information.
   * Tip: To display the top-level Folder or Document within a Network Link in
   * the List View, assign an ID to the Folder or Document. Without this ID,
   * only the child object names are displayed in the List View. When a file is
   * fetched, the URL that is sent to the server is composed of three pieces of
   * information: the href (Hypertext Reference) that specifies the file to
   * load. an arbitrary format string that is created from (a) parameters that
   * you specify in the &lt;viewFormat&gt; element or (b) bounding box
   * parameters (this is the default and is used if no &lt;viewFormat&gt;
   * element is included in the file). a second format string that is specified
   * in the &lt;httpQuery&gt; element. Syntax: &lt;pre&gt;
   * &lt;strong&gt;&lt;Link id="ID"&gt; &lt;/strong&gt; &lt;!-- specific to Link
   * --&gt; &lt;href&gt; &lt;em&gt;... &lt;/em&gt;&lt;/href&gt; &lt;!--
   * &lt;span&gt;string &lt;/span&gt; --&gt;
   * &lt;refreshMode&gt;onChange&lt;/refreshMode&gt; &lt;!-- refreshModeEnum:
   * onChange, onInterval, &lt;em&gt;or &lt;/em&gt; onExpire --&gt;
   * &lt;refreshInterval&gt;4&lt;/refreshInterval&gt; &lt;!-- float --&gt;
   * &lt;viewRefreshMode&gt;never&lt;/viewRefreshMode&gt; &lt;!--
   * viewRefreshModeEnum: never, onStop, onRequest, onRegion --&gt;
   * &lt;viewRefreshTime&gt;4&lt;/viewRefreshTime&gt; &lt;!-- float --&gt;
   * &lt;viewBoundScale&gt;1&lt;/viewBoundScale&gt; &lt;!-- float --&gt;
   * &lt;viewFormat&gt;BBOX=[bboxWest],[bboxSouth],[bboxEast],[bboxNorth]&lt;
   * &lt;strong&gt;/ &lt;/strong&gt;viewFormat&gt; &lt;!-- string --&gt;
   * &lt;httpQuery&gt;...&lt;/httpQuery&gt; &lt;!-- string --&gt;
   * &lt;strong&gt;&lt;/Link&gt; &lt;/strong&gt; </pre>
   * <p>
   * Extends:
   *
   * @see: &lt;Object&gt;
   *
   * Contained By:
   * @see: &lt;Model&gt;
   * @see: &lt;NetworkLink&gt;
   *
   * See Also: &lt;NetworkLinkControl&gt; &lt;Region&gt;
   *
   */
  @XmlElement(name = "Link")
  protected Link link;
  /**
   * &lt;resourcemap&gt;
   */
  @XmlElement(name = "ResourceMap")
  protected ResourceMap resourceMap;
  @XmlElement(name = "ModelSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> modelSimpleExtension;
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
  @XmlElement(name = "ModelObjectExtensionGroup")
  protected List<AbstractObject> modelObjectExtension;

  public Model() {
    super();
  }

  /**
   * @see altitudeMode
   *
   * @return possible object is null null null null null null null null null   {@code Object}
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
   * @param value allowed object is null null null null null null null null null   {@code Object}
     *     {@code net.opengis.kml.AltitudeMode}
   *     {@code de.micromata.opengis.kml.v_2_2_0.gx.AltitudeMode}
   *
   */
  public void setAltitudeMode(AltitudeMode value) {
    this.altitudeMode = value;
  }

  /**
   * @see location
   *
   * @return possible object is {@code Location}
   *
   */
  public Location getLocation() {
    return location;
  }

  /**
   * @see location
   *
   * @param value allowed object is {@code Location}
   *
   */
  public void setLocation(Location value) {
    this.location = value;
  }

  /**
   * @see orientation
   *
   * @return possible object is {@code Orientation}
   *
   */
  public Orientation getOrientation() {
    return orientation;
  }

  /**
   * @see orientation
   *
   * @param value allowed object is {@code Orientation}
   *
   */
  public void setOrientation(Orientation value) {
    this.orientation = value;
  }

  /**
   * @see scale
   *
   * @return possible object is {@code Scale}
   *
   */
  public Scale getScale() {
    return scale;
  }

  /**
   * @see scale
   *
   * @param value allowed object is {@code Scale}
   *
   */
  public void setScale(Scale value) {
    this.scale = value;
  }

  /**
   * @see link
   *
   * @return possible object is {@code Link}
   *
   */
  public Link getLink() {
    return link;
  }

  /**
   * @see link
   *
   * @param value allowed object is {@code Link}
   *
   */
  public void setLink(Link value) {
    this.link = value;
  }

  /**
   * @see resourceMap
   *
   * @return possible object is {@code ResourceMap}
   *
   */
  public ResourceMap getResourceMap() {
    return resourceMap;
  }

  /**
   * @see resourceMap
   *
   * @param value allowed object is {@code ResourceMap}
   *
   */
  public void setResourceMap(ResourceMap value) {
    this.resourceMap = value;
  }

  /**
   * @see modelSimpleExtension
   *
   */
  public List<Object> getModelSimpleExtension() {
    if (modelSimpleExtension == null) {
      modelSimpleExtension = new ArrayList<>();
    }
    return this.modelSimpleExtension;
  }

  /**
   * @see modelObjectExtension
   *
   */
  public List<AbstractObject> getModelObjectExtension() {
    if (modelObjectExtension == null) {
      modelObjectExtension = new ArrayList<>();
    }
    return this.modelObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((altitudeMode == null) ? 0 : altitudeMode.hashCode()));
    result = ((prime * result) + ((location == null) ? 0 : location.hashCode()));
    result = ((prime * result) + ((orientation == null) ? 0 : orientation.hashCode()));
    result = ((prime * result) + ((scale == null) ? 0 : scale.hashCode()));
    result = ((prime * result) + ((link == null) ? 0 : link.hashCode()));
    result = ((prime * result) + ((resourceMap == null) ? 0 : resourceMap.hashCode()));
    result = ((prime * result) + ((modelSimpleExtension == null) ? 0 : modelSimpleExtension.hashCode()));
    result = ((prime * result) + ((modelObjectExtension == null) ? 0 : modelObjectExtension.hashCode()));
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
    if ((obj instanceof Model) == false) {
      return false;
    }
    Model other = ((Model) obj);
    if (altitudeMode == null) {
      if (other.altitudeMode != null) {
        return false;
      }
    } else if (altitudeMode.equals(other.altitudeMode) == false) {
      return false;
    }
    if (location == null) {
      if (other.location != null) {
        return false;
      }
    } else if (location.equals(other.location) == false) {
      return false;
    }
    if (orientation == null) {
      if (other.orientation != null) {
        return false;
      }
    } else if (orientation.equals(other.orientation) == false) {
      return false;
    }
    if (scale == null) {
      if (other.scale != null) {
        return false;
      }
    } else if (scale.equals(other.scale) == false) {
      return false;
    }
    if (link == null) {
      if (other.link != null) {
        return false;
      }
    } else if (link.equals(other.link) == false) {
      return false;
    }
    if (resourceMap == null) {
      if (other.resourceMap != null) {
        return false;
      }
    } else if (resourceMap.equals(other.resourceMap) == false) {
      return false;
    }
    if (modelSimpleExtension == null) {
      if (other.modelSimpleExtension != null) {
        return false;
      }
    } else if (modelSimpleExtension.equals(other.modelSimpleExtension) == false) {
      return false;
    }
    if (modelObjectExtension == null) {
      if (other.modelObjectExtension != null) {
        return false;
      }
    } else if (modelObjectExtension.equals(other.modelObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code Location} and set it to location.
   * <p>
   * This method is a short version for: &lt;code&gt; Location location = new
   * Location(); this.setLocation(location); &lt;/code&gt;
   */
  public Location createAndSetLocation() {
    Location newValue = new Location();
    this.setLocation(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Orientation} and set it to orientation.
   * <p>
   * This method is a short version for: &lt;code&gt; Orientation orientation =
   * new Orientation(); this.setOrientation(orientation); &lt;/code&gt;
   */
  public Orientation createAndSetOrientation() {
    Orientation newValue = new Orientation();
    this.setOrientation(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Scale} and set it to scale.
   * <p>
   * This method is a short version for: &lt;code&gt; Scale scale = new Scale();
   * this.setScale(scale); &lt;/code&gt;
   */
  public Scale createAndSetScale() {
    Scale newValue = new Scale();
    this.setScale(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Link} and set it to link.
   * <p>
   * This method is a short version for: &lt;code&gt; Link link = new Link();
   * this.setLink(link); &lt;/code&gt;
   */
  public Link createAndSetLink() {
    Link newValue = new Link();
    this.setLink(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code ResourceMap} and set it to resourceMap.
   * <p>
   * This method is a short version for: &lt;code&gt; ResourceMap resourceMap =
   * new ResourceMap(); this.setResourceMap(resourceMap); &lt;/code&gt;
   */
  public ResourceMap createAndSetResourceMap() {
    ResourceMap newValue = new ResourceMap();
    this.setResourceMap(newValue);
    return newValue;
  }

  /**
   * @see modelSimpleExtension
   *
   * @param modelSimpleExtension
   */
  public void setModelSimpleExtension(final List<Object> modelSimpleExtension) {
    this.modelSimpleExtension = modelSimpleExtension;
  }

  /**
   * add a value to the modelSimpleExtension property collection
   *
   * @param modelSimpleExtension Objects of the following type are allowed in
   *                             the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Model addToModelSimpleExtension(final Object modelSimpleExtension) {
    this.getModelSimpleExtension().add(modelSimpleExtension);
    return this;
  }

  /**
   * @see modelObjectExtension
   *
   * @param modelObjectExtension
   */
  public void setModelObjectExtension(final List<AbstractObject> modelObjectExtension) {
    this.modelObjectExtension = modelObjectExtension;
  }

  /**
   * add a value to the modelObjectExtension property collection
   *
   * @param modelObjectExtension Objects of the following type are allowed in
   *                             the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Model addToModelObjectExtension(final AbstractObject modelObjectExtension) {
    this.getModelObjectExtension().add(modelObjectExtension);
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
  public Model addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public Model addToGeometrySimpleExtension(final Object geometrySimpleExtension) {
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
  public Model addToGeometryObjectExtension(final AbstractObject geometryObjectExtension) {
    super.getGeometryObjectExtension().add(geometryObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAltitudeMode(Object)
   *
   * @param altitudeMode required parameter
   */
  public Model withAltitudeMode(final AltitudeMode altitudeMode) {
    this.setAltitudeMode(altitudeMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLocation(Location)
   *
   * @param location required parameter
   */
  public Model withLocation(final Location location) {
    this.setLocation(location);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setOrientation(Orientation)
   *
   * @param orientation required parameter
   */
  public Model withOrientation(final Orientation orientation) {
    this.setOrientation(orientation);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setScale(Scale)
   *
   * @param scale required parameter
   */
  public Model withScale(final Scale scale) {
    this.setScale(scale);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLink(Link)
   *
   * @param link required parameter
   */
  public Model withLink(final Link link) {
    this.setLink(link);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setResourceMap(ResourceMap)
   *
   * @param resourceMap required parameter
   */
  public Model withResourceMap(final ResourceMap resourceMap) {
    this.setResourceMap(resourceMap);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setModelSimpleExtension(List &lt;Object&gt;)
   *
   * @param modelSimpleExtension required parameter
   */
  public Model withModelSimpleExtension(final List<Object> modelSimpleExtension) {
    this.setModelSimpleExtension(modelSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setModelObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param modelObjectExtension required parameter
   */
  public Model withModelObjectExtension(final List<AbstractObject> modelObjectExtension) {
    this.setModelObjectExtension(modelObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Model withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Model withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Model withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public Model withGeometrySimpleExtension(final List<Object> geometrySimpleExtension) {
    super.withGeometrySimpleExtension(geometrySimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Model withGeometryObjectExtension(final List<AbstractObject> geometryObjectExtension) {
    super.withGeometryObjectExtension(geometryObjectExtension);
    return this;
  }

  @Override
  public Model clone() {
    Model copy;
    copy = ((Model) super.clone());
    copy.location = ((location == null) ? null : ((Location) location.clone()));
    copy.orientation = ((orientation == null) ? null : ((Orientation) orientation.clone()));
    copy.scale = ((scale == null) ? null : ((Scale) scale.clone()));
    copy.link = ((link == null) ? null : ((Link) link.clone()));
    copy.resourceMap = ((resourceMap == null) ? null : ((ResourceMap) resourceMap.clone()));
    copy.modelSimpleExtension = new ArrayList<>((getModelSimpleExtension().size()));
    for (Object iter : modelSimpleExtension) {
      copy.modelSimpleExtension.add(iter);
    }
    copy.modelObjectExtension = new ArrayList<>((getModelObjectExtension().size()));
    for (AbstractObject iter : modelObjectExtension) {
      copy.modelObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
