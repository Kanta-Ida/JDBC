package chap04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex04_3 {
	public static void main(String[] args) {
		//url、user、passwordの設定
		String url = "jdbc:mysql://localhost:3306/labs";
		String user = "root";
		String password = "root";

		//JDBCの操作用
		Connection con = null;//データベース接続用
		PreparedStatement psmt = null;//SQL文実行用
		ResultSet rs = null;//結果の取得用

		//問い合わせ結果格納用
		String pname = "";
		int volume = 0;
		String unit = "";

		//起動パラメータの指定があるかの確認
		if (args.length != 1) {
			System.out.println("担当者番号を指定してください");
			System.exit(1);
		}

		String ecode = args[0];

		String sql = "SELECT products.product_name AS product_name," + "orders.volume AS volume,"
				+ "products.unit AS unit" + " FROM products INNER JOIN orders"
				+ " ON (products.product_id = orders.product_id)"
				+ " WHERE employee_id = ?";

		/*String sql = "SELECT products.product_name,orders.volume," + "products.unit" + "FROM products,orders" +
				"WHERE products.product_id = orders.product_id" + "AND employee_id";
				*/

		try {
			//データベースへの接続
			con = DriverManager.getConnection(url, user, password);
			//PreparedStatementオブジェクトの取得
			psmt = con.prepareStatement(sql);
			//PreparedStatementオブジェクトの取得
			psmt.setString(1, ecode);
			//SELECT文の実行
			rs = psmt.executeQuery();
			//検索結果の取り出し
			while (rs.next()) {
				pname = rs.getString("product_name");
				volume = rs.getInt("volume");
				unit = rs.getString("unit");
				System.out.println(pname + "が" + volume + unit + "です");
			}

		} catch (SQLException e) {
			//データベース使用時のエラー例外クラス
			System.out.println("エラー番号:" + e.getErrorCode());
			System.out.println("説明:" + e.getMessage());
		} catch (Exception e) {
			//その他のエラー
			System.out.println("その他のエラー:" + e.getMessage());

		} finally {
			try {
				if (rs != null) {//rsのクローズ
					rs.close();
				}
				if (psmt != null) {//psmtのクローズ
					psmt.close();
				}
				if (con != null) {//conのクローズ
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("クローズエラー" + e.getMessage());
			}
		}
	}

}
