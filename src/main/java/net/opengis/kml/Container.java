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
 * &lt;Container&gt;
 * <p>
 * This is an abstract element and cannot be used directly in a KML file. A
 * Container element holds one or more Features and allows the creation of
 * nested hierarchies. Syntax:
 * <pre>&lt;!-- abstract element; do not create --&gt;
 *  &lt;strong&gt;&lt;!--  &lt;em&gt;Container &lt;/em&gt; id="ID" --&gt; &lt;/strong&gt;              &lt;!-- Document,Folder --&gt;
 *   &lt;!-- inherited from  &lt;em&gt;Feature &lt;/em&gt; element --&gt;
 *   &lt;name&gt; &lt;em&gt;... &lt;/em&gt;&lt;/name&gt;                      &lt;!-- string --&gt;
 *   &lt;visibility&gt;1&lt;/visibility&gt;            &lt;!-- boolean --&gt;
 *   &lt;open&gt;0&lt;/open&gt;                        &lt;!-- boolean --&gt;
 *   &lt;address&gt; &lt;em&gt;... &lt;/em&gt;&lt;/address&gt;                &lt;!-- string --&gt;
 *   &lt;AddressDetails xmlns="urn:oasis:names:tc:ciq:xsdschema:xAL:2.0"&gt;... &lt;br&gt;      &lt;/AddressDetails&gt;                 &lt;!-- string --&gt;
 *   &lt;phoneNumber&gt;...&lt;/phoneNumber&gt;        &lt;!-- string --&gt; &lt;br&gt;  &lt;Snippet maxLines="2"&gt; &lt;em&gt;... &lt;/em&gt;&lt;/Snippet&gt;   &lt;!-- string --&gt;
 *   &lt;description&gt; &lt;em&gt;... &lt;/em&gt;&lt;/description&gt;        &lt;!-- string --&gt;
 *    &lt;span&gt; &lt;em&gt;&lt;AbstractView&gt;...&lt;/AbstractView&gt; &lt;/em&gt;      &lt;!-- LookAt  &lt;em&gt;or &lt;/em&gt; Camera --&gt; &lt;/span&gt;
 *   &lt; &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;...&lt;/ &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;
 *   &lt;styleUrl&gt; &lt;em&gt;... &lt;/em&gt;&lt;/styleUrl&gt;              &lt;!-- anyURI --&gt;
 *   &lt; &lt;em&gt;StyleSelector&gt;...&lt;/StyleSelector&gt; &lt;/em&gt;
 *   &lt;Region&gt;...&lt;/Region&gt;
 *   &lt;Metadata&gt;...&lt;/Metadata&gt;
 *    &lt;span&gt;&lt;atom:author&gt;...&lt;atom:author&gt;   &lt;!-- xmlns:atom="http://www.w3.org/2005/Atom" --&gt;
 *   &lt;atom:link&gt;...&lt;/atom:link&gt; &lt;/span&gt;
 *
 *   &lt;!-- specific to  &lt;em&gt;Container &lt;/em&gt; --&gt;  &lt;br&gt;  &lt;!-- 0 or more Features --&gt;
 *  &lt;strong&gt;&lt;!-- / &lt;em&gt;Container -- &lt;/em&gt;&gt; &lt;/strong&gt;
 * </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Feature&gt;
 *
 * Extended By:
 * @see: &lt;Document&gt;
 * @see: &lt;Folder&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractContainerType", propOrder = {
  "containerSimpleExtension",
  "containerObjectExtension"
})
@XmlSeeAlso({
  Folder.class,
  Document.class
})
public abstract class Container extends Feature implements Cloneable {

