/********************URVESH 1/21/2009 *********************/

var mymessage="WELCOME AMIT How R U ?";
var movecontrol=0;
var mess_len=mymessage.length;
var movespeed=50;
var max_len=mess_len+mymessage.length;
window.status=mymessage;




function Printitrep()
    {
		document.getElementById("trHead").style.display = "none";
		window.print();
        document.getElementById("trHead").style.display = "block";
	}




function movemessage()
{
	var index;
	if(movecontrol>max_len)
	{
		window.status=mymessage;
		movecontrol=0;
	}                             
	if(movecontrol>=mess_len)
	{
		index=movecontrol-mess_len;
		window.status=mymessage.substring(index,mess_len);
		movecontrol++;
	}
	else
	{
		window.status=mymessage.substring(0,movecontrol);
		movecontrol++;                 
	}
	setTimeout("movemessage();",movespeed);
}

 function facselect(fac)					// FUNCTION FOR MATHS SUBJECT AND LEVEL OF MATHS
	{
	
		if(fac.value != 4 && fac.value != 6 && fac.value != 19)
			{
			document.getElementById('SUB').style.display = 'inline';
			document.getElementById('LVL').style.display = 'inline';
			}
		else
			{
			document.getElementById('SUB').style.display = 'none';
			document.getElementById('LVL').style.display = 'none';
			}

		return true;
	}


function isother(val)					// FUNCTION FOR MATHS SUBJECT AND LEVEL OF MATHS
	{
		
		document.getElementById('isothercaste').style.display = 'none';
		
		
		if(val.value < 742 && val.value > 732)
		{
			document.getElementById('isothercaste').style.display = 'inline';
		}
		else
		{
			document.cate.othersrno.value = "";
			document.cate.othercaste.value = "";
		}
		
		return true;
	}

function login()
	{

	if(document.login.password.value == "")
		{
		alert("Please enter Password");
		return false;
		}
	}


function validques()
	{

	if(document.secureques.username.value == "")
		{
		alert("Please enter Application ID");
		return false;
		}
	if(document.secureques.secureques.value == "")
		{
		alert("Please Select your security question");
		return false;
		}
	if(document.secureques.answer.value == "")
		{
		alert("Please enter you answer");
		return false;
		}
	return true;
	}
function showhomeuniv(univ)
	{
	//alert(univ.value);
	//return false;
	}

