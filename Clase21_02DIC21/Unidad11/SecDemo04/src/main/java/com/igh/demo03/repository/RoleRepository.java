package com.igh.demo03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igh.demo03.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
