package net.opengis.kml.internal;

/**
 * Conformance Level 3
 *  &lt;b&gt;Purpose: &lt;/b &gt;
 *   
 * Conformance Level 3 includes all Level 2 tests and introduces additional
 * constraints of an informative nature; these are intended to signal the use of
 * deprecated elements or to encourage alignment with existing (non-normative)
 * standards or conventions.
 *   
 * List of Tables
 *  &lt;ol &gt;
 *  &lt;li&gt;Polygon - rings &lt;/li &gt;
 *  &lt;li&gt;LinearRing - Simple &lt;/li &gt;
 *  &lt;li&gt;BalloonStyle - color &lt;/li &gt;
 *  &lt;li&gt;Metadata &lt;/li &gt;
 *  &lt;li&gt;Scale - full content &lt;/li &gt;
 *  &lt;li&gt;Lod - fade extents &lt;/li &gt;
 *  &lt;li&gt;Orientation - full content &lt;/li &gt;
 *  &lt;li&gt;Snippet &lt;/li &gt;
 *  &lt;li&gt;NetworkLink-Url &lt;/li &gt;
 *  &lt;/ol &gt;
 */
public interface IAtsConformanceLevel3 {

  /**
   * ATC 69: Polygon - rings
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-3/PolygonRings &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; Confirm that no two rings comprising the boundary of a
   * kml:Polygon geometry cross. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail otherwise. The
   * rings may intersect at a single point. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.8.2 &lt;/li &gt;
   *  &lt;li&gt;OpenGIS Geography Markup Language (GML) Encoding Standard: D.3.6 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc69PolygonRings();

  /**
   * ATC 70: LinearRing - Simple
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-3/SimpleLinearRing &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck that a kml:LinearRing is a simple
   * ring (that is, it does not cross itself). &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.8.2 &lt;/li &gt;
   *  &lt;li&gt;OpenGIS Geography Markup Language (GML) Encoding Standard: D.3.6 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc70LinearRingSimple();

  /**
   * ATC 71: BalloonStyle - color
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-3/BalloonStyle-color &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck for any occurrences of the
   * (deprecated) kml:color element in kml:BalloonStyle elements. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if no kml:color elements occur in this context;
   * fail otherwise. This element is deprecated in favour of kml:bgColor. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: Annex A &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc71BaloonStyleColor();

  /**
   * ATC 72: Metadata
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-3/Metadata &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck for any occurrences of the
   * (deprecated) kml:Metadata element. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if no kml:Metadata elements occur; fail otherwise.
   * This element is deprecated in favour of kml:ExtendedData. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: Annex A &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc72Metadata();

  /**
   * ATC 73: Scale - full content
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-3/Scale-Full &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; Verify that a kml:Scale element includes all of the
   * following child elements: kml:x, kml:y, and kml:z. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.12.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc73ScaleFullContent();

  /**
   * ATC 74: Lod - fade extents
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-3/Lod-FadeExtents &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; Verify the following constraint regarding the
   * evaluation of fade extents: kml:minFadeExtent + kml:maxFadeExtent  &lt;=
   * kml:maxLodPixels - kml:minLodPixels. &lt;br/&gt;  &lt;b&gt;Test method: &lt;/b &gt; Pass if the
   * assert ion is satisfied; fail otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 9.18.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc74LodFadeExtents();

  /**
   * ATC 75: Orientation - full content
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-3/Orientation-Full &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; Verify that a kml:Orientation element includes the
   * following child elements: kml:heading, kml:tilt, and kml:roll. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if the assertion is satisfied; fail
   * otherwise. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: cl. 10.11.2 &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc75OrientationFullContent();

  /**
   * ATC 76: Snippet
   *   
   *  &lt;b&gt;Identifier: &lt;/b&gt; http://www.opengis.net/kml/2.2/atc/level-3/Snippet &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck for any occurrences of the
   * (deprecated) kml:Snippet element. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if no kml:Snippet elements occur; fail otherwise.
   * This element is deprecated in favour of kml:snippet. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: Annex A &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc76Snippet();

  /**
   * ATC 77: NetworkLink-Url
   *   
   *  &lt;b&gt;Identifier: &lt;/b &gt;
   * http://www.opengis.net/kml/2.2/atc/level-3/NetworkLink/Url &lt;br/ &gt;
   *  &lt;b&gt;Test purpose: &lt;/b &gt; KmlReferenceCheck for any occurrences of the
   * (deprecated) kml:Url element. &lt;br/ &gt;
   *  &lt;b&gt;Test method: &lt;/b &gt; Pass if no kml:Url elements occur as a child of
   * kml:NetworkLink; fail otherwise. This element is deprecated in favour of
   * kml:Link. &lt;br/ &gt;
   *  &lt;b&gt;Reference: &lt;/b &gt;
   *  &lt;ul &gt;
   *  &lt;li&gt;OGC-07-147r2: Annex A &lt;/li &gt;
   *  &lt;/ul &gt;
   *  &lt;b&gt;Test type: &lt;/b &gt; Basic
   */
  public void atc77NetworkLinkUrl();
}
