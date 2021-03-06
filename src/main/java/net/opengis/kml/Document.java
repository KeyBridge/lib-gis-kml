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
 * &lt;Document&gt;
 * <p>
 * &lt;Document&gt; &lt;Style id="myPrettyDocument"&gt; &lt;ListStyle&gt; ...
 * &lt;/ListStyle&gt; &lt;/Style&gt; &lt;styleUrl#myPrettyDocument"&gt; ...
 * &lt;/Document&gt; A Document is a container for features and styles. This
 * element is required if your KML file uses shared styles. It is recommended
 * that you use shared styles, which require the following steps: Define all
 * Styles in a Document. Assign a unique ID to each Style. Within a given
 * Feature or StyleMap, reference the Style's ID using a &lt;styleUrl&gt;
 * element. Do not put shared styles within a Folder. Each Feature must
 * explicitly reference the styles it uses in a &lt;styleUrl&gt; element. For a
 * Style that applies to a Document (such as ListStyle), the Document itself
 * must explicitly reference the &lt;styleUrl&gt;. For example: Note that shared
 * styles are not inherited by the Features in the Document. The following
 * example illustrates use of a shared style. Syntax: &lt;pre&gt;
 * &lt;strong&gt;&lt;Document id="ID"&gt; &lt;/strong&gt; &lt;!-- inherited from
 * &lt;em&gt;Feature &lt;/em&gt; element --&gt; &lt;name&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/name&gt; &lt;!-- string --&gt;
 * &lt;visibility&gt;1&lt;/visibility&gt; &lt;!-- boolean --&gt;
 * &lt;open&gt;0&lt;/open&gt; &lt;!-- boolean --&gt;
 * &lt;span&gt;&lt;atom:author&gt;...&lt;atom:author&gt; &lt;!-- xmlns:atom
 * --&gt; &lt;atom:link&gt;...&lt;/atom:link&gt; &lt;/span&gt; &lt;span&gt;
 * &lt;!-- xmlns:atom --&gt; &lt;/span&gt; &lt;address&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/address&gt; &lt;!-- string --&gt;
 * &lt;xal:AddressDetails&gt;...&lt;/xal:AddressDetails&gt; &lt;!-- xmlns:xal
 * --&gt; &lt;br&gt; &lt;phoneNumber&gt;...&lt;/phoneNumber&gt; &lt;!-- string
 * --&gt; &lt;br&gt; &lt;Snippet maxLines="2"&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/Snippet&gt; &lt;!-- string --&gt; &lt;description&gt;
 * &lt;em&gt;... &lt;/em&gt;&lt;/description&gt; &lt;!-- string --&gt;
 * &lt;span&gt; &lt;em&gt;&lt;AbstractView&gt;...&lt;/AbstractView&gt;
 * &lt;/em&gt; &lt;!-- Camera &lt;em&gt;or &lt;/em&gt; LookAt --&gt;
 * &lt;/span&gt; &lt; &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;...&lt;/
 * &lt;em&gt;TimePrimitive &lt;/em&gt;&gt; &lt;styleUrl&gt; &lt;em&gt;...
 * &lt;/em&gt;&lt;/styleUrl&gt; &lt;!-- anyURI --&gt; &lt;
 * &lt;em&gt;StyleSelector&gt;...&lt;/StyleSelector&gt; &lt;/em&gt;
 * &lt;Region&gt;...&lt;/Region&gt;
 * &lt;span&gt;&lt;Metadata&gt;...&lt;/Metadata&gt; &lt;!-- deprecated in KML
 * 2.2 --&gt; &lt;ExtendedData&gt;...&lt;/ExtendedData&gt; &lt;!-- new in KML
 * 2.2 --&gt; &lt;/span&gt;
 * <p>
 * &lt;!-- specific to Document --&gt; &lt;!-- 0 or more Schema elements --&gt;
 * &lt;!-- 0 or more &lt;em&gt;Feature &lt;/em&gt; elements --&gt;
 * &lt;strong&gt;&lt;/Document&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Container&gt;
 *
 * Contains:
 * @see: &lt;Feature&gt;
 * @see: &lt;Schema&gt;
 * @see: &lt;StyleSelector&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentType", propOrder = {
  "schema",
  "feature",
  "documentSimpleExtension",
  "documentObjectExtension"
})
@XmlRootElement(name = "Document", namespace = "http://www.opengis.net/kml/2.2")
public class Document extends Container implements Cloneable {

