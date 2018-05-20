/*
 * Java Port Listener
 *
 * Copyright 2000 Matteo Baccan <mbaccan@planetisa.com>
 * www - http://www.infomedia.it/artic/Baccan
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA (or visit
 * their web site at http://www.gnu.org/).
 *
 */

import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class portListen extends Thread {

   /* Public interface ******************************************************/
   static public void main( String argv[] ) {

      String cPortFrom;
      String cPortDesc;

      System.out.println( "+---------------------------------------------------------------------------+" );
      System.out.println( "| TCP/IP Port Listener                             Version 0.11  04-06-2000 |" );
      System.out.println( "| (C) 2000 by Matteo Baccan            http://www.infomedia.it/artic/Baccan |" );
      System.out.println( "+---------------------------------------------------------------------------+" );
      System.out.println( "\nOpening portListen.ini ...\n" );
      try {
         RandomAccessFile RAF;
         RAF = new RandomAccessFile("portListen.ini","r");

         String cIPFrom = "127.0.0.1";
         if( argv.length>0 )
            cIPFrom = argv[0];

         String cLine = "";
         cLine = RAF.readLine();
         while( cLine!=null ){

            StringTokenizer token = new StringTokenizer( cLine, "," );

            cPortFrom="";
            cPortDesc="";

            if( token.hasMoreTokens() )
               cPortFrom = token.nextToken();
            if( token.hasMoreTokens() )
               cPortDesc = token.nextToken();

            if( cPortFrom.length()>0 ){
               portListen server = new portListen( cIPFrom, cPortFrom, cPortDesc );
               server.start();
            }
            cLine = RAF.readLine();
         }

         RAF.close();

         System.out.println( "\nAll system ready" );

      } catch(Exception e) {
         e.printStackTrace();
         System.out.println( "\nError during opening of portListen.ini  " +e.toString() );
      }
   }
   /*************************************************************************/

   private int nPortFrom;
   private String cInServer;
   private String cPortDesc;

   public portListen( String cIPFrom, String inPort, String cPDesc ){
      cInServer  = cIPFrom;
      nPortFrom  = Integer.parseInt(  inPort );
      cPortDesc  = cPDesc;
      System.out.println( "   listen [" +cInServer +":" +nPortFrom +":" +cPortDesc +"] " );
   }

   public void run(){
      try {                                  // port, maxrequest, address
         ServerSocket sock = new ServerSocket( nPortFrom, 5, InetAddress.getByName(cInServer) );
         while( true ){
            Socket socket = sock.accept();

            //System.out.println( " User at [" +socket.getLocalPort() +":" +cPortDesc +"] retreive information" );
            System.out.println( " New user from [" +socket.getInetAddress() +":" +socket.getPort() +"] to [" +socket.getLocalAddress()  +":" +socket.getLocalPort() +":" +cPortDesc +"]" );

            socket.close();
         }
      } catch (Throwable e) {
         e.printStackTrace();
         System.out.println( e.getMessage() );
         System.out.println( "Error in listen [" +nPortFrom +"] " );
      }
   }
}
