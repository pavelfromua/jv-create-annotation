package project.controller;

import project.dao.Dao;
import java.util.Scanner;
import project.lib.Inject;
import project.model.Bet;
import project.model.User;

public class ConsoleHandler {
    @Inject
    private Dao<Bet> betDao;

    @Inject
    private Dao<User> userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Bet bet = null;
            User user = null;

            String command  = "";

            try {
                command = scanner.nextLine();

                if (command.equalsIgnoreCase("q")) {
                    break;
                }

                String[] betData = command.split(" ");
                bet = betDao.getNewModel(betData);

                command = scanner.nextLine();

                if (command.equalsIgnoreCase("q")) {
                    break;
                }

                String[] userData = command.split(" ");
                user = userDao.getNewModel(userData);
            } catch (NumberFormatException e) {
                System.out.println("Enter correct data, please");
            }

            betDao.add(bet);
            userDao.add(user);
        }
    }
}
