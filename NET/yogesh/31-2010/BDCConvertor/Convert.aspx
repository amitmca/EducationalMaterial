<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Convert.aspx.cs" Inherits="Login" Title="Convert BDC" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">

    <script language="javascript" type="text/javascript">
  function del()
  {
     return confirm("Are You Sure!!!");    
  }
function File1_onclick() {

}

   </script>

    <table style="font-size: 8pt; width: 100%; font-family: Verdana; background-color: #cddefc;
        text-align: right; border-right: #1c84c5 1px solid; border-top: #1c84c5 1px solid; border-left: #1c84c5 1px solid; border-bottom: #1c84c5 1px solid;">
        <tr>
            <td style="width: 60%; text-align: left; border-right: #1c84c5 1px solid; border-top: #1c84c5 1px solid; border-left: #1c84c5 1px solid; border-bottom: #1c84c5 1px solid;">
                <asp:Panel ID="Panel1" runat="server" style="width: 100%">
                <table style="font-size: 8pt; width: 100%; font-family: Verdana; background-color: #cddefc; text-align: right">
                    <tr>
                        <td style="text-align: left">
                            <asp:Label ID="lblLoadBDC" runat="server" Text="Import BDC-From File:"></asp:Label></td>
                        <td style="text-align: left">
                        </td>
                        <td style="width: 165px">
                            <asp:ValidationSummary ID="ValidationSummary1" runat="server" ValidationGroup="Load1" ShowMessageBox="True" ShowSummary="False" Width="149px" />
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right">
                            <input id="File1" type="file" runat="server" style="width: 223px" onclick="return File1_onclick()" /></td>
                        <td style="text-align: left">
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="File1"
                                ErrorMessage="Please Select File to Upload.." ValidationGroup="Load1">*</asp:RequiredFieldValidator></td>
                        <td style="text-align: left">
                </td>
                    </tr>
                    <tr>
                        <td style="text-align: right">
                <asp:Label ID="lblName" runat="server" Text="BDC Name:" Width="74px"></asp:Label><asp:TextBox ID="txtName" runat="server" ValidationGroup="Load1" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" OnDataBinding="Button1_Click"></asp:TextBox></td>
                        <td style="text-align: left">
                            <asp:RequiredFieldValidator
                                ID="RequiredFieldValidator1" runat="server" ControlToValidate="txtName" ErrorMessage="Name Field Should Not be Blank."
                                ValidationGroup="Load1">*</asp:RequiredFieldValidator><asp:RegularExpressionValidator
                                    ID="RegularExpressionValidator1" runat="server" ControlToValidate="txtName" ErrorMessage="Name Field should contains Characters & numbers only."
                                    ValidationExpression="^[a-zA-Z0-9 \\-]+$" ValidationGroup="Load1">*</asp:RegularExpressionValidator></td>
                        <td style="text-align: left">
                <asp:Label ID="Label1" runat="server" Text="HotKey:"></asp:Label><asp:TextBox ID="txtHotkey" runat="server" ValidationGroup="Load1" Width="75px" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px"></asp:TextBox><asp:RegularExpressionValidator
                                ID="RegularExpressionValidator2" runat="server" ControlToValidate="txtHotkey"
                                ErrorMessage="Please Enter Any Function Key.">*</asp:RegularExpressionValidator></td>
                    </tr>
                    <tr>
                        <td style="text-align: right">
                            <asp:Label ID="lblDesc" runat="server" Text="BDC Description:" Width="103px"></asp:Label><asp:TextBox
                                ID="txtDescription" runat="server" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px"
                                OnDataBinding="Button1_Click" ValidationGroup="Load1" Width="153px"></asp:TextBox></td>
                        <td style="text-align: center">
                            <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ErrorMessage="Description Field Should Not be Blank."
                                ValidationGroup="Load1" ControlToValidate="txtDescription">*</asp:RequiredFieldValidator></td>
                        <td style="width: 165px">
                <asp:Button ID="btnLoad" runat="server" OnClick="Button1_Click" Text="Load" Width="75px" ValidationGroup="Load1" BackColor="White" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" /></td>
                    </tr>
                </table>
                    <asp:Label ID="lblMsg" runat="server" ForeColor="Red"></asp:Label></asp:Panel>
                <br />
                <br />
            </td>
            <td style="width: 30%; border-right: #1c84c5 1px solid; border-top: #1c84c5 1px solid; border-left: #1c84c5 1px solid; border-bottom: #1c84c5 1px solid; text-align: right;">
                <table style="font-size: 8pt; width: 60%; font-family: Verdana; background-color: #cddefc; text-align: right">
                    <tr>
                        <td colspan="1" style="text-align: left">
                        </td>
                        <td colspan="2" style="text-align: left">
                            <asp:Label ID="lblLoadBDC1" runat="server" Text="Load BDC-From Database:"></asp:Label></td>
                    </tr>
                    <tr>
                        <td>
                            <asp:Label ID="Label2" runat="server" Text="BDC Name:"></asp:Label></td>
                        <td colspan="2" style="text-align: left">
                <asp:DropDownList ID="drdnBDCName" runat="server" AutoPostBack="True" Width="146px" OnSelectedIndexChanged="drdnBDCName_SelectedIndexChanged">
                </asp:DropDownList></td>
                    </tr>
                    <tr>
                        <td>
                        </td>
                        <td colspan="2" style="text-align: left">
                <asp:Button ID="btnLoadD" runat="server" Text="Load" OnClick="btnLoadD_Click" Width="75px" BackColor="White" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" />&nbsp;
                            <asp:Button ID="btnDelete" runat="server" BackColor="White" BorderColor="#1C84C5"
                                BorderStyle="Solid" BorderWidth="1px" OnClick="Button1_Click1" OnClientClick="return del()" Text="Delete" Width="75px" /></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table style="width: 100%; text-align: right; font-size: 8pt; font-family: Verdana; background-color: #cddefc; border-right: #1c84c5 1px solid; border-left: #1c84c5 1px solid; border-bottom: #1c84c5 1px solid;">
        <tr>
            <td colspan="2" style="text-align: left; border-right: #1c84c5 1px solid; border-top: #1c84c5 1px solid; border-left: #1c84c5 1px solid; border-bottom: #1c84c5 1px solid;">
    <asp:GridView ID="GridView1" runat="server" Width="100%" Font-Names="Verdana" 
                    Font-Size="8pt" AutoGenerateColumns="False" OnPreRender="GridView1_PreRender" 
                     >
        <Columns>
            <asp:BoundField DataField="ProgramName" HeaderText="Program Name" />
            <asp:BoundField DataField="ScreenNo" HeaderText="Screen No" />
            <asp:BoundField DataField="FieldType" HeaderText="Field Type" />
            <asp:BoundField DataField="FieldName" HeaderText="Field Name" />
            <asp:BoundField DataField="FieldValue" HeaderText="Field Value" />
            <asp:TemplateField HeaderText="Screen Field">
           
                <ItemTemplate>
                    <asp:CheckBox ID="CheckBox1" runat="server" AutoPostBack="True" OnCheckedChanged="CheckBox1_CheckedChanged" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" />
                </ItemTemplate>
            </asp:TemplateField>
            
            <asp:TemplateField HeaderText="Caps">
           
                <ItemTemplate>
                    <asp:CheckBox ID="CheckBox2" runat="server"     BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" Enabled="False" />
                </ItemTemplate>
            </asp:TemplateField>
            
            
            
            
            
            <asp:TemplateField HeaderText="Discription">
                <ItemTemplate>
                    <asp:TextBox ID="TextBox2" runat="server" Enabled="False" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" OnTextChanged="TextBox2_TextChanged" ValidationGroup="Generate"></asp:TextBox>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Size">
                <ItemTemplate>
                    <asp:TextBox ID="TextBox1" runat="server" Width="40px" Enabled="False" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px"></asp:TextBox>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Field Sequence">
                <ItemTemplate>
                    <asp:TextBox ID="TextBox3" runat="server" Width="43px" Enabled="False" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px"></asp:TextBox>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="DataType">
                <ItemTemplate>
                    &nbsp;<asp:DropDownList ID="DropDownList1" runat="server" Enabled="False" Width="90px">
                        <asp:ListItem>Text</asp:ListItem>
                        <asp:ListItem>Number</asp:ListItem>
                        <asp:ListItem>Date/Time</asp:ListItem>
                    </asp:DropDownList>
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
        <EditRowStyle BorderColor="Silver" BorderStyle="Solid" BorderWidth="1px" Wrap="False" />
        <HeaderStyle HorizontalAlign="Left" Wrap="False" />
        <RowStyle Wrap="False" />
        <EmptyDataRowStyle Wrap="False" />
        <SelectedRowStyle Wrap="False" />
        <AlternatingRowStyle Wrap="False" />
    </asp:GridView>
                <asp:Label ID="lblGridError" runat="server" ForeColor="Red"></asp:Label></td>
        </tr>
        <tr>
            <td style="text-align: left;" colspan="2">
                <asp:Button ID="btnGenerate" runat="server" Text="Generate Screens" OnClientClick="return validate()" OnClick="btnGenerate_Click" BackColor="White" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" Width="113px" ValidationGroup="Generate" Visible="False"/>
                <asp:Button ID="btnModifyBDC" runat="server" BackColor="White" BorderColor="#1C84C5"
                    BorderStyle="Solid" BorderWidth="1px" Text="Modify BDC" OnClick="btnModifyBDC_Click" Visible="False" /></td>
        </tr>
    </table>
</asp:Content>

