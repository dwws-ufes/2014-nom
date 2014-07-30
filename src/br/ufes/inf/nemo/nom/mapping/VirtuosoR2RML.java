package br.ufes.inf.nemo.nom.mapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VirtuosoR2RML {

	public ArrayList<String> createMapping(ArrayList<String> mapList, String fileName){
		
		try {
			System.out.println(fileName);
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str = "";
			while (in.ready()) {
				str = str + in.readLine() + "\n";
				
				if(str.contains("<end-command>")){
					str = str.replace("<end-command>", "");
					mapList.add(str);
					str = "";
				}
										
			}
			in.close();
		} catch (IOException e) {
		}

		return mapList;
	}
	
	public void executeMapping(ArrayList<String> mapList, Connection connection){
		
		for(String query : mapList){
			
			System.out.println(query);
			System.out.println("================================================");
			
			Statement st;
			try {
				st = connection.createStatement();	
				st.executeQuery(query);
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}
