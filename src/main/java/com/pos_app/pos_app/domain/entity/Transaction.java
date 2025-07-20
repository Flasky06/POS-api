package com.pos_app.pos_app.domain.entity;

import com.pos_app.pos_app.domain.model.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "waiter_id", nullable = false)
    private User waiter;

    @ManyToOne
    @JoinColumn(name = "cashier_id", nullable = false)
    private User cashier;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
}
