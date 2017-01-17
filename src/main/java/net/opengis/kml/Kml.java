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
 * <kml>
 * <p>
 * <kml xmlns="http://www.opengis.net/kml/2.2"> <NetworkLinkControl> ...
 * </NetworkLinkControl>
 * <!-- 0 or 1 Feature elements --> </kml>
 * </p>
 * <p>
 * A basic <kml> element contains 0 or 1 Feature and 0 or 1 NetworkLinkControl:
 * </p>
 * <p>
 * The <kml> element may also include the namespace for any external XML schemas
 * that are referenced within the file.
 * </p>
 * <p>
 * The root element of a KML file. This element is required. It follows the xml
 * declaration at the beginning of the file. The hint attribute is used as a
 * signal to Google Earth to display the file as celestial data.
 * </p>
 * <p>
 * Syntax:
 * <pre>&lt;kml xmlns="http://www.opengis.net/kml/2.2" <span>hint="target=sky"</span>&gt; ... &lt;/kml&gt;</pre>
 * <p>
 * <p>
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
   * <NetworkLinkControl>
   * <p>
   * Controls the behavior of files fetched by a <NetworkLink>.
   * </p>
   * <p>
   * Syntax:
   * <pre><strong>&lt;NetworkLinkControl&gt;</strong>
   *   &lt;minRefreshPeriod&gt;0&lt;/minRefreshPeriod&gt;           &lt;!-- float --&gt;
   *   <span class="style2">&lt;maxSessionLength&gt;-1&lt;/maxSessionLength&gt;          &lt;!-- float --&gt; </span>
   *   &lt;cookie&gt;<em>...</em>&lt;/cookie&gt;                             &lt;!-- string --&gt;
   *   &lt;message&gt;<em>...</em>&lt;/message&gt;                           &lt;!-- string --&gt;
   *   &lt;linkName&gt;<em>...</em>&lt;/linkName&gt;                         &lt;!-- string --&gt;
   *   &lt;linkDescription&gt;<em>...</em>&lt;/linkDescription&gt;           &lt;!-- string --&gt;
   *   &lt;linkSnippet maxLines="2"&gt;<em>...</em>&lt;/linkSnippet&gt;      &lt;!-- string --&gt;
   *   &lt;expires&gt;...&lt;/expires&gt;                           &lt;!-- kml:dateTime --&gt;
   *   &lt;Update&gt;...&lt;/Update&gt;                             &lt;!-- Change,Create,Delete --&gt;
   *   <span><em>&lt;AbstractView&gt;...&lt;/AbstractView&gt;</em>                 &lt;!-- LookAt <em>or</em> Camera --&gt;</span>
   * <strong>&lt;/NetworkLinkControl&gt;</strong></pre>
   * <p>
   * See Also:
   * <NetworkLink>
   * <Update>
   * <p>
   * <p>
   * <p>
   */
  @XmlElement(name = "NetworkLinkControl")
  protected NetworkLinkControl networkLinkControl;
  /**
   * <Feature>
   * <p>
   * This is an abstract element and cannot be used directly in a KML file. The
   * following diagram shows how some of a Feature's elements appear in Google
   * Earth.
   * </p>
   * <p>
   * Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt;
   * <strong>&lt;!--<em> Feature</em> id="ID" --&gt;</strong>                &lt;!-- Document,Folder,
   *                                              NetworkLink,Placemark,
   *                                              GroundOverlay,PhotoOverlay,ScreenOverlay --&gt;
   *   &lt;name&gt;<em>...</em>&lt;/name&gt;                      &lt;!-- string --&gt;
   *   &lt;visibility&gt;1&lt;/visibility&gt;            &lt;!-- boolean --&gt;
   *   &lt;open&gt;0&lt;/open&gt;                        &lt;!-- boolean --&gt;
   *   <span>&lt;atom:author&gt;...&lt;atom:author&gt;         &lt;!-- xmlns:atom --&gt;
   *   &lt;atom:link&gt;...&lt;/atom:link&gt;</span><span>            &lt;!-- xmlns:atom --&gt;</span>
   *   &lt;address&gt;<em>...</em>&lt;/address&gt;                &lt;!-- string --&gt;
   *   &lt;xal:AddressDetails&gt;...&lt;/xal:AddressDetails&gt;  &lt;!-- xmlns:xal --&gt;<br>  &lt;phoneNumber&gt;...&lt;/phoneNumber&gt;        &lt;!-- string --&gt;<br>  &lt;Snippet maxLines="2"&gt;<em>...</em>&lt;/Snippet&gt;   &lt;!-- string --&gt;
   *   &lt;description&gt;<em>...</em>&lt;/description&gt;        &lt;!-- string --&gt;
   *   <span><em>&lt;AbstractView&gt;...&lt;/AbstractView&gt;</em>      &lt;!-- Camera <em>or</em> LookAt --&gt;</span>
   *   &lt;<em>TimePrimitive</em>&gt;...&lt;/<em>TimePrimitive</em>&gt;    &lt;!-- TimeStamp or TimeSpan --&gt;
   *   &lt;styleUrl&gt;<em>...</em>&lt;/styleUrl&gt;              &lt;!-- anyURI --&gt;
   *   &lt;<em>StyleSelector&gt;...&lt;/StyleSelector&gt;</em>
   *   &lt;Region&gt;...&lt;/Region&gt;
   *   <span>&lt;Metadata&gt;...&lt;/Metadata&gt;              &lt;!-- deprecated in KML 2.2 --&gt;
   *   &lt;ExtendedData&gt;...&lt;/ExtendedData&gt;      &lt;!-- new in KML 2.2 --&gt;<br></span>&lt;-- /<em>Feature</em> --&gt;</pre>
   * <p>
   * Extends:
   *
   * @see: <Object>
   *
   * Extended By:
   * @see: <Container>
   * @see: <NetworkLink>
   * @see: <Overlay>
   * @see: <Placemark>
   * @see: <gx:Tour>
   *
   *
   *
   */
  @XmlElementRef(name = "AbstractFeatureGroup", namespace = "http://www.opengis.net/kml/2.2", required = false)
  protected Feature feature;
  @XmlElement(name = "KmlSimpleExtensionGroup")
  @XmlSchemaType(name = "anySimpleType")
  protected List<Object> kmlSimpleExtension;
  /**
   * <Object>
   * <p>
   * This is an abstract base class and cannot be used directly in a KML file.
   * It provides the id attribute, which allows unique identification of a KML
   * element, and the targetId attribute, which is used to reference objects
   * that have already been loaded into Google Earth. The id attribute must be
   * assigned if the <Update> mechanism is to be used.
   * </p>
   * <p>
   * Syntax:
   * <pre>&lt;!-- abstract element; do not create --&gt;<strong>
   * &lt;!-- <em>Object</em> id="ID" targetId="NCName" --&gt;
   * &lt;!-- /<em>Object</em>&gt; --&gt;</strong></pre>
   * <p>
   * <p>
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
   * @return possible object is {@link NetworkLinkControl}
   *
   */
  public NetworkLinkControl getNetworkLinkControl() {
    return networkLinkControl;
  }

  /**
   * @see networkLinkControl
   *
   * @param value allowed object is {@link NetworkLinkControl}
   *
   */
  public void setNetworkLinkControl(NetworkLinkControl value) {
    this.networkLinkControl = value;
  }

  /**
   * @see feature
   *
   * @return possible object is null null null null null null null null null
   *         null null null   {@code <}{@link Container}{@code>}
     *     {@code <}{@link GroundOverlay}{@code>}
   *     {@code <}{@link NetworkLink}{@code>}
   *     {@code <}{@link Folder}{@code>}
   *     {@code <}{@link PhotoOverlay}{@code>}
   *     {@code <}{@link Document}{@code>}
   *     {@code <}{@link Tour}{@code>}
   *     {@code <}{@link ScreenOverlay}{@code>}
   *     {@code <}{@link Feature}{@code>}
   *     {@code <}{@link Placemark}{@code>}
   *     {@code <}{@link Overlay}{@code>}
   *
   */
  public Feature getFeature() {
    return feature;
  }

  /**
   * @see feature
   *
   * @param value allowed object is null null null null null null null null null
   *              null null null   {@code <}{@link Container}{@code>}
     *     {@code <}{@link GroundOverlay}{@code>}
   *     {@code <}{@link NetworkLink}{@code>}
   *     {@code <}{@link Folder}{@code>}
   *     {@code <}{@link PhotoOverlay}{@code>}
   *     {@code <}{@link Document}{@code>}
   *     {@code <}{@link Tour}{@code>}
   *     {@code <}{@link ScreenOverlay}{@code>}
   *     {@code <}{@link Feature}{@code>}
   *     {@code <}{@link Placemark}{@code>}
   *     {@code <}{@link Overlay}{@code>}
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
   * @return possible object is {@link String}
   *
   */
  public String getHint() {
    return hint;
  }

  /**
   * @see hint
   *
   * @param value allowed object is {@link String}
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
   * Creates a new instance of {@link NetworkLinkControl} and set it to
   * networkLinkControl.
   * <p>
   * This method is a short version for:    <code>
   * NetworkLinkControl networkLinkControl = new NetworkLinkControl();
   * this.setNetworkLinkControl(networkLinkControl); </code>
   * <p>
   * <p>
   */
  public NetworkLinkControl createAndSetNetworkLinkControl() {
    NetworkLinkControl newValue = new NetworkLinkControl();
    this.setNetworkLinkControl(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Tour} and set it to feature.
   * <p>
   * This method is a short version for:    <code>
   * Tour tour = new Tour();
   * this.setFeature(tour); </code>
   * <p>
   * <p>
   */
  public Tour createAndSetTour() {
    Tour newValue = new Tour();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link ScreenOverlay} and set it to feature.
   * <p>
   * This method is a short version for:    <code>
   * ScreenOverlay screenOverlay = new ScreenOverlay();
   * this.setFeature(screenOverlay); </code>
   * <p>
   * <p>
   */
  public ScreenOverlay createAndSetScreenOverlay() {
    ScreenOverlay newValue = new ScreenOverlay();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link PhotoOverlay} and set it to feature.
   * <p>
   * This method is a short version for:    <code>
   * PhotoOverlay photoOverlay = new PhotoOverlay();
   * this.setFeature(photoOverlay); </code>
   * <p>
   * <p>
   */
  public PhotoOverlay createAndSetPhotoOverlay() {
    PhotoOverlay newValue = new PhotoOverlay();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link GroundOverlay} and set it to feature.
   * <p>
   * This method is a short version for:    <code>
   * GroundOverlay groundOverlay = new GroundOverlay();
   * this.setFeature(groundOverlay); </code>
   * <p>
   * <p>
   */
  public GroundOverlay createAndSetGroundOverlay() {
    GroundOverlay newValue = new GroundOverlay();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link NetworkLink} and set it to feature.
   * <p>
   * This method is a short version for:    <code>
   * NetworkLink networkLink = new NetworkLink();
   * this.setFeature(networkLink); </code>
   * <p>
   * <p>
   */
  public NetworkLink createAndSetNetworkLink() {
    NetworkLink newValue = new NetworkLink();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Folder} and set it to feature.
   * <p>
   * This method is a short version for:    <code>
   * Folder folder = new Folder();
   * this.setFeature(folder); </code>
   * <p>
   * <p>
   */
  public Folder createAndSetFolder() {
    Folder newValue = new Folder();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Document} and set it to feature.
   * <p>
   * This method is a short version for:    <code>
   * Document document = new Document();
   * this.setFeature(document); </code>
   * <p>
   * <p>
   */
  public Document createAndSetDocument() {
    Document newValue = new Document();
    this.setFeature(newValue);
    return newValue;
  }

  /**
   * Creates a new instance of {@link Placemark} and set it to feature.
   * <p>
   * This method is a short version for:    <code>
   * Placemark placemark = new Placemark();
   * this.setFeature(placemark); </code>
   * <p>
   * <p>
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
   *                           list: {@link Object}
   * @return <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
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
   *                           list: {@link AbstractObject}
   * @return <tt>true</tt> (as general contract of <tt>Collection.add</tt>).
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
   * @see #setKmlSimpleExtension(List<Object>)
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
   * @see #setKmlObjectExtension(List<AbstractObject>)
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
   * null null null null null null null null null   {@link https://jaxb.dev.java.net/faq/}
     * {@link http://code.google.com/p/javaapiforkml/issues/detail?id=7} The
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
   * <p>
   * <p>
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
   * <p>
   * <p>
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
   * <p>
   * <p>
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
   * <p>
   * <p>
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
