package project;

import project.controller.ConsoleHandler;
import project.dao.Dao;
import project.exceptions.DaoModelNullException;
import project.factory.Factory;
import project.lib.Injector;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException,
            DaoModelNullException {

        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        System.out.println("Enter the value and the risk of your bet");
        System.out.println("Than Enter name, email and password of the user");
        handler.handle();

        Dao betDao = Factory.getBetDao();
        System.out.println(betDao.getAll());

        Dao userDao = Factory.getUserDao();
        System.out.println(userDao.getAll());
    }
}
