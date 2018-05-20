<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="WebDataList.WebForm1"%>
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
			<asp:DataList id=DataList1 style="Z-INDEX: 101; LEFT: 144px; POSITION: absolute; TOP: 64px" runat="server" DataSource='<%# DataBinder.Eval(DataSet11, "Tables[authors]") %>'>
				<ItemTemplate>
					<asp:Label id=Label2 runat="server" Text='<%# DataBinder.Eval(Container,"DataItem.au_fname") %>'>
					</asp:Label>&nbsp;&nbsp;
					<asp:Label id=Label3 runat="server" Text='<%# DataBinder.Eval(Container, "DataItem.au_lname") %>'>
					</asp:Label>
				</ItemTemplate>
			</asp:DataList>
			<asp:Label id="Label1" style="Z-INDEX: 102; LEFT: 16px; POSITION: absolute; TOP: 16px" runat="server"
				Font-Bold="True" Font-Names="Verdana" Font-Size="Large">Using DataList</asp:Label>
		</form>
	</body>
</HTML>