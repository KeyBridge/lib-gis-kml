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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import net.opengis.kml.AbstractObject;
import net.opengis.kml.annotations.Obvious;

/*
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewerOptionsType", propOrder = {
  "option"
})
@XmlRootElement(name = "ViewerOptions", namespace = "http://www.google.com/kml/ext/2.2")
public class ViewerOptions
  extends AbstractObject
  implements Cloneable {

  @XmlElement(required = true)
  protected List<Option> option;

  /**
   * Value constructor with only mandatory fields
   *
   * @param option required parameter
   */
  public ViewerOptions(final List<Option> option) {
    super();
    this.option = option;
  }

  /**
   * Default no-arg constructor is private. Use overloaded constructor instead!
   * (Temporary solution, till a better and more suitable ObjectFactory is
   * created.)
   * <p>
   */
  @Deprecated
  private ViewerOptions() {
    super();
  }

  /*
   *
   */
  public List<Option> getOption() {
    if (option == null) {
      option = new ArrayList<>();
    }
    return this.option;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = ((prime * result) + ((option == null) ? 0 : option.hashCode()));
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
    if ((obj instanceof ViewerOptions) == false) {
      return false;
    }
    ViewerOptions other = ((ViewerOptions) obj);
    if (option == null) {
      if (other.option != null) {
        return false;
      }
    } else if (option.equals(other.option) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code Option} and adds it to option. This method
   * is a short version for: &lt;code&gt; Option option = new Option();
   * this.getOption().add(option); &lt;/code&gt;
   */
  public Option createAndAddOption() {
    Option newValue = new Option();
    this.getOption().add(newValue);
    return newValue;
  }

  /**
   * Sets the value of the option property Objects of the following type(s) are
   * allowed in the list List &lt;Option&gt;.
   * <p>
   * Note:
   * <p>
   * This method does not make use of the fluent pattern.If you would like to
   * make it fluent, use {@code #withOption} instead.
   *
   * @param option
   */
  public void setOption(final List<Option> option) {
    this.option = option;
  }

  /**
   * add a value to the option property collection
   *
   * @param option Objects of the following type are allowed in the list:
   *               {@code Option}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public ViewerOptions addToOption(final Option option) {
    this.getOption().add(option);
    return this;
  }

  @Obvious
  @Override
  public void setObjectSimpleExtension(final List<Object> objectSimpleExtension) {
    super.setObjectSimpleExtension(objectSimpleExtension);
  }

  @Obvious
  @Override
  public ViewerOptions addToObjectSimpleExtension(final Object objectSimpleExtension) {
    super.getObjectSimpleExtension().add(objectSimpleExtension);
    return this;
  }

  @Override
  public ViewerOptions clone() {
    ViewerOptions copy;
    copy = ((ViewerOptions) super.clone());
    copy.option = new ArrayList<>((getOption().size()));
    for (Option iter : option) {
      copy.option.add(iter.clone());
    }
    return copy;
  }

}
