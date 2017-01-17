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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.opengis.kml;

import java.util.List;
import net.opengis.kml.atom.Author;
import net.opengis.kml.gx.*;
import net.opengis.kml.xal.*;

/**
 * Factory functions to create all KML complex elements.
 * <p>
 */
public final class KmlFactory {

  /**
   * Create an instance of {@link Alias}
   * <p>
   */
  public static Alias createAlias() {
    return new Alias();
  }

  /**
   * Create an instance of {@link BalloonStyle}
   * <p>
   */
  public static BalloonStyle createBalloonStyle() {
    return new BalloonStyle();
  }

  /**
   * Create an instance of {@link BasicLink}
   * <p>
   */
  public static BasicLink createBasicLink() {
    return new BasicLink();
  }

  /**
   * Create an instance of {@link Boundary}
   * <p>
   */
  public static Boundary createBoundary() {
    return new Boundary();
  }

  /**
   * Create an instance of {@link Camera}
   * <p>
   */
  public static Camera createCamera() {
    return new Camera();
  }

  /**
   * Create an instance of {@link Change}
   * <p>
   */
  public static Change createChange() {
    return new Change();
  }

  /**
   * Create an instance of {@link Coordinate}
   *
   * @param longitude required parameter
   * @param latitude  required parameter
   */
  public static Coordinate createCoordinate(final double longitude, final double latitude) {
    return new Coordinate(longitude, latitude);
  }

  /**
   * Create an instance of {@link Coordinate}
   *
   * @param longitude required parameter
   * @param latitude  required parameter
   * @param altitude  required parameter
   */
  public static Coordinate createCoordinate(final double longitude, final double latitude, final double altitude) {
    return new Coordinate(longitude, latitude, altitude);
  }

  /**
   * Create an instance of {@link Coordinate}
   *
   * @param coordinates required parameter
   */
  public static Coordinate createCoordinate(final String coordinates) {
    return new Coordinate(coordinates);
  }

  /**
   * Create an instance of {@link Create}
   * <p>
   */
  public static Create createCreate() {
    return new Create();
  }

  /**
   * Create an instance of {@link Data}
   *
   * @param value required parameter
   */
  public static Data createData(final String value) {
    return new Data(value);
  }

  /**
   * Create an instance of {@link Delete}
   * <p>
   */
  public static Delete createDelete() {
    return new Delete();
  }

  /**
   * Create an instance of {@link Document}
   * <p>
   */
  public static Document createDocument() {
    return new Document();
  }

  /**
   * Create an instance of {@link ExtendedData}
   * <p>
   */
  public static ExtendedData createExtendedData() {
    return new ExtendedData();
  }

  /**
   * Create an instance of {@link Folder}
   * <p>
   */
  public static Folder createFolder() {
    return new Folder();
  }

  /**
   * Create an instance of {@link GroundOverlay}
   * <p>
   */
  public static GroundOverlay createGroundOverlay() {
    return new GroundOverlay();
  }

  /**
   * Create an instance of {@link Icon}
   * <p>
   */
  public static Icon createIcon() {
    return new Icon();
  }

  /**
   * Create an instance of {@link IconStyle}
   * <p>
   */
  public static IconStyle createIconStyle() {
    return new IconStyle();
  }

  /**
   * Create an instance of {@link ImagePyramid}
   * <p>
   */
  public static ImagePyramid createImagePyramid() {
    return new ImagePyramid();
  }

  /**
   * Create an instance of {@link ItemIcon}
   * <p>
   */
  public static ItemIcon createItemIcon() {
    return new ItemIcon();
  }

  /**
   * Create an instance of {@link Kml}
   * <p>
   */
  public static Kml createKml() {
    return new Kml();
  }

  /**
   * Create an instance of {@link LabelStyle}
   * <p>
   */
  public static LabelStyle createLabelStyle() {
    return new LabelStyle();
  }

  /**
   * Create an instance of {@link LatLonAltBox}
   * <p>
   */
  public static LatLonAltBox createLatLonAltBox() {
    return new LatLonAltBox();
  }

