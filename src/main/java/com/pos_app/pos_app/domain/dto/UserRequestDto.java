package com.pos_app.pos_app.domain.dto;

import com.pos_app.pos_app.domain.model.Role;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto {
    private String userName;
    private String fullName;
    private String phoneNo;
    private String password;
    private Role role;
    private BigDecimal balance;
}