  @XmlElement(name = "AbstractContainerSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> containerSimpleExtension;
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
  @XmlElement(name = "AbstractContainerObjectExtensionGroup")
  protected List<AbstractObject> containerObjectExtension;

  public Container() {
    super();
  }

  /**
   * @see containerSimpleExtension
   *
   */
  public List<Object> getContainerSimpleExtension() {
    if (containerSimpleExtension == null) {
      containerSimpleExtension = new ArrayList<>();
    }
    return this.containerSimpleExtension;
  }

  /**
   * @see containerObjectExtension
   *
   */
  public List<AbstractObject> getContainerObjectExtension() {
    if (containerObjectExtension == null) {
      containerObjectExtension = new ArrayList<>();
    }
    return this.containerObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((containerSimpleExtension == null) ? 0 : containerSimpleExtension.hashCode()));
    result = ((prime * result) + ((containerObjectExtension == null) ? 0 : containerObjectExtension.hashCode()));
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
    if ((obj instanceof Container) == false) {
      return false;
    }
    Container other = ((Container) obj);
    if (containerSimpleExtension == null) {
      if (other.containerSimpleExtension != null) {
        return false;
      }
    } else if (containerSimpleExtension.equals(other.containerSimpleExtension) == false) {
      return false;
    }
    if (containerObjectExtension == null) {
      if (other.containerObjectExtension != null) {
        return false;
      }
    } else if (containerObjectExtension.equals(other.containerObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see containerSimpleExtension
   *
   * @param containerSimpleExtension
   */
  public void setContainerSimpleExtension(final List<Object> containerSimpleExtension) {
    this.containerSimpleExtension = containerSimpleExtension;
  }

  /**
   * add a value to the containerSimpleExtension property collection
   *
   * @param containerSimpleExtension Objects of the following type are allowed
   *                                 in the list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Container addToContainerSimpleExtension(final Object containerSimpleExtension) {
    this.getContainerSimpleExtension().add(containerSimpleExtension);
    return this;
  }

  /**
   * @see containerObjectExtension
   *
   * @param containerObjectExtension
   */
  public void setContainerObjectExtension(final List<AbstractObject> containerObjectExtension) {
    this.containerObjectExtension = containerObjectExtension;
  }

  /**
   * add a value to the containerObjectExtension property collection
   *
   * @param containerObjectExtension Objects of the following type are allowed
   *                                 in the list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Container addToContainerObjectExtension(final AbstractObject containerObjectExtension) {
    this.getContainerObjectExtension().add(containerObjectExtension);
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
  public Container addToObjectSimpleExtension(final Object objectSimpleExtension) {
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
  public Container addToStyleSelector(final StyleSelector styleSelector) {
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
  public Container addToFeatureSimpleExtension(final Object featureSimpleExtension) {
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
  public Container addToFeatureObjectExtension(final AbstractObject featureObjectExtension) {
    super.getFeatureObjectExtension().add(featureObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setContainerSimpleExtension(List &lt;Object&gt;)
   *
   * @param containerSimpleExtension required parameter
   */
  public Container withContainerSimpleExtension(final List<Object> containerSimpleExtension) {
    this.setContainerSimpleExtension(containerSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setContainerObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param containerObjectExtension required parameter
   */
  public Container withContainerObjectExtension(final List<AbstractObject> containerObjectExtension) {
    this.setContainerObjectExtension(containerObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public Container withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Container withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Container withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public Container withName(final String name) {
    super.withName(name);
    return this;
  }

  @Obvious
  @Override
  public Container withVisibility(final Boolean visibility) {
    super.withVisibility(visibility);
    return this;
  }

  @Obvious
  @Override
  public Container withOpen(final Boolean open) {
    super.withOpen(open);
    return this;
  }

  @Obvious
  @Override
  public Container withAtomAuthor(final Author atomAuthor) {
    super.withAtomAuthor(atomAuthor);
    return this;
  }

  @Obvious
  @Override
  public Container withAtomLink(final Link atomLink) {
    super.withAtomLink(atomLink);
    return this;
  }

  @Obvious
  @Override
  public Container withAddress(final String address) {
    super.withAddress(address);
    return this;
  }

  @Obvious
  @Override
  public Container withXalAddressDetails(final AddressDetails xalAddressDetails) {
    super.withXalAddressDetails(xalAddressDetails);
    return this;
  }

  @Obvious
  @Override
  public Container withPhoneNumber(final String phoneNumber) {
    super.withPhoneNumber(phoneNumber);
    return this;
  }

  @Obvious
  @Override
  public Container withSnippet(final Snippet snippet) {
    super.withSnippet(snippet);
    return this;
  }

  @Obvious
  @Override
  public Container withSnippetd(final String snippetd) {
    super.withSnippetd(snippetd);
    return this;
  }

  @Obvious
  @Override
  public Container withDescription(final String description) {
    super.withDescription(description);
    return this;
  }

  @Obvious
  @Override
  public Container withAbstractView(final AbstractView abstractView) {
    super.withAbstractView(abstractView);
    return this;
  }

  @Obvious
  @Override
  public Container withTimePrimitive(final TimePrimitive timePrimitive) {
    super.withTimePrimitive(timePrimitive);
    return this;
  }

  @Obvious
  @Override
  public Container withStyleUrl(final String styleUrl) {
    super.withStyleUrl(styleUrl);
    return this;
  }

  @Obvious
  @Override
  public Container withStyleSelector(final List<StyleSelector> styleSelector) {
    super.withStyleSelector(styleSelector);
    return this;
  }

  @Obvious
  @Override
  public Container withRegion(final Region region) {
    super.withRegion(region);
    return this;
  }

  @Obvious
  @Override
  public Container withMetadata(final Metadata metadata) {
    super.withMetadata(metadata);
    return this;
  }

  @Obvious
  @Override
  public Container withExtendedData(final ExtendedData extendedData) {
    super.withExtendedData(extendedData);
    return this;
  }

  @Obvious
  @Override
  public Container withFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.withFeatureSimpleExtension(featureSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Container withFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.withFeatureObjectExtension(featureObjectExtension);
    return this;
  }

  @Override
  public Container clone() {
    Container copy;
    copy = ((Container) super.clone());
    copy.containerSimpleExtension = new ArrayList<>((getContainerSimpleExtension().size()));
    for (Object iter : containerSimpleExtension) {
      copy.containerSimpleExtension.add(iter);
    }
    copy.containerObjectExtension = new ArrayList<>((getContainerObjectExtension().size()));
    for (AbstractObject iter : containerObjectExtension) {
      copy.containerObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
