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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * &lt;Style&gt;
 * <p>
 * A Style defines an addressable style group that can be referenced by
 * StyleMaps and Features. Styles affect how Geometry is presented in the 3D
 * viewer and how Features appear in the Places panel of the List view. Shared
 * styles are collected in a &lt;Document&gt; and must have an id defined for
 * them so that they can be referenced by the individual Features that use them.
 * A Style defines an addressable style group that can be referenced by
 * StyleMaps and Features. Styles affect how Geometry is presented in the 3D
 * viewer and how Features appear in the Places panel of the List view. Shared
 * styles are collected in a &lt;Document&gt; and must have an id defined for
 * them so that they can be referenced by the individual Features that use them.
 * Use an id to refer to the style from a &lt;styleUrl&gt;. Syntax:
 * <pre> &lt;strong&gt;&lt;Style id="ID"&gt;
 *  &lt;/strong&gt;&lt;!-- extends StyleSelector --&gt;
 *
 * &lt;!-- specific to Style --&gt;
 *   &lt;IconStyle&gt;...&lt;/IconStyle&gt;
 *   &lt;LabelStyle&gt;...&lt;/LabelStyle&gt;
 *   &lt;LineStyle&gt;...&lt;/LineStyle&gt;
 *   &lt;PolyStyle&gt;...&lt;/PolyStyle&gt;
 *   &lt;BalloonStyle&gt;...&lt;/BalloonStyle&gt;
 *   &lt;ListStyle&gt; &lt;strong&gt;... &lt;/strong&gt;&lt;/ListStyle&gt; &lt;strong&gt;
 * &lt;/Style&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;StyleSelector&gt;
 *
 * Contained By:
 * @see: &lt;Feature&gt;
 *
 */
@XmlType(name = "styleStateEnumType")
@XmlEnum
public enum StyleState {

  @XmlEnumValue("normal")
  NORMAL("normal"),
  @XmlEnumValue("highlight")
  HIGHLIGHT("highlight");
  private final String value;

  StyleState(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static StyleState fromValue(String v) {
    for (StyleState c : StyleState.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

}
