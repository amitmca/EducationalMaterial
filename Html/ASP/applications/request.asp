
<br><b>welcome &nbsp;

<% 

fname=Request.Form("firstname") 
lname=Request.Form("lastname") 

if fname="amit" then
	response.write("Hello :"&fname)
else
	response.write("Bye :"&fname)
end if	


%>



