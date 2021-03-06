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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for playModeEnumType. The following schema fragment specifies the
 * expected content contained within this class.
 * <p>
 * &lt; pre&gt; &lt;simpleType name="playModeEnumType"&gt; &lt;restriction
 * base="{http://www.w3.org/2001/XMLSchema}string"&gt; &lt;enumeration
 * value="pause"/&gt; &lt;/restriction&gt; &lt;/simpleType&gt;
 * </pre>
 * <p>
 */
@XmlType(name = "playModeEnumType")
@XmlEnum
public enum PlayMode {

  @XmlEnumValue("pause")
  PAUSE("pause");
  private final String value;

  PlayMode(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static PlayMode fromValue(String v) {
    for (PlayMode c : PlayMode.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

}
