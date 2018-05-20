<%@ Page language="c#" Codebehind="contents.aspx.cs" AutoEventWireup="false" Inherits="Advertisement.contents" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" >
<HTML>
  <HEAD>
		<title>contents</title>
		<meta name="GENERATOR" Content="Microsoft Visual Studio .NET 7.1">
		<meta name="CODE_LANGUAGE" Content="C#">
		<meta name="vs_defaultClientScript" content="JavaScript">
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
  </HEAD>
	<body MS_POSITIONING="GridLayout" bgColor="antiquewhite">
		<form id="Form1" method="post" runat="server">
			<asp:HyperLink id="hlNewAd" style="Z-INDEX: 101; LEFT: 16px; POSITION: absolute; TOP: 104px" runat="server"
				Target="main" NavigateUrl="NewAdv.aspx" Font-Italic="True">New Ad</asp:HyperLink>
			<asp:HyperLink id="hlAccptAd" style="Z-INDEX: 102; LEFT: 16px; POSITION: absolute; TOP: 152px"
				runat="server" Width="72px" Target="main" NavigateUrl="acceptance.aspx" Font-Italic="True">Accept Ad</asp:HyperLink>
			<asp:HyperLink id="hlUpdateAd" style="Z-INDEX: 103; LEFT: 16px; POSITION: absolute; TOP: 200px"
				runat="server" Target="main" NavigateUrl="updateForm.aspx" Font-Italic="True">Update Ad</asp:HyperLink>
			<asp:HyperLink id="hlViewAd" style="Z-INDEX: 104; LEFT: 16px; POSITION: absolute; TOP: 248px" runat="server"
				Target="main" NavigateUrl="view.aspx" Font-Italic="True">View Ad</asp:HyperLink>
			<asp:HyperLink id="hlDailyDetails" style="Z-INDEX: 105; LEFT: 16px; POSITION: absolute; TOP: 296px"
				runat="server" Target="main" NavigateUrl="dailydetails.aspx" Font-Italic="True">Daily Ad Details</asp:HyperLink>
			<asp:HyperLink id="hlLogout" style="Z-INDEX: 106; LEFT: 16px; POSITION: absolute; TOP: 344px" runat="server"
				NavigateUrl="logout.aspx" Target="_top" Font-Italic="True">Logout</asp:HyperLink>
		</form>
	</body>
</HTML>
