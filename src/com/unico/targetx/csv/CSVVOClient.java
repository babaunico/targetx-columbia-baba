package com.unico.targetx.csv;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class CSVVOClient {

	private static Collection<String> rowValues;
	private static Map<String, String> row;

	public static void main(String[] args) throws IOException {
		String csvInputFilePath = "resource/inputcsv.csv";
		CSVInputVOS csvInputVOS = new CSVInputVOS(csvInputFilePath);
		
		getRowForGivenIndexValue(csvInputVOS);
		
		getRowForGivenIDValue(csvInputVOS);
	}

	private static void getRowForGivenIDValue(CSVInputVOS csvInputVOS) {
		rowValues = csvInputVOS.getRowForGivenID("2");
		if(rowValues != null) {
			for (String rowValue : rowValues) {
				System.out.print(rowValue);
			}
		} else {
			System.out.println("Given ID does not exist");
		}
	}

	private static void getRowForGivenIndexValue(CSVInputVOS csvInputVOS) {
		row = csvInputVOS.getRowForGivenIndex(0);
		if(row != null) {
			for (Map.Entry<String, String> entry : row.entrySet()) {
				System.out.print(entry.getValue());
			}
			System.out.println();
		}
	}
}
