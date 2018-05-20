<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="AddItems.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Add Items</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:listbox id="ListBox1" style="Z-INDEX: 101; LEFT: 176px; POSITION: absolute; TOP: 72px" runat="server"
				Width="154px" Height="112px" AutoPostBack="True"></asp:listbox>
			<INPUT id="Hidden1" style="Z-INDEX: 104; LEFT: 184px; POSITION: absolute; TOP: 264px" type="hidden"
				value="0" runat="server" NAME="Hidden1">
			<asp:button id="Button1" style="Z-INDEX: 103; LEFT: 208px; POSITION: absolute; TOP: 184px" runat="server"
				Width="103px" Height="24px" Text="Add a new item"></asp:button>
			<asp:textbox id="TextBox1" style="Z-INDEX: 102; LEFT: 184px; POSITION: absolute; TOP: 232px"
				runat="server"></asp:textbox>
			<asp:Label id="Label1" style="Z-INDEX: 105; LEFT: 112px; POSITION: absolute; TOP: 32px" runat="server"
				Width="342px" Font-Bold="True" Font-Names="Verdana">Adding Items in List Box on Runtime</asp:Label>
		</form>
	</body>
</HTML>
