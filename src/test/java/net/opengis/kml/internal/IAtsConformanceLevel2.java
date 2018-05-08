package net.opengis.kml.internal;

/**
 * Conformance Level 2
 *  &lt;b &gt;Purpose: &lt;/b &gt;
 *   
 * Conformance Level 2 includes all Level 1 tests plus test cases covering
 * requirements that should be satisfied by a KML document. Non-conformance at
 * this level may hinder the utility, portability, or interoperability of the
 * document.
 *   
 * List of Tables
 *  &lt;ol &gt;
 *  &lt;li &gt;PolyStyle &lt;/li &gt;
 *  &lt;li &gt;Coordinates - altitudeMode &lt;/li &gt;
 *  &lt;li &gt;Scale - minimal content &lt;/li &gt;
 *  &lt;li &gt;KML - minimal content &lt;/li &gt;
 *  &lt;li &gt;ViewFormat &lt;/li &gt;
 *  &lt;li &gt;httpQuery &lt;/li &gt;
 *  &lt;li &gt;LinearRing in Polygon &lt;/li &gt;
 *  &lt;li &gt;Data &lt;/li &gt;
 *  &lt;li &gt;ResourceMap - Alias &lt;/li &gt;
 *  &lt;li &gt;Link refresh values &lt;/li &gt;
 *  &lt;li &gt;PhotoOverlay &lt;/li &gt;
 *  &lt;li &gt;GroundOverlay - minimal content &lt;/li &gt;
 *  &lt;li &gt;Camera &lt;/li &gt;
 *  &lt;li &gt;Location &lt;/li &gt;
 *  &lt;li &gt;Overlay &lt;/li &gt;
 *  &lt;li &gt;ScreenOverlay &lt;/li &gt;
 *  &lt;li &gt;BalloonStyle &lt;/li &gt;
 *  &lt;li &gt;ExtendedData &lt;/li &gt;
 *  &lt;li &gt;Folder &lt;/li &gt;
 *  &lt;li &gt;IconStyle &lt;/li &gt;
 *  &lt;li &gt;ImagePyramid &lt;/li &gt;
 *  &lt;li &gt;LabelStyle &lt;/li &gt;
 *  &lt;li &gt;ListStyle &lt;/li &gt;
 *  &lt;li &gt;Style &lt;/li &gt;
 *  &lt;li &gt;MultiGeometry &lt;/li &gt;
 *  &lt;li &gt;Placemark &lt;/li &gt;
 *  &lt;li &gt;StyleMap &lt;/li &gt;
 *  &lt;/ol &gt;
 */
public interface IAtsConformanceLevel2 {

