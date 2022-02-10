package car_Dealership;

import java.io.*;
import java.util.*;
public class Bill extends Login_signup{
	public Bill(String choice) throws IOException, ClassNotFoundException, InterruptedException {
		super(choice);
	}
	static String NAME = name+".txt";
	static String us = reciept;
	public static void bill_print(String car_name,int car_price,String paint,String rims,String interior,int custom_interior,int custom_paint,int custom_rim,int custom_light,int total) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(NAME,true));
		bw.write("-------------------------Receipt----------------------------------"+"\n"+"DATE: "+new Date()+"\n");
		String p[] = us.split(":", 3);
		for(String  i : p)
		{
			bw.write(i+"\n");
		}
		bw.write("Selected car model:  "+car_name+": "+car_price+"\n");
		bw.write("Selected Paint: ");
		if(!(paint.equals("pearl_white")))
		{
			bw.write(paint+": "+custom_paint+"\n");
		}
		else
		{
			bw.write(paint+": 0\n");
		}
		bw.write("Selected Rims: ");
		if(!(rims.equals("Default_chrome")))
		{
			bw.write(rims+":"+custom_rim+"\n");
		}
		else
		{
			bw.write(rims+": 0\n");
		}
		bw.write("Interior: ");
		if(!(interior.equals("Vinyl")))
		{
			bw.write(interior+": "+custom_interior+"\n");
		}
		else
		{
			bw.write(interior+": 0\n");
		}
		if(custom_light != 0)
		{
			bw.write("Neon lights: "+custom_light+"\n");
		}
		bw.write("Final Price: "+total+"\n");
		bw.flush();bw.close();
	}
}