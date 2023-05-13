package com.marcodebarros.myhome.repositories;

import com.marcodebarros.myhome.models.UserPreference;
import com.marcodebarros.myhome.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {
    @Query
    List<UserPreference> findByUserProfile(UserProfile userProfile);
}
