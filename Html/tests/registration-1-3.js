
// define messages related to fields over here
var aMessages = new Array();

aMessages["login"] = new Array();
aMessages["login"]["blank"] = "Profile ID is mandatory.";
aMessages["login"]["^0-9a-z_"] = "Incorrect format for Profile ID. Please use only alphabets and numerals (0-9, a-z, A-Z, ‘_’). Example Rajdoctor_28";
aMessages["login"]["length < 4"] = "Your profile ID should be between 4 to 20 characters (0-9, a-z, A-Z, ‘_’).<br> Example Rajdoctor_28";
aMessages["login"]["length > 20"] = "Your profile ID should be between 4 to 20 characters (0-9, a-z, A-Z).Example Rajdoctor28.";
aMessages["login"]["_$"] = "Please do not end your Profile ID with an '_'";
aMessages["login"]["^_"] = "Please do not begin your Profile ID with an '_'";
aMessages["login"]["login email@ same"] = "Your Profile ID & Email username (text before the @ sign) cannot be the same, for security reasons.";
aMessages["login"]["login email same"] = "Your Profile ID & Email Address cannot be the same, for security reasons.";
aMessages["login"]["check if available"] = "Checking if Profile ID is available...";
aMessages["login"]["check if available error"] = "A technical error occurred while processing your Profile ID request. Please type your Profile ID again.";
aMessages["login"]["numerics > 4"] = "Please do not use more than 4 numeric characters.";
aMessages["email"] = new Array();
aMessages["email"]["blank"] = "Your email address is mandatory.";
aMessages["email"]["invalid"] = "Incorrect email address format. Please type a valid email address. Example raj_23@yahoo.com";
aMessages["email"]["@shaadi.com"] = "Incorrect Email Address. This Email Address does not exist. Please use your correct email address.";
aMessages["email"]["login email@ same"] = "Your Profile ID & Email username (text before the @ sign) cannot be the same, for security reasons.";
aMessages["email"]["login email same"] = "Your Profile ID & Email Address cannot be the same, for security reasons.";
aMessages["email"]["check if available"] = "Checking if Email Address already exists...";
aMessages["email"]["check if available error"] = "A technical error occurred while checking if this email address exists. Please type your email address again.";

aMessages["retypeemail"] = new Array();
aMessages["retypeemail"]["blank"] = "Confirm your email address again to make sure you have entered it correctly.";
aMessages["retypeemail"]["mismatch"] = "Your email addresses do not match. Please type identical email addresses in both fields.";

aMessages["password1"] = new Array();
aMessages["password1"]["blank"] = "Password is mandatory.";
aMessages["password1"]["\s"] = "Incorrect password format. Please do not use spaces in your password.";
aMessages["password1"]["\."] = "Incorrect password format. Please do not use .(dot)  in your password.";
aMessages["password1"]["length < 4"] = "Your password should be between 4 to 20 characters. It cannot contain spaces.";
aMessages["password1"]["length > 20"] = "Your password should be between 4 to 20 characters. It cannot contain spaces.";
aMessages["password1"]["login password same"] = "In order to protect your privacy your profile ID & password cannot be identical. Please change your profile ID or your password.";
aMessages["password1"]["email password same"] = "In order to protect your privacy your email address & password cannot be identical Please change your email address or your password.";

aMessages["password2"] = new Array();
aMessages["password2"]["blank"] = "Please type your Password again.";
aMessages["password2"]["mismatch"] = "Both the Passwords you typed do not match. Please use identical Passwords in both the form fields.";

aMessages["gender"] = new Array();
aMessages["gender"]["blank"] = "Gender is mandatory.";

aMessages["dateofbirth"] = new Array();
aMessages["dateofbirth"]["blank"] = "Date of birth is mandatory.";
aMessages["dateofbirth"]["day"] = "Date is mandatory.";
aMessages["dateofbirth"]["month"] = "Month is mandatory.";
aMessages["dateofbirth"]["year"] = "Year is mandatory.";
aMessages["dateofbirth"]["Invalid"] = "Incorrect Date of Birth. Please select the correct Date of Birth of the person looking to get married.";
//aMessages["dateofbirth"]["check if valid"] = "Checking if Date of Birth is valid...";
aMessages["dateofbirth"]["check if valid"] = "";
aMessages["dateofbirth"]["check if valid error"] = "A technical error occurred while checking the Date of Birth. Please select the Date of Birth again.";

