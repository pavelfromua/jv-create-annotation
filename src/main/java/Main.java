import controller.ConsoleHandler;
import dao.impl.BetDaoImpl;

public class Main {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler(new BetDaoImpl());
        System.out.println("Enter the value and the risk of your bet");
        handler.handle();
    }
}
