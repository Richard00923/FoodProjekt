package com.example.demo.repository;

import com.example.demo.database.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    List<Receipt> findByDateTime(Date dateTime);

    List<Receipt> findByDateTimeAndCustomerId(Date dateTime, long customerId);

    List<Receipt> findByCustomerId(long customerId);
}