package com.betbull.challange.service;

import com.betbull.challange.model.Player;
import com.betbull.challange.model.Team;
import com.betbull.challange.model.TeamSquad;
import com.betbull.challange.repository.TeamSquadRepository;
import com.betbull.challange.repository.TeamSquadServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeamSquadService implements TeamSquadServiceRepository {
    @Autowired
    TeamSquadRepository teamSquadRepository;

    public void deleteById(long id){
        teamSquadRepository.deleteById(id);
    }
    public TeamSquad insertTeamSquad(int year, Player player, Team team){
        TeamSquad teamSquad = new TeamSquad();
        teamSquad.setYear(year);
        teamSquad.setPlayer(player);
        teamSquad.setTeam(team);
        return teamSquadRepository.save(teamSquad);
    }
    public TeamSquad updateTeamSquad(long id, int year){
        TeamSquad teamSquad = teamSquadRepository.findById(id);
        teamSquad.setYear(year);

        return teamSquadRepository.save(teamSquad);
    }
    public List<Player> findPlayersByYearAndTeam(int year, Team team){
        return StreamSupport.stream(teamSquadRepository.findAllByYearAndTeam(year, team).spliterator(), false).map(tuple -> tuple.getPlayer()).distinct().collect(Collectors.toList());
    }
    public List<Team> findTeamsByPlayer(Player player){
        return StreamSupport.stream(teamSquadRepository.findAllByPlayer(player).spliterator(), false).map(tuple-> tuple.getTeam()).distinct().collect(Collectors.toList());
    }
    public String findContractFeeAndQualification(Player player){
        long count = StreamSupport.stream(teamSquadRepository.findAllByPlayer(player).spliterator(), true).count();
        long contractFee = (count * 12 * 100000 / player.getPlayerAge()) * 110 / 100;
        return "Position: " + player.getPlayerPosition() + ", Transfer Fee: " + contractFee;
    }
    public Iterable<TeamSquad> findAll(){
        return teamSquadRepository.findAll();
    }
}
