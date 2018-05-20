<?php
$dom=new DomDocument();
$dom->load("book.xml");

$t=$dom->getElementsByTagName("Book_Title");
//echo "hello";
echo "<b> Book Name :</b><br>";
	foreach($t as $node)
	{		
		print $node->textContent."<br>";
	}
	$t=$dom->getElementsByTagName("Book_Author");
	echo "<b> Book Author :</b><br>";
	foreach($t as $node)
	{		
		print $node->textContent."<br>";
	}


?>
