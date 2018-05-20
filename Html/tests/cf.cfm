<STYLE TYPE="text/css">  
<!-- 
.row0 {background-color: green;}  
.row1 {background-color: white;}  
-->  
</STYLE>  
<TABLE>  
<CFOUTPUT QUERY="QueryName">  
<CFSET class="row#Int(QueryName.CurrentRow MOD 2)#">  
<TR class = #class#>  
<TD>#Field1#</td>  
<TD>#Field2#</td>  
</TR>  
</CFOUTPUT>  
</TABLE>