  /**
   * ATC 42: PolyStyle
   *   
   *  &lt;b &gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/PolyStyle &lt;br/ &gt;
   *  &lt;b &gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:PolyStyle element is
   * not a descendant of kml:Update, it contains at least one of the following
   * elements: kml:color, kml:colorMode, kml:fill, or kml:outline. &lt;br/ &gt;
   *  &lt;b &gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 12.12.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc42PolyStyle();

  /**
   * ATC 43: Coordinates - altitudeMode
   *   
   *  &lt;b &gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/Coordinates-altitudeMode &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt;  &lt;br/ &gt;
   * Confirm that a kml:coordinates or kml:Location element includes a third
   * coordinate tuple (altitude) if its sibling kml:altitudeMode element does
   * NOT have the value "clampToGround".  &lt;b &gt;Test method: &lt;/b &gt; Pass if the
   * assertion is satisfied; fail otherwise. Applies to the control points in
   * kml:AbstractGeometryType/kml:coordinates and kml:Model/kml:Location. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 9.17.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc43CoordinatesAltitudeMode();

  /**
   * ATC 44: Scale - minimal content
   *   
   *  &lt;b &gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/Scale-Minimal &lt;br/ &gt;
   *  &lt;b &gt;Test purpose: &lt;/b &gt; Verify that if a kml:Scale element is not a descendant
   * of kml:Update, it contains at least one of the following elements: kml:x,
   * kml:y, or kml:z. &lt;br/ &gt;
   *  &lt;b &gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 10.12.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc44ScaleMinimalContent();

  /**
   * ATC 45: KML - minimal content
   *   
   *  &lt;b &gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/Kml-Minimal &lt;br/ &gt;
   *  &lt;b &gt;Test purpose: &lt;/b &gt; Verify that the root element (kml:kml) contains at
   * least one child element: kml:NetworkLinkControl or any element that
   * substitutes for kml:AbstractFeatureType. &lt;br/ &gt;
   *  &lt;b &gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 7.1.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc45KMLMinimalContent();

  /**
   * ATC 46: ViewFormat
   *   
   *  &lt;b &gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/ViewFormat &lt;br/ &gt;
   *  &lt;b &gt;Test purpose: &lt;/b &gt; Verify a kml:viewFormat contains at least one
   * parameter. &lt;br/ &gt;
   *  &lt;b &gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 13.1.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc46ViewFormat();

  /**
   * ATC 47: httpQuery
   *   
   *  &lt;b &gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/HttpQuery &lt;br/ &gt;
   *  &lt;b &gt;Test purpose: &lt;/b &gt; Verify a kml:httpQuery contains at least one
   * parameter. &lt;br/ &gt;
   *  &lt;b &gt;Test method: &lt;/b &gt; Pass if the httpQuery has at least one of the allowable
   * parameters; fail otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 13.1.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc47HttpQuery();

  /**
   * ATC 48: LinearRing in Polygon
   *   
   *  &lt;b &gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/LinearRingInPolygon &lt;br/ &gt;
   *  &lt;b &gt;Test purpose: &lt;/b &gt; Verify that a kml:LinearRing element, when appearing
   * within a kml:Polygon, does not contain any of the following elements:
   * kml:extrude, kml:tesselate, or kml:altitudeMode. &lt;br/ &gt;
   *  &lt;b &gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 10.5.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc48LinearRingInPolygon();

  /**
   * ATC 49: Data
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt; http://www.opengis.net/kml/2.2/atc/level-2/Data &lt;br/ &gt;
   *  &lt;b &gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that the kml:Data element has both a
   * 'name' attribute and a kml:value child element. &lt;br/ &gt;
   *  &lt;b &gt;Test method: &lt;/b &gt; Pass if the assertion is satisfiedt; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 9.3.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc49Data();

  /**
   * ATC 50: ResourceMap - Alias
   *   
   *  &lt;b &gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/ResourceMap-Alias &lt;br/ &gt;
   *  &lt;b &gt;Test purpose: &lt;/b &gt; Verify that a kml:ResourceMap element contains at
   * least one kml:Alias child element, and that each Alias element has a unique
   * kml:sourceHref value. &lt;br/ &gt;
   *  &lt;b &gt;Test method: &lt;/b &gt; Pass if all assertions are satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b &gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li &gt;OGC-07-147r2: cl. 10.13.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b &gt;Test type: &lt;/b &gt; Basic
   */
  public void atc50ResourceMapAlias();

