package com.betbull.challange.controller;

import com.betbull.challange.model.Team;
import com.betbull.challange.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/deleteTeamById", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTeamById(
            @RequestParam(value = "id") long id) {
        teamService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @RequestMapping(value = "/findAllTeams", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Team>> findAllTeams() {
        return new ResponseEntity<Iterable<Team>>(teamService.findAll(), HttpStatus.OK);
    }
    @RequestMapping(value = "/insertTeam", method = RequestMethod.PUT)
    public ResponseEntity<Team> insertTeam(
            @RequestParam(value = "teamname") String teamName
            , @RequestParam(value = "leaguename") String leagueName) {
        Team team = teamService.insertTeam(teamName, leagueName);
        if(team != null)
            return new ResponseEntity<Team>(team, HttpStatus.CREATED);
        else
            return new ResponseEntity<Team>(team, HttpStatus.UNAUTHORIZED);
    }
    @RequestMapping(value = "/updateTeam", method = RequestMethod.POST)
    public ResponseEntity<Team> updateTeam(
            @RequestParam(value = "id") long id
            , @RequestParam(value = "teamname", required = false) String teamName
            , @RequestParam(value = "leaguename", required = false) String leagueName) {
        Team team = teamService.updateTeam(id, teamName, leagueName);
        if(team != null)
            return new ResponseEntity<Team>(team, HttpStatus.OK);
        else
            return new ResponseEntity<Team>(team, HttpStatus.UNAUTHORIZED);
    }
}
