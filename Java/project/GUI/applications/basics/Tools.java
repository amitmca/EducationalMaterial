package applications.basics;

/**

  some helpfull things very often needed


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

import java.util.*;

public class Tools {

    public Tools() {
    }

    public String toDay() {
	Calendar cal;
	cal = Calendar.getInstance();
	String y = Integer.toString(cal.get(cal.YEAR));
	String m = Integer.toString(cal.get(cal.MONTH)+ 1);
	m = trailing(m);
	String d = Integer.toString(cal.get(cal.DAY_OF_MONTH));
	d = trailing(d);
	
	 return y + "-" + d + "-" + m;

    }

    public java.sql.Date getSqlDate(String datum) {
	StringTokenizer st = new StringTokenizer(datum,"-");
  	Calendar cal;
	cal = Calendar.getInstance();      
        int y = cal.YEAR;
        int m = cal.MONTH + 1;
        int d = cal.DAY_OF_MONTH;
	y = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()) - 1;
        d = Integer.parseInt(st.nextToken());
        cal.set(y,m,d);
        return new java.sql.Date(cal.getTimeInMillis());	   
    }


    public String trailing(String v) {
	if (v.length() < 2 ) v = "0"+ v;
	return v;
    }
}
