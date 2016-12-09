package my.training.site.model.student;

import javax.validation.constraints.*;

public class Student {
	private int id;
	
	@Size(min = 3, max = 20, message = "count of characters must be between 3 and 20")
	@Pattern(regexp ="[A-Za-zА-Яа-я]++", message = "Illegal characters were found")
	@NotNull(message = "This field could not be empty")
	private String firstName;
	
	@Size(min = 3, max = 20, message = "count of characters must be between 3 and 20")
	@Pattern(regexp ="[A-Za-zА-Яа-я]++", message = "Illegal characters were found")
	@NotNull(message = "This field could not be empty")
	private String lastName;
	

	@Pattern(regexp = "^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+(\\.[(a-zA-z)]{2,3}){1,2}$",
			message = "Invalid email address")
	@NotNull(message = "This field could not be empty")
	private String email;
	
	public Student(){
		
	}



	public Student(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	

	public Student(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
