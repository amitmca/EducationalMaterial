<?php
	define('PI',3.144);
	
	interface area_volume
	{
		function area();
		function volume();
	}
	class cylinder implements area_volume
	{
		private $r;
		private $h;
		
		function cylinder($r,$h)
		{
			$this->r=$r;
			$this->h=$h;
			
		}
		function area()
		{
			return 2*PI*$this->r*($this->r*$this->h);
		}
		function volume()
		{
			return PI*$this->r*$this->r*$this->h;
		}
	}
	$obj=new cylinder(4,5);
	printf("Area of Cylinder :: %f<br>Volume of Cylinder::%f",$obj->area(),$obj->volume());

?>
