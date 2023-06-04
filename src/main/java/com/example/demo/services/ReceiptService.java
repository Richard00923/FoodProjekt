package com.example.demo.services;
import com.example.demo.database.Receipt;
import com.example.demo.repository.ReceiptRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;


@Service
public class ReceiptService {
    private final ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    public Receipt createReceipt(Receipt receipt) {
        // Логіка створення чеку
        return receiptRepository.save(receipt);
    }

    public List<Receipt> getAllReceipts() {
        // Логіка отримання всіх чеків
        return receiptRepository.findAll();
    }

    public Receipt getReceiptById(long id) throws ChangeSetPersister.NotFoundException {
        // Логіка отримання чеку за ідентифікатором
        return receiptRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public List<Receipt> searchReceipts(Date date, Long id) {
        // Логіка пошуку чеків за датою та покупцем
        if (date != null && id != null) {
            // Шукати за датою та покупцем
            return receiptRepository.findByDateTimeAndCustomerId(date, id);
        } else if (date != null) {
            // Шукати за датою
            return receiptRepository.findByDateTime(date);
        } else if (id != null) {
            // Шукати за покупцем
            return receiptRepository.findByCustomerId(id);
        } else {
            // Повернути всі чеки
            return getAllReceipts();
        }
    }

    public void deleteReceipt(long id) throws ChangeSetPersister.NotFoundException {
        // Логіка видалення чеку
        if (receiptRepository.existsById(id)) {
            receiptRepository.deleteById(id);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }
}