function Qual(pa,pp,pn,up,pm,um)
	{
	
	/////SSC
	if(isEmpty(document.form1.txtE3Obtained))
	   return false;  
	if(isEmpty(document.form1.txtE3OutOf))
	   return false;  
	if(validMarks1(document.form1.txtE3Obtained,document.form1.txtE3OutOf,document.form1.txtE3))   
	   return false; 
		//SSC ENDS

		//SSC MATHS
	if(isEmpty(document.form1.txtE4Obtained))
		return false;  
	if(isEmpty(document.form1.txtE4OutOf))
		return false;  
	if(validMarks1(document.form1.txtE4Obtained,document.form1.txtE4OutOf,document.form1.txtE4))   
		return false;
		//SSC MATHS ENDS
		
		//HSC
	if(isEmpty(document.form1.txtE2Obtained))
		  return false;
	if(isEmpty(document.form1.txtE2OutOf))
		  return false;  
	if(validMarks1(document.form1.txtE2Obtained,document.form1.txtE2OutOf,document.form1.txtE2))   
		  return false; 
		//HSC ENDS

	if(up == true)
		{
		if(isEmptySelect(document.form1.ugfac))
			return false;
		if(isEmpty(document.form1.txtE1Obtained))
		    return false;
		if(isEmpty(document.form1.txtE1OutOf))
		    return false;
		if(validMarks1(document.form1.txtE1Obtained,document.form1.txtE1OutOf,document.form1.txtE1))   
		    return false;
		}

	if(pa == true)
		{
		if(isEmptySelect(document.form1.pgfac))
			return false;
		
		if(up == false)
			{
			alert("You must have to select passed Under Graduation Examination as you selected Post Graduation Examination Appeared");
			return false;
			}
		}

	else if(pp == true)
		{
		if(isEmptySelect(document.form1.pgfac))
			return false;
		if(isEmpty(document.form1.pgObt))
		    return false;
		if(isEmpty(document.form1.pgOutOf))
		    return false;
		if(validMarks1(document.form1.pgObt,document.form1.pgOutOf,document.form1.txtpg))   
		    return false;

		if(up == false)
			{
			alert("You must have to select passed Under Graduation Examination as you selected Post Graduation Examination Passed");
			return false;
			}
		}

	

	if(pp == true && up == true)
		{
		//alert(document.form1.category.value);
		//return false;
		if(document.form1.category.value <= 0)
			{
			if(pm < 45 && um < 45)
				{
				alert("You are not eligible for filling the application form.Aleast one (Under Graduation or Post Graduation ) examination should have more than 45%");
				return false;
				}
			}
		else
			{
			if(pm < 40 && um < 40)
				{
				alert("You are not eligible for filling the application form.Aleast one (Under Graduation or Post Graduation ) examination should have more than 40%");
				return false;
				}
			}
		}
	
	if(pn == true && up == true)
		{
		if(document.form1.category.value <= 0)
			{
			if(um < 45)
				{
				alert("You are not eligible for filling the application form.Under Graduation examination should have more than 45%");
					return false;
				}
			}
		else
			{
			if(um < 40)
				{
				alert("You are not eligible for filling the application form.Under Graduation examination should have more than 40%");
				return false;
				}
			}
		}
	if(document.form1.ugfac.value == 0)
		{
		alert("Please select your Under Graduation Faculty");
			return false;
		}

	//-----------------------------------------//
	

	//alert(document.form1.ugfac.value);
	//return false;

	if(document.form1.ugfac.value != 6 && document.form1.ugfac.value != 19)
		{
		//alert("ok");
		if(isSelectRadio_for3(document.form1.elgMath[0],document.form1.elgMath[1],document.form1.elgMath[2]))
	      return false;
		if(document.form1.mathssub.value == "")
			{
			alert("Please Enter the Mathematics Subject Name");
			return false;
			}
		}
	
	if((document.form1.ugfac.value != 6 ||  document.form1.ugfac.value != 19 ) && document.form1.elgMath[2].checked == true)
		{
		alert("You are not eligible as you have not selected 10+2 or Higher level Mathematics or statistic condition");
		return false;
		}
	return true;
	}

function enableDisable(c,opt1,opt2,opt3)
{      
	if (c.value=='Y')
	{
	 opt1.disabled=false;
	 opt2.disabled=false;
	 opt3.disabled=false;
    }
	else 
	{
     opt1.disabled=true;
     opt2.disabled=true;
     opt3.disabled=true;

     opt1.checked=false;
     opt2.checked=false;
     opt3.checked=false;
    }
}


function elgqual(pa,pp,pn,ua,up,um,pm,cat)
	{
	if(up == true && pn == true)
		{
		if(cat == 0 && um < 45)
			{
			alert("required more than 45%");
			return false;
			}
		else if (cat != 0 && um < 40)
			{
			alert("required more than 40%");
			return false;
			}
		}
	else if (up == true && pp == true)
		{
		if(cat == 0 && um < 45 && pm < 45)
			{
			alert("required more than 45% atleast in one examination");
			return false;
			}
		else if(cat != 0 && um < 40 && pm < 40)
			{
			alert("required more than 40% atleast in one examination");
			return false;
			}
		}
		return true;
	}
function MM_showHideLayers() 
	{ //v6.0
	var i,p,v,obj,args=MM_showHideLayers.arguments;
	for (i=0; i<(args.length-2); i+=3)
		if ((obj=MM_findObj(args[i]))!=null)
		{
		v=args[i+2];
		if (obj.style)
			{
			obj=obj.style; 
			v=(v=='show')?'visible':(v=='hide')?'hidden':v;
			}
		obj.visibility=v;
		}
	}


function xfer(src,target) {
    var sc, itemText, i, newIndex, listy,j=1;
    target.selectedIndex = -1;
    for (i=0; i<src.options.length; i++) {
	   if (src.options[i].selected) {
			
            var sc=i;
            var o=src.options[sc];
			
			if(o.value=="Others")
			{
               items=new Option(o.text+' ('+exp[j].skill+')',o.value);
			}
			else
			{
		       items=new Option(o.text,o.value);
			}
            newIndex=target.options.length;
            target.options[newIndex]=items;
	        target.options[newIndex].selected=true;
			j++;
        }
    }
    i = 0;
    while (i<src.options.length) {
        if (src.options[i].selected)
            src.options[i]=null
        else
            i = i + 1;
    }
	delNul(src)
	delNul(target)
}

