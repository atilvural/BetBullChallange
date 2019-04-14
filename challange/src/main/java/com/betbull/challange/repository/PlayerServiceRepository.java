package com.betbull.challange.repository;

import com.betbull.challange.model.Player;

public interface PlayerServiceRepository {
    void deleteById(long id);
    Player findById(long id);
    Player insertPlayer(String playerName, String playerSurname, int playerAge, String playerPosition);
    Player updatePlayer(long id, String playerName, String playerSurname, int playerAge, String playerPosition);
    Iterable<Player> findAll();
}

