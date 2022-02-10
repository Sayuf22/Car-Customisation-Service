package car_Dealership;
import java.util.*;
import java.io.*;
public class Petrol_cars {
	public TreeMap<String,Integer> get_details() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Petrol_cars.txt"));
		String line;
		TreeMap<String , Integer> PC = new TreeMap<String,Integer>();
		while((line = br.readLine())!= null)
		{
			String p[] = line.split(":", 2);
			if(p.length >=2)
			{
				String key = p[0];
				Integer val = Integer.valueOf(p[1]);
				PC.put(key, val);
			}
		}
		br.close();
		return PC;
	}
}
