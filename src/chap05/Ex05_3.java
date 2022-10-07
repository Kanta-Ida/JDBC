package chap05;

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

		boolean hasErrors = false;
		int cnt = 0;

		//起動パラメータがあるかの確認
		if (args.length != 2) {
			System.err.println("削除したい担当者番号を2つ指定してください");
			System.exit(1);
		}

		String ecode1 = args[0];
		String ecode2 = args[1];

		//実行するsql文
		String sql = "DELETE FROM employees" + " WHERE employee_id = ?";

		try {
			//データベースへの接続
			con = DriverManager.getConnection(url, user, password);
			//手動コミットモードに設定
			con.setAutoCommit(false);
			//PreparedStatementオブジェクトの取得
			psmt = con.prepareStatement(sql);
			//1人目の処理
			psmt.setString(1, ecode1);
			//DELETE文の実行
			cnt = psmt.executeUpdate();

			if (cnt != 1) {
				hasErrors = true;
			}
			//2人目の処理
			psmt.setString(1, ecode2);
			//DELETE文の実行
			cnt = psmt.executeUpdate();

			if (cnt != 1) {
				hasErrors = true;
			}
			if (!hasErrors) {
				con.commit();
				System.out.println("2件削除しました");
			} else {
				con.rollback();
				System.out.println("担当者番号を確認してください");
			}

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
