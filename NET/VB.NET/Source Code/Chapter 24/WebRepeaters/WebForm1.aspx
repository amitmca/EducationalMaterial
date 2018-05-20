<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="WebRepeaters.WebForm1" smartNavigation="True"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Repeaters Example</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="Visual Basic .NET 7.1" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<table width="100%">
				<asp:Repeater id=Repeater1 runat="server" DataSource="<%# DataSet11 %>" DataMember="authors">
					<HeaderTemplate>
						<tr style="background-color:Gray">
							<th>
								First Name</th>
							<th>
								Last Name</th>
						</tr>
					</HeaderTemplate>
					<ItemTemplate>
						<tr>
							<td><%# DataBinder.Eval(Container, "DataItem.au_fname") %>
							</td>
							<td><%# DataBinder.Eval(Container,"DataItem.au_lname") %>
							</td>
						</tr>
					</ItemTemplate>
					<AlternatingItemTemplate>
						<tr>
							<td bgcolor="Yellow">
								<%# DataBinder.Eval(Container, "DataItem.au_fname") %>
							</td>
							<td bgcolor="Yellow">
								<%# DataBinder.Eval(Container,"DataItem.au_lname") %>
							</td>
						</tr>
					</AlternatingItemTemplate>
					<FooterTemplate>
						<tr style="background-color:Gray">
							<th>
								First Name</th>
							<th>
								Last Name</th>
						</tr>
					</FooterTemplate>
				</asp:Repeater></table>
		</form>
	</body>
</HTML>
