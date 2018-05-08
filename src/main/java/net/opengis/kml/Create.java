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

/**
 *  &lt;create&gt;
 *   
 * Adds new elements to a Folder or Document that has already been loaded via a
 *  &lt;NetworkLink&gt;. The  &lt;targetHref&gt; element in  &lt;Update&gt; specifies the URL of the
 * .kml or .kmz file that contained the original Folder or Document. Within that
 * file, the Folder or Document that is to contain the new data must already
 * have an explicit id defined for it. This id is referenced as the targetId
 * attribute of the Folder or Document within  &lt;Create&gt; that contains the element
 * to be added. Once an object has been created and loaded into Google Earth, it
 * takes on the URL of the original parent Document of Folder. To perform
 * subsequent updates to objects added with this Update/Create mechanism, set
 *  &lt;targetHref&gt; to the URL of the original Document or Folder (not the URL of
 * the file that loaded the intervening updates).
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateType", propOrder = {
  "container"
})
@XmlRootElement(name = "Create", namespace = "http://www.opengis.net/kml/2.2")
public class Create implements Cloneable {

  /**
   *  &lt;Container&gt;
   *   
   * This is an abstract element and cannot be used directly in a KML file. A
   * Container element holds one or more Features and allows the creation of
   * nested hierarchies. Syntax:
   *  <pre>&lt;!-- abstract element; do not create --&gt;
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
   *  &lt;strong&gt;&lt;!-- / &lt;em&gt;Container -- &lt;/em&gt;&gt; &lt;/strong&gt; </pre>
   *   
   * Extends:
   *
   * @see:  &lt;Feature&gt;
   *
   * Extended By:
   * @see:  &lt;Document&gt;
   * @see:  &lt;Folder&gt;
   *
   */
  @XmlElementRef(name = "AbstractContainerGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected List<Container> container;

  public Create() {
    super();
  }

  /**
   * @see container
   *
   */
  public List<Container> getContainer() {
    if (container == null) {
      container = new ArrayList<>();
    }
    return this.container;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((container == null) ? 0 : container.hashCode()));
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
    if ((obj instanceof Create) == false) {
      return false;
    }
    Create other = ((Create) obj);
    if (container == null) {
      if (other.container != null) {
        return false;
      }
    } else if (container.equals(other.container) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link Folder} and adds it to container. This
   * method is a short version for:     &lt;code&gt;
   * Folder folder = new Folder();
   * this.getContainer().add(folder);  &lt;/code&gt;
   */
  public Folder createAndAddFolder() {
    Folder newValue = new Folder();
    this.getContainer().add(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Document} and adds it to container. This
   * method is a short version for:     &lt;code&gt;
   * Document document = new Document();
   * this.getContainer().add(document);  &lt;/code&gt;
   */
  public Document createAndAddDocument() {
    Document newValue = new Document();
    this.getContainer().add(newValue);
    return newValue;
  }

  /**
   * @see container
   *
   * @param container
   */
  public void setContainer(final List<Container> container) {
    this.container = container;
  }

  /**
   * add a value to the container property collection
   *
   * @param container Objects of the following type are allowed in the list:
   *                  {@link Container}{@link JAXBElement}{@link Folder}{@link JAXBElement}{@link Document}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Create addToContainer(final Container container) {
    this.getContainer().add(container);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setContainer(List &lt;Container&gt;)
   *
   * @param container required parameter
   */
  public Create withContainer(final List<Container> container) {
    this.setContainer(container);
    return this;
  }

  @Override
  public Create clone() {
    Create copy;
    try {
      copy = ((Create) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.container = new ArrayList<>((getContainer().size()));
    for (Container iter : container) {
      copy.container.add(iter.clone());
    }
    return copy;
  }

}
