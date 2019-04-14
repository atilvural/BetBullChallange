package com.betbull.challange.repository;

import com.betbull.challange.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    void deleteById(long id);
    Player findById(long id);
}