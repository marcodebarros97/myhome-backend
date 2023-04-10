package com.marcodebarros.myhome.repositories;

import com.marcodebarros.myhome.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    @Query
    UserProfile findByUsername(String username);
}
