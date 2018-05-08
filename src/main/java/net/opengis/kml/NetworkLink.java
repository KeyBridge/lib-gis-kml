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
import net.opengis.kml.atom.Author;
import net.opengis.kml.xal.AddressDetails;

/**
 * &lt;NetworkLink&gt;
 * <p>
 * References a KML file or KMZ archive on a local or remote network. Use the
 * &lt;Link&gt; element to specify the location of the KML file. Within that
 * element, you can define the refresh options for updating the file, based on
 * time and camera change. NetworkLinks can be used in combination with Regions
 * to handle very large datasets efficiently. Syntax: &lt;pre&gt;
 * &lt;strong&gt;&lt;NetworkLink id="ID"&gt; &lt;/strong&gt; &lt;!-- inherited
 * from &lt;em&gt;Feature &lt;/em&gt; element --&gt;&lt;name&gt; &lt;em&gt;...
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
 * 2.2 --&gt; &lt;/span&gt;
 * <p>
 * &lt;!-- specific to NetworkLink --&gt;
 * &lt;refreshVisibility&gt;0&lt;/refreshVisibility&gt; &lt;!-- boolean --&gt;
 * &lt;flyToView&gt;0&lt;/flyToView&gt; &lt;!-- boolean --&gt;
 * &lt;Link&gt;...&lt;/Link&gt; &lt;strong&gt;&lt;/NetworkLink&gt;
 * &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Feature&gt;
 *
 * Contained By:
 * @see: &lt;Container&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkLinkType", propOrder = {
  "refreshVisibility",
  "flyToView",
  "url",
  "link",
  "networkLinkSimpleExtension",
  "networkLinkObjectExtension"
})
@XmlRootElement(name = "NetworkLink", namespace = "http://www.opengis.net/kml/2.2")
public class NetworkLink
  extends Feature
  implements Cloneable {

  /**
   * &lt;refreshvisibility&gt;
   * <p>
   * Boolean value. A value of 0 leaves the visibility of features within the
   * control of the Google Earth user. Set the value to 1 to reset the
   * visibility of features each time the NetworkLink is refreshed. For example,
   * suppose a Placemark within the linked KML file has &lt;visibility&gt; set
   * to 1 and the NetworkLink has &lt;refreshVisibility&gt; set to 1. When the
   * file is first loaded into Google Earth, the user can clear the check box
   * next to the item to turn off display in the 3D viewer. However, when the
   * NetworkLink is refreshed, the Placemark will be made visible again, since
   * its original visibility state was TRUE.
   */
  @XmlElement(defaultValue = "0")
  @XmlJavaTypeAdapter(BooleanConverter.class)
  protected Boolean refreshVisibility;
  /**
   * &lt;flytoview&gt;
   * <p>
   * Boolean value. A value of 1 causes Google Earth to fly to the view of the
   * LookAt or Camera in the NetworkLinkControl (if it exists). If the
   * NetworkLinkControl does not contain an AbstractView element, Google Earth
   * flies to the LookAt or Camera element in the Feature child within the
   * &lt;kml&gt; element in the refreshed file. If the &lt;kml&gt; element does
   * not have a LookAt or Camera specified, the view is unchanged. For example,
   * Google Earth would fly to the &lt;LookAt&gt; view of the parent Document,
   * not the &lt;LookAt&gt; of the Placemarks contained within the Document.
   */
  @XmlElement(defaultValue = "0")
  @XmlJavaTypeAdapter(BooleanConverter.class)
  protected Boolean flyToView;
  /**
   * &lt;Url&gt;
   */
  @XmlElement(name = "Url")
  @Deprecated
  protected net.opengis.kml.Link url;
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
  protected net.opengis.kml.Link link;
  @XmlElement(name = "NetworkLinkSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> networkLinkSimpleExtension;
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
  @XmlElement(name = "NetworkLinkObjectExtensionGroup")
  protected List<AbstractObject> networkLinkObjectExtension;

  public NetworkLink() {
    super();
  }

  /**
   * @return possible object is {@link Boolean}
   *
   */
  public Boolean isRefreshVisibility() {
    return refreshVisibility;
  }

  /**
   * @see refreshVisibility
   *
   * @param value allowed object is {@link Boolean}
   *
   */
  public void setRefreshVisibility(Boolean value) {
    this.refreshVisibility = value;
  }

  /**
   * @return possible object is {@link Boolean}
   *
   */
  public Boolean isFlyToView() {
    return flyToView;
  }

  /**
   * @see flyToView
   *
   * @param value allowed object is {@link Boolean}
   *
   */
  public void setFlyToView(Boolean value) {
    this.flyToView = value;
  }

  /**
   * @see url
   *
   * @return possible object is {@link net.opengis.kml.Link}
   *
   */
  public net.opengis.kml.Link getUrl() {
    return url;
  }

  /**
   * @see url
   *
   * @param value allowed object is {@link net.opengis.kml.Link}
   *
   */
  public void setUrl(net.opengis.kml.Link value) {
    this.url = value;
  }

  /**
   * @see link
   *
   * @return possible object is {@link net.opengis.kml.Link}
   *
   */
  public net.opengis.kml.Link getLink() {
    return link;
  }

  /**
   * @see link
   *
   * @param value allowed object is {@link net.opengis.kml.Link}
   *
   */
  public void setLink(net.opengis.kml.Link value) {
    this.link = value;
  }

  /**
   * @see networkLinkSimpleExtension
   *
   */
  public List<Object> getNetworkLinkSimpleExtension() {
    if (networkLinkSimpleExtension == null) {
      networkLinkSimpleExtension = new ArrayList<>();
    }
    return this.networkLinkSimpleExtension;
  }

  /**
   * @see networkLinkObjectExtension
   *
   */
  public List<AbstractObject> getNetworkLinkObjectExtension() {
    if (networkLinkObjectExtension == null) {
      networkLinkObjectExtension = new ArrayList<>();
    }
    return this.networkLinkObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((refreshVisibility == null) ? 0 : refreshVisibility.hashCode()));
    result = ((prime * result) + ((flyToView == null) ? 0 : flyToView.hashCode()));
    result = ((prime * result) + ((url == null) ? 0 : url.hashCode()));
    result = ((prime * result) + ((link == null) ? 0 : link.hashCode()));
    result = ((prime * result) + ((networkLinkSimpleExtension == null) ? 0 : networkLinkSimpleExtension.hashCode()));
    result = ((prime * result) + ((networkLinkObjectExtension == null) ? 0 : networkLinkObjectExtension.hashCode()));
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
    if ((obj instanceof NetworkLink) == false) {
      return false;
    }
    NetworkLink other = ((NetworkLink) obj);
    if (refreshVisibility == null) {
      if (other.refreshVisibility != null) {
        return false;
      }
    } else if (refreshVisibility.equals(other.refreshVisibility) == false) {
      return false;
    }
    if (flyToView == null) {
      if (other.flyToView != null) {
        return false;
      }
    } else if (flyToView.equals(other.flyToView) == false) {
      return false;
    }
    if (url == null) {
      if (other.url != null) {
        return false;
      }
    } else if (url.equals(other.url) == false) {
      return false;
    }
    if (link == null) {
      if (other.link != null) {
        return false;
      }
    } else if (link.equals(other.link) == false) {
      return false;
    }
    if (networkLinkSimpleExtension == null) {
      if (other.networkLinkSimpleExtension != null) {
        return false;
      }
    } else if (networkLinkSimpleExtension.equals(other.networkLinkSimpleExtension) == false) {
      return false;
    }
    if (networkLinkObjectExtension == null) {
      if (other.networkLinkObjectExtension != null) {
        return false;
      }
    } else if (networkLinkObjectExtension.equals(other.networkLinkObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link net.opengis.kml.Link} and set it to url.
   * <p>
   * This method is a short version for: &lt;code&gt; Link link = new Link();
   * this.setUrl(link); &lt;/code&gt;
   */
  public net.opengis.kml.Link createAndSetUrl() {
    net.opengis.kml.Link newValue = new net.opengis.kml.Link();
    this.setUrl(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link net.opengis.kml.Link} and set it to link.
   * <p>
   * This method is a short version for: &lt;code&gt; Link link = new Link();
   * this.setLink(link); &lt;/code&gt;
   */
  public net.opengis.kml.Link createAndSetLink() {
    net.opengis.kml.Link newValue = new net.opengis.kml.Link();
    this.setLink(newValue);
    return newValue;
  }

  /**
   * @see networkLinkSimpleExtension
   *
   * @param networkLinkSimpleExtension
   */
  public void setNetworkLinkSimpleExtension(final List<Object> networkLinkSimpleExtension) {
    this.networkLinkSimpleExtension = networkLinkSimpleExtension;
  }

  /**
   * add a value to the networkLinkSimpleExtension property collection
   *
   * @param networkLinkSimpleExtension Objects of the following type are allowed
   *                                   in the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public NetworkLink addToNetworkLinkSimpleExtension(final Object networkLinkSimpleExtension) {
    this.getNetworkLinkSimpleExtension().add(networkLinkSimpleExtension);
    return this;
  }

  /**
   * @see networkLinkObjectExtension
   *
   * @param networkLinkObjectExtension
   */
  public void setNetworkLinkObjectExtension(final List<AbstractObject> networkLinkObjectExtension) {
    this.networkLinkObjectExtension = networkLinkObjectExtension;
  }

  /**
   * add a value to the networkLinkObjectExtension property collection
   *
   * @param networkLinkObjectExtension Objects of the following type are allowed
   *                                   in the list: {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public NetworkLink addToNetworkLinkObjectExtension(final AbstractObject networkLinkObjectExtension) {
    this.getNetworkLinkObjectExtension().add(networkLinkObjectExtension);
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
  public NetworkLink addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public NetworkLink addToStyleSelector(final StyleSelector styleSelector) {
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
  public NetworkLink addToFeatureSimpleExtension(final Object featureSimpleExtension) {
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
  public NetworkLink addToFeatureObjectExtension(final AbstractObject featureObjectExtension) {
    super.getFeatureObjectExtension().add(featureObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setRefreshVisibility(Boolean)
   *
   * @param refreshVisibility required parameter
   */
  public NetworkLink withRefreshVisibility(final Boolean refreshVisibility) {
    this.setRefreshVisibility(refreshVisibility);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setFlyToView(Boolean)
   *
   * @param flyToView required parameter
   */
  public NetworkLink withFlyToView(final Boolean flyToView) {
    this.setFlyToView(flyToView);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setUrl(Link)
   *
   * @param url required parameter
   */
  public NetworkLink withUrl(final net.opengis.kml.Link url) {
    this.setUrl(url);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLink(Link)
   *
   * @param link required parameter
   */
  public NetworkLink withLink(final net.opengis.kml.Link link) {
    this.setLink(link);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setNetworkLinkSimpleExtension(List &lt;Object&gt;)
   *
   * @param networkLinkSimpleExtension required parameter
   */
  public NetworkLink withNetworkLinkSimpleExtension(final List<Object> networkLinkSimpleExtension) {
    this.setNetworkLinkSimpleExtension(networkLinkSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setNetworkLinkObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param networkLinkObjectExtension required parameter
   */
  public NetworkLink withNetworkLinkObjectExtension(final List<AbstractObject> networkLinkObjectExtension) {
    this.setNetworkLinkObjectExtension(networkLinkObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withName(final String name) {
    super.withName(name);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withVisibility(final Boolean visibility) {
    super.withVisibility(visibility);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withOpen(final Boolean open) {
    super.withOpen(open);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withAtomAuthor(final Author atomAuthor) {
    super.withAtomAuthor(atomAuthor);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withAtomLink(final net.opengis.kml.atom.Link atomLink) {
    super.withAtomLink(atomLink);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withAddress(final String address) {
    super.withAddress(address);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withXalAddressDetails(final AddressDetails xalAddressDetails) {
    super.withXalAddressDetails(xalAddressDetails);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withPhoneNumber(final String phoneNumber) {
    super.withPhoneNumber(phoneNumber);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withSnippet(final Snippet snippet) {
    super.withSnippet(snippet);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withSnippetd(final String snippetd) {
    super.withSnippetd(snippetd);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withDescription(final String description) {
    super.withDescription(description);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withAbstractView(final AbstractView abstractView) {
    super.withAbstractView(abstractView);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withTimePrimitive(final TimePrimitive timePrimitive) {
    super.withTimePrimitive(timePrimitive);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withStyleUrl(final String styleUrl) {
    super.withStyleUrl(styleUrl);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withStyleSelector(final List<StyleSelector> styleSelector) {
    super.withStyleSelector(styleSelector);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withRegion(final Region region) {
    super.withRegion(region);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withMetadata(final Metadata metadata) {
    super.withMetadata(metadata);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withExtendedData(final ExtendedData extendedData) {
    super.withExtendedData(extendedData);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.withFeatureSimpleExtension(featureSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public NetworkLink withFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.withFeatureObjectExtension(featureObjectExtension);
    return this;
  }

  @Override
  public NetworkLink clone() {
    NetworkLink copy;
    copy = ((NetworkLink) super.clone());
    copy.url = ((url == null) ? null : ((net.opengis.kml.Link) url.clone()));
    copy.link = ((link == null) ? null : ((net.opengis.kml.Link) link.clone()));
    copy.networkLinkSimpleExtension = new ArrayList<>((getNetworkLinkSimpleExtension().size()));
    for (Object iter : networkLinkSimpleExtension) {
      copy.networkLinkSimpleExtension.add(iter);
    }
    copy.networkLinkObjectExtension = new ArrayList<>((getNetworkLinkObjectExtension().size()));
    for (AbstractObject iter : networkLinkObjectExtension) {
      copy.networkLinkObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
