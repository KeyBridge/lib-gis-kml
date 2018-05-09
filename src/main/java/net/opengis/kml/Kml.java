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

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import net.opengis.kml.gx.Tour;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * &lt;kml&gt;
 * <p>
 * &lt;kml xmlns="http://www.opengis.net/kml/2.2"&gt; &lt;NetworkLinkControl&gt;
 * ... &lt;/NetworkLinkControl&gt; &lt;!-- 0 or 1 Feature elements --&gt;
 * &lt;/kml&gt; A basic &lt;kml&gt; element contains 0 or 1 Feature and 0 or 1
 * NetworkLinkControl: The &lt;kml&gt; element may also include the namespace
 * for any external XML schemas that are referenced within the file. The root
 * element of a KML file. This element is required. It follows the xml
 * declaration at the beginning of the file. The hint attribute is used as a
 * signal to Google Earth to display the file as celestial data. Syntax:
 * &lt;pre&gt;&lt;kml xmlns="http://www.opengis.net/kml/2.2"
 * &lt;span&gt;hint="target=sky" &lt;/span&gt;&gt; ... &lt;/kml&gt; </pre>
 * <p>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KmlType", propOrder = {
  "networkLinkControl",
  "feature",
  "kmlSimpleExtension",
  "kmlObjectExtension"
})
@XmlRootElement(name = "kml", namespace = "http://www.opengis.net/kml/2.2")
public class Kml implements Cloneable {

