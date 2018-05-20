<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="ClientEvents.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<script id="clientEventHandlersJS" language="javascript">
<!--

function Button1_onclick() {
    document.Form1.Text1.value = "Handling client events!"
}

//-->
		</script>
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
		<INPUT id=Button1 style="Z-INDEX: 101; LEFT: 125px; POSITION: absolute; 
    TOP: 85px" type=button value="Click me" language=javascript 
    onclick="return Button1_onclick()">
<INPUT 
id=Text1 style="Z-INDEX: 102; LEFT: 208px; WIDTH: 155px; 
POSITION: absolute; TOP: 86px; HEIGHT: 22px" type=text>

			&nbsp;
		</form>
	</body>
</HTML>
