<%@ Page Language="VB" AutoEventWireup="false" CodeFile="Default.aspx.vb" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Untitled Page</title>
</head>
<body>
    <form id="form1" runat="server" method="get">
    <div>
        Example Of Cross Page Posting<br />
        <asp:Label ID="Label1" runat="server" Height="26px" Text="Enter Your Name" Width="131px"></asp:Label>
        <asp:TextBox ID="txt" runat="server"></asp:TextBox><br /><br />
        <asp:Button ID="Button1" runat="server" Text="Submit"  PostBackUrl="~/Default2.aspx"/></div>
    </form>
</body>
</html>
