package com.mohran.udemy.service;

import com.mohran.udemy.dto.AdminDto;
import com.mohran.udemy.model.Admin;
import org.springframework.stereotype.Service;

@Service
public class ConvertAdminService {

    public AdminDto convertAdminToAdminDto(Admin admin) {
        AdminDto adminDto = new AdminDto();

        if (admin.getId() != null) {
            adminDto.setId(admin.getId());
        }

        if (admin.getFirstName() != null) {
            adminDto.setFirstName(admin.getFirstName());
        }

        if (admin.getLastName() != null) {
            adminDto.setLastName(admin.getLastName());
        }

        if (admin.getEmail() != null) {
            adminDto.setEmail(admin.getEmail());
        }

        if (admin.getPassword() != null) {
            adminDto.setPassword(admin.getPassword());
        }

        if (admin.getProfilePicture() != null) {
            adminDto.setProfilePicture(admin.getProfilePicture());
        }

        if (admin.getPhoneNumber() != null) {
            adminDto.setPhoneNumber(admin.getPhoneNumber());
        }

        if (admin.getAddress() != null) {
            adminDto.setAddress(admin.getAddress());
        }

        if (admin.getBio() != null) {
            adminDto.setBio(admin.getBio());
        }

        return adminDto;
    }

    public Admin convertAdminDtoToAdmin(AdminDto adminDto) {
        Admin admin = new Admin();

        if (adminDto.getId() != null) {
            admin.setId(adminDto.getId());
        }

        if (adminDto.getFirstName() != null) {
            admin.setFirstName(adminDto.getFirstName());
        }

        if (adminDto.getLastName() != null) {
            admin.setLastName(adminDto.getLastName());
        }

        if (adminDto.getEmail() != null) {
            admin.setEmail(adminDto.getEmail());
        }

        if (adminDto.getPassword() != null) {
            admin.setPassword(adminDto.getPassword());
        }

        if (adminDto.getProfilePicture() != null) {
            admin.setProfilePicture(adminDto.getProfilePicture());
        }

        if (adminDto.getPhoneNumber() != null) {
            admin.setPhoneNumber(adminDto.getPhoneNumber());
        }

        if (adminDto.getAddress() != null) {
            admin.setAddress(adminDto.getAddress());
        }

        if (adminDto.getBio() != null) {
            admin.setBio(adminDto.getBio());
        }

        return admin;
    }

    public Admin update(AdminDto adminDto, Admin admin) {

        if (adminDto.getFirstName() != null) {
            admin.setFirstName(adminDto.getFirstName());
        }

        if (adminDto.getLastName() != null) {
            admin.setLastName(adminDto.getLastName());
        }

        if (adminDto.getEmail() != null) {
            admin.setEmail(adminDto.getEmail());
        }

        if (adminDto.getPassword() != null) {
            admin.setPassword(adminDto.getPassword());
        }

        if (adminDto.getProfilePicture() != null) {
            admin.setProfilePicture(adminDto.getProfilePicture());
        }

        if (adminDto.getPhoneNumber() != null) {
            admin.setPhoneNumber(adminDto.getPhoneNumber());
        }

        if (adminDto.getAddress() != null) {
            admin.setAddress(adminDto.getAddress());
        }

        if (adminDto.getBio() != null) {
            admin.setBio(adminDto.getBio());
        }

        return admin;
    }
}
