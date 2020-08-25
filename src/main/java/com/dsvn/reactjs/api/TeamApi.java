package com.dsvn.reactjs.api;

import com.dsvn.reactjs.entity.Team;
import com.dsvn.reactjs.response.ResourceResponse;
import com.dsvn.reactjs.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamApi {
    @Autowired
    private TeamService teamService;

    @GetMapping("")
    public ResourceResponse getAll() {
        List<Team> teams = teamService.getAll();
        return new ResourceResponse(teams);
    }
}
