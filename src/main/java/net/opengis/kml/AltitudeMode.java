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
 * AltitudeMode
 *   
 * clampToGround, relativeToGround, absolute See Also: See  &lt;LookAt&gt; and  &lt;Region&gt;
 *   
 */
@XmlType(name = "altitudeModeEnumType")
@XmlEnum
public enum AltitudeMode {

  @XmlEnumValue("clampToGround")
  CLAMP_TO_GROUND("clampToGround"),
  @XmlEnumValue("relativeToGround")
  RELATIVE_TO_GROUND("relativeToGround"),
  @XmlEnumValue("absolute")
  ABSOLUTE("absolute"),
  @XmlEnumValue("clampToSeaFloor")
  CLAMP_TO_SEA_FLOOR("clampToSeaFloor"),
  @XmlEnumValue("relativeToSeaFloor")
  RELATIVE_TO_SEA_FLOOR("relativeToSeaFloor");
  private final String value;

  AltitudeMode(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static AltitudeMode fromValue(String v) {
    for (AltitudeMode c : AltitudeMode.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

}
