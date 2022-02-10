package car_Dealership;
public class Custom_class {
	public int custom_paint(String paint,int car_price)
	{
		System.out.println("You have choosen "+paint+" Color");
		return (int)(0.09*car_price);
	}
	public int custom_lights(String c,int car_price)
	{
		if(c.equalsIgnoreCase("Yes"))
		{
			System.out.println("Neon Lights are also installed");
			return (int)(0.06*car_price);
		}
		else
		{
			System.out.println("Neon Lights are not installed");
			return 0;
		}
	}
	public int custom_rims(String c,int car_price)
	{
		System.out.println(c+ "Colored rims are installed in your car");
		return (int)(0.045*car_price);
	}
	public int custom_interior(String c,int car_price)
	{
		int custom_int=0;
		switch(c)
		{
			case "Wood": 
			{
				custom_int = (int)(0.01*car_price);
				break;
			}
			case "Leather": 
			{
				custom_int = (int)(0.04*car_price);
				break;
			}
			case "Suede": 
			{
				custom_int = (int)(0.04*car_price);
				break;
			}
			case "Velour": 
			{
				custom_int = (int)(0.03*car_price);
				break;
			}
			case "Wool": 
			{
				custom_int = (int)(0.1*car_price);
				break;
			}
			default:
			{
				//System.out.println("Wrong Input...");
				break;
			}
		}
		return custom_int;
	}
}
