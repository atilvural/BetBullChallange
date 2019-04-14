package com.betbull.challange.repository;
import com.betbull.challange.model.Player;
import com.betbull.challange.model.Team;
import com.betbull.challange.model.TeamSquad;

import java.util.List;

public interface TeamSquadServiceRepository {
    void deleteById(long id);
    TeamSquad insertTeamSquad(int year, Player player, Team team);
    TeamSquad updateTeamSquad(long id, int year);
    List<Player> findPlayersByYearAndTeam(int year, Team team);
    List<Team> findTeamsByPlayer(Player player);
    String findContractFeeAndQualification(Player player);
}
