package appendixB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

	private Connection getConnection() throws SQLException {

		//url、user、passwordの設定
		String url = "jdbc:mysql://localhost:3306/labs";
		String user = "root";
		String password = "root";
		return DriverManager.getConnection(url, user, password);
	}

	public int updateEmployee(Employee employee) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int cnt = 0;
		try {
			//Connectionのオブジェクトを取得
			conn = getConnection();
			//実行するSQL文の指定
			String sql = "UPDATE employees SET employee_name = ?" + " WHERE employee_id = ?";
			//PreparedStatementオブジェクトの取得
			pstm = conn.prepareStatement(sql);
			//SQLのパラメータに商品番号を設定
			pstm.setString(1, employee.getEmployeeName());
			pstm.setString(2, employee.getEmployeeId());
			//テーブルを更新するSQLを発行
			cnt = pstm.executeUpdate();
			return cnt;

		} catch (SQLException e) {
			//データベース使用時のエラー例外クラス
			System.out.println("エラー番号:" + e.getErrorCode());
			System.out.println("説明:" + e.getMessage());
			return 0;
		} finally {
			try {
				if (pstm != null) {//pstmのクローズ
					pstm.close();
				}
				if (conn != null) {//connのクローズ
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("クローズエラー" + e.getMessage());
			}
		}
	}

}
