<%@ Register TagPrefix="mobile" Namespace="System.Web.UI.MobileControls" Assembly="System.Web.Mobile" %>
<%@ Page Language="vb" AutoEventWireup="false" Codebehind="MobileWebForm1.aspx.vb" Inherits="MyMobile.MobileWebForm1" %>
<HEAD>
	<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
	<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
	<meta name="vs_targetSchema" content="http://schemas.microsoft.com/Mobile/Page">
</HEAD>
<body Xmlns:mobile="http://schemas.microsoft.com/Mobile/WebForm">
	<mobile:Form id="Form1" runat="server">
		<mobile:Label id="Label1" runat="server">What is ur favorite ice cream?</mobile:Label>
		<BR>
		<mobile:SelectionList id="SelectionList1" runat="server">
			<Item Value="Chocolate" Text="Chocolate"></Item>
			<Item Value="Butter Scotch" Text="Butter Scotch"></Item>
			<Item Value="Vanilla" Text="Vanilla"></Item>
		</mobile:SelectionList>
		<BR>
		<mobile:Label id="Label2" runat="server"></mobile:Label>
		<BR>
		<mobile:Command id="Command1" runat="server">Enter</mobile:Command>
	</mobile:Form>
</body>
