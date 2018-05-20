<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="HTMLInputHidden.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="Visual Basic .NET 7.1" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		<script language="VB" runat="server">
    

 Sub btnclick(sender As Object, e As EventArgs)
		Span1.InnerHtml = "Hidden value is: " & "<b>" & hiddenfield.Value & "</b>"
    
    End Sub 
		</script>
		</SCRIPT>
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<input id="hiddenfield" type="hidden" value="Some hidden Value" runat="server" NAME="hiddenfield">
			<DIV style="DISPLAY: inline; Z-INDEX: 101; LEFT: 264px; WIDTH: 224px; POSITION: absolute; TOP: 64px; HEIGHT: 44px"
				ms_positioning="FlowLayout"><FONT face="Verdana" size="4">Hidden Value example</FONT></DIV>
			<INPUT style="Z-INDEX: 102; LEFT: 280px; POSITION: absolute; TOP: 128px" type="submit"
				value="Submit" OnServerClick="btnclick" id="Submit1" name="Submit1" runat="server">
			<span id="Span1" runat="server" style="Z-INDEX: 102; LEFT: 216px; POSITION: absolute; TOP: 176px">
			</span>
		</form>
	</body>
</HTML>
