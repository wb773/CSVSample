package jp.co.sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.stream.Stream;

import jp.co.sample.entity.CSV;

public class PureJavaCSVReader {
	// CSVファイルを読み込み、１行ずつリストに格納する
	private String filename = "";
	private boolean hasHeader = false;

	public PureJavaCSVReader(String filename, boolean hasHeader) {
		this.filename = filename;
		this.hasHeader = hasHeader;
	}

	public void read(Connection connection) throws SQLException {

		int skipCount = 0;
		if (hasHeader) {
			skipCount = 1;
		}

		try (Stream<String> rows = Files.lines(Paths.get(filename))) { // 自動close
			rows.skip(skipCount).forEach((final String row) -> {
				CSV c = new CSV(row, connection);
				try {
					c.save();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
