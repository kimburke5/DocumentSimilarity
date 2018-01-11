package ie.gmit.sw;

import java.util.Scanner;

/**
 *  this class provides user Menu
 * @author kimburke
 * @version 1.0
 * 
 *
 */

public class UI {
	
	public void show() throws InterruptedException  {
		
		// TODO Auto-generated method stub
		//menu print
		System.out.println("*** Document Comparison Service ***");
		
		String file1;
		String file2;
		Scanner console=new Scanner(System.in);
		
		// Get name of file or URL to process
		System.out.print("\nEnter File Name / URL 1: ");
		file1 = console.nextLine();
		
		System.out.print("\nEnter File Name / URL 2: ");
		file2 = console.nextLine();
		
		//calls Launcher class
		new Launcher(file1,file2, 100);
		console.close();
	}
	
	public UI() {
		//super();
		// TODO Auto-generated constructor stub
	}

}