function xferback(src,target) {
    var sc, itemText, i, newIndex, listy;
    target.selectedIndex = -1;
    for (i=0; i<src.options.length; i++) {
        if (src.options[i].selected) {
            var sc=i;
			var o=src.options[sc]
			var temp = o.text.split(" (");
			items=new Option(temp[0],o.value);
			newIndex=target.options.length;
            target.options[newIndex]=items;
	        target.options[newIndex].selected=true
        }
    }
    i = 0;
    while (i<src.options.length) {
        if (src.options[i].selected)
            src.options[i]=null
        else
            i = i + 1;
    }
	delNul(src)
	delNul(target)
}

function receiptamt(val)
	{
	if(document.receipt.rtype.value == 'MCO')
		{
		document.receipt.ramt.value = 750;
		alert("You have selected Receipt type MCO and postal receipt amount = 750/-");
		}
	if(document.receipt.rtype.value == 'MCR')
		{
		document.receipt.ramt.value = 550;
		alert("You have selected Receipt type MCR and postal receipt amount = 550/-");
		}
	}


/********************  ANIL************************************/

function pgEnableDisbleTextBox(arg,ObtText,OutOfText,PerText)
	{
	
	if(arg.value == 'N')
		{
		ObtText.disabled = true;
		OutOfText.disabled = true;
		ObtText.value ="";
		OutOfText.value ="";
		PerText.value = "";
		document.getElementById('PF').style.display = 'none';
		}
	else if(arg.value == 'A')
		{
		
		document.getElementById('PF').style.display = 'inline';
		ObtText.disabled = true;
		OutOfText.disabled = true;
		ObtText.value ="";
		OutOfText.value ="";
		PerText.value = "";
		}
	else
		{
		document.getElementById('PF').style.display = 'inline';
		ObtText.disabled = false;
		OutOfText.disabled = false;
		}
	}

function isjkoms(val)
	{
	document.getElementById('JKR').style.display = 'none';
	document.getElementById('JKA').style.display = 'none';
	
	if(val.value == 'Y')
		{
		document.getElementById('JKR').style.display = 'inline';
		document.getElementById('JKA').style.display = 'inline';
		}
	else if(val.value == 'Y')
		{
		document.getElementById('JKR').style.display = 'none';
		document.getElementById('JKA').style.display = 'none';
		}
	}

	function ugFaculty(c)
	{
	var id = c.value;
	
	if(id != '4')
		{	
		document.getElementById('EM').style.display = 'inline';
		}
	else
		{
		document.getElementById('EM').style.display = 'none';
		}
	}

function pgFaculty(c)
	{
	var id = c.value;
	
	if(id == 'P')
		{	
		document.getElementById('PF').style.display = 'inline';
		}
	else if(id == 'A')
		{	
		document.getElementById('PF').style.display = 'inline';
		}
	else
		{
		document.getElementById('PF').style.display = 'none';
		}
	}

function EnableDisbleTextBox(arg,ObtText,OutOfText,PerText)
	{
	if(arg.value == 'A' || arg.value == 'N')
		{
		ObtText.disabled = true;
		OutOfText.disabled = true;
		ObtText.value ="";
		OutOfText.value ="";
		PerText.value = "";
		}
	else
		{
		ObtText.disabled = false;
		OutOfText.disabled = false;
		}
	}


function is_int(event) 
{
	//alert(event.keyCode);
	var Key = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if(Key !=8 && Key !=9 && Key !=46)
	{
		if(Key == 13) return true;
		for(i=48;i<=57;i++)
		{
			if(Key == i) return true;
		}
		alert("Please Enter Only Numeric Value.");
		return false;
	}
}


function mathselg(sel)
	{
	if(document.arcconf.fac.value != 6 && sel.value == 0)
		{
		alert("Candidate must have Pass the Mathematics or statistic as one of the subject at 10+2 or at higher level.Except BCA Faculty student.");
		return false;
		}
	else 
		
		return true;
	}

