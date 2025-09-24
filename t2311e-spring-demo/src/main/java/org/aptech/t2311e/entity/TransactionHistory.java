package org.aptech.t2311e.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "transaction_history")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "type")
    private String type;
    @Column(name = "start_at")
    private LocalDateTime startAt;
    @Column(name = "completed_at")
    private LocalDateTime completeAt;

    public TransactionHistory(String username, String type, LocalDateTime startAt) {
        this.username = username;
        this.type = type;
        this.startAt = startAt;
    }

    @PrePersist  // todo : prepresist : truoc khi create, upate du lieu
    public void setCompleteAt() {
        this.completeAt = LocalDateTime.now();
    }
}
