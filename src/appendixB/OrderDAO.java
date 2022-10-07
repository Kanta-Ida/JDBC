package appendixB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
	private Connection getConnection() throws SQLException {

		//url、user、passwordの設定
		String url = "jdbc:mysql://localhost:3306/labs";
		String user = "root";
		String password = "root";
		return DriverManager.getConnection(url, user, password);
	}

	public List<Order> getOrderListByEmployeeId(String employeeId) {
		Connection con = null;//データベース接続用
		PreparedStatement psmt = null;//SQL文実行用
		ResultSet rs = null;//結果の取得用
		try {
			//Connectionオブジェクトを取得
			con = getConnection();
			//実行SQL文の指定
			String sql = "SELECT" + " orders.order_id AS order_id," + " orders.product_id As product_id," +
					" products.product_name As product_name," + " products.unit AS unit," + " orders.volume AS volume,"
					+ " orders.employee_id AS employee_id" + " FROM orders INNER JOIN products"
					+ " ON(orders.product_id=products.product_id)" + " Where orders.employee_id = ?";
			//PreparedStatementオブジェクトの取得
			psmt = con.prepareStatement(sql);
			//SQLのパラメータに商品番号を設定
			psmt.setString(1, employeeId);
			//SELECT文の実行
			rs = psmt.executeQuery();
			//結果を格納するリストの生成
			ArrayList<Order> list = new ArrayList<Order>();
			//検索結果を取り出してEntitiyを生成
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("order_id"));
				order.setProductId(rs.getString("product_id"));
				order.setProductName(rs.getString("product_name"));
				order.setUnit(rs.getString("unit"));
				order.setVolume(rs.getInt("volume"));
				order.setEmployeeId(rs.getString("employee_id"));
			}
			return list;

		} catch (SQLException e) {
			//データベース使用時のエラー例外クラス
			System.out.println("エラー番号:" + e.getErrorCode());
			System.out.println("説明:" + e.getMessage());
			return null;
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