  /**
   * Create an instance of {@link LatLonBox}
   * <p>
   */
  public static LatLonBox createLatLonBox() {
    return new LatLonBox();
  }

  /**
   * Create an instance of {@link LineString}
   * <p>
   */
  public static LineString createLineString() {
    return new LineString();
  }

  /**
   * Create an instance of {@link LineStyle}
   * <p>
   */
  public static LineStyle createLineStyle() {
    return new LineStyle();
  }

  /**
   * Create an instance of {@link LinearRing}
   * <p>
   */
  public static LinearRing createLinearRing() {
    return new LinearRing();
  }

  /**
   * Create an instance of {@link net.opengis.kml.Link}
   * <p>
   */
  public static net.opengis.kml.Link createLink() {
    return new net.opengis.kml.Link();
  }

  /**
   * Create an instance of {@link ListStyle}
   * <p>
   */
  public static ListStyle createListStyle() {
    return new ListStyle();
  }

  /**
   * Create an instance of {@link Location}
   * <p>
   */
  public static Location createLocation() {
    return new Location();
  }

  /**
   * Create an instance of {@link Lod}
   * <p>
   */
  public static Lod createLod() {
    return new Lod();
  }

  /**
   * Create an instance of {@link LookAt}
   * <p>
   */
  public static LookAt createLookAt() {
    return new LookAt();
  }

  /**
   * Create an instance of {@link Metadata}
   * <p>
   */
  public static Metadata createMetadata() {
    return new Metadata();
  }

  /**
   * Create an instance of {@link Model}
   * <p>
   */
  public static Model createModel() {
    return new Model();
  }

  /**
   * Create an instance of {@link MultiGeometry}
   * <p>
   */
  public static MultiGeometry createMultiGeometry() {
    return new MultiGeometry();
  }

  /**
   * Create an instance of {@link NetworkLink}
   * <p>
   */
  public static NetworkLink createNetworkLink() {
    return new NetworkLink();
  }

  /**
   * Create an instance of {@link NetworkLinkControl}
   * <p>
   */
  public static NetworkLinkControl createNetworkLinkControl() {
    return new NetworkLinkControl();
  }

  /**
   * Create an instance of {@link Orientation}
   * <p>
   */
  public static Orientation createOrientation() {
    return new Orientation();
  }

  /**
   * Create an instance of {@link Pair}
   * <p>
   */
  public static Pair createPair() {
    return new Pair();
  }

  /**
   * Create an instance of {@link PhotoOverlay}
   * <p>
   */
  public static PhotoOverlay createPhotoOverlay() {
    return new PhotoOverlay();
  }

  /**
   * Create an instance of {@link Placemark}
   * <p>
   */
  public static Placemark createPlacemark() {
    return new Placemark();
  }

  /**
   * Create an instance of {@link Point}
   * <p>
   */
  public static Point createPoint() {
    return new Point();
  }

  /**
   * Create an instance of {@link PolyStyle}
   * <p>
   */
  public static PolyStyle createPolyStyle() {
    return new PolyStyle();
  }

  /**
   * Create an instance of {@link Polygon}
   * <p>
   */
  public static Polygon createPolygon() {
    return new Polygon();
  }

  /**
   * Create an instance of {@link Region}
   * <p>
   */
  public static Region createRegion() {
    return new Region();
  }

  /**
   * Create an instance of {@link ResourceMap}
   * <p>
   */
  public static ResourceMap createResourceMap() {
    return new ResourceMap();
  }

  /**
   * Create an instance of {@link Scale}
   * <p>
   */
  public static Scale createScale() {
    return new Scale();
  }

  /**
   * Create an instance of {@link Schema}
   * <p>
   */
  public static Schema createSchema() {
    return new Schema();
  }

  /**
   * Create an instance of {@link SchemaData}
   * <p>
   */
  public static SchemaData createSchemaData() {
    return new SchemaData();
  }

  /**
   * Create an instance of {@link ScreenOverlay}
   * <p>
   */
  public static ScreenOverlay createScreenOverlay() {
    return new ScreenOverlay();
  }

  /**
   * Create an instance of {@link SimpleData}
   *
   * @param name required parameter
   */
  public static SimpleData createSimpleData(final String name) {
    return new SimpleData(name);
  }

