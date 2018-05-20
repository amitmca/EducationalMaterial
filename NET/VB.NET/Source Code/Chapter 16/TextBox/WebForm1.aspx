<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="TextBox.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:Button id="Button1" style="Z-INDEX: 101; LEFT: 101px; POSITION: absolute; TOP: 78px" runat="server"
				Text="Click me" Width="114px" Height="24px"></asp:Button>
			<asp:Label id="Label1" style="Z-INDEX: 106; LEFT: 102px; POSITION: absolute; TOP: 115px" runat="server">
Enter password:</asp:Label>
			<asp:TextBox id="TextBox4" style="Z-INDEX: 105; LEFT: 100px; POSITION: absolute; TOP: 188px"
				runat="server" Width="119px" Height="27px"></asp:TextBox>
			<asp:TextBox id="TextBox3" style="Z-INDEX: 104; LEFT: 101px; POSITION: absolute; TOP: 146px"
				runat="server" Width="118px" Height="24px" TextMode="Password"></asp:TextBox>
			<asp:TextBox id="TextBox2" style="Z-INDEX: 103; LEFT: 233px; POSITION: absolute; TOP: 117px"
				runat="server" Width="157px" Height="74px" TextMode="MultiLine"></asp:TextBox>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 102; LEFT: 235px; POSITION: absolute; TOP: 78px" runat="server"
				AutoPostBack="True"></asp:TextBox>
		</form>
	</body>
</HTML>
