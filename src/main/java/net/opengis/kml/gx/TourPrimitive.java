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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.kml.AbstractObject;

/**
 *  &lt;gx:TourPrimitive&gt;
 *   
 * Elements extended from gx:TourPrimitive provide instructions to KML browsers
 * during tours, including points to fly to and the duration of those flights,
 * pauses, updates to KML features, and sound files to play. These elements must
 * be contained within a  &lt;gx:Playlist&gt; element, which in turn is contained with
 * a  &lt;gx:Tour&gt; element. This is an abstract element and cannot be used directly
 * in a KML file. This element is extended by the  &lt;gx:FlyTo&gt;,
 *  &lt;gx:AnimatedUpdate&gt;,  &lt;gx:TourControl&gt;,
 *  &lt;gx:Wait&gt;, and  &lt;gx:SoundCue&gt; elements. Syntax:
 *  <pre>&lt;gx:Tour&gt;
 *   &lt;gx:Playlist&gt;
 *
 *     &lt;!-- abstract element; do not create --&gt;
 *      &lt;strong&gt;&lt;!-- gx:TourPrimitive --&gt; &lt;/strong&gt;    &lt;!-- gx:AnimatedUpdate, gx:FlyTo, gx:TourControl, gx:SoundCue, gx:Wait --&gt;
 *         &lt;!-- extends  &lt;strong&gt;Object &lt;/strong&gt; --&gt;
 *      &lt;strong&gt;&lt;!-- /gx:TourPrimitive --&gt; &lt;/strong&gt;
 *
 *   &lt;/gx:Playlist&gt;
 * &lt;/gx:Tour&gt;
 *  </pre>
 *   
 * Extends:
 *
 * @see:  &lt;Object&gt;
 *
 * Extended By:
 * @see:  &lt;gx:AnimatedUpdate&gt;
 * @see:  &lt;gx:FlyTo&gt;
 * @see:  &lt;gx:SoundCue&gt;
 * @see:  &lt;gx:TourControl&gt;
 * @see:  &lt;gx:Wait&gt;
 *
 * Contained By:
 * @see:  &lt;gx:Playlist&gt;
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
