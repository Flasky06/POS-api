package com.pos_app.pos_app.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "brands")
@Builder
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Product> products;

}
