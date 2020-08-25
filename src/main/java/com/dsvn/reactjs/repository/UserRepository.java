package com.dsvn.reactjs.repository;

import com.dsvn.reactjs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("Select u From User u Where u.name like %:name% And u.deletedAt is null")
    List<User> getUserByName(String name);

    @Transactional
    @Modifying
    @Query("Update User as u set u.deletedAt = :deletedAt Where u.id in :ids")
    void delete(List<Integer> ids);
}
