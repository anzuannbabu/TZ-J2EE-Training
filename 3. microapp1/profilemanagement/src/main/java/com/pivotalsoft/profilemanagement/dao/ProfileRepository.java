package com.pivotalsoft.profilemanagement.dao;

import com.pivotalsoft.profilemanagement.domain.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository < EmployeeProfile, Integer > {
    
}
