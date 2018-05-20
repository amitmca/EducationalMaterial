<?
class Shape
{
	var $dim1, $dim2;
	function Shape($dim1,$dim2)
	{
		$this->dim1 = $dim1;
		$this->dim2 = $dim2;
	}
	function get_area()
	{
		return $this->dim1*$this->dim2;
	}
}
class Rectangle extends Shape
{
	function Rectangle($dim1,$dim2)
	{
		$this->Shape($dim1,$dim2);
	}
	function get_area()
	{
		return parent::get_area();
	}
}
class Square extends Shape
{
	function Square($dim1)
	{
		$this->Shape($dim1,$dim1);
	}
	function get_area()
	{
		return parent::get_area();
	}
}
class Circle extends Shape
{
	function Circle($dim1)
	{
		$this->Shape($dim1,$dim1);
	}
	function get_area()
	{
		return M_PI*parent::get_area();
	}
}
$a = $_POST['dim1'];
$b = $_POST['dim2'];
$obj = null;
if($_POST['shape']=="rectangle")
{
	$obj = new Rectangle($a,$b);
}
elseif($_POST['shape']=="square")
{
	$obj = new Square($a);
}
elseif($_POST['shape']=="circle")
{
	$obj = new Circle($a);
}
$area = $obj->get_area();
echo "<h1>Area = $area</h1><br>";
echo "<a href='slip16.html'>Go Back</a>";
?>		