aMessages["community"] = new Array();
aMessages["community"]["blank"] = "Religion / community is mandatory.";

aMessages["countryofresidence"] = new Array();
aMessages["countryofresidence"]["blank"] = "Country of residence is mandatory.";



// validated ajax values
sLoginValidatedVal = "";
sEmailValidatedVal = "";
sDateOfBirthValidatedVal = "";


// To trim the string in JS..
// create the prototype on the String object
String.prototype.trim = function()
{
	// skip leading and trailing whitespace
	// and return everything in between
	var x=this;
	x=x.replace(/^\s*(.*)/, "$1");
	x=x.replace(/(.*?)\s*$/, "$1");
	return x;
}


// same function is in registration2-2.js
function toggleHint(sMode, sElementName)
{
	sDisplay = (sMode == "show") ? "inline" : "none";

	if(oElement = eval(document.getElementById('hint_' + sElementName)))
	{
		oElement.style.display = sDisplay;
	}
}

// same function is in registration2-2.js
function toggleHint_new (sMode, sElementName, sElement, sWidth)
{
	sLeftPos = 0;
	while(sElement)
	{
		sLeftPos += sElement.offsetLeft;
		sElement = sElement.offsetParent;
	}
	//alert(sLeftPos);
	//alert(sWidth);
	sLeftPos = sLeftPos + sWidth + 25 + "px";
	sDisplay = (sMode == "show") ? "inline" : "none";

	if(oElement = eval(document.getElementById('hint_' + sElementName)))
	{
		oElement.style.left = sLeftPos;
		oElement.style.display = sDisplay;
	}
}

function validate_login()
{	
	var oField = document.forms["frm_registration"].login;
	var oFieldEmail = document.forms["frm_registration"].email;
	var oElement = document.getElementById('errmsg_login');
	
	oField.value = oField.value.trim();
	aEmailValBeforeAtSign = oFieldEmail.value.split("@");
	toggleHint('hide', 'login');
	oElement.innerHTML = "";
	oField.className = "field_filled";

	oRegX = new RegExp(/^[0-9a-z_]+$/gi);

	if(oField.value == "")
	{
		oElement.innerHTML = aMessages["login"]["blank"];
		oField.className = "field_err";
	}
	else if(oField.value.length < 4)
	{
		oElement.innerHTML = aMessages["login"]["length < 4"];
		oField.className = "field_err";
	}
	else if(oField.value.length > 20)
	{
		oElement.innerHTML = aMessages["login"]["length > 20"];
		oField.className = "field_err";
	}
		else if(/_$/.test(oField.value))
	{
		oElement.innerHTML = aMessages["login"]["_$"];
		oField.className = "field_err";
	}
	else if(/^_/.test(oField.value))
	{
		oElement.innerHTML = aMessages["login"]["^_"];
		oField.className = "field_err";
	}
	else if(!oRegX.test(oField.value))
	{
		oElement.innerHTML = aMessages["login"]["^0-9a-z_"];
		oField.className = "field_err";
	}
	else if(oFieldEmail.value.toLowerCase() == oField.value.toLowerCase())
	{
		oElement.innerHTML = aMessages["login"]["login email same"];
		oField.className = "field_err";
	}
	else if(oField.value.toLowerCase() == aEmailValBeforeAtSign[0].toLowerCase())
	{
		oElement.innerHTML = aMessages["login"]["login email@ same"];
		oField.className = "field_err";
	}
	else if(getNoOfNumerics(oField.value) > 4)
	{
		oElement.innerHTML = aMessages["login"]["numerics > 4"];
		oField.className = "field_err";
	}
	else
	{
		sUrl = "/ssi/ajax/registration.php?mode=is_login_available&login=" + escape(oField.value);
		sendRequestAndGetResponse(sUrl, oElement, aMessages["login"]["check if available"], aMessages["login"]["check if available error"]);
	}
	

} // EO validate_login()



function getNoOfNumerics(sStr)
{
	var iNumericCharsCount = 0;

	for(i=0; i< sStr.length; i++)
	{
		if(!isNaN(sStr.charAt(i)))
		{
			iNumericCharsCount++;
		}
	}

	return iNumericCharsCount;
}


function uncheck(obj)
{
	if(eval(obj))
	{
		for(var i=0; i<obj.length; i++)
		{
			obj[i].checked=false;
		}
	}
}