/*function isnumeric()  
	{	  
  alert("ss");
	if((event.keyCode <48 )||(event.keyCode >57 ))  
		{  
		if (event.keyCode != 32 )  
			{  
        		alert('Enter only Numeric values');  
        		event.returnValue=false  
			}  
		}  
	}  
*/
function formatDecimal(argvalue, addzero, decimaln) {
  var numOfDecimal = (decimaln == null) ? 2 : decimaln;
  var number = 1;

  number = Math.pow(10, numOfDecimal);

  argvalue = Math.round(parseFloat(argvalue) * number) / number;
  // If you're using IE3.x, you will get error with the following line.
  // argvalue = argvalue.toString();
  // It works fine in IE4.
  argvalue = "" + argvalue;

  if (argvalue.indexOf(".") == 0)
    argvalue = "0" + argvalue;

  if (addzero == true) {
    if (argvalue.indexOf(".") == -1)
      argvalue = argvalue + ".";

    while ((argvalue.indexOf(".") + 1) > (argvalue.length - numOfDecimal))
      argvalue = argvalue + "0";
  }

  return argvalue;
}



function percentageE1(eObtained,eOutOf,e)  //----------  SSC Percentage
{  
	//alert(eObtained.value + eOutOf.value + e.value);
   if(eObtained.value !="" && eOutOf.value !="" )
    {
	   if(eObtained.value <= 0 || eOutOf.value <= 0) 
	   {
		alert("Please Enter Proper "+e.id);
		e.value ="";
		eObtained.value ="" ;
		eOutOf.value ="";
		eObtained.focus() ;
	    return false;
	    }
	  e.value = formatDecimal((eObtained.value/eOutOf.value)*100,true,2);
	 
	
		if(e.value < 0 || e.value > 100)
		{
			
			 alert("Please enter Valid "+e.id);
    	        	 e.value ="";
			 eObtained.value ="" ;
			 eOutOf.value ="";
			 eObtained.focus();
			 return false;
		}
		/*if(e.value < 40)
		{
    		 alert("You must have minimum 40 % "+e.id);
    		 e.value ="";
			 eObtained.value ="" ;
			 eOutOf.value ="";
			 eObtained.focus() ;
			 return false;
		}*/

   }
}

function validMarks(e1Obtained,e1OutOf,e1)
{
   if(e1.value !="")
   {
     	if(e1.value >100 || e1.value < 0 )
		 {
		  	alert ("Please Enter Proper"+e1.id);
			e1Obtained.value=""; 
			e1OutOf.value=""; 
			e1.value=""; 
			e1Obtained.focus(); 
			return true;
         }

        /* var str="<?php echo $category;?>"	;
         var candidateType=<?php echo $intCandidateType;?>;
         //alert(str);*/
           if(candidateType == 1 && str !="OPEN")
           {
		    //alert(str);
            	if(e1.value < 40)
				{
				alert ('You Must have minimum 40% '+e1.id);
				e1Obtained.value=""; 
				e1OutOf.value=""; 
				e1.value=""; 
				e1Obtained.focus();
				return true;
               }  
		   } 
           else if(e1.value < 45)
           {
            alert ('You Must have minimum 45% '+e1.id);
			e1Obtained.value=""; 
			e1OutOf.value=""; 
			e1.value=""; 
			e1Obtained.focus();
			return true;
           }  
	  }
	  
}//function end

function validMarks1(eObtained,eOutOf,e)
{
    if(e.value >100 || e.value < 0 )
	 {
		alert ('Please Enter Proper '+e.id);
        eObtained.value=""; 
		eOutOf.value=""; 
		e.value=""; 
        eObtained.focus(); 
		return true;
	 }

	  if(e.value < 25)
	   {
		alert ('You Must have minimum 25% '+e.id);
		eObtained.value=""; 
		eOutOf.value=""; 
		e.value=""; 
		eObtained.focus();
		return true;
	   }
}

function percentageE(eObtained,eOutOf,e)  //----------  HSC Percentage
{  
if(eObtained.value !="" && eObtained.value != null && eOutOf.value !="" && eOutOf.value !=null )
    {
		if(eObtained.value <= 0 || eOutOf.value <= 0) 
		{
		alert("Please Enter Proper "+e.id);
		e.value ="";
		eObtained.value ="" ;
		eOutOf.value ="";
		eObtained.focus() ;
	    return false;
	    }
	   
	    var lowerlimit;
		/*var str="<?php echo $category;?>"	;
                var candidateType=<?php echo $intCandidateType;?>;
         //alert(str);
           if(candidateType == 1 && str !="OPEN")
		   lowerlimit=40;
	   else
	       lowerlimit=45; 	   */
		
		e.value = formatDecimal((eObtained.value /  eOutOf.value) *100,true,2);
		if(e.value < 0 || e.value > 100)
		{
			 alert("Please enter Valid "+e.id);
    		 e.value ="";
			 eObtained.value ="" ;
			 eOutOf.value ="";
			 eObtained.focus();
			 return false;
		}
		/*if(e.value < lowerlimit)
		{
    		 alert("You must have minimum "+lowerlimit+"% "+e.id);
    		 e.value ="";
			 eObtained.value ="" ;
			 eOutOf.value ="";
			 eObtained.focus() ;
			 return false;
		}*/	 
   }
}



