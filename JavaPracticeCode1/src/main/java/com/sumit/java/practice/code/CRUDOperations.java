package com.sumit.java.practice.code;

import java.util.List;

public interface CRUDOperations {
	int addRecord(ContactValueObject collection);

	int updateRecord(ContactValueObject collection);

	int deleteRecord(long contactId);

	 List<ContactValueObject> getAllRecords();

	 ContactValueObject getContactById(long contactId);

	final String DBUrl="";
	final String DBUser="";
	final String DBPass="";
	final String DBDriver="";

}
