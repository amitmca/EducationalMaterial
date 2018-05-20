// form validation function //
function validate(form) {
  var name = form.txtname.value;
  var pid=form.txtpid.value;
  var pass=form.txtpass.value;
  var pass1=form.txtvpass.value;
  var security=form.security.value;
  var ans=form.txtans.value;
  var month=form.month.value;
  var date1=form.date1.value;
  var year=form.year.value;
  var gender=form.gender.value;
  var country=form.country.value;



	
  if(name == "") {
    inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must enter your name.</font></b>',2);
	
    return false;
  }
  
  if(pid == "") {
  inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must enter your Project ID.</font></b>',2);

    return false;
}
if(pass == "") {
     inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must enter your password.</font></b>',2);

    return false;
}

if(pass1 == "") {
    inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must verify your password.</font></b>',2);

    return false;
}

if(security == "") {
     inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must select security question.</font></b>',2);

    return false;
}

if(ans == "") {
     inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must enter answer for security question.</font></b>',2);

    return false;
}
if(month == "") {
 inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must select a month.</font></b>',2);
    return false;
}
if(date1 == "") {
 inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must enter a date.</font></b>',2);
    return false;
}
if(year == "") {
 inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must enter a year.</font></b>',2);
    return false;
}
if(gender == "") {
 inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must select your gender.</font></b>',2);
    return false;
}
if(country == "") {
 inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must enter your country.</font></b>',2);
    return false;
}

if(verify == "") {
 inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must enter the code given.</font></b>',2);
    return false;
}

if(document.form.a.checked==false)
		{
		 inlineMsg('name','<strong><font color=white face=Verdana, Arial, Helvetica><center>Error</center></font></strong></br><b><font color=yellow face=Verdana, Arial, Helvetica>You must be agreed upon the terms and conditions.</font></b>',2);
    return false;
		}


  return true;
}

// START OF MESSAGE SCRIPT //

var MSGTIMER = 20;
var MSGSPEED = 5;
var MSGOFFSET = 3;
var MSGHIDE = 3;

// build out the divs, set attributes and call the fade function //
function inlineMsg(target,string,autohide) {
  var msg;
  var msgcontent;
  if(!document.getElementById('msg')) {
    msg = document.createElement('div');
    msg.id = 'msg';
    msgcontent = document.createElement('div');
    msgcontent.id = 'msgcontent';
    document.body.appendChild(msg);
    msg.appendChild(msgcontent);
    msg.style.filter = 'alpha(opacity=0)';
    msg.style.opacity = 0;
    msg.alpha = 0;
  } else {
    msg = document.getElementById('msg');
    msgcontent = document.getElementById('msgcontent');
  }
  msgcontent.innerHTML = string;
  msg.style.display = 'block';
  var msgheight = msg.offsetHeight;
  var targetdiv = document.getElementById(target);
  targetdiv.focus();
  var targetheight = targetdiv.offsetHeight;
  var targetwidth = targetdiv.offsetWidth;
  var topposition = topPosition(targetdiv) - ((msgheight - targetheight) / 2);
  var leftposition = leftPosition(targetdiv) + targetwidth + MSGOFFSET;
  msg.style.top = topposition + 'px';
  msg.style.left = leftposition + 'px';
  clearInterval(msg.timer);
  msg.timer = setInterval("fadeMsg(1)", MSGTIMER);
  if(!autohide) {
    autohide = MSGHIDE;  
  }
  window.setTimeout("hideMsg()", (autohide * 1000));
}

// hide the form alert //
function hideMsg(msg) {
  var msg = document.getElementById('msg');
  if(!msg.timer) {
    msg.timer = setInterval("fadeMsg(0)", MSGTIMER);
  }
}

// face the message box //
function fadeMsg(flag) {
  if(flag == null) {
    flag = 1;
  }
  var msg = document.getElementById('msg');
  var value;
  if(flag == 1) {
    value = msg.alpha + MSGSPEED;
  } else {
    value = msg.alpha - MSGSPEED;
  }
  msg.alpha = value;
  msg.style.opacity = (value / 100);
  msg.style.filter = 'alpha(opacity=' + value + ')';
  if(value >= 99) {
    clearInterval(msg.timer);
    msg.timer = null;
  } else if(value <= 1) {
    msg.style.display = "none";
    clearInterval(msg.timer);
  }
}

// calculate the position of the element in relation to the left of the browser //
function leftPosition(target) {
  var left = 0;
  if(target.offsetParent) {
    while(1) {
      left += target.offsetLeft;
      if(!target.offsetParent) {
        break;
      }
      target = target.offsetParent;
    }
  } else if(target.x) {
    left += target.x;
  }
  return left;
}

// calculate the position of the element in relation to the top of the browser window //
function topPosition(target) {
  var top = 0;
  if(target.offsetParent) {
    while(1) {
      top += target.offsetTop;
      if(!target.offsetParent) {
        break;
      }
      target = target.offsetParent;
    }
  } else if(target.y) {
    top += target.y;
  }
  return top;
}

// preload the arrow //
if(document.images) {
  arrow = new Image(7,80); 
  arrow.src = "images/n.gif"; 
}