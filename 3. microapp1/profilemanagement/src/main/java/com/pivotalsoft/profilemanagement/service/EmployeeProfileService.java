package com.pivotalsoft.profilemanagement.service;

import com.pivotalsoft.profilemanagement.domain.EmployeeProfile;
import java.util.List;

public interface EmployeeProfileService {
    void addEmployeeProfile(EmployeeProfile profile);
    List < EmployeeProfile > getEmployeeProfiles();
}

