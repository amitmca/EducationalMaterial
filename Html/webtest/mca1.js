
/*************  2/2/2009 FUNCTION TO PRINT HALL TICKET AND PRINTABLE FORM EXCLUDING HEADER,LEFT AND FOOTER  
				DONT ALTER THIS FUNCTION *****/
function printpage() 
	{
		window.print();
	}

	function Printit()
    {
		document.getElementById("trHead").style.display = "none";
        document.getElementById("tdLeft").style.display = "none";
        document.getElementById("WHeader").style.display = "none";
        document.getElementById("Footer").style.display = "none";

        document.getElementById("tblPrint").style.display = "none";
		//document.getElementById("tblproc").style.display = "none";
	
		document.getElementById("logo-graphic").style.display = "none";
		document.getElementById("header").style.display = "none";
		document.getElementById("footer").style.display = "none";

		document.getElementById("mbar").style.display = "none";
		document.getElementById("Note").style.display = "none";
		document.getElementById("nav").style.display = "none";
		///document.getElementById("nava").style.display = "none";
		//document.getElementById("welcome").style.display = "none";
		document.getElementById("lft").style.display = "none";
		 

		printpage();
         
        document.getElementById("trHead").style.display = "block";
        document.getElementById("tdLeft").style.display = "block";
        document.getElementById("WHeader").style.display = "block";
        document.getElementById("Footer").style.display = "block";
        document.getElementById("tblPrint").style.display = "block";
		//document.getElementById("tblproc").style.display = "block";

		document.getElementById("logo-graphic").style.display = "block";
		document.getElementById("header").style.display = "block";
		document.getElementById("footer").style.display = "block";

		document.getElementById("mbar").style.display = "block";
		document.getElementById("Note").style.display = "block";
		document.getElementById("nav").style.display = "block";
		//document.getElementById("nava").style.display = "block";
		//document.getElementById("welcome").style.display = "block";
		document.getElementById("lft").style.display = "block";
	}

function Printit1()
    {
		document.getElementById("trHead").style.display = "none";
        document.getElementById("tdLeft").style.display = "none";
        document.getElementById("WHeader").style.display = "none";
        document.getElementById("Footer").style.display = "none";

        document.getElementById("btnPrint").style.display = "none";
		//document.getElementById("tblproc").style.display = "none";
	
		document.getElementById("logo-graphic").style.display = "none";
		document.getElementById("header").style.display = "none";
		document.getElementById("footer").style.display = "none";

		document.getElementById("mbar").style.display = "none";
		document.getElementById("Note").style.display = "none";
		document.getElementById("nav").style.display = "none";
		///document.getElementById("nava").style.display = "none";
		//document.getElementById("welcome").style.display = "none";
		document.getElementById("lft").style.display = "none";
		 

		window.print();

         
        document.getElementById("trHead").style.display = "block";
        document.getElementById("tdLeft").style.display = "block";
        document.getElementById("WHeader").style.display = "block";
        document.getElementById("Footer").style.display = "block";
        
		document.getElementById("btnPrint").style.display = "block";
		//document.getElementById("tblproc").style.display = "block";

		document.getElementById("logo-graphic").style.display = "block";
		document.getElementById("header").style.display = "block";
		document.getElementById("footer").style.display = "block";

		document.getElementById("mbar").style.display = "block";
		document.getElementById("Note").style.display = "block";
		document.getElementById("nav").style.display = "block";
		//document.getElementById("nava").style.display = "block";
		//document.getElementById("welcome").style.display = "block";
		document.getElementById("lft").style.display = "block";
	}

function Printitouter()
    {
		 
		document.getElementById("trHead").style.display = "none";
		document.getElementById("Footer").style.display = "none";
		document.getElementById("logo-graphic").style.display = "block";
		document.getElementById("header").style.display = "block";
		document.getElementById("footer").style.display = "block";
		document.getElementById("mbar").style.display = "none";
        document.getElementById("lft").style.display = "none";
		document.getElementById("nav").style.display = "none";
        window.print();
		
		document.getElementById("trHead").style.display = "block";
		document.getElementById("Footer").style.display = "block";
		document.getElementById("logo-graphic").style.display = "none";
		document.getElementById("header").style.display = "none";
		document.getElementById("footer").style.display = "none";
		document.getElementById("mbar").style.display = "block";
		 
		document.getElementById("nav").style.display = "block";
        document.getElementById("lft").style.display = "block";
        
		
	}