function fix_email(sVal)
{
	sVal = sVal.replace(/@_/i, "@");
	sVal = sVal.replace(/\s@\s|\s@|@\s/i, "@");
	sVal = sVal.replace(/_\._|_\.|\._/i, ".");
	sVal = sVal.replace(/\s\.\s|\s\.|\.\s/i, ".");
	sVal = sVal.replace(/,/gi, ".");

	return sVal;
}


function validate_email()
{
	var oField = document.forms["frm_registration"].email;
	var oFieldLogin = document.forms["frm_registration"].login;
	var oFieldGo = document.forms["frm_registration"].go;
	var oElement = document.getElementById('errmsg_email');

	toggleHint('hide', 'email');
	oField.value = fix_email(oField.value.trim());
	aEmailValBeforeAtSign = oField.value.split("@");
	oElement.innerHTML = "";
	oField.className = "field_filled";


	oRegX = new RegExp(/^[\w_-]+(\.[\w_-]+)*@[\w_-]+(\.[\w_-]+)*\.\w{2,4}$/gi);

	if(oField.value == "")
	{
		oElement.innerHTML = aMessages["email"]["blank"];
		oField.className = "field_err";
	}
	else if(/@shaadi.com/gi.test(oField.value))
	{
		oElement.innerHTML = aMessages["email"]["@shaadi.com"].replace(/<!--EMAIL-->/, oField.value);
		oField.className = "field_err";
	}
	else if(oFieldLogin.value.toLowerCase() == oField.value.toLowerCase())
	{
		oElement.innerHTML = aMessages["email"]["login email same"];
		oField.className = "field_err";
	}
	else if(oFieldLogin.value.toLowerCase() == aEmailValBeforeAtSign[0].toLowerCase())
	{
		oElement.innerHTML = aMessages["email"]["login email@ same"];
		oField.className = "field_err";
	}
	else if(!oRegX.test(oField.value))
	{
		oElement.innerHTML = aMessages["email"]["invalid"];
		oField.className = "field_err";
	}
	else
	{
		sParams = "&login=" + oFieldLogin.value + "&go=" + oFieldGo.value;
		sUrl = "/ssi/ajax/registration.php?mode=is_email_available&email=" + escape(oField.value) + sParams;
		sendRequestAndGetResponse(sUrl, oElement, aMessages["email"]["check if available"], aMessages["email"]["check if available error"]);

	}

} // EO validate_email()



function validate_retypeemail()
{	
	var oField = document.forms["frm_registration"].retypeemail;
	var oFieldEmail = document.forms["frm_registration"].email;
	var oElement = document.getElementById('errmsg_retypeemail');

	toggleHint('hide', 'retypeemail');
	oField.value = fix_email(oField.value.trim());
	oElement.innerHTML = "";
	oField.className = "field_filled";

	if(oField.value == "")
	{
		oElement.innerHTML = aMessages["retypeemail"]["blank"];
		oField.className = "field_err";
	}
	else if(oFieldEmail.value.toLowerCase() != oField.value.toLowerCase())
	{
		oElement.innerHTML = aMessages["retypeemail"]["mismatch"];
		oField.className = "field_err";
	}

} // EO validate_retypeemail()



function validate_password1()
{	
	var oField = document.forms["frm_registration"].password1;
	var oFieldLogin = document.forms["frm_registration"].login;
	var oFieldEmail = document.forms["frm_registration"].email;
	var oElement = document.getElementById('errmsg_password1');

	toggleHint('hide', 'password1');
	oField.value = oField.value.trim();
	oElement.innerHTML = "";
	oField.className = "field_filled";

	if(oField.value == "")
	{
		oElement.innerHTML = aMessages["password1"]["blank"];
		oField.className = "field_err";
	}
	else if(/\s/.test(oField.value))
	{
		oElement.innerHTML = aMessages["password1"]["\s"];
		oField.className = "field_err";
	}
	else if(/\./.test(oField.value))
	{
		oElement.innerHTML = aMessages["password1"]["\."];
		oField.className = "field_err";
	}
	else if(oField.value.length < 4)
	{
		oElement.innerHTML = aMessages["password1"]["length < 4"];
		oField.className = "field_err";
	}
	else if(oField.value.length > 20)
	{
		oElement.innerHTML = aMessages["password1"]["length > 20"];
		oField.className = "field_err";
	}
	else if(oFieldLogin.value.toLowerCase() == oField.value.toLowerCase())
	{
		oElement.innerHTML = aMessages["password1"]["login password same"];
		oField.className = "field_err";
	}
	else if(oFieldEmail.value.toLowerCase() == oField.value.toLowerCase())
	{
		oElement.innerHTML = aMessages["password1"]["email password same"];
		oField.className = "field_err";
	}

} // EO validate_password1()



