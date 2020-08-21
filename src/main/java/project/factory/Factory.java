package project.factory;

import project.dao.Dao;
import project.dao.impl.BetDaoImpl;
import project.dao.impl.UserDaoImpl;
import project.model.Bet;
import project.model.User;

public class Factory {
    private static Dao<Bet> betDao;
    private static Dao<User> userDao;

    public static Dao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }

        return betDao;
    }

    public static Dao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }

        return userDao;
    }
}