function valButton(btn) {
var cnt = -1;
for (var i=btn.length-1; i > -1; i--) {
if (btn[i].checked) {cnt = i; i = -1;}
}
if (cnt > -1) return btn[cnt].value;
else return null;
}

function cand_type()
{
	var btn = valButton(document.candtype.type);
	if (btn == null) 
		{	
		alert('Please select the Type of Candidature.');
		return false;
		}
	return true;
	return true;
}


function Categorysubmit()
{
	if(document.cate.maincate.value == 0)
	{
		alert("Select your specific category");   
		document.cate.maincate.focus();
		return false;
	}
	
	if(document.cate.maincate.value != "09")//Reserved category cases start from here
	{
		if(document.cate.subcate.value == '')
		{
			alert("Select your Sub Category");   
			document.cate.subcate.focus();
			return false;
		}
		if(document.cate.subcate.value < 742 && document.cate.subcate.value > 732 && document.cate.othersrno.value == "")
		{
			alert("Fill your Caste Sr. No.");   
			return false;
		}
		if(document.cate.subcate.value < 742 && document.cate.subcate.value > 732 && document.cate.othercaste.value == "")
		{
			alert("Fill your Caste Name.");   
			return false;
		}
	}
	
	if(document.cate.seldist.value == 0)
	{
		alert("Select your District.");
		document.cate.seldist.focus();
		return false;
	}

	if(isSelectRadio_for2(document.cate.radioPH[0],document.cate.radioPH[1]))
		 return false;
	if(isSelectRadio_for3(document.cate.chkPH[0],document.cate.chkPH[1],
		document.cate.chkPH[2]))
	     return false;


return true;
}

function isSelectRadio_for2(radio1,radio2)
	{   
	if(radio1.checked == false && radio2.checked == false)
	    {
	     alert(" Please select "+radio1.id);
		 radio1.focus();
		 return true;
    	}
	return false;
	}

function isSelectRadio_for3(radio1,radio2,radio3)
{   
    if(!(radio1.disabled))
	{
         if(radio1.checked == false && radio2.checked == false && radio3.checked == false )
	    {
	         alert(" Please select the "+radio1.id);
		     radio1.focus();
		     return true;
    	}
	}
 return false;
}


function disableForm(theform) 
{
	if (document.all || document.getElementById) 
	{
		for (i = 0; i < theform.length; i++) 
		{
			var tempobj = theform.elements[i];
			if (tempobj.type.toLowerCase() == "submit" || tempobj.type.toLowerCase() == "reset")
			tempobj.disabled = true;
		}
	}
	else 
	{
	}
}

function ComfirmCancelOrder(t)
	{
	var r=confirm(t);
	if(r==true)
		{
		return true;
		}
	else
		{
		return false;
		}
}

function Receiptsubmit(d,m)
	{
	if(document.receipt.rtype.value == '')
		{
		alert("Select Receipt Type.");
		document.receipt.rtype.focus();
		return false;
		}
	if(document.receipt.rno.value == '')
		{
		alert("Enter your valid Receipt No.");
		document.receipt.rno.focus();
		return false;
		}
	if(document.receipt.rno.value.length < 6)
		{
		alert("Enter your valid Receipt No.");
		document.receipt.rno.focus();
		return false;
		}
	 if(document.receipt.rtype.value == 'MCO' && document.receipt.ramt.value == 550)
		{
		document.receipt.ramt.value = 750;
		var t = "You have selected Receipt type MCO and postal receipt amount = 750/- instead 0f 550/-";
		if(!ComfirmCancelOrder(t))
		return false;
		}
	else if(document.receipt.rtype.value == 'MCR')
		{
		document.receipt.ramt.value = 550;
		var t = "You have selected Receipt type MCR and postal receipt amount = 550/-";
		if(!ComfirmCancelOrder(t))
			return false;
		}
	if(document.receipt.day.value == '')
		{
		alert("Select Receipt Day.");
		document.receipt.day.focus();
		return false;
		}
	 
	return true;
	}




