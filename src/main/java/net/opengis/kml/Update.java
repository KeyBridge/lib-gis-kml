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
 *  &lt;Update&gt;
 *   
 * Specifies an addition, change, or deletion to KML data that has already been
 * loaded using the specified URL. The  &lt;targetHref&gt; specifies the .kml or .kmz
 * file whose data (within Google Earth) is to be modified.  &lt;Update&gt; is always
 * contained in a NetworkLinkControl. Furthermore, the file containing the
 * NetworkLinkControl must have been loaded by a NetworkLink. See the "Topics in
 * KML" page on Updates for a detailed example of how Update works. With
 *  &lt;Update&gt;, you can specify any number of Change, Create, and Delete tags for a
 * .kml file or .kmz archive that has previously been loaded with a network
 * link. See  &lt;Update&gt;. Syntax:
 *  <pre> &lt;strong&gt;&lt;Update&gt;
 *    &lt;/strong&gt;&lt;targetHref&gt;...&lt;targetHref&gt;    &lt;!-- URL --&gt;
 *   &lt;Change&gt;...&lt;/Change&gt;
 *   &lt;Create&gt;...&lt;/Create&gt;
 *   &lt;Delete&gt;...&lt;/Delete&gt;
 *  &lt;strong&gt;&lt;/Update&gt; &lt;/strong&gt; </pre>
 *   
 * Contained By:
 *
 * @see:  &lt;NetworkLinkControl&gt;
 * @see: Note: This element was deprecated in KML Release 2.1 and is replaced by
 *  &lt;Link&gt;, which provides the additional functionality of Regions. The  &lt;Url&gt; tag
 * will still work in Google Earth, but use of the newer  &lt;Link&gt; tag is
 * encouraged.
 * @see: Use this element to set the location of the link to the KML file, to
 * define the refresh options for the server and viewer changes, and to populate
 * a variable to return useful client information to the server.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateType", propOrder = {
  "targetHref",
  "createOrDeleteOrChange",
  "updateExtension"
})
@XmlRootElement(name = "Update", namespace = "http://www.opengis.net/kml/2.2")
public class Update implements Cloneable {

  /**
   *  &lt;targethref&gt; (required)
   *   
   * A URL that specifies the .kml or .kmz file whose data (within Google Earth)
   * is to be modified by an  &lt;Update&gt; element. This KML file must already have
   * been loaded via a  &lt;NetworkLink&gt;. In that file, the element to be modified
   * must already have an explicit id attribute defined for it. Specifies the
   * texture file to be fetched by Google Earth. This reference can be a
   * relative reference to an image file within the .kmz archive, or it can be
   * an absolute reference to the file (for example, a URL).
   */
  @XmlElement(required = true)
  @XmlSchemaType(name = "anyURI")
  protected String targetHref;
  @XmlElements({
    @XmlElement(name = "UpdateOpExtensionGroup")
    ,
    @XmlElement(name = "Change", type = Change.class)
    ,
    @XmlElement(name = "Delete", type = Delete.class)
    ,
    @XmlElement(name = "Create", type = Create.class)
  })
  protected List<Object> createOrDeleteOrChange;
  @XmlElement(name = "UpdateExtensionGroup")
  protected List<Object> updateExtension;

  /**
   * Value constructor with only mandatory fields
   *
   * @param createOrDeleteOrChange required parameter
   * @param targetHref             required parameter
   */
  public Update(final String targetHref, final List<Object> createOrDeleteOrChange) {
    super();
    this.targetHref = targetHref;
    this.createOrDeleteOrChange = createOrDeleteOrChange;
  }

  /**
   * Default no-arg constructor is private. Use overloaded constructor instead!
   * (Temporary solution, till a better and more suitable ObjectFactory is
   * created.)
   *   
   */
  @Deprecated
  private Update() {
    super();
  }

  /**
   * @see targetHref
   *
   * @return possible object is {@link String}
   *
   */
  public String getTargetHref() {
    return targetHref;
  }

  /**
   * @see targetHref
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setTargetHref(String value) {
    this.targetHref = value;
  }

  /**
   * @see createOrDeleteOrChange
   *
   */
  public List<Object> getCreateOrDeleteOrChange() {
    if (createOrDeleteOrChange == null) {
      createOrDeleteOrChange = new ArrayList<>();
    }
    return this.createOrDeleteOrChange;
  }

  /**
   * @see updateExtension
   *
   */
  public List<Object> getUpdateExtension() {
    if (updateExtension == null) {
      updateExtension = new ArrayList<>();
    }
    return this.updateExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((targetHref == null) ? 0 : targetHref.hashCode()));
    result = ((prime * result) + ((createOrDeleteOrChange == null) ? 0 : createOrDeleteOrChange.hashCode()));
    result = ((prime * result) + ((updateExtension == null) ? 0 : updateExtension.hashCode()));
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
    if ((obj instanceof Update) == false) {
      return false;
    }
    Update other = ((Update) obj);
    if (targetHref == null) {
      if (other.targetHref != null) {
        return false;
      }
    } else if (targetHref.equals(other.targetHref) == false) {
      return false;
    }
    if (createOrDeleteOrChange == null) {
      if (other.createOrDeleteOrChange != null) {
        return false;
      }
    } else if (createOrDeleteOrChange.equals(other.createOrDeleteOrChange) == false) {
      return false;
    }
    if (updateExtension == null) {
      if (other.updateExtension != null) {
        return false;
      }
    } else if (updateExtension.equals(other.updateExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * @see createOrDeleteOrChange
   *
   * @param createOrDeleteOrChange
   */
  public void setCreateOrDeleteOrChange(final List<Object> createOrDeleteOrChange) {
    this.createOrDeleteOrChange = createOrDeleteOrChange;
  }

  /**
   * add a value to the createOrDeleteOrChange property collection
   *
   * @param createOrDeleteOrChange Objects of the following type are allowed in
   *                               the list:
   *                               {@link Object}{@link Change}{@link Delete}{@link Create}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Update addToCreateOrDeleteOrChange(final Object createOrDeleteOrChange) {
    this.getCreateOrDeleteOrChange().add(createOrDeleteOrChange);
    return this;
  }

  /**
   * @see updateExtension
   *
   * @param updateExtension
   */
  public void setUpdateExtension(final List<Object> updateExtension) {
    this.updateExtension = updateExtension;
  }

  /**
   * add a value to the updateExtension property collection
   *
   * @param updateExtension Objects of the following type are allowed in the
   *                        list: {@link Object}
   * @return  &lt;tt&gt;true &lt;/tt&gt; (as general contract of  &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Update addToUpdateExtension(final Object updateExtension) {
    this.getUpdateExtension().add(updateExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setUpdateExtension(List &lt;Object&gt;)
   *
   * @param updateExtension required parameter
   */
  public Update withUpdateExtension(final List<Object> updateExtension) {
    this.setUpdateExtension(updateExtension);
    return this;
  }

  @Override
  public Update clone() {
    Update copy;
    try {
      copy = ((Update) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.createOrDeleteOrChange = new ArrayList<>((getCreateOrDeleteOrChange().size()));
    for (Object iter : createOrDeleteOrChange) {
      copy.createOrDeleteOrChange.add(iter);
    }
    copy.updateExtension = new ArrayList<>((getUpdateExtension().size()));
    for (Object iter : updateExtension) {
      copy.updateExtension.add(iter);
    }
    return copy;
  }

}
