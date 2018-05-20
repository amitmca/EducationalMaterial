<?
	class A
	{
		var $i=10;
		var $j=20;
		function f1(){}
		function f2(){}
	}
	class B extends A
	{
		var $x=10;
		var $y=20;
		function fun(){}
	}
	function print_methods($class)
	{
		$methods=get_class_methods($class);
		echo"<h2>Methods<h2><br>";
		echo'<ul>';
		foreach($methods as $val)
		{
			echo"<li>$val</li><br>";
		}
		echo'</ul>';
	}
	function print_properties($class)
        {
                $vars=get_class_vars($class);
                echo"<h2>Properties<h2><br>";
                echo'<ul>';
                foreach($vars as $val)
                {
                        echo"<li>$val</li><br>";
                }
                echo'</ul>';
        }
	$ob=new B;
	$parent=get_parent_class($ob);
	echo"<h1>Parent : $parent</h1><br>";
	print_methods($parent);
	print_properties($parent);
	$class=get_class($ob);
	echo"<h1>Childs : $class</h1><br>";
        print_methods($class);
        print_properties($class);
?>
