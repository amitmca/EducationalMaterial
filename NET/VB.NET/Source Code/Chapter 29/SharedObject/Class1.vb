Imports System.Drawing
Imports System.Runtime.Remoting.Lifetime
Imports System.Runtime.Remoting.Messaging

Public Delegate Sub StrokeEvent(ByVal from As Point, ByVal till As Point)
Public Delegate Sub StatusEvent(ByVal msg As String)

<Serializable()> Public Class SentOver
    Public Sub Greeting(ByVal name As String)
        Diagnostics.Debug.WriteLine("SentOver says Hi : " + name)
    End Sub
End Class
<Serializable()> _
Public Class SharedObject
    Inherits System.MarshalByRefObject

    Private Shared Count As Integer = 0
    Public Event Stroke As StrokeEvent
    Public Event Status As StatusEvent

    Public Sub New()
        Count += 1
    End Sub



    Public Function GetCount() As Integer
        Return Count
    End Function

    Public Sub Greeting(ByVal name As String)
        Diagnostics.Debug.WriteLine("SharedObject says Hi : " + name)
        RaiseEvent Status("SharedObject says Hi : " + name)
    End Sub

    Public Sub Confer(ByVal From As Point, ByVal Till As Point)
        RaiseEvent Stroke(From, Till)
    End Sub

    <OneWay()> _
    Public Sub ClimbTheCliff()
        Diagnostics.Debug.WriteLine("Climbing the cliff, see you later.")
        System.Threading.Thread.Sleep(1000)
        Diagnostics.Debug.WriteLine("I'm back.")
    End Sub

    Public Overrides Function InitializeLifetimeService() As Object
        Dim myLease As ILease = MyBase.InitializeLifetimeService()
        myLease.InitialLeaseTime = TimeSpan.FromMinutes(10)
        myLease.RenewOnCallTime = TimeSpan.FromMinutes(50)
        Return myLease
    End Function
End Class


Public Class EventSink
    Inherits MarshalByRefObject
    Dim DrawLineMethod As StrokeEvent
    Dim StatusMethod As StatusEvent

    Public Sub OnStroke(ByVal From As Point, ByVal Till As Point)
        DrawLineMethod(From, Till)
    End Sub

    Public Sub OnStatus(ByVal msg As String)
        StatusMethod("Calling Back : " & msg)
    End Sub

    Public Sub New(ByVal DrSub As StrokeEvent)
        DrawLineMethod = DrSub
    End Sub

    Public Sub New(ByVal StSub As StatusEvent)
        StatusMethod = StSub
    End Sub

    Public Sub New(ByVal DrSub As StrokeEvent, ByVal StSub As StatusEvent)
        DrawLineMethod = DrSub
        StatusMethod = StSub
    End Sub

End Class

