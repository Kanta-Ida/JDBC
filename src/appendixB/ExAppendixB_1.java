package appendixB;

import java.util.List;

public class ExAppendixB_1 {

	public static void main(String[] args) {
		//起動パラメータの確認
		if (args.length != 1) {
			System.err.println("担当者番号を指定してください");
			System.exit(1);
		}

		String ecode = args[0];
		//DAoオブジェクトを生成
		OrderDAO orderDao = new OrderDAO();
		//DAOメソッドの呼び出し
		List<Order> list = orderDao.getOrderListByEmployeeId(ecode);
		//取得結果を表示
		for (Order order : list) {
			System.out.println(order.getProductName() + "が" + order.getVolume() + order.getUnit() + "です");
		}
	}

}
