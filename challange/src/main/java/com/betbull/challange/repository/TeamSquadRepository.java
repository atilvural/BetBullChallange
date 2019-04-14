package com.betbull.challange.repository;

import com.betbull.challange.model.Player;
import com.betbull.challange.model.Team;
import com.betbull.challange.model.TeamSquad;
import org.springframework.data.repository.CrudRepository;

public interface TeamSquadRepository extends CrudRepository<TeamSquad, Long> {
    void deleteById(long id);
    TeamSquad findById(long id);
    Iterable<TeamSquad> findAllByYearAndTeam(int year, Team team);
    Iterable<TeamSquad> findAllByPlayer(Player player);
}
