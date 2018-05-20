<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="HTMLInPutImage.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<script language="VB" runat="server">

      Sub SubmitBtn_Click(ByVal Source As Object, ByVal E as ImageClickEventArgs)
         Message.InnerHtml = "You have clicked Submit button!"
      End Sub
 
      Sub ClearBtn_Click(ByVal Source As Object, ByVal E as ImageClickEventArgs)
         Message.InnerHtml = "You have clicked Reset button!"
      End Sub

		</script>
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			&nbsp;&nbsp;&nbsp; <input type="image" src="reset.JPG" OnServerClick="ClearBtn_Click" runat="server" ID="Image2"
				NAME="Image2" style="Z-INDEX: 101; LEFT: 400px; POSITION: absolute; TOP: 104px">
			<input type="image" src="Submit.jpg" OnServerClick="SubmitBtn_Click" runat="server" ID="Image1"
				NAME="Image1" style="Z-INDEX: 102; LEFT: 248px; POSITION: absolute; TOP: 104px">
			<DIV style="DISPLAY: inline; Z-INDEX: 103; LEFT: 256px; WIDTH: 272px; POSITION: absolute; TOP: 48px; HEIGHT: 32px"
				ms_positioning="FlowLayout"><FONT face="Verdana" size="4">Image Input example</FONT></DIV>
			<span id="Message" runat="server" style="Z-INDEX: 101; LEFT: 264px; POSITION: absolute; TOP: 176px">
			</span>
		</form>
	</body>
</HTML>
