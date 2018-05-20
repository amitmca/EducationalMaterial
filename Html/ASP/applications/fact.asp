<%
n=Request.Form("n")
dim f
dim i
f=1
for i=1 to n
	f=f*i
Next
Response.Write("<br>Factorial is : "& "&nbsp;" &f)

if n mod 2 =0 then
	Response.Write("<br>Even")
else 
	Response.Write("<br>Odd")	
End if
%>