function emailcheck(str) {
var at="@"
var dot="."
var lat=str.indexOf(at)
var lstr=str.length
var ldot=str.indexOf(dot)
if (str.indexOf(at)==-1){
alert("The eMail address '@' convention appears to be invalid.")
return false
}
if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
alert("The eMail address '@' convention appears to be invalid.")
return false
}
if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
alert("The eMail address 'dot' convention appears to be invalid.")
return false
}
if (str.indexOf(at,(lat+1))!=-1){
alert("The eMail address '@' convention appears to be invalid.")
return false
}
if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
alert("The eMail address 'dot' convention appears to be invalid.")
return false
}
if (str.indexOf(dot,(lat+2))==-1){
alert("The eMail address 'dot' convention appears to be invalid.")
return false
}
if (str.indexOf(" ")!=-1){
alert("The eMail address spacing convention appears to be invalid.")
return false
}
return true 
  }
  
function validate()
{
	var emailID=document.userform.email;
    if (document.userform.FirstName.value == "")
    {
        alert ( "Please enter first name." );
		document.userform.FirstName.focus();
        return false;
    }
	 if (document.userform.LastName.value == "")
    {
        alert ( "Please enter last name." );
		document.userform.LastName.focus();
        return false;
    }
    if(documnet.userfrom.EmailId.value=="")
    {
    	alert("Please enter the email Id");
    	document.userform.EmailId.focus();
    	return false;
    }
    if(documnet.userform.MobileNo.value=="")
    {
    	alert("Please enter the mobile number");
    	documnet.userform.MobileNo.focus();
    	return false;
    }
    if(document.userform.Education.value=="")
    {
    	alert("Please enter the Education details");
    	document.userform.Education.focus();
    	return false;
    }
	 if (document.userform.UserName.value == "")
    {
        alert ( "Please enter User Name." );
		document.userform.UserName.focus();
        return false;
    }
	 if (document.userform.Password.value == "")
    {
        alert ( "Please enter Password." );
		document.userform.Password.focus();
        return false;
    }
	 if (document.userform.ConfirmPassword.value == "")
    {
        alert ( "Please enter confirm password." );
		document.userform.ConfirmPassword.focus();
        return false;
    }

	if (document.userform.ConfirmPassword.value != document.userform.Password.value)
    {
        alert ( "Confirm password must be same." );
		document.userform.ConfirmPassword.focus();
        return false;
    }
      if (emailcheck(EmailId.value)==false){
	  EmailId.value=""
	 EmailId.focus()
	  return false
	  }

	 
	return true;
}


function validLogin()
{

    if (document.loginform.userName.value == "")
    {
        alert ( "Please enter Login Name." );
		document.loginform.userName.focus();
        return false;
    }
	 if (document.loginform.password.value == "")
    {
        alert ( "Please enter password." );
		document.userform.password.focus();
        return false;
    }
	return true;
}

function passValid()
{

 
   if (document.changepassform.oldpassword.value == "")
    {
        alert ( "Please enter Old password." );
		document.changepassform.oldpassword.focus();
        return false;
    }
	if (document.changepassform.newpassword.value == "")
    {
        alert ( "Please enter new password." );
		document.changepassform.newpassword.focus();
        return false;
    }

	 if (document.changepassform.cpassword.value == "")
    {
        alert ( "Please enter confirm password." );
		document.changepassform.cpassword.focus();
        return false;
    }

	if (document.changepassform.cpassword.value != document.changepassform.newpassword.value)
    {
        alert ( "Confirm password must be same." );
		document.changepassform.cpassword.focus();
        return false;
    }
	return true;

}
