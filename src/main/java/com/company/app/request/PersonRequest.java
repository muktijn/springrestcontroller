package com.company.app.request;

public class PersonRequest {
	 private int personId;
	    
	    private String firstName;
	    
	    private String lastName;
	    
	    private String middleName;
	    
	    private String gender;

		public PersonRequest(int personId, String firstName, String lastName, String middleName, String gender) {
			super();
			this.personId = personId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.middleName = middleName;
			this.gender = gender;
		}

		public PersonRequest() {
			super();
		}
		public int getPersonId() {
			return personId;
		}

		public void setPersonId(int personId) {
			this.personId = personId;
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

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

}
