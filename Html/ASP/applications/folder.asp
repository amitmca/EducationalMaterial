<%
Dim fs,fo
Set fs=Server.CreateObject("Scripting.FileSystemObject")
Set fo=fs.GetFolder("c:\wamp")
Response.Write("Folder created: " & fo.DateCreated)
set fo=nothing
set fs=nothing
%> 
