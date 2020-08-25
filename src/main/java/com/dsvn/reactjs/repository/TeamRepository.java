package com.dsvn.reactjs.repository;

import com.dsvn.reactjs.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    List<Team> findByDeletedAtIsNull();
}
