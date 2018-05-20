<%@ page language="java" import="java.io.*" %>
<html>
<head>
<title>Embedding Windows Media Player in JSP</title>
</head>
<body>
<OBJECT id="VIDEO" CLASSID="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6" type="application/x-oleobject" 
width="320" height="240">

<PARAM NAME="URL" VALUE="G:\video\andekhi.DAT">

<PARAM NAME="enabled" VALUE="True">

<PARAM NAME="AutoStart" VALUE="False">

<PARAM name="PlayCount" VALUE="3">

<PARAM name="Volume" VALUE="50">

<PARAM NAME="balance" VALUE="0">

<PARAM NAME="Rate" VALUE="1.0">

<PARAM NAME="Mute" VALUE="False">

<PARAM NAME="fullScreen" VALUE="False">

<PARAM name="uiMode" VALUE="full">

</OBJECT>
</body>
</html>