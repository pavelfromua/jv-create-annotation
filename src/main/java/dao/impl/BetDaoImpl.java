package dao.impl;

import dao.BetDao;
import db.Storage;
import model.Bet;

import java.util.List;

public class BetDaoImpl implements BetDao {
    public void add(Bet bet) {
        Storage.bets.add(bet);
    }

    public List<Bet> getAll() {
        return Storage.bets;
    }
}
