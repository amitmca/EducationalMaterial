<%@ LANGUAGE="VBSCRIPT" %>
	<HTML><HEAD>
	<TITLE>Upload File Results</TITLE>
	</HEAD>
	<BODY>
	Thank you for uploading your file.<br>
	<% Set upl = Server.CreateObject("SoftArtisans.FileUp") %>
	<% upl.SaveAs "C:\Inetpub\wwwroot\asp\uploads\" %><BR>
	Total Bytes Written: <%=upl.TotalBytes%>
	</BODY>
	</HTML>