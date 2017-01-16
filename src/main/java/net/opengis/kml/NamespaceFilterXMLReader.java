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

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

final class NamespaceFilterXMLReader
    implements XMLReader
{

    private XMLReader xmlReader;

    public NamespaceFilterXMLReader(boolean validate)
        throws ParserConfigurationException, SAXException
    {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setNamespaceAware(true);
        parserFactory.setValidating(validate);
        xmlReader = parserFactory.newSAXParser().getXMLReader();
    }

    public ContentHandler getContentHandler() {
        return xmlReader.getContentHandler();
    }

    public DTDHandler getDTDHandler() {
        return xmlReader.getDTDHandler();
    }

    public EntityResolver getEntityResolver() {
        return xmlReader.getEntityResolver();
    }

    public ErrorHandler getErrorHandler() {
        return xmlReader.getErrorHandler();
    }

    public boolean getFeature(String name)
        throws SAXNotRecognizedException, SAXNotSupportedException
    {
        return xmlReader.getFeature(name);
    }

    public Object getProperty(String name)
        throws SAXNotRecognizedException, SAXNotSupportedException
    {
        return xmlReader.getProperty(name);
    }

    public void parse(InputSource input)
        throws IOException, SAXException
    {
        xmlReader.parse(input);
    }

    public void parse(String systemId)
        throws IOException, SAXException
    {
        xmlReader.parse(systemId);
    }

    public void setContentHandler(ContentHandler handler) {
        xmlReader.setContentHandler(new NamespaceFilterHandler(handler));
    }

    public void setDTDHandler(DTDHandler handler) {
        xmlReader.setDTDHandler(handler);
    }

    public void setEntityResolver(EntityResolver handler) {
        xmlReader.setEntityResolver(handler);
    }

    public void setErrorHandler(ErrorHandler handler) {
        xmlReader.setErrorHandler(handler);
    }

    public void setFeature(String name, boolean value)
        throws SAXNotRecognizedException, SAXNotSupportedException
    {
        xmlReader.setFeature(name, value);
    }

    public void setProperty(String name, Object value)
        throws SAXNotRecognizedException, SAXNotSupportedException
    {
        xmlReader.setProperty(name, value);
    }

}
