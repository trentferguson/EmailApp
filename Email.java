import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private int defaultPasswordLength = 20;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = generatePassword(defaultPasswordLength);
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + ".gaig.com";
    }

    private String setDepartment() {
        System.out.print("Enter the department:\n [1] Sales \n [2] Development \n [3] IT \n [4] Human Resources \n [0] None\n");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if(input == 1) {return "sales";}
            else if(input == 2) {return "dev"; }
            else if(input == 3) {return "it";}
            else if(input == 4) {return  "hr";}
            else {return"";}

    }

    private String generatePassword(int length) {

        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*";
        char[] password = new char[length];

        for(int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }

        return new String(password);


    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


