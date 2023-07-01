package com.example.demo.controller;
import com.example.demo.database.Receipt;
import com.example.demo.services.ReceiptService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping
    public ResponseEntity<Receipt> createReceipt(@RequestBody Receipt receipt) {
        Receipt createdReceipt = receiptService.createReceipt(receipt);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReceipt);
    }

    @GetMapping
    public ResponseEntity<List<Receipt>> getAllReceipts() {
        List<Receipt> receipts = receiptService.getAllReceipts();
        return ResponseEntity.ok(receipts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receipt> getReceiptById(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        Receipt receipt = receiptService.getReceiptById(id);
        return ResponseEntity.ok(receipt);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Receipt>> searchReceipts(@RequestParam(required = false) Date date,
                                                        @RequestParam(required = false) Long id) {
        List<Receipt> receipts = receiptService.searchReceipts(date, id);
        return ResponseEntity.ok(receipts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceipt(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        receiptService.deleteReceipt(id);
        return ResponseEntity.noContent().build();
    }
}

