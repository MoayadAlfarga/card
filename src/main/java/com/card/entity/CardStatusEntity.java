package com.card.entity;

import com.card.enums.CardStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "card_status")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CardStatusEntity extends Audiate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_status")
    private CardStatus status;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
}
