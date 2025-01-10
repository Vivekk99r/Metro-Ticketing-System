package com.metro.repository;

import com.metro.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCardRepository extends JpaRepository<UserCard, Long> {}
public interface StationRepository extends JpaRepository<Station, Long> {}
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
