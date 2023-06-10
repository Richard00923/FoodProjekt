package com.example.demo.services;

import com.example.demo.database.OrderItems;
import com.example.demo.database.Receipt;
import com.example.demo.repository.ReceiptRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ReceiptService {
    private final ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public Receipt createReceipt(long customerId, List<OrderItems> orderItems) {
        // Logic for creating a receipt
        Receipt receipt = new Receipt(customerId, orderItems);
        calculateTotalAmount(receipt);
        return receiptRepository.save(receipt);
    }

    public List<Receipt> getAllReceipts() {
        // Logic for retrieving all receipts
        return receiptRepository.findAll();
    }

    public Receipt getReceiptById(long id) throws ChangeSetPersister.NotFoundException {
        // Logic for retrieving a receipt by its identifier
        return receiptRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<Receipt> searchReceipts(Date date, Long id) {
        // Logic for searching receipts by date and customer ID
        if (date != null && id != null) {
            // Search by date and customer ID
            return receiptRepository.findByDateAndCustomerId(date, id);
        } else if (date != null) {
            // Search by date
            return receiptRepository.findByDate(date);
        } else if (id != null) {
            // Search by customer ID
            return receiptRepository.findByCustomerId(id);
        } else {
            // Return all receipts
            return getAllReceipts();
        }
    }

    public void deleteReceipt(long id) {
        // Logic for deleting a receipt
        try {
            receiptRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Receipt not found with ID: " + id);
        }
    }

    private void calculateTotalAmount(Receipt receipt) {
        int total = 0;
        for (OrderItems orderItem : receipt.getOrderItems()) {
            total += orderItem.getQuantity();
        }
        receipt.setTotalAmount(total);
    }

    public Receipt createReceipt(Receipt receipt) {
        return receipt;
    }
}

