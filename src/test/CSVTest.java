package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import jp.co.sample.entity.CSV;

public class CSVTest {

	@Test
	public void testSaveCSV() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sampleDatabase", // "jdbc:postgresql://[場所(Domain)]:[ポート番号]/[DB名]"
					"role_sample", // ログインロール
					"password"); // パスワード
			CSV c = new CSV(
					"Base1_00001,Base2_00001,Base3_00001,Base4_00001,DataA1_00001,DataA2_00001,DataA3_00001,DataA4_00001,DataB1_00001,DataB2_00001,DataB3_00001,DataB4_00001,DataC1_00001,DataC2_00001,DataC3_00001,DataC4_00001,DataD1_00001,DataD2_00001,DataD3_00001,DataD4_00001",
					connection);
			try {
				c.save();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {

			if (connection != null) {
				connection.close();
			}
		}

	}

}
