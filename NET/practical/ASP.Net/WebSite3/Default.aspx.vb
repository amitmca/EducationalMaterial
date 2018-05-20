
Partial Class _Default
    Inherits System.Web.UI.Page

    Protected Sub Page_Init(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Init
        Trace.Write("Page Init event")
    End Sub

    Protected Sub Page_InitComplete(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.InitComplete
        Trace.Write("Page Init Complete event")
    End Sub

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        Trace.Write("Page Load event")
    End Sub

    Protected Sub Page_LoadComplete(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.LoadComplete
        Trace.Write("Page Load complete event")
    End Sub

    Protected Sub Page_PreInit(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.PreInit
        Trace.Write("Page pre event")
    End Sub

    Protected Sub Page_PreLoad(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.PreLoad
        Trace.Write("Page Pre Load event")
    End Sub

    Protected Sub Page_PreRender(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.PreRender
        Trace.Write("Page Pre Render event")
    End Sub

    Protected Sub Page_SaveStateComplete(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.SaveStateComplete
        Trace.Write("Page Save State Complete  event")
    End Sub

    Protected Sub Page_Unload(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Unload
        Trace.Write("Page Unload event")
    End Sub
End Class
