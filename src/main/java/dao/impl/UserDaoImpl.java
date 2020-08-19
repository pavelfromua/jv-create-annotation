package dao.impl;

import dao.UserDao;
import db.Storage;
import model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    public void add(User user) {
        Storage.users.add(user);
    }

    public List<User> getAll() {
        return Storage.users;
    }
}
