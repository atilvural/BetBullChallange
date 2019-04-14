package com.betbull.challange.repository;

import com.betbull.challange.model.Team;

public interface TeamServiceRepository {
    void deleteById(long id);
    Team findById(long id);
    Team insertTeam(String teamName, String leagueName);
    Team updateTeam(long id, String teamName, String leagueName);
    Iterable<Team> findAll();
}
