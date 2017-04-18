package com.unico.targetx.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

public class CSVInputVOS {

	private File file = null;
	
	CsvPreference prefs = CsvPreference.STANDARD_PREFERENCE;
	private ICsvMapReader mapReader = null;
	private Map<String, String> row;
	private List<Map<String, String>> parsedRows;

	public CSVInputVOS(String filePath) throws IOException { 
		
		file = new File(filePath);
		if(file.exists()) {
			mapReader = new CsvMapReader(new FileReader(file), prefs);
			final String[] readHeader = mapReader.getHeader(true);
			final String[] writeHeader = new String[readHeader.length + 1];
			System.arraycopy(readHeader, 0, writeHeader, 0, readHeader.length);		
			readAndWriteRow(mapReader, readHeader);
		} else {
			System.out.println(filePath + "File Not Found");
		}
	}
	
	public void readAndWriteRow(ICsvMapReader mapReader, final String[] readHeader) throws IOException {	
		
		parsedRows = new ArrayList<Map<String, String>>();
		while( (row = mapReader.read(readHeader)) != null ) {
			parsedRows.add(row);
		}
	} 
	
	public Map<String, String> getRowForGivenIndex(int rowId) {
		
		Map<String, String> row = null;
		try {
			row = parsedRows.get(rowId);
		} catch (IndexOutOfBoundsException ae) {
			System.out.println("Given element does not exist..");
		}
		
		return row;
	}
	
	public Collection<String> getRowForGivenID(String id) {
		try {
			for(Map<String, String> parseRow : parsedRows) {
				for (Map.Entry<String, String> entry : parseRow.entrySet()) {
					if(entry.getKey().contains("ID") && (entry.getValue().contains(id))) {
						//System.out.println(parseRow.values());
						return parseRow.values();
					}
				}
			}
		} catch (NullPointerException ae) {
			System.out.println("Given element does not exist..");
		}
		
		return null;
	}
}
