package com.betbull.challange.service;

import com.betbull.challange.model.Team;
import com.betbull.challange.repository.TeamRepository;
import com.betbull.challange.repository.TeamServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService implements TeamServiceRepository {
    @Autowired
    TeamRepository teamRepository;

    public void deleteById(long id){
        teamRepository.deleteById(id);
    }
    public Team findById(long id){
        return teamRepository.findById(id);
    }
    public Iterable<Team> findAll(){
        return teamRepository.findAll();
    }
    public Team insertTeam(String teamName, String leagueName){
        Team team = new Team();
        team.setTeamName(teamName);
        team.setLeagueName(leagueName);
        return teamRepository.save(team);
    }
    public Team updateTeam(long id, String teamName, String leagueName){
        Team team = teamRepository.findById(id);
        team.setTeamName((teamName != null) ? teamName : team.getTeamName());
        team.setLeagueName((leagueName != null) ? leagueName : team.getLeagueName());

        return teamRepository.save(team);
    }
}
