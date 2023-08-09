package com.crm.vtger.practice;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;



public class Fetch {
	
	public static void main(String[] args) throws Throwable {
		String cell[];
		try {
			//To read the data from csv file
			FileReader fr=new FileReader("./src/test/resources/data.csv");
			CSVReader reader=new CSVReader(fr);
			
			//navigate to each cell data
			while((cell=reader.readNext())!=null) {
				String keyword = cell[1];
				System.out.println(keyword);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
