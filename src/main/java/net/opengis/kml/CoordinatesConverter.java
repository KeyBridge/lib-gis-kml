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
package net.opengis.kml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public final class CoordinatesConverter
        extends XmlAdapter<String, List<Coordinate>> {

  @Override
  public String marshal(final List<Coordinate> dt)
          throws Exception {
    StringBuilder sb = new StringBuilder();
    for (Coordinate coord : dt) {
      sb.append((coord + " "));
    }
    return sb.toString().trim();
  }

  @Override
  public List<Coordinate> unmarshal(final String s)
          throws Exception {
    String[] coords = s.replaceAll(",[\\s]+", ",").trim().split("\\s+");
    List<Coordinate> coordinates = new ArrayList<>();
    if (coords.length <= 0) {
      return coordinates;
    }
    for (String string : coords) {
      coordinates.add(new Coordinate(string));
    }
    return coordinates;
  }

}
