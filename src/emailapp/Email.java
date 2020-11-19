package emailapp;

import java.util.Random;
import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private String emailAddress;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aoycompany.com";

    // Constructors
    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        // Call method asking for department - return department
        this.department = setDepartment();

        // Call method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is :" + this.password);

        // Combine elements to generate email
        emailAddress = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department

    private String setDepartment() {
        System.out.print("New worker: " + firstname + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else { return ""; }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$";
        char[] passwordChar = new char[length];
        Random r = new Random();
        for (int i=0; i<length; i++ ) {
            int rand = r.nextInt() * passwordSet.length();
            passwordChar[i] = passwordSet.charAt(rand);
        }
        return new String(passwordChar);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }

    public String getAlternateEmail() { return  alternateEmail; }

    public String getPassword() { return password; }

    public String showInfo() {
        return "DISPLAY NAME: " + firstname + " " + lastname +
                "\nCOMPANY EMAIL: " + emailAddress +
                "\nMAILBOX CAPACITY: " + mailboxCapacity;
    }
}
