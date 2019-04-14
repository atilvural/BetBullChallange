package com.betbull.challange.controller;

import com.betbull.challange.model.Player;
import com.betbull.challange.model.Team;
import com.betbull.challange.model.TeamSquad;
import com.betbull.challange.service.PlayerService;
import com.betbull.challange.service.TeamService;
import com.betbull.challange.service.TeamSquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamSquadController {
    @Autowired
    TeamSquadService teamSquadService;
    @Autowired
    PlayerService playerService;
    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/deleteTeamSquadById", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTeamSquadById(
            @RequestParam(value = "id") long id) {
        teamSquadService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @RequestMapping(value = "/findAllTeamSquads", method = RequestMethod.GET)
    public ResponseEntity<Iterable<TeamSquad>> findAllTeamSquads() {
        return new ResponseEntity<Iterable<TeamSquad>>(teamSquadService.findAll(), HttpStatus.OK);
    }
    @RequestMapping(value = "/insertTeamSquad", method = RequestMethod.PUT)
    public ResponseEntity<TeamSquad> insertTeamSquad(
            @RequestParam(value = "year") int year
            , @RequestParam(value = "playerId") long playerId
            , @RequestParam(value = "teamId") long teamId
    ){
        Player player = playerService.findById(playerId);
        Team team = teamService.findById(teamId);
        TeamSquad teamSquad = teamSquadService.insertTeamSquad(year, player, team);
        if(player != null)
            return new ResponseEntity<TeamSquad>(teamSquad, HttpStatus.CREATED);
        else
            return new ResponseEntity<TeamSquad>(teamSquad, HttpStatus.UNAUTHORIZED);
    }
    @RequestMapping(value = "/updateTeamSquad", method = RequestMethod.POST)
    public ResponseEntity<TeamSquad> updateTeamSquad(
            @RequestParam(value = "id") long id
            , @RequestParam(value = "year") int year
    ){
        TeamSquad teamSquad = teamSquadService.updateTeamSquad(id, year);
        if(teamSquad != null)
            return new ResponseEntity<TeamSquad>(teamSquad, HttpStatus.OK);
        else
            return new ResponseEntity<TeamSquad>(teamSquad, HttpStatus.UNAUTHORIZED);
    }
    @RequestMapping(value = "/findPlayersByYearAndTeam", method = RequestMethod.GET)
    public ResponseEntity<List<Player>> findPlayersByYearAndTeam(
            @RequestParam(value = "teamId") long teamId
            , @RequestParam(value = "year") int year
    ){
        Team team = teamService.findById(teamId);
        List<Player> playerList = teamSquadService.findPlayersByYearAndTeam(year, team);
        if(playerList != null)
            return new ResponseEntity<List<Player>>(playerList, HttpStatus.OK);
        else
            return new ResponseEntity<List<Player>>(playerList, HttpStatus.UNAUTHORIZED);
    }
    @RequestMapping(value = "/findTeamsByPlayer", method = RequestMethod.GET)
    public ResponseEntity<List<Team>> findTeamsByPlayer(
            @RequestParam(value = "playerId") long playerId){
        Player player = playerService.findById(playerId);
        List<Team> teamList = teamSquadService.findTeamsByPlayer(player);
        if(teamList != null)
            return new ResponseEntity<List<Team>>(teamList, HttpStatus.OK);
        else
            return new ResponseEntity<List<Team>>(teamList, HttpStatus.UNAUTHORIZED);
    }
    @RequestMapping(value = "/findContractFeeAndQualification", method = RequestMethod.GET)
    public ResponseEntity<String> findContractFeeAndQualification(
            @RequestParam(value = "playerId") long playerId){
        Player player = playerService.findById(playerId);
        return new ResponseEntity<String>(teamSquadService.findContractFeeAndQualification(player), HttpStatus.OK);
    }
}
