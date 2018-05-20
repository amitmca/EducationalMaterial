<%
'*****************************************************
'* Code written by Alexander Haneng (C) 1998-2001    *
'* FREE download from http://www.haneng.com/         *
'*****************************************************
%>
<HTML>
<HEAD>
<TITLE>Confirmation </TITLE>
<BODY> 
<%
Set JMail = Server.CreateObject("JMail.SMTPMail") 
' This is my local SMTP server
JMail.ServerAddress = "mail.yourdomain.com:25"

' This is me....
JMail.Sender = "myemail@mydomain.net" 
JMail.Subject = Request.Form("Subject")

' Get the recipients mailbox from a form (note the lack of an equal sign).
JMail.AddRecipient Request.Form("MailTo")

' The body property is both read and write.
' If you want to append text to the body you can
' use JMail.Body = JMail.Body & "Hello world!"
' or you can use JMail.AppendText "Hello World!"
' which in many cases is easier to use.
JMail.Body = Request.Form("body")


' 1 - highest priority (Urgent)
' 3 - normal
' 5 - lowest

JMail.Priority = 3

'JMail.AddHeader "Originating-IP",
'Request.ServerVariables("REMOTE_ADDR")

' Must make sure that IUSR_???? has access to the following files.
' I've disabled the attachments and footer in this demo
'JMail.AppendBodyFromFile "e:\mail\standard_footer.txt"
'JMail.AddAttachment "e:\products\MyProduct.exe"

JMail.Execute

%>
<CENTER> 
An e-mail has been sent to your mailbox (<%=request.form("MailTo")%>).
</CENTER>
</BODY>
</HTML>