  /**
   * &lt;NetworkLinkControl&gt;
   * <p>
   * Controls the behavior of files fetched by a &lt;NetworkLink&gt;. Syntax:
   * &lt;pre&gt; &lt;strong&gt;&lt;NetworkLinkControl&gt; &lt;/strong&gt;
   * &lt;minRefreshPeriod&gt;0&lt;/minRefreshPeriod&gt; &lt;!-- float --&gt;
   * &lt;span
   * class="style2"&gt;&lt;maxSessionLength&gt;-1&lt;/maxSessionLength&gt;
   * &lt;!-- float --&gt; &lt;/span&gt; &lt;cookie&gt; &lt;em&gt;...
   * &lt;/em&gt;&lt;/cookie&gt; &lt;!-- string --&gt; &lt;message&gt;
   * &lt;em&gt;... &lt;/em&gt;&lt;/message&gt; &lt;!-- string --&gt;
   * &lt;linkName&gt; &lt;em&gt;... &lt;/em&gt;&lt;/linkName&gt; &lt;!-- string
   * --&gt; &lt;linkDescription&gt; &lt;em&gt;...
   * &lt;/em&gt;&lt;/linkDescription&gt; &lt;!-- string --&gt; &lt;linkSnippet
   * maxLines="2"&gt; &lt;em&gt;... &lt;/em&gt;&lt;/linkSnippet&gt; &lt;!--
   * string --&gt; &lt;expires&gt;...&lt;/expires&gt; &lt;!-- kml:dateTime
   * --&gt; &lt;Update&gt;...&lt;/Update&gt; &lt;!-- Change,Create,Delete --&gt;
   * &lt;span&gt; &lt;em&gt;&lt;AbstractView&gt;...&lt;/AbstractView&gt;
   * &lt;/em&gt; &lt;!-- LookAt &lt;em&gt;or &lt;/em&gt; Camera --&gt;
   * &lt;/span&gt; &lt;strong&gt;&lt;/NetworkLinkControl&gt; &lt;/strong&gt;
   * </pre>
   * <p>
   * See Also: &lt;NetworkLink&gt; &lt;Update&gt;
   * <p>
   */
  @XmlElement(name = "NetworkLinkControl")
  protected NetworkLinkControl networkLinkControl;
  /**
   * &lt;Feature&gt;
   * <p>
   * This is an abstract element and cannot be used directly in a KML file. The
   * following diagram shows how some of a Feature's elements appear in Google
   * Earth. Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt;
   *  &lt;strong&gt;&lt;!-- &lt;em&gt; Feature &lt;/em&gt; id="ID" --&gt; &lt;/strong&gt;                &lt;!-- Document,Folder,
   *                                              NetworkLink,Placemark,
   *                                              GroundOverlay,PhotoOverlay,ScreenOverlay --&gt;
   *   &lt;name&gt; &lt;em&gt;... &lt;/em&gt;&lt;/name&gt;                      &lt;!-- string --&gt;
   *   &lt;visibility&gt;1&lt;/visibility&gt;            &lt;!-- boolean --&gt;
   *   &lt;open&gt;0&lt;/open&gt;                        &lt;!-- boolean --&gt;
   *    &lt;span&gt;&lt;atom:author&gt;...&lt;atom:author&gt;         &lt;!-- xmlns:atom --&gt;
   *   &lt;atom:link&gt;...&lt;/atom:link&gt; &lt;/span&gt; &lt;span&gt;            &lt;!-- xmlns:atom --&gt; &lt;/span&gt;
   *   &lt;address&gt; &lt;em&gt;... &lt;/em&gt;&lt;/address&gt;                &lt;!-- string --&gt;
   *   &lt;xal:AddressDetails&gt;...&lt;/xal:AddressDetails&gt;  &lt;!-- xmlns:xal --&gt; &lt;br&gt;  &lt;phoneNumber&gt;...&lt;/phoneNumber&gt;        &lt;!-- string --&gt; &lt;br&gt;  &lt;Snippet maxLines="2"&gt; &lt;em&gt;... &lt;/em&gt;&lt;/Snippet&gt;   &lt;!-- string --&gt;
   *   &lt;description&gt; &lt;em&gt;... &lt;/em&gt;&lt;/description&gt;        &lt;!-- string --&gt;
   *    &lt;span&gt; &lt;em&gt;&lt;AbstractView&gt;...&lt;/AbstractView&gt; &lt;/em&gt;      &lt;!-- Camera  &lt;em&gt;or &lt;/em&gt; LookAt --&gt; &lt;/span&gt;
   *   &lt; &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;...&lt;/ &lt;em&gt;TimePrimitive &lt;/em&gt;&gt;    &lt;!-- TimeStamp or TimeSpan --&gt;
   *   &lt;styleUrl&gt; &lt;em&gt;... &lt;/em&gt;&lt;/styleUrl&gt;              &lt;!-- anyURI --&gt;
   *   &lt; &lt;em&gt;StyleSelector&gt;...&lt;/StyleSelector&gt; &lt;/em&gt;
   *   &lt;Region&gt;...&lt;/Region&gt;
   *    &lt;span&gt;&lt;Metadata&gt;...&lt;/Metadata&gt;              &lt;!-- deprecated in KML 2.2 --&gt;
   *   &lt;ExtendedData&gt;...&lt;/ExtendedData&gt;      &lt;!-- new in KML 2.2 --&gt; &lt;br&gt; &lt;/span&gt;&lt;-- / &lt;em&gt;Feature &lt;/em&gt; --&gt;
   * </pre>
   * <p>
   * Extends:
   *
   * @see: &lt;Object&gt;
   *
   * Extended By:
   * @see: &lt;Container&gt;
   * @see: &lt;NetworkLink&gt;
   * @see: &lt;Overlay&gt;
   * @see: &lt;Placemark&gt;
   * @see: &lt;gx:Tour&gt;
   *
   */
  @XmlElementRef(name = "AbstractFeatureGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected Feature feature;
  @XmlElement(name = "KmlSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> kmlSimpleExtension;
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
  @XmlElement(name = "KmlObjectExtensionGroup")
  protected List<AbstractObject> kmlObjectExtension;
  @XmlAttribute(name = "hint")
  protected String hint;
  private transient JAXBContext jc = null;
  private transient Marshaller m = null;
  private transient int missingNameCounter = (1);
  private final static String SCHEMA_LOCATION = "src/main/resources/schema/ogckml/ogckml22.xsd";

  public Kml() {
    super();
  }

  /**
   * @see networkLinkControl
   *
   * @return possible object is {@code NetworkLinkControl}
   *
   */
  public NetworkLinkControl getNetworkLinkControl() {
    return networkLinkControl;
  }

  /**
   * @see networkLinkControl
   *
   * @param value allowed object is {@code NetworkLinkControl}
   *
   */
  public void setNetworkLinkControl(NetworkLinkControl value) {
    this.networkLinkControl = value;
  }

  /**
   * @see feature
   *
   * @return possible object {@code Container}
   *     {@code GroundOverlay}
   *     {@code NetworkLink}
   *     {@code Folder}
   *     {@code PhotoOverlay}
   *     {@code Document}
   *     {@code Tour}
   *     {@code ScreenOverlay}
   *     {@code Feature}
   *     {@code Placemark}
   *     {@code Overlay}
   *
   */
  public Feature getFeature() {
    return feature;
  }

  /**
   * @see feature
   *
   * @param value allowed object is null null null null null null null null   {@code Container}
     *     {@code GroundOverlay}
   *     {@code NetworkLink}
   *     {@code Folder}
   *     {@code PhotoOverlay}
   *     {@code Document}
   *     {@code Tour}
   *     {@code ScreenOverlay}
   *     {@code Feature}
   *     {@code Placemark}
   *     {@code Overlay}
   *
   */
  public void setFeature(Feature value) {
    this.feature = ((Feature) value);
  }

  /**
   * @see kmlSimpleExtension
   *
   */
  public List<Object> getKmlSimpleExtension() {
    if (kmlSimpleExtension == null) {
      kmlSimpleExtension = new ArrayList<>();
    }
    return this.kmlSimpleExtension;
  }

  /**
   * @see kmlObjectExtension
   *
   */
  public List<AbstractObject> getKmlObjectExtension() {
    if (kmlObjectExtension == null) {
      kmlObjectExtension = new ArrayList<>();
    }
    return this.kmlObjectExtension;
  }

  /**
   * @see hint
   *
   * @return possible object is {@code String}
   *
   */
  public String getHint() {
    return hint;
  }

  /**
   * @see hint
   *
   * @param value allowed object is {@code String}
   *
   */
  public void setHint(String value) {
    this.hint = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = ((prime * result) + ((networkLinkControl == null) ? 0 : networkLinkControl.hashCode()));
    result = ((prime * result) + ((feature == null) ? 0 : feature.hashCode()));
    result = ((prime * result) + ((kmlSimpleExtension == null) ? 0 : kmlSimpleExtension.hashCode()));
    result = ((prime * result) + ((kmlObjectExtension == null) ? 0 : kmlObjectExtension.hashCode()));
    result = ((prime * result) + ((hint == null) ? 0 : hint.hashCode()));
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
    if ((obj instanceof Kml) == false) {
      return false;
    }
    Kml other = ((Kml) obj);
    if (networkLinkControl == null) {
      if (other.networkLinkControl != null) {
        return false;
      }
    } else if (networkLinkControl.equals(other.networkLinkControl) == false) {
      return false;
    }
    if (feature == null) {
      if (other.feature != null) {
        return false;
      }
    } else if (feature.equals(other.feature) == false) {
      return false;
    }
    if (kmlSimpleExtension == null) {
      if (other.kmlSimpleExtension != null) {
        return false;
      }
    } else if (kmlSimpleExtension.equals(other.kmlSimpleExtension) == false) {
      return false;
    }
    if (kmlObjectExtension == null) {
      if (other.kmlObjectExtension != null) {
        return false;
      }
    } else if (kmlObjectExtension.equals(other.kmlObjectExtension) == false) {
      return false;
    }
    if (hint == null) {
      if (other.hint != null) {
        return false;
      }
    } else if (hint.equals(other.hint) == false) {
      return false;
    }
    return true;
  }

  /**
   * Creates a new instance of {@code NetworkLinkControl} and set it to
   * networkLinkControl.
   * <p>
   * This method is a short version for: &lt;code&gt; NetworkLinkControl
   * networkLinkControl = new NetworkLinkControl();
   * this.setNetworkLinkControl(networkLinkControl); &lt;/code&gt;
   */
  public NetworkLinkControl createAndSetNetworkLinkControl() {
    NetworkLinkControl newValue = new NetworkLinkControl();
    this.setNetworkLinkControl(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Tour} and set it to feature.
   * <p>
   * This method is a short version for: &lt;code&gt; Tour tour = new Tour();
   * this.setFeature(tour); &lt;/code&gt;
   */
  public Tour createAndSetTour() {
    Tour newValue = new Tour();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code ScreenOverlay} and set it to feature.
   * <p>
   * This method is a short version for: &lt;code&gt; ScreenOverlay
   * screenOverlay = new ScreenOverlay(); this.setFeature(screenOverlay);
   * &lt;/code&gt;
   */
  public ScreenOverlay createAndSetScreenOverlay() {
    ScreenOverlay newValue = new ScreenOverlay();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code PhotoOverlay} and set it to feature.
   * <p>
   * This method is a short version for: &lt;code&gt; PhotoOverlay photoOverlay
   * = new PhotoOverlay(); this.setFeature(photoOverlay); &lt;/code&gt;
   */
  public PhotoOverlay createAndSetPhotoOverlay() {
    PhotoOverlay newValue = new PhotoOverlay();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code GroundOverlay} and set it to feature.
   * <p>
   * This method is a short version for: &lt;code&gt; GroundOverlay
   * groundOverlay = new GroundOverlay(); this.setFeature(groundOverlay);
   * &lt;/code&gt;
   */
  public GroundOverlay createAndSetGroundOverlay() {
    GroundOverlay newValue = new GroundOverlay();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code NetworkLink} and set it to feature.
   * <p>
   * This method is a short version for: &lt;code&gt; NetworkLink networkLink =
   * new NetworkLink(); this.setFeature(networkLink); &lt;/code&gt;
   */
  public NetworkLink createAndSetNetworkLink() {
    NetworkLink newValue = new NetworkLink();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Folder} and set it to feature.
   * <p>
   * This method is a short version for: &lt;code&gt; Folder folder = new
   * Folder(); this.setFeature(folder); &lt;/code&gt;
   */
  public Folder createAndSetFolder() {
    Folder newValue = new Folder();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Document} and set it to feature.
   * <p>
   * This method is a short version for: &lt;code&gt; Document document = new
   * Document(); this.setFeature(document); &lt;/code&gt;
   */
  public Document createAndSetDocument() {
    Document newValue = new Document();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@code Placemark} and set it to feature.
   * <p>
   * This method is a short version for: &lt;code&gt; Placemark placemark = new
   * Placemark(); this.setFeature(placemark); &lt;/code&gt;
   */
  public Placemark createAndSetPlacemark() {
    Placemark newValue = new Placemark();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * @see kmlSimpleExtension
   *
   * @param kmlSimpleExtension
   */
  public void setKmlSimpleExtension(final List<Object> kmlSimpleExtension) {
    this.kmlSimpleExtension = kmlSimpleExtension;
  }

  /**
   * add a value to the kmlSimpleExtension property collection
   *
   * @param kmlSimpleExtension Objects of the following type are allowed in the
   *                           list: {@code Object}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Kml addToKmlSimpleExtension(final Object kmlSimpleExtension) {
    this.getKmlSimpleExtension().add(kmlSimpleExtension);
    return this;
  }

  /**
   * @see kmlObjectExtension
   *
   * @param kmlObjectExtension
   */
  public void setKmlObjectExtension(final List<AbstractObject> kmlObjectExtension) {
    this.kmlObjectExtension = kmlObjectExtension;
  }

  /**
   * add a value to the kmlObjectExtension property collection
   *
   * @param kmlObjectExtension Objects of the following type are allowed in the
   *                           list: {@code AbstractObject}
   * @return &lt;tt&gt;true &lt;/tt&gt; (as general contract of
   *         &lt;tt&gt;Collection.add &lt;/tt&gt;).
   */
  public Kml addToKmlObjectExtension(final AbstractObject kmlObjectExtension) {
    this.getKmlObjectExtension().add(kmlObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setNetworkLinkControl(NetworkLinkControl)
   *
   * @param networkLinkControl required parameter
   */
  public Kml withNetworkLinkControl(final NetworkLinkControl networkLinkControl) {
    this.setNetworkLinkControl(networkLinkControl);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setFeature(Feature)
   *
   * @param feature required parameter
   */
  public Kml withFeature(final Feature feature) {
    this.setFeature(feature);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setKmlSimpleExtension(List &lt;Object&gt;)
   *
   * @param kmlSimpleExtension required parameter
   */
  public Kml withKmlSimpleExtension(final List<Object> kmlSimpleExtension) {
    this.setKmlSimpleExtension(kmlSimpleExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setKmlObjectExtension(List &lt;AbstractObject&gt;)
   *
   * @param kmlObjectExtension required parameter
   */
  public Kml withKmlObjectExtension(final List<AbstractObject> kmlObjectExtension) {
    this.setKmlObjectExtension(kmlObjectExtension);
    return this;
  }

  /**
   * fluent setter
   *
   * @see #setHint(String)
   *
   * @param hint required parameter
   */
  public Kml withHint(final String hint) {
    this.setHint(hint);
    return this;
  }

  /**
   * @see jaxbContext
   *
   */
  private JAXBContext getJaxbContext() throws JAXBException {
    if (jc == null) {
      jc = JAXBContext.newInstance((Kml.class));
    }
    return jc;
  }

  private Marshaller createMarshaller() throws JAXBException {
    if (m == null) {
      m = this.getJaxbContext().createMarshaller();
      m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//      m.setProperty("com.sun.xml.bind.namespacePrefixMapper", new Kml.NameSpaceBeautyfier());
    }
    return m;
  }

  /**
   * Internal method
   * <p>
   */
  private void addKmzFile(Kml kmzFile, ZipOutputStream out, boolean mainfile) throws IOException {
    String fileName = null;
    if (((kmzFile.getFeature() == null) || (kmzFile.getFeature().getName() == null)) || (kmzFile.getFeature().getName().length() == 0)) {
      fileName = (("noFeatureNameSet" + missingNameCounter++) + ".kml");
    } else {
      fileName = kmzFile.getFeature().getName();
      if (!fileName.endsWith(".kml")) {
        fileName += ".kml";
      }
    }
    if (mainfile) {
      fileName = "doc.kml";
    }
    out.putNextEntry(new ZipEntry(URLEncoder.encode(fileName, "UTF-8")));
    kmzFile.marshal(out);
    out.closeEntry();
  }

  /**
   * Java to KML The object graph is marshalled to an OutputStream object. The
   * object is not saved as a zipped .kmz file.
   *
   * @see marshalKmz(String, Kml...)
   *
   */
  public boolean marshal(final OutputStream outputstream)
    throws FileNotFoundException {
    try {
      m = this.createMarshaller();
      m.marshal(this, outputstream);
      return true;
    } catch (JAXBException _x) {
      _x.printStackTrace();
      return false;
    }
  }

  /**
   * Java to KML The object graph is marshalled to a Writer object. The object
   * is not saved as a zipped .kmz file.
   *
   * @see marshalKmz(String, Kml...)
   *
   */
  public boolean marshal(final Writer writer) {
    try {
      m = this.createMarshaller();
      m.marshal(this, writer);
      return true;
    } catch (JAXBException _x) {
      _x.printStackTrace();
      return false;
    }
  }

  /**
   * Java to KML The object graph is marshalled to a Contenthandler object.
   * Useful if marshaller cis needed to generate CDATA blocks. null null null
   * null null null null null   {@code https://jaxb.dev.java.net/faq/}
     * {@code http://code.google.com/p/javaapiforkml/issues/detail?id=7} The
   * object is not saved as a zipped .kmz file.
   *
   * @see marshalKmz(String, Kml...)
   *
   */
  public boolean marshal(final ContentHandler contenthandler) {
    try {
      m = this.createMarshaller();
      m.marshal(this, contenthandler);
      return true;
    } catch (JAXBException _x) {
      _x.printStackTrace();
      return false;
    }
  }

  /**
   * Java to KML The object graph is printed to the console. (Nothing is saved,
   * nor saved. Just printed.)
   */
  public boolean marshal() {
    try {
      m = this.createMarshaller();
      m.marshal(this, System.out);
      return true;
    } catch (JAXBException _x) {
      _x.printStackTrace();
      return false;
    }
  }

  /**
   * Java to KML The object graph is marshalled to a File object. The object is
   * not saved as a zipped .kmz file.
   *
   * @see marshalKmz(String, Kml...)
   *
   */
  public boolean marshal(final File filename)
    throws FileNotFoundException {
    OutputStream out = new FileOutputStream(filename);
    return this.marshal(out);
  }

  public boolean marshalAsKmz(String name, Kml... additionalFiles) throws IOException {
    ZipOutputStream out = new ZipOutputStream(new FileOutputStream(name));
    out.setComment("KMZ-file created with Java API for KML. Visit us: http://code.google.com/p/javaapiforkml/");
    this.addKmzFile(this, out, true);
    for (Kml kml : additionalFiles) {
      this.addKmzFile(kml, out, false);
    }
    out.close();
    missingNameCounter = 1;
    return false;
  }

  private static boolean validate(final Unmarshaller unmarshaller) {
    try {
      SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      File schemaFile = new File(SCHEMA_LOCATION);
      Schema schema = sf.newSchema(schemaFile);
      unmarshaller.setSchema(schema);
      return true;
    } catch (SAXException _x) {
      _x.printStackTrace();
    }
    return false;
  }

  /**
   * KML to Java KML given as a file object is transformed into a graph of Java
   * objects. The boolean value indicates, whether the File object should be
   * validated automatically during unmarshalling and be checked if the object
   * graph meets all constraints defined in OGC's KML schema specification.
   * <p>
   */
  public static Kml unmarshal(final File file, final boolean validate) {
    try {
      Unmarshaller unmarshaller = JAXBContext.newInstance((Kml.class)).createUnmarshaller();
      if (validate == true) {
        Kml.validate(unmarshaller);
      }
      InputSource input = new InputSource(new FileReader(file));
      SAXSource saxSource = new SAXSource(new NamespaceFilterXMLReader(validate), input);
      Kml jaxbRootElement = ((Kml) unmarshaller.unmarshal(saxSource));
      return jaxbRootElement;
    } catch (SAXException _x) {
      _x.printStackTrace();
    } catch (ParserConfigurationException _x) {
      _x.printStackTrace();
    } catch (JAXBException _x) {
      _x.printStackTrace();
    } catch (FileNotFoundException _x) {
      _x.printStackTrace();
    }
    return null;
  }

  /**
   * KML to Java KML given as a file object is transformed into a graph of Java
   * objects. Similar to the method: unmarshal(final File, final boolean) with
   * the exception that the File object is not validated (boolean is false).
   * <p>
   */
  public static Kml unmarshal(final File file) {
    return Kml.unmarshal(file, false);
  }

  /**
   * KML to Java Similar to the other unmarshal methods
   * <p>
   * with the exception that it transforms a String into a graph of Java
   * objects.
   */
  public static Kml unmarshal(final String content) {
    try {
      Unmarshaller unmarshaller = JAXBContext.newInstance((Kml.class)).createUnmarshaller();
      InputSource input = new InputSource(new StringReader(content));
      SAXSource saxSource = new SAXSource(new NamespaceFilterXMLReader(false), input);
      Kml jaxbRootElement = ((Kml) unmarshaller.unmarshal(saxSource));
      return jaxbRootElement;
    } catch (SAXException _x) {
      _x.printStackTrace();
    } catch (ParserConfigurationException _x) {
      _x.printStackTrace();
    } catch (JAXBException _x) {
      _x.printStackTrace();
    }
    return null;
  }

  /**
   * KML to Java Similar to the other unmarshal methods
   * <p>
   * with the exception that it transforms a InputStream into a graph of Java
   * objects.
   */
  public static Kml unmarshal(final InputStream content) {
    try {
      Unmarshaller unmarshaller = JAXBContext.newInstance((Kml.class)).createUnmarshaller();
      InputSource input = new InputSource(content);
      SAXSource saxSource = new SAXSource(new NamespaceFilterXMLReader(false), input);
      Kml jaxbRootElement = ((Kml) unmarshaller.unmarshal(saxSource));
      return jaxbRootElement;
    } catch (SAXException _x) {
      _x.printStackTrace();
    } catch (ParserConfigurationException _x) {
      _x.printStackTrace();
    } catch (JAXBException _x) {
      _x.printStackTrace();
    }
    return null;
  }

  /**
   * KMZ to Java Similar to the other unmarshal methods
   * <p>
   * with the exception that it transforms a KMZ-file into a graph of Java
   * objects.
   */
  public static Kml[] unmarshalFromKmz(File file) throws IOException {
    Kml[] EMPTY_KML_ARRAY = (new Kml[0]);
    if (!file.getName().endsWith(".kmz")) {
      return EMPTY_KML_ARRAY;
    }
    ZipFile zip = new ZipFile(file);
    Enumeration<? extends ZipEntry> entries = zip.entries();
    if (!file.exists()) {
      return EMPTY_KML_ARRAY;
    }
    ArrayList<Kml> kmlfiles = new ArrayList<>();
    while (entries.hasMoreElements()) {
      ZipEntry entry = ((ZipEntry) entries.nextElement());
      if (entry.getName().contains("__MACOSX") || entry.getName().contains(".DS_STORE")) {
        continue;
      }
      String entryName = URLDecoder.decode(entry.getName(), "UTF-8");
      if (!entryName.endsWith(".kml")) {
        continue;
      }
      InputStream in = zip.getInputStream(entry);
      Kml unmarshal = Kml.unmarshal(in);
      kmlfiles.add(unmarshal);
    }
    zip.close();
    return kmlfiles.toArray(EMPTY_KML_ARRAY);
  }

  @Override
  public Kml clone() {
    Kml copy;
    try {
      copy = ((Kml) super.clone());
    } catch (CloneNotSupportedException _x) {
      throw new InternalError((_x.toString()));
    }
    copy.networkLinkControl = ((networkLinkControl == null) ? null : ((NetworkLinkControl) networkLinkControl.clone()));
    copy.feature = ((feature == null) ? null : ((Feature) feature.clone()));
    copy.kmlSimpleExtension = new ArrayList<>((getKmlSimpleExtension().size()));
    for (Object iter : kmlSimpleExtension) {
      copy.kmlSimpleExtension.add(iter);
    }
    copy.kmlObjectExtension = new ArrayList<>((getKmlObjectExtension().size()));
    for (AbstractObject iter : kmlObjectExtension) {
      copy.kmlObjectExtension.add(iter.clone());
    }
    return copy;
  }

}
