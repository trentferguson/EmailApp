import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the firsts name of the employee: ");
        String firstName = sc.nextLine();
        System.out.print("Enter the last name of the employee: ");
        String lastName = sc.nextLine();
        System.out.println("----------------------------");

        Email email = new Email(firstName, lastName);

        System.out.println("----------------------------");
        System.out.println("Credentials for " + firstName + " " + lastName +":");
        System.out.println("Company Email Address = " + email.getEmail());
        System.out.println("Password = " + email.getPassword());
        System.out.println("----------------------------");
        System.out.println();

        System.out.print("Would you like to set your own password? [Y/N]: ");
        String input = sc.next();
        if(input.equalsIgnoreCase("y")) {
            System.out.print("Enter your new password: ");
            String newPass = sc.next();
            email.setPassword(newPass);
            System.out.println("Password has successfully been changed to: " + newPass);
        } else if(input.equalsIgnoreCase("n")) {
            System.out.println("Password will remain as the randomly generate default password.");
        }



    }
}
