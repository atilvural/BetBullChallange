package com.betbull.challange.repository;

import com.betbull.challange.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
    void deleteById(long id);
    Team findById(long id);
}
