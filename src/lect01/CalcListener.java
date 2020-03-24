package lect01;

import lect01.CalculatorUI;

public class CalcListener extends CalculatorUI
{

	private double cResult;
	private double cResultPlus;
	
	public CalcListener(double number)
	{
		setMemory(number);
		setMemoryPluss(number);
	}
	
	public void setMemory(double number)
	{
		this.cResult = number;
		counter();
	}
	
	public void addToMemory(double number)
	{
		cResult += number;
		cResultPlus += number;
	}
	
	public void substractFromMemory(double number)
	{
		cResult -= number;
		cResultPlus -= number;
	}
	
	public double getMemory()
	{
		return cResult;
	}
	
	public void setMemoryPluss(double number)
	{
		this.cResultPlus = number;
	}
	
	public double getMemoryPluss()
	{
		return cResultPlus;
	}
	
	public double add(double number)
	{
		setMemory(getMemory() + number);
		return getMemory();
	}
	
	public double subtract(double number)
	{
		setMemory(getMemory() - number);
		return getMemory();
	}
	
	public double multiply(double number)
	{
		return getMemory() * number;
	}
	
	public double divid(double number)
	{
		return getMemory() / number;
	
	}
	
	public double square(double number)
	{
		return number * number;
	}
	
	public double squareRoot(double number)
	{
		return Math.sqrt(number);
	}
	
	public double reciproc(double number)
	{
		return 1.0 / number;
	}
	
	public double percentage(double number)
	{
		return  getMemory() / 100 * number;
	}
	
}
	