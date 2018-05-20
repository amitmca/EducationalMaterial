<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="WebDataBinding.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>Web Data Binding Example</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:TextBox id=TextBox1 style="Z-INDEX: 101; LEFT: 100px; POSITION: absolute; TOP: 96px" runat="server" Text='<%# DataBinder.Eval(DataSet11, "Tables[authors].DefaultView.[0].au_fname") %>'>
			</asp:TextBox>
			<asp:CheckBoxList id=CheckBoxList1 style="Z-INDEX: 107; LEFT: 285px; POSITION: absolute; TOP: 216px" runat="server" DataTextField="au_lname" 
DataSource="<%# DataSet11 %>">
			</asp:CheckBoxList>
			<asp:TextBox id=TextBox2 style="Z-INDEX: 102; LEFT: 101px; POSITION: absolute; TOP: 136px" runat="server" Text= 
'<%# DataBinder.Eval(DataSet11, "Tables[authors].DefaultView.[0].au_lname") %>'>
			</asp:TextBox>
			<asp:ListBox id=ListBox1 style="Z-INDEX: 103; LEFT: 291px; POSITION: absolute; TOP: 96px" runat="server" Height="70px" Width="156px" 
DataSource="<%# DataSet11 %>" DataTextField="au_lname">
			</asp:ListBox>
			<asp:DropDownList id=DropDownList1 style="Z-INDEX: 104; LEFT: 292px; POSITION: absolute; TOP: 184px" runat="server" Height="22px" Width="156px" 
DataTextField="au_lname" DataSource="<%# DataSet11 %>">
			</asp:DropDownList>
			<asp:CheckBox id=CheckBox1 style="Z-INDEX: 105; LEFT: 97px; POSITION: absolute; TOP: 224px" runat="server" Text="Contract" Checked= 
'<%# DataBinder.Eval(DataSet11, "Tables[authors].DefaultView.[0].contract") %>'>
			</asp:CheckBox>
			<asp:RadioButton id=RadioButton1 style="Z-INDEX: 106; LEFT: 96px; POSITION: absolute; TOP: 200px" runat="server" Text="Contract" 
Checked='<%# DataBinder.Eval(DataSet11, "Tables[authors].DefaultView.[0].contract") %>'>
			</asp:RadioButton>
			<asp:Label id=Label1 style="Z-INDEX: 108; LEFT: 102px; POSITION: absolute; TOP: 168px" runat="server" Text= 
'<%# DataBinder.Eval(DataSet11, "Tables[authors].DefaultView.[0].au_lname") %>'>
			</asp:Label>
			<asp:HyperLink id=HyperLink1 style="Z-INDEX: 109; LEFT: 100px; POSITION: absolute; TOP: 256px" runat="server" 
Text='<%# DataBinder.Eval(DataSet11, "Tables[authors].DefaultView.[0].au_lname") %>' NavigateUrl="http:// www.microsoft.com">
			</asp:HyperLink>
			<asp:Label id="Label2" style="Z-INDEX: 110; LEFT: 24px; POSITION: absolute; TOP: 40px" runat="server"
				Width="408px" Font-Bold="True" Font-Names="Verdana" Font-Size="Large">Binding Data to Web Controls</asp:Label>
		</form>
	</body>
</HTML>
