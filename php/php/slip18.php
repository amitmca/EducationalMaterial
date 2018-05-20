<?
	class A
	{
		var $i=10,$j=15;
		function f1(){}
		function f2(){}
		function f3(){}
	}
	class B extends A
	{
		var $k=35;
		function f4(){}
		function f5(){}
	}
	function print_methods($class)
	{
		$methods = get_class_methods($class);
		echo '<ul>';
		foreach($methods as $method)
		{
			echo "<li>$method</li>";
		}
		echo '</ul>';
	}
        function print_vars($class)
        {
                $vars = get_class_vars($class);
                echo '<ul>';
                foreach($vars as $key=>$val)
                {
                        echo "<li>$key=$val</li>";
                }
                echo '</ul>';
        }
	$obj = new B;
	$class = get_class($obj);
	$parent = get_parent_class($class);
	echo "<h1>Parent: $parent</h1><br>";
	echo "Methods<br>";
	print_methods($parent);
	echo "Properties<br>";
	print_vars($parent);
        echo "<h1>Child: $class</h1><br>";
        echo "Methods<br>";
        print_methods($class);
        echo "Properties<br>";
        print_vars($class);
?>