  /**
   * Create an instance of {@link SimpleField}
   * <p>
   */
  public static SimpleField createSimpleField() {
    return new SimpleField();
  }

  /**
   * Create an instance of {@link Snippet}
   * <p>
   */
  public static Snippet createSnippet() {
    return new Snippet();
  }

  /**
   * Create an instance of {@link Style}
   * <p>
   */
  public static Style createStyle() {
    return new Style();
  }

  /**
   * Create an instance of {@link StyleMap}
   * <p>
   */
  public static StyleMap createStyleMap() {
    return new StyleMap();
  }

  /**
   * Create an instance of {@link TimeSpan}
   * <p>
   */
  public static TimeSpan createTimeSpan() {
    return new TimeSpan();
  }

  /**
   * Create an instance of {@link TimeStamp}
   * <p>
   */
  public static TimeStamp createTimeStamp() {
    return new TimeStamp();
  }

  /**
   * Create an instance of {@link Update}
   *
   * @param createOrDeleteOrChange required parameter
   * @param targetHref             required parameter
   */
  public static Update createUpdate(final String targetHref, final List<Object> createOrDeleteOrChange) {
    return new Update(targetHref, createOrDeleteOrChange);
  }

  /**
   * Create an instance of {@link Vec2}
   * <p>
   */
  public static Vec2 createVec2() {
    return new Vec2();
  }

  /**
   * Create an instance of {@link ViewVolume}
   * <p>
   */
  public static ViewVolume createViewVolume() {
    return new ViewVolume();
  }

  /**
   * Create an instance of {@link Author}
   * <p>
   */
  public static Author createAtomAuthor() {
    return new Author();
  }

  /**
   * Create an instance of {@link net.opengis.kml.atom.Link}
   *
   * @param href required parameter
   */
  public static net.opengis.kml.atom.Link createAtomLink(final String href) {
    return new net.opengis.kml.atom.Link(href);
  }

  /**
   * Create an instance of {@link AnimatedUpdate}
   * <p>
   */
  public static AnimatedUpdate createGxAnimatedUpdate() {
    return new AnimatedUpdate();
  }

  /**
   * Create an instance of {@link FlyTo}
   * <p>
   */
  public static FlyTo createGxFlyTo() {
    return new FlyTo();
  }

  /**
   * Create an instance of {@link LatLonQuad}
   * <p>
   */
  public static LatLonQuad createGxLatLonQuad() {
    return new LatLonQuad();
  }

  /**
   * Create an instance of {@link MultiTrack}
   * <p>
   */
  public static MultiTrack createGxMultiTrack() {
    return new MultiTrack();
  }

  /**
   * Create an instance of {@link Option}
   * <p>
   */
  public static Option createGxOption() {
    return new Option();
  }

  /**
   * Create an instance of {@link Playlist}
   * <p>
   */
  public static Playlist createGxPlaylist() {
    return new Playlist();
  }

  /**
   * Create an instance of {@link SimpleArrayData}
   * <p>
   */
  public static SimpleArrayData createGxSimpleArrayData() {
    return new SimpleArrayData();
  }

  /**
   * Create an instance of {@link SimpleArrayField}
   * <p>
   */
  public static SimpleArrayField createGxSimpleArrayField() {
    return new SimpleArrayField();
  }

  /**
   * Create an instance of {@link SoundCue}
   * <p>
   */
  public static SoundCue createGxSoundCue() {
    return new SoundCue();
  }

  /**
   * Create an instance of {@link Tour}
   * <p>
   */
  public static Tour createGxTour() {
    return new Tour();
  }

  /**
   * Create an instance of {@link TourControl}
   * <p>
   */
  public static TourControl createGxTourControl() {
    return new TourControl();
  }

  /**
   * Create an instance of {@link Track}
   * <p>
   */
  public static Track createGxTrack() {
    return new Track();
  }

  /**
   * Create an instance of {@link ViewerOptions}
   *
   * @param option required parameter
   */
  public static ViewerOptions createGxViewerOptions(final List<Option> option) {
    return new ViewerOptions(option);
  }

