package com.unico.targetx.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class CSVColumnMapping {

	private List<CSVDefinitionVO> csvDefVOs;
	private String columnName = null;
	private int start_Index;
	private int end_Index;
	private String csvdefFile = null;
	private static final String START_INDEX = "Start";
	private static final String END_INDEX = "End";
	private static final String COLUMN_NAME = "Column";
	CSVReader csvReader;
	LinkedHashMap<String,List<Integer>> strlenMap = new LinkedHashMap<>();

	public void parseCSVToBeanList() throws IOException {
		
		HeaderColumnNameTranslateMappingStrategy<CSVDefinitionVO> beanStrategy 
		= new HeaderColumnNameTranslateMappingStrategy<CSVDefinitionVO>();
		beanStrategy.setType(CSVDefinitionVO.class);
		
		Map<String, String> columnMapping = new HashMap<String, String>();
		columnMapping.put(COLUMN_NAME, "column");
		columnMapping.put(START_INDEX, "start");
		columnMapping.put(END_INDEX, "end");
		beanStrategy.setColumnMapping(columnMapping);
		
		CsvToBean<CSVDefinitionVO> csvToBean = new CsvToBean<CSVDefinitionVO>();
		
		csvdefFile = "resource/csvdef.csv";
		File file = new File(csvdefFile);
		
		if(file.exists()) {
			csvReader = new CSVReader(new FileReader(file));
			csvDefVOs = csvToBean.parse(beanStrategy, csvReader);
			for (Iterator iterator = csvDefVOs.iterator(); iterator.hasNext();) {
				CSVDefinitionVO csvDefinitionVO = (CSVDefinitionVO) iterator.next();
				columnName = csvDefinitionVO.getColumn(); 
				start_Index = Integer.parseInt(csvDefinitionVO.getStart()); 
				end_Index =  Integer.parseInt(csvDefinitionVO.getEnd());
				
				List<Integer> list=new ArrayList<>();			
				list.add(start_Index);
				list.add(end_Index);
				list.add(end_Index - start_Index + 1);
				strlenMap.put(columnName, list);
			}
		} else {
			System.out.println("File Not Found");
		}
	}
	
	public String getCSVDefByColumnName(String columnName) {
		for(Map.Entry<String, List<Integer>> entry : strlenMap.entrySet()) {
            String key = entry.getKey();
            List<Integer> values = entry.getValue();
            
            if(key.contains(columnName)) {
            	return "Definition of "+ columnName + " :  "+ values;
            }
		}
		
		return null;
	}
	
	public String getStringLength(String columnName) {
		for(Map.Entry<String, List<Integer>> entry : strlenMap.entrySet()) {
			String key = entry.getKey();
			List<Integer> values = entry.getValue();
			if(key.equals(columnName)) {
				return "Length of " + columnName + " : " + values.get(2);
			}
		}
		
		return null;
	}
}
