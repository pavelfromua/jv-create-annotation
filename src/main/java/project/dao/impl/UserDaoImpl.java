package project.dao.impl;

import project.dao.Dao;
import java.util.List;
import project.db.Storage;
import project.lib.DaoAn;
import project.model.User;

@DaoAn
public class UserDaoImpl implements Dao<User> {
    public void add(User user) {
        Storage.users.add(user);
    }

    public List<User> getAll() {
        return Storage.users;
    }

    @Override
    public User getNewModel(String... argv) {
        return new User(argv[0], argv[1], argv[2]);
    }
}
