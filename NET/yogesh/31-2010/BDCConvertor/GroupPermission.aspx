<%@ Page Language="C#" MasterPageFile="~/LoginMaster.master" AutoEventWireup="true" CodeFile="GroupPermission.aspx.cs" Inherits="GroupPermission" Title="BDC Converter - Group Permission" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <asp:UpdatePanel id="UpdatePanel1" runat="server">
        <contenttemplate>
<TABLE style="BORDER-RIGHT: dodgerblue 1px solid; BORDER-TOP: dodgerblue 1px solid; FONT-SIZE: 10pt; BORDER-LEFT: dodgerblue 1px solid; WIDTH: 400px; BORDER-BOTTOM: dodgerblue 1px solid; FONT-FAMILY: Verdana; HEIGHT: 200px; BACKGROUND-COLOR: #cddefc"><TBODY><TR><TD style="HEIGHT: 20px; BACKGROUND-COLOR: #1c84c5; TEXT-ALIGN: center" colSpan=3><STRONG><SPAN style="COLOR: #ffffff">Group Permission</SPAN></STRONG></TD></TR><TR><TD style="HEIGHT: 20px; TEXT-ALIGN: right" colSpan=3></TD></TR><TR><TD style="TEXT-ALIGN: right"><asp:Label id="lblGroupName" runat="server" Text="Group Name:"></asp:Label></TD><TD style="WIDTH: 5%; TEXT-ALIGN: left"></TD><TD style="TEXT-ALIGN: left"><asp:DropDownList id="drdnGroupName" tabIndex=1 runat="server" Width="150px" AutoPostBack="True" OnSelectedIndexChanged="drdnGroupName_SelectedIndexChanged" BackColor="White"></asp:DropDownList></TD></TR><TR><TD style="VERTICAL-ALIGN: top; TEXT-ALIGN: right"><asp:Label id="lblPermission" runat="server" Text="Permissions:"></asp:Label></TD><TD style="TEXT-ALIGN: left"></TD><TD style="TEXT-ALIGN: left"><asp:CheckBoxList id="CheckBoxList1" tabIndex=2 runat="server" Width="141px" AutoPostBack="True" OnSelectedIndexChanged="CheckBoxList1_SelectedIndexChanged"></asp:CheckBoxList></TD></TR><TR><TD style="WIDTH: 100px; TEXT-ALIGN: right"></TD><TD></TD><TD style="WIDTH: 150px; TEXT-ALIGN: right"></TD></TR><TR><TD style="TEXT-ALIGN: center" colSpan=3><asp:Label id="lblError" runat="server" ForeColor="Red" Font-Size="8pt"></asp:Label> <asp:Label id="lblMsg" runat="server" ForeColor="Green" Font-Size="8pt"></asp:Label></TD></TR><TR><TD style="TEXT-ALIGN: center" colSpan=3><asp:Button id="btnAssPermission" tabIndex=3 onclick="btnAssPermission_Click" runat="server" Width="125px" Text="Assign Permission" BackColor="White" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" __designer:wfdid="w9"></asp:Button> <asp:Button id="btnDelete" tabIndex=3 runat="server" Width="125px" Text="Delete Group" BackColor="White" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" __designer:wfdid="w10" Enabled="False" OnClick="btnDelete_Click" onclientclick="return confirm('Are You Sure')"></asp:Button></TD></TR><TR><TD style="TEXT-ALIGN: right"></TD><TD></TD><TD style="HEIGHT: 5px; TEXT-ALIGN: right"></TD></TR></TBODY></TABLE>
</contenttemplate>
    </asp:UpdatePanel>
</asp:Content>

