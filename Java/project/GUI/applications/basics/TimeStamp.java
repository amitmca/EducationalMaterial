package applications.basics;

/**
   Need a correct timeStamp?
   This will do it

    Copyright (c) 1999 Fredy Fischer
                       sql@hulmen.ch

		       Fredy Fischer
		       Hulmenweg 36
		       8405 Winterthur
		       Switzerland

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA


**/

import java.util.Date;
import java.sql.Timestamp;


public class TimeStamp  {


    
    java.sql.Timestamp timestamp;
    
    /**
       * Get the value of timestamp.
       * @return Value of timestamp.
       */
    public java.sql.Timestamp getTimestamp() {return timestamp;}
    
    /**
       * Set the value of timestamp.
       * @param v  Value to assign to timestamp.
       */
    public void setTimestamp(java.sql.Timestamp  v) {this.timestamp = v;}
    

    public TimeStamp() {

	java.util.Date d = new java.util.Date();
	setTimestamp( new Timestamp( d.getTime() ) );

    }

    public static void main( String args[] ){
	TimeStamp tst = new TimeStamp();
	System.out.println("Timestamp: " + tst.getTimestamp());
    }
}
