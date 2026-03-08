package com.card.service;

import com.card.dto.CardDto;
import com.card.entity.Card;
import com.card.entity.CardStatusEntity;
import com.card.enums.CardStatus;
import com.card.exception.CardAlreadyExistsException;
import com.card.exception.ResourceNotFoundException;
import com.card.payload.CreateCardRequest;
import com.card.payload.UpdateCardRequest;
import com.card.repository.CardRepository;
import com.card.repository.CardStatusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService {
    private final CardRepository cardRepository;
    private final CardStatusRepository cardStatusRepository;

    @Transactional
    public CardDto createCard(CreateCardRequest request) {
        log.info("Creating Card for accountNumber: {}", request.getAccountNumber());
        cardRepository.findByCardNumber(request.getCardNumber()).ifPresent(card -> {
            throw new CardAlreadyExistsException("Card", "cardNumber", request.getCardNumber().toString());
        });
        Card card = buildCreateCardInformation(request);
        CardStatusEntity cardStatus = fillStatusCard(card);
        card.setStatus(cardStatus);
        Card savedCard = saveCard(card);
        return CardDto.fromEntity(savedCard);
    }

    private Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Transactional
    public CardDto updateCardInformation(Long id, UpdateCardRequest request) {
        Card card = findById(id);
        fillUpdateInformation(card, request);
        Card savedCard = saveCard(card);
        return CardDto.fromEntity(savedCard);
    }

    public CardDto getCardByCardNumber(Long cardNumber) {
        return CardDto.fromEntity(findCardByCardNumber(cardNumber));
    }

    private void fillUpdateInformation(Card card, UpdateCardRequest request) {
        if (request == null) {
            return;
        }
        Optional.ofNullable(request.getCardType()).ifPresent(card::setCardType);
        if (request.getCardStatus() != null) {
            if (card.getStatus() != null) {
                card.getStatus().setStatus(request.getCardStatus());
            } else {
                card.setStatus(fillStatusCard(card, request.getCardStatus()));
            }
        }
        Optional.ofNullable(request.getMobileNumber()).ifPresent(card::setMobileNumber);
        Optional.ofNullable(request.getCardHolderName()).ifPresent(card::setCardHolderName);
    }

    private Card buildCreateCardInformation(CreateCardRequest request) {
        return Card.builder()
                .cardType(request.getCardType())
                .cardNumber(request.getCardNumber() != null ? request.getCardNumber() : generateCardNumber())
                .accountNumber(request.getAccountNumber())
                .mobileNumber(request.getMobileNumber())
                .cardHolderName(request.getCardHolderName())
                .build();
    }

    private Long generateCardNumber() {
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        log.info("created Card Number {}", randomCardNumber);
        return randomCardNumber;
    }

    public CardDto getCardById(Long id) {
        return CardDto.fromEntity(findById(id));
    }

    public List<CardDto> getAllCards() {
        return cardRepository.findAll()
                .stream()
                .map(CardDto::fromEntity)
                .toList();
    }

    private Card findById(Long id) {
        return cardRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Card", "id", id.toString())
        );
    }

    private Card findCardByCardNumber(Long cardNumber) {
        return cardRepository.findByCardNumber(cardNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "cardNumber", cardNumber.toString())
        );
    }

    private CardStatusEntity fillStatusCard(Card card) {
        return CardStatusEntity.builder()
                .status(CardStatus.ACTIVE)
                .card(card)
                .build();
    }

    private CardStatusEntity fillStatusCard(Card card, CardStatus status) {
        return CardStatusEntity.builder()
                .status(status)
                .card(card)
                .build();
    }
}

