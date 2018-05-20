<%@ Page Language="vb" AutoEventWireup="false" Codebehind="WebForm1.aspx.vb" Inherits="HTMLFileUpload.WebForm1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<title>WebForm1</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" content="Visual Basic .NET 7.1">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<script language="VB" runat="server">
       Sub FileUpload(Source As Object, e As EventArgs)
            
            If Text1.Value = "" Then
                messagespan.InnerHtml = "Error: Please provide a file name before proceeding"
                Return
            End If
            
            If Not (Select_UploadFile.PostedFile Is Nothing) Then
                Try
                    Select_UploadFile.PostedFile.SaveAs(("c:\FileUpload\" & Text1.Value))
                    messagespan.InnerHtml = "Your File has been uploaded successfully to <b>c:\FileUpload\" & _
                                      Text1.Value & "</b>"
                Catch exc As Exception
                    messagespan.InnerHtml = "Some Error occured while saving the file <b>c:\FileUpload\" & _
                                      Text1.Value & "</b><br>" & exc.ToString()
                End Try
            End If
        End Sub 
		</script>
	</HEAD>
	<body MS_POSITIONING="GridLayout">
		<form id="Form1" method="post" runat="server">
			<DIV style="DISPLAY: inline; Z-INDEX: 101; LEFT: 144px; WIDTH: 264px; POSITION: absolute; TOP: 48px; HEIGHT: 24px"
				ms_positioning="FlowLayout"><FONT face="Verdana" size="4">HTML File Upload example</FONT></DIV>
			<DIV style="DISPLAY: inline; Z-INDEX: 102; LEFT: 40px; WIDTH: 112px; POSITION: absolute; TOP: 144px; HEIGHT: 32px"
				ms_positioning="FlowLayout"><FONT face="Verdana" size="2">Select File :</FONT></DIV>
			<DIV style="DISPLAY: inline; Z-INDEX: 103; LEFT: 40px; WIDTH: 208px; POSITION: absolute; TOP: 200px; HEIGHT: 48px"
				ms_positioning="FlowLayout"><FONT face="Verdana" size="2">Save as (Filename with 
					proper extension):</FONT></DIV>
			<INPUT id="Select_UploadFile" style="Z-INDEX: 104; LEFT: 312px; POSITION: absolute; TOP: 144px"
				type="file" name="Select_UploadFile" runat="server"> <INPUT id="Text1" style="Z-INDEX: 105; LEFT: 312px; POSITION: absolute; TOP: 200px" type="text"
				name="Text1" runat="server"><INPUT id="Button1" style="Z-INDEX: 106; LEFT: 80px; POSITION: absolute; TOP: 272px" type="button"
				value="Upload File" name="Button1" runat="server" OnServerClick="Fileupload"><INPUT id="Reset1" style="Z-INDEX: 107; LEFT: 216px; POSITION: absolute; TOP: 272px" type="reset"
				value="Reset" name="Reset1" runat="server"> <span id="messagespan" style="Z-INDEX: 108; LEFT: 88px; POSITION: absolute; TOP: 320px"
				runat="server" />
		</form>
	</body>
</HTML>