/*************** Application ID Validate     **********/
function validateappid()
	{
		if(document.ht.txt_regNo.value == "MC09" || document.ht.txt_regNo.value == "")
		{
			alert("Please enter Application ID");
			document.ht.txt_regNo.focus();
			return false;
		}
	}


function appidval()
	{
		//alert("aa");
		if(document.login.username.value == "MC09" || document.login.username.value == "")
		{
			alert("Please enter Application ID");
			document.login.username.focus();
			return false;
		}
		
		if(document.login.password.value == '' || document.login.password.value == null)
		{
			alert("Please enter Password");
			document.login.password.focus();
			return false;
		}
	}

/**********   CET CENTER CONTROL IN ADMIN ***************/
function valid()
{
	if(document.viewtype.cetcenters.value =='')
	{
		alert("Please Select Cet Center City.");
		return false;
	}
	
	if(document.viewtype.cetvenue.value =='')
	{
		alert("Please Select Cet Center Venue.");
		return false;
	}

	return true
}


function CheckCapacity()
{
	//alert(document.cet.current.value);
	//alert(document.cet.maxcap.value);
	if(document.cet.maxcap.value < document.cet.current.value)
	{
		alert("Maximum Capacity should not be less than Current Capacity.");
		return false;
	}
	
	return true
}

function moveUpList()
{
	var listField = document.getElementById("cmbOptionsSelected");
	if ( listField.length == -1) 
	{
		alert("There are no values which can be moved!");
	}
	else
	{
		var selected = listField.selectedIndex;
		if (selected == -1)
		{
			alert("You must select an entry to be moved!");
		} 
		else 
		{  
			if ( listField.length == 0 )
			{ 
				alert("There is only one entry!\nThe one entry will remain in place.");
			}
		    else
		    {  
				if ( selected == 0 ) 
		        {
					alert("The first entry in the list cannot be moved up.");
				}
		        else 
		        {
					// Get the text/value of the one directly above the hightlighted entry as
		            // well as the highlighted entry; then flip them
		            var moveText1 = listField[selected-1].text;
		            var moveText2 = listField[selected].text;
		            var moveValue1 = listField[selected-1].value;
		            var moveValue2 = listField[selected].value;
		            listField[selected].text = moveText1;
		            listField[selected].value = moveValue1;
		            listField[selected-1].text = moveText2;
		            listField[selected-1].value = moveValue2;
		            listField.selectedIndex = selected-1; // Select the one that was selected before
				}  // Ends the check for selecting one which can be moved
			}  // Ends the check for there only being one in the list to begin with
		}  // Ends the check for there being something selected
	}  // Ends the check for there being none in the list
}

function validateaa()
{
	if(document.cet.cmbOptionsSelected.length<1)
	{
		alert("Please Select at least one Cetcenter");
		document.cet.cmbOptionsSelected.focus();
		return false;
	}
	var list;
	list="";
	for(i=0;i< document.cet.cmbOptionsSelected.length; i++)
	{
		list=list+","+document.cet.cmbOptionsSelected.options[i].value;
	}
	document.cet.colleges.value=list;
return true;
} 

function moveDownList() 
{
	var listField = document.getElementById("cmbOptionsSelected");
	if ( listField.length == -1) 
	{  
		alert("There are no values which can be moved!");
	} 
	else
	{
		var selected = listField.selectedIndex;
		if (selected == -1)
		{
			alert("You must select an entry to be moved!");
		} 
		else 
		{  
			if ( listField.length == 0 ) 
		    {  
				alert("There is only one entry!\nThe one entry will remain in place.");
			} 
		    else 
		    { 
				if ( selected == listField.length-1 ) 
		        {
					alert("The last entry in the list cannot be moved down.");
				} 
		        else 
		        {
					// Get the text/value of the one directly below the hightlighted entry as
		            // well as the highlighted entry; then flip them
		            var moveText1 = listField[selected+1].text;
		            var moveText2 = listField[selected].text;
		            var moveValue1 = listField[selected+1].value;
		            var moveValue2 = listField[selected].value;
		            listField[selected].text = moveText1;
		            listField[selected].value = moveValue1;
		            listField[selected+1].text = moveText2;
		            listField[selected+1].value = moveValue2;
		            listField.selectedIndex = selected+1; // Select the one that was selected before
				}  // Ends the check for selecting one which can be moved
			}  // Ends the check for there only being one in the list to begin with
		}  // Ends the check for there being something selected
	}  // Ends the check for there being none in the list
}

