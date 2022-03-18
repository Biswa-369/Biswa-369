//import mypackage.*;
import java.io.*;
import java.util.*;

class LockedMe {
	
	static final String projectfilespath = "D:\\project";
	static final String errorMessage = "Some error occured. Please contact : admin@lockedme.com";

	public static void main(String[] args) {
	
		Scanner obj = new Scanner(System.in);
		int ch;
		
		do
		{
			displayMenu();
			System.out.println("Enter your choice:");
			ch=Integer.parseInt(obj.nextLine());
			
			switch(ch)
			{
				case 1:
					getAllFiles();
					break;
				case 2:
					createFiles();
					break;
				case 3:
					deleteFiles();
				break;
					case 4:
					searchFiles();
					break;
				case 5:
					System.exit(0);
				break;
					default:System.out.println("Invalid Option");
					break;
			}
			
		}
		while(ch>0);
		obj.close();
	}
	
	public static void displayMenu()
	{
		System.out.println("***************************************************************************");
		System.out.println("\t\tWelcome to Lockedme.com");
		System.out.println("\t\t\tDesigned By");
		System.out.println("\t\tMr. Biswaranjan Dixit");
		System.out.println("***************************************************************************");
		System.out.println("\t\t1. Display all the files");
		System.out.println("\t\t2. Add a new file");
		System.out.println("\t\t3. Delete a file");
		System.out.println("\t\t4. Search a file");
		System.out.println("\t\t5. EXIT");
	}
	
	// running 
	public static void getAllFiles()
	{
		try
		{
		    File file = new File(projectfilespath);
		    
		    String[] fileList = file.list();		
		    for(String str : fileList)
		    {
		      System.out.println(str);
		    }
	  	}
		catch(Exception Ex)
	  	{
			System.out.println(errorMessage);
	  	}
	}


	// running 
	public static void createFiles() 
	{
		try
		{
			Scanner obj = new Scanner(System.in);			
			String fileName;
			
			System.out.println("Enter file name:");
			fileName = obj.nextLine();
			
			int linesCount;
			System.out.println("Enter how many lines in the file:");
			linesCount=Integer.parseInt(obj.nextLine());
			
			FileWriter myWriter = new FileWriter(projectfilespath+ "\\"+ fileName);
			
			for(int i=0;i<linesCount;i++)
			{
				System.out.println("Enter the file line");
				myWriter.write(obj.nextLine()+"\n");
			}
			
			System.out.println("File Created Successfully");
			myWriter.close();
		
		}
	catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
	}
	
	
	public static void deleteFiles()
	{
	   Scanner obj = new Scanner(System.in);		
	   try
	   {
	        String fileName;
	
	System.out.println("Enter the file name to be deleted:");
		
		fileName = obj.nextLine();
	
		File file = new File(projectfilespath+ "\\"+ fileName);
	
	        if(file.exists())
	        {
		file.delete(); 
		System.out.println("File deleted successfully : "+fileName);
	        }
	        else
		System.out.println("File do not exist");
	   }	
	catch(Exception Ex)
	   {
		System.out.println(errorMessage);
	   }
	
	}

	// running 
	public static void searchFiles()
	{
		Scanner obj = new Scanner(System.in);
		
		   try
		   {
		        String fileName;		
				System.out.println("Enter the file name to be searched:");		
				fileName = obj.nextLine();			
			    File folder = new File(projectfilespath);
			    
				File dir = new File(projectfilespath);
				String[] children = dir.list();
				
				if (children == null)
				{
					System.out.println("does not exist");
				}
				else
				{
					for (int i = 0; i < children.length; i++)
					{
						String filename = children[i];
						System.out.println(filename + " File Found");
					}
				}
									
			   
		
		   }	
		catch(Exception Ex)
		   {
			System.out.println(errorMessage);
		   }
	}
	
}
