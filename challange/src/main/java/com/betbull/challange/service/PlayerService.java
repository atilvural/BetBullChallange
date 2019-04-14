package com.betbull.challange.service;

import com.betbull.challange.model.Player;
import com.betbull.challange.repository.PlayerRepository;
import com.betbull.challange.repository.PlayerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements PlayerServiceRepository {
    @Autowired
    PlayerRepository playerRepository;

    public void deleteById(long id){
        playerRepository.deleteById(id);
    }
    public Player findById(long id) { return playerRepository.findById(id);}
    public Iterable<Player> findAll(){
        return playerRepository.findAll();
    }
    public Player insertPlayer(String playerName, String playerSurname, int playerAge, String playerPosition){
        Player player = new Player();
        player.setPlayerName(playerName);
        player.setPlayerSurname(playerSurname);
        player.setPlayerAge(playerAge);
        player.setPlayerPosition(playerPosition);

        return playerRepository.save(player);
    }
    public Player updatePlayer(long id, String playerName, String playerSurname, int playerAge, String playerPosition){
        Player player = playerRepository.findById(id);
        player.setPlayerName((playerName != null) ? playerName : player.getPlayerName());
        player.setPlayerSurname((playerSurname != null) ? playerSurname : player.getPlayerSurname());
        player.setPlayerAge((playerAge != -1) ? playerAge : player.getPlayerAge());
        player.setPlayerPosition((playerPosition != null) ? playerPosition : player.getPlayerPosition());

        return playerRepository.save(player);
    }
}
