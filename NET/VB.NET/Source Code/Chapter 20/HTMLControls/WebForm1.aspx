<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="HTMLControls.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>HTML Controls Example</TITLE>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR">
		<meta content="Visual Basic .NET 7.1" name="CODE_LANGUAGE">
		<meta content="JavaScript" name="vs_defaultClientScript">
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema">
		<script language="javascript"> 
			<!--
			function Button1_onclick() 
			{ 
				document.Form1.Text1.value = "Welcome to client coding!" 
			} 
			-->
		</script>
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="form1" method="post" runat="server">
			<DIV style="DISPLAY: inline; Z-INDEX: 101; LEFT: 216px; WIDTH: 70px; POSITION: absolute; TOP: 128px; HEIGHT: 15px"
				ms_positioning="FlowLayout" id="DIV1" runat="server">Label</DIV>
			<DIV style="DISPLAY: inline; Z-INDEX: 112; LEFT: 248px; WIDTH: 70px; BORDER-TOP-STYLE: none; BORDER-RIGHT-STYLE: none; BORDER-LEFT-STYLE: none; POSITION: absolute; TOP: 224px; HEIGHT: 15px; BORDER-BOTTOM-STYLE: none"
				ms_positioning="FlowLayout">
				Check Box</DIV>
			<SELECT style="Z-INDEX: 111; LEFT: 472px; WIDTH: 114px; POSITION: absolute; TOP: 224px; HEIGHT: 38px"
				size="2">
				<OPTION>List Item 1</OPTION>
				<OPTION>List Item 2</OPTION>
				<OPTION>List Item 3</OPTION>
			</SELECT>
			<TABLE style="Z-INDEX: 109; LEFT: 216px; WIDTH: 376px; POSITION: absolute; TOP: 104px"
				size="2">
				<OPTION>List Item 1</OPTION>
				<OPTION>List Item 2</OPTION>
				<OPTION>List Item 3</OPTION>
				</SELECT></TABLE>
			<TABLE style="Z-INDEX: 110; LEFT: 216px; WIDTH: 376px; POSITION: absolute; TOP: 272px; HEIGHT: 72px"
				cellSpacing="1" cellPadding="1" width="376" border="1">
				<TR>
					<TD id="TD1" runat="server">1</TD>
					<TD>2</TD>
					<TD>3</TD>
				</TR>
				<TR>
					<TD>4</TD>
					<TD>5</TD>
					<TD>6</TD>
				</TR>
				<TR>
					<TD>7</TD>
					<TD>8</TD>
					<TD>9</TD>
				</TR>
			</TABLE>
			<INPUT style="Z-INDEX: 108; LEFT: 336px; WIDTH: 20px; POSITION: absolute; TOP: 224px; HEIGHT: 20px"
				type="radio" id="Radio1" title="" CHECKED value="Radio1" name="" runat="server">
			<INPUT style="Z-INDEX: 107; LEFT: 224px; POSITION: absolute; TOP: 224px" type="checkbox"
				id="Checkbox1" title="Check Box" name="Checkbox1" runat="server" CHECKED> <TEXTAREA style="Z-INDEX: 106; LEFT: 408px; WIDTH: 183px; POSITION: absolute; TOP: 168px; HEIGHT: 38px"
				rows="2" cols="20" id="TEXTAREA1" name="TEXTAREA1" runat="server"> 
Text Area</TEXTAREA> <INPUT style="Z-INDEX: 105; LEFT: 224px; WIDTH: 155px; POSITION: absolute; TOP: 176px; HEIGHT: 22px"
				type="text" value="Text Field" id="Text1" name="Text1" runat="server"> <INPUT style="Z-INDEX: 104; LEFT: 520px; WIDTH: 63px; POSITION: absolute; TOP: 128px; HEIGHT: 24px"
				type="submit" value="Submit" id="Submit1" name="Submit1" runat="server"> <INPUT style="Z-INDEX: 103; LEFT: 432px; WIDTH: 52px; POSITION: absolute; TOP: 128px; HEIGHT: 24px"
				type="reset" value="Reset" id="Reset1" name="Reset1" runat="server">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<INPUT style="Z-INDEX: 102; LEFT: 328px; POSITION: absolute; TOP: 128px" type="button"
				value="Button" id="Button1" name="Button1" runat="server">&nbsp;
			<DIV style="DISPLAY: inline; Z-INDEX: 113; LEFT: 360px; WIDTH: 94px; POSITION: absolute; TOP: 224px; HEIGHT: 22px"
				ms_positioning="FlowLayout">Radio Button</DIV>
			<DIV style="DISPLAY: inline; Z-INDEX: 114; LEFT: 176px; WIDTH: 288px; POSITION: absolute; TOP: 40px; HEIGHT: 40px"
				ms_positioning="FlowLayout"><FONT face="Verdana" size="5">HTML Controls Example</FONT></DIV>
		</form>
		</SCRIPT>
	</body>
</HTML>
