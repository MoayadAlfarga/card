package com.card.dto;

import com.card.enums.CardStatus;
import com.card.enums.CardType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CardDto {
    private CardType cardType;
    private CardStatus cardStatus;
    private Long cardNumber;
    private Long accountNumber;
    private String mobileNumber;
    private String cardHolderName;

    public static CardDto fromEntity(com.card.entity.Card card) {
        return CardDto.builder()
                .cardType(card.getCardType())
                .cardStatus(card.getStatus() != null ? card.getStatus().getStatus() : null)
                .cardNumber(card.getCardNumber())
                .accountNumber(card.getAccountNumber())
                .mobileNumber(card.getMobileNumber())
                .cardHolderName(card.getCardHolderName())
                .build();
    }

}
