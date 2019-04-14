package com.betbull.challange.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "tbl_team_squads", uniqueConstraints={
        @UniqueConstraint(columnNames = {"int_year", "int_player_id"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TeamSquad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_team_squad_id")
    @ApiModelProperty(notes = "team squad id")
    private long id;

    @Column(name = "int_year")
    @ApiModelProperty(notes = "year of player contract")
    private Integer year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "int_player_id", nullable = false)
    @ApiModelProperty(notes = "player info")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "int_team_id", nullable = false)
    @ApiModelProperty(notes = "team info")
    private Team team;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
