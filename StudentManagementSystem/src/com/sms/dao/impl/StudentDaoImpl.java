package com.sms.dao.impl;
import java.io.*;
import java.util.Scanner;
import com.sms.pojo.Student;

public class StudentDaoImpl {
	//StudentDaoImpl obj = new StudentDaoImpl();
	static File file = new File("students.txt");
	static Scanner sc = new Scanner(System.in);
     static int size;
	 static Student[] studentInfo; 
	
	public static void addStudents() {
		
		
		  System.out.println("How many students do you want to add: "); 
		  size=sc.nextInt(); 
		  studentInfo = new Student[size];
		 
		 
		
		for(int i = 0; i<size; i++) {
			System.out.println("Enter Student ID#: ");
			int id = sc.nextInt();
			System.out.println("Enter Student Name: ");
			String name = sc.next();
			System.out.println("Enter Student Address: ");
			String address= sc.next();
			
			Student stu = new Student(id,name,address);
			studentInfo[i]=stu;
			System.out.println("Student Added Successfully");
			System.out.println();
			//saveToFile();
		}
		try (PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {
		      for (int i = 0; i < size ; i++) {
		        writer.write(studentInfo[i].getId() + ","+ studentInfo[i].getName() + "," + studentInfo[i].getAddress() + "\n");
		      }
		      System.out.println("Data saved to file.");
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
		
	}
	
	public Student[] viewAllStudents() { 
			
	
		return studentInfo; 
		
	}
	
	/*
	 * public Student viewStudent(int id) { if(studentInfo!=null) { for(Student
	 * list: studentInfo) { if(list!=null) //if(list.getId()==id) { return list; } }
	 * } return null; }
	 */

	 
	public void getDataFromFile() {
      if (file.exists()){
    	  int i = 0;
    	  size = 0;
    	  try (Scanner fileScanner = new Scanner(file)) {
    	    while (fileScanner.hasNextLine()) {
    	      size++;
    	      fileScanner.nextLine();
    	    }
    	  } catch (IOException e) {
    	    e.printStackTrace();
    	  }
    	  
    	  studentInfo = new Student[size];
    	  try (Scanner fileScanner = new Scanner(file)) {
    	    i = 0;
    	    while (fileScanner.hasNextLine()) {
    	    	String[] data = fileScanner.nextLine().split(",");
    	        int id = Integer.parseInt(data[0]);
    	        String name = data[1];
    	        String address = data[2];
    	        studentInfo[i] = new Student(id, name, address);
    	        i++;
    	    }
    	  } catch (IOException e) {
    	    e.printStackTrace();
    	  }
    	}




	}




}


