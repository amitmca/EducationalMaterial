<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="ValidationControls.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<script language="vbscript"> 
Sub Validate(source, arguments) 
If (arguments.Value > 20000) Then 
arguments.IsValid = True 
Else 
arguments.IsValid = False 
End If 
End Sub 
		</script>
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<asp:RequiredFieldValidator id="RequiredFieldValidator1" style="Z-INDEX: 101; LEFT: 352px; POSITION: absolute; TOP: 80px"
				runat="server" ErrorMessage="You must supply a class rank." ControlToValidate="TextBox1" Font-Names="Verdana"></asp:RequiredFieldValidator>
			<asp:Label id="Label5" style="Z-INDEX: 117; LEFT: 152px; POSITION: absolute; TOP: 288px" runat="server"
				Font-Names="Verdana">The tuition you'll pay:</asp:Label>
			<asp:TextBox id="TextBox5" style="Z-INDEX: 116; LEFT: 152px; POSITION: absolute; TOP: 320px"
				runat="server"></asp:TextBox>
			<asp:Label id="Label4" style="Z-INDEX: 115; LEFT: 152px; POSITION: absolute; TOP: 224px" runat="server"
				Font-Names="Verdana">Your email address:</asp:Label>
			<asp:Label id="Label3" style="Z-INDEX: 114; LEFT: 152px; POSITION: absolute; TOP: 168px" runat="server"
				Font-Names="Verdana">Your age:</asp:Label>
			<asp:Label id="Label2" style="Z-INDEX: 113; LEFT: 152px; POSITION: absolute; TOP: 120px" runat="server"
				Font-Names="Verdana">Your class size:</asp:Label>
			<asp:Label id="Label1" style="Z-INDEX: 112; LEFT: 152px; POSITION: absolute; TOP: 64px" runat="server"
				Font-Names="Verdana">Your class rank:</asp:Label>
			<asp:TextBox id="TextBox4" style="Z-INDEX: 111; LEFT: 152px; POSITION: absolute; TOP: 248px"
				runat="server"></asp:TextBox>
			<asp:TextBox id="TextBox3" style="Z-INDEX: 110; LEFT: 152px; POSITION: absolute; TOP: 192px"
				runat="server"></asp:TextBox>
			<asp:TextBox id="TextBox2" style="Z-INDEX: 109; LEFT: 152px; POSITION: absolute; TOP: 144px"
				runat="server"></asp:TextBox>
			<asp:Button id="Button1" style="Z-INDEX: 108; LEFT: 144px; POSITION: absolute; TOP: 360px" runat="server"
				Text="Admit me to college!"></asp:Button>
			<asp:TextBox id="TextBox1" style="Z-INDEX: 107; LEFT: 152px; POSITION: absolute; TOP: 88px" runat="server"></asp:TextBox>
			<asp:ValidationSummary id="ValidationSummary1" style="Z-INDEX: 106; LEFT: 344px; POSITION: absolute; TOP: 296px"
				runat="server" Width="272px" Height="49px" Font-Names="Verdana"></asp:ValidationSummary>
			<asp:CustomValidator id="CustomValidator1" style="Z-INDEX: 105; LEFT: 368px; POSITION: absolute; TOP: 272px"
				runat="server" ErrorMessage="You have to pay more than that!" ControlToValidate="TextBox5" ClientValidationFunction="Validate"
				Font-Names="Verdana"></asp:CustomValidator>
			<asp:RegularExpressionValidator id="RegularExpressionValidator1" style="Z-INDEX: 104; LEFT: 360px; POSITION: absolute; TOP: 224px"
				runat="server" ErrorMessage="Please enter a valid email address." ControlToValidate="TextBox4" ValidationExpression="\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"
				Font-Names="Verdana"></asp:RegularExpressionValidator>
			<asp:RangeValidator id="RangeValidator1" style="Z-INDEX: 103; LEFT: 360px; POSITION: absolute; TOP: 184px"
				runat="server" ErrorMessage="You must be at &#13;&#10;least 18." ControlToValidate="TextBox3" MinimumValue="18"
				MaximumValue="150" Type="Integer" Font-Names="Verdana"></asp:RangeValidator>
			<asp:CompareValidator id="CompareValidator1" style="Z-INDEX: 102; LEFT: 352px; POSITION: absolute; TOP: 128px"
				runat="server" ErrorMessage="Class rank must be less than class size." ControlToValidate="TextBox2"
				ControlToCompare="TextBox1" Operator="GreaterThanEqual" Width="336px" Height="26px" Type="Integer"
				Font-Names="Verdana"></asp:CompareValidator>
			<asp:Label id="Label6" style="Z-INDEX: 118; LEFT: 192px; POSITION: absolute; TOP: 16px" runat="server">Validation Controls Example</asp:Label>
		</form>
	</body>
</HTML>
