<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="HTMLSelect.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<script runat="server">

      Sub Button_Click (sender As Object, e As EventArgs)
        
         Dim i As Integer

         Label1.Text = "You have selected "

         For i = 0 to Select1.Items.Count - 1
  
            If Select1.Items(i).Selected Then
               Label1.Text = Label1.Text & " &nbsp;&nbsp; " & Select1.Items(i).Text
            End If         

         Next i

      End Sub

		</script>
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			&nbsp;
			<br>
			<select id="Select1" Multiple runat="server" NAME="Select1" style="Z-INDEX: 101; LEFT: 280px; POSITION: absolute; TOP: 104px">
				<OPTION value="Monday" selected>Monday</OPTION>
				<OPTION value="Tuesday">Tuesday</OPTION>
				<OPTION value="Wednesday">Wednesday</OPTION>
				<OPTION value="Thursday">Thursday</OPTION>
				<OPTION value="Friday">Friday</OPTION>
				<OPTION value="Saturday">Saturday</OPTION>
				<OPTION value="Sunday">Sunday</OPTION>
			</select>
			<DIV style="DISPLAY: inline; Z-INDEX: 104; LEFT: 211px; WIDTH: 256px; POSITION: absolute; TOP: 53px; HEIGHT: 32px"
				ms_positioning="FlowLayout"><FONT face="Verdana" size="4">HTML Select Example</FONT></DIV>
			<br>
			&nbsp;
			<br>
			<br>
			<button id="Button1" OnServerClick="Button_Click" runat="server" type="button" style="Z-INDEX: 102; LEFT: 128px; POSITION: absolute; TOP: 208px">
				Submit </button>
			<asp:Label id="Label1" runat="server" style="Z-INDEX: 103; LEFT: 240px; POSITION: absolute; TOP: 216px" />
			<DIV style="DISPLAY: inline; Z-INDEX: 105; LEFT: 120px; WIDTH: 136px; POSITION: absolute; TOP: 120px; HEIGHT: 32px"
				ms_positioning="FlowLayout"><FONT face="Verdana" size="2">Please Select a day</FONT></DIV>
		</form>
	</body>
</HTML>
