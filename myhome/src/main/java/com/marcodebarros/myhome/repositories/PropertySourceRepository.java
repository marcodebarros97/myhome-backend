package com.marcodebarros.myhome.repositories;

import com.marcodebarros.myhome.models.PropertySources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertySourceRepository extends JpaRepository<PropertySources, Long> {
}
