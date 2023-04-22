package com.example.eshopapplication.model.dto;

import com.example.eshopapplication.model.User;
import com.example.eshopapplication.model.enumerations.Role;
import lombok.Data;

@Data
public class UserDetailsDto {
    private String username;
    private Role role;

    public static UserDetailsDto of(User user) {
        UserDetailsDto detailsDto = new UserDetailsDto();
        detailsDto.username = user.getUsername();
        detailsDto.role = user.getRole();
        return detailsDto;
    }
}
