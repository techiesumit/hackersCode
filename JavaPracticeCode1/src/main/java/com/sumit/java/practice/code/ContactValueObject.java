package com.sumit.java.practice.code;

public class ContactValueObject {
	private long contactId;
	private String firstName;
	private String lastName;
	private String comapny;
	private String  contactGroup;
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
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
	public String getComapny() {
		return comapny;
	}
	public void setComapny(String comapny) {
		this.comapny = comapny;
	}
	
	
	public String getContactGroup() {
		return contactGroup;
	}
	public void setContactGroup(String contactGroup) {
		this.contactGroup = contactGroup;
	}
	@Override
	public String toString() {
		return "ContactValueObject [contactId=" + contactId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", comapny=" + comapny + ", contactGroup=" + contactGroup + "]";
	}
	

}
