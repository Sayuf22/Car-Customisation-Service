package car_Dealership;

import java.io.*;
import java.util.*;

public class Test {
	public static void custom() {
		System.out.println("What do you want to customise: ");
		System.out.print("1.Paint\n2.Add Neon Light Kit\n3.Rims\n4.Interior\n5.Quit\nEnter your choice: ");
	}

	public static void main(String[] args)
			throws IOException, NullPointerException, InterruptedException, ClassNotFoundException {
		String choice, car_choice;
		Integer x = null;
		String car_name = null, paint = "pearl white", rims = "Default_Chrome", interior = "Vinyl";
		int budget, car_price = 0;
		int custom_choices, custom_paint = 0, custom_light = 0, custom_rim = 0, custom_interior = 0;
		Custom_class C = new Custom_class();
		Scanner sc = new Scanner(System.in);
		TreeMap<String, Integer> finalMap = new TreeMap<String, Integer>();
		System.out.print("Enter Signup if new user...Enter Login if existing user: ");
		choice = sc.next();
		Login_signup L = new Login_signup(choice);
		System.out.print("Select Fuel Type (petrol/diesel): ");
		car_choice = sc.next();
		if (car_choice.equalsIgnoreCase("petrol")) {
			Petrol_cars P = new Petrol_cars();
			finalMap = P.get_details();
		} else if (car_choice.equalsIgnoreCase("diesel")) {
			Diesel_cars D = new Diesel_cars();
			finalMap = D.get_details();
		}
		System.out.print("Enter Your Budget: ");
		budget = sc.nextInt();
		ArrayList<Map.Entry<String, Integer>> List = new ArrayList<Map.Entry<String, Integer>>(finalMap.entrySet());
		Collections.sort(List, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		System.out.println("Cars Available for your Budget ");
		for (Map.Entry<String, Integer> f : List) {
			if (f.getValue() <= budget) {
				System.out.println(f.getKey() + ":" + f.getValue());
			}
		}
		do {
			System.out.print("Enter the name of the car you wish to buy: ");
			car_name = sc.next();
			x = finalMap.get(car_name);
			if (x == null) {
				System.out.println("Car name Invalid");
			}
		} while (x == null);
		car_price = (int) x;
		System.out.println("Your selected car is " + car_name + " of price: " + car_price);
		do {
			Test.custom();
			custom_choices = sc.nextInt();
			switch (custom_choices) {
			case 1: {
				System.out.println("Currently your car color is " + paint);
				System.out.print("What paint do you want: ");
				paint = sc.next();
				custom_paint = C.custom_paint(paint, car_price);
				break;
			}
			case 2: {
				System.out.print("Do you want to add neon Lights??(Yes/no): ");
				String c = sc.next();
				custom_light = C.custom_lights(c, car_price);
				break;
			}
			case 3: {
				System.out.println("Currently you have " + rims + " cloured rims");
				System.out.print("What color rims do you want :");
				rims = sc.next();
				custom_rim = C.custom_rims(rims, car_price);
				break;
			}
			case 4: {
				System.out.println("Current interior is: " + interior);
				System.out
						.println("What material of interior do want: \n1. Wood\t2.Leather\t3.Suede\t4.Velour\t5.Wool");
				System.out.println("Enter desired material: ");
				interior = sc.next();
				custom_interior = C.custom_interior(interior, car_price);
				break;
			}
			default: {
				// System.out.println("Wrong Input.....Try again");
				break;
			}
			}
		} while (custom_choices != 5);
		int total = car_price + custom_interior + custom_light + custom_paint + custom_rim;
		Bill.bill_print(car_name, car_price, paint, rims, interior, custom_interior, custom_paint, custom_rim,
				custom_light, total);
		System.out.println("----------Thank you for the purchase------------");
		
	}

}
