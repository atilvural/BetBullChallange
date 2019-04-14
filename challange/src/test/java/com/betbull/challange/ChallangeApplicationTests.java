package com.betbull.challange;

import com.betbull.challange.model.Player;
import com.betbull.challange.model.Team;
import com.betbull.challange.service.PlayerService;
import com.betbull.challange.service.TeamService;
import com.betbull.challange.service.TeamSquadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ChallangeApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PlayerService playerService;
    @MockBean
    private TeamService teamService;
    @MockBean
    private TeamSquadService teamSquadService;

    @Test
    public void findAllPlayers() throws Exception {
        Player player = new Player();
        player.setPlayerName("atil");
        player.setPlayerSurname("vural");
        player.setPlayerPosition("GK");
        player.setPlayerAge(26);

        List<Player> players = Arrays.asList(player);
        BDDMockito.given(playerService.findAll()).willReturn(players);

        this.mockMvc.perform(get("/findAllPlayers"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 0,'playerName': 'atil','playerSurname': 'vural', 'playerPosition': 'GK', 'playerAge': 26}]"));
    }
    @Test
    public void findAllTeams() throws Exception {
        Team team = new Team();
        team.setLeagueName("TSL");
        team.setTeamName("FB");

        List<Team> teams= Arrays.asList(team);
        BDDMockito.given(teamService.findAll()).willReturn(teams);

        this.mockMvc.perform(get("/findAllTeams"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 0,'teamName': 'FB','leagueName': 'TSL'}]"));
    }
    @Test
    public void insertPlayer() throws Exception {
        Player player = new Player();
        player.setPlayerName("atil");
        player.setPlayerSurname("vural");
        player.setPlayerPosition("GK");
        player.setPlayerAge(26);

        BDDMockito.given(playerService.insertPlayer("atil", "vural", 26, "GK")).willReturn(player);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("name", "atil");
        headers.add("surname", "vural");
        headers.add("age", "26");
        headers.add("position", "GK");

        this.mockMvc.perform(put("/insertPlayer").params(headers))
                .andExpect(status().isCreated())
                .andExpect(content().json("{'id': 0,'playerName': 'atil','playerSurname': 'vural', 'playerPosition': 'GK', 'playerAge': 26}"));
    }
    @Test
    public void insertTeam() throws Exception {
        Team team = new Team();
        team.setLeagueName("TSL");
        team.setTeamName("FB");

        BDDMockito.given(teamService.insertTeam("FB", "TSL")).willReturn(team);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("teamname", "FB");
        headers.add("leaguename", "TSL");
        this.mockMvc.perform(put("/insertTeam").params(headers))
                .andExpect(status().isCreated())
                .andExpect(content().json("{'id': 0,'teamName': 'FB','leagueName': 'TSL'}"));
    }

}
