 package course1;

     import java.io.File;
     import java.io.FileWriter;
     import java.io.IOException;
     import java.util.Arrays;
     import java.util.Collections;
     import java.util.LinkedList;
     import java.util.Scanner;
     import java.util.regex.Matcher;
     import java.util.regex.Pattern;


            public class Lockedme {
	                        //This block contain standard Error message and default path.
		   static final String errorMessage = " If Some error occured please contact admin: admin@LockedMe.Com";
		   static final String Myjavapractice = "E:/";

		              // This method display menu options, application name and Developer name.
		   public static void displayMenu() {
			
			System.out.println("\t..................................");
			
			System.out.println("\tWelcome to LockedMe.com");
			
			System.out.println("\t..................................");
			
			System.out.println("\tDesigned by:- ***** Ganesh Vudugu ****** ");
			
			System.out.println("\t1. Display all Files, Folders (In Ascending Order).");
			System.out.println("\t2. Add a new file.");
			System.out.println("\t3. Delete a file.");
			System.out.println("\t4. Search a file.");
			System.out.println("\t5. Exit from Application.");
			System.out.println("\t..................................");
		    }

		  public static boolean fileNamevalidation(String ch) {
			// This method check that input choice should be only number (1-5).
			// Do not contain any character, white space or blank space.
			// input Example- abc.txt.
			// false mean pass the test
			boolean t = true;
			String pat = "^[a-zA-Z](?:[a-zA-Z0-9 ._-]*[a-zA-Z0-9])?\\.[a-zA-Z0-9_-]+$";
			Pattern p = Pattern.compile(pat);
			Matcher m = p.matcher(ch);
			if (m.matches() == true) {
				t = false;
			} else {
				System.out.println(" please enter proper file name eg abc.txt");
				t = true;
			}
			return t;
		   }

		






	                      // This method is shows all files and folders present in "Myjavapractice" in
		                    // ascending order.
		                    // As per requirement of project.
		  public static void getAllFiles() {
			try {
				File folder = new File(Myjavapractice);
				File[] listOfFiles = folder.listFiles();
				if (listOfFiles.length == 0) {
					System.out.println("No Files exist");
				} else {

					Arrays.sort(listOfFiles, Collections.reverseOrder());
					for (var l : listOfFiles) {
						System.out.println(l.getName());
					}
				}
			} catch (Exception Ex) {
				System.out.println(errorMessage);
			}

		  }

		                      //This method is sub method that is used to write in file.
		  public static void WriteToFiles(String Path) {
			   Scanner Sc = new Scanner(System.in);
			try {
				FileWriter Writer = new FileWriter(Path);

				System.out.println("Enter the Text that you want to save in file.(Press Enter key to save)");
				String In = Sc.nextLine();
				Writer.write(In);
				Writer.close();
				System.out.println("Successfully written in file.");

			} catch (Exception e) {
				System.out.println(errorMessage);
				e.printStackTrace();
			} finally {
				// Sc.close();
			}
		      }

		                              // This method is used to create new file in TXT format.
		                              // Also prevent duplicate file formation.

		public static void createFiles() throws IOException {
			try {

				Scanner obj = new Scanner(System.in);
				String fileName;

	             System.out.println("Enter the filename: ");
				fileName = obj.nextLine();
				String newpath = (Myjavapractice + "\\" + fileName);
				boolean b = fileNamevalidation(fileName);
				while (b) {
					b = false;
					createFiles();
				}
				File F1 = new File(newpath);

				if (F1.exists()) {
					System.out.println(" The given filename name already present, give new file name.");
					createFiles();
				} else {
					F1.createNewFile();
					System.out.println("File " + fileName + " created Sucessfully.");
					WriteToFiles(newpath);
				}
				// obj.close();

			} catch (Exception ex) {
				System.out.println("Some error has occcured");
			}
		        }

		                   // This method delete the given file from path.
	       public static void deleteAllFiles() {
			Scanner obj = new Scanner(System.in);
			try {
				String fileName;
				System.out.println("Enter the file name to be deleted");
				fileName = obj.nextLine();
				File file = new File(Myjavapractice + "\\" + fileName);

				if ((file.exists() == true) && (fileName != "null")) {
					file.delete();
					System.out.println("File " + fileName + " deleted SuccessFully : ");
				} else {
					System.out.println("File do not exists or you are entering space");
				}
			} catch (Exception ex) {
				System.out.println(errorMessage);
			} finally {
				// obj.close();
			}
		}

		

	                      /* This method will search the files from the directory */
		public static void searchFiles() {
			Scanner obj = new Scanner(System.in);
			try {
				String fileName;

				System.out.println("Enter the file name to be Searched");
				fileName = obj.nextLine();
				File folder = new File(Myjavapractice);
				File[] listOfFiles = folder.listFiles();
				LinkedList<String> filenames = new LinkedList<String>();
				for (var l : listOfFiles)
					filenames.add(l.getName());
				if (filenames.contains(fileName))
					System.out.println("File " + fileName + "is available at " + folder.getAbsolutePath());
				else
					System.out.println("File " + fileName + "is not available");
			} catch (Exception ex) {
				System.out.println(errorMessage);
			} finally {
				// obj.close();
			}
		       }

		     public static boolean numbervalidation(String ch) {
			// This method check that input choice is only number
			// do not contain any character, white space or blank space.
			// choice between 1 to 5 only.
			boolean t = true;
			String pat = "[1-5]";
			Pattern p = Pattern.compile(pat);
			Matcher m = p.matcher(ch);
			if (m.matches() == true) {
				t = false;
			} else {
				System.out.println("You are not entering number bewteen 1 to 5");
				t = true;
			}

			return t;
		    }

	

	                  // This method is used to repeat the options and keep main program very simple.
		    public static void loopme() {
			displayMenu();
			boolean flag = true;
			String ch = null;
			do {
				Scanner obj = new Scanner(System.in);
				System.out.println("Enter your number Choice :- ");
				ch = obj.next();
				flag = numbervalidation(ch);
			} while (flag == true);
			int cha = Integer.parseInt(ch);
			switch (cha) {
			case 1:
				getAllFiles();
				System.out.println("****************************************");
				loopme();
				break;
			case 2:
				try {
					createFiles();
				} catch (IOException e) {
					System.out.println(errorMessage);
					e.printStackTrace();
				}
				System.out.println("****************************************");
				loopme();
				break;
			case 3:
				deleteAllFiles();
				System.out.println("****************************************");
				loopme();
				break;
			case 4:
				searchFiles();
				System.out.println("****************************************");
				loopme();
				break;
			case 5:
				System.out.println("Thanks for selecting Lockme application");
				System.out.println("****************************************");
				System.exit(0);
			}
		        }

		           //This is client code(main method). As all method in this project are  public Static .
		   public static void main(String[] args) {

			try {
				loopme();
			} catch (Exception e) {
				System.out.println(errorMessage);
			}

		    }

	    }
