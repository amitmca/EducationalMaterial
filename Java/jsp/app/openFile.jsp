<%@ page import="java.io.*"%>
<%
FileOutputStream fout;		
try{
fout = new FileOutputStream("C://Hello.txt");
new PrintStream(fout).println ("All glitters are not gold");
out.close(); 	
}
catch (IOException e){
fout.println ("Unable to write to file");
}
%>