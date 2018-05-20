<?php
abstract class Shape
{
	protected $d1,$d2;
	
	function Shape($d1,$d2)
	{
		$this->d1=$d1;
		$this->d2=$d2;
	}
	abstract function Area();
}//abstratc class Shape

class Circle extends Shape{
		function Circle($radius){
			$this->Shape($radius,0);
		}

		public function Area(){
			return M_PI*$this->d1*$this->d1;
		}
	}//class Circle

class Square extends Shape
{
	function Square($side)
	{
		$this->Shape($side,0);
	}
	public function Area()
	{
		return $this->d1*$this->d1;
	}
}//class Square


class Triangle extends Shape
{
private $d3;
	function Triangle($side1,$side2,$side3)
	{
		$this->Shape($side1,$side2,$side3);
	}
	public function Area()
	{
		$s=($this->d1+$this->d2+$this->d3)/3;
		return sqrt($s*($s-$this->d1)*($s-$this->d2)*($s-$this->d3));
	}
}//class Triangle

$r=$_GET['r'];
$s=$_GET['s'];
$a=$_GET['a'];
$b=$_GET['b'];
$c=$_GET['c'];

$op=$_GET['op'];
$obj=null;
switch($op)
{
	case 1:	$obj=new Circle($r);
				break;
	case 2:	$obj=new Square($s);
				break;
	case 3:	$obj=new Triangle($a,$b,$c);
				break;
}
printf("Area=%0.2f",$obj->Area());
?>
<br><a href='shape.html' >GO BACK</a>
