package net.opengis.kml;

import net.opengis.kml.internal.IKmlGxReference;
import java.util.ArrayList;
import net.opengis.kml.*;
import net.opengis.kml.gx.*;
import org.junit.Test;

public class KmlGxReferenceApiTest implements IKmlGxReference {

  /**
   * @throws @see de.micromata.jak.internal.IKmlGxReference#altitudeMode()
   */
  @Test
  @Override
  public void altitudeMode() {
    final Kml kml = new Kml();
    Placemark placemark = kml.createAndSetPlacemark().withName("gx:altitudeMode Example");
    placemark.createAndSetLookAt().withLongitude(146.806).withLatitude(12.219).withHeading(-60).withTilt(70).withRange(6300).withAltitudeMode(AltitudeMode.RELATIVE_TO_SEA_FLOOR);
    LineString lineString = placemark.createAndSetLineString().withExtrude(true);
    lineString.withAltitudeMode(AltitudeMode.RELATIVE_TO_SEA_FLOOR);
    lineString.addToCoordinates(146.825, 12.233, 400).addToCoordinates(146.820, 12.222, 400).addToCoordinates(146.812, 12.212, 400)
            .addToCoordinates(146.796, 12.209, 400).addToCoordinates(146.788, 12.205, 400);

    kml.marshal();
  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#altitudeModeReference()
   */
  @Test
  @Override
  public void altitudeModeReference() {
    AnimatedUpdate gxAnimatedUpdate = KmlFactory.createGxAnimatedUpdate();
    gxAnimatedUpdate.withDuration(0.0);
    gxAnimatedUpdate.createAndSetUpdate("...", new ArrayList<Object>()).addToCreateOrDeleteOrChange(new Change())
            .addToCreateOrDeleteOrChange(new Create()).addToCreateOrDeleteOrChange(new Delete());

    Utils.marshal(gxAnimatedUpdate);
  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#animatedUpdate()
   */
  @Test
  @Override
  public void animatedUpdate() {
    Change change = new Change();
    Delete delete = new Delete();
    Create create = new Create();

    AnimatedUpdate animatedUpdate = KmlFactory.createGxAnimatedUpdate().withDuration(0.0);
    animatedUpdate.createAndSetUpdate("...", new ArrayList<Object>())
            .addToCreateOrDeleteOrChange(change)
            .addToCreateOrDeleteOrChange(delete)
            .addToCreateOrDeleteOrChange(create);

    Utils.marshal(animatedUpdate);
  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#animatedUpdateExample()
   */
  @Test
  @Override
  public void animatedUpdateExample() {
    Kml kml = new Kml();
    Document document = kml.createAndSetDocument().withName("gx:AnimatedUpdate example");
    // <!-- Begin Style Definitions -->
    final Style style = document.createAndAddStyle().withId("pushpin");
    style.createAndSetIconStyle().withId("mystyle").withIcon(
            new Icon().withHref("http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png")).withScale(1.0);

    document.createAndAddPlacemark().withId("mountainpin1").withName("Pin on a mountaintop").withStyleUrl("#pushpin").createAndSetPoint()
            .addToCoordinates(170.1435558771009, -43.60505741890396, 0);

    Playlist playlist = document.createAndAddTour().withName("Play me!").createAndSetPlaylist();
    FlyTo flyTo = playlist.createAndAddFlyTo().withFlyToMode(FlyToMode.BOUNCE).withDuration(3);
    flyTo.createAndSetCamera().withLongitude(170.157).withLatitude(-43.671).withAltitude(9700).withHeading(-6.333).withTilt(33.5);

    Change change = new Change()
            .addToAbstractObject(KmlFactory.createIconStyle().withId("mystyle").withTargetId("mystyle").withScale(10.0));

    playlist.createAndAddAnimatedUpdate().withDuration(5).createAndSetUpdate("", new ArrayList<Object>()).addToCreateOrDeleteOrChange(
            change);

    playlist.createAndAddWait().withDuration(5);

    kml.marshal();
  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#balloonVisibilityExample()
   */
  @Test
  @Override
  public void balloonVisibilityExample() {
    Kml kml = new Kml();
    Placemark placemark = kml.createAndSetPlacemark().withName("Eiffel Tower").withDescription("Located in Paris, France. This description balloon opens when the Placemark is loaded.");
    //TODO:  <gx:balloonVisibility>1</gx:balloonVisibility>
    placemark.createAndSetPoint().addToCoordinates(2.294785, 48.858093, 0);
  }

  /**
   * @see
   * de.micromata.jak.internal.IKmlGxReference#balloonVisibilityTourExample()
   */
  @Override
  public void balloonVisibilityTourExample() {

  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#duration()
   */
  @Test
  @Override
  public void duration() {
    KmlFactory.createGxFlyTo().withFlyToMode(FlyToMode.BOUNCE).withDuration(10.2).createAndSetCamera();
    KmlFactory.createGxFlyTo().withFlyToMode(FlyToMode.BOUNCE).withDuration(10.2).createAndSetLookAt();

  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#durationAnimatedUpdate()
   */
  @Test
  @Override
  public void durationAnimatedUpdate() {
    KmlFactory.createGxFlyTo().withDuration(5).addToObjectSimpleExtension(new Update("....", new ArrayList<Object>()));
  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#flyto()
   */
  @Test
  @Override
  public void flyto() {
    KmlFactory.createGxFlyTo().withFlyToMode(FlyToMode.BOUNCE).withDuration(0.0).createAndSetCamera();
    KmlFactory.createGxFlyTo().withFlyToMode(FlyToMode.BOUNCE).withDuration(0.0).createAndSetLookAt();
  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#flytoExample()
   */
  @Test
  @Override
  public void flytoExample() {
    FlyTo flyTo = KmlFactory.createGxFlyTo().withFlyToMode(FlyToMode.SMOOTH).withDuration(2.55);
    flyTo.createAndSetCamera().withLongitude(-113.084448).withLatitude(36.567081).withAltitude(41277.571403).withHeading(116.150227).withAltitudeMode(AltitudeMode.ABSOLUTE);
  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#latLonQuad()
   */
  @Test
  @Override
  public void latLonQuad() {
    GroundOverlay groundOverlay = KmlFactory.createGroundOverlay().withId("ID");
    groundOverlay.createAndSetIcon().withHref("...");
    groundOverlay.withAltitude(0).withAltitudeMode(AltitudeMode.CLAMP_TO_GROUND);
    LatLonQuad latLonQuad = KmlFactory.createGxLatLonQuad().addToCoordinates(0, 0, 0);
    groundOverlay.addToFeatureObjectExtension(latLonQuad);

    Utils.marshal(groundOverlay);
  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#latLonQuadExample()
   */
  @Override
  public void latLonQuadExample() {

  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#playlist()
   */
  @Override
  public void playlist() {

  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#soundCue()
   */
  @Override
  public void soundCue() {

  }

  /**
   * @see
   * de.micromata.jak.internal.IKmlGxReference#timeSpanAndGxTimeStampExample()
   */
  @Override
  public void timeSpanAndGxTimeStampExample() {

  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#tour()
   */
  @Override
  public void tour() {

  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#tourControl()
   */
  @Override
  public void tourControl() {

  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#tourPrimitive()
   */
  @Override
  public void tourPrimitive() {

  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#tourPrimitiveExample()
   */
  @Override
  public void tourPrimitiveExample() {

  }

  /**
   * @see de.micromata.jak.internal.IKmlGxReference#waitgx()
   */
  @Override
  public void waitgx() {

  }

}
