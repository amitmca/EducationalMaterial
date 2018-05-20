<%@ Page Language="C#" MasterPageFile="~/BlankMaster.master" AutoEventWireup="true" CodeFile="Index.aspx.cs" Inherits="HomePageH" Title="BDC Converter - Login"%>

<%@ Register Assembly="AjaxControlToolkit" Namespace="AjaxControlToolkit" TagPrefix="cc1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
 
    <asp:UpdatePanel id="UpdatePanel1" runat="server">
        <contenttemplate>
    <asp:Panel ID="LoginPanel" runat="server" style="background-color: #cddefc;" Width="350px">
    <table style="font-family: Verdana; border-right: #1c84c5 1px solid; border-top: #1c84c5 1px solid; border-left: #1c84c5 1px solid; border-bottom: #1c84c5 1px solid; width: 100%;">
        <tr>
            <td style="text-align: center" height="10">
            </td>
        </tr>
        <tr>
            <td style="background-color: #1c84c5; text-align: center" height="25">
                <span style="color: white">Sing in to BDC Converter</span></td>
        </tr>
        <tr>
            <td style="text-align: center">
                <strong> <b style="font-size: 12pt"> 
                        <span style="font-size: 10pt">&nbsp;<br />
                            <table style="border-left-color: #ffffff; border-bottom-color: #ffffff; border-top-color: #ffffff; border-right-color: #ffffff;">
                                <tr>
                                    <td style="width: 100px; text-align: right">
                                        &nbsp;<asp:Label ID="lblUsrNm" runat="server" Text="User Name:" Font-Bold="False"></asp:Label></td>
                                    <td style="width: 100px; text-align: left">
                                        <asp:TextBox ID="txtUsrNm" runat="server" Style="width: 150px" BackColor="White" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" TabIndex="1"></asp:TextBox></td>
                                    <td>
                                        <asp:RequiredFieldValidator ID="ReqFieldValidator1" runat="server" ControlToValidate="txtUsrNm"
                                            Display="None" ErrorMessage="User Name should not be blank." Font-Bold="False"></asp:RequiredFieldValidator></td>
                                </tr>
                                <tr>
                                    <td style="width: 100px; text-align: right">
                                        <asp:Label ID="lblPswd" runat="server" Text="Password:" Font-Bold="False"></asp:Label></td>
                                    <td style="width: 100px; text-align: left">
                                        <asp:TextBox ID="txtPswd" runat="server" OnTextChanged="Button1_Click" Style="width: 150px"
                                            TextMode="Password" BackColor="White" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" TabIndex="2"></asp:TextBox></td>
                                    <td>
                                        <asp:RequiredFieldValidator ID="ReqFieldValidator2" runat="server" ControlToValidate="txtPswd"
                                            Display="None" ErrorMessage="Password should not be blank." Font-Bold="False"></asp:RequiredFieldValidator></td>
                                </tr>
                                <tr>
                                    <td style="width: 100px; height: 5px;">
                                    </td>
                                    <td style="width: 200px; text-align: center">
                                        </td>
                                    <td>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="3">
                                        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click"
                                            Text="Sign In" BackColor="White" BorderColor="#1C84C5" BorderStyle="Solid" BorderWidth="1px" Font-Bold="False" Font-Names="Verdana" ForeColor="Black" TabIndex="3" /></td>
                                </tr>
                                <tr>
                                    <td style="width: 100px;">
                                    </td>
                                    <td colspan="2" style="text-align: left;">
                                        <cc1:ValidatorCalloutExtender ID="ValidatorCalloutExtender1" runat="server" TargetControlID="ReqFieldValidator1">
                                        </cc1:ValidatorCalloutExtender>
                                        <cc1:ValidatorCalloutExtender ID="ValidatorCalloutExtender2" runat="server" TargetControlID="ReqFieldValidator2">
                                        </cc1:ValidatorCalloutExtender>
                                    </td>
                                </tr>
                            </table>
                        </span></b>
                    </strong>
                                        <asp:Label ID="lblMsg" runat="server" ForeColor="Red" Font-Bold="False" Font-Size="8pt"></asp:Label></td>
        </tr>
        <tr>
            <td style="height: 5px; text-align: center">
            </td>
        </tr>
    </table>
    </asp:Panel>
    <cc1:AlwaysVisibleControlExtender ID="AlwaysVisibleControlExtender1" runat="server"
        TargetControlID="LoginPanel" HorizontalSide="Center" VerticalSide="Middle">
    </cc1:AlwaysVisibleControlExtender>
    <cc1:AnimationExtender ID="AnimationExtender1" runat="server" TargetControlID="Button1">
    <Animations>
            <OnLoad>
                <OpacityAction Opacity=".3" />
            </OnLoad>
            <OnHoverOver>
                <FadeIn Duration=".25" Fps="10" MinimumOpacity=".3" MaximumOpacity=".8" />
            </OnHoverOver>
            <OnHoverOut>
                <FadeOut Duration=".25" Fps="20" MinimumOpacity=".3" MaximumOpacity=".8" />
            </OnHoverOut></Animations>
    </cc1:AnimationExtender>
    <cc1:RoundedCornersExtender ID="RoundedCornersExtender1" runat="server" BorderColor="28, 132, 197"
        Color="28, 132, 197" Radius="20" TargetControlID="LoginPanel">
    </cc1:RoundedCornersExtender></contenttemplate>
    </asp:UpdatePanel>
    &nbsp; &nbsp;
     </asp:Content>

