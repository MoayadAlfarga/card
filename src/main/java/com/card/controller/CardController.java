package com.card.controller;

import com.card.dto.CardDto;
import com.card.payload.CreateCardRequest;
import com.card.payload.UpdateCardRequest;
import com.card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardDto> createCard(@RequestBody CreateCardRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.createCard(request));
    }

    @GetMapping("card-number/{cardNumber}")
    public ResponseEntity<CardDto> getCardByCardNumber(@PathVariable(name = "cardNumber") Long cardNumber) {
        return ResponseEntity.ok(cardService.getCardByCardNumber(cardNumber));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> getCardById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @GetMapping
    public ResponseEntity<List<CardDto>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardDto> updateCard(@PathVariable Long id, @RequestBody UpdateCardRequest request) {
        return ResponseEntity.ok(cardService.updateCardInformation(id, request));
    }
}
