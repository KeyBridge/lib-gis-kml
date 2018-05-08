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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import net.opengis.kml.annotations.Obvious;

/**
 * &lt;ListStyle&gt;
 * <p>
 * Specifies how a Feature is displayed in the list view. The list view is a
 * hierarchy of containers and children; in Google Earth, this is the Places
 * panel. Syntax: &lt;pre&gt; &lt;strong&gt;&lt;ListStyle id="ID"&gt;
 * &lt;/strong&gt; &lt;!-- specific to ListStyle --&gt;
 * &lt;listItemType&gt;check&lt;/listItemType&gt; &lt;!--
 * kml:listItemTypeEnum:check, checkOffOnly,checkHideChildren, radioFolder
 * --&gt; &lt;bgColor&gt;ffffffff&lt;/bgColor&gt; &lt;!-- kml:color --&gt;
 * &lt;ItemIcon&gt; &lt;!-- 0 or more ItemIcon elements --&gt;
 * &lt;state&gt;open&lt;/state&gt; &lt;!-- kml:itemIconModeEnum:open, closed,
 * error, fetching0, fetching1, &lt;em&gt;or &lt;/em&gt; fetching2 --&gt;
 * &lt;href&gt;...&lt;/href&gt; &lt;!-- anyURI --&gt; &lt;/ItemIcon&gt;
 * &lt;strong&gt;&lt;/ListStyle&gt; &lt;/strong&gt; </pre>
 * <p>
 * Extends:
 *
 * @see: &lt;Object&gt;
 *
 * Contained By:
 * @see: &lt;Style&gt;
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListStyleType", propOrder = {
  "listItemType",
  "bgColor",
  "itemIcon",
  "maxSnippetLines",
  "listStyleSimpleExtension",
  "listStyleObjectExtension"
})
@XmlRootElement(name = "ListStyle", namespace = "http://www.opengis.net/kml/2.2")
public class ListStyle
  extends SubStyle
  implements Cloneable {

  /**
   * &lt;listitemtype&gt;
   * <p>
   * Specifies how a Feature is displayed in the list view. Possible values are:
   * check (default) - The Feature's visibility is tied to its item's checkbox.
   * radioFolder - When specified for a Container, only one of the Container's
   * items is visible at a time checkOffOnly - When specified for a Container or
   * Network Link, prevents all items from being made visible at once—that is,
   * the user can turn everything in the Container or Network Link off but
   * cannot turn everything on at the same time. This setting is useful for
   * Containers or Network Links containing large amounts of data.
   * checkHideChildren - Use a normal checkbox for visibility but do not display
   * the Container or Network Link's children in the list view. A checkbox
   * allows the user to toggle visibility of the child objects in the viewer.
   */
  @XmlElement(defaultValue = "check")
  protected ListItemType listItemType;
  /**
   * &lt;bgcolor&gt;
   * <p>
   * Background color for the Snippet. Color and opacity values are expressed in
   * hexadecimal notation. The range of values for any one color is 0 to 255 (00
   * to ff). For alpha, 00 is fully transparent and ff is fully opaque. The
   * order of expression is aabbggrr, where aa=alpha (00 to ff); bb=blue (00 to
   * ff); gg=green (00 to ff); rr=red (00 to ff). For example, if you want to
   * apply a blue color with 50 percent opacity to an overlay, you would specify
   * the following: &lt;color&gt;7fff0000 &lt;/color&gt;, where alpha=0x7f,
   * blue=0xff, green=0x00, and red=0x00. Background color of the balloon
   * (optional). Color and opacity (alpha) values are expressed in hexadecimal
   * notation. The range of values for any one color is 0 to 255 (00 to ff). The
   * order of expression is aabbggrr, where aa=alpha (00 to ff); bb=blue (00 to
   * ff); gg=green (00 to ff); rr=red (00 to ff). For alpha, 00 is fully
   * transparent and ff is fully opaque. For example, if you want to apply a
   * blue color with 50 percent opacity to an overlay, you would specify the
   * following: &lt;bgColor&gt;7fff0000 &lt;/bgColor&gt;, where alpha=0x7f,
   * blue=0xff, green=0x00, and red=0x00. The default is opaque white
   * (ffffffff). Note: The use of the &lt;color&gt; element within
   * &lt;BalloonStyle&gt; has been deprecated. Use &lt;bgColor&gt; instead.
   */
  @XmlElement(defaultValue = "ffffffff")

  protected String bgColor;
  /**
   * &lt;itemicon&gt;
   * <p>
   * &lt;state&gt; Specifies the current state of the NetworkLink or Folder.
   * Possible values are open, closed, error, fetching0, fetching1, and
   * fetching2. These values can be combined by inserting a space between two
   * values (no comma). &lt;href&gt; Specifies the URI of the image used in the
   * List View for the Feature. Icon used in the List view that reflects the
   * state of a Folder or Link fetch. Icons associated with the open and closed
   * modes are used for Folders and Network Links. Icons associated with the
   * error and fetching0, fetching1, and fetching2 modes are used for Network
   * Links. The following screen capture illustrates the Google Earth icons for
   * these states:
   */
  @XmlElement(name = "ItemIcon")
  protected List<ItemIcon> itemIcon;
  @XmlElement(defaultValue = "2")
  protected int maxSnippetLines;
  @XmlElement(name = "ListStyleSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> listStyleSimpleExtension;
  /**
   * &lt;Object&gt;
   * <p>
   * This is an abstract base class and cannot be used directly in a KML file.
   * It provides the id attribute, which allows unique identification of a KML
   * element, and the targetId attribute, which is used to reference objects
   * that have already been loaded into Google Earth. The id attribute must be
   * assigned if the &lt;Update&gt; mechanism is to be used. Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt; &lt;strong&gt;
   * &lt;!--  &lt;em&gt;Object &lt;/em&gt; id="ID" targetId="NCName" --&gt;
   * &lt;!-- / &lt;em&gt;Object &lt;/em&gt;&gt; --&gt; &lt;/strong&gt; </pre>
   * <p>
   */
  @XmlElement(name = "ListStyleObjectExtensionGroup")
  protected List<AbstractObject> listStyleObjectExtension;

  public ListStyle() {
    super();
  }

  /**
   * @see listItemType
   *
   * @return possible object is {@link ListItemType}
   *
   */
  public ListItemType getListItemType() {
    return listItemType;
  }

  /**
   * @see listItemType
   *
   * @param value allowed object is {@link ListItemType}
   *
   */
  public void setListItemType(ListItemType value) {
    this.listItemType = value;
  }

  /**
   * @see bgColor
   *
   * @return possible object is {@link String}
   *
   */
  public String getBgColor() {
    return bgColor;
  }

  /**
   * @see bgColor
   *
   * @param value allowed object is {@link String}
   *
   */
  public void setBgColor(String value) {
    this.bgColor = value;
  }

  /**
   * @see itemIcon
   *
   */
  public List<ItemIcon> getItemIcon() {
    if (itemIcon == null) {
      itemIcon = new ArrayList<>();
    }
    return this.itemIcon;
  }

  /**
   * @see maxSnippetLines
   *
   * @return possible object is {@link Integer}
   *
   */
  public int getMaxSnippetLines() {
    return maxSnippetLines;
  }

  /**
   * @see maxSnippetLines
   *
   * @param value allowed object is {@link Integer}
   *
   */
  public void setMaxSnippetLines(int value) {
    this.maxSnippetLines = value;
  }

  /**
   * @see listStyleSimpleExtension
   *
   */
  public List<Object> getListStyleSimpleExtension() {
    if (listStyleSimpleExtension == null) {
      listStyleSimpleExtension = new ArrayList<>();
    }
    return this.listStyleSimpleExtension;
  }

  /**
   * @see listStyleObjectExtension
   *
   */
  public List<AbstractObject> getListStyleObjectExtension() {
    if (listStyleObjectExtension == null) {
      listStyleObjectExtension = new ArrayList<>();
    }
    return this.listStyleObjectExtension;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((listItemType == null) ? 0 : listItemType.hashCode()));
    result = ((prime * result) + ((bgColor == null) ? 0 : bgColor.hashCode()));
    result = ((prime * result) + ((itemIcon == null) ? 0 : itemIcon.hashCode()));
    result = ((prime * result) + maxSnippetLines);
    result = ((prime * result) + ((listStyleSimpleExtension == null) ? 0 : listStyleSimpleExtension.hashCode()));
    result = ((prime * result) + ((listStyleObjectExtension == null) ? 0 : listStyleObjectExtension.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (super.equals(obj) == false) {
      return false;
    }
    if ((obj instanceof ListStyle) == false) {
      return false;
    }
    ListStyle other = ((ListStyle) obj);
    if (listItemType == null) {
      if (other.listItemType != null) {
        return false;
      }
    } else if (listItemType.equals(other.listItemType) == false) {
      return false;
    }
    if (bgColor == null) {
      if (other.bgColor != null) {
        return false;
      }
    } else if (bgColor.equals(other.bgColor) == false) {
      return false;
    }
    if (itemIcon == null) {
      if (other.itemIcon != null) {
        return false;
      }
    } else if (itemIcon.equals(other.itemIcon) == false) {
      return false;
    }
    if (maxSnippetLines != other.maxSnippetLines) {
      return false;
    }
    if (listStyleSimpleExtension == null) {
      if (other.listStyleSimpleExtension != null) {
        return false;
      }
    } else if (listStyleSimpleExtension.equals(other.listStyleSimpleExtension) == false) {
      return false;
    }
    if (listStyleObjectExtension == null) {
      if (other.listStyleObjectExtension != null) {
        return false;
      }
    } else if (listStyleObjectExtension.equals(other.listStyleObjectExtension) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@link ItemIcon} and adds it to itemIcon. This
   * method is a short version for: &lt;code&gt; ItemIcon itemIcon = new
   * ItemIcon(); this.getItemIcon().add(itemIcon); &lt;/code&gt;
   */
  public ItemIcon createAndAddItemIcon() {
    ItemIcon newValue = new ItemIcon();
    this.getItemIcon().add(newValue);
    return newValue;
  }

  /**
   * @see itemIcon
   *
   * @param itemIcon
   */
  public void setItemIcon(final List<ItemIcon> itemIcon) {
    this.itemIcon = itemIcon;
  }

  /**
   * add a value to the itemIcon property collection
   *
   * @param itemIcon Objects of the following type are allowed in the list:
   *                 {@link ItemIcon}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public ListStyle addToItemIcon(final ItemIcon itemIcon) {
    this.getItemIcon().add(itemIcon);
    return this;
  }

  /**
   * @see listStyleSimpleExtension
   *
   * @param listStyleSimpleExtension
   */
  public void setListStyleSimpleExtension(final List<Object> listStyleSimpleExtension) {
    this.listStyleSimpleExtension = listStyleSimpleExtension;
  }

  /**
   * add a value to the listStyleSimpleExtension property collection
   *
   * @param listStyleSimpleExtension Objects of the following type are allowed
   *                                 in the list: {@link Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public ListStyle addToListStyleSimpleExtension(final Object listStyleSimpleExtension) {
    this.getListStyleSimpleExtension().add(listStyleSimpleExtension);
    return this;
  }

  /**
   * @see listStyleObjectExtension
   *
   * @param listStyleObjectExtension
   */
  public void setListStyleObjectExtension(final List<AbstractObject> listStyleObjectExtension) {
    this.listStyleObjectExtension = listStyleObjectExtension;
  }

  /**
   * add a value to the listStyleObjectExtension property collection
   *
   * @param listStyleObjectExtension Objects of the following type are allowed
   *                                 in the list: {@link AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public ListStyle addToListStyleObjectExtension(final AbstractObject listStyleObjectExtension) {
    this.getListStyleObjectExtension().add(listStyleObjectExtension);
    return this;
  }

  /**
   * @see objectSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.setObjectSimpleExtension(objectSimpleExtension);
  }

  @Obvious
  @Override
  public ListStyle addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  /**
   * @see subStyleSimpleExtension
   *
   */
  @Obvious
  @Override
  public void setSubStyleSimpleExtension(final List<Object> subStyleSimpleExtension) {
    super.setSubStyleSimpleExtension(subStyleSimpleExtension);
  }

  @Obvious
  @Override
  public ListStyle addToSubStyleSimpleExtension(final Object subStyleSimpleExtension) {
    super.getSubStyleSimpleExtension().add(subStyleSimpleExtension);
    return this;
  }

  /**
   * @see subStyleObjectExtension
   *
   */
  @Obvious
  @Override
  public void setSubStyleObjectExtension(final List<AbstractObject> subStyleObjectExtension) {
    super.setSubStyleObjectExtension(subStyleObjectExtension);
  }

  @Obvious
  @Override
  public ListStyle addToSubStyleObjectExtension(final AbstractObject subStyleObjectExtension) {
    super.getSubStyleObjectExtension().add(subStyleObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setListItemType(ListItemType)
   *
   * @param listItemType required parameter
   */
  public ListStyle withListItemType(final ListItemType listItemType) {
    this.setListItemType(listItemType);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setBgColor(String)
   *
   * @param bgColor required parameter
   */
  public ListStyle withBgColor(final String bgColor) {
    this.setBgColor(bgColor);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setItemIcon(List &lt;ItemIcon&gt;)
   *
   * @param itemIcon required parameter
   */
  public ListStyle withItemIcon(final List<ItemIcon> itemIcon) {
    this.setItemIcon(itemIcon);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setMaxSnippetLines(int)
   *
   * @param maxSnippetLines required parameter
   */
  public ListStyle withMaxSnippetLines(final int maxSnippetLines) {
    this.setMaxSnippetLines(maxSnippetLines);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setListStyleSimpleExtension(List &lt;Object&gt;)
   *
   * @param listStyleSimpleExtension required parameter
   */
  public ListStyle withListStyleSimpleExtension(final List<Object> listStyleSimpleExtension) {
    this.setListStyleSimpleExtension(listStyleSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setListStyleObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param listStyleObjectExtension required parameter
   */
  public ListStyle withListStyleObjectExtension(final List<AbstractObject> listStyleObjectExtension) {
    this.setListStyleObjectExtension(listStyleObjectExtension);
    return this;
  }

  @Obvious
  @Override
  public ListStyle withObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.withObjectSimpleExtension(objectSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public ListStyle withId(final String id) {
    super.withId(id);
    return this;
  }

  @Obvious
  @Override
  public ListStyle withTargetId(final String targetId) {
    super.withTargetId(targetId);
    return this;
  }

  @Obvious
  @Override
  public ListStyle withSubStyleSimpleExtension(final List<Object> subStyleSimpleExtension) {
    super.withSubStyleSimpleExtension(subStyleSimpleExtension);
    return this;
  }

  @Obvious
  @Override
  public ListStyle withSubStyleObjectExtension(final List<AbstractObject> subStyleObjectExtension) {
    super.withSubStyleObjectExtension(subStyleObjectExtension);
    return this;
  }

  @Override
  public ListStyle clone() {
    ListStyle copy;
    copy = ((ListStyle) super.clone());
    copy.itemIcon = new ArrayList<>((getItemIcon().size()));
    for (ItemIcon iter : itemIcon) {
      copy.itemIcon.add(iter.clone());
    }
    copy.listStyleSimpleExtension = new ArrayList<>((getListStyleSimpleExtension().size()));
    for (Object iter : listStyleSimpleExtension) {
      copy.listStyleSimpleExtension.add(iter);
    }
    copy.listStyleObjectExtension = new ArrayList<>((getListStyleObjectExtension().size()));
    for (AbstractObject iter : listStyleObjectExtension) {
      copy.listStyleObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
