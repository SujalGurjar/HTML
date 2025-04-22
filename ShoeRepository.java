package com.exa.shoe_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exa.shoe_project.Model.User;

public interface ShoeRepository extends JpaRepository<User, Long>{

    
}