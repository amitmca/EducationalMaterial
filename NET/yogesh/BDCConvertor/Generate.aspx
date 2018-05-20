<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Generate.aspx.cs" Inherits="Generate" Title="BDC Entries" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table style="border-right: #1c84c5 1px solid; border-top: #1c84c5 1px solid; border-left: #1c84c5 1px solid;
        width: 50%; border-bottom: #1c84c5 1px solid; background-color: #cddefc; font-size: 8pt; font-family: Verdana;">
        <tr>
            <td bgcolor="#1c84c5" colspan="3">
                <asp:Label ID="lblBDCName" runat="server" Font-Size="12pt" ForeColor="White" Font-Names="Verdana"></asp:Label></td>
        </tr>
        <tr>
            <td colspan="3" style="border-right: #1c84c5 1px solid; border-top: #1c84c5 1px solid;
                border-left: #1c84c5 1px solid; border-bottom: #1c84c5 1px solid">
                <asp:Label ID="lblDscrptn" runat="server" Font-Names="Verdana" Font-Size="12pt" ForeColor="Black"></asp:Label></td>
        </tr>
        <tr>
            <td colspan="3" style="border-right: #1c84c5 1px solid; border-top: #1c84c5 1px solid;
                border-left: #1c84c5 1px solid; border-bottom: #1c84c5 1px solid">
    <asp:Table ID="display1" runat="server" Style="width: 100%" Font-Names="Verdana" Font-Size="10pt">
    </asp:Table>
            </td>
        </tr>
        <tr>
            <td style="text-align: center;" colspan="3">
                <asp:Label ID="lblMsg" runat="server" ForeColor="Green"></asp:Label></td>
        </tr>
        <tr>
            <td style="text-align: right">
                <asp:Button ID="btnSave" runat="server" OnClick="btnSave_Click" Text="Save" Width="62px" BackColor="White" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana" /></td>
            <td style="width: 5px; text-align: left">
            </td>
            <td style="text-align: left">
                <asp:Button ID="btnCancel" runat="server" Text="Cancel" Width="62px" BackColor="White" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana" OnClick="btnCancel_Click" /></td>
        </tr>
        <tr>
            <td colspan="3" style="text-align: right">
            </td>
        </tr>
    </table>
    <br />
    <table style="border-right: #1c84c5 1px solid; border-top: #1c84c5 1px solid; border-left: #1c84c5 1px solid;
        width: 80%; border-bottom: #1c84c5 1px solid; background-color: #cddefc; font-size: 8pt; font-family: Verdana;">
        <tr>
            <td colspan="3" style="text-align: right">
                <asp:GridView ID="GridView1" runat="server" EmptyDataText="There Is No Record In Database"
                    Style="width: 100%">
                    <RowStyle HorizontalAlign="Left" />
                    <HeaderStyle BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" ForeColor="Black"
                        HorizontalAlign="Left" />
                </asp:GridView>
            </td>
        </tr>
    </table>
</asp:Content>

