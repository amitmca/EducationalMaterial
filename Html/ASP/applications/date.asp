<center>
<h3><font color="red">ASP Date,Time Functions</font></h3>

<b>Today's Date is&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =date %>

<br><br>Current Time is&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =time %>

<br><br>Current Date and Time is&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =now %>

<br><br>Month is&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =month(now) %>

<br><br>Month Name is&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =monthname(month(now)) %>

<br><br>Day is&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =day(now) %>

<br><br>Year is&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =year(now) %>

<br><br>Weekday is&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =weekday(now) %>

<br><br>Weekday Name is&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =weekdayname(weekday(now)) %>

<br><br>Hour is&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =hour(now) %>

<br><br>Minutes are&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =minute(now) %>

<br><br>Seconds are&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =second(now) %>

<br><br>Time Value for 17:10:05PM &nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;<% =timevalue("17:10:05PM") %>
</center>