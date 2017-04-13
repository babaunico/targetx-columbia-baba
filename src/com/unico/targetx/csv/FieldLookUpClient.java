package com.unico.targetx.csv;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class FieldLookUpClient {

	public static void main(String[] args) throws IOException {
		
		List<Integer> fieldDefinitions;
		int stringLength;
		
		final Logger LOGGER = Logger.getLogger(FieldLookUpClient.class.getName());
		
		FieldLookup fieldLookupObj = FieldLookup.getInstance();
		
		fieldDefinitions = fieldLookupObj.getCSVDefByColumnName("ID");
		//LOGGER.info(fieldDefinitions.toString());
		System.out.println(fieldDefinitions);
		
		stringLength = fieldLookupObj.getFieldLength("First_Name");
		//LOGGER.info(String.valueOf(stringLength));
		System.out.println(stringLength);		
	}
}
