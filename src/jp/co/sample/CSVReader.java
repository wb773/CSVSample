package jp.co.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class CSVReader {

	public static void main(String[] args) throws SQLException {

		// �J�n����
		Calendar start = Calendar.getInstance();

		// TODO Auto-generated method stub
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle("sampleprop");
			System.out.println(bundle.getString("filename"));

			PureJavaCSVReader reader = new PureJavaCSVReader(bundle.getString("filename"), true);

			Connection connection = null;
			try {
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sampleDatabase", // "jdbc:postgresql://[�ꏊ(Domain)]:[�|�[�g�ԍ�]/[DB��]"
						"role_sample", // ���O�C�����[��
						"password"); // �p�X���[�h

				reader.read(connection);
			} finally {

				if (connection != null) {
					connection.close();
				}
			}

		} catch (MissingResourceException e) {
			e.printStackTrace();
			return;
		}
		Calendar end = Calendar.getInstance();

		System.out.println(end.getTimeInMillis() - start.getTimeInMillis());
	}
}
