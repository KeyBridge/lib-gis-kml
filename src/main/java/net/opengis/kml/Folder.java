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
import net.opengis.kml.gx.Tour;
import net.opengis.kml.xal.AddressDetails;

/**
 *  &lt;Folder&gt;
 *   
 * A Folder is used to arrange other Features hierarchically (Folders,
 * Placemarks, NetworkLinks, or Overlays). A Feature is visible only if it and
 * all its ancestors are visible. A Folder is used to arrange other Features
 * hierarchically (Folders, Placemarks, NetworkLinks, or Overlays). A Feature is
 * visible only if it and all its ancestors are visible. Syntax:
 *  &lt;pre&gt; &lt;strong&gt;&lt;Folder id="ID"&gt; &lt;/strong&gt;
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
 *   &lt;ExtendedData&gt;...&lt;/ExtendedData&gt;      &lt;!-- new in KML 2.2 --&gt;
 *
 *    &lt;/span&gt;&lt;!-- specific to Folder --&gt;
 *   &lt;!-- 0 or more  &lt;em&gt;Feature &lt;/em&gt; elements --&gt;
 *  &lt;strong&gt;&lt;/Folder &lt;/strong&gt;&gt;
 *  </pre>
 *   
 * Extends:
 *
 * @see:  &lt;Container&gt;
 *
 * Contains:
 * @see:  &lt;Feature&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FolderType", propOrder = {
  "feature",
  "folderSimpleExtension",
  "folderObjectExtension"
})
@XmlRootElement(name = "Folder", namespace = "http://www.opengis.net/kml/2.2")
public class Folder extends Container implements Cloneable {

  /**
   *  &lt;Feature&gt;
   *   
   * This is an abstract element and cannot be used directly in a KML file. The
   * following diagram shows how some of a Feature's elements appear in Google
   * Earth. Syntax:
   *  <pre>&lt;!-- abstract element; do not create --&gt;
   *  &lt;strong&gt;&lt;!-- &lt;em&gt; Feature &lt;/em&gt; id="ID" --&gt; &lt;/strong&gt;                &lt;!-- Document,Folder,
   *                                              NetworkLink,Placemark,
   *                                              GroundOverlay,PhotoOverlay,ScreenOverlay --&gt;
   *   &lt;name&gt; &lt;em&gt;... &lt;/em&gt;&lt;/name&gt;                      &lt;!-- string --&gt;
   *   &lt;visibility&gt;1&lt;/visibility&gt;            &lt;!-- boolean --&gt;
   *   &lt;open&gt;0&lt;/open&gt;                        &lt;!-- boolean --&gt;
   *    &lt;span&gt;&lt;atom:author&gt;...&lt;atom:author&gt;         &lt;!-- xmlns:atom --&gt;
   *   &lt;atom:link&gt;...&lt;/atom:link&gt; &lt;/span&gt; &lt;span&gt;            &lt;!-- xmlns:atom --&gt; &lt;/span&gt;
   *   &lt;address&gt; &lt;em&gt;... &lt;/em&gt;&lt;/address&gt;                &lt;!-- string --&gt;
   *   &lt;xal:AddressDetails&gt;...&lt;/xal:AddressDetails&gt;  &lt;!-- xmlns:xal --&gt; &lt;br&gt;  &lt;phoneNumber&gt;...&lt;/phoneNumber&gt;        &lt;!-- string --&gt; &lt;br&gt;  &lt;Snippet maxLines="2"&gt; &lt;em&gt;... &lt;/em&gt;&lt;/Snippet&gt;   &lt;!-- string --&gt;
   *   &lt;description&gt; &lt;em&gt;... &lt;/em&gt;&lt;/description&gt;        &lt;!-- string --&gt;
   *    &lt;span&gt; &lt;em&gt;&lt;AbstractView&gt;...&lt;/AbstractView&gt; &lt;/em&gt;      &lt;!-- Camera  &lt;em&gt;or &lt;/em&gt; LookAt --&gt; &lt;/span&gt;
   *   &lt; &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;...&lt;/ &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;    &lt;!-- TimeStamp or TimeSpan --&gt;
   *   &lt;styleUrl&gt; &lt;em&gt;... &lt;/em&gt;&lt;/styleUrl&gt;              &lt;!-- anyURI --&gt;
   *   &lt; &lt;em&gt;StyleSelector&gt;...&lt;/StyleSelector&gt; &lt;/em&gt;
   *   &lt;Region&gt;...&lt;/Region&gt;
   *    &lt;span&gt;&lt;Metadata&gt;...&lt;/Metadata&gt;              &lt;!-- deprecated in KML 2.2 --&gt;
   *   &lt;ExtendedData&gt;...&lt;/ExtendedData&gt;      &lt;!-- new in KML 2.2 --&gt; &lt;br&gt; &lt;/span&gt;&lt;-- / &lt;em&gt;Feature &lt;/em&gt; --&gt; </pre>
   *   
   * Extends:
   *
   * @see:  &lt;Object&gt;
   *
   * Extended By:
   * @see:  &lt;Container&gt;
   * @see:  &lt;NetworkLink&gt;
   * @see:  &lt;Overlay&gt;
   * @see:  &lt;Placemark&gt;
   * @see:  &lt;gx:Tour&gt;
   *
   */
  @XmlElementRef(name = "AbstractFeatureGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected List<Feature> feature;
  @XmlElement(name = "FolderSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> folderSimpleExtension;
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
  @XmlElement(name = "FolderObjectExtensionGroup")
  protected List<AbstractObject> folderObjectExtension;

  public Folder() {
    super();
  }

  /**
   * @see feature
   *
   */
  public List<Feature> getFeature() {
    if (feature == null) {
      feature = new ArrayList<>();
    }
    return this.feature;
  }

  /**
   * @see folderSimpleExtension
   *
   */
  public List<Object> getFolderSimpleExtension() {
    if (folderSimpleExtension == null) {
      folderSimpleExtension = new ArrayList<>();
    }
    return this.folderSimpleExtension;
  }

  /**
   * @see folderObjectExtension
   *
   */
  public List<AbstractObject> getFolderObjectExtension() {
    if (folderObjectExtension == null) {
      folderObjectExtension = new ArrayList<>();
    }
    return this.folderObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((feature == null) ? 0 : feature.hashCode()));
    result = ((prime * result) + ((folderSimpleExtension == null) ? 0 : folderSimpleExtension.hashCode()));
    result = ((prime * result) + ((folderObjectExtension == null) ? 0 : folderObjectExtension.hashCode()));
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
    if ((obj instanceof Folder) == false) {
      return false;
    }
    Folder other = ((Folder) obj);
    if (feature == null) {
      if (other.feature != null) {
        return false;
      }
    } else if (feature.equals(other.feature) == false) {
      return false;
    }
    if (folderSimpleExtension == null) {
      if (other.folderSimpleExtension != null) {
        return false;
      }
    } else if (folderSimpleExtension.equals(other.folderSimpleExtension) == false) {
      return false;
    }
    if (folderObjectExtension == null) {
      if (other.folderObjectExtension != null) {
        return false;
      }
    } else if (folderObjectExtension.equals(other.folderObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link Tour} and adds it to feature. This method
   * is a short version for:     &lt;code&gt;
   * Tour tour = new Tour();
   * this.getFeature().add(tour);  &lt;/code&gt;
   */
  public Tour createAndAddTour() {
    Tour newValue = new Tour();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link ScreenOverlay} and adds it to feature.
   * This method is a short version for:     &lt;code&gt;
   * ScreenOverlay screenOverlay = new ScreenOverlay();
   * this.getFeature().add(screenOverlay);  &lt;/code&gt;
   */
  public ScreenOverlay createAndAddScreenOverlay() {
    ScreenOverlay newValue = new ScreenOverlay();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link PhotoOverlay} and adds it to feature. This
   * method is a short version for:     &lt;code&gt;
   * PhotoOverlay photoOverlay = new PhotoOverlay();
   * this.getFeature().add(photoOverlay);  &lt;/code&gt;
   */
  public PhotoOverlay createAndAddPhotoOverlay() {
    PhotoOverlay newValue = new PhotoOverlay();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link GroundOverlay} and adds it to feature.
   * This method is a short version for:     &lt;code&gt;
   * GroundOverlay groundOverlay = new GroundOverlay();
   * this.getFeature().add(groundOverlay);  &lt;/code&gt;
   */
  public GroundOverlay createAndAddGroundOverlay() {
    GroundOverlay newValue = new GroundOverlay();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link NetworkLink} and adds it to feature. This
   * method is a short version for:     &lt;code&gt;
   * NetworkLink networkLink = new NetworkLink();
   * this.getFeature().add(networkLink);  &lt;/code&gt;
   */
  public NetworkLink createAndAddNetworkLink() {
    NetworkLink newValue = new NetworkLink();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Folder} and adds it to feature. This
   * method is a short version for:     &lt;code&gt;
   * Folder folder = new Folder();
   * this.getFeature().add(folder);  &lt;/code&gt;
   */
  public Folder createAndAddFolder() {
    Folder newValue = new Folder();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Document} and adds it to feature. This
   * method is a short version for:     &lt;code&gt;
   * Document document = new Document();
   * this.getFeature().add(document);  &lt;/code&gt;
   */
  public Document createAndAddDocument() {
    Document newValue = new Document();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Placemark} and adds it to feature. This
   * method is a short version for:     &lt;code&gt;
   * Placemark placemark = new Placemark();
   * this.getFeature().add(placemark);  &lt;/code&gt;
   */
  public Placemark createAndAddPlacemark() {
    Placemark newValue = new Placemark();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * @see feature
   *
   * @param feature
   */
  public void setFeature(final List<Feature> feature) {
    this.feature = feature;
  }

  /**
   * add a value to the feature property collection
   *
   * @param feature Objects of the following type are allowed in the list:
   *                {@link Container}{@link JAXBElement}{@link GroundOverlay}{@link JAXBElement}{@link NetworkLink}{@link JAXBElement}{@link Folder}{@link JAXBElement}{@link PhotoOverlay}{@link JAXBElement}{@link Document}{@link JAXBElement}{@link Tour}{@link JAXBElement}{@link ScreenOverlay}{@link JAXBElement}{@link Feature}{@link JAXBElement}{@link Placemark}{@link JAXBElement}{@link Overlay}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Folder addToFeature(final Feature feature) {
    this.getFeature().add(feature);
    return this;
  }

  /**
   * @see folderSimpleExtension
   *
   * @param folderSimpleExtension
   */
  public void setFolderSimpleExtension(final List<Object> folderSimpleExtension) {
    this.folderSimpleExtension = folderSimpleExtension;
  }

  /**
   * add a value to the folderSimpleExtension property collection
   *
   * @param folderSimpleExtension Objects of the following type are allowed in
   *                              the list: {@link Object}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Folder addToFolderSimpleExtension(final Object folderSimpleExtension) {
    this.getFolderSimpleExtension().add(folderSimpleExtension);
    return this;
  }

  /**
   * @see folderObjectExtension
   *
   * @param folderObjectExtension
   */
  public void setFolderObjectExtension(final List<AbstractObject> folderObjectExtension) {
    this.folderObjectExtension = folderObjectExtension;
  }

  /**
   * add a value to the folderObjectExtension property collection
   *
   * @param folderObjectExtension Objects of the following type are allowed in
   *                              the list: {@link AbstractObject}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Folder addToFolderObjectExtension(final AbstractObject folderObjectExtension) {
    this.getFolderObjectExtension().add(folderObjectExtension);
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
  public Folder addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public Folder addToStyleSelector(final StyleSelector styleSelector) {
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
  public Folder addToFeatureSimpleExtension(final Object featureSimpleExtension) {
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
  public Folder addToFeatureObjectExtension(final AbstractObject featureObjectExtension) {
    super.getFeatureObjectExtension().add(featureObjectExtension);
    return this;
  }

  /**
   * @see containerSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setContainerSimpleExtension(final List<Object> containerSimpleExtension) {
    super.setContainerSimpleExtension(containerSimpleExtension);
  }

  @Obvious
  @Override
  public Folder addToContainerSimpleExtension(final Object containerSimpleExtension) {
    super.getContainerSimpleExtension().add(containerSimpleExtension);
    return this;
  }

  /**
   * @see containerObjectExtension
   *
   */
  @Obvious
  @Override
  public void setContainerObjectExtension(final List<AbstractObject> containerObjectExtension) {
    super.setContainerObjectExtension(containerObjectExtension);
  }

  @Obvious
  @Override
  public Folder addToContainerObjectExtension(final AbstractObject containerObjectExtension) {
    super.getContainerObjectExtension().add(containerObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setFeature(List &lt;Feature&gt;)
   *
   * @param feature required parameter
   */
  public Folder withFeature(final List<Feature> feature) {
    this.setFeature(feature);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setFolderSimpleExtension(List &lt;Object&gt;)
   *
   * @param folderSimpleExtension required parameter
   */
  public Folder withFolderSimpleExtension(final List<Object> folderSimpleExtension) {
    this.setFolderSimpleExtension(folderSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setFolderObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param folderObjectExtension required parameter
   */
  public Folder withFolderObjectExtension(final List<AbstractObject> folderObjectExtension) {
    this.setFolderObjectExtension(folderObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Folder withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Folder withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Folder withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public Folder withName(final String name) {
    super.withName(name);
    return this;
  }

  @Obvious
  @Override
  public Folder withVisibility(final Boolean visibility) {
    super.withVisibility(visibility);
    return this;
  }

  @Obvious
  @Override
  public Folder withOpen(final Boolean open) {
    super.withOpen(open);
    return this;
  }

  @Obvious
  @Override
  public Folder withAtomAuthor(final Author atomAuthor) {
    super.withAtomAuthor(atomAuthor);
    return this;
  }

  @Obvious
  @Override
  public Folder withAtomLink(final Link atomLink) {
    super.withAtomLink(atomLink);
    return this;
  }

  @Obvious
  @Override
  public Folder withAddress(final String address) {
    super.withAddress(address);
    return this;
  }

  @Obvious
  @Override
  public Folder withXalAddressDetails(final AddressDetails xalAddressDetails) {
    super.withXalAddressDetails(xalAddressDetails);
    return this;
  }

  @Obvious
  @Override
  public Folder withPhoneNumber(final String phoneNumber) {
    super.withPhoneNumber(phoneNumber);
    return this;
  }

  @Obvious
  @Override
  public Folder withSnippet(final Snippet snippet) {
    super.withSnippet(snippet);
    return this;
  }

  @Obvious
  @Override
  public Folder withSnippetd(final String snippetd) {
    super.withSnippetd(snippetd);
    return this;
  }

  @Obvious
  @Override
  public Folder withDescription(final String description) {
    super.withDescription(description);
    return this;
  }

  @Obvious
  @Override
  public Folder withAbstractView(final AbstractView abstractView) {
    super.withAbstractView(abstractView);
    return this;
  }

  @Obvious
  @Override
  public Folder withTimePrimitive(final TimePrimitive timePrimitive) {
    super.withTimePrimitive(timePrimitive);
    return this;
  }

  @Obvious
  @Override
  public Folder withStyleUrl(final String styleUrl) {
    super.withStyleUrl(styleUrl);
    return this;
  }

  @Obvious
  @Override
  public Folder withStyleSelector(final List<StyleSelector> styleSelector) {
    super.withStyleSelector(styleSelector);
    return this;
  }

  @Obvious
  @Override
  public Folder withRegion(final Region region) {
    super.withRegion(region);
    return this;
  }

  @Obvious
  @Override
  public Folder withMetadata(final Metadata metadata) {
    super.withMetadata(metadata);
    return this;
  }

  @Obvious
  @Override
  public Folder withExtendedData(final ExtendedData extendedData) {
    super.withExtendedData(extendedData);
    return this;
  }

  @Obvious
  @Override
  public Folder withFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.withFeatureSimpleExtension(featureSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Folder withFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.withFeatureObjectExtension(featureObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Folder withContainerSimpleExtension(final List<Object> containerSimpleExtension) {
    super.withContainerSimpleExtension(containerSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Folder withContainerObjectExtension(final List<AbstractObject> containerObjectExtension) {
    super.withContainerObjectExtension(containerObjectExtension);
    return this;
  }

  @Override
  public Folder clone() {
    Folder copy;
    copy = ((Folder) super.clone());
    copy.feature = new ArrayList<>((getFeature().size()));
    for (Feature iter : feature) {
      copy.feature.add(iter.clone());
    }
    copy.folderSimpleExtension = new ArrayList<>((getFolderSimpleExtension().size()));
    for (Object iter : folderSimpleExtension) {
      copy.folderSimpleExtension.add(iter);
    }
    copy.folderObjectExtension = new ArrayList<>((getFolderObjectExtension().size()));
    for (AbstractObject iter : folderObjectExtension) {
      copy.folderObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
