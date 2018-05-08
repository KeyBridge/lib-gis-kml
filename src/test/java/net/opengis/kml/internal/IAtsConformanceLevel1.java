package net.opengis.kml.internal;

/**
 * Conformance Level 1
 *  &lt;b&gt;Purpose: &lt;/b&gt;
 *   
 * Conformance Level 1 includes test cases corresponding to absolute
 * requirements; a KML document must satisfy all assertions at this level to be
 * minimally conformant.
 *   
 * List of Tables
 *  &lt;ol&gt;
 *  &lt;li&gt;Root element &lt;/li&gt;
 *  &lt;li&gt;XML Schema constraints &lt;/li&gt;
 *  &lt;li&gt;Geometry coordinates &lt;/li&gt;
 *  &lt;li&gt;TimeSpan &lt;/li&gt;
 *  &lt;li&gt;TimeStamp &lt;/li&gt;
 *  &lt;li&gt;Style reference &lt;/li&gt;
 *  &lt;li&gt;Shared style definition &lt;/li&gt;
 *  &lt;li&gt;Region - LatLonAltBox &lt;/li&gt;
 *  &lt;li&gt;Link elements &lt;/li&gt;
 *  &lt;li&gt;Link referent &lt;/li&gt;
 *  &lt;li&gt;LatLonBox &lt;/li&gt;
 *  &lt;li&gt;Geometry - extrude &lt;/li&gt;
 *  &lt;li&gt;Geometry - tessellate &lt;/li&gt;
 *  &lt;li&gt;Point &lt;/li&gt;
 *  &lt;li&gt;LineString &lt;/li&gt;
 *  &lt;li&gt;LinearRing - control points &lt;/li&gt;
 *  &lt;li&gt;Polygon boundary &lt;/li&gt;
 *  &lt;li&gt;Icon - href &lt;/li&gt;
 *  &lt;li&gt;ViewVolume - minimal content &lt;/li&gt;
 *  &lt;li&gt;NetworkLinkControl - minRefreshPeriod &lt;/li&gt;
 *  &lt;li&gt;Empty object &lt;/li&gt;
 *  &lt;li&gt;Update - targetHref &lt;/li&gt;
 *  &lt;li&gt;Identification of update target &lt;/li&gt;
 *  &lt;li&gt;PhoneNumber &lt;/li&gt;
 *  &lt;li&gt;Schema &lt;/li&gt;
 *  &lt;li&gt;Schema - SimpleField &lt;/li&gt;
 *  &lt;li&gt;ExtendedData - SchemaData &lt;/li&gt;
 *  &lt;li&gt;ExtendedData - Data &lt;/li&gt;
 *  &lt;li&gt;Alias &lt;/li&gt;
 *  &lt;li&gt;atom:author &lt;/li&gt;
 *  &lt;li&gt;atom:link &lt;/li&gt;
 *  &lt;li&gt;Orientation - minimal content &lt;/li&gt;
 *  &lt;li&gt;GroundOverlay &lt;/li&gt;
 *  &lt;li&gt;Model &lt;/li&gt;
 *  &lt;li&gt;PhotoOverlay - minimal content &lt;/li&gt;
 *  &lt;li&gt;Pair &lt;/li&gt;
 *  &lt;li&gt;ItemIcon &lt;/li&gt;
 *  &lt;li&gt;LookAt &lt;/li&gt;
 *  &lt;li&gt;Lod &lt;/li&gt;
 *  &lt;li&gt;Link &lt;/li&gt;
 *  &lt;li&gt;Region &lt;/li&gt;
 *  &lt;/ol&gt;
 */
public interface IAtsConformanceLevel1 {

