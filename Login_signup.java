package car_Dealership;

import java.util.*;
import java.util.regex.*;
import java.io.*;

class New_Customer {
	String name, user_name, password, con_pass,email, ph_no;
	Scanner sc = new Scanner(System.in);
	int count = 0;

	public New_Customer() throws InterruptedException {
		System.out.print("Enter Your Name: ");//x
		this.name = sc.next();//name = x.getText();
		System.out.print("Enter Your User_name: ");
		this.user_name = sc.next();
		do {
			if (count != 0) {
				System.err.println("Your Password doesnot match...Try Again!!!!!");
				Thread.currentThread();
				Thread.sleep(1000);
			}
			System.out.print("Enter Your Password: ");
			this.password = sc.next();
			System.out.print("Confirm Your Password: ");
			this.con_pass = sc.next();
			count++;
		} while (!(password.equals(con_pass)));
		boolean check_ph_no = false;
		do
		{
			System.out.print("Enter your phone number: ");
			ph_no = sc.next();
			check_ph_no = Pattern.matches("[6-9]{1}[0-9]{8}[^0]{1}",ph_no);	
		}while(!check_ph_no);
		boolean check_email = false;
		do
		{
			System.out.print("Enter your Email: ");
			email = sc.next();
			check_email = Pattern.matches("^(.+)@(.+)$",email);	
		}while(!check_email);
	}
}
public class Login_signup {
	Scanner sc = new Scanner(System.in);
	static String name,UserData,reciept;
	public Login_signup(String choice)throws IOException, ClassNotFoundException, InterruptedException
	{
		if(choice.equalsIgnoreCase("signup"))
		{
			New_Customer N1 = new New_Customer();
			UserData = N1.user_name+":"+N1.password+":"+N1.name+":"+N1.ph_no+":"+N1.email+"\n";
			System.out.println("Restart the application and choose Login Option...");
			BufferedWriter bw = new BufferedWriter(new FileWriter("UserInfo.txt",true));
			bw.write(UserData);
			bw.flush();
			bw.close();
			System.exit(0);
		}
		else if(choice.equalsIgnoreCase("login"))
		{
			String user_name,pass,line;
			int success = 0;
			do
			{
				System.out.print("Enter User_Name: ");
				user_name = sc.next();
				System.out.print("Enter Password: ");
				pass = sc.next();
				BufferedReader br = new BufferedReader(new FileReader("UserInfo.txt"));
				while((line = br.readLine())!= null)
				{
					String p[] = line.split(":", 5);
					if(p.length >= 2)
					{
						if((user_name.equals(p[0])))
						{
							if(pass.equals(p[1]))
							{
								success = 1;
								name = p[2];
								reciept = p[2]+":"+p[3]+":"+p[4]+"\n";
								System.out.println("Hello..."+p[2]);  
								break;
							}
							else
							{
								System.out.println("Incorrect Password");
							}
						}
					}
				}
				if(success == 0)
				{
					System.out.println("Username Doesnot exist.....Try Again...!!!");
				}
				br.close();
			}while(success != 1);
			System.out.println("---------------Welcome To the Application----------------------");
		}
	}
	public String get_name()
	{
		return this.name;
	}
}
