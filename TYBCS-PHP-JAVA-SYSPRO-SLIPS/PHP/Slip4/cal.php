<?php

$n1=$_POST['no1'];
$n2=$_POST['no2'];
//echo $n1;
//echo $n1;
$op=$_POST['op'];
//echo $op;
class Cal
{
	private $a,$b;
	function Cal($a,$b)
	{
		$this->a=$a;
		$this->b=$b;
	}
	public function add()
	{
		return $this->a+$this->b;
	}
	public function sub()
	{
		return $this->a-$this->b;
	}
	public function mult()
	{
		return $this->a*$this->b;
	}
	public function div()
	{
		return $this->a/$this->b;
	}
}

$ob=new Cal($n1,$n2);

switch($op)
{
	case '+' : echo "Addition is :".$ob->add();
				break;
	case '-' : echo "Substarction is :".$ob->sub();
				break;
	case '*' : echo "Multiplication is :".$ob->mult();
				break;
	case '/' : echo "Division is:".$ob->div();
				break;
			
		
}
?>
