package Bank;
import java.util.*;
public class BankSystem {
	static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {
		BankManager manager = BankManager.getInstance();
		do {
			manager.showMenu();
			int choice = kb.nextInt();
			switch(choice) {
			case 1://Join
				manager.join(); break;
			case 2://Login
				manager.login();
				manager.showBankMenu();
				int choice1 = kb.nextInt();
				switch(choice1) {
				case 1://input
					manager.deposit(); break;
				case 2:
					manager.withdraw(); break;
				case 3:
					manager.check(); break;
				default:
					System.out.println("�߸��� �Է��Դϴ�.");
					return;
				}
				break;
			case 3://Exit
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}while(true);
	}
	

}
