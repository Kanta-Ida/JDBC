package chap02.meta;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex02_1 {

	public static void main(String[] args) {
		//url、user、passwordの設定
		String url = "jdbc:mysql://localhost:3306/labs";
		String user = "root";
		String password = "root";

		Connection con = null;
		DatabaseMetaData dbMeta = null;

		try {
			//データベースへの接続
			con = DriverManager.getConnection(url, user, password);
			//データベース情報の取得
			dbMeta = con.getMetaData();

			System.out.println("データベース情報を表示します");
			System.out.println("データベース名:" + dbMeta.getDatabaseProductName());
			System.out.println("データベースのバージョン:" + dbMeta.getDatabaseProductVersion());
			System.out.println("ドライバ名:" + dbMeta.getDriverName());
			System.out.println("ドライバのバージョン:" + dbMeta.getDriverVersion());
			System.out.println("トランザクションのサポートの有無:" + dbMeta.supportsTransactions());
			System.out.println("JDBC URL:" + dbMeta.getURL());

		} catch (SQLException e) {
			//データベース使用時のエラー例外クラス
			System.out.println("エラー番号:" + e.getErrorCode());
			System.out.println("説明:" + e.getMessage());
		} catch (Exception e) {
			//その他のエラー
			System.out.println("その他のエラー:" + e.getMessage());

		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("クローズエラー" + e.getMessage());
			}
		}

	}

}
