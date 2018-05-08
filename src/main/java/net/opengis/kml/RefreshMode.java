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
 * RefreshMode
 * <p>
 * onChange, onInterval, onExpire See Also: See &lt;Link&gt;
 * <p>
 */
@XmlType(name = "refreshModeEnumType")
@XmlEnum
public enum RefreshMode {

  @XmlEnumValue("onChange")
  ON_CHANGE("onChange"),
  @XmlEnumValue("onInterval")
  ON_INTERVAL("onInterval"),
  @XmlEnumValue("onExpire")
  ON_EXPIRE("onExpire");
  private final String value;

  RefreshMode(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static RefreshMode fromValue(String v) {
    for (RefreshMode c : RefreshMode.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

}
