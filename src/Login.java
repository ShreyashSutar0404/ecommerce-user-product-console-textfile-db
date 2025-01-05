import java.util.Scanner;

public class Login {
	public static void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("^^^^^^Login Information^^^^^^^");
        System.out.println("Enter Username:");
        String userName = scan.next();
        System.out.println("Enter Password:");
        String password = scan.next();

        if (userName.equals("Shreyash") && password.equals("SHRE2004")) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Login Failed!!!");
            System.exit(0);
        }
		
	}

}
