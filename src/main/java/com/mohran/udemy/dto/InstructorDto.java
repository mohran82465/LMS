package com.mohran.udemy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Data
@Getter
@Setter
public class InstructorDto {
    private Long id ;
    @Email
    @NotEmpty
    @NotBlank
    private String email;
    @NotEmpty
    @NotBlank
    private String password;
    @NotEmpty
    @NotBlank
    private String firstName;
    @NotEmpty
    @NotBlank
    private String lastName;

    private String profilePicture;
    @NotBlank
    @NotEmpty
    @Length(min = 11 ,max = 11)
    private String phoneNumber;

    private String address;

    private String bio ;

}
