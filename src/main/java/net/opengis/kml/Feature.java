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
import net.opengis.kml.atom.Link;
import net.opengis.kml.gx.Tour;
import net.opengis.kml.xal.*;

/**
 * &lt;Feature&gt; This is an abstract element and cannot be used directly in a
 * KML file. The following diagram shows how some of a Feature's elements appear
 * in Google Earth. Syntax:
 * <pre>&lt;!-- abstract element; do not create --&gt;
 *  &lt;strong&gt;&lt;!-- &lt;em&gt; Feature &lt;/em&gt; id="ID" --&gt; &lt;/strong&gt;                &lt;!-- Document,Folder,
 *                                              NetworkLink,Placemark,
 *                                              GroundOverlay,PhotoOverlay,ScreenOverlay --&gt;
 *   &lt;name&gt; &lt;em&gt;... &lt;/em&gt;&lt;/name&gt;                      &lt;!-- string --&gt;
 *   &lt;visibility&gt;1&lt;/visibility&gt;            &lt;!-- boolean --&gt;
 *   &lt;open&gt;0&lt;/open&gt;                        &lt;!-- boolean --&gt;
 *    &lt;span&gt;&lt;atom:author&gt;...&lt;atom:author&gt;         &lt;!-- xmlns:atom --&gt;
 *   &lt;atom:link&gt;...&lt;/atom:link&gt; &lt;/span&gt; &lt;span&gt;            &lt;!-- xmlns:atom --&gt; &lt;/span&gt;
 *   &lt;address&gt; &lt;em&gt;... &lt;/em&gt;&lt;/address&gt;                &lt;!-- string --&gt;
 *   &lt;xal:AddressDetails&gt;...&lt;/xal:AddressDetails&gt;  &lt;!-- xmlns:xal --&gt;
 *   &lt;phoneNumber&gt;...&lt;/phoneNumber&gt;        &lt;!-- string --&gt;
 *   &lt;Snippet maxLines="2"&gt; &lt;em&gt;... &lt;/em&gt;&lt;/Snippet&gt;   &lt;!-- string --&gt;
 *   &lt;description&gt; &lt;em&gt;... &lt;/em&gt;&lt;/description&gt;        &lt;!-- string --&gt;
 *    &lt;span&gt; &lt;em&gt;&lt;AbstractView&gt;...&lt;/AbstractView&gt; &lt;/em&gt;      &lt;!-- Camera  &lt;em&gt;or &lt;/em&gt; LookAt --&gt; &lt;/span&gt;
 *   &lt; &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;...&lt;/ &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;    &lt;!-- TimeStamp or TimeSpan --&gt;
 *   &lt;styleUrl&gt; &lt;em&gt;... &lt;/em&gt;&lt;/styleUrl&gt;              &lt;!-- anyURI --&gt;
 *   &lt; &lt;em&gt;StyleSelector&gt;...&lt;/StyleSelector&gt; &lt;/em&gt;
 *   &lt;Region&gt;...&lt;/Region&gt;
 *    &lt;span&gt;&lt;Metadata&gt;...&lt;/Metadata&gt;              &lt;!-- deprecated in KML 2.2 --&gt;
 *   &lt;ExtendedData&gt;...&lt;/ExtendedData&gt;      &lt;!-- new in KML 2.2 --&gt; &lt;br&gt; &lt;/span&gt;&lt;-- / &lt;em&gt;Feature &lt;/em&gt; --&gt;
 * </pre> Extends:
 *
 * @see: &lt;Object&gt;
 *
 * Extended By:
 * @see: &lt;Container&gt;
 * @see: &lt;NetworkLink&gt;
 * @see: &lt;Overlay&gt;
 * @see: &lt;Placemark&gt;
 * @see: &lt;gx:Tour&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractFeatureType", propOrder = {
  "name",
  "visibility",
  "open",
  "atomAuthor",
  "atomLink",
  "address",
  "xalAddressDetails",
  "phoneNumber",
  "snippet",
  "snippetd",
  "description",
  "abstractView",
  "timePrimitive",
  "styleUrl",
  "styleSelector",
  "region",
  "metadata",
  "extendedData",
  "featureSimpleExtension",
  "featureObjectExtension"
})
@XmlSeeAlso({
  Container.class,
  Document.class,
  Folder.class,
  GroundOverlay.class,
  NetworkLink.class,
  Overlay.class,
  PhotoOverlay.class,
  Placemark.class,
  ScreenOverlay.class,
  Tour.class
})
public abstract class Feature extends AbstractObject implements Cloneable {

  /**
   * &lt;name&gt; User-defined text displayed in the 3D viewer as the label for
   * the object (for example, for a Placemark, Folder, or NetworkLink).
   */
  protected String name;
  /**
   * &lt;visibility&gt; Boolean value. Specifies whether the feature is drawn in
   * the 3D viewer when it is initially loaded. In order for a feature to be
   * visible, the &lt;visibility&gt; tag of all its ancestors must also be set
   * to 1. In the Google Earth List View, each Feature has a checkbox that
   * allows the user to control visibility of the Feature.
   */
  @XmlElement(defaultValue = "1")
  @XmlJavaTypeAdapter(BooleanConverter.class)
  protected Boolean visibility;
  /**
   * &lt;open&gt; Boolean value. Specifies whether a Document or Folder appears
   * closed or open when first loaded into the Places panel. 0=collapsed (the
   * default), 1=expanded. See also &lt;ListStyle&gt;. This element applies only
   * to Document, Folder, and NetworkLink.
   */
  @XmlElement(defaultValue = "0")
  @XmlJavaTypeAdapter(BooleanConverter.class)
  protected Boolean open;
  /**
   * &lt;atom:author&gt; KML 2.2 supports new elements for including data about
   * the author and related website in your KML file. This information is
   * displayed in geo search results, both in Earth browsers such as Google
   * Earth, and in other applications such as Google Maps. The ascription
   * elements used in KML are as follows: The &lt;atom:author&gt; element is the
   * parent element for &lt;atom:name&gt;, which specifies the author of the KML
   * feature. These elements are defined in the Atom Syndication Format. The
   * complete specification is found at http://atompub.org. (see the sample that
   * follows). These elements are defined in the Atom Syndication Format. The
   * complete specification is found at http://atompub.org. (see the sample that
   * follows).
   */
  @XmlElement(name = "author", namespace = "http://www.w3.org/2005/Atom")
  protected Author atomAuthor;
  /**
   * &lt;link&gt; (required). see &lt;link&gt;. &lt;Link&gt; specifies the
   * location of any of the following: If the file specified in &lt;href&gt; is
   * a local file, the &lt;viewFormat&gt; and &lt;httpQuery&gt; elements are not
   * used. KML files fetched by network links Image files used in any Overlay
   * (the &lt;Icon&gt; element specifies the image in an Overlay; &lt;Icon&gt;
   * has the same fields as &lt;Link&gt;) Model files used in the &lt;Model&gt;
   * element Specifies the URL of the website containing this KML or KMZ file.
   * Be sure to include the namespace for this element in any KML file that uses
   * it: xmlns:atom="http://www.w3.org/2005/Atom" (see the sample that follows).
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
   * in the &lt;httpQuery&gt; element. Syntax: &lt;pre&gt; &lt;strong
   * &gt;&lt;Link id="ID"&gt; &lt;/strong&gt; &lt;!-- specific to Link --&gt;
   * &lt;href&gt; &lt;em&gt;... &lt;/em&gt;&lt;/href&gt; &lt;!-- &lt;span
   * &gt;string &lt;/span&gt; --&gt;
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
   * &lt;strong&gt;&lt;/Link&gt; &lt;/strong&gt; </pre> Extends:
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
  @XmlElement(name = "link", namespace = "http://www.w3.org/2005/Atom")
  protected Link atomLink;
  /**
   * &lt;address&gt; A string value representing an unstructured address written
   * as a standard street, city, state address, and/or as a postal code. You can
   * use the &lt;address&gt; tag to specify the location of a point instead of
   * using latitude and longitude coordinates. (However, if a &lt;Point&gt; is
   * provided, it takes precedence over the &lt;address&gt;.) To find out which
   * locales are supported for this tag in Google Earth, go to the Google Maps
   * Help.
   */
  protected String address;
  /**
   * &lt;xal:addressdetails&gt; A structured address, formatted as xAL, or
   * eXtensible Address Language, an international standard for address
   * formatting. &lt;xal:AddressDetails&gt; is used by KML for geocoding in
   * Google Maps only. For details, see the Google Maps API documentation.
   * Currently, Google Earth does not use this element; use &lt;address&gt;
   * instead. Be sure to include the namespace for this element in any KML file
   * that uses it: xmlns:xal="urn:oasis:names:tc:ciq:xsdschema:xAL:2.0" A
   * structured address, formatted as xAL, or eXtensible Address Language, an
   * international standard for address formatting. &lt;xal:AddressDetails&gt;
   * is used by KML for geocoding in Google Maps only. For details, see the
   * Google Maps API documentation. Currently, Google Earth does not use this
   * element; use &lt;address&gt; instead. Be sure to include the namespace for
   * this element in any KML file that uses it:
   * xmlns:xal="urn:oasis:names:tc:ciq:xsdschema:xAL:2.0"
   */
  @XmlElement(name = "AddressDetails", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
  protected AddressDetails xalAddressDetails;
  /**
   * &lt;phonenumber&gt;
   */
  protected String phoneNumber;
  /**
   * &lt;snippet maxlines="2"&gt; A short description of the feature. In Google
   * Earth, this description is displayed in the Places panel under the name of
   * the feature. If a Snippet is not supplied, the first two lines of the
   * &lt;description&gt; are used. In Google Earth, if a Placemark contains both
   * a description and a Snippet, the &lt;Snippet&gt; appears beneath the
   * Placemark in the Places panel, and the &lt;description&gt; appears in the
   * Placemark's description balloon. This tag does not support HTML markup.
   * &lt;Snippet&gt; has a maxLines attribute, an integer that specifies the
   * maximum number of lines to display.
   */
  @XmlElement(name = "Snippet")
  protected Snippet snippet;
  @XmlElement(name = "snippet")
  protected String snippetd;
  /**
   * &lt;description&gt; The supported content for the &lt;description&gt;
   * element changed from Google Earth 4.3 to 5.0. Specific information for each
   * version is listed out below, followed by information common to both.
   * User-supplied content that appears in the description balloon.
   * User-supplied content that appears in the description balloon. The
   * supported content for the &lt;description&gt; element changed from Google
   * Earth 4.3 to 5.0. Specific information for each version is listed out
   * below, followed by information common to both. Google Earth 5.0 Google
   * Earth 5.0 supports plain text content, as well as full HTML and JavaScript,
   * within description balloons. Contents of the description tag are rendered
   * by the WebKit open source web browser engine, and are displayed as they
   * would be in any WebKit-based browser. General restrictions Links to local
   * files are generally not allowed. This prevents malicious code from damaging
   * your system or accessing your data. Should you wish to allow access to your
   * local filesystem, select Preferences&gt; Allow placemark balloons to access
   * local files and personal data. Links to image files on the local filesystem
   * are always allowed, if contained within an &lt;img&gt; tag. Content that
   * has been compressed into a KMZ file can be accessed, even if on the local
   * filesystem. Cookies are completely disabled, including cookies set or read
   * by content contained within a iFrame. There are no exceptions to this rule.
   * Doctype declarations are ignored.
   */
  protected String description;
  /**
   * &lt;abstractview&gt; Defines a viewpoint associated with any element
   * derived from Feature. See &lt;Camera&gt; and &lt;LookAt&gt;. This is an
   * abstract element and cannot be used directly in a KML file. This element is
   * extended by the &lt;Camera&gt; and &lt;LookAt&gt; elements. Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt;
   *  &lt;strong&gt;&lt;!-- &lt;em&gt; AbstractView &lt;/em&gt; --&gt; &lt;/strong&gt;                   &lt;!-- Camera, LookAt --&gt;
   *   &lt;!-- extends  &lt;span class="style1"&gt;Object &lt;/span&gt; --&gt;
   *    &lt;em&gt;&lt;TimePrimitive&gt;...&lt;/TimePrimitive&gt; &lt;/em&gt;                        &lt;!-- gx:TimeSpan or gx:TimeStamp --&gt;
   *  &lt;strong&gt;&lt;-- / &lt;em&gt;AbstractView &lt;/em&gt; --&gt; &lt;/strong&gt;
   * </pre> Extends:
   *
   * @see: &lt;Object&gt;
   *
   * Extended By:
   * @see: &lt;Camera&gt;
   * @see: &lt;LookAt&gt;
   *
   */
  @XmlElementRef(name = "AbstractViewGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected AbstractView abstractView;
  /**
   * &lt;TimePrimitive&gt; Associates this Feature with a period of time (
   * &lt;TimeSpan&gt;) or a point in time ( &lt;TimeStamp&gt;). This is an
   * abstract element and cannot be used directly in a KML file. This element is
   * extended by the &lt;TimeSpan&gt; and &lt;TimeStamp&gt; elements. Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt;
   *  &lt;strong&gt;&lt;!-- TimePrimitive id="ID" --&gt;            &lt;!-- TimeSpan,TimeStamp --&gt;
   *   &lt;/strong&gt; &lt;!-- extends Object --&gt; &lt;strong&gt;
   * &lt;!-- /TimePrimitive --&gt; &lt;/strong&gt; </pre> Extends:
   *
   * @see: &lt;Object&gt;
   *
   * Extended By:
   * @see: &lt;TimeSpan&gt;
   * @see: &lt;TimeStamp&gt;
   *
   */
  @XmlElementRef(name = "AbstractTimePrimitiveGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected TimePrimitive timePrimitive;
  /**
   * &lt;styleurl&gt; URL of a &lt;Style&gt; or &lt;StyleMap&gt; defined in a
   * Document. If the style is in the same file, use a # reference. If the style
   * is defined in an external file, use a full URL along with # referencing.
   * Examples are &lt;styleUrl&gt;#myIconStyleID &lt;/styleUrl&gt;
   * &lt;styleUrl&gt;http://someserver.com/somestylefile.xml#restaurant
   * &lt;/styleUrl&gt; &lt;styleUrl&gt;eateries.kml#my-lunch-spot
   * &lt;/styleUrl&gt;
   */
  @XmlSchemaType(name = "anyURI")
  protected String styleUrl;
  /**
   * &lt;StyleSelector&gt; One or more Styles and StyleMaps can be defined to
   * customize the appearance of any element derived from Feature or of the
   * Geometry in a Placemark. (See &lt;BalloonStyle&gt;, &lt;ListStyle&gt;,
   * &lt;StyleSelector&gt;, and the styles derived from &lt;ColorStyle&gt;.) A
   * style defined within a Feature is called an "inline style" and applies only
   * to the Feature that contains it. A style defined as the child of a
   * &lt;Document&gt; is called a "shared style." A shared style must have an id
   * defined for it. This id is referenced by one or more Features within the
   * &lt;Document&gt;. In cases where a style element is defined both in a
   * shared style and in an inline style for a Feature—that is, a Folder,
   * GroundOverlay, NetworkLink, Placemark, or ScreenOverlay—the value for the
   * Feature's inline style takes precedence over the value for the shared
   * style. Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt;
   *  &lt;strong&gt;&lt;!--  &lt;em&gt;StyleSelector &lt;/em&gt; id="ID" --&gt;                &lt;/strong&gt;  &lt;!-- Style,StyleMap --&gt; &lt;strong&gt;
   * &lt;!-- / &lt;em&gt;StyleSelector &lt;/em&gt; --&gt; &lt;/strong&gt;
   * </pre> Extends:
   *
   * @see: &lt;Object&gt;
   *
   * Extended By:
   * @see: &lt;Style&gt;
   * @see: &lt;StyleMap&gt;
   *
   */
  @XmlElementRef(name = "AbstractStyleSelectorGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected List<StyleSelector> styleSelector;
  /**
   * &lt;Region&gt; A region contains a bounding box ( &lt;LatLonAltBox&gt;)
   * that describes an area of interest defined by geographic coordinates and
   * altitudes. In addition, a Region contains an LOD (level of detail) extent (
   * &lt;Lod&gt;) that defines a validity range of the associated Region in
   * terms of projected screen size. A Region is said to be "active" when the
   * bounding box is within the user's view and the LOD requirements are met.
   * Objects associated with a Region are drawn only when the Region is active.
   * When the &lt;viewRefreshMode&gt; is onRegion, the Link or Icon is loaded
   * only when the Region is active. See the "Topics in KML" page on Regions for
   * more details. In a Container or NetworkLink hierarchy, this calculation
   * uses the Region that is the closest ancestor in the hierarchy. Features and
   * geometry associated with a Region are drawn only when the Region is active.
   * See &lt;Region&gt;. Syntax: &lt;pre&gt; &lt;strong&gt;&lt;Region
   * id="ID"&gt; &lt;/strong&gt; &lt;LatLonAltBox&gt;
   * &lt;north&gt;&lt;/north&gt; &lt;!-- required; kml:angle90 --&gt;
   * &lt;south&gt;&lt;/south&gt; &lt;!-- required; kml:angle90 --&gt;
   * &lt;east&gt;&lt;/east&gt; &lt;!-- required; kml:angle180 --&gt;
   * &lt;west&gt;&lt;/west&gt; &lt;!-- required; kml:angle180 --&gt;
   * &lt;minAltitude&gt;0&lt;/minAltitude&gt; &lt;!-- float --&gt;
   * &lt;maxAltitude&gt;0&lt;/maxAltitude&gt; &lt;!-- float --&gt;
   * &lt;altitudeMode&gt;clampToGround&lt;/altitudeMode&gt; &lt;!--
   * kml:altitudeModeEnum: clampToGround, relativeToGround, or absolute --&gt;
   * &lt;!-- or, substitute gx:altitudeMode: clampToSeaFloor, relativeToSeaFloor
   * --&gt; &lt;/LatLonAltBox&gt; &lt;Lod&gt;
   * &lt;minLodPixels&gt;0&lt;/minLodPixels&gt; &lt;!-- float --&gt;
   * &lt;maxLodPixels&gt;-1&lt;/maxLodPixels&gt; &lt;!-- float --&gt;
   * &lt;minFadeExtent&gt;0&lt;/minFadeExtent&gt; &lt;!-- float --&gt;
   * &lt;maxFadeExtent&gt;0&lt;/maxFadeExtent&gt; &lt;!-- float --&gt;
   * &lt;/Lod&gt; &lt;strong&gt;&lt;/Region&gt; &lt;/strong&gt; </pre> &lt;p
   * &gt; Extends:
   *
   * @see: &lt;Object&gt;
   *
   * Contained By:
   * @see: &lt;Feature&gt;
   *
   */
  @XmlElement(name = "Region")
  protected Region region;
  /**
   * &lt;metadata&gt; (deprecated in kml 2.2; use &lt;extendeddata&gt; instead)
   */
  @XmlElement(name = "Metadata")
  protected Metadata metadata;
  /**
   * &lt;extendeddata&gt; Adding untyped data/value pairs using the &lt;Data
   * &gt; element (basic) Declaring new typed fields using the &lt;Schema&gt;
   * element and then instancing them using the &lt;SchemaData&gt; element
   * (advanced) Referring to XML elements defined in other namespaces by
   * referencing the external namespace within the KML file (basic) Allows you
   * to add custom data to a KML file. This data can be (1) data that references
   * an external XML schema, (2) untyped data/value pairs, or (3) typed data. A
   * given KML Feature can contain a combination of these types of custom data.
   * For more information, see Adding Custom Data in "Topics in KML." The
   * ExtendedData element offers three techniques for adding custom data to a
   * KML Feature (NetworkLink, Placemark, GroundOverlay, PhotoOverlay,
   * ScreenOverlay, Document, Folder). These techniques are These techniques can
   * be combined within a single KML file or Feature for different pieces of
   * data. Syntax:
   * &lt;pre&gt;&lt;ExtendedData&gt;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   * &lt;br&gt; &lt;Data name="string"&gt; &lt;br&gt;&nbsp;
   * &lt;displayName&gt;...&lt;/displayName&gt;&nbsp;&nbsp;&nbsp; &lt;!-- string
   * --&gt; &lt;br&gt; &nbsp;&nbsp;
   * &lt;value&gt;...&lt;/value&gt;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   * &lt;!-- string --&gt; &lt;br&gt; &lt;/Data&gt; &lt;SchemaData schemaUrl="
   * &lt;em&gt;anyURI &lt;/em&gt;"&gt; &lt;br&gt; &lt;SimpleData name=""&gt; ...
   * &lt;/SimpleData&gt;&nbsp;&nbsp; &lt;!-- string --&gt; &lt;br&gt;
   * &lt;/SchemaData&gt;
   * &lt;namespace_prefix:other&gt;...&lt;/namespace_prefix:other&gt;
   * &lt;/ExtendedData&gt; </pre> Contained By:
   *
   * @see: &lt;Feature&gt;
   *
   * See Also: Schema
   *
   */
  @XmlElement(name = "ExtendedData")
  protected ExtendedData extendedData;
  /**
   * &lt;Object&gt; This is an abstract base class and cannot be used directly
   * in a KML file. It provides the id attribute, which allows unique
   * identification of a KML element, and the targetId attribute, which is used
   * to reference objects that have already been loaded into Google Earth. The
   * id attribute must be assigned if the &lt;Update&gt; mechanism is to be
   * used. Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt; &lt;strong&gt;
   * &lt;!--  &lt;em&gt;Object &lt;/em&gt; id="ID" targetId="NCName" --&gt;
   * &lt;!-- / &lt;em&gt;Object &lt;/em&gt;&gt; --&gt; &lt;/strong&gt; </pre>
   * <p>
   */
  @XmlElement(name = "AbstractFeatureSimpleExtensionGroup")
  protected List<Object> featureSimpleExtension;
  /**
   * &lt;Object&gt; This is an abstract base class and cannot be used directly
   * in a KML file. It provides the id attribute, which allows unique
   * identification of a KML element, and the targetId attribute, which is used
   * to reference objects that have already been loaded into Google Earth. The
   * id attribute must be assigned if the &lt;Update&gt; mechanism is to be
   * used. Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt; &lt;strong&gt;
   * &lt;!--  &lt;em&gt;Object &lt;/em&gt; id="ID" targetId="NCName" --&gt;
   * &lt;!-- / &lt;em&gt;Object &lt;/em&gt;&gt; --&gt; &lt;/strong&gt; </pre>
   * <p>
   */
  @XmlElement(name = "AbstractFeatureObjectExtensionGroup")
  protected List<AbstractObject> featureObjectExtension;

  public Feature() {
    super();
  }

  /**
   * @see name
   *
   * @return possible object is {@link String}
   *
   */
  public String getName() {
    return name;
  }

  /**
   * @see name
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setName(String value) {
    this.name = value;
  }

  /**
   * @return possible object is {@link Boolean}
   *
   */
  public Boolean isVisibility() {
    return visibility;
  }

  /**
   * @see visibility
   *
   * @param value allowed object is {@link Boolean}
   *
   */
  public void setVisibility(Boolean value) {
    this.visibility = value;
  }

  /**
   * @return possible object is {@link Boolean}
   *
   */
  public Boolean isOpen() {
    return open;
  }

  /**
   * @see open
   *
   * @param value allowed object is {@link Boolean}
   *
   */
  public void setOpen(Boolean value) {
    this.open = value;
  }

  /**
   * @see atomAuthor
   *
   * @return possible object is {@link Author}
   *
   */
  public Author getAtomAuthor() {
    return atomAuthor;
  }

  /**
   * @see atomAuthor
   *
   * @param value allowed object is {@link Author}
   *
   */
  public void setAtomAuthor(Author value) {
    this.atomAuthor = value;
  }

  /**
   * @see atomLink
   *
   * @return possible object is {@link Link}
   *
   */
  public Link getAtomLink() {
    return atomLink;
  }

  /**
   * @see atomLink
   *
   * @param value allowed object is {@link Link}
   *
   */
  public void setAtomLink(Link value) {
    this.atomLink = value;
  }

  /**
   * @see address
   *
   * @return possible object is {@link String}
   *
   */
  public String getAddress() {
    return address;
  }

  /**
   * @see address
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setAddress(String value) {
    this.address = value;
  }

  /**
   * @see xalAddressDetails
   *
   * @return possible object is {@link AddressDetails}
   *
   */
  public AddressDetails getXalAddressDetails() {
    return xalAddressDetails;
  }

  /**
   * @see xalAddressDetails
   *
   * @param value allowed object is {@link AddressDetails}
   *
   */
  public void setXalAddressDetails(AddressDetails value) {
    this.xalAddressDetails = value;
  }

  /**
   * @see phoneNumber
   *
   * @return possible object is {@link String}
   *
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @see phoneNumber
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setPhoneNumber(String value) {
    this.phoneNumber = value;
  }

  /**
   * @see snippet
   *
   * @return possible object is {@link Snippet}
   *
   */
  public Snippet getSnippet() {
    return snippet;
  }

  /**
   * @see snippet
   *
   * @param value allowed object is {@link Snippet}
   *
   */
  public void setSnippet(Snippet value) {
    this.snippet = value;
  }

  /**
   * @see snippetd
   *
   * @return possible object is {@link String}
   *
   */
  public String getSnippetd() {
    return snippetd;
  }

  /**
   * @see snippetd
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setSnippetd(String value) {
    this.snippetd = value;
  }

  /**
   * @see description
   *
   * @return possible object is {@link String}
   *
   */
  public String getDescription() {
    return description;
  }

  /**
   * @see description
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setDescription(String value) {
    this.description = value;
  }

  /**
   * @see abstractView
   *
   * @return possible object is {@link AbstractView}
   *     {@link LookAt}
   *     {@link Camera}
   *
   */
  public AbstractView getAbstractView() {
    return abstractView;
  }

  /**
   * @see abstractView
   *
   * @param value allowed object is {@link AbstractView}
   *     {@link LookAt}
   *     {@link Camera}
   *
   */
  public void setAbstractView(AbstractView value) {
    this.abstractView = ((AbstractView) value);
  }

  /**
   * @see timePrimitive
   *
   * @return possible object is {@link TimeSpan}
   *     {@link TimeStamp}
   *     {@link TimePrimitive}
   *
   */
  public TimePrimitive getTimePrimitive() {
    return timePrimitive;
  }

  /**
   * @see timePrimitive
   *
   * @param value allowed object is null null null null null null null null null
   *              null null null null null null null null null null null   {@link TimeSpan}
     *     {@link TimeStamp}
   *     {@link TimePrimitive}
   *
   */
  public void setTimePrimitive(TimePrimitive value) {
    this.timePrimitive = ((TimePrimitive) value);
  }

  /**
   * @see styleUrl
   *
   * @return possible object is {@link String}
   *
   */
  public String getStyleUrl() {
    return styleUrl;
  }

  /**
   * @see styleUrl
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setStyleUrl(String value) {
    this.styleUrl = value;
  }

  /**
   * @see styleSelector
   *
   */
  public List<StyleSelector> getStyleSelector() {
    if (styleSelector == null) {
      styleSelector = new ArrayList<>();
    }
    return this.styleSelector;
  }

  /**
   * @see region
   *
   * @return possible object is {@link Region}
   *
   */
  public Region getRegion() {
    return region;
  }

  /**
   * @see region
   *
   * @param value allowed object is {@link Region}
   *
   */
  public void setRegion(Region value) {
    this.region = value;
  }

  /**
   * @see metadata
   *
   * @return possible object is {@link Metadata}
   *
   */
  public Metadata getMetadata() {
    return metadata;
  }

  /**
   * @see metadata
   *
   * @param value allowed object is {@link Metadata}
   *
   */
  public void setMetadata(Metadata value) {
    this.metadata = value;
  }

  /**
   * @see extendedData
   *
   * @return possible object is {@link ExtendedData}
   *
   */
  public ExtendedData getExtendedData() {
    return extendedData;
  }

  /**
   * @see extendedData
   *
   * @param value allowed object is {@link ExtendedData}
   *
   */
  public void setExtendedData(ExtendedData value) {
    this.extendedData = value;
  }

  /**
   * @see featureSimpleExtension
   *
   */
  public List<Object> getFeatureSimpleExtension() {
    if (featureSimpleExtension == null) {
      featureSimpleExtension = new ArrayList<>();
    }
    return this.featureSimpleExtension;
  }

  /**
   * @see featureObjectExtension
   *
   */
  public List<AbstractObject> getFeatureObjectExtension() {
    if (featureObjectExtension == null) {
      featureObjectExtension = new ArrayList<>();
    }
    return this.featureObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((name == null) ? 0 : name.hashCode()));
    result = ((prime * result) + ((visibility == null) ? 0 : visibility.hashCode()));
    result = ((prime * result) + ((open == null) ? 0 : open.hashCode()));
    result = ((prime * result) + ((atomAuthor == null) ? 0 : atomAuthor.hashCode()));
    result = ((prime * result) + ((atomLink == null) ? 0 : atomLink.hashCode()));
    result = ((prime * result) + ((address == null) ? 0 : address.hashCode()));
    result = ((prime * result) + ((xalAddressDetails == null) ? 0 : xalAddressDetails.hashCode()));
    result = ((prime * result) + ((phoneNumber == null) ? 0 : phoneNumber.hashCode()));
    result = ((prime * result) + ((snippet == null) ? 0 : snippet.hashCode()));
    result = ((prime * result) + ((snippetd == null) ? 0 : snippetd.hashCode()));
    result = ((prime * result) + ((description == null) ? 0 : description.hashCode()));
    result = ((prime * result) + ((abstractView == null) ? 0 : abstractView.hashCode()));
    result = ((prime * result) + ((timePrimitive == null) ? 0 : timePrimitive.hashCode()));
    result = ((prime * result) + ((styleUrl == null) ? 0 : styleUrl.hashCode()));
    result = ((prime * result) + ((styleSelector == null) ? 0 : styleSelector.hashCode()));
    result = ((prime * result) + ((region == null) ? 0 : region.hashCode()));
    result = ((prime * result) + ((metadata == null) ? 0 : metadata.hashCode()));
    result = ((prime * result) + ((extendedData == null) ? 0 : extendedData.hashCode()));
    result = ((prime * result) + ((featureSimpleExtension == null) ? 0 : featureSimpleExtension.hashCode()));
    result = ((prime * result) + ((featureObjectExtension == null) ? 0 : featureObjectExtension.hashCode()));
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
    if ((obj instanceof Feature) == false) {
      return false;
    }
    Feature other = ((Feature) obj);
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (name.equals(other.name) == false) {
      return false;
    }
    if (visibility == null) {
      if (other.visibility != null) {
        return false;
      }
    } else if (visibility.equals(other.visibility) == false) {
      return false;
    }
    if (open == null) {
      if (other.open != null) {
        return false;
      }
    } else if (open.equals(other.open) == false) {
      return false;
    }
    if (atomAuthor == null) {
      if (other.atomAuthor != null) {
        return false;
      }
    } else if (atomAuthor.equals(other.atomAuthor) == false) {
      return false;
    }
    if (atomLink == null) {
      if (other.atomLink != null) {
        return false;
      }
    } else if (atomLink.equals(other.atomLink) == false) {
      return false;
    }
    if (address == null) {
      if (other.address != null) {
        return false;
      }
    } else if (address.equals(other.address) == false) {
      return false;
    }
    if (xalAddressDetails == null) {
      if (other.xalAddressDetails != null) {
        return false;
      }
    } else if (xalAddressDetails.equals(other.xalAddressDetails) == false) {
      return false;
    }
    if (phoneNumber == null) {
      if (other.phoneNumber != null) {
        return false;
      }
    } else if (phoneNumber.equals(other.phoneNumber) == false) {
      return false;
    }
    if (snippet == null) {
      if (other.snippet != null) {
        return false;
      }
    } else if (snippet.equals(other.snippet) == false) {
      return false;
    }
    if (snippetd == null) {
      if (other.snippetd != null) {
        return false;
      }
    } else if (snippetd.equals(other.snippetd) == false) {
      return false;
    }
    if (description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (description.equals(other.description) == false) {
      return false;
    }
    if (abstractView == null) {
      if (other.abstractView != null) {
        return false;
      }
    } else if (abstractView.equals(other.abstractView) == false) {
      return false;
    }
    if (timePrimitive == null) {
      if (other.timePrimitive != null) {
        return false;
      }
    } else if (timePrimitive.equals(other.timePrimitive) == false) {
      return false;
    }
    if (styleUrl == null) {
      if (other.styleUrl != null) {
        return false;
      }
    } else if (styleUrl.equals(other.styleUrl) == false) {
      return false;
    }
    if (styleSelector == null) {
      if (other.styleSelector != null) {
        return false;
      }
    } else if (styleSelector.equals(other.styleSelector) == false) {
      return false;
    }
    if (region == null) {
      if (other.region != null) {
        return false;
      }
    } else if (region.equals(other.region) == false) {
      return false;
    }
    if (metadata == null) {
      if (other.metadata != null) {
        return false;
      }
    } else if (metadata.equals(other.metadata) == false) {
      return false;
    }
    if (extendedData == null) {
      if (other.extendedData != null) {
        return false;
      }
    } else if (extendedData.equals(other.extendedData) == false) {
      return false;
    }
    if (featureSimpleExtension == null) {
      if (other.featureSimpleExtension != null) {
        return false;
      }
    } else if (featureSimpleExtension.equals(other.featureSimpleExtension) == false) {
      return false;
    }
    if (featureObjectExtension == null) {
      if (other.featureObjectExtension != null) {
        return false;
      }
    } else if (featureObjectExtension.equals(other.featureObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link Author} and set it to atomAuthor. &lt;p
   * &gt; This method is a short version for: &lt;code&gt; Author author = new
   * Author(); this.setAtomAuthor(author); &lt;/code&gt;
   */
  public Author createAndSetAtomAuthor() {
    Author newValue = new Author();
    this.setAtomAuthor(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Link} and set it to atomLink. This method
   * is a short version for: &lt;code&gt; Link link = new Link();
   * this.setAtomLink(link); &lt;/code&gt;
   *
   * @param href required parameter
   */
  public Link createAndSetAtomLink(final String href) {
    Link newValue = new Link(href);
    this.setAtomLink(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link AddressDetails} and set it to
   * xalAddressDetails. This method is a short version for: &lt;code&gt;
   * AddressDetails addressDetails = new AddressDetails();
   * this.setXalAddressDetails(addressDetails); &lt;/code&gt;
   *
   * @param xalAddress         required parameter
   * @param addressLines       required parameter
   * @param country            required parameter
   * @param locality           required parameter
   * @param administrativeArea required parameter
   * @param thoroughfare       required parameter
   */
  public AddressDetails createAndSetXalAddressDetails(final AddressDetails.Address xalAddress, final AddressLines addressLines, final AddressDetails.Country country, final AdministrativeArea administrativeArea, final Locality locality, final Thoroughfare thoroughfare) {
    AddressDetails newValue = new AddressDetails(xalAddress, addressLines, country, administrativeArea, locality, thoroughfare);
    this.setXalAddressDetails(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Snippet} and set it to snippet. This
   * method is a short version for: &lt;code&gt; Snippet snippet = new
   * Snippet(); this.setSnippet(snippet); &lt;/code&gt;
   */
  public Snippet createAndSetSnippet() {
    Snippet newValue = new Snippet();
    this.setSnippet(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link LookAt} and set it to abstractView. &lt;p
   * &gt; This method is a short version for: &lt;code&gt; LookAt lookAt = new
   * LookAt(); this.setAbstractView(lookAt); &lt;/code&gt;
   */
  public LookAt createAndSetLookAt() {
    LookAt newValue = new LookAt();
    this.setAbstractView(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Camera} and set it to abstractView. &lt;p
   * &gt; This method is a short version for: &lt;code&gt; Camera camera = new
   * Camera(); this.setAbstractView(camera); &lt;/code&gt;
   */
  public Camera createAndSetCamera() {
    Camera newValue = new Camera();
    this.setAbstractView(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link TimeSpan} and set it to timePrimitive.
   * This method is a short version for: &lt;code&gt; TimeSpan timeSpan = new
   * TimeSpan(); this.setTimePrimitive(timeSpan); &lt;/code&gt;
   */
  public TimeSpan createAndSetTimeSpan() {
    TimeSpan newValue = new TimeSpan();
    this.setTimePrimitive(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link TimeStamp} and set it to timePrimitive.
   * This method is a short version for: &lt;code&gt; TimeStamp timeStamp = new
   * TimeStamp(); this.setTimePrimitive(timeStamp); &lt;/code&gt;
   */
  public TimeStamp createAndSetTimeStamp() {
    TimeStamp newValue = new TimeStamp();
    this.setTimePrimitive(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Style} and adds it to styleSelector. This
   * method is a short version for: &lt;code&gt; Style style = new Style();
   * this.getStyleSelector().add(style); &lt;/code&gt;
   */
  public Style createAndAddStyle() {
    Style newValue = new Style();
    this.getStyleSelector().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link StyleMap} and adds it to styleSelector.
   * This method is a short version for: &lt;code&gt; StyleMap styleMap = new
   * StyleMap(); this.getStyleSelector().add(styleMap); &lt;/code&gt;
   */
  public StyleMap createAndAddStyleMap() {
    StyleMap newValue = new StyleMap();
    this.getStyleSelector().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Region} and set it to region. This method
   * is a short version for: &lt;code&gt; Region region = new Region();
   * this.setRegion(region); &lt;/code&gt;
   */
  public Region createAndSetRegion() {
    Region newValue = new Region();
    this.setRegion(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Metadata} and set it to metadata. &lt;p
   * &gt; This method is a short version for: &lt;code&gt; Metadata metadata =
   * new Metadata(); this.setMetadata(metadata); &lt;/code&gt;
   */
  public Metadata createAndSetMetadata() {
    Metadata newValue = new Metadata();
    this.setMetadata(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link ExtendedData} and set it to extendedData.
   * This method is a short version for: &lt;code&gt; ExtendedData extendedData
   * = new ExtendedData(); this.setExtendedData(extendedData); &lt;/code&gt;
   */
  public ExtendedData createAndSetExtendedData() {
    ExtendedData newValue = new ExtendedData();
    this.setExtendedData(newValue);
    return newValue;
  }

  /**
   * @see styleSelector
   *
   * @param styleSelector
   */
  public void setStyleSelector(final List<StyleSelector> styleSelector) {
    this.styleSelector = styleSelector;
  }

  /**
   * add a value to the styleSelector property collection
   *
   * @param styleSelector Objects of the following type are allowed in the list:
   *                      {@link Style}{@link JAXBElement}{@link StyleSelector}{@link JAXBElement}{@link StyleMap}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of &lt;tt
   *         &gt;Collection.add &lt;/tt&gt;).
   */
  public Feature addToStyleSelector(final StyleSelector styleSelector) {
    this.getStyleSelector().add(styleSelector);
    return this;
  }

  /**
   * @see featureSimpleExtension
   *
   * @param featureSimpleExtension
   */
  public void setFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    this.featureSimpleExtension = featureSimpleExtension;
  }

  /**
   * add a value to the featureSimpleExtension property collection
   *
   * @param featureSimpleExtension Objects of the following type are allowed in
   *                               the list:
   *                               {@link Double}{@link JAXBElement}{@link Object}{@link JAXBElement}{@link Boolean}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of &lt;tt
   *         &gt;Collection.add &lt;/tt&gt;).
   */
  public Feature addToFeatureSimpleExtension(final Object featureSimpleExtension) {
    this.getFeatureSimpleExtension().add(featureSimpleExtension);
    return this;
  }

  /**
   * @see featureObjectExtension
   *
   * @param featureObjectExtension
   */
  public void setFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    this.featureObjectExtension = featureObjectExtension;
  }

  /**
   * add a value to the featureObjectExtension property collection
   *
   * @param featureObjectExtension Objects of the following type are allowed in
   *                               the list: {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of &lt;tt
   *         &gt;Collection.add &lt;/tt&gt;).
   */
  public Feature addToFeatureObjectExtension(final AbstractObject featureObjectExtension) {
    this.getFeatureObjectExtension().add(featureObjectExtension);
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
  public Feature addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setName(String)
   *
   * @param name required parameter
   */
  public Feature withName(final String name) {
    this.setName(name);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setVisibility(Boolean)
   *
   * @param visibility required parameter
   */
  public Feature withVisibility(final Boolean visibility) {
    this.setVisibility(visibility);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setOpen(Boolean)
   *
   * @param open required parameter
   */
  public Feature withOpen(final Boolean open) {
    this.setOpen(open);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAtomAuthor(Author)
   *
   * @param atomAuthor required parameter
   */
  public Feature withAtomAuthor(final Author atomAuthor) {
    this.setAtomAuthor(atomAuthor);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAtomLink(Link)
   *
   * @param atomLink required parameter
   */
  public Feature withAtomLink(final Link atomLink) {
    this.setAtomLink(atomLink);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAddress(String)
   *
   * @param address required parameter
   */
  public Feature withAddress(final String address) {
    this.setAddress(address);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setXalAddressDetails(AddressDetails)
   *
   * @param xalAddressDetails required parameter
   */
  public Feature withXalAddressDetails(final AddressDetails xalAddressDetails) {
    this.setXalAddressDetails(xalAddressDetails);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPhoneNumber(String)
   *
   * @param phoneNumber required parameter
   */
  public Feature withPhoneNumber(final String phoneNumber) {
    this.setPhoneNumber(phoneNumber);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSnippet(Snippet)
   *
   * @param snippet required parameter
   */
  public Feature withSnippet(final Snippet snippet) {
    this.setSnippet(snippet);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSnippetd(String)
   *
   * @param snippetd required parameter
   */
  public Feature withSnippetd(final String snippetd) {
    this.setSnippetd(snippetd);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setDescription(String)
   *
   * @param description required parameter
   */
  public Feature withDescription(final String description) {
    this.setDescription(description);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setAbstractView(AbstractView)
   *
   * @param abstractView required parameter
   */
  public Feature withAbstractView(final AbstractView abstractView) {
    this.setAbstractView(abstractView);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTimePrimitive(TimePrimitive)
   *
   * @param timePrimitive required parameter
   */
  public Feature withTimePrimitive(final TimePrimitive timePrimitive) {
    this.setTimePrimitive(timePrimitive);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setStyleUrl(String)
   *
   * @param styleUrl required parameter
   */
  public Feature withStyleUrl(final String styleUrl) {
    this.setStyleUrl(styleUrl);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setStyleSelector(List &lt;StyleSelector&gt;)
   *
   * @param styleSelector required parameter
   */
  public Feature withStyleSelector(final List<StyleSelector> styleSelector) {
    this.setStyleSelector(styleSelector);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setRegion(Region)
   *
   * @param region required parameter
   */
  public Feature withRegion(final Region region) {
    this.setRegion(region);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setMetadata(Metadata)
   *
   * @param metadata required parameter
   */
  public Feature withMetadata(final Metadata metadata) {
    this.setMetadata(metadata);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setExtendedData(ExtendedData)
   *
   * @param extendedData required parameter
   */
  public Feature withExtendedData(final ExtendedData extendedData) {
    this.setExtendedData(extendedData);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setFeatureSimpleExtension(List &lt;Object&gt;)
   *
   * @param featureSimpleExtension required parameter
   */
  public Feature withFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    this.setFeatureSimpleExtension(featureSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setFeatureObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param featureObjectExtension required parameter
   */
  public Feature withFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    this.setFeatureObjectExtension(featureObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Feature withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Feature withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Feature withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Override
  public Feature clone() {
    Feature copy;
    copy = ((Feature) super.clone());
    copy.atomAuthor = ((atomAuthor == null) ? null : ((Author) atomAuthor.clone()));
    copy.atomLink = ((atomLink == null) ? null : ((Link) atomLink.clone()));
    copy.xalAddressDetails = ((xalAddressDetails == null) ? null : ((AddressDetails) xalAddressDetails.clone()));
    copy.snippet = ((snippet == null) ? null : ((Snippet) snippet.clone()));
    copy.abstractView = ((abstractView == null) ? null : ((AbstractView) abstractView.clone()));
    copy.timePrimitive = ((timePrimitive == null) ? null : ((TimePrimitive) timePrimitive.clone()));
    copy.styleSelector = new ArrayList<>((getStyleSelector().size()));
    for (StyleSelector iter : styleSelector) {
      copy.styleSelector.add(iter.clone());
    }
    copy.region = ((region == null) ? null : ((Region) region.clone()));
    copy.metadata = ((metadata == null) ? null : ((Metadata) metadata.clone()));
    copy.extendedData = ((extendedData == null) ? null : ((ExtendedData) extendedData.clone()));
    copy.featureSimpleExtension = new ArrayList<>((getFeatureSimpleExtension().size()));
    for (Object iter : featureSimpleExtension) {
      copy.featureSimpleExtension.add(iter);
    }
    copy.featureObjectExtension = new ArrayList<>((getFeatureObjectExtension().size()));
    for (AbstractObject iter : featureObjectExtension) {
      copy.featureObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
