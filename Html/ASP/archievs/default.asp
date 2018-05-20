<%
'*****************************************************
'* Code written by Alexander Haneng (C) 1998-2001    *
'* FREE download from http://www.haneng.com/         *
'*****************************************************
%>

<HTML><BODY BGCOLOR="#FFFFFF" TEXT="#000000" LINK="#000000" VLINK="#000000">
<BR>
<B>My file archive:</B><BR><BR>
<TABLE BORDER=0 CELLPADDING=3 CELLSPACING=0>
<TR BGCOLOR="#000000"><TD><FONT COLOR="#FFFFFF"><B>Filename:</B></FONT></TD><TD><FONT COLOR="#FFFFFF"><B>Size:</B></FONT></TD><TD><FONT COLOR="#FFFFFF"><B>File type:</B></FONT></TD><TD><FONT COLOR="#FFFFFF"><B>Date created:</B></FONT></TD>
<%
' Create an instance of the FileSystemObject
Set MyFileObject=Server.CreateObject("Scripting.FileSystemObject")
' Create Folder Object
Set MyFolder=MyFileObject.GetFolder(Server.MapPath("shared"))
'Loop trough the files in the folder
FOR EACH thing in MyFolder.Files
%>
<TR BGCOLOR="#F7F7E7"><TD><A HREF="shared/<%=thing.Name%>"><%=thing.Name%></A></TD><TD ALIGN=RIGHT><%=thing.Size%>bytes</TD><TD><%=thing.Type%></TD><TD><%=thing.DateCreated%></TD> 
<%
NEXT
%>
</TABLE>
</BODY></HTML>