  /**
   * &lt;Schema&gt;
   * <p>
   * Specifies a custom KML schema that is used to add custom data to KML
   * Features. The "id" attribute is required and must be unique within the KML
   * file. &lt;Schema&gt; is always a child of &lt;Document&gt;. Syntax:
   * <pre>&lt;Schema name="string" id="ID"&gt;
   *   &lt;SimpleField type="string" name="string"&gt;
   *     &lt;displayName&gt;...&lt;/displayName&gt;            &lt;!-- string --&gt;
   *   &lt;/SimpleField&gt;
   * &lt;/Schema&gt; </pre>
   * <p>
   * Extends:
   *
   * @see: This is a root element.
   *
   * Contained By:
   * @see: &lt;Document&gt;
   *
   * See Also: &lt;SchemaData&gt;
   *
   */
  @XmlElement(name = "Schema")
  protected List<Schema> schema;
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
  @XmlElement(name = "DocumentSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> documentSimpleExtension;
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
  @XmlElement(name = "DocumentObjectExtensionGroup")
  protected List<AbstractObject> documentObjectExtension;

  public Document() {
    super();
  }

  /**
   * @see schema
   *
   */
  public List<Schema> getSchema() {
    if (schema == null) {
      schema = new ArrayList<>();
    }
    return this.schema;
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
   * @see documentSimpleExtension
   *
   */
  public List<Object> getDocumentSimpleExtension() {
    if (documentSimpleExtension == null) {
      documentSimpleExtension = new ArrayList<>();
    }
    return this.documentSimpleExtension;
  }

  /**
   * @see documentObjectExtension
   *
   */
  public List<AbstractObject> getDocumentObjectExtension() {
    if (documentObjectExtension == null) {
      documentObjectExtension = new ArrayList<>();
    }
    return this.documentObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((schema == null) ? 0 : schema.hashCode()));
    result = ((prime * result) + ((feature == null) ? 0 : feature.hashCode()));
    result = ((prime * result) + ((documentSimpleExtension == null) ? 0 : documentSimpleExtension.hashCode()));
    result = ((prime * result) + ((documentObjectExtension == null) ? 0 : documentObjectExtension.hashCode()));
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
    if ((obj instanceof Document) == false) {
      return false;
    }
    Document other = ((Document) obj);
    if (schema == null) {
      if (other.schema != null) {
        return false;
      }
    } else if (schema.equals(other.schema) == false) {
      return false;
    }
    if (feature == null) {
      if (other.feature != null) {
        return false;
      }
    } else if (feature.equals(other.feature) == false) {
      return false;
    }
    if (documentSimpleExtension == null) {
      if (other.documentSimpleExtension != null) {
        return false;
      }
    } else if (documentSimpleExtension.equals(other.documentSimpleExtension) == false) {
      return false;
    }
    if (documentObjectExtension == null) {
      if (other.documentObjectExtension != null) {
        return false;
      }
    } else if (documentObjectExtension.equals(other.documentObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code Schema} and adds it to schema. This method
   * is a short version for: &lt;code&gt; Schema schema = new Schema();
   * this.getSchema().add(schema); &lt;/code&gt;
   */
  public Schema createAndAddSchema() {
    Schema newValue = new Schema();
    this.getSchema().add(newValue);
    return newValue;
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
   * @see schema
   *
   * @param schema
   */
  public void setSchema(final List<Schema> schema) {
    this.schema = schema;
  }

  /**
   * add a value to the schema property collection
   *
   * @param schema Objects of the following type are allowed in the list:
   *               {@code Schema}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Document addToSchema(final Schema schema) {
    this.getSchema().add(schema);
    return this;
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
  public Document addToFeature(final Feature feature) {
    this.getFeature().add(feature);
    return this;
  }

  /**
   * @see documentSimpleExtension
   *
   * @param documentSimpleExtension
   */
  public void setDocumentSimpleExtension(final List<Object> documentSimpleExtension) {
    this.documentSimpleExtension = documentSimpleExtension;
  }

  /**
   * add a value to the documentSimpleExtension property collection
   *
   * @param documentSimpleExtension Objects of the following type are allowed in
   *                                the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Document addToDocumentSimpleExtension(final Object documentSimpleExtension) {
    this.getDocumentSimpleExtension().add(documentSimpleExtension);
    return this;
  }

  /**
   * @see documentObjectExtension
   *
   * @param documentObjectExtension
   */
  public void setDocumentObjectExtension(final List<AbstractObject> documentObjectExtension) {
    this.documentObjectExtension = documentObjectExtension;
  }

  /**
   * add a value to the documentObjectExtension property collection
   *
   * @param documentObjectExtension Objects of the following type are allowed in
   *                                the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Document addToDocumentObjectExtension(final AbstractObject documentObjectExtension) {
    this.getDocumentObjectExtension().add(documentObjectExtension);
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
  public Document addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public Document addToStyleSelector(final StyleSelector styleSelector) {
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
  public Document addToFeatureSimpleExtension(final Object featureSimpleExtension) {
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
  public Document addToFeatureObjectExtension(final AbstractObject featureObjectExtension) {
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
  public Document addToContainerSimpleExtension(final Object containerSimpleExtension) {
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
  public Document addToContainerObjectExtension(final AbstractObject containerObjectExtension) {
    super.getContainerObjectExtension().add(containerObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setSchema(List &lt;Schema&gt;)
   *
   * @param schema required parameter
   */
  public Document withSchema(final List<Schema> schema) {
    this.setSchema(schema);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setFeature(List &lt;Feature&gt;)
   *
   * @param feature required parameter
   */
  public Document withFeature(final List<Feature> feature) {
    this.setFeature(feature);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setDocumentSimpleExtension(List &lt;Object&gt;)
   *
   * @param documentSimpleExtension required parameter
   */
  public Document withDocumentSimpleExtension(final List<Object> documentSimpleExtension) {
    this.setDocumentSimpleExtension(documentSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setDocumentObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param documentObjectExtension required parameter
   */
  public Document withDocumentObjectExtension(final List<AbstractObject> documentObjectExtension) {
    this.setDocumentObjectExtension(documentObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Document withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Document withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Document withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public Document withName(final String name) {
    super.withName(name);
    return this;
  }

  @Obvious
  @Override
  public Document withVisibility(final Boolean visibility) {
    super.withVisibility(visibility);
    return this;
  }

  @Obvious
  @Override
  public Document withOpen(final Boolean open) {
    super.withOpen(open);
    return this;
  }

  @Obvious
  @Override
  public Document withAtomAuthor(final Author atomAuthor) {
    super.withAtomAuthor(atomAuthor);
    return this;
  }

  @Obvious
  @Override
  public Document withAtomLink(final Link atomLink) {
    super.withAtomLink(atomLink);
    return this;
  }

  @Obvious
  @Override
  public Document withAddress(final String address) {
    super.withAddress(address);
    return this;
  }

  @Obvious
  @Override
  public Document withXalAddressDetails(final AddressDetails xalAddressDetails) {
    super.withXalAddressDetails(xalAddressDetails);
    return this;
  }

  @Obvious
  @Override
  public Document withPhoneNumber(final String phoneNumber) {
    super.withPhoneNumber(phoneNumber);
    return this;
  }

  @Obvious
  @Override
  public Document withSnippet(final Snippet snippet) {
    super.withSnippet(snippet);
    return this;
  }

  @Obvious
  @Override
  public Document withSnippetd(final String snippetd) {
    super.withSnippetd(snippetd);
    return this;
  }

  @Obvious
  @Override
  public Document withDescription(final String description) {
    super.withDescription(description);
    return this;
  }

  @Obvious
  @Override
  public Document withAbstractView(final AbstractView abstractView) {
    super.withAbstractView(abstractView);
    return this;
  }

  @Obvious
  @Override
  public Document withTimePrimitive(final TimePrimitive timePrimitive) {
    super.withTimePrimitive(timePrimitive);
    return this;
  }

  @Obvious
  @Override
  public Document withStyleUrl(final String styleUrl) {
    super.withStyleUrl(styleUrl);
    return this;
  }

  @Obvious
  @Override
  public Document withStyleSelector(final List<StyleSelector> styleSelector) {
    super.withStyleSelector(styleSelector);
    return this;
  }

  @Obvious
  @Override
  public Document withRegion(final Region region) {
    super.withRegion(region);
    return this;
  }

  @Obvious
  @Override
  public Document withMetadata(final Metadata metadata) {
    super.withMetadata(metadata);
    return this;
  }

  @Obvious
  @Override
  public Document withExtendedData(final ExtendedData extendedData) {
    super.withExtendedData(extendedData);
    return this;
  }

  @Obvious
  @Override
  public Document withFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.withFeatureSimpleExtension(featureSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Document withFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.withFeatureObjectExtension(featureObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Document withContainerSimpleExtension(final List<Object> containerSimpleExtension) {
    super.withContainerSimpleExtension(containerSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Document withContainerObjectExtension(final List<AbstractObject> containerObjectExtension) {
    super.withContainerObjectExtension(containerObjectExtension);
    return this;
  }

  @Override
  public Document clone() {
    Document copy;
    copy = ((Document) super.clone());
    copy.schema = new ArrayList<>((getSchema().size()));
    for (Schema iter : schema) {
      copy.schema.add(iter.clone());
    }
    copy.feature = new ArrayList<>((getFeature().size()));
    for (Feature iter : feature) {
      copy.feature.add(iter.clone());
    }
    copy.documentSimpleExtension = new ArrayList<>((getDocumentSimpleExtension().size()));
    for (Object iter : documentSimpleExtension) {
      copy.documentSimpleExtension.add(iter);
    }
    copy.documentObjectExtension = new ArrayList<>((getDocumentObjectExtension().size()));
    for (AbstractObject iter : documentObjectExtension) {
      copy.documentObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
