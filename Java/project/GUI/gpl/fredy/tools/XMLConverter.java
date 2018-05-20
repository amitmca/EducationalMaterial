package gpl.fredy.tools;

/**

    Copyright (c) 2002 Fredy Fischer
                       fredy.fischer@hulmen.ch

		       Fredy Fischer
		       Hulmenweg 36
		       8405 Winterthur
		       Switzerland

   This class is used by the SimpleLogServer to transform a ByteStream
   comeing in as XML-DOM into a LogRecord

   SimpleLogServer is a tool I did to enhance my sql-Admin package.
   http://www.hulmen.ch/admin

 
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

**/

import java.util.logging.*;
import java.io.*;
import java.util.List;
import java.util.Iterator;
import java.util.Calendar;
import java.util.Vector;


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Attribute;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.input.DOMBuilder;
import org.jdom.output.XMLOutputter;
import org.jdom.Namespace;


public class XMLConverter  {

    private Document doc;
    private Logger   logger;

    private LogRecord lr;

   
    public LogRecord convert(byte[] byts ) {
	logger = Logger.getLogger("gpl.fredy.tools");	
        try {
	    SAXBuilder builder = new SAXBuilder();
	    builder.setValidation(false);
	    //ByteArrayInputStream bais = new ByteArrayInputStream( byts,0, byts.length);
            int j = 0;

	    for (int i=0;i< byts.length; i++) {
		if ( byts[i] == 00 ) continue;
		j++;
	    }
	    ByteArrayInputStream bais = new ByteArrayInputStream( byts,0,j);

	    doc = builder.build( bais );

	} catch (JDOMException e) {
	    logger.log(Level.SEVERE,"can not build document! " + e.getMessage().toString());
	    e.printStackTrace();
	} catch (Exception e ) {
	    logger.log(Level.SEVERE,"strange exception! " + e.getMessage().toString());
	    e.printStackTrace();
	}

	lr = new LogRecord(Level.FINEST," ");

	Element log      = doc.getRootElement();
	Element record   = log.getChild("record");
	lr.setMillis(getMillis(record));
	lr.setSequenceNumber(getSequence(record));
	lr.setLoggerName(getLoggerName(record));
	lr.setLevel(getLevel(record));
	lr.setSourceClassName(getSourceClassName(record));
	lr.setSourceMethodName(getSourceMethodName(record));
	lr.setThreadID(getThreadID(record));
	lr.setMessage(getMessage(record));	    
 
	return lr;
    }

    private long getMillis(Element record ) {

	long m = 0;
	try {
	    Element millis = record.getChild("millis");
	    String s =  millis.getTextTrim() ;
            m = Long.parseLong(  s );
	} catch ( NumberFormatException nfe) {
	    logger.log(Level.WARNING,"Can not convert MILLIS value, returning ZERO");
	}

	return m;

    }

    private long getSequence(Element record ) {

	long l = 0;
	try {
	    Element sequence = record.getChild("sequence");
	    String s =  sequence.getTextTrim();
	    l = Long.parseLong( s );
	} catch ( NumberFormatException nfe) {
	    logger.log(Level.WARNING,"Can not convert SEQUENCE value, returning ZERO");
	}
	return l;

    }
		
    private String getLoggerName(Element record ) {
	String s = "UNKNOWN";
	
	Element loggerName = record.getChild("logger");
	s = loggerName.getTextTrim() ;
	
	return s;
    }	


    private Level getLevel(Element record ) {
	String s = "FINEST";
	
	Element level = record.getChild("level");
	s =  level.getTextTrim();	

	if ( s.equalsIgnoreCase("FINE" ) ) return Level.FINE;
	if ( s.equalsIgnoreCase("CONFIG" ) ) return Level.CONFIG;
	if ( s.equalsIgnoreCase("INFO" ) ) return Level.INFO;
	if ( s.equalsIgnoreCase("WARNING" ) ) return Level.WARNING;
	if ( s.equalsIgnoreCase("SEVERE" ) ) return Level.SEVERE;

	return Level.FINEST;
    }
	
    private String getSourceClassName(Element record ) {
	String s = "UNKNOWN";
	Element srcName = record.getChild("class");
	s = srcName.getTextTrim() ;


	return s;
    }	

    private String getSourceMethodName(Element record ) {
	String s = "UNKNOWN";
	Element srcName = record.getChild("method");
	s = srcName.getTextTrim() ;

	return s;
    }	

    private int getThreadID(Element record ) {

	int i = 0;
	try {
	    Element threadId = record.getChild("thread");
            i = Integer.parseInt( threadId.getTextTrim() );
	} catch ( NumberFormatException nfe) {
	    logger.log(Level.WARNING,"Can not convert THREAD value, returning ZERO");
	} 

	return i;

    }
    private String getMessage(Element record ) {
	String s = "UNKNOWN";
	Element msg = record.getChild("message");
	s = msg.getTextTrim() ;
	return s;
    }	
}