function Cetpref()								/******	CET PREFERENCE  */
	{
	if(isEmptySelect(document.viewtype.cetcenters))
	   return false;
	return true;
}

function copy_textTotext()
{
	var btn = valButton(document.form1.same);
	if (btn == 'Y') 
	{
		document.form1.Addressp.value = "";
		document.form1.Pincodep.value = "";
		document.form1.Addressp.value = document.form1.Addressm.value
		document.form1.Pincodep.value = document.form1.Pincodem.value
	}
	else if (btn == 'N') 
	{
		document.form1.Addressp.value = "";
		document.form1.Pincodep.value = "";
	}
}	

function pdetails()								/******	Personnel DETAILS  */
	{
	if(document.form1.Name.value =='' || document.form1.Name.value ==null)
	{
		alert("Please Enter Name");
		document.form1.Name.focus();
		return false;
	}
	if(FullName(document.form1.Name))
       return false;
	if(document.form1.Name.value.length < 3)
   	{
		alert("Enter your Valid Full Name");
		return false;
	}
	if(isEmpty(document.form1.Addressm))
	   return false;

	if(document.form1.Addressm.value.length < 4)
   		{
		alert("Address should Be Minimum Four(4) Character Long");
		return false;
		} 
	if(isEmpty(document.form1.Pincodem))
	   return false;
    if(ValidPincode(document.form1.Pincodem))   
	   return false;
	if(isEmpty(document.form1.Addressp))
	   return false;
	if(document.form1.Addressp.value.length < 4)
   		{
		alert("Address should Be Minimum Four(4) Character Long");
		return false;
		} 
	if(isEmpty(document.form1.Pincodep))
	   return false;
    if(ValidPincode(document.form1.Pincodep))   
	   return false;
	
	if(isEmptySelect(document.form1.cmbstate))
	   return false;

	if(isEmptySelect(document.form1.gender))
	   return false;
	
	//alert(document.form1.email.value);
	if(document.form1.email.value !="")
	{
		if(validEmail(document.form1.email))
		return false;
	}
	if(document.form1.dob.value == "")
		{
		alert("Please select the Date of birth");
			return false;
		}
	if(isEmptySelect(document.form1.cmbrel))
	   return false;
	
	if(isEmpty(document.form1.Income))
	  	return false;

	return true;
	}

function validEmail(c)
{  
 Email= /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
 if(!Email.test(c.value))
 {
 	alert("Invalid Email ID");
	c.focus();
	return true;
 }
 else
 return false; 
}

function isEmptySelect(c)
{
	 
  if(c.value=="" || c.value == 0 || c.value == null)
  { 
    alert("Please select "+c.id);
    c.focus();
    return true;
  }
  else
     return false;
}

function isEmpty(c)								//ISEMPTY
{

  if(c.disabled == false)
  {
	if(c.value == "" || c.value == " " || c.value == 0 || c.value == null)
  	{ 
    	alert("Please enter "+c.id);
	    c.focus();
	    return true;
    }
  }
  else
     return false;
}

function FullName(inputString)
{
	
	var StrLen = inputString.value.length-1;
	for(var i=0; i <= StrLen; i++)
	{//alert(temp);
		ch=inputString.value.charAt(i)
		if(!(ch >= 'a' && ch <= 'z'||ch >= 'A' && ch <= 'Z')&&!(ch == " "|| ch == "." || ch == "," || ch == "'" || ch == '"'))
		{ 	
		    alert("Entered "+inputString.id+" is invalid");
			 inputString.focus(); 
				return true;
		}
 	}
	return false;
}

function ValidPincode(pin)
{//alert("ok");
    if(pin.value.length != 6)
	{
	    alert(pin.id+"  should be SIX (6) Digit");
		//pin.value = "";
		pin.focus();
		return true;
	}
	else
	return false;
}

function validNum1(c)
{   
    if(c.value.length != 0)
	{
		
		if (isNum.test(c.value) == false || isBlank.test(c.value))
		{
			alert ("Please enter valid " + c.id +"(Number only)");
			c.value = "";
			c.focus();
			return true;
		}
	}
	else
	  return false;
}
