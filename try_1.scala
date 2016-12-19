object Main {
  def akkerman(a: Int,b: Int) :Int = {
   if (a == 0)
	{
		 b +  1	
	}
	else
	{
		if ((a > 0) && (b == 0))
		{
			
			akkerman(a - 1,1)
		}
		else
		{
		 	if ((a > 0) && (b > 0))
			{
				
				akkerman(a - 1, akkerman(a, b - 1))
			}
			 else
			{
				b +  1
			}
		}
	}
 }
  def main(args:Array[String]) :Unit 
={
 print("Result: " +  akkerman(3, 5))

 }
}
