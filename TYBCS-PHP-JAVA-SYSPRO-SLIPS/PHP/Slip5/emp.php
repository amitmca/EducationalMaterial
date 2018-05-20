<?php
	$doc = new DOMDocument("1.0");
	$doc->formatOutput = true;

	$root = $doc->createElement("EmpDetails");
	$root = $doc->appendChild($root);

	$emp = $doc->createElement("Employee");
	$emp = $root->appendChild($emp);
	$emp->setAttribute("EmpNo","1");
	$emp->setAttribute("EmpName","Sham");

	$sal = $doc->createElement("Salary");
	$sal = $root->appendChild($sal);

	$text = $doc->createTextNode("4500");
	$text = $sal->appendChild($text);

	$desgn = $doc->createElement("Designation");
	$desgn = $root->appendChild($desgn);

	$text = $doc->createTextNode("Clerk");
	$text = $desgn->appendChild($text);

	$doc->save("Employee1.xml");
?>
