package com.unico.targetx.csv;

import java.io.IOException;
import java.util.Map;

public class CSVVOClient {

	public static void main(String[] args) throws IOException {
		String csvInputFilePath = "resource/inputcsv.csv";
		
		CSVInputVOS csvInputVOS = new CSVInputVOS(csvInputFilePath);
		
		Map<String, String> row = csvInputVOS.getRowForGivenId(7);
		if(row != null) {
			for (Map.Entry<String, String> entry : row.entrySet()) {
				System.out.print(entry.getValue());
			}
			System.out.println();
		}
	}
}
