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
package net.opengis.kml.atom;

import javax.xml.bind.annotation.*;

/**
 *  &lt;link&gt; (required). see  &lt;link&gt;.
 *   
 *  &lt;Link&gt; specifies the location of any of the following: If the file specified
 * in  &lt;href&gt; is a local file, the  &lt;viewFormat&gt; and
 *  &lt;httpQuery&gt;
 * elements are not used. KML files fetched by network links Image files used in
 * any Overlay (the
 *  &lt;Icon&gt; element specifies the image in an Overlay;  &lt;Icon&gt; has the same fields
 * as  &lt;Link&gt;) Model files used in the  &lt;Model&gt; element Specifies the URL of the
 * website containing this KML or KMZ file. Be sure to include the namespace for
 * this element in any KML file that uses it:
 * xmlns:atom="http://www.w3.org/2005/Atom" (see the sample that follows).
 * Specifies the file to load and optional refresh parameters. See  &lt;Link&gt;. The
 *  &lt;Link&gt; element replaces the  &lt;Url&gt; element of  &lt;NetworkLink&gt; contained in
 * earlier KML releases and adds functionality for the  &lt;Region&gt; element
 * (introduced in KML 2.1). In Google Earth releases 3.0 and earlier, the  &lt;Link&gt;
 * element is ignored. The file is conditionally loaded and refreshed, depending
 * on the refresh parameters supplied here. Two different sets of refresh
 * parameters can be specified: one set is based on time ( &lt;refreshMode&gt; and
 *  &lt;refreshInterval&gt;) and one is based on the current "camera" view
 * ( &lt;viewRefreshMode&gt; and
 *  &lt;viewRefreshTime&gt;). In addition, Link specifies whether to scale the bounding
 * box parameters that are sent to the server ( &lt;viewBoundScale&gt;
 * and provides a set of optional viewing parameters that can be sent to the
 * server ( &lt;viewFormat&gt;) as well as a set of optional parameters containing
 * version and language information. Tip: To display the top-level Folder or
 * Document within a Network Link in the List View, assign an ID to the Folder
 * or Document. Without this ID, only the child object names are displayed in
 * the List View. When a file is fetched, the URL that is sent to the server is
 * composed of three pieces of information: the href (Hypertext Reference) that
 * specifies the file to load. an arbitrary format string that is created from
 * (a) parameters that you specify in the
 *  &lt;viewFormat&gt;
 * element or (b) bounding box parameters (this is the default and is used if no
 *  &lt;viewFormat&gt;
 * element is included in the file). a second format string that is specified in
 * the
 *  &lt;httpQuery&gt; element. Syntax:
 *  &lt;pre&gt; &lt;strong&gt;&lt;Link id="ID"&gt; &lt;/strong&gt;
 *   &lt;!-- specific to Link --&gt;
 *   &lt;href&gt; &lt;em&gt;... &lt;/em&gt;&lt;/href&gt;                      &lt;!--  &lt;span&gt;string &lt;/span&gt; --&gt;
 *   &lt;refreshMode&gt;onChange&lt;/refreshMode&gt;
 *     &lt;!-- refreshModeEnum: onChange, onInterval,  &lt;em&gt;or &lt;/em&gt; onExpire --&gt;
 *   &lt;refreshInterval&gt;4&lt;/refreshInterval&gt;  &lt;!-- float --&gt;
 *   &lt;viewRefreshMode&gt;never&lt;/viewRefreshMode&gt;
 *     &lt;!-- viewRefreshModeEnum: never, onStop, onRequest, onRegion --&gt;
 *   &lt;viewRefreshTime&gt;4&lt;/viewRefreshTime&gt;  &lt;!-- float --&gt;
 *   &lt;viewBoundScale&gt;1&lt;/viewBoundScale&gt;    &lt;!-- float --&gt;
 *   &lt;viewFormat&gt;BBOX=[bboxWest],[bboxSouth],[bboxEast],[bboxNorth]&lt; &lt;strong&gt;/ &lt;/strong&gt;viewFormat&gt;
 *                                         &lt;!-- string --&gt;
 *   &lt;httpQuery&gt;...&lt;/httpQuery&gt;            &lt;!-- string --&gt;
 *  &lt;strong&gt;&lt;/Link&gt; &lt;/strong&gt; </pre>
 *   
 * Extends:
 *
 * @see:  &lt;Object&gt;
 *
 * Contained By:
 * @see:  &lt;Model&gt;
 * @see:  &lt;NetworkLink&gt;
 *
 * See Also:
 *  &lt;NetworkLinkControl&gt;
 *  &lt;Region&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "link")
public class Link implements Cloneable {

  /**
   *  &lt;href&gt;
   *   
   * A URL (either an HTTP address or a local file specification). When the
   * parent of
   *  &lt;Link&gt; is a NetworkLink,  &lt;href&gt; is a KML file. When the parent of  &lt;Link&gt; is
   * a Model,
   *  &lt;href&gt; is a COLLADA file. When the parent of  &lt;Icon&gt; (same fields as  &lt;Link&gt;)
   * is an Overlay,  &lt;href&gt; is an image. Relative URLs can be used in this tag
   * and are evaluated relative to the enclosing KML file. An HTTP address or a
   * local file specification used to load an icon. Specifies the URI of the
   * image used in the List View for the Feature.
   */
  @XmlAttribute(name = "href", required = true)
  @XmlSchemaType(name = "anySimpleType")
  protected String href;
  @XmlAttribute(name = "rel")
  @XmlSchemaType(name = "anySimpleType")
  protected String rel;
  @XmlAttribute(name = "type")
  protected String type;
  @XmlAttribute(name = "hreflang")
  protected String hreflang;
  @XmlAttribute(name = "title")
  @XmlSchemaType(name = "anySimpleType")
  protected String title;
  @XmlAttribute(name = "length")
  @XmlSchemaType(name = "anySimpleType")
  protected String length;

  /**
   * Value constructor with only mandatory fields
   *
   * @param href required parameter
   */
  public Link(final String href) {
    super();
    this.href = href;
  }

  /**
   * Default no-arg constructor is private. Use overloaded constructor instead!
   * (Temporary solution, till a better and more suitable ObjectFactory is
   * created.)
   *   
   */
  @Deprecated
  private Link() {
    super();
  }

  /**
   * @see href
   *
   * @return possible object is {@link String}
   *
   */
  public String getHref() {
    return href;
  }

  /**
   * @see href
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setHref(String value) {
    this.href = value;
  }

  /**
   * @see rel
   *
   * @return possible object is {@link String}
   *
   */
  public String getRel() {
    return rel;
  }

  /**
   * @see rel
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setRel(String value) {
    this.rel = value;
  }

  /**
   * @see type
   *
   * @return possible object is {@link String}
   *
   */
  public String getType() {
    return type;
  }

  /**
   * @see type
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setType(String value) {
    this.type = value;
  }

  /**
   * @see hreflang
   *
   * @return possible object is {@link String}
   *
   */
  public String getHreflang() {
    return hreflang;
  }

  /**
   * @see hreflang
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setHreflang(String value) {
    this.hreflang = value;
  }

  /**
   * @see title
   *
   * @return possible object is {@link String}
   *
   */
  public String getTitle() {
    return title;
  }

  /**
   * @see title
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setTitle(String value) {
    this.title = value;
  }

  /**
   * @see length
   *
   * @return possible object is {@link String}
   *
   */
  public String getLength() {
    return length;
  }

  /**
   * @see length
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setLength(String value) {
    this.length = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((href == null) ? 0 : href.hashCode()));
    result = ((prime * result) + ((rel == null) ? 0 : rel.hashCode()));
    result = ((prime * result) + ((type == null) ? 0 : type.hashCode()));
    result = ((prime * result) + ((hreflang == null) ? 0 : hreflang.hashCode()));
    result = ((prime * result) + ((title == null) ? 0 : title.hashCode()));
    result = ((prime * result) + ((length == null) ? 0 : length.hashCode()));
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
    if ((obj instanceof Link) == false) {
      return false;
    }
    Link other = ((Link) obj);
    if (href == null) {
      if (other.href != null) {
        return false;
      }
    } else if (href.equals(other.href) == false) {
      return false;
    }
    if (rel == null) {
      if (other.rel != null) {
        return false;
      }
    } else if (rel.equals(other.rel) == false) {
      return false;
    }
    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (type.equals(other.type) == false) {
      return false;
    }
    if (hreflang == null) {
      if (other.hreflang != null) {
        return false;
      }
    } else if (hreflang.equals(other.hreflang) == false) {
      return false;
    }
    if (title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (title.equals(other.title) == false) {
      return false;
    }
    if (length == null) {
      if (other.length != null) {
        return false;
      }
    } else if (length.equals(other.length) == false) {
      return false;
    }
    return true;
  }

  /**
   * fluent setter
   *
   * @see #setRel(String)
   *
   * @param rel required parameter
   */
  public Link withRel(final String rel) {
    this.setRel(rel);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setType(String)
   *
   * @param type required parameter
   */
  public Link withType(final String type) {
    this.setType(type);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setHreflang(String)
   *
   * @param hreflang required parameter
   */
  public Link withHreflang(final String hreflang) {
    this.setHreflang(hreflang);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setTitle(String)
   *
   * @param title required parameter
   */
  public Link withTitle(final String title) {
    this.setTitle(title);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setLength(String)
   *
   * @param length required parameter
   */
  public Link withLength(final String length) {
    this.setLength(length);
    return this;
  }

  @Override
  public Link clone() {
    Link copy;
    try {
      copy = ((Link) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    return copy;
  }

}
