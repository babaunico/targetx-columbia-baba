package com.unico.targetx.csv;

import java.io.IOException;

public class CSVColumnMappingClient {

	public static void main(String[] args) throws IOException {
		String fieldDefinitions;
		
		CSVColumnMapping columnMapping = new CSVColumnMapping();
		columnMapping.parseCSVToBeanList();
		fieldDefinitions = columnMapping.getCSVDefByColumnName("State");
		System.out.println(fieldDefinitions);
		String fieldLength = columnMapping.getStringLength("ID");
		System.out.println(fieldLength);
	}
}
