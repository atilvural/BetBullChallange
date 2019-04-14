package com.betbull.challange.controller;

import com.betbull.challange.model.Player;
import com.betbull.challange.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Player Controller Resource", description = "shows player functions")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @ApiOperation(value = "Deletes player",
            notes = "Deletes player from database by player ID",
            response = String.class,
            responseContainer = "String")
    @RequestMapping(value = "/deletePlayerById", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePlayerById(
            @RequestParam(value = "id") long id) {
        playerService.deleteById(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
    @RequestMapping(value = "/findAllPlayers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Player>> findAllPlayers() {
        return new ResponseEntity<Iterable<Player>>(playerService.findAll(), HttpStatus.OK);
    }
    @RequestMapping(value = "/insertPlayer", method = RequestMethod.PUT)
    public ResponseEntity<Player> insertPlayer(
            @RequestParam(value = "name") String name
            , @RequestParam(value = "surname") String surname
            , @RequestParam(value = "age") int age
            , @RequestParam(value = "position") String position) {
        Player player = playerService.insertPlayer(name, surname, age, position);
        if(player != null)
            return new ResponseEntity<Player>(player, HttpStatus.CREATED);
        else
            return new ResponseEntity<Player>(player, HttpStatus.UNAUTHORIZED);
    }
    @RequestMapping(value = "/updatePlayer", method = RequestMethod.POST)
    public ResponseEntity<Player> updatePlayer(
            @RequestParam(value = "id") long id
            , @RequestParam(value = "name", required = false) String name
            , @RequestParam(value = "surname", required = false) String surname
            , @RequestParam(value = "age", required = false, defaultValue = "-1") int age
            , @RequestParam(value = "position", required = false) String position) {
        Player player = playerService.updatePlayer(id, name, surname, age, position);
        if(player != null)
            return new ResponseEntity<Player>(player, HttpStatus.OK);
        else
            return new ResponseEntity<Player>(player, HttpStatus.UNAUTHORIZED);
    }
}
