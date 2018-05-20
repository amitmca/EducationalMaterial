<?
	class shape
	{
		var $dim1,$dim2;
		function shape($d1,$d2)
		{
			$this->dim1=$d1;
			$this->dim2=$d2;
		}
		function get_area()
		{
			return $this->dim1*$this->dim2;
		}
	}
	class Rectangle extends shape
	{
		function Rectangle($d1,$d2)
		{
			$this->shape($d1,$d2);
		}
		function get_area()
		{
			return parent::get_area();
		}
	}
	class Square extends shape
        {
                function Square($d1)
                {
                        $this->shape($d1,$d1);
                }
                function get_area()
                {
                        return parent::get_area();
                }
        }
	class Circle extends shape
        {
                function Circle($d1)
                {
                        $this->shape($d1,$d1);
                }
                function get_area()
                {
                        return parent::get_area()*M_PI;
                }
        }
	$a=$_POST['dim1'];
	$b=$_POST['dim2'];
	$obj=NULL;
	$area=NULL;
	if($_POST['shape']=='rectangle')
	{
		$obj= new rectangle($a,$b);
	}
	else
	if($_POST['shape']=='square')
        {
                $obj= new square($a);
        }
	else
	if($_POST['shape']=='circle')
        {
                $obj= new circle($a);
        }
	$area=$obj->get_area();
	echo"<h1>Area=$area</h1>";
	
?>
