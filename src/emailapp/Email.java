package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    //CONSTRUCTOR TO RECEIVE THE FIRST NAME AND LAST NAME
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.print("Email created: "+this.firstName+" "+this.lastName);

        //Call a method asking for the department - return the department
        this.department = setDepartment();
        //System.out.println("Department "+ this.department);
        
        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        //System.out.println("Your email is: " + email);
    }

    //ASK FOR THE RANDOM PASSWORD
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\no for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        }else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }
    //GENERATE A RANDOM PASSWORD
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
        char[] password = new char[length];
        for(int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String (password);
    }

    //SET THE MAILBOX CAPACITY
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //SET THE ALTERNATIVE EMAIL
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //CHANGE THE PASSWORD
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() {
        return password;
    }
    public String showInfo() {
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailBox Capacity: " + mailboxCapacity + "mb";
    }
}