  /**
   * Create an instance of {@link Wait}
   * <p>
   */
  public static Wait createGxWait() {
    return new Wait();
  }

  /**
   * Create an instance of {@link AddressDetails}
   *
   * @param xalAddress         required parameter
   * @param addressLines       required parameter
   * @param country            required parameter
   * @param locality           required parameter
   * @param administrativeArea required parameter
   * @param thoroughfare       required parameter
   */
  public static AddressDetails createXalAddressDetails(final AddressDetails.Address xalAddress, final AddressLines addressLines, final AddressDetails.Country country, final AdministrativeArea administrativeArea, final Locality locality, final Thoroughfare thoroughfare) {
    return new AddressDetails(xalAddress, addressLines, country, administrativeArea, locality, thoroughfare);
  }

  /**
   * Create an instance of {@link AddressLine}
   * <p>
   */
  public static AddressLine createXalAddressLine() {
    return new AddressLine();
  }

  /**
   * Create an instance of {@link AddressLines}
   *
   * @param addressLine required parameter
   */
  public static AddressLines createXalAddressLines(final List<AddressLine> addressLine) {
    return new AddressLines(addressLine);
  }

  /**
   * Create an instance of {@link AdministrativeArea}
   *
   * @param postalCode required parameter
   * @param locality   required parameter
   * @param postOffice required parameter
   */
  public static AdministrativeArea createXalAdministrativeArea(final Locality locality, final PostOffice postOffice, final PostalCode postalCode) {
    return new AdministrativeArea(locality, postOffice, postalCode);
  }

  /**
   * Create an instance of {@link BuildingName}
   * <p>
   */
  public static BuildingName createXalBuildingName() {
    return new BuildingName();
  }

  /**
   * Create an instance of {@link CountryName}
   * <p>
   */
  public static CountryName createXalCountryName() {
    return new CountryName();
  }

  /**
   * Create an instance of {@link Department}
   * <p>
   */
  public static Department createXalDepartment() {
    return new Department();
  }

  /**
   * Create an instance of {@link DependentLocality}
   *
   * @param postBox       required parameter
   * @param postOffice    required parameter
   * @param postalRoute   required parameter
   * @param largeMailUser required parameter
   */
  public static DependentLocality createXalDependentLocality(final PostBox postBox, final LargeMailUser largeMailUser, final PostOffice postOffice, final PostalRoute postalRoute) {
    return new DependentLocality(postBox, largeMailUser, postOffice, postalRoute);
  }

  /**
   * Create an instance of {@link Firm}
   * <p>
   */
  public static Firm createXalFirm() {
    return new Firm();
  }

  /**
   * Create an instance of {@link LargeMailUser}
   * <p>
   */
  public static LargeMailUser createXalLargeMailUser() {
    return new LargeMailUser();
  }

  /**
   * Create an instance of {@link Locality}
   *
   * @param postBox       required parameter
   * @param postOffice    required parameter
   * @param postalRoute   required parameter
   * @param largeMailUser required parameter
   */
  public static Locality createXalLocality(final PostBox postBox, final LargeMailUser largeMailUser, final PostOffice postOffice, final PostalRoute postalRoute) {
    return new Locality(postBox, largeMailUser, postOffice, postalRoute);
  }

  /**
   * Create an instance of {@link MailStop}
   * <p>
   */
  public static MailStop createXalMailStop() {
    return new MailStop();
  }

  /**
   * Create an instance of {@link PostBox}
   *
   * @param postBoxNumber required parameter
   */
  public static PostBox createXalPostBox(final PostBox.PostBoxNumber postBoxNumber) {
    return new PostBox(postBoxNumber);
  }

  /**
   * Create an instance of {@link PostOffice}
   * <p>
   */
  public static PostOffice createXalPostOffice() {
    return new PostOffice();
  }

  /**
   * Create an instance of {@link PostalCode}
   * <p>
   */
  public static PostalCode createXalPostalCode() {
    return new PostalCode();
  }

