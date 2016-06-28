<?php
require 'Matematicas.php';
class TestMatematicas extends PHPUnit_Framework_TestCase
{
	public function testAdd() {
		$num1=3;
		$num2=2;
		$result=5;
		$this->assertEquals(Matematicas.suma(num1, num2), result);
		
	}
}