package project.dao.impl;

import project.dao.Dao;
import project.db.Storage;
import java.util.List;
import project.lib.DaoAn;
import project.model.Bet;
import project.model.User;

@DaoAn
public class BetDaoImpl implements Dao<Bet> {
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    public List<Bet> getAll() {
        return Storage.bets;
    }

    @Override
    public Bet getNewModel(String... argv) {
        return new Bet(Integer.parseInt(argv[0]),
                Double.parseDouble(argv[1]));
    }
}
