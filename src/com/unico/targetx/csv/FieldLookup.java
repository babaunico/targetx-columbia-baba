package com.unico.targetx.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

public class FieldLookup {

	private static FieldLookup instance;
	
	private String csvdefFile = null;
	private static final String START_INDEX = "Start"; 
	private static final String END_INDEX = "End";
	private CsvPreference prefs = CsvPreference.STANDARD_PREFERENCE;
	LinkedHashMap<String,List<Integer>> strlenMap = new LinkedHashMap<>();
	ICsvMapReader mapReader = null;
	
	private FieldLookup() throws IOException {	
		
		csvdefFile = "resource/csvdef1.csv";
		File file = new File(csvdefFile);
		
		if(file.exists()) {
			mapReader = new CsvMapReader(new FileReader(file), prefs);
			final String[] readHeader = mapReader.getHeader(true);
			final String[] writeHeader = new String[readHeader.length + 1];
			System.arraycopy(readHeader, 0, writeHeader, 0, readHeader.length);		
			createMapForFields(mapReader, readHeader, strlenMap);
		} else {
			System.out.println("File Not Found");
		}
	}
	
	public static FieldLookup getInstance() throws IOException {
		
		if(instance == null) {
			instance = new FieldLookup();
		}
		
		return instance;
	}
	
	public void createMapForFields(ICsvMapReader mapReader, final String[] readHeader, 
			LinkedHashMap<String, List<Integer>> strlenMap) throws IOException {
		
		Map<String, String> row;
		String columnName;
		
		while( (row = mapReader.read(readHeader)) != null ) {
			List<Integer> list=new ArrayList<>();
			columnName = row.values().iterator().next();
			
			Iterator entries = row.entrySet().iterator();
			
			int start = Integer.parseInt(row.get(START_INDEX));
			int end = Integer.parseInt(row.get(END_INDEX));
			
			list.add(start);
			list.add(end);
			list.add(end - start + 1);
			strlenMap.put(columnName, list);
		}
	}
	
	public List<Integer> getCSVDefByColumnName(String columnName) {
		for(Map.Entry<String, List<Integer>> entry : strlenMap.entrySet()) {
            String key = entry.getKey();
            List<Integer> values = entry.getValue();
            
            if(key.contains(columnName)) {
            	return values;
            }
		}
		
		return null;
	}
	
	public int getFieldLength(String columnName) {
		for(Map.Entry<String, List<Integer>> entry : strlenMap.entrySet()) {
			String key = entry.getKey();
			List<Integer> values = entry.getValue();
			if(key.equals(columnName)) {
				return values.get(2);
			}
		}
		
		return 0;
	}
}
