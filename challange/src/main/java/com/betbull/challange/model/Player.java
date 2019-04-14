package com.betbull.challange.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "tbl_players", uniqueConstraints={
        @UniqueConstraint(columnNames = {"str_player_name", "str_player_surname"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_player_id")
    @ApiModelProperty(notes = "player id")
    private long id;

    @ApiModelProperty(notes = "player first name")
    @Column(name="str_player_name")
    private String playerName;

    @ApiModelProperty(notes = "player surname")
    @Column(name="str_player_surname")
    private String playerSurname;

    @ApiModelProperty(notes = "player age")
    @Column(name="int_age")
    private Integer playerAge;

    @ApiModelProperty(notes = "player position/qualification")
    @Column(name="str_position")
    private String playerPosition;

    @ApiModelProperty(notes = "foreign key relation")
    @OneToMany(targetEntity=TeamSquad.class, mappedBy="player",cascade=CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<TeamSquad> teamSquad = new ArrayList<>();

    public String getPlayerSurname() {
        return playerSurname;
    }

    public void setPlayerSurname(String playerSurname) {
        this.playerSurname = playerSurname;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Integer getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(Integer playerAge) {
        this.playerAge = playerAge;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public long getId() {
        return id;
    }
}
