package project.dao;

import java.util.List;

public interface Dao<T> {
    void add(T bet);

    List<T> getAll();

    T getNewModel(String...argv);
}