  /**
   * ATC 1: Root element
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/RootElement &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; Verify that the root element of the document has
   * [local name] = "kml" and [namespace name] =
   * "http://www.opengis.net/kml/2.2". &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if all assertions are satisfied; fail otherwise.
   * This test checks that the XML document is indeed an OGC KML document. If
   * this test fails, all remaining tests are skipped. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 7.1.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc01RootElement();

  /**
   * ATC 2: XML Schema constraints
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/XmlSchemaConstraints &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; KmlReferenceCheck that the document is well-formed and
   * schema-valid. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the document satisfies all schema constraints;
   * fail otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: Annex A (KML Schemas) &lt;/li&gt;
   *  &lt;li&gt;XML 1.0: Well-Formed XML Documents &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc02XMLSchemaconstraints();

  /**
   * ATC 3: Geometry coordinates
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/Geometry-Coordinates &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; Verify that a kml:coordinates element contains a list
   * of white space-separated 2D or 3D tuples that contain comma-separated
   * decimal values (lon,lat[,hgt]). &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if all kml:coordinates elements contain 2D/3D
   * tuples containing decimal values conforming to the xsd:decimal type; fail
   * otherwise. White space consists of one or more of the following characters:
   * space (U+0020), carriage return (U+000D), line feed (U+000A), or tab
   * (U+0009). The relevant coordinate reference system (CRS) is defined in
   * Annex B of the OGC KML 2.2 specification. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 16.1 &lt;/li&gt;
   *  &lt;li&gt;XML Schema Part 2 - Datatypes (2e): decimal &lt;/li&gt;
   *  &lt;li&gt;OGC-07-147r2: Annex B &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc03GeometryCoordinates();

  /**
   * ATC 4: TimeSpan
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-1/TimeSpan &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * Verify that a TimeSpan element satisfies all of the following constraints:
   * it includes at least one child element (kml:begin or kml:end); if it is a
   * definite interval (both kml:begin and kml:end are present), then the begin
   * value is earlier than the end value.
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if all assertions are satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 15.2.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc04TimeSpan();

  /**
   * ATC 5: TimeStamp
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/TimeStamp &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; Verify that a kml:TimeStamp element has a child
   * kml:when element. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 15.3.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc05TimeStamp();

  /**
   * ATC 6: Style reference
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/StyleReference &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * KmlReferenceCheck that a kml:styleUrl element satisfies all of the
   * following constraints: its value is a valid relative or absolute URL that
   * refers to a shared style definition (any element that substitutes for
   * kml:AbstractStyleSelectorGroup); if the reference is an absolute URI, the
   * value conforms to the 'http' or 'file' URI schemes; it includes a fragment
   * identifier conforming to the shorthand pointer syntax as defined in the W3C
   * XPointer framework.  &lt;b&gt;Test method: &lt;/b&gt; Pass if all applicable assertions
   * are satisfied; fail otherwise. A relative URL is resolved according to the
   * reference resolution algorithm described in section 5 of RFC 3986. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 6.4 &lt;/li&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.1.3.13.1 &lt;/li&gt;
   *  &lt;li&gt;XPointer Framework: Shorthand Pointer &lt;/li&gt;
   *  &lt;li&gt;RFC 3986: Reference Resolution &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc06StyleReference();

  /**
   * ATC 7: Shared style definition
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/SharedStyle &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * Confirm that a 'shared' style definition (any element that may substitute
   * for kml:AbstractStyleSelectorGroup) satisfies all of the following
   * constraints: its parent element is kml:Document; it has an 'id' attribute
   * value.  &lt;b&gt;Test method: &lt;/b&gt; Pass if all assertions are satisfied; fail
   * otherwise. Shared styles include kml:Style and kml:StyleMap elements. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 6.4 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc07SharedStyleDefintion();

  /**
   * ATC 8: Region - LatLonAltBox
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/Region-LatLonAltBox &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * Verify that the content of a kml:LatLonAltBox element satisfies all of the
   * following constraints: kml:north &gt; kml:south; kml:east &gt; kml:west;
   * kml:minAltitude  &lt;= kml:maxAltitude; if kml:minAltitude and kml:maxAltitude
   * are both present, then kml:altitudeMode does not have the value
   * "clampToGround".  &lt;b&gt;Test method:
   *  &lt;/b&gt; Pass if all applicable assertions are satisfied; fail otherwise. The
   * default envelope for a region of interest is the entire surface of the
   * EGM96 geoid. By testing north &gt; south and east &gt; west, we are testing for a
   * non-zero area. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.15.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc08RegionLatLonAltBox();

  /**
   * ATC 9: Link elements
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/Link-Elements &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * KmlReferenceCheck that a link element (of type kml:LinkType) satisfies all
   * of the following constraints: if present, the child kml:refreshInterval
   * element has a positive value (&gt; 0); if present, the child
   * kml:viewRefreshTime element has a positive value (&gt; 0); if present, the
   * child kml:viewBoundScale element has a positive value (&gt; 0).  &lt;b&gt;Test
   * method: &lt;/b&gt; Pass if a link element (kml:Link,
   * kml:AbstractOverlayType/kml:Icon) satisfies all applicable constraints;
   * fail otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 13.1.3.3.1 &lt;/li&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 13.1.3.5.1 &lt;/li&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 13.1.3.6.1 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc09LinkElements();

  /**
   * ATC 10: Link referent
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/LinkReferent &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * Confirm that a link element refers to the correct resource type, according
   * to one of the following cases: if the parent element is kml:NetworkLink - a
   * KML or KMZ resource; if the parent element is kml:Model - a textured 3D
   * object resource; if the parent element is kml:GroundOverlay,
   * kml:ScreenOverlay, or kml:PhotoOverlay - an image resource  &lt;b&gt;Test
   * method: &lt;/b&gt; Pass if all link elements (kml:Link,
   * kml:AbstractOverlayType/kml:Icon) have correct referents; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.12.3.3 &lt;/li&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.9.3.5.1 &lt;/li&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 11.1.3.3 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc10LinkReferent();

  /**
   * ATC 11: LatLonBox
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/LatLonBox &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * Verify that a kml:LatLonBox element satisfies all of the following
   * constraints: it contains the kml:north, kml:south, kml:east, and kml:west
   * elements; kml:north &gt; kml:south (compare character information items);
   * kml:east &gt; kml:west (compare character information items).  &lt;b&gt;Test
   * method: &lt;/b&gt; Pass if the assertion is satisfied; fail otherwise. The default
   * envelope for a kml:GroundOverlay is the entire surface of the WGS 84
   * ellipsoid. By testing north &gt; south and east &gt; west, we are testing for a
   * non-zero area. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 11.3.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc11LatLonBox();

  /**
   * ATC 12: Geometry - extrude
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/Geometry-Extrude &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * KmlReferenceCheck that if the kml:extrude element has the value "true",
   * then the value of kml:altitudeMode is not "clampToGround".  &lt;b&gt;Test
   * method: &lt;/b&gt; Pass if the assertion is satisfied; fail otherwise. This
   * applies to the following elements: kml:Point, kml:LineString,
   * kml:LinearRing (but NOT if it occurs within a Polygon), and
   * kml:Polygon. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.4.1.1.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc12GeometryExtrude();

  /**
   * ATC 13: Geometry - tessellate
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/Geometry-Tessellate &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * Confirm that if the kml:tessellate element has the value "true", then the
   * value of kml:altitudeMode is "clampToGround" (default value).
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail otherwise.
   * This applies to the following elements: kml:LineString, kml:LinearRing (but
   * NOT if it occurs within a Polygon), and kml:Polygon. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.6.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc13GeometryTessellate();

  /**
   * ATC 14: Point
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-1/Point &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; KmlReferenceCheck that the kml:coordinates element in
   * a kml:Point geometry contains exactly one coordinate tuple. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.3.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc14Point();

  /**
   * ATC 15: LineString
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/LineString &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; Verify that the kml:coordinates element in a
   * kml:LineString geometry contains at least two coordinate tuples. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.7.3.4.1 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc15LineString();

  /**
   * ATC 16: LinearRing - control points
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/LinearRing-ControlPoints &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; KmlReferenceCheck that the kml:coordinates element in
   * a kml:LinearRing geometry contains at least 4 coordinate tuples, where the
   * first and last are identical (i.e. they constitute a closed figure). &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.7.5.4.1 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc16LinearRingControlPoints();

  /**
   * ATC 17: Polygon boundary
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/PolygonBoundary &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * Verify that the boundary of a kml:Polygon element satisfies all of the
   * following constraints: if it is not a descendant of kml:Update, then the
   * kml:Polygon has a child kml:outerBoundaryIs element; each interior boundary
   * defines a hole in the Polygon (that is, each inner ring lies within the
   * exterior boundary).  &lt;b&gt;Test method: &lt;/b&gt; Pass if all assertions are
   * satisfied; fail otherwise. This test case reflects the essential definition
   * of a polygon; no particular line orientations are assumed. The relevant
   * polygons can be identified using this XPath expression:
   * //kml:Polygon[not(ancestor::kml:Update)]. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.8.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc17PolygonBoundary();

  /**
   * ATC 18: Icon - href
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/Icon-href &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; Verify that the kml:Icon/kml:href element refers to an
   * image resource. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail otherwise. The
   * image format must correspond to a registered image media type (PNG, JPEG,
   * and GIF images are commonly used for this purpose). Applies to kml:Icon
   * elements in both kml:IconStyle and kml:AbstractOverlayType contexts. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 13.1.2 &lt;/li&gt;
   * Image Media Types
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc18IconHref();

  /**
   * ATC 19: ViewVolume - minimal content
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/ViewVolume-Minimal &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; Verify that a kml:ViewVolume element includes at least
   * the following child elements: kml:leftFov, kml:rightFov, kml:bottomFov,
   * kml:topFov, and kml:near (non-negative value). &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 11.5.2 &lt;/li&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 11.5.3.5 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc19ViewVolumeMinimalContent();

  /**
   * ATC 20: NetworkLinkControl - minRefreshPeriod
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/NetworkLinkControl-MinRefreshPeriod &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; Verify that a kml:minRefreshPeriod element (occurs in
   * kml:NetworkLinkControl) is non-negative (&gt;=0). &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 13.2.3.1.1 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc20NetworkLinkControlMinRefreshPeriod();

  /**
   * ATC 21: Empty object
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/EmptyObject &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; Verify that a KML object that is not a descendant of
   * kml:Update is either (a) not empty, or (b) has an 'id' attribute value (so
   * it can be easily updated). &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail otherwise. The
   * relevant context is
   * //kml:AbstractObjectType[not(ancestor::kml:Update)]. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 8.1.3.1.1 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc21EmptyObject();

  /**
   * ATC 22: Update - targetHref
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/Update-targetHref &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * KmlReferenceCheck that the value of the kml:Update/kml:targetHref element
   * satisfies all of the following constraints: it is an absolute URL that
   * refers to a KML or KMZ resource; the value matches the retrieval URI for an
   * existing NetworkLink element (kml:NetworkLink/kml:Link/kml:href).  &lt;b&gt;Test
   * method: &lt;/b&gt; Pass if all applicable assertions are satisfied; fail
   * otherwise. This modifies the behaviour of a referring NetworkLink. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 13.4.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc22UpdateTargetHref();

  /**
   * ATC 23: Identification of update target
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/UpdateTarget &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; KmlReferenceCheck that a KML object which is a
   * grandchild of kml:Update satisfies the following constraints: (a) it
   * includes a 'targetId' attribute value that identifies the object to be
   * updated, and (b) it does not have an 'id' attribute. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail otherwise.
   * Examine the content of all kml:Create, kml:Delete and kml:Change
   * elements. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 13.3.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc23IdentificationOfUpdateTarget();

  /**
   * ATC 24: PhoneNumber
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/PhoneNumber &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; KmlReferenceCheck that the value of the
   * kml:phoneNumber element is a 'tel' URI that conforms to RFC 3966. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.1.3.8.1 &lt;/li&gt;
   *  &lt;li&gt;RFC 3966: The tel URI for Telephone Numbers &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc24Phonenumber();

  /**
   * ATC 25: Schema
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-1/Schema &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; KmlReferenceCheck that a kml:Schema element has an
   * 'id' attribute value. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.8.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc25Schema();

  /**
   * ATC 26: Schema - SimpleField
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/Schema-SimpleField &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * Verify that a kml:SimpleField element satisfies all of the following
   * constraints: it has a 'name' attribute; the value of the 'type' attribute
   * is one of the following XML Schema data types:  &lt;li&gt;xsd:string &lt;/li&gt;
   *  &lt;li&gt;xsd:int &lt;/li&gt;  &lt;li&gt;xsd:unsignedInt &lt;/li&gt;  &lt;li&gt;xsd:short &lt;/li&gt;
   *  &lt;li&gt;xsd:unsignedShort &lt;/li&gt;  &lt;li&gt;xsd:float &lt;/li&gt;  &lt;li&gt;xsd:double &lt;/li&gt;
   *  &lt;li&gt;xsd:boolean &lt;/li&gt;  &lt;b&gt;Test method: &lt;/b&gt; Pass if all assertions are
   * satisfied; fail otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.9.2, &lt;/li&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.9.4.2.1 &lt;/li&gt;
   *  &lt;li&gt;XML Schema Part 2 - Datatypes (2e): Built-in datatypes &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc26SchemaSimpleField();

  /**
   * ATC 27: ExtendedData - SchemaData
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/ExtendedData-SchemaData &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * Confirm that a kml:SchemaData element satisfies all of the following
   * constraints: the 'schemaUrl' attribute value is a URL with a fragment
   * component that refers to a kml:Schema element; all kml:SimpleData child
   * elements have a 'name' attribute that matches the name of a declared
   * kml:SimpleField element in the corresponding Schema; the values of all
   * kml:SimpleData child elements conform to their declared types.  &lt;b&gt;Test
   * method: &lt;/b&gt; Pass if all assertions are satisfied; fail otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.4.2 &lt;/li&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.5.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc27ExtendedDataSchemaData();

  /**
   * ATC 28: ExtendedData - Data
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/ExtendedData-Data &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; KmlReferenceCheck that the value of the 'name'
   * attribute is unique within the context of the parent kml:ExtendedData
   * element. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.3.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc28ExtendedDataData();

  /**
   * ATC 29: Alias
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-1/Alias &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * Verify that a kml:Alias element satisfies the following assertions: the
   * value of the child kml:targetHref element is a URI reference to an image
   * (texture) resource; the value of the child kml:sourceHref element
   * corresponds to a file reference appearing within the 3D object resource
   * referenced in the preceding sibling kml:Link element.  &lt;b&gt;Test method: &lt;/b&gt;
   * Pass if all assertions are satisfied; fail otherwise. The source is
   * expected to be a textual (possibly XML) resource. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.14.3.1.1 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc29Alias();

  /**
   * ATC 30: atom:author
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/atom-author &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * KmlReferenceCheck that an atom:author element satisfies all of the
   * following assertions: the content of the child atom:uri element is an IRI
   * reference; the content of the child atom:email element conforms to the
   * "addr-spec" production in RFC 2822.  &lt;b&gt;Test method: &lt;/b&gt; Pass if all
   * assertions are satisfied; fail otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.1.3.4.2 &lt;/li&gt;
   *  &lt;li&gt;RFC 4287: Person Constructs &lt;/li&gt;
   *  &lt;li&gt;RFC 3987: Internationalized Resource Identifiers (IRIs) &lt;/li&gt;
   *  &lt;li&gt;RFC 2822: Addr-spec specification &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc30AtomAuthor();

  /**
   * ATC 31: atom:link
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/atom-link &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; KmlReferenceCheck that the value of the atom:link/@rel
   * attribute is "related". &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail otherwise. If
   * the attribute is not present, the link must be interpreted as if @rel =
   * "alternate" (i.e. the referent is an alternate version of the resource).
   * The value "related" simply signifies a generic relationship. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.1.3.5.1 &lt;/li&gt;
   *  &lt;li&gt;RFC 4287: The "rel" Attribute &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc31AtomLink();

  /**
   * ATC 32: Orientation - minimal content
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/Orientation-Minimum &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; Verify that if a kml:Orientation element is not a
   * descendant of kml:Update, then it contains at least one of the following
   * elements: kml:heading, kml:tilt, or kml:roll. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.11.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc32OrientationMinimalContent();

  /**
   * ATC 33: GroundOverlay
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/GroundOverlay &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; Verify that a kml:GroundOverlay with an
   * kml:altitudeMode value of "absolute" includes a kml:altitude element. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.17.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc33GroundOverlay();

  /**
   * ATC 34: Model
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-1/Model &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/&gt;
   * KmlReferenceCheck that a kml:Model element satisfies all of the following
   * constraints: it contains the kml:Link and kml:Location elements; if it is
   * not a descendant of kml:Update and the target resource refers to any
   * texture files, then there must be a kml:ResourceMap/kml:Alias for each
   * related texture file.  &lt;b&gt;Test method: &lt;/b&gt; Pass if all applicable assertions
   * are satisfied; fail otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.9.3 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc34Model();

  /**
   * ATC 35: PhotoOverlay - minimal content
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt;
   * http://www.opengis.net/kml/2.2/atc/level-1/PhotoOverlay-Minimal &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; KmlReferenceCheck that if a kml:PhotoOverlay element
   * is not a descendant of kml:Update, then it includes all of the following
   * child elements: kml:Icon, kml:ViewVolume, kml:Point, and kml:Camera. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 11.4.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc35PhotoOverlayMinimalContent();

  /**
   * ATC 36: Pair
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-1/Pair &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; KmlReferenceCheck that if a kml:Pair element is not a
   * descendant of kml:Update, then it contains (a) a kml:key element, and (b)
   * at least one of kml:styleURL element or any element that substitutes for
   * kml:AbstractStyleSelectorGroup. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail otherwise.
   * kml:AbstractStyleSelectorGroup elements are typically kml:Style or
   * kml:StyleMap. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 12.4.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc36Pair();

  /**
   * ATC 37: ItemIcon
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-1/ItemIcon &lt;br/&gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt; KmlReferenceCheck that if a kml:ItemIcon element is
   * not a descendant of kml:Update, then it has a kml:href child element. &lt;br/&gt;
   *  &lt;b&gt;Test method: &lt;/b&gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/&gt;
   *  &lt;b&gt;Reference: &lt;/b&gt;
   *  &lt;ul&gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 12.14.2 &lt;/li&gt;
   *  &lt;/ul&gt;
   *  &lt;b&gt;Test type: &lt;/b&gt; Basic
   */
  public void atc37ItemIcon();

