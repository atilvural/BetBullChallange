package com.betbull.challange.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "tbl_teams", uniqueConstraints={
        @UniqueConstraint(columnNames = {"str_team_name", "str_league_name"})})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "int_team_id")
    @ApiModelProperty(notes = "team id")
    private long id;

    @ApiModelProperty(notes = "team name")
    @Column(name="str_team_name")
    private String teamName;

    @ApiModelProperty(notes = "team's league name")
    @Column(name="str_league_name")
    private String leagueName;

    @ApiModelProperty(notes = "foreign key relation")
    @OneToMany(targetEntity=TeamSquad.class, mappedBy="team",cascade=CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<TeamSquad> teamSquad = new ArrayList<>();

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public long getId() {
            return id;
        }

    }
