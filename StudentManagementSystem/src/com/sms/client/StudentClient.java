package com.sms.client;
import java.util.Scanner;
import com.sms.details.StudentDetails;



public class StudentClient {
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("-------------------------------------------------------");
			System.out.println("                   1.Student                           ");
			System.out.println("                   2.Exit                              ");
			System.out.println("-------------------------------------------------------");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				StudentDetails details = new StudentDetails();
				details.studentMenu();
				break;
			case 2:
				System.out.println("Thanks for choosing us :)");
				System.exit(0);
			default:
				System.out.println("Choose between 1-2");
			}
			
		}
	}

}


