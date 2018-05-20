<%@ Page Language="C#" MasterPageFile="~/LoginMaster.master" AutoEventWireup="true" CodeFile="UserPermission.aspx.cs" Inherits="UserPermission" Title="BDC Converter - User Permission" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<script language="javascript" type="text/javascript">
  function del()
  {
     return confirm("Are You Sure!!!");    
  }
   </script>
    <asp:UpdatePanel id="UpdatePanel1" runat="server">
        <contenttemplate>
<TABLE style="BORDER-RIGHT: dodgerblue 1px solid; BORDER-TOP: dodgerblue 1px solid; FONT-SIZE: 10pt; BORDER-LEFT: dodgerblue 1px solid; WIDTH: 400px; BORDER-BOTTOM: dodgerblue 1px solid; FONT-FAMILY: Verdana; HEIGHT: 200px; BACKGROUND-COLOR: #cddefc"><TBODY><TR><TD style="HEIGHT: 20px; BACKGROUND-COLOR: #1c84c5; TEXT-ALIGN: center" colSpan=3><STRONG><SPAN style="COLOR: #ffffff">User Permission</SPAN></STRONG></TD></TR><TR><TD style="HEIGHT: 20px; TEXT-ALIGN: right" colSpan=3></TD></TR><TR><TD style="TEXT-ALIGN: right"><asp:Label id="lblUserName" runat="server" Text="User Name:"></asp:Label></TD><TD style="WIDTH: 5%; TEXT-ALIGN: left"></TD><TD style="TEXT-ALIGN: left"><asp:DropDownList id="drdnUserName" tabIndex=1 runat="server" Width="150px" OnSelectedIndexChanged="drdnUserName_SelectedIndexChanged" AutoPostBack="True"></asp:DropDownList></TD></TR><TR><TD style="VERTICAL-ALIGN: top; TEXT-ALIGN: right"><asp:Label id="lblPermission" runat="server" Text="Permissions:"></asp:Label></TD><TD style="TEXT-ALIGN: left"></TD><TD style="TEXT-ALIGN: left"><asp:CheckBoxList id="CheckBoxList1" tabIndex=2 runat="server" Width="151px" OnSelectedIndexChanged="CheckBoxList1_SelectedIndexChanged" AutoPostBack="True">
                </asp:CheckBoxList></TD></TR><TR><TD style="WIDTH: 100px; TEXT-ALIGN: right"></TD><TD></TD><TD style="WIDTH: 150px; TEXT-ALIGN: right"></TD></TR><TR><TD style="TEXT-ALIGN: center" colSpan=3><asp:Label id="lblError" runat="server" Font-Size="8pt" ForeColor="Red"></asp:Label><asp:Label id="lblMsg" runat="server" Font-Size="8pt" ForeColor="Green"></asp:Label></TD></TR><TR><TD style="TEXT-ALIGN: right"></TD><TD></TD><TD style="TEXT-ALIGN: left"><asp:Button id="btnAssPermission" tabIndex=3 onclick="btnCreateUser_Click" runat="server" Width="125px" Text="Assign Permission" BorderWidth="1px" BorderStyle="Solid" BorderColor="#1C84C5" BackColor="White"></asp:Button>
                    <asp:Button ID="btnDelete" runat="server" BackColor="White" BorderColor="#1C84C5"
                        BorderStyle="Solid" BorderWidth="1px" OnClientClick="return del()" OnClick="btnDelete_Click" Text="Delete" /></TD></TR><TR><TD style="TEXT-ALIGN: right"></TD><TD></TD><TD style="HEIGHT: 5px; TEXT-ALIGN: right"></TD></TR></TBODY></TABLE>
</contenttemplate>
    </asp:UpdatePanel>
</asp:Content>

