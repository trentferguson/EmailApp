import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) throws IOException {

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
        System.out.println("\n----------------------------");
        System.out.println();

        System.out.print("Would you like to set your own password? [Y/N]: ");
        String input = sc.next();
        if(input.equalsIgnoreCase("y")) {
            System.out.print("Enter your new password: ");
            String newPass = sc.next();
            email.setPassword(newPass);
            System.out.println("Password has successfully been changed to: " + newPass);
        } else if(input.equalsIgnoreCase("n")) {
            System.out.println("\nPassword will remain as the randomly generate default password.");
        }

        try {
            FileWriter myWriter = new FileWriter("EmailDB.txt", true);
            myWriter.write(email.getEmail());
            myWriter.write("\n");
            myWriter.write(email.getPassword() + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while to trying to write to file.");
            e.printStackTrace();
        }

        /*
        Path filePath = Path.of("/Users/Trent/Documents/repos/ProjectEmailApp/data/EmailDB.txt");
        Files.writeString(filePath, email.getEmail());
        */


        //ability to  print out every email/password in the database
        System.out.println("\n----------------------------\n");
        System.out.print("Would you like to print out a list of all emails and passwords? [Y/N]: ");
        input = sc.next();
        System.out.println("\n----------------------------");
        if(input.equalsIgnoreCase("y")) {
            try {
                Scanner scanner = new Scanner(new File("EmailDB.txt"));

                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println();
            System.out.println("Thank you for using the Great American Company Email Creation Tool (GACECT)!");
            System.out.println("\n----------------------------");
        }


    }
}
