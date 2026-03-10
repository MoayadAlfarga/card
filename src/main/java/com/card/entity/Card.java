package com.card.entity;

import com.card.enums.CardType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Card  extends Audiate{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    private CardType cardType;

    @Column(name = "card_number")
    private Long cardNumber;
    @Column(name = "account_number")
    private Long accountNumber;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "card_holder_name")
    private String cardHolderName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private CardStatusEntity status;
}
