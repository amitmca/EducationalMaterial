<script language="javascript">
function validate()
	{
	for(i=0;i<document.regform.elements.length;i++)
		{
		if(document.regform.elements[i].type=="text")
			{
			if(document.regform.elements[i].value=" ")
				{
				alert("Data left empty");
				document.regform.elements[i].focus();
				return false;
				}
			}
		}
	}

</script>