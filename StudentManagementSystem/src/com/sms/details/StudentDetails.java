package com.sms.details;
import java.util.Scanner;
import com.sms.client.StudentClient;
import com.sms.dao.impl.StudentDaoImpl;
import com.sms.pojo.Student;



public class StudentDetails {
	Scanner sc = new Scanner(System.in);
	StudentDaoImpl daoImpl = new StudentDaoImpl();
	
	public void studentMenu() {
		while(true) {
			System.out.println("-----------------------------------------------");
			System.out.println("            1) Add Student                     ");
			System.out.println("            2) ViewAll Student                 ");
			//System.out.println("            3) View Student[NOT WORKING]       ");
			System.out.println("            3) Back                            ");
			System.out.println("-----------------------------------------------");
			
			System.out.println("Enter the choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				daoImpl.addStudents();
             
				studentMenu();
				break;
			case 2:
              daoImpl.getDataFromFile();
				Student[] viewAllStudents = daoImpl.viewAllStudents();
				System.out.println("-----------------------------------------------");
				System.out.println("StudentID \tStudentName \tStudentAddress");
				System.out.println("-----------------------------------------------");
				if(viewAllStudents!=null) {
				for(Student s: viewAllStudents) {
					if(s!=null)
						System.out.println(s.getId()+"\t\t"+s.getName()+"\t\t"+s.getAddress());
				}
				}
				else {
					System.out.println("Student Records are empty");
				}
				studentMenu();
				break;
			
			case 3:
				StudentClient.main(null);
				break;
			default:
				System.out.println("Choose between 1 - 3");
					
				
			}
			
		}
	}

}


