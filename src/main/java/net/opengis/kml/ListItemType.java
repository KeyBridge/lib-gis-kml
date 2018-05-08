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
 * &lt;listitemtype&gt;
 * <p>
 * Specifies how a Feature is displayed in the list view. Possible values are:
 * check (default) - The Feature's visibility is tied to its item's checkbox.
 * radioFolder - When specified for a Container, only one of the Container's
 * items is visible at a time checkOffOnly - When specified for a Container or
 * Network Link, prevents all items from being made visible at once—that is, the
 * user can turn everything in the Container or Network Link off but cannot turn
 * everything on at the same time. This setting is useful for Containers or
 * Network Links containing large amounts of data. checkHideChildren - Use a
 * normal checkbox for visibility but do not display the Container or Network
 * Link's children in the list view. A checkbox allows the user to toggle
 * visibility of the child objects in the viewer.
 */
@XmlType(name = "listItemTypeEnumType")
@XmlEnum
public enum ListItemType {

  @XmlEnumValue("radioFolder")
  RADIO_FOLDER("radioFolder"),
  @XmlEnumValue("check")
  CHECK("check"),
  @XmlEnumValue("checkHideChildren")
  CHECK_HIDE_CHILDREN("checkHideChildren"),
  @XmlEnumValue("checkOffOnly")
  CHECK_OFF_ONLY("checkOffOnly");
  private final String value;

  ListItemType(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static ListItemType fromValue(String v) {
    for (ListItemType c : ListItemType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

}
