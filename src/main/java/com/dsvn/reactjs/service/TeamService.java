package com.dsvn.reactjs.service;

import com.dsvn.reactjs.entity.Team;
import com.dsvn.reactjs.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team findById(Integer id) {
        return teamRepository.findById(id).orElse(null);
    }

    public List<Team> getAll() {
        return teamRepository.findByDeletedAtIsNull();
    }
}
