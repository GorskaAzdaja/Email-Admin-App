package emailAdmin;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String fullName;
	private String password;
	private String department;
	private String email;
	private String alternateEmail;
	private String company = "test";
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	
//	Constructor for first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
//		Call a method for department
		this.department = setDepartment();

		
//		Call a method to generate a password
		this.password = randomPassword(defaultPasswordLength);
		
//		Create the email template
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + company.toLowerCase() + ".com";
	}
	
//	Define department
	private String setDepartment() {
		System.out.print("Department codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int tempDept = in.nextInt();
		in.close();
		
		if(tempDept == 1) {
			return "sales";
		} else if (tempDept == 2) {
			return "dev";
		} else if (tempDept == 3) {
			return "acct";
		} else {
			return "";
		}
	}
	
	
//	Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!&*%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
//	Set the mailbox capacity
	public void setMailCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	public int getMailCapacity() {
		return mailboxCapacity;
	}
	
//	Set the alternate mail
	public void setAltEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public String getAltEmail() {
		return alternateEmail;
	}
	
//	Change the password
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setFullName(String firstName, String lastName) {
		this.fullName = firstName + " " + lastName;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String showInformation() {
		return "\n\nYOUR NAME IS: " + fullName + "\n" +
				"YOUR EMAIL: " + email + "\n" +
				"YOUR DEPARTMENT IS: " + department + "\n" +
				"MAILBOX CAPACITY: " + mailboxCapacity + "\n" +
				"YOUR CURRENT PASSWORD: " + password;
	}
}
