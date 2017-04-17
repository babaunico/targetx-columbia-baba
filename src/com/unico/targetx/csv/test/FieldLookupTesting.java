package com.unico.targetx.csv.test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.unico.targetx.csv.FieldLookup;

//import static org.junit.Assert.assertThat;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.*;

//import java.io.IOException;
//import java.util.List;

//import org.junit.Test;

//import com.unico.columbia.design.pattern.FieldLookup;

public class FieldLookupTesting {
	
	/*List<Integer> expectedList;
	List<Integer> actualList;
	
	FieldLookup fieldLookupObj=null;
	 
	@Test
	public void test_id_Length() throws IOException {
		fieldLookupObj=FieldLookup.getInstance();
		int idLength = fieldLookupObj.getStringLength("ID");
		assertEquals(2, idLength);
	 }
	
	
	@Test
	public void test_id_definition() throws IOException {
		fieldLookupObj=FieldLookup.getInstance();
		expectedList = Arrays.asList(0, 1, 2);
		actualList = fieldLookupObj.getCSVDefByColumnName("ID");
		assertEquals(expectedList, actualList);
	}*/
	
	
	List<Integer> listValues=null;
	FieldLookup fl=null;
	int val;
	
	@Test
	public  void findColumn() throws IOException {
		
		fl=FieldLookup.getInstance();
		
		val=fl.getFieldLength("ID");
		assertNotSame(val,0);
	}
	
	
	int columnLength;
	
	@Test
	public void ColumnLength() throws IOException {
		
		fl=FieldLookup.getInstance();
		
		columnLength=fl.getFieldLength("ID");
		assertEquals(2,columnLength);
	}
	
	
	int startIndex;
	
	@Test
	public void columnStartIndex() throws IOException {
		fl=FieldLookup.getInstance();
		
		listValues=fl.getCSVDefByColumnName("ID");
			
		startIndex=listValues.get(0);
		assertEquals(0,startIndex);
	}
	
	
	int endIndex;
	
	@Test
	public void columnEndIndex() throws IOException {
		fl=FieldLookup.getInstance();
		
		listValues=fl.getCSVDefByColumnName("ID");
		
		endIndex=listValues.get(1);
		assertEquals(1,endIndex);
	}
	
	
	/*List<Integer> listValues=null;
	FieldLookup fl=null;
	
	String columns[]={"ID","First_Name","Last_Name","Age","Salary","Language","Street1","Street2","City","State","Country"};
	
	int lengths[]={2,10,10,3,6,10,10,10,10,2,15};
	
	int startIndexes[]={0,2,12,22,25,31,41,51,61,71,73};
	
	int endIndexes[]={1,11,21,24,30,40,0,60,70,72,87};
	
	
	@Test
	public  void findColumn() throws IOException {
		fl=FieldLookup.getInstance();
		int val;
		
		System.out.println("\n\nfind column : ");
		
		for(int i=0;i<columns.length;i++){
		
			val=fl.getStringLength(columns[i]);
			assertNotSame(val,0);
			System.out.print((i+1)+" ");
		}
	}
	
	@Test
	public void ColumnLength() throws IOException {
		
		fl=FieldLookup.getInstance();
		int columnLength;
		
		System.out.println("\n\nfind column length: ");
		
		for(int i=0;i<columns.length;i++){
			columnLength=fl.getStringLength(columns[i]);
			
			assertEquals(lengths[i],columnLength);
			System.out.print((i+1)+" ");
		}
	}
	
	@Test
	public void columnStartIndex() throws IOException {
		fl=FieldLookup.getInstance();
		int startIndex;
		
		System.out.println("\nfind start index: ");
		
		for(int i=0;i<columns.length;i++){
			listValues=fl.getCSVDefByColumnName(columns[i]);
			
			startIndex=listValues.get(0);
			assertEquals(startIndexes[i],startIndex);
			System.out.print((i+1)+" ");
		}
	}
	
	@Test
	public void columnEndIndex() throws IOException {
		fl=FieldLookup.getInstance();
		int endIndex;
		
		System.out.println("\n\nfind end index: ");
		
		for(int i=0;i<columns.length;i++){
			listValues=fl.getCSVDefByColumnName(columns[i]);
			
			endIndex=listValues.get(1);
			assertEquals(endIndexes[i],endIndex);
			System.out.print((i+1)+" ");
		}
	}*/
}
