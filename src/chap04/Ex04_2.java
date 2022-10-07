package chap04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex04_2 {

	public static void main(String[] args) {
		//url、user、passwordの設定
		String url = "jdbc:mysql://localhost:3306/labs";
		String user = "root";
		String password = "root";

		//JDBCの操作用
		Connection con = null;//データベース接続用
		PreparedStatement psmt = null;//SQL文実行用
		ResultSet rs = null;//結果の取得用

		String pname = "";
		int price = 0;

		String pcode = args[0];

		//起動パラメータの指定があるかの確認
		if (args.length != 1) {
			System.out.println("商品番号を指定してください");
			System.exit(1);
		}

		String sql = "SELECT product_name,unit_price FROM products " + "WHERE product_id = ?";

		try {
			//データベースへの接続
			con = DriverManager.getConnection(url, user, password);
			//PreparedStatementオブジェクトの取得
			psmt = con.prepareStatement(sql);
			//PreparedStatementオブジェクトの取得
			psmt.setString(1, pcode);
			//SELECT文の実行
			rs = psmt.executeQuery();
			//検索結果の表示
			if (rs.next()) {
				pname = rs.getString("product_name");
				price = rs.getInt("unit_price");
				System.out.println(pname + "の単価は" + price + "円です");
			} else {
				System.out.println("該当の商品はありません");
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
