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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.opengis.kml.gx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.kml.AbstractObject;

/**
 * <gx:TourPrimitive>
 * <p>
 * Elements extended from gx:TourPrimitive provide instructions to KML browsers
 * during tours, including points to fly to and the duration of those flights,
 * pauses, updates to KML features, and sound files to play.
 * </p>
 * <p>
 * These elements must be contained within a <gx:Playlist> element, which in
 * turn is contained with a <gx:Tour> element.
 * </p>
 * <p>
 * This is an abstract element and cannot be used directly in a KML file. This
 * element is extended by the <gx:FlyTo>, <gx:AnimatedUpdate>, <gx:TourControl>,
 * <gx:Wait>, and <gx:SoundCue> elements.
 * </p>
 * <p>
 * Syntax:
 * <pre>&lt;gx:Tour&gt;
 *   &lt;gx:Playlist&gt;
 * <p>
 *     &lt;!-- abstract element; do not create --&gt;
 *     <strong>&lt;!-- gx:TourPrimitive --&gt;</strong>    &lt;!-- gx:AnimatedUpdate, gx:FlyTo, gx:TourControl, gx:SoundCue, gx:Wait --&gt;
 *         &lt;!-- extends <strong>Object</strong> --&gt;
 *     <strong>&lt;!-- /gx:TourPrimitive --&gt;</strong>
 * <p>
 *   &lt;/gx:Playlist&gt;
 * &lt;/gx:Tour&gt;
 * </pre>
 * <p>
 * Extends:
 *
 * @see: <Object>
 *
 * Extended By:
 * @see: <gx:AnimatedUpdate>
 * @see: <gx:FlyTo>
 * @see: <gx:SoundCue>
 * @see: <gx:TourControl>
 * @see: <gx:Wait>
 *
 * Contained By:
 * @see: <gx:Playlist>
 *
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractTourPrimitiveType")
@XmlSeeAlso({
  Wait.class,
  AnimatedUpdate.class,
  TourControl.class,
  FlyTo.class,
  SoundCue.class
})
public abstract class TourPrimitive
        extends AbstractObject
        implements Cloneable {

  public TourPrimitive() {
    super();
  }

  @Override
  public TourPrimitive clone() {
    TourPrimitive copy;
    copy = ((TourPrimitive) super.clone());
    return copy;
  }

}
