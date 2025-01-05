package main.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class UserManagement {
	public static void userManagement() throws IOException {
		Scanner scan = new Scanner(System.in);
		ArrayList<User> userList = new ArrayList<>();
		String filePath = "C:\\java\\Day_24_Read_Write_Product_User_txtFilee\\src\\main\\User\\User.txt";
		File file = new File(filePath);
		
		if(file.exists()) {
			FileReader filereader = new FileReader(file);
			BufferedReader br = new BufferedReader(filereader);
			String line;
			while((line=br.readLine())!=null) {
				String userArray[] = line.split(",");
				if(userArray.length == 3) {
					User user = new User();
					user.userName = userArray[0];
					user.email = userArray[1];
					user.password = userArray[2];
					userList.add(user);
				}
				
			}br.close();
			filereader.close();	
		}
		while(true) {
			System.out.println("What would you like to do!");
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Search User");
            System.out.println("4. Delete User");
            System.out.println("5. Print Saved users");
            System.out.println("9. Quit User Management");
            int option = scan.nextInt();
            
            if(option == 1) {
            	User user = new User();
            	System.out.println("Add User details:");
            	System.out.println("Enter UserName :");
            	user.userName = scan.next();
            	System.out.println("Enter email ID :");
            	user.email = scan.next();
            	System.out.println("Enter The Password :");
            	user.password = scan.next();
            	userList.add(user);
                
            }else if(option == 2) {
            	System.out.println("Enter Username to update :");
            	String updateName = scan.next();
            	boolean found = false;
            	for(User user:userList) {
            		if(user.userName.equals(updateName)) {
            			System.out.println("Enter new email ID :");
            			user.email = scan.next();
            			System.out.println("Enter new password :");
            			user.password = scan.next();
            			found = true;
            			System.out.println("User Updated Successfully");
            			break;
            		}
            	}
            }else if(option == 3) {
            	System.out.println("Enter User to search :");
            	String searchName = scan.next();
            	boolean found = false;
            	for(User user:userList) {
            		if(user.userName.equals(searchName)) {
            			System.out.println("User Found:");
                        System.out.println("Name: " + user.userName);
                        System.out.println("Price: " + user.email);
                        System.out.println("Quantity: " + user.password);
                        found = true;
                        break;	
            		}
            	}if(!found) {
            		System.out.println("Product Not Found!!!");
            	}
            	
            }else if(option == 4) {
            	System.out.println("Enter User name to remove :");
            	String deleteName = scan.next();
            	boolean found = false;
            	
            	for(int i=0;i<userList.size();i=i+1) {
            		User user = userList.get(i);
            		if(user.userName.equals(deleteName)) {
            			userList.remove(i);
            			found = true;
            			System.out.println("User Removed Successfully!");
            			break;
            		}
            	}if(!found) {
            		System.out.println("User not Found!!");
            	}
            }else if(option == 5) {
            	for(User user:userList) {
            		System.out.println(""+user.userName);
            		System.out.println(""+user.email);
            		System.out.println(""+user.password);
            		System.out.println("------------------------------------");
            	}
            }else if(option == 9) {
            	System.out.println("Quitting the User Panel:");
            	FileWriter fileWriter = new FileWriter(file);
            	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            	
            	for(User user :userList) {
            		bufferedWriter.write(user.userName+","+user.email+","+user.password);
            		bufferedWriter.newLine();
            	}
            	bufferedWriter.close();
            	fileWriter.close();
            	break;
            }else {
            	System.out.println("Invalid option selected!!!");
            }
		}
		
		
		
	}

}
