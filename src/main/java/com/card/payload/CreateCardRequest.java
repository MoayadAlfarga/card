package com.card.payload;

import com.card.enums.CardStatus;
import com.card.enums.CardType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateCardRequest {
    private CardType cardType;
    private CardStatus cardStatus;
    private Long cardNumber;
    private Long accountNumber;
    private String mobileNumber;
    private String cardHolderName;
}
