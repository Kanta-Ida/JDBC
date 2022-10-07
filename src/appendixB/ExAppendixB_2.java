package appendixB;

public class ExAppendixB_2 {

	public static void main(String[] args) {
		//起動パラメータの確認
		if (args.length != 2) {
			System.err.println("変更したい担当者番号と変更後の担当者名を指定してください");
			System.exit(1);
		}

		String ecode = args[0];
		String ename = args[1];
		//担当者マスタのEntityを生成し、更新用の情報を格納
		Employee employee = new Employee();
		employee.setEmployeeId(ecode);
		employee.setEmployeeName(ename);

		//DAOのオブジェクトを生成
		EmployeeDAO employeeDao = new EmployeeDAO();
		//DAOメソッドの呼び出し
		int cnt = employeeDao.updateEmployee(employee);
		if (cnt == 1) {
			System.out.println("データを更新しました");
		} else {
			System.out.println("担当者番号を確認してください");
		}
	}

}
