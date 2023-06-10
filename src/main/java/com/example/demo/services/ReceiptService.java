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
        // Логіка створення чеку
        Receipt receipt = new Receipt(customerId, orderItems);
        calculateTotalAmount(receipt);
        return receiptRepository.save(receipt);
    }

    public List<Receipt> getAllReceipts() {
        // Логіка отримання всіх чеків
        return receiptRepository.findAll();
    }

    public Receipt getReceiptById(long id) throws ChangeSetPersister.NotFoundException {
        // Логіка отримання чеку за ідентифікатором
        return receiptRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<Receipt> searchReceipts(Date date, Long id) {
        // Логіка пошуку чеків за датою та покупцем
        if (date != null && id != null) {
            // Шукати за датою та покупцем
            return receiptRepository.findByDateAndCustomerId(date, id);
        } else if (date != null) {
            // Шукати за датою
            return receiptRepository.findByDate(date);
        } else if (id != null) {
            // Шукати за покупцем
            return receiptRepository.findByCustomerId(id);
        } else {
            // Повернути всі чеки
            return getAllReceipts();
        }
    }

    public void deleteReceipt(long id) {
        // Логіка видалення чеку
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
