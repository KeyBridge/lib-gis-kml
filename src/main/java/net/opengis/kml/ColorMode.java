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
 * ColorMode
 * <p>
 * normal, random See Also: See any element that extends &lt;ColorStyle&gt;
 * <p>
 */
@XmlType(name = "colorModeEnumType")
@XmlEnum
public enum ColorMode {

  @XmlEnumValue("normal")
  NORMAL("normal"),
  @XmlEnumValue("random")
  RANDOM("random");
  private final String value;

  ColorMode(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static ColorMode fromValue(String v) {
    for (ColorMode c : ColorMode.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

}
