package com.sumit.java.practice.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRUDOperationsImplementation implements CRUDOperations {
	private Connection connection;
	private ResultSet resultset;
	private Map<String, String> connectionMap;
	
	public  CRUDOperationsImplementation getConnection() {
		CRUDOperationsImplementation crudImpl= new CRUDOperationsImplementation();
		crudImpl.loadConnectionFromResource();
		return crudImpl;
	}

	public int addRecord(ContactValueObject collection) {
		return 0;

	}

	public int updateRecord(ContactValueObject collection) {
		return 0;

	}

	public int deleteRecord(long contactId) {
		return 0;

	}

	public List<ContactValueObject> getAllRecords() {
		Statement allrecords;
		try {
			allrecords = connection.createStatement();
			resultset= allrecords.executeQuery("Select * from contacts"); 
		} catch (SQLException e) {
		e.printStackTrace();
		}
		
		return processResults(resultset);

	}

	public ContactValueObject getContactById(long contactId) {
		return null;

	}
	private List<ContactValueObject> processResults(ResultSet resultSet){
		List<ContactValueObject> results= new ArrayList<ContactValueObject>();
		try {
			while(resultSet.next()) {
				   ContactValueObject contact = new ContactValueObject();      
				   contact.setContactId(resultSet.getLong("contactId"));
				   results.add(contact);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return results;
	}

	private void loadConnectionFromResource() {
		try {
			File connectionFile = new File(getClass().getClassLoader().getResource("connections.properties").getFile());
			BufferedReader connectionsProperty = new BufferedReader(new FileReader(connectionFile));
			String line;
			connectionMap = new HashMap<String, String>();
			while ((line = connectionsProperty.readLine()) != null) {
				String[] splitLine = line.split("=");
				connectionMap.put(splitLine[0], splitLine[1]);
			}
			createConnection(connectionMap);
			connectionsProperty.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	private void createConnection(Map<String, String> connectionMap) {
		try {

			if (connection == null) {
				//Class.forName(connectionMap.get(DBDriver));
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(DBUrl, connectionMap.get(DBUser), connectionMap.get(DBPass));
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
