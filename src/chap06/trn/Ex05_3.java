package chap06.trn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex05_3 {

	public static void main(String[] args) {

		//url、user、passwordの設定
		String url = "jdbc:mysql://localhost:3306/labs";
		String user = "root";
		String password = "root";

		//JDBCの操作用
		Connection con = null;//データベース接続用
		PreparedStatement psmt = null;//SQL文実行用

		//起動パラメータがあるかの確認
		if (args.length != 1) {
			System.err.println("削除したい担当者番号を指定してください");
			System.exit(1);
		}

		String ecode = args[0];

		String sql = "DELETE FROM employees" + " WHERE employee_id = ?";

		try {
			//データベースへの接続
			con = DriverManager.getConnection(url, user, password);
			//PreparedStatementオブジェクトの取得
			psmt = con.prepareStatement(sql);
			//SQLのパラメータに担当者名を指定
			psmt.setString(1, ecode);
			//DELETE文の実行
			int cnt = psmt.executeUpdate();

			if (cnt == 1) {
				System.out.println("データを削除しました");
			} else {
				System.out.println("担当者番号を確認してください");
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
