package part7_2_networrk2;

public class UnitTest {

		public static void main(String[] args) {
			ChatDao cDao = new ChatDao();
			String nick =cDao.login("test", "123");
			System.out.println(nick);
		}
}
