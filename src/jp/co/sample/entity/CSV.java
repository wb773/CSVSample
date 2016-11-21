package jp.co.sample.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CSV {
	
	private String[] items ;
	private Connection connection;
	
	public CSV(String row,Connection connection){
		this.items = row.split(",", 0);
		this.connection = connection;
	}
	
	
	
	public void save() throws Exception{
//		Connection connection = null;
		ResultSet resultSet = null;

		try {
			//-----------------
			// ê⁄ë±
			//-----------------
			String sql = "INSERT INTO public.ReadedCSV(" +
							"Base1, Base2, Base3, Base4, Data1, Data2, Data3, Data4)" +
							"VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			
			//DataA
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, items[0]);
			pstmt.setString(2, items[1]);
			pstmt.setString(3, items[2]);
			pstmt.setString(4, items[3]);
			pstmt.setString(5, items[4]);
			pstmt.setString(6, items[8]);
			pstmt.setString(7, items[12]);
			pstmt.setString(8, items[16]);
			int num = pstmt.executeUpdate();
			
			//DataB
			pstmt.setString(5, items[5]);
			pstmt.setString(6, items[9]);
			pstmt.setString(7, items[13]);
			pstmt.setString(8, items[17]);
			num = pstmt.executeUpdate();

			//DataC
			pstmt.setString(5, items[6]);
			pstmt.setString(6, items[10]);
			pstmt.setString(7, items[14]);
			pstmt.setString(8, items[18]);
			num = pstmt.executeUpdate();

			//DataD
			pstmt.setString(5, items[7]);
			pstmt.setString(6, items[11]);
			pstmt.setString(7, items[15]);
			pstmt.setString(8, items[19]);
			num = pstmt.executeUpdate();
			
			
		} finally {
			//ê⁄ë±ÇêÿífÇ∑ÇÈ
			if (resultSet != null) {
				resultSet.close();
			}
		}
	}

}
