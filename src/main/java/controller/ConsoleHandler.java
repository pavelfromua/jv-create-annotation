package controller;

import java.util.Scanner;
import dao.BetDao;
import model.Bet;

public class ConsoleHandler {
    private BetDao betDao;

    public ConsoleHandler(BetDao betDao) {
        this.betDao = betDao;
    }

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("q")) {
                break;
            }

            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);

                bet = new Bet(value, risk);
            } catch (NumberFormatException e) {
                System.out.println("Enter correct data, please");
            }

            betDao.add(bet);
        }
    }
}