/**********   CET CENTER CONTROL IN ADMIN ENDS ***************/


function toggleDiv(id,flagit){
	if (flagit=="1"){
		if (document.layers) document.layers[''+id+''].visibility = "show"
		else if (document.all) document.all[''+id+''].style.visibility = "visible"
		else if (document.getElementById) document.getElementById(''+id+'').style.visibility = "visible"
	}
	else{
		if (flagit=="0"){
			if (document.layers) document.layers[''+id+''].visibility = "hide"
			else if (document.all) document.all[''+id+''].style.visibility = "hidden"
			else if (document.getElementById) document.getElementById(''+id+'').style.visibility = "hidden"
		}
	}
}


function get_homeuniv() 
{
	var str = document.cate.seldist.value.substr(3,2);
	
	if(str ==1)
	{
		var univ_name = "Dr. Babasaheb Ambedkar Marathwada University";
	}
	else if(str ==2)
	{
		var univ_name = "Swami Ramanand Teerth Marathwada University";
	}
	else if(str ==3)
	{
		var univ_name = "Rashtrasant Tukdoji Maharaj Nagpur University";
	}
	else if(str ==4)
	{
		var univ_name = "Pune University";
	}
	else if(str ==5)
	{
		var univ_name = "North Maharashtra University";
	}
	else if(str ==6)
	{
		var univ_name = "Mumbai University";
	}
	else if(str ==7)
	{
		var univ_name = "Sant Gadgebaba Amravati University";
	}
	else if(str ==8)
	{
		var univ_name = "Shivaji University+Solapur University";
	}
	alert (univ_name);

	return univ_name;
 }



function validateFaqsForm()
	{
	
	if (document.faqForm.Candidate.value == "")
		{
		alert ("Please Select  the Candidat type.");
		document.faqForm.Candidate.focus();
		return false;
		}
		
	return true;
	}

function conpsw()
{
	if(document.loginForm.txt_pswcon.value.length < 5 || document.loginForm.txt_pswcon.value.length >15)  {
		alert ("Please Enter the password of length 5-15 characters.");
		document.loginForm.txt_pwd.value="";
		document.loginForm.txt_pswcon.value="";
		document.loginForm.txt_pwd.focus();
		return false;
	}
	
	if(document.loginForm.txt_pswcon.value==document.loginForm.txt_pwd.value)
	{
		//alert("Password Matched");
	}
	else
	{
		alert("Please Re-enter Password ");
		document.loginForm.txt_pswcon.value="";
		document.loginForm.txt_pwd.focus();
		return false;
	}
}

 function processForm() {
	if (document.loginForm.opass.value == "")
	{
		alert ("Please Enter the old Password");
		document.loginForm.opass.focus();
		return false;
	}

	if (document.loginForm.txt_pwd.value == "")
	{
		alert ("Please Enter the password.");
		document.loginForm.txt_pwd.focus();
		return false;
	}
	
	if (document.loginForm.txt_pswcon.value == "")
	{
		alert ("Please confirm Password.");
		document.loginForm.txt_pswcon.focus();
		return false;
	}//end of if
	
	return true;
 }


function secque() 
{
	if(isEmptySelect(document.secureques.cmbsec))
			return false;
	
	if(isEmpty(document.secureques.answer))
		    return false;

	return true;
 }

function valcngcandpwd()
{
	if(document.cngcandpwd.appid.value == "MC09" && document.cngcandpwd.user.value == "")
	{
		alert("Please enter the valid Application ID");
			return false;
	}
	else if(document.cngcandpwd.user.value == "arc" && document.cngcandpwd.appid.value == "ARC")
	{
		alert("Please enter the valid Arc Code");
			return false;
	}
	if(document.cngcandpwd.txt_pwd.value == "")
	{
		alert("Please enter the New Password");
			return false;
	}
	if(document.cngcandpwd.txt_pswcon.value == "")
	{
		alert("Please enter the Confirm Password");
			return false;
	}
	if(document.cngcandpwd.txt_pswcon.value != document.cngcandpwd.txt_pwd.value)
	{
		alert("New Password and Confirm Password must be same");
			return false;
	}
	return true;
}

//FOR CANDIDATE MSG SYSTEM

