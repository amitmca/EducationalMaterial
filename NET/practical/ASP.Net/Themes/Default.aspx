<%@ Page Language="VB"  Theme="Theme1"  AutoEventWireup="false" CodeFile="Default.aspx.vb" Inherits="_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>Untitled Page</title>
</head>
<body id="button2">
    <form id="form1" runat="server">
    <div>
        <asp:Button  ID="Button2" SkinID="buttonskin1" runat="server" Text="Button" Width="72px" /></div>
        <asp:Button  SkinID ="buttonskin2" ID="Button1" runat="server" Text="Button" Width="72px" /><br />
        &nbsp;<asp:Label  SkinID="label1" ID="Label1" runat="server" Text="This is My label" Width="138px"></asp:Label>
        <asp:TextBox  SkinID ="textbox1" ID="TextBox1" runat="server"></asp:TextBox><br />
        <br />
        
    </form>
</body>
</html>
