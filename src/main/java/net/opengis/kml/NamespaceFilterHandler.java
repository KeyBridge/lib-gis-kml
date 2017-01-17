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

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

final class NamespaceFilterHandler
        implements ContentHandler {

  private final static String KML_20 = "http://earth.google.com/kml/2.0";
  private final static String KML_21 = "http://earth.google.com/kml/2.1";
  private final static String KML_22 = "http://www.opengis.net/kml/2.2";
  private ContentHandler contentHandler;

  public NamespaceFilterHandler(ContentHandler contentHandler) {
    this.contentHandler = contentHandler;
  }

  public void startElement(String uri, String localName, String qName, Attributes atts)
          throws SAXException {
    if (uri.equals(KML_20) || uri.equals(KML_21)) {
      contentHandler.startElement(KML_22, localName, qName, atts);
    } else {
      contentHandler.startElement(uri, localName, qName, atts);
    }
  }

  public void characters(char[] ch, int start, int length)
          throws SAXException {
    contentHandler.characters(ch, start, length);
  }

  public void endDocument()
          throws SAXException {
    contentHandler.endDocument();
  }

  public void endElement(String uri, String localName, String qName)
          throws SAXException {
    contentHandler.endElement(uri, localName, qName);
  }

  public void endPrefixMapping(String prefix)
          throws SAXException {
    contentHandler.endPrefixMapping(prefix);
  }

  public void ignorableWhitespace(char[] ch, int start, int length)
          throws SAXException {
    contentHandler.ignorableWhitespace(ch, start, length);
  }

  public void processingInstruction(String target, String data)
          throws SAXException {
    contentHandler.processingInstruction(target, data);
  }

  public void setDocumentLocator(Locator locator) {
    contentHandler.setDocumentLocator(locator);
  }

  public void skippedEntity(String name)
          throws SAXException {
    contentHandler.skippedEntity(name);
  }

  public void startDocument()
          throws SAXException {
    contentHandler.startDocument();
  }

  public void startPrefixMapping(String prefix, String uri)
          throws SAXException {
    contentHandler.startPrefixMapping(prefix, uri);
  }

}
