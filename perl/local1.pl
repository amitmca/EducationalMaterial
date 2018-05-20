sub Hello
	{
	$f=0;
	}	
sub myword
	{
	local $f=20;
	Hello();
	print $f;
	}
myword();