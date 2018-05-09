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
import net.opengis.kml.atom.Author;
import net.opengis.kml.atom.Link;
import net.opengis.kml.xal.AddressDetails;

/**
 * &lt;PhotoOverlay&gt;
 * <p>
 * Because &lt;PhotoOverlay&gt; is derived from &lt;Feature&gt;, it can contain
 * one of the two elements derived from &lt;AbstractView&gt;—either
 * &lt;Camera&gt; or &lt;LookAt&gt;. The Camera (or LookAt) specifies a
 * viewpoint and a viewing direction (also referred to as a view vector). The
 * PhotoOverlay is positioned in relation to the viewpoint. Specifically, the
 * plane of a 2D rectangular image is orthogonal (at right angles to) the view
 * vector. The normal of this plane—that is, its front, which is the part with
 * the photo—is oriented toward the viewpoint. For more information, see the
 * "Topics in KML" page on PhotoOverlay. The &lt;PhotoOverlay&gt; element allows
 * you to geographically locate a photograph on the Earth and to specify viewing
 * parameters for this PhotoOverlay. The PhotoOverlay can be a simple 2D
 * rectangle, a partial or full cylinder, or a sphere (for spherical panoramas).
 * The overlay is placed at the specified location and oriented toward the
 * viewpoint. The URL for the PhotoOverlay image is specified in the
 * &lt;Icon&gt; tag, which is inherited from &lt;Overlay&gt;. The &lt;Icon&gt;
 * tag must contain an &lt;href&gt; element that specifies the image file to use
 * for the PhotoOverlay. In the case of a very large image, the &lt;href&gt; is
 * a special URL that indexes into a pyramid of images of varying resolutions
 * (see ImagePyramid). Extends:
 *
 * @see: &lt;Overlay&gt;
 *
 * Contained By:
 * @see: &lt;Document&gt;
 * @see: &lt;Folder&gt;
 * @see: &lt;kml&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhotoOverlayType", propOrder = {
  "rotation",
  "viewVolume",
  "imagePyramid",
  "point",
  "shape",
  "photoOverlaySimpleExtension",
  "photoOverlayObjectExtension"
})
@XmlRootElement(name = "PhotoOverlay", namespace = "http://www.opengis.net/kml/2.2")
public class PhotoOverlay
  extends Overlay
  implements Cloneable {

  /**
   * &lt;rotation&gt;
   * <p>
   * Adjusts how the photo is placed inside the field of view. This element is
   * useful if your photo has been rotated and deviates slightly from a desired
   * horizontal view. Indicates the angle of rotation of the parent object. A
   * value of 0 means no rotation. The value is an angle in degrees
   * counterclockwise starting from north. Use ±180 to indicate the rotation of
   * the parent object from 0. The center of the &lt;rotation&gt;, if not
   * (.5,.5), is specified in &lt;rotationXY&gt;.
   */
  @XmlElement(defaultValue = "0.0")
  protected double rotation;
  /**
   * &lt;viewvolume&gt;
   * <p>
   * Defines how much of the current scene is visible. Specifying the field of
   * view is analogous to specifying the lens opening in a physical camera. A
   * small field of view, like a telephoto lens, focuses on a small part of the
   * scene. A large field of view, like a wide-angle lens, focuses on a large
   * part of the scene.
   */
  @XmlElement(name = "ViewVolume")
  protected ViewVolume viewVolume;
  /**
   * &lt;imagepyramid&gt;
   * <p>
   * For very large images, you'll need to construct an image pyramid, which is
   * a hierarchical set of images, each of which is an increasingly lower
   * resolution version of the original image. Each image in the pyramid is
   * subdivided into tiles, so that only the portions in view need to be loaded.
   * Google Earth calculates the current viewpoint and loads the tiles that are
   * appropriate to the user's distance from the image. As the viewpoint moves
   * closer to the PhotoOverlay, Google Earth loads higher resolution tiles.
   * Since all the pixels in the original image can't be viewed on the screen at
   * once, this preprocessing allows Google Earth to achieve maximum performance
   * because it loads only the portions of the image that are in view, and only
   * the pixel details that can be discerned by the user at the current
   * viewpoint. When you specify an image pyramid, you also modify the
   * &lt;href&gt; in the &lt;Icon&gt; element to include specifications for
   * which tiles to load.
   */
  @XmlElement(name = "ImagePyramid")
  protected ImagePyramid imagePyramid;
  /**
   * &lt;Point&gt;
   * <p>
   * A geographic location defined by longitude, latitude, and (optional)
   * altitude. When a Point is contained by a Placemark, the point itself
   * determines the position of the Placemark's name and icon. When a Point is
   * extruded, it is connected to the ground with a line. This "tether" uses the
   * current LineStyle. The &lt;Point&gt; element acts as a &lt;Point&gt; inside
   * a &lt;Placemark&gt; element. It draws an icon to mark the position of the
   * PhotoOverlay. The icon drawn is specified by the &lt;styleUrl&gt; and
   * &lt;StyleSelector&gt; fields, just as it is for &lt;Placemark&gt;. Syntax:
   * &lt;pre&gt; &lt;strong&gt;&lt;Point id="ID"&gt; &lt;/strong&gt; &lt;!--
   * specific to Point --&gt; &lt;extrude&gt;0&lt;/extrude&gt; &lt;!-- boolean
   * --&gt; &lt;altitudeMode&gt;clampToGround&lt;/altitudeMode&gt; &lt;!--
   * kml:altitudeModeEnum: clampToGround, relativeToGround, or absolute --&gt;
   * &lt;!-- or, substitute gx:altitudeMode: clampToSeaFloor, relativeToSeaFloor
   * --&gt; &lt;coordinates&gt; &lt;em&gt;... &lt;/em&gt;&lt;/coordinates&gt;
   * &lt;span class="style1"&gt; &lt;em&gt; &lt;/em&gt; &lt;/span&gt;&lt;!--
   * lon,lat[,alt] --&gt; &lt;strong&gt;&lt;/Point&gt; &lt;/strong&gt; </pre>
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
  @XmlElement(name = "Point")
  protected Point point;
  /**
   * Shape
   * <p>
   * rectangle, cylinder, sphere See Also: See &lt;PhotoOverlay&gt;
   * <p>
   */
  @XmlElement(defaultValue = "rectangle")
  protected Shape shape;
  @XmlElement(name = "PhotoOverlaySimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> photoOverlaySimpleExtension;
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
  @XmlElement(name = "PhotoOverlayObjectExtensionGroup")
  protected List<AbstractObject> photoOverlayObjectExtension;

  public PhotoOverlay() {
    super();
  }

  /**
   * @see rotation
   *
   * @return possible object is {@code Double}
   *
   */
  public double getRotation() {
    return rotation;
  }

  /**
   * @see rotation
   *
   * @param value allowed object is {@code Double}
   *
   */
  public void setRotation(double value) {
    this.rotation = value;
  }

  /**
   * @see viewVolume
   *
   * @return possible object is {@code ViewVolume}
   *
   */
  public ViewVolume getViewVolume() {
    return viewVolume;
  }

  /**
   * @see viewVolume
   *
   * @param value allowed object is {@code ViewVolume}
   *
   */
  public void setViewVolume(ViewVolume value) {
    this.viewVolume = value;
  }

  /**
   * @see imagePyramid
   *
   * @return possible object is {@code ImagePyramid}
   *
   */
  public ImagePyramid getImagePyramid() {
    return imagePyramid;
  }

  /**
   * @see imagePyramid
   *
   * @param value allowed object is {@code ImagePyramid}
   *
   */
  public void setImagePyramid(ImagePyramid value) {
    this.imagePyramid = value;
  }

  /**
   * @see point
   *
   * @return possible object is {@code Point}
   *
   */
  public Point getPoint() {
    return point;
  }

  /**
   * @see point
   *
   * @param value allowed object is {@code Point}
   *
   */
  public void setPoint(Point value) {
    this.point = value;
  }

  /**
   * @see shape
   *
   * @return possible object is {@code Shape}
   *
   */
  public Shape getShape() {
    return shape;
  }

  /**
   * @see shape
   *
   * @param value allowed object is {@code Shape}
   *
   */
  public void setShape(Shape value) {
    this.shape = value;
  }

  /**
   * @see photoOverlaySimpleExtension
   *
   */
  public List<Object> getPhotoOverlaySimpleExtension() {
    if (photoOverlaySimpleExtension == null) {
      photoOverlaySimpleExtension = new ArrayList<>();
    }
    return this.photoOverlaySimpleExtension;
  }

  /**
   * @see photoOverlayObjectExtension
   *
   */
  public List<AbstractObject> getPhotoOverlayObjectExtension() {
    if (photoOverlayObjectExtension == null) {
      photoOverlayObjectExtension = new ArrayList<>();
    }
    return this.photoOverlayObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    long temp;
    temp = Double.doubleToLongBits(rotation);
    result = ((prime * result) + ((int) (temp ^ (temp >>> (32)))));
    result = ((prime * result) + ((viewVolume == null) ? 0 : viewVolume.hashCode()));
    result = ((prime * result) + ((imagePyramid == null) ? 0 : imagePyramid.hashCode()));
    result = ((prime * result) + ((point == null) ? 0 : point.hashCode()));
    result = ((prime * result) + ((shape == null) ? 0 : shape.hashCode()));
    result = ((prime * result) + ((photoOverlaySimpleExtension == null) ? 0 : photoOverlaySimpleExtension.hashCode()));
    result = ((prime * result) + ((photoOverlayObjectExtension == null) ? 0 : photoOverlayObjectExtension.hashCode()));
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
    if ((obj instanceof PhotoOverlay) == false) {
      return false;
    }
    PhotoOverlay other = ((PhotoOverlay) obj);
    if (rotation != other.rotation) {
      return false;
    }
    if (viewVolume == null) {
      if (other.viewVolume != null) {
        return false;
      }
    } else if (viewVolume.equals(other.viewVolume) == false) {
      return false;
    }
    if (imagePyramid == null) {
      if (other.imagePyramid != null) {
        return false;
      }
    } else if (imagePyramid.equals(other.imagePyramid) == false) {
      return false;
    }
    if (point == null) {
      if (other.point != null) {
        return false;
      }
    } else if (point.equals(other.point) == false) {
      return false;
    }
    if (shape == null) {
      if (other.shape != null) {
        return false;
      }
    } else if (shape.equals(other.shape) == false) {
      return false;
    }
    if (photoOverlaySimpleExtension == null) {
      if (other.photoOverlaySimpleExtension != null) {
        return false;
      }
    } else if (photoOverlaySimpleExtension.equals(other.photoOverlaySimpleExtension) == false) {
      return false;
    }
    if (photoOverlayObjectExtension == null) {
      if (other.photoOverlayObjectExtension != null) {
        return false;
      }
    } else if (photoOverlayObjectExtension.equals(other.photoOverlayObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code ViewVolume} and set it to viewVolume.
   * <p>
   * This method is a short version for: &lt;code&gt; ViewVolume viewVolume =
   * new ViewVolume(); this.setViewVolume(viewVolume); &lt;/code&gt;
   */
  public ViewVolume createAndSetViewVolume() {
    ViewVolume newValue = new ViewVolume();
    this.setViewVolume(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code ImagePyramid} and set it to imagePyramid.
   * <p>
   * This method is a short version for: &lt;code&gt; ImagePyramid imagePyramid
   * = new ImagePyramid(); this.setImagePyramid(imagePyramid); &lt;/code&gt;
   */
  public ImagePyramid createAndSetImagePyramid() {
    ImagePyramid newValue = new ImagePyramid();
    this.setImagePyramid(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Point} and set it to point.
   * <p>
   * This method is a short version for: &lt;code&gt; Point point = new Point();
   * this.setPoint(point); &lt;/code&gt;
   */
  public Point createAndSetPoint() {
    Point newValue = new Point();
    this.setPoint(newValue);
    return newValue;
  }

  /**
   * @see photoOverlaySimpleExtension
   *
   * @param photoOverlaySimpleExtension
   */
  public void setPhotoOverlaySimpleExtension(final List<Object> photoOverlaySimpleExtension) {
    this.photoOverlaySimpleExtension = photoOverlaySimpleExtension;
  }

  /**
   * add a value to the photoOverlaySimpleExtension property collection
   *
   * @param photoOverlaySimpleExtension Objects of the following type are
   *                                    allowed in the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public PhotoOverlay addToPhotoOverlaySimpleExtension(final Object photoOverlaySimpleExtension) {
    this.getPhotoOverlaySimpleExtension().add(photoOverlaySimpleExtension);
    return this;
  }

  /**
   * @see photoOverlayObjectExtension
   *
   * @param photoOverlayObjectExtension
   */
  public void setPhotoOverlayObjectExtension(final List<AbstractObject> photoOverlayObjectExtension) {
    this.photoOverlayObjectExtension = photoOverlayObjectExtension;
  }

  /**
   * add a value to the photoOverlayObjectExtension property collection
   *
   * @param photoOverlayObjectExtension Objects of the following type are
   *                                    allowed in the list:
   *                                    {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public PhotoOverlay addToPhotoOverlayObjectExtension(final AbstractObject photoOverlayObjectExtension) {
    this.getPhotoOverlayObjectExtension().add(photoOverlayObjectExtension);
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
  public PhotoOverlay addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public PhotoOverlay addToStyleSelector(final StyleSelector styleSelector) {
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
  public PhotoOverlay addToFeatureSimpleExtension(final Object featureSimpleExtension) {
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
  public PhotoOverlay addToFeatureObjectExtension(final AbstractObject featureObjectExtension) {
    super.getFeatureObjectExtension().add(featureObjectExtension);
    return this;
  }

  /**
   * @see overlaySimpleExtension
   *
   */
  @Obvious
  @Override
  public void setOverlaySimpleExtension(final List<Object> overlaySimpleExtension) {
    super.setOverlaySimpleExtension(overlaySimpleExtension);
  }

  @Obvious
  @Override
  public PhotoOverlay addToOverlaySimpleExtension(final Object overlaySimpleExtension) {
    super.getOverlaySimpleExtension().add(overlaySimpleExtension);
    return this;
  }

  /**
   * @see overlayObjectExtension
   *
   */
  @Obvious
  @Override
  public void setOverlayObjectExtension(final List<AbstractObject> overlayObjectExtension) {
    super.setOverlayObjectExtension(overlayObjectExtension);
  }

  @Obvious
  @Override
  public PhotoOverlay addToOverlayObjectExtension(final AbstractObject overlayObjectExtension) {
    super.getOverlayObjectExtension().add(overlayObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setRotation(double)
   *
   * @param rotation required parameter
   */
  public PhotoOverlay withRotation(final double rotation) {
    this.setRotation(rotation);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setViewVolume(ViewVolume)
   *
   * @param viewVolume required parameter
   */
  public PhotoOverlay withViewVolume(final ViewVolume viewVolume) {
    this.setViewVolume(viewVolume);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setImagePyramid(ImagePyramid)
   *
   * @param imagePyramid required parameter
   */
  public PhotoOverlay withImagePyramid(final ImagePyramid imagePyramid) {
    this.setImagePyramid(imagePyramid);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPoint(Point)
   *
   * @param point required parameter
   */
  public PhotoOverlay withPoint(final Point point) {
    this.setPoint(point);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setShape(Shape)
   *
   * @param shape required parameter
   */
  public PhotoOverlay withShape(final Shape shape) {
    this.setShape(shape);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPhotoOverlaySimpleExtension(List &lt;Object&gt;)
   *
   * @param photoOverlaySimpleExtension required parameter
   */
  public PhotoOverlay withPhotoOverlaySimpleExtension(final List<Object> photoOverlaySimpleExtension) {
    this.setPhotoOverlaySimpleExtension(photoOverlaySimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setPhotoOverlayObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param photoOverlayObjectExtension required parameter
   */
  public PhotoOverlay withPhotoOverlayObjectExtension(final List<AbstractObject> photoOverlayObjectExtension) {
    this.setPhotoOverlayObjectExtension(photoOverlayObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withName(final String name) {
    super.withName(name);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withVisibility(final Boolean visibility) {
    super.withVisibility(visibility);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withOpen(final Boolean open) {
    super.withOpen(open);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withAtomAuthor(final Author atomAuthor) {
    super.withAtomAuthor(atomAuthor);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withAtomLink(final Link atomLink) {
    super.withAtomLink(atomLink);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withAddress(final String address) {
    super.withAddress(address);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withXalAddressDetails(final AddressDetails xalAddressDetails) {
    super.withXalAddressDetails(xalAddressDetails);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withPhoneNumber(final String phoneNumber) {
    super.withPhoneNumber(phoneNumber);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withSnippet(final Snippet snippet) {
    super.withSnippet(snippet);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withSnippetd(final String snippetd) {
    super.withSnippetd(snippetd);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withDescription(final String description) {
    super.withDescription(description);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withAbstractView(final AbstractView abstractView) {
    super.withAbstractView(abstractView);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withTimePrimitive(final TimePrimitive timePrimitive) {
    super.withTimePrimitive(timePrimitive);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withStyleUrl(final String styleUrl) {
    super.withStyleUrl(styleUrl);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withStyleSelector(final List<StyleSelector> styleSelector) {
    super.withStyleSelector(styleSelector);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withRegion(final Region region) {
    super.withRegion(region);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withMetadata(final Metadata metadata) {
    super.withMetadata(metadata);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withExtendedData(final ExtendedData extendedData) {
    super.withExtendedData(extendedData);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.withFeatureSimpleExtension(featureSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.withFeatureObjectExtension(featureObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withColor(final String color) {
    super.withColor(color);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withDrawOrder(final int drawOrder) {
    super.withDrawOrder(drawOrder);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withIcon(final Icon icon) {
    super.withIcon(icon);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withOverlaySimpleExtension(final List<Object> overlaySimpleExtension) {
    super.withOverlaySimpleExtension(overlaySimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public PhotoOverlay withOverlayObjectExtension(final List<AbstractObject> overlayObjectExtension) {
    super.withOverlayObjectExtension(overlayObjectExtension);
    return this;
  }

  @Override
  public PhotoOverlay clone() {
    PhotoOverlay copy;
    copy = ((PhotoOverlay) super.clone());
    copy.viewVolume = ((viewVolume == null) ? null : ((ViewVolume) viewVolume.clone()));
    copy.imagePyramid = ((imagePyramid == null) ? null : ((ImagePyramid) imagePyramid.clone()));
    copy.point = ((point == null) ? null : ((Point) point.clone()));
    copy.photoOverlaySimpleExtension = new ArrayList<>((getPhotoOverlaySimpleExtension().size()));
    for (Object iter : photoOverlaySimpleExtension) {
      copy.photoOverlaySimpleExtension.add(iter);
    }
    copy.photoOverlayObjectExtension = new ArrayList<>((getPhotoOverlayObjectExtension().size()));
    for (AbstractObject iter : photoOverlayObjectExtension) {
      copy.photoOverlayObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
