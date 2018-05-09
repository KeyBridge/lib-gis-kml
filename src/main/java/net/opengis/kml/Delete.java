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
import net.opengis.kml.gx.Tour;

/**
 * &lt;delete&gt;
 * <p>
 * Child elements for &lt;Delete&gt;, which are the only elements that can be
 * deleted, are Document, Folder, GroundOverlay, Placemark, and ScreenOverlay.
 * Deletes features from a complex element that has already been loaded via a
 * &lt;NetworkLink&gt;. The &lt;targetHref&gt; element in &lt;Update&gt;
 * specifies the .kml or .kmz file containing the data to be deleted. Within
 * that file, the element to be deleted must already have an explicit id defined
 * for it. The &lt;Delete&gt; element references this id in the targetId
 * attribute.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeleteType", propOrder = {
  "feature"
})
@XmlRootElement(name = "Delete", namespace = "http://www.opengis.net/kml/2.2")
public class Delete implements Cloneable {

  /**
   * &lt;Feature&gt;
   * <p>
   * This is an abstract element and cannot be used directly in a KML file. The
   * following diagram shows how some of a Feature's elements appear in Google
   * Earth. Syntax:
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
   *   &lt;xal:AddressDetails&gt;...&lt;/xal:AddressDetails&gt;  &lt;!-- xmlns:xal --&gt; &lt;br&gt;  &lt;phoneNumber&gt;...&lt;/phoneNumber&gt;        &lt;!-- string --&gt; &lt;br&gt;  &lt;Snippet maxLines="2"&gt; &lt;em&gt;... &lt;/em&gt;&lt;/Snippet&gt;   &lt;!-- string --&gt;
   *   &lt;description&gt; &lt;em&gt;... &lt;/em&gt;&lt;/description&gt;        &lt;!-- string --&gt;
   *    &lt;span&gt; &lt;em&gt;&lt;AbstractView&gt;...&lt;/AbstractView&gt; &lt;/em&gt;      &lt;!-- Camera  &lt;em&gt;or &lt;/em&gt; LookAt --&gt; &lt;/span&gt;
   *   &lt; &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;...&lt;/ &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;    &lt;!-- TimeStamp or TimeSpan --&gt;
   *   &lt;styleUrl&gt; &lt;em&gt;... &lt;/em&gt;&lt;/styleUrl&gt;              &lt;!-- anyURI --&gt;
   *   &lt; &lt;em&gt;StyleSelector&gt;...&lt;/StyleSelector&gt; &lt;/em&gt;
   *   &lt;Region&gt;...&lt;/Region&gt;
   *    &lt;span&gt;&lt;Metadata&gt;...&lt;/Metadata&gt;              &lt;!-- deprecated in KML 2.2 --&gt;
   *   &lt;ExtendedData&gt;...&lt;/ExtendedData&gt;      &lt;!-- new in KML 2.2 --&gt; &lt;br&gt; &lt;/span&gt;&lt;-- / &lt;em&gt;Feature &lt;/em&gt; --&gt;
   * </pre>
   * <p>
   * Extends:
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
  @XmlElementRef(name = "AbstractFeatureGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected List<Feature> feature;

  public Delete() {
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((feature == null) ? 0 : feature.hashCode()));
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
    if ((obj instanceof Delete) == false) {
      return false;
    }
    Delete other = ((Delete) obj);
    if (feature == null) {
      if (other.feature != null) {
        return false;
      }
    } else if (feature.equals(other.feature) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code Tour} and adds it to feature. This method
   * is a short version for: &lt;code&gt; Tour tour = new Tour();
   * this.getFeature().add(tour); &lt;/code&gt;
   */
  public Tour createAndAddTour() {
    Tour newValue = new Tour();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code ScreenOverlay} and adds it to feature.
   * This method is a short version for: &lt;code&gt; ScreenOverlay
   * screenOverlay = new ScreenOverlay(); this.getFeature().add(screenOverlay);
   * &lt;/code&gt;
   */
  public ScreenOverlay createAndAddScreenOverlay() {
    ScreenOverlay newValue = new ScreenOverlay();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code PhotoOverlay} and adds it to feature. This
   * method is a short version for: &lt;code&gt; PhotoOverlay photoOverlay = new
   * PhotoOverlay(); this.getFeature().add(photoOverlay); &lt;/code&gt;
   */
  public PhotoOverlay createAndAddPhotoOverlay() {
    PhotoOverlay newValue = new PhotoOverlay();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code GroundOverlay} and adds it to feature.
   * This method is a short version for: &lt;code&gt; GroundOverlay
   * groundOverlay = new GroundOverlay(); this.getFeature().add(groundOverlay);
   * &lt;/code&gt;
   */
  public GroundOverlay createAndAddGroundOverlay() {
    GroundOverlay newValue = new GroundOverlay();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code NetworkLink} and adds it to feature. This
   * method is a short version for: &lt;code&gt; NetworkLink networkLink = new
   * NetworkLink(); this.getFeature().add(networkLink); &lt;/code&gt;
   */
  public NetworkLink createAndAddNetworkLink() {
    NetworkLink newValue = new NetworkLink();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Folder} and adds it to feature. This
   * method is a short version for: &lt;code&gt; Folder folder = new Folder();
   * this.getFeature().add(folder); &lt;/code&gt;
   */
  public Folder createAndAddFolder() {
    Folder newValue = new Folder();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Document} and adds it to feature. This
   * method is a short version for: &lt;code&gt; Document document = new
   * Document(); this.getFeature().add(document); &lt;/code&gt;
   */
  public Document createAndAddDocument() {
    Document newValue = new Document();
    this.getFeature().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Placemark} and adds it to feature. This
   * method is a short version for: &lt;code&gt; Placemark placemark = new
   * Placemark(); this.getFeature().add(placemark); &lt;/code&gt;
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
   *                {@code Container}{@code JAXBElement}{@code GroundOverlay}{@code JAXBElement}{@code NetworkLink}{@code JAXBElement}{@code Folder}{@code JAXBElement}{@code PhotoOverlay}{@code JAXBElement}{@code Document}{@code JAXBElement}{@code Tour}{@code JAXBElement}{@code ScreenOverlay}{@code JAXBElement}{@code Feature}{@code JAXBElement}{@code Placemark}{@code JAXBElement}{@code Overlay}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Delete addToFeature(final Feature feature) {
    this.getFeature().add(feature);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setFeature(List &lt;Feature&gt;)
   *
   * @param feature required parameter
   */
  public Delete withFeature(final List<Feature> feature) {
    this.setFeature(feature);
    return this;
  }

  @Override
  public Delete clone() {
    Delete copy;
    try {
      copy = ((Delete) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.feature = new ArrayList<>((getFeature().size()));
    for (Feature iter : feature) {
      copy.feature.add(iter.clone());
    }
    return copy;
  }

}