function validate_password2()
{
	var oField = document.forms["frm_registration"].password2;
	var oElement = document.getElementById('errmsg_password2');

	toggleHint('hide', 'password2');
	oField.value = oField.value.trim();
	oElement.innerHTML = "";
	oField.className = "field_filled";

	if(oField.value == "")
	{
		oElement.innerHTML = aMessages["password2"]["blank"];
		oField.className = "field_err";
	}
	else if(document.forms["frm_registration"].password1.value.toLowerCase() != oField.value.toLowerCase())
	{
		oElement.innerHTML = aMessages["password2"]["mismatch"];
		oField.className = "field_err";
	}

} // EO validate_password2()



function validate_gender()
{
	var oField = document.forms["frm_registration"].gender;
	var oElement = document.getElementById('errmsg_gender');

	toggleHint('hide', 'gender');
	oElement.innerHTML = "";
	oField.className = "field_filled";

	if(oField[0].checked == false
	&& oField[1].checked == false)
	{
		oElement.innerHTML = aMessages["gender"]["blank"];
	}

} // EO validate_gender()



function validate_dateofbirth(sFieldName)
{
	var oFieldDay = document.forms["frm_registration"].day;
	var oFieldMonth = document.forms["frm_registration"].month;
	var oFieldYear = document.forms["frm_registration"].year;
	var oElement = document.getElementById('errmsg_dateofbirth');

	toggleHint('hide', 'dateofbirth');

	iDay = oFieldDay.options[oFieldDay.selectedIndex].value;
	iMonth = oFieldMonth.options[oFieldMonth.selectedIndex].value;
	iYear = oFieldYear.options[oFieldYear.selectedIndex].value;

	iDateOfBirth = iDay + iMonth + iYear;

	//alert(sFieldName + "\nday" + iDay + "\nmonth" + iMonth + "\nyear" + iYear + "\n");

	oFieldDay.className = (iDay == "") ? "field_dob_err" : "field_dob_filled";
	oFieldMonth.className = (iMonth == "") ? "field_dob_err" : "field_dob_filled";
	oFieldYear.className = (iYear == "") ? "field_dob_err" : "field_dob_filled";

	if(iDay == "" && iMonth == "" && iYear == "")
	{
		oElement.innerHTML = aMessages["dateofbirth"]["blank"];
	}
	else if(iDay == "")
	{
		oElement.innerHTML = aMessages["dateofbirth"]["day"];
	}
	else if(iMonth == "")
	{
		oElement.innerHTML = aMessages["dateofbirth"]["month"];
	}
	else if(iYear == "")
	{
		oElement.innerHTML = aMessages["dateofbirth"]["year"];
	}
	else if(iDay != "" && iMonth != "" && iYear != "")
	{
		sParams = "&day=" + iDay + "&month=" + iMonth + "&year=" + iYear;
		sUrl = "/ssi/ajax/registration.php?mode=is_dateofbirth_valid" + sParams;
		sendRequestAndGetResponse(sUrl, oElement, aMessages["dateofbirth"]["check if valid"], aMessages["dateofbirth"]["check if valid error"]);
	}
	else
	{
		oElement.innerHTML = "";
	}
} // EO validate_dateofbirth()




function validate_community()
{
	
	var oField = document.forms["frm_registration"].community;
	var oElement = document.getElementById('errmsg_community');
	oElement.innerHTML = "";
	oField.className = "field_filled";

	if(oField.options[oField.selectedIndex].value == "")
	{
		oElement.innerHTML = aMessages["community"]["blank"];
		oField.className = "field_rel_err";
	}

} // EO validate_community()



function validate_countryofresidence()
{
	var oField = document.forms["frm_registration"].countryofresidence;
	var oElement = document.getElementById('errmsg_countryofresidence');
	oElement.innerHTML = "";
	oField.className = "field_filled";

	if(oField.options[oField.selectedIndex].value == "")
	{
		oElement.innerHTML = aMessages["countryofresidence"]["blank"];
		oField.className = "field_rel_err";
	}

} // EO validate_gender()



