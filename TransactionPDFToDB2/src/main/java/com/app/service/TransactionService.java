package com.app.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TransactionService {
    void processTransactionsFromPdf(MultipartFile file) throws IOException;
}