  /**
   * ATC 51: Link refresh values
   *   
   *  &lt;b &gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/LinkRefresh &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt;  &lt;br/ &gt;
   * KmlReferenceCheck that a kml:Link or a kml:Icon element (of type
   * kml:LinkType) satisfies all of the following constraints: if the
   * kml:refreshInterval element is present, the kml:refreshMode value must be
   * "onInterval"; if the kml:viewRefresh element is present, the
   * kml:refreshMode value must be "onStop".  &lt;b &gt;Test method: &lt;/b &gt; Pass if all
   * relevant assertions are satisfied; fail otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 13.1.3.2.1 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc51LinkRefreshValues();

  /**
   * ATC 52: PhotoOverlay
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/PhotoOverlay &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:PhotoOverlay element
   * includes a kml:Icon/kml:href element containing [x], [y], and [level]
   * parameters, then it also includes a child kml:ImagePyramid element; the
   * converse must also be true. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail otherwise. The
   * parameters are embedded within the URL; i.e,
   * http://server.company.com/bigphoto/$[level]/row_$[x]_column_$[y].jpg.
   * KmlReferenceCheck for the kml:ImagePyramid when the x, y, level parameters
   * are present, or if the kml:ImagePyramid is present check for the x, y,
   * level parameters. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 11.4.3 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc52PhotoOverlay();

  /**
   * ATC 53: GroundOverlay - minimal content
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/GroundOverlay-Minimal &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; Verify that if a kml:GroundOverlay element is not a
   * descendant of kml:Update, it contains a kml:LatLonBox element (with
   * kml:north, kml:south, kml:east, kml:west). &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail otherwise. The
   * presence of north, south, east, and west indicates the Overlay draws a
   * polygon. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 11.2.3.1 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc53GroundOverlayMinimalContent();

  /**
   * ATC 54: Camera
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-2/Camera &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/ &gt;
   * KmlReferenceCheck that a kml:Camera element satisfies all of the following
   * constraints: if it is not a descendant of kml:Update, then the following
   * child elements are present: kml:latitude, kml:longitude, and kml:altitude;
   * the value of kml:altitudeMode is not "clampToGround".
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 14.2.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc54Camera();

  /**
   * ATC 55: Location
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-2/Location &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/ &gt;
   * KmlReferenceCheck that a kml:Location element satisfies all of the
   * following constraints: it contains the kml:longitude and kml:latitude
   * elements; if the parent kml:Model element has a kml:altitudeMode value that
   * is not "clampToGround", then the kml:altitude element must also be present.
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if all applicable assertions are satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.17.2 &lt;/li &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.9.2, &lt;/li &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.10.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc55Location();

  /**
   * ATC 56: Overlay
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-2/Overlay &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if any element that substitutes
   * for kml:AbstractOverlayType is not a descendant of kml:Update, then it
   * contains a kml:Icon child element. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 11.2.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc56Overlay();

  /**
   * ATC 57: ScreenOverlay
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/ScreenOverlay &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:ScreenOverlay element
   * is not a descendant of kml:Update, then it has a kml:screenXY child
   * element. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 11.7.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc57ScreenOverlay();

  /**
   * ATC 58: BalloonStyle
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/BalloonStyle &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:BalloonStyle element
   * is not a descendant of kml:Update, it is not empty. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 12.6.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc58BaloonStyle();

  /**
   * ATC 59: ExtendedData
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/ExtendedData &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that a kml:ExtendedData element is
   * not empty. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.2.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc59ExtendedData();

  /**
   * ATC 60: Folder
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-2/Folder &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:Folder element is not
   * a descendant of kml:Update, then it is not empty. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.10.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc60Folder();

  /**
   * ATC 61: IconStyle
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/IconStyle &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:IconStyle element is
   * NOT a descendant of kml:Update, it is not empty. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if all applicable assertions are satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 12.8.2 &lt;/li &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 12.9.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc61IconStyle();

  /**
   * ATC 62: ImagePyramid
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/ImagePyramid &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b&gt;  &lt;br/ &gt;
   * KmlReferenceCheck that if a kml:ImagePyramid element is not a descendantof
   * kml:Update, it satisfies all of the following constraints: it has the
   * kml:maxWidth and kml:maxHeight child elements; the kml:tileSize value is a
   * power of 2.  &lt;b&gt;Test method: &lt;/b &gt; Pass if all assertions are satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 11.6.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc62ImagePyramid();

  /**
   * ATC 63: LabelStyle
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/LabelStyle &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:LabelStyle element is
   * not a descendant of kml:Update, it has at least one of the following child
   * elements: kml:color, kml:colorMode, or kml:scale. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 12.10.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc63LabelStyle();

  /**
   * ATC 64: ListStyle
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/ListStyle &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:ListStyle element is
   * not a descendant of kml:Update, it has at least one of the following child
   * elements: kml:listItemType, kml:bgColor, or kml:ItemIcon. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 12.13.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc64ListStyle();

  /**
   * ATC 65: Style
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-2/Style &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:Style element is not a
   * descendant of kml:Update, it is not empty. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 12.2.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc65Sytle();

  /**
   * ATC 66: MultiGeometry
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/MultiGeometry &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:MultiGeometry element
   * is not a descendant of kml:Update, it contains two or more geometry
   * elements. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.2.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc66MultiGeometry();

  /**
   * ATC 67: Placemark
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-2/Placemark &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:Placemark element is
   * not a descendant of kml:Update, it includes a geometry element (any element
   * that substitutes for kml:AbstractGeometryGroup. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.11.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc67Placemark();

  /**
   * ATC 68: StyleMap
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-2/StyleMap &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that if a kml:StyleMap element is
   * not a descendant of kml:Update, it contains two kml:Pair elements where one
   * key value is "normal" and the other key value is "highlight". &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 12.3.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc68StyleMap();
}
