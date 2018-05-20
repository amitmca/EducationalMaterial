<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="HTMLAnchor.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<script runat="server">
  
      Sub AnchorBtn_Click(sender As Object, e As EventArgs)

         ' Display a message when the HtmlAchor control is clicked.
         Message.InnerHtml = "You have clicked the HTML Anchor!!"
      
      End Sub
  
		</script>
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<a ID="AnchorButton" OnServerClick="AnchorBtn_Click" runat="server" style="Z-INDEX: 100; LEFT: 272px; WIDTH: 63px; POSITION: absolute; TOP: 88px; HEIGHT: 19px">
				Click here </a>
			<h1>
				<span id="Message" runat="server" style="Z-INDEX: 102; LEFT: 288px; POSITION: absolute; TOP: 152px">
				</span>
				<DIV style="DISPLAY: inline; Z-INDEX: 103; LEFT: 224px; WIDTH: 232px; POSITION: absolute; TOP: 40px; HEIGHT: 24px"
					ms_positioning="FlowLayout" id="DIV1" runat="server">
					<P><FONT face="Verdana" size="4">HTML Anchor Example</FONT></P>
				</DIV>
			</h1>
		</form>
	</body>
</HTML>
