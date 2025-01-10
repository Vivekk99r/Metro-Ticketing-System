package com.metro.service;

import com.metro.model.*;
import com.metro.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MetroService {
    @Autowired
    private UserCardRepository userCardRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public UserCard rechargeCard(Long cardId, double amount) {
        Optional<UserCard> card = userCardRepository.findById(cardId);
        if (card.isPresent()) {
            UserCard userCard = card.get();
            userCard.setBalance(userCard.getBalance() + amount);
            return userCardRepository.save(userCard);
        }
        throw new RuntimeException("Card not found");
    }

    public double calculateFare(String source, String destination) {
        return Math.abs(source.hashCode() - destination.hashCode()) % 10 + 10; // Example calculation
    }

    public Transaction travel(Long cardId, String source, String destination) {
        Optional<UserCard> card = userCardRepository.findById(cardId);
        if (card.isPresent()) {
            double fare = calculateFare(source, destination);
            UserCard userCard = card.get();
            if (userCard.getBalance() >= fare) {
                userCard.setBalance(userCard.getBalance() - fare);
                userCardRepository.save(userCard);

                Transaction transaction = new Transaction();
                transaction.setUserCard(userCard);
                transaction.setSourceStation(source);
                transaction.setDestinationStation(destination);
                transaction.setFare(fare);
                transaction.setTimestamp(java.time.LocalDateTime.now());

                return transactionRepository.save(transaction);
            } else {
                throw new RuntimeException("Insufficient balance");
            }
        }
        throw new RuntimeException("Card not found");
    }

    public Station addStation(String name) {
        Station station = new Station();
        station.setName(name);
        return stationRepository.save(station);
    }

    public void removeStation(Long stationId) {
        stationRepository.deleteById(stationId);
    }
}
