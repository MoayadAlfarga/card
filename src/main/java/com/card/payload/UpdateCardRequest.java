package com.card.payload;

import com.card.enums.CardStatus;
import com.card.enums.CardType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateCardRequest {
    private CardType cardType;
    private CardStatus cardStatus;
    private String mobileNumber;
    private String cardHolderName;
}