  /**
   * ATC 38: LookAt
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt; http://www.opengis.net/kml/2.2/atc/level-1/LookAt &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt;  &lt;br/ &gt;
   * KmlReferenceCheck that a kml:LookAt element satisfies all of the following
   * constraints: if it is not a descendant of kml:Update, it contains all of
   * the following child elements: kml:longitude, kml:latitude, and kml:range; 0
   *  &lt;= kml:tilt  &lt;= 90; if kml:altitudeMode does not have the value
   * "clampToGround", then the kml:altitude element is present.  &lt;b &gt;Test method:
   *  &lt;/b &gt; Pass if the applicable assertions are satisfied; fail otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 9.17.2 &lt;/li &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 14.3.2 &lt;/li &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 14.3.4.5.1 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc38LookAt();

  /**
   * ATC 39: Lod
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt; http://www.opengis.net/kml/2.2/atc/level-1/Lod &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt;  &lt;br/ &gt;
   * KmlReferenceCheck that a kml:Lod element satisfies all of the following
   * constraints: if it is not a descendant of kml:Update, it contains the
   * kml:minLodPixels element; kml:minLodPixels  &lt; kml:maxLodPixels (where a
   * value of -1 denotes infinity).  &lt;b &gt;Test method:
   *  &lt;/b &gt; Pass if all assertions are satisfied; fail otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 9.18.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc39Lod();

  /**
   * ATC 40: Link
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt; http://www.opengis.net/kml/2.2/atc/level-1/Link &lt;br/ &gt;
   *  &lt;b &gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:Link or a kml:Icon
   * element is not a descendant of kml:Update, then it contains a kml:href
   * child element. &lt;br/ &gt;
   *  &lt;b &gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 13.1.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc40Link();

  /**
   * ATC 41: Region
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt; http://www.opengis.net/kml/2.2/atc/level-1/Region &lt;br/ &gt;
   *  &lt;b &gt;Test purpose: &lt;/b &gt; Confirm that if a kml:Region element is not a
   * descendant of kml:Update, it contains the kml:LatLonAltBox and kml:Lod
   * elements. &lt;br/ &gt;
   *  &lt;b &gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 9.13.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc41Region();
}
