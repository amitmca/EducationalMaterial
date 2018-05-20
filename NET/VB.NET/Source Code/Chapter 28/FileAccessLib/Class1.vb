Imports System
Imports System.Security.Permissions
Imports System.IO

Public Class Class1

    '<StrongNameIdentityPermission(SecurityAction.LinkDemand, _
    'PublicKey:="002400000480000094000000060200000024000052" & _
    '"5341310004000001000100F31E5A4F3033EC17FDE57C93AF9BE" & _
    '"0CB00AE5D299A09D3CA2953CCC6681CC7C31E89AF30C89BB437" & _
    '"A53728D4D930F67D918FA07CBBE78F8B02AE5DC6FA8D32AFBB7" & _
    '"A18988B83337E85C5DB775350D8DA1EBE9B4C82C3C22C4D4C67" & _
    '"EB1861F77E28D3CAA46206BC2CD114B7F417E7990BB81EDF224" & _
    '"5FC610E1D976C72D63168C2"), _
    'FileIOPermissionAttribute(SecurityAction.Assert, All:="c:\file.txt")> _
Function AccessFile(ByRef FileText As String) As Boolean
        Try
            Dim fs As New System.IO.FileStream("C:\file.txt", FileMode.OpenOrCreate, _
            FileAccess.Write)

            Dim w As New StreamWriter(fs)
            w.BaseStream.Seek(0, SeekOrigin.End)
            w.WriteLine("Here is the file's text.")
            w.Write("Here is more file text." & ControlChars.CrLf)
            w.WriteLine("And that's about it.")
            w.Flush()
            w.Close()

            fs = New System.IO.FileStream("C:\file.txt", FileMode.Open, _
                FileAccess.Read)

            Dim r As New StreamReader(fs)
            r.BaseStream.Seek(0, SeekOrigin.Begin)
            FileText = ""
            While r.Peek() > -1
                FileText &= r.ReadLine() & ControlChars.CrLf
            End While
            r.Close()
            Return True
        Catch 'ex As Security.SecurityException
            Return False
        End Try
    End Function
End Class
