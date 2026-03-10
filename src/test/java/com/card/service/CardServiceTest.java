package com.card.service;

import com.card.dto.CardDto;
import com.card.entity.Card;
import com.card.enums.CardStatus;
import com.card.enums.CardType;
import com.card.payload.CreateCardRequest;
import com.card.repository.CardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {
//    @Mock
//    private CardRepository cardRepository;
//    @InjectMocks
//    private CardService cardService;
//
//
//    public CreateCardRequest createCardRequest() {
//        return CreateCardRequest.builder()
//                .cardType(CardType.DEBIT)
//                .cardStatus(CardStatus.ACTIVE)
//                .cardNumber(123456789012L)
//                .accountNumber(9876543210L)
//                .mobileNumber("0987654321")
//                .cardHolderName("John Doe")
//                .build();
//    }
//
//    @Test
//    public void createCard_Success() {
//        //arrange
//        CreateCardRequest request = createCardRequest();
//        Card card = Card.builder()
//                .cardType(request.getCardType())
//                .cardNumber(request.getCardNumber())
//                .accountNumber(request.getAccountNumber())
//                .mobileNumber(request.getMobileNumber())
//                .cardHolderName(request.getCardHolderName())
//                .build();
//        //
//        when(cardRepository.findByCardNumber(request.getCardNumber())).thenReturn(Optional.empty());
//        when(cardRepository.save(any(Card.class))).thenReturn(card);
//        CardDto result = cardService.createCard(request);
//
//        assertNotNull(result);
//        assertEquals(request.getCardNumber(), result.getCardNumber());
//        assertEquals(request.getCardHolderName(), result.getCardHolderName());
//    }
//
//    @Test
//    public void getByCardNumber() {
//        Long cardNumber = 9876543210L;
//        when(cardRepository.findByCardNumber(cardNumber)).thenReturn(Optional.empty());
//        CardDto result = cardService.getCardByCardNumber(cardNumber);
//        assertNotNull(result);
//        assertEquals(cardNumber, result.getCardNumber());
//    }
//
//
//    @Test
//    public void getAll_Cards() {
//        when(cardRepository.findAll()).thenReturn(java.util.List.of(new Card()));
//        Assertions.assertNotNull(cardService.getAllCards());
//    }
}
