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
import net.opengis.kml.xal.AddressDetails;

/**
 *  &lt;Overlay&gt;
 *   
 * This is an abstract element and cannot be used directly in a KML file.
 *  &lt;Overlay&gt;
 * is the base type for image overlays drawn on the planet surface or on the
 * screen.
 *  &lt;Icon&gt; specifies the image to use and can be configured to reload images
 * based on a timer or by camera changes. This element also includes
 * specifications for stacking order of multiple overlays and for adding color
 * and transparency values to the base image. Syntax:
 *  <pre>&lt;!-- abstract element; do not create --&gt;
 *  &lt;strong&gt;&lt;!--  &lt;em&gt;Overlay &lt;/em&gt; id="ID" --&gt; &lt;/strong&gt;                    &lt;!-- GroundOverlay,ScreenOverlay --&gt;
 *   &lt;!-- inherited from  &lt;em&gt;Feature &lt;/em&gt; element --&gt;
 *   &lt;name&gt; &lt;em&gt;... &lt;/em&gt;&lt;/name&gt;                      &lt;!-- string --&gt;
 *   &lt;visibility&gt;1&lt;/visibility&gt;            &lt;!-- boolean --&gt;
 *   &lt;open&gt;0&lt;/open&gt;                        &lt;!-- boolean --&gt;
 *    &lt;span&gt;&lt;atom:author&gt;...&lt;atom:author&gt;         &lt;!-- xmlns:atom --&gt;
 *   &lt;atom:link&gt;...&lt;/atom:link&gt; &lt;/span&gt; &lt;span&gt;            &lt;!-- xmlns:atom --&gt; &lt;/span&gt;
 *   &lt;address&gt; &lt;em&gt;... &lt;/em&gt;&lt;/address&gt;                &lt;!-- string --&gt;
 *   &lt;xal:AddressDetails&gt;...&lt;/xal:AddressDetails&gt;  &lt;!-- xmlns:xal --&gt; &lt;br&gt;  &lt;phoneNumber&gt;...&lt;/phoneNumber&gt;        &lt;!-- string --&gt; &lt;br&gt;  &lt;Snippet maxLines="2"&gt; &lt;em&gt;... &lt;/em&gt;&lt;/Snippet&gt;   &lt;!-- string --&gt;
 *   &lt;description&gt; &lt;em&gt;... &lt;/em&gt;&lt;/description&gt;        &lt;!-- string --&gt;
 *    &lt;span&gt; &lt;em&gt;&lt;AbstractView&gt;...&lt;/AbstractView&gt; &lt;/em&gt;      &lt;!-- Camera  &lt;em&gt;or &lt;/em&gt; LookAt --&gt; &lt;/span&gt;
 *   &lt; &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;...&lt;/ &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;
 *   &lt;styleUrl&gt; &lt;em&gt;... &lt;/em&gt;&lt;/styleUrl&gt;              &lt;!-- anyURI --&gt;
 *   &lt; &lt;em&gt;StyleSelector&gt;...&lt;/StyleSelector&gt; &lt;/em&gt;
 *   &lt;Region&gt;...&lt;/Region&gt;
 *    &lt;span&gt;&lt;Metadata&gt;...&lt;/Metadata&gt;              &lt;!-- deprecated in KML 2.2 --&gt;
 *   &lt;ExtendedData&gt;...&lt;/ExtendedData&gt;      &lt;!-- new in KML 2.2 --&gt; &lt;/span&gt;
 *
 *   &lt;!-- specific to  &lt;em&gt;Overlay &lt;/em&gt; --&gt;
 *   &lt;color&gt;ffffffff&lt;/color&gt;                   &lt;!-- kml:color --&gt;
 *   &lt;drawOrder&gt;0&lt;/drawOrder&gt;                  &lt;!-- int --&gt;
 *   &lt;Icon&gt;
 *     &lt;href&gt;...&lt;/href&gt;
 *   &lt;/Icon&gt;
 *  &lt;strong&gt;&lt;!-- / &lt;em&gt;Overlay -- &lt;/em&gt;&gt; &lt;/strong&gt; </pre>
 *   
 * Extends:
 *
 * @see:  &lt;Feature&gt;
 *
 * Extended By:
 * @see:  &lt;GroundOverlay&gt;
 * @see:  &lt;PhotoOverlay @see:  &lt;Sc
 * r
 * eenOverlay&gt; @see: Syntax
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractOverlayType", propOrder = {
  "color",
  "drawOrder",
  "icon",
  "overlaySimpleExtension",
  "overlayObjectExtension"
})
@XmlSeeAlso({
  ScreenOverlay.class,
  PhotoOverlay.class,
  GroundOverlay.class
})
public abstract class Overlay
  extends Feature
  implements Cloneable {

  /**
   *  &lt;color&gt;
   *   
   * Color and opacity (alpha) values are expressed in hexadecimal notation. The
   * range of values for any one color is 0 to 255 (00 to ff). For alpha, 00 is
   * fully transparent and ff is fully opaque. The order of expression is
   * aabbggrr, where aa=alpha (00 to ff); bb=blue (00 to ff); gg=green (00 to
   * ff); rr=red (00 to ff). For example, if you want to apply a blue color with
   * 50 percent opacity to an overlay, you would specify the following:
   *  &lt;color&gt;7fff0000 &lt;/color&gt;, where alpha=0x7f, blue=0xff, green=0x00, and
   * red=0x00. Color values are expressed in hexadecimal notation, including
   * opacity (alpha) values. The order of expression is alpha, blue, green, red
   * (aabbggrr). The range of values for any one color is 0 to 255 (00 to ff).
   * For opacity, 00 is fully transparent and ff is fully opaque. For example,
   * if you want to apply a blue color with 50 percent opacity to an overlay,
   * you would specify the following:  &lt;color&gt;7fff0000 &lt;/color&gt;
   * Note: The  &lt;geomColor&gt; element has been deprecated. Use  &lt;color&gt; instead.
   */
  @XmlElement(defaultValue = "ffffffff")

  protected String color;
  /**
   *  &lt;draworder&gt;
   *   
   * This element defines the stacking order for the images in overlapping
   * overlays. Overlays with higher  &lt;drawOrder&gt; values are drawn on top of
   * overlays with lower
   *  &lt;drawOrder&gt; values.
   */
  @XmlElement(defaultValue = "0")
  protected int drawOrder;
  /**
   *  &lt;icon&gt; see also  &lt;icon&gt;.
   *   
   *  &lt;Icon&gt;  &lt;href&gt;Sunset.jpg &lt;/href&gt;  &lt;/Icon&gt;
   * A custom Icon. In  &lt;IconStyle&gt;, the only child element of  &lt;Icon&gt; is  &lt;href&gt;:
   *  &lt;href&gt;: An HTTP address or a local file specification used to load an icon.
   * Defines an image associated with an Icon style or overlay.  &lt;Icon&gt; has the
   * same child elements as  &lt;Link&gt;. The required  &lt;href&gt; child element defines
   * the location of the image to be used as the overlay or as the icon for the
   * placemark. This location can either be on a local file system or a remote
   * web server. Defines the image associated with the Overlay. The  &lt;href&gt;
   * element defines the location of the image to be used as the Overlay. This
   * location can be either on a local file system or on a web server. If this
   * element is omitted or contains no  &lt;href&gt;, a rectangle is drawn using the
   * color and size defined by the ground or screen overlay.  &lt;Icon&gt;
   *  &lt;href&gt;icon.jpg &lt;/href&gt;  &lt;/Icon&gt;
   * Syntax:
   *  &lt;pre&gt; &lt;strong&gt;&lt;Icon id="ID"&gt; &lt;/strong&gt;
   *   &lt;!-- specific to Icon --&gt;
   *   &lt;href&gt; &lt;em&gt;... &lt;/em&gt;&lt;/href&gt;                      &lt;!-- anyURI --&gt;
   *   &lt;refreshMode&gt;onChange&lt;/refreshMode&gt;
   *     &lt;!-- kml:refreshModeEnum: onChange, onInterval,  &lt;em&gt;or &lt;/em&gt; onExpire --&gt;
   *   &lt;refreshInterval&gt;4&lt;/refreshInterval&gt;  &lt;!-- float --&gt;
   *   &lt;viewRefreshMode&gt;never&lt;/viewRefreshMode&gt;
   *     &lt;!-- kml:viewRefreshModeEnum: never, onStop, onRequest, onRegion --&gt;
   *   &lt;viewRefreshTime&gt;4&lt;/viewRefreshTime&gt;  &lt;!-- float --&gt;
   *   &lt;viewBoundScale&gt;1&lt;/viewBoundScale&gt;    &lt;!-- float --&gt;
   *   &lt;viewFormat&gt;...&lt;/viewFormat&gt;          &lt;!-- string --&gt;
   *   &lt;httpQuery&gt;...&lt;/httpQuery&gt;            &lt;!-- string --&gt;
   *    &lt;strong&gt;&lt;/Icon&gt; &lt;/strong&gt; </pre>
   *   
   * Contained By:
   *
   * @see:  &lt;GroundOverlay&gt;
   * @see:  &lt;IconStyle&gt;
   * @see:  &lt;ScreenOverlay&gt;
   *
   */
  @XmlElement(name = "Icon")
  protected Icon icon;
  @XmlElement(name = "AbstractOverlaySimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> overlaySimpleExtension;
  /**
   *  &lt;Object&gt;
   *   
   * This is an abstract base class and cannot be used directly in a KML file.
   * It provides the id attribute, which allows unique identification of a KML
   * element, and the targetId attribute, which is used to reference objects
   * that have already been loaded into Google Earth. The id attribute must be
   * assigned if the  &lt;Update&gt; mechanism is to be used. Syntax:
   *  <pre>&lt;!-- abstract element; do not create --&gt; &lt;strong&gt;
   * &lt;!--  &lt;em&gt;Object &lt;/em&gt; id="ID" targetId="NCName" --&gt;
   * &lt;!-- / &lt;em&gt;Object &lt;/em&gt;&gt; --&gt; &lt;/strong&gt; </pre>
   *   
   */
  @XmlElement(name = "AbstractOverlayObjectExtensionGroup")
  protected List<AbstractObject> overlayObjectExtension;

  public Overlay() {
    super();
  }

  /**
   * @see color
   *
   * @return possible object is {@link String}
   *
   */
  public String getColor() {
    return color;
  }

  /**
   * @see color
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setColor(String value) {
    this.color = value;
  }

  /**
   * @see drawOrder
   *
   * @return possible object is {@link Integer}
   *
   */
  public int getDrawOrder() {
    return drawOrder;
  }

  /**
   * @see drawOrder
   *
   * @param value allowed object is {@link Integer}
   *
   */
  public void setDrawOrder(int value) {
    this.drawOrder = value;
  }

  /**
   * @see icon
   *
   * @return possible object is {@link net.opengis.kml.Link}
   *
   */
  public Icon getIcon() {
    return icon;
  }

  /**
   * @see icon
   *
   * @param value allowed object is {@link net.opengis.kml.Link}
   *
   */
  public void setIcon(Icon value) {
    this.icon = value;
  }

  /**
   * @see overlaySimpleExtension
   *
   */
  public List<Object> getOverlaySimpleExtension() {
    if (overlaySimpleExtension == null) {
      overlaySimpleExtension = new ArrayList<>();
    }
    return this.overlaySimpleExtension;
  }

  /**
   * @see overlayObjectExtension
   *
   */
  public List<AbstractObject> getOverlayObjectExtension() {
    if (overlayObjectExtension == null) {
      overlayObjectExtension = new ArrayList<>();
    }
    return this.overlayObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((color == null) ? 0 : color.hashCode()));
    result = ((prime * result) + drawOrder);
    result = ((prime * result) + ((icon == null) ? 0 : icon.hashCode()));
    result = ((prime * result) + ((overlaySimpleExtension == null) ? 0 : overlaySimpleExtension.hashCode()));
    result = ((prime * result) + ((overlayObjectExtension == null) ? 0 : overlayObjectExtension.hashCode()));
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
    if ((obj instanceof Overlay) == false) {
      return false;
    }
    Overlay other = ((Overlay) obj);
    if (color == null) {
      if (other.color != null) {
        return false;
      }
    } else if (color.equals(other.color) == false) {
      return false;
    }
    if (drawOrder != other.drawOrder) {
      return false;
    }
    if (icon == null) {
      if (other.icon != null) {
        return false;
      }
    } else if (icon.equals(other.icon) == false) {
      return false;
    }
    if (overlaySimpleExtension == null) {
      if (other.overlaySimpleExtension != null) {
        return false;
      }
    } else if (overlaySimpleExtension.equals(other.overlaySimpleExtension) == false) {
      return false;
    }
    if (overlayObjectExtension == null) {
      if (other.overlayObjectExtension != null) {
        return false;
      }
    } else if (overlayObjectExtension.equals(other.overlayObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link Icon} and set it to icon.
   *   
   * This method is a short version for:     &lt;code&gt;
   * Icon icon = new Icon();
   * this.setIcon(icon);  &lt;/code&gt;
   */
  public Icon createAndSetIcon() {
    Icon newValue = new Icon();
    this.setIcon(newValue);
    return newValue;
  }

  /**
   * @see overlaySimpleExtension
   *
   * @param overlaySimpleExtension
   */
  public void setOverlaySimpleExtension(final List<Object> overlaySimpleExtension) {
    this.overlaySimpleExtension = overlaySimpleExtension;
  }

  /**
   * add a value to the overlaySimpleExtension property collection
   *
   * @param overlaySimpleExtension Objects of the following type are allowed in
   *                               the list: {@link Object}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Overlay addToOverlaySimpleExtension(final Object overlaySimpleExtension) {
    this.getOverlaySimpleExtension().add(overlaySimpleExtension);
    return this;
  }

  /**
   * @see overlayObjectExtension
   *
   * @param overlayObjectExtension
   */
  public void setOverlayObjectExtension(final List<AbstractObject> overlayObjectExtension) {
    this.overlayObjectExtension = overlayObjectExtension;
  }

  /**
   * add a value to the overlayObjectExtension property collection
   *
   * @param overlayObjectExtension Objects of the following type are allowed in
   *                               the list: {@link AbstractObject}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Overlay addToOverlayObjectExtension(final AbstractObject overlayObjectExtension) {
    this.getOverlayObjectExtension().add(overlayObjectExtension);
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
  public Overlay addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public Overlay addToStyleSelector(final StyleSelector styleSelector) {
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
  public Overlay addToFeatureSimpleExtension(final Object featureSimpleExtension) {
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
  public Overlay addToFeatureObjectExtension(final AbstractObject featureObjectExtension) {
    super.getFeatureObjectExtension().add(featureObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setColor(String)
   *
   * @param color required parameter
   */
  public Overlay withColor(final String color) {
    this.setColor(color);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setDrawOrder(int)
   *
   * @param drawOrder required parameter
   */
  public Overlay withDrawOrder(final int drawOrder) {
    this.setDrawOrder(drawOrder);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setIcon(Icon)
   *
   * @param icon required parameter
   */
  public Overlay withIcon(final Icon icon) {
    this.setIcon(icon);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setOverlaySimpleExtension(List &lt;Object&gt;)
   *
   * @param overlaySimpleExtension required parameter
   */
  public Overlay withOverlaySimpleExtension(final List<Object> overlaySimpleExtension) {
    this.setOverlaySimpleExtension(overlaySimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setOverlayObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param overlayObjectExtension required parameter
   */
  public Overlay withOverlayObjectExtension(final List<AbstractObject> overlayObjectExtension) {
    this.setOverlayObjectExtension(overlayObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Overlay withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Overlay withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Overlay withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public Overlay withName(final String name) {
    super.withName(name);
    return this;
  }

  @Obvious
  @Override
  public Overlay withVisibility(final Boolean visibility) {
    super.withVisibility(visibility);
    return this;
  }

  @Obvious
  @Override
  public Overlay withOpen(final Boolean open) {
    super.withOpen(open);
    return this;
  }

  @Obvious
  @Override
  public Overlay withAtomAuthor(final Author atomAuthor) {
    super.withAtomAuthor(atomAuthor);
    return this;
  }

  @Obvious
  @Override
  public Overlay withAtomLink(final net.opengis.kml.atom.Link atomLink) {
    super.withAtomLink(atomLink);
    return this;
  }

  @Obvious
  @Override
  public Overlay withAddress(final String address) {
    super.withAddress(address);
    return this;
  }

  @Obvious
  @Override
  public Overlay withXalAddressDetails(final AddressDetails xalAddressDetails) {
    super.withXalAddressDetails(xalAddressDetails);
    return this;
  }

  @Obvious
  @Override
  public Overlay withPhoneNumber(final String phoneNumber) {
    super.withPhoneNumber(phoneNumber);
    return this;
  }

  @Obvious
  @Override
  public Overlay withSnippet(final Snippet snippet) {
    super.withSnippet(snippet);
    return this;
  }

  @Obvious
  @Override
  public Overlay withSnippetd(final String snippetd) {
    super.withSnippetd(snippetd);
    return this;
  }

  @Obvious
  @Override
  public Overlay withDescription(final String description) {
    super.withDescription(description);
    return this;
  }

  @Obvious
  @Override
  public Overlay withAbstractView(final AbstractView abstractView) {
    super.withAbstractView(abstractView);
    return this;
  }

  @Obvious
  @Override
  public Overlay withTimePrimitive(final TimePrimitive timePrimitive) {
    super.withTimePrimitive(timePrimitive);
    return this;
  }

  @Obvious
  @Override
  public Overlay withStyleUrl(final String styleUrl) {
    super.withStyleUrl(styleUrl);
    return this;
  }

  @Obvious
  @Override
  public Overlay withStyleSelector(final List<StyleSelector> styleSelector) {
    super.withStyleSelector(styleSelector);
    return this;
  }

  @Obvious
  @Override
  public Overlay withRegion(final Region region) {
    super.withRegion(region);
    return this;
  }

  @Obvious
  @Override
  public Overlay withMetadata(final Metadata metadata) {
    super.withMetadata(metadata);
    return this;
  }

  @Obvious
  @Override
  public Overlay withExtendedData(final ExtendedData extendedData) {
    super.withExtendedData(extendedData);
    return this;
  }

  @Obvious
  @Override
  public Overlay withFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.withFeatureSimpleExtension(featureSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Overlay withFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.withFeatureObjectExtension(featureObjectExtension);
    return this;
  }

  @Override
  public Overlay clone() {
    Overlay copy;
    copy = ((Overlay) super.clone());
    copy.icon = ((icon == null) ? null : ((Icon) icon.clone()));
    copy.overlaySimpleExtension = new ArrayList<>((getOverlaySimpleExtension().size()));
    for (Object iter : overlaySimpleExtension) {
      copy.overlaySimpleExtension.add(iter);
    }
    copy.overlayObjectExtension = new ArrayList<>((getOverlayObjectExtension().size()));
    for (AbstractObject iter : overlayObjectExtension) {
      copy.overlayObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
