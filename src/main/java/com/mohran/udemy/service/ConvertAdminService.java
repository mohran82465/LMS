package com.mohran.udemy.service;

import com.mohran.udemy.dto.AdminDto;
import com.mohran.udemy.model.Admin;
import org.springframework.stereotype.Service;

@Service
public class ConvertAdminService {
    public AdminDto convertAdminToAdminDto(Admin admin)
    {
        AdminDto adminDto = new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setFirstName(admin.getFirstName());
        adminDto.setLastName(admin.getLastName());
        adminDto.setEmail(admin.getEmail());
        adminDto.setPassword(admin.getPassword());
        adminDto.setProfilePicture(admin.getProfilePicture());
        adminDto.setPhoneNumber(admin.getPhoneNumber());
        adminDto.setAddress(admin.getAddress());
        adminDto.setBio(admin.getBio());
        return adminDto;
    }

    public Admin convertAdminDtoToAdmin(AdminDto adminDto){
        Admin admin = new Admin();
        admin.setId(adminDto.getId());
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        admin.setProfilePicture(adminDto.getProfilePicture());
        admin.setPhoneNumber(adminDto.getPhoneNumber());
        admin.setAddress(adminDto.getAddress());
        admin.setBio(adminDto.getBio());

        return admin;
    }
}
