<center><h3><font color="red">ASP Text Functions</font></h3>

<b><font color="green">Len</font><br>There are 
<% =len("I am from Baramati") %>
Characters in "I am from Baramati" including space.

<br><br>
<font color="green">Left</font><br>
Left 3 Characters in the word "Baramati" are
<% =left("Baramati",3)%>

<br><br>
<font color="green">Right</font><br>
Right 4 Characters in the word "Baramati" are
<% =right("Baramati",4)%>

<br><br>
<font color="green">Middle</font><br>

<% =left(right("pineapples",6),5) %>
<br>
<% =right(left("pineapples",9),5) %>

<a href=<% =weekdayname(weekday(now)) %>.html>Link Of The Day</a>

</center>
