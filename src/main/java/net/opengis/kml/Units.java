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
 * Units
 * <p>
 * fraction, pixels, insetPixels See Also: See &lt;hotSpot&gt; in
 * &lt;IconStyle&gt;, &lt;ScreenOverlay&gt;
 * <p>
 */
@XmlType(name = "unitsEnumType")
@XmlEnum
public enum Units {

  @XmlEnumValue("fraction")
  FRACTION("fraction"),
  @XmlEnumValue("pixels")
  PIXELS("pixels"),
  @XmlEnumValue("insetPixels")
  INSET_PIXELS("insetPixels");
  private final String value;

  Units(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static Units fromValue(String v) {
    for (Units c : Units.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

}