  /**
   * Create an instance of {@link PostalRoute}
   *
   * @param postalRouteName   required parameter
   * @param postalRouteNumber required parameter
   */
  public static PostalRoute createXalPostalRoute(final List<PostalRoute.PostalRouteName> postalRouteName, final PostalRoute.PostalRouteNumber postalRouteNumber) {
    return new PostalRoute(postalRouteName, postalRouteNumber);
  }

  /**
   * Create an instance of {@link Premise}
   *
   * @param premiseNumber      required parameter
   * @param premiseNumberRange required parameter
   * @param premiseLocation    required parameter
   */
  public static Premise createXalPremise(final Premise.PremiseLocation premiseLocation, final List<PremiseNumber> premiseNumber, final Premise.PremiseNumberRange premiseNumberRange) {
    return new Premise(premiseLocation, premiseNumber, premiseNumberRange);
  }

  /**
   * Create an instance of {@link PremiseNumber}
   * <p>
   */
  public static PremiseNumber createXalPremiseNumber() {
    return new PremiseNumber();
  }

  /**
   * Create an instance of {@link PremiseNumberPrefix}
   * <p>
   */
  public static PremiseNumberPrefix createXalPremiseNumberPrefix() {
    return new PremiseNumberPrefix();
  }

  /**
   * Create an instance of {@link PremiseNumberSuffix}
   * <p>
   */
  public static PremiseNumberSuffix createXalPremiseNumberSuffix() {
    return new PremiseNumberSuffix();
  }

  /**
   * Create an instance of {@link SubPremise}
   *
   * @param subPremiseLocation required parameter
   */
  public static SubPremise createXalSubPremise(final SubPremise.SubPremiseLocation subPremiseLocation) {
    return new SubPremise(subPremiseLocation);
  }

  /**
   * Create an instance of {@link Thoroughfare}
   *
   * @param postalCode        required parameter
   * @param premise           required parameter
   * @param firm              required parameter
   * @param dependentLocality required parameter
   */
  public static Thoroughfare createXalThoroughfare(final DependentLocality dependentLocality, final Premise premise, final Firm firm, final PostalCode postalCode) {
    return new Thoroughfare(dependentLocality, premise, firm, postalCode);
  }

  /**
   * Create an instance of {@link ThoroughfareLeadingType}
   * <p>
   */
  public static ThoroughfareLeadingType createXalThoroughfareLeadingType() {
    return new ThoroughfareLeadingType();
  }

  /**
   * Create an instance of {@link ThoroughfareName}
   * <p>
   */
  public static ThoroughfareName createXalThoroughfareName() {
    return new ThoroughfareName();
  }

  /**
   * Create an instance of {@link ThoroughfareNumber}
   * <p>
   */
  public static ThoroughfareNumber createXalThoroughfareNumber() {
    return new ThoroughfareNumber();
  }

  /**
   * Create an instance of {@link ThoroughfareNumberPrefix}
   * <p>
   */
  public static ThoroughfareNumberPrefix createXalThoroughfareNumberPrefix() {
    return new ThoroughfareNumberPrefix();
  }

  /**
   * Create an instance of {@link ThoroughfareNumberSuffix}
   * <p>
   */
  public static ThoroughfareNumberSuffix createXalThoroughfareNumberSuffix() {
    return new ThoroughfareNumberSuffix();
  }

  /**
   * Create an instance of {@link ThoroughfarePostDirection}
   * <p>
   */
  public static ThoroughfarePostDirection createXalThoroughfarePostDirection() {
    return new ThoroughfarePostDirection();
  }

  /**
   * Create an instance of {@link ThoroughfarePreDirection}
   * <p>
   */
  public static ThoroughfarePreDirection createXalThoroughfarePreDirection() {
    return new ThoroughfarePreDirection();
  }

  /**
   * Create an instance of {@link ThoroughfareTrailingType}
   * <p>
   */
  public static ThoroughfareTrailingType createXalThoroughfareTrailingType() {
    return new ThoroughfareTrailingType();
  }

  /**
   * Create an instance of {@link XAL}
   *
   * @param xalAddressDetails required parameter
   */
  public static XAL createXalXAL(final List<AddressDetails> xalAddressDetails) {
    return new XAL(xalAddressDetails);
  }

}
