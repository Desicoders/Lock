package com.Locktome;

import java.io.IOException;
import java.util.Scanner;

public class ClientApp {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		String choice="";
		do {
		Lockedme.displayMenu();
		 choice=sc.nextLine();
		 switch(choice){
			 case  "1":
				 Lockedme.display_all_files();
				 break;
			 case "2":
				 System.out.println("Enter file name to delete");
				 String s=sc.nextLine();
				 Lockedme.deleteFile(s);
				 break;
			 case "3":
				 System.out.println("Enter filename to search if exists");
				 String s1=sc.nextLine();
				 Lockedme.searchFile(s1);
				 break;
			 case "4":
				 System.out.print("enter filename to write in it");
				 String s2=sc.nextLine();
				 Lockedme.Write(s2);
				 break;
			 case "5":
				 System.out.println("enter filename to display file");
				 String s3=sc.nextLine();
				 Lockedme.display(s3);
				 break;
			 case "6":
				 System.out.println("you have chosen to exit");
				 break;
			  default:
				 System.out.println("invalid input");
			 
			 
		 }
		
		
		}while(!choice.equalsIgnoreCase("6"));
		sc.close();
		
	}
	
	
	
	
}
