package com.sumit.java.practice.code.executor;

import java.util.List;

import com.sumit.java.practice.code.CRUDOperations;
import com.sumit.java.practice.code.CRUDOperationsImplementation;
import com.sumit.java.practice.code.ContactValueObject;

public class Executor {
	 CRUDOperations crudOperations;

	public static void main(String[] args) {
		Executor executor= new Executor();
		executor.establishConnection();
		executor.getAllContacts();

	}
	private void establishConnection() {
		crudOperations = new CRUDOperationsImplementation().getConnection();
		
	}
	private void getAllContacts() {

		showContact(crudOperations.getAllRecords());
		 

	}
	private void showContact(List<ContactValueObject> contacts) {
		for(ContactValueObject contact: contacts) {
			System.out.println(contact.toString());
		}
		
	}

}
