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
package net.opengis.kml.gx;

import java.util.List;
import javax.xml.bind.annotation.*;
import net.opengis.kml.*;
import net.opengis.kml.annotations.Obvious;
import net.opengis.kml.atom.Author;
import net.opengis.kml.atom.Link;
import net.opengis.kml.xal.AddressDetails;

/**
 *  &lt;gx:Tour&gt;
 *   
 *  &lt;gx:Tour&gt; can contain a single  &lt;gx:Playlist&gt; element, which in turn contains
 * an ordered list of gx:TourPrimitive elements that define a tour in any KML
 * browser. Learn more about tours. Syntax:
 *  <pre>&lt;gx:Tour&gt;
 *   &lt;name&gt;...&lt;/name&gt;
 *   &lt;description&gt;...&lt;/description&gt;
 *   &lt;gx:Playlist&gt;
 *
 *     &lt;!-- any number of  &lt;em&gt;gx:TourPrimitive &lt;/em&gt; elements --&gt;
 *
 *   &lt;/gx:Playlist&gt;
 * &lt;/gx:Tour&gt; </pre>
 *   
 * Contains:
 *
 * @see:  &lt;gx:Playlist&gt;
 * @see:  &lt;gx:Tour&gt;
 * @see:  &lt;gx:Tour&gt;  &lt;gx:Playlist&gt;  &lt;!-- gx:TourPrimitive --&gt; ...
 *  &lt;!-- /gx:TourPrimitive --&gt;
 *  &lt;!--- Any number of gx:TourPrimitive elements can be included ---&gt;
 *  &lt;/gx:Playlist&gt;  &lt;/gx:Tour&gt;
 * @see: gx:Playlist
 * @see: gx:TourPrimitive
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TourType", propOrder = {
  "playlist"
})
@XmlRootElement(name = "Tour", namespace = "http://www.google.com/kml/ext/2.2")
public class Tour
  extends Feature
  implements Cloneable {

  @XmlElement(name = "Playlist")
  protected Playlist playlist;

  public Tour() {
    super();
  }

  /**
   * @see playlist
   *
   * @return possible object is {@link Playlist}
   *
   */
  public Playlist getPlaylist() {
    return playlist;
  }

  /**
   * @see playlist
   *
   * @param value allowed object is {@link Playlist}
   *
   */
  public void setPlaylist(Playlist value) {
    this.playlist = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((playlist == null) ? 0 : playlist.hashCode()));
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
    if ((obj instanceof Tour) == false) {
      return false;
    }
    Tour other = ((Tour) obj);
    if (playlist == null) {
      if (other.playlist != null) {
        return false;
      }
    } else if (playlist.equals(other.playlist) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link Playlist} and set it to playlist.
   *   
   * This method is a short version for:     &lt;code&gt;
   * Playlist playlist = new Playlist();
   * this.setPlaylist(playlist);  &lt;/code&gt;
   */
  public Playlist createAndSetPlaylist() {
    Playlist newValue = new Playlist();
    this.setPlaylist(newValue);
    return newValue;
  }

  /**
   * fluent setter
   *
   * @see #setPlaylist(Playlist)
   *
   * @param playlist required parameter
   */
  public Tour withPlaylist(final Playlist playlist) {
    this.setPlaylist(playlist);
    return this;
  }

  @Obvious
  @Override
  public Tour withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Tour withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public Tour withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public Tour withName(final String name) {
    super.withName(name);
    return this;
  }

  @Obvious
  @Override
  public Tour withVisibility(final Boolean visibility) {
    super.withVisibility(visibility);
    return this;
  }

  @Obvious
  @Override
  public Tour withOpen(final Boolean open) {
    super.withOpen(open);
    return this;
  }

  @Obvious
  @Override
  public Tour withAtomAuthor(final Author atomAuthor) {
    super.withAtomAuthor(atomAuthor);
    return this;
  }

  @Obvious
  @Override
  public Tour withAtomLink(final Link atomLink) {
    super.withAtomLink(atomLink);
    return this;
  }

  @Obvious
  @Override
  public Tour withAddress(final String address) {
    super.withAddress(address);
    return this;
  }

  @Obvious
  @Override
  public Tour withXalAddressDetails(final AddressDetails xalAddressDetails) {
    super.withXalAddressDetails(xalAddressDetails);
    return this;
  }

  @Obvious
  @Override
  public Tour withPhoneNumber(final String phoneNumber) {
    super.withPhoneNumber(phoneNumber);
    return this;
  }

  @Obvious
  @Override
  public Tour withSnippet(final Snippet snippet) {
    super.withSnippet(snippet);
    return this;
  }

  @Obvious
  @Override
  public Tour withSnippetd(final String snippetd) {
    super.withSnippetd(snippetd);
    return this;
  }

  @Obvious
  @Override
  public Tour withDescription(final String description) {
    super.withDescription(description);
    return this;
  }

  @Obvious
  @Override
  public Tour withAbstractView(final AbstractView abstractView) {
    super.withAbstractView(abstractView);
    return this;
  }

  @Obvious
  @Override
  public Tour withTimePrimitive(final TimePrimitive timePrimitive) {
    super.withTimePrimitive(timePrimitive);
    return this;
  }

  @Obvious
  @Override
  public Tour withStyleUrl(final String styleUrl) {
    super.withStyleUrl(styleUrl);
    return this;
  }

  @Obvious
  @Override
  public Tour withStyleSelector(final List<StyleSelector> styleSelector) {
    super.withStyleSelector(styleSelector);
    return this;
  }

  @Obvious
  @Override
  public Tour withRegion(final Region region) {
    super.withRegion(region);
    return this;
  }

  @Obvious
  @Override
  public Tour withMetadata(final Metadata metadata) {
    super.withMetadata(metadata);
    return this;
  }

  @Obvious
  @Override
  public Tour withExtendedData(final ExtendedData extendedData) {
    super.withExtendedData(extendedData);
    return this;
  }

  @Obvious
  @Override
  public Tour withFeatureSimpleExtension(final List<Object> featureSimpleExtension) {
    super.withFeatureSimpleExtension(featureSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public Tour withFeatureObjectExtension(final List<AbstractObject> featureObjectExtension) {
    super.withFeatureObjectExtension(featureObjectExtension);
    return this;
  }

  @Override
  public Tour clone() {
    Tour copy;
    copy = ((Tour) super.clone());
    copy.playlist = ((playlist == null) ? null : ((Playlist) playlist.clone()));
    return copy;
  }

}
