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
 * &lt;link&gt; (required). see &lt;link&gt;.
 * <p>
 * &lt;Link&gt; specifies the location of any of the following: If the file
 * specified in &lt;href&gt; is a local file, the &lt;viewFormat&gt; and
 * &lt;httpQuery&gt; elements are not used. KML files fetched by network links
 * Image files used in any Overlay (the &lt;Icon&gt; element specifies the image
 * in an Overlay; &lt;Icon&gt; has the same fields as &lt;Link&gt;) Model files
 * used in the &lt;Model&gt; element Specifies the URL of the website containing
 * this KML or KMZ file. Be sure to include the namespace for this element in
 * any KML file that uses it: xmlns:atom="http://www.w3.org/2005/Atom" (see the
 * sample that follows). Specifies the file to load and optional refresh
 * parameters. See &lt;Link&gt;. The &lt;Link&gt; element replaces the
 * &lt;Url&gt; element of &lt;NetworkLink&gt; contained in earlier KML releases
 * and adds functionality for the &lt;Region&gt; element (introduced in KML
 * 2.1). In Google Earth releases 3.0 and earlier, the &lt;Link&gt; element is
 * ignored. The file is conditionally loaded and refreshed, depending on the
 * refresh parameters supplied here. Two different sets of refresh parameters
 * can be specified: one set is based on time ( &lt;refreshMode&gt; and
 * &lt;refreshInterval&gt;) and one is based on the current "camera" view (
 * &lt;viewRefreshMode&gt; and &lt;viewRefreshTime&gt;). In addition, Link
 * specifies whether to scale the bounding box parameters that are sent to the
 * server ( &lt;viewBoundScale&gt; and provides a set of optional viewing
 * parameters that can be sent to the server ( &lt;viewFormat&gt;) as well as a
 * set of optional parameters containing version and language information. Tip:
 * To display the top-level Folder or Document within a Network Link in the List
 * View, assign an ID to the Folder or Document. Without this ID, only the child
 * object names are displayed in the List View. When a file is fetched, the URL
 * that is sent to the server is composed of three pieces of information: the
 * href (Hypertext Reference) that specifies the file to load. an arbitrary
 * format string that is created from (a) parameters that you specify in the
 * &lt;viewFormat&gt; element or (b) bounding box parameters (this is the
 * default and is used if no &lt;viewFormat&gt; element is included in the
 * file). a second format string that is specified in the &lt;httpQuery&gt;
 * element. Syntax: &lt;pre&gt; &lt;strong&gt;&lt;Link id="ID"&gt;
 * &lt;/strong&gt; &lt;!-- specific to Link --&gt; &lt;href&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/href&gt; &lt;!-- &lt;span&gt;string &lt;/span&gt; --&gt;
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkType", propOrder = {
  "refreshMode",
  "refreshInterval",
  "viewRefreshMode",
  "viewRefreshTime",
  "viewBoundScale",
  "viewFormat",
  "httpQuery",
  "linkSimpleExtension",
  "linkObjectExtension"
})
@XmlRootElement(name = "Link", namespace = "http://www.opengis.net/kml/2.2")
public class Link
  extends BasicLink
  implements Cloneable {

  /**
   * RefreshMode
   * <p>
   * onChange, onInterval, onExpire See Also: See &lt;Link&gt;
   * <p>
   */
  @XmlElement(defaultValue = "onChange")
  protected RefreshMode refreshMode;
  /**
   * &lt;refreshinterval&gt;
   * <p>
   * Indicates to refresh the file every n seconds.
   */
  @XmlElement(defaultValue = "4.0")
  protected double refreshInterval;
  /**
   * ViewRefreshMode
   * <p>
   * never, onRequest, onStop, onRegion See Also: See &lt;Link&gt;
   * <p>
   */
  @XmlElement(defaultValue = "never")
  protected ViewRefreshMode viewRefreshMode;
  /**
   * &lt;viewrefreshtime&gt;
   * <p>
   * After camera movement stops, specifies the number of seconds to wait before
   * refreshing the view. (See &lt;viewRefreshMode&gt; and onStop above.)
   */
  @XmlElement(defaultValue = "4.0")
  protected double viewRefreshTime;
  /**
   * &lt;viewboundscale&gt;
   * <p>
   * Scales the BBOX parameters before sending them to the server. A value less
   * than 1 specifies to use less than the full view (screen). A value greater
   * than 1 specifies to fetch an area that extends beyond the edges of the
   * current view.
   */
  @XmlElement(defaultValue = "1.0")
  protected double viewBoundScale;
  /**
   * &lt;viewformat&gt;
   * <p>
   * BBOX=[bboxWest],[bboxSouth],[bboxEast],[bboxNorth] If you specify a
   * &lt;viewRefreshMode&gt; of onStop and do not include the &lt;viewFormat&gt;
   * tag in the file, the following information is automatically appended to the
   * query string: If you specify an empty &lt;viewFormat&gt; tag, no
   * information is appended to the query string. Specifies the format of the
   * query string that is appended to the Link's &lt;href&gt; before the file is
   * fetched.(If the &lt;href&gt; specifies a local file, this element is
   * ignored.) This information matches the Web Map Service (WMS) bounding box
   * specification. You can also specify a custom set of viewing parameters to
   * add to the query string. If you supply a format string, it is used instead
   * of the BBOX information. If you also want the BBOX information, you need to
   * add those parameters along with the custom parameters. You can use any of
   * the following parameters in your format string (and Google Earth will
   * substitute the appropriate current value at the time it creates the query
   * string): [lookatLon], [lookatLat] - longitude and latitude of the point
   * that &lt;LookAt&gt; is viewing [lookatRange], [lookatTilt], [lookatHeading]
   * - values used by the &lt;LookAt&gt; element (see descriptions of
   * &lt;range&gt;, &lt;tilt&gt;, and &lt;heading&gt; in &lt;LookAt&gt;)
   * [lookatTerrainLon], [lookatTerrainLat], [lookatTerrainAlt] - point on the
   * terrain in degrees/meters that &lt;LookAt&gt; is viewing [cameraLon],
   * [cameraLat], [cameraAlt] - degrees/meters of the eyepoint for the camera
   * [horizFov], [vertFov] - horizontal, vertical field of view for the camera
   * [horizPixels], [vertPixels] - size in pixels of the 3D viewer
   * [terrainEnabled] - indicates whether the 3D viewer is showing terrain
   */
  protected String viewFormat;
  /**
   * &lt;httpquery&gt;
   * <p>
   * Appends information to the query string, based on the parameters specified.
   * (Google Earth substitutes the appropriate current value at the time it
   * creates the query string.) The following parameters are supported:
   * [clientVersion] [kmlVersion] [clientName] [language]
   */
  protected String httpQuery;
  @XmlElement(name = "LinkSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> linkSimpleExtension;
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
  @XmlElement(name = "LinkObjectExtensionGroup")
  protected List<AbstractObject> linkObjectExtension;

  public Link() {
    super();
  }

  /**
   * @see refreshMode
   *
   * @return possible object is {@link RefreshMode}
   *
   */
  public RefreshMode getRefreshMode() {
    return refreshMode;
  }

  /**
   * @see refreshMode
   *
   * @param value allowed object is {@link RefreshMode}
   *
   */
  public void setRefreshMode(RefreshMode value) {
    this.refreshMode = value;
  }

  /**
   * @see refreshInterval
   *
   * @return possible object is {@link Double}
   *
   */
  public double getRefreshInterval() {
    return refreshInterval;
  }

  /**
   * @see refreshInterval
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setRefreshInterval(double value) {
    this.refreshInterval = value;
  }

  /**
   * @see viewRefreshMode
   *
   * @return possible object is {@link ViewRefreshMode}
   *
   */
  public ViewRefreshMode getViewRefreshMode() {
    return viewRefreshMode;
  }

  /**
   * @see viewRefreshMode
   *
   * @param value allowed object is {@link ViewRefreshMode}
   *
   */
  public void setViewRefreshMode(ViewRefreshMode value) {
    this.viewRefreshMode = value;
  }

  /**
   * @see viewRefreshTime
   *
   * @return possible object is {@link Double}
   *
   */
  public double getViewRefreshTime() {
    return viewRefreshTime;
  }

  /**
   * @see viewRefreshTime
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setViewRefreshTime(double value) {
    this.viewRefreshTime = value;
  }

  /**
   * @see viewBoundScale
   *
   * @return possible object is {@link Double}
   *
   */
  public double getViewBoundScale() {
    return viewBoundScale;
  }

  /**
   * @see viewBoundScale
   *
   * @param value allowed object is {@link Double}
   *
   */
  public void setViewBoundScale(double value) {
    this.viewBoundScale = value;
  }

  /**
   * @see viewFormat
   *
   * @return possible object is {@link String}
   *
   */
  public String getViewFormat() {
    return viewFormat;
  }

  /**
   * @see viewFormat
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setViewFormat(String value) {
    this.viewFormat = value;
  }

  /**
   * @see httpQuery
   *
   * @return possible object is {@link String}
   *
   */
  public String getHttpQuery() {
    return httpQuery;
  }

  /**
   * @see httpQuery
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setHttpQuery(String value) {
    this.httpQuery = value;
  }

  /**
   * @see linkSimpleExtension
   *
   */
  public List<Object> getLinkSimpleExtension() {
    if (linkSimpleExtension == null) {
      linkSimpleExtension = new ArrayList<>();
    }
    return this.linkSimpleExtension;
  }

  /**
   * @see linkObjectExtension
   *
   */
  public List<AbstractObject> getLinkObjectExtension() {
    if (linkObjectExtension == null) {
      linkObjectExtension = new ArrayList<>();
    }
    return this.linkObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    result = ((prime * result) + ((refreshMode == null) ? 0 : refreshMode.hashCode()));
    temp = Double.doubleToLongBits(refreshInterval);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((viewRefreshMode == null) ? 0 : viewRefreshMode.hashCode()));
    temp = Double.doubleToLongBits(viewRefreshTime);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    temp = Double.doubleToLongBits(viewBoundScale);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((viewFormat == null) ? 0 : viewFormat.hashCode()));
    result = ((prime * result) + ((httpQuery == null) ? 0 : httpQuery.hashCode()));
    result = ((prime * result) + ((linkSimpleExtension == null) ? 0 : linkSimpleExtension.hashCode()));
    result = ((prime * result) + ((linkObjectExtension == null) ? 0 : linkObjectExtension.hashCode()));
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
    if ((obj instanceof Link) == false) {
      return false;
    }
    Link other = ((Link) obj);
    if (refreshMode == null) {
      if (other.refreshMode != null) {
        return false;
      }
    } else if (refreshMode.equals(other.refreshMode) == false) {
      return false;
    }
    if (refreshInterval != other.refreshInterval) {
      return false;
    }
    if (viewRefreshMode == null) {
      if (other.viewRefreshMode != null) {
        return false;
      }
    } else if (viewRefreshMode.equals(other.viewRefreshMode) == false) {
      return false;
    }
    if (viewRefreshTime != other.viewRefreshTime) {
      return false;
    }
    if (viewBoundScale != other.viewBoundScale) {
      return false;
    }
    if (viewFormat == null) {
      if (other.viewFormat != null) {
        return false;
      }
    } else if (viewFormat.equals(other.viewFormat) == false) {
      return false;
    }
    if (httpQuery == null) {
      if (other.httpQuery != null) {
        return false;
      }
    } else if (httpQuery.equals(other.httpQuery) == false) {
      return false;
    }
    if (linkSimpleExtension == null) {
      if (other.linkSimpleExtension != null) {
        return false;
      }
    } else if (linkSimpleExtension.equals(other.linkSimpleExtension) == false) {
      return false;
    }
    if (linkObjectExtension == null) {
      if (other.linkObjectExtension != null) {
        return false;
      }
    } else if (linkObjectExtension.equals(other.linkObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see linkSimpleExtension
   *
   * @param linkSimpleExtension
   */
  public void setLinkSimpleExtension(final List<Object> linkSimpleExtension) {
    this.linkSimpleExtension = linkSimpleExtension;
  }

  /**
   * add a value to the linkSimpleExtension property collection
   *
   * @param linkSimpleExtension Objects of the following type are allowed in the
   *                            list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Link addToLinkSimpleExtension(final Object linkSimpleExtension) {
    this.getLinkSimpleExtension().add(linkSimpleExtension);
    return this;
  }

  /**
   * @see linkObjectExtension
   *
   * @param linkObjectExtension
   */
  public void setLinkObjectExtension(final List<AbstractObject> linkObjectExtension) {
    this.linkObjectExtension = linkObjectExtension;
  }

  /**
   * add a value to the linkObjectExtension property collection
   *
   * @param linkObjectExtension Objects of the following type are allowed in the
   *                            list: {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Link addToLinkObjectExtension(final AbstractObject linkObjectExtension) {
    this.getLinkObjectExtension().add(linkObjectExtension);
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
  public Link addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * @see basicLinkSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setBasicLinkSimpleExtension(final List<Object> basicLinkSimpleExtension) {
    super.setBasicLinkSimpleExtension(basicLinkSimpleExtension);
  }

  @Obvious
  @Override
  public Link addToBasicLinkSimpleExtension(final Object basicLinkSimpleExtension) {
    super.getBasicLinkSimpleExtension().add(basicLinkSimpleExtension);
    return this;
  }

  /**
   * @see basicLinkObjectExtension
   *
   */
  @Obvious
  @Override
  public void setBasicLinkObjectExtension(final List<AbstractObject> basicLinkObjectExtension) {
    super.setBasicLinkObjectExtension(basicLinkObjectExtension);
  }

  @Obvious
  @Override
  public Link addToBasicLinkObjectExtension(final AbstractObject basicLinkObjectExtension) {
    super.getBasicLinkObjectExtension().add(basicLinkObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setRefreshMode(RefreshMode)
   *
   * @param refreshMode required parameter
   */
  public Link withRefreshMode(final RefreshMode refreshMode) {
    this.setRefreshMode(refreshMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setRefreshInterval(double)
   *
   * @param refreshInterval required parameter
   */
  public Link withRefreshInterval(final double refreshInterval) {
    this.setRefreshInterval(refreshInterval);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setViewRefreshMode(ViewRefreshMode)
   *
   * @param viewRefreshMode required parameter
   */
  public Link withViewRefreshMode(final ViewRefreshMode viewRefreshMode) {
    this.setViewRefreshMode(viewRefreshMode);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setViewRefreshTime(double)
   *
   * @param viewRefreshTime required parameter
   */
  public Link withViewRefreshTime(final double viewRefreshTime) {
    this.setViewRefreshTime(viewRefreshTime);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setViewBoundScale(double)
   *
   * @param viewBoundScale required parameter
   */
  public Link withViewBoundScale(final double viewBoundScale) {
    this.setViewBoundScale(viewBoundScale);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setViewFormat(String)
   *
   * @param viewFormat required parameter
   */
  public Link withViewFormat(final String viewFormat) {
    this.setViewFormat(viewFormat);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setHttpQuery(String)
   *
   * @param httpQuery required parameter
   */
  public Link withHttpQuery(final String httpQuery) {
    this.setHttpQuery(httpQuery);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLinkSimpleExtension(List &lt;Object&gt;)
   *
   * @param linkSimpleExtension required parameter
   */
  public Link withLinkSimpleExtension(final List<Object> linkSimpleExtension) {
    this.setLinkSimpleExtension(linkSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLinkObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param linkObjectExtension required parameter
   */
  public Link withLinkObjectExtension(final List<AbstractObject> linkObjectExtension) {
    this.setLinkObjectExtension(linkObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Link withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Link withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Link withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public Link withHref(final String href) {
    super.withHref(href);
    return this;
  }

  @Obvious
  @Override
  public Link withBasicLinkSimpleExtension(final List<Object> basicLinkSimpleExtension) {
    super.withBasicLinkSimpleExtension(basicLinkSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Link withBasicLinkObjectExtension(final List<AbstractObject> basicLinkObjectExtension) {
    super.withBasicLinkObjectExtension(basicLinkObjectExtension);
    return this;
  }

  @Override
  public Link clone() {
    Link copy;
    copy = ((Link) super.clone());
    copy.linkSimpleExtension = new ArrayList<>((getLinkSimpleExtension().size()));
    for (Object iter : linkSimpleExtension) {
      copy.linkSimpleExtension.add(iter);
    }
    copy.linkObjectExtension = new ArrayList<>((getLinkObjectExtension().size()));
    for (AbstractObject iter : linkObjectExtension) {
      copy.linkObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
