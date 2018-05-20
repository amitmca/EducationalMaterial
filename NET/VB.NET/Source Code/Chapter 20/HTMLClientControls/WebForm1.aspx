<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="HTMLClientControls.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<script language="javascript">
			<!--
			function Button1_OnClick()
			{
				document.Form1.textbox1.value="Executing Javascript Code"
			}
				-->	
		</script>
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<DIV style="DISPLAY: inline; Z-INDEX: 101; LEFT: 144px; WIDTH: 360px; POSITION: absolute; TOP: 72px; HEIGHT: 24px"
				ms_positioning="FlowLayout"><FONT face="Verdana" size="5">HTML Client Controls 
					Example</FONT></DIV>
			<INPUT id="textbox1" style="Z-INDEX: 102; LEFT: 112px; WIDTH: 200px; POSITION: absolute; TOP: 144px; HEIGHT: 22px"
				type="text" size="28"> 
				
				<INPUT id="button1" style="Z-INDEX: 103; LEFT: 336px; POSITION: absolute; TOP: 144px" type="button"
				value="Click here" language="javascript" onclick="return Button1_OnClick()">
				
				
		</form>
	</body>
</HTML>
