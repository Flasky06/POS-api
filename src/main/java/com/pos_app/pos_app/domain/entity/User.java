package com.pos_app.pos_app.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pos_app.pos_app.domain.model.Role;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String phoneNo;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(fullName, user.fullName) && Objects.equals(phoneNo, user.phoneNo) && Objects.equals(password, user.password) && role == user.role && Objects.equals(balance, user.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, fullName, phoneNo, password, role, balance);
    }
}


