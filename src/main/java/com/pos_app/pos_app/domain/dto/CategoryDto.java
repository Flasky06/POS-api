package com.pos_app.pos_app.domain.dto;


import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    private UUID id;
    private String name;
}