function selsubjectClick()
	{
	document.getElementById('UP').style.display = 'none';
	if(document.getElementById("candtype").checked)
		{
		document.composemsg.subject.value = "Change in Candidate Type";	
		}
	else if(document.getElementById("category").checked)
		{
		document.composemsg.subject.value = "Change in Category Details";
		}
	else if(document.getElementById("Receipt_Details").checked)
		{
		document.composemsg.subject.value = "Change in Receipt Details";
		}
	else if(document.getElementById("Personal_Details").checked)
		{
		document.composemsg.subject.value = "Change in Personal Details";
		}
	else if(document.getElementById("Qualification_Details").checked)
		{
		document.composemsg.subject.value = "Change in Qualification Details";
		}
	else if(document.getElementById("Photo").checked)
		{
		document.composemsg.subject.value = "Change Uploaded Photo with Signature";
		document.getElementById('UP').style.display = 'inline';
		}
	else if(document.getElementById("Hall_Ticket").checked)
		{
		document.composemsg.subject.value = "Problem in Print Hall Ticket";
		}
	else if(document.getElementById("Miscellaneous").checked)
		{
		document.composemsg.subject.value = "Miscellaneous";
		}
	else
		{
		document.composemsg.subject.value = "";
		}
	}

/*function selcompose()
	{
	if(document.composemsg.subject.value == null);
		{
		alert("Please select the appropriate Subject");
		return false;
		}
	if(document.composemsg.putmsg.value == "")
		{
		alert("Please enter the details of the message");
		return false;
		}
	return true;
	//if(document.composemsg.prb)
	}*/


//this is for after check box selection name are pasted in the given text area.
function showlist(yes)
{
	if(yes.value == 'Y')
		document.getElementById('list').style.display = 'inline';
	else
		document.getElementById('list').style.display = 'none';
}
function Doit() 
{ 
	myval="" 
	re=/,$/ // Use regular expression to remove comma from last value added to text box 
	for(i=0;i<myform.ckb.length;i++) 
	{ 
		if(myform.ckb[i].checked) 
		{
			myval+=myform.ckb[i].value+","
		} 
	} 
	myform.txt1.value=myval.replace(re,"") 
} 


function setParentValue() 
{
	//if (this.document.myform.txt1.value != null &&
	//this.document.myform.txt1.value != "") {
	window.opener.document.forms[0].myTextBox.value +=
	this.document.myform.txt1.value;
	this.close();
	//}
}


function checkAll(field)
{
	var obj=document.all.ckb
	for (i = 0; i < obj.length; i++)
		obj.ckb[i].checked = true ;
}

function uncheckAll(field)
{
	var obj=document.all.ckb
	for (i = 0; i < obj.length; i++)
	obj.ckb[i].checked = false ;
}


function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}


function validateaddUserForm()
	{
	if(isEmpty(document.useraddForm.fullname))
   	   return false;
	if(isEmpty(document.useraddForm.address))
	   return false;
    if(ValidPincode(document.useraddForm.pincode))   
	   return false; 
    if(isEmpty(document.useraddForm.city))
	   return false;
    
	if(isEmpty(document.useraddForm.role))
	  return false; 
   
     if(isEmpty(document.useraddForm.username))
	  return false; 

	
	if(isEmpty(document.useraddForm.password))
      return false;

	if((document.useraddForm.password.value.length < 1)) //MAKE < 5 AFTER PASSWORD INSERT
		{
		alert("Password Must Be Minimum Six Character Long1");
		return false;
		} 
	if(!validatePwd(document.useraddForm.password))
		return false;
		
	if(isEmpty(document.useraddForm.cpassword))
      return false;  
	if((document.useraddForm.password.value != document.useraddForm.cpassword.value))
		{alert (document.useraddForm.password.value + document.useraddForm.cpassword.value);
		alert("Confirm Password Must Be Same As Password");
		return false;
		}
var agree=confirm("Click Ok, if you are sure that information filled by you is correct. \n\tPlease remember your Password\n\t Note down Please Check that Email Id Provided by you is Correct and Valid.");
  if (!agree)
	{
	document.useraddForm.txtPwd.value = "";
	document.useraddForm.txtPwdcon.value="";
	document.useraddForm.txtAnsw.value = "";
	document.useraddForm.txtPwd.focus();
	return false;
	}  
	return true;
	}


//end