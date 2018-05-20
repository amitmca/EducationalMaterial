package gpl.fredy.tools;
/**
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 * and exports data into various formats
 *
 *
 *   Copyright (C)     2003, Fredy Fischer
 *                           sql@hulmen.ch
 *   Postal: Fredy Fischer
 *           Hulmenweg 36
 *           8405 Winterthur
 *           Switzerland
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the Free Software
 *   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory; 
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import java.util.logging.*;

public class SimpleXMLConverter extends DefaultHandler {

    private Logger   logger;

    public SimpleXMLConverter() {

	logger = Logger.getLogger("gpl.fredy.tools");	
	

    }
    public LogRecord convert(byte[] byts )  throws SAXException {

	//efaultHandler handler = new LogMsgHandler();
       LogMsgHandler handler = new LogMsgHandler();
       SAXParserFactory factory = SAXParserFactory.newInstance();

       int j = 0;
       
       for (int i=0;i< byts.length; i++) {
	   if ( byts[i] == 00 ) continue;
	   j++;
       }
       
       ByteArrayInputStream bais = new ByteArrayInputStream( byts,0,j);
       
       try {
	   
	   SAXParser saxParser = factory.newSAXParser();
	   saxParser.parse( bais, handler );
 
       } catch (IOException e) {
	   logger.log(Level.SEVERE,"IOException, " + e.getMessage().toString());
       } catch (IllegalArgumentException e) {
	   logger.log(Level.WARNING,"InputStream is null, " + e.getMessage().toString());
       } catch (SAXException e) {
	   // logger.log(Level.WARNING,"SAX Exception, " + e.getMessage().toString());
       } catch (ParserConfigurationException e) {
	   logger.log(Level.WARNING,"Parser Configuration Exception, " + e.getMessage().toString());
       }
        
       return handler.getLogRecord();
   }
}
    
