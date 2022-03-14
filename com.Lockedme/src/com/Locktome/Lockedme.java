package com.Locktome;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*WELCOME TO LOCKEDME.COM
******************
DEVELOPER NAME: Bhuwan Agrawal
**************** *
Date : 14th/march/2022

*/

public class Lockedme {
	static String path="File Database";
	public static void display_all_files() {
	
    File f=new File(path);
    //System.out.println(f.getAbsolutePath());
    String arr[]=f.list();
    System.out.println("all files present in the directory are");
    for(int i=0;i<arr.length;i++)
    	System.out.println(arr[i]);
    
    } 
	
	public static void  createnewFile(String FileName) throws IOException
	{
		String path1=Lockedme.path;
		path1+="//"+FileName;
		File f=new File(path1);
		if(f.exists())
		{System.out.println("file already exists");}
		else if(f.createNewFile())
		System.out.println("File created sucessfully");
		else {System.out.println("file not created please try again");}
		
	}
	public static void deleteFile(String FileName)
	{
		Scanner sc=new Scanner(System.in);
		String path1=Lockedme.path;
		path1+="//"+FileName;
		File f=new File(path1);
		if(f.exists())
		{
			System.out.println("File"+FileName+" found do you realy want to delete it. Type y to delete anything else means no");
			String s=sc.nextLine();
			if(s.equalsIgnoreCase("y"))
			{
			if(f.delete())
				System.out.println("File deleted sucessfully");
			}
			else {
				System.out.println("File not deleted");
			}
		}
		else {
			
			System.out.println("File"+FileName+"not deleted as it doesnot exist");
		}
		//sc.close();
	
		
	}
	public static void Write(String FileName) throws IOException {
        Scanner sc=new Scanner(System.in);
		
		String path1=Lockedme.path;
		FileWriter fr;

		path1+="//"+FileName;
		File f=new File(path1);
		if(!f.exists()) {
			System.out.println("File donot exist do you want to make a new file press y for yes anything else is no");
			String s=sc.nextLine();
			if(s.equalsIgnoreCase("y"))
			{
				createnewFile(FileName);
			}
			else {
				System.out.println("Since you have choosen to not create a file and also file not created so you cannot write anything in it");
				return;
			}
			fr=new FileWriter(f);
		   }else {
			System.out.println("File  exists do you want to write in it or overwrite it. Type 1 to write, 2 for overwrite any thing else will not able to do anything in the file ");
		String choice=sc.nextLine();
		if(choice.equals("1"))
		{
			fr=new FileWriter(f,true);
		
		}
		else if (choice.equals("2")) {
			
			fr=new FileWriter(f,false);
			
		}
		else { System.out.println("you have given invalid input ");
		return;}
		}
		
		System.out.println(" type ** in new line to exit file writing mode");
		
		String s="";
		while(!s.equals("**"))
		{
			
			s=sc.nextLine();
			if(!s.equals("**"))
				{fr.write(s+"\n");
			    fr.flush();
				}
		
		//FileWriter
		
		}
		fr.close();
	}
	
    public static void searchFile(String Filename) {
    	String path1=Lockedme.path;
		path1+="//"+Filename;
		File f=new File(path1);
		if(f.exists())
			System.out.println("File exists ");
    	
		else System.out.println("File donot exist");
    	
    	
    	
    	
    }	
	public static void displayMenu() {
		System.out.println("***************************************");
		System.out.println(" what do you want to do");
		System.out.println("enter 1 to see all the files present in your application ");
		System.out.println("enter 2 to you want to delete a file ");
		System.out.println("enter 3 to search whether file exists");
		System.out.println("enter 4 to write and create a file");
		System.out.println("enter 5 if you want to display file");
		System.out.println("enter 6 if you want to exit");
		System.out.println("any other input is invalid");
		System.out.println("******************************************");
		
		
	}
    public static void display(String Filename) throws IOException{
    	String path1=Lockedme.path;
		path1+="//"+Filename;
    	File f=new File(path1);
    	if(f.exists()) {
    		
    	System.out.println("*****************"+Filename+"*******************");	
    		
    	FileReader fr=new FileReader(f);
    	BufferedReader br=new BufferedReader(fr);
    	String s;
    	do {
    		s=br.readLine();
    		if(s!=null)
    	System.out.println(s);
    	
    	
    	
    	}while(s!=null);
    	}
    	else {
    		System.out.println("invalid file name or file doesnot exist");
    	}
    	System.out.println("***********************************************");
    	//br.close();
    	
    }
}
