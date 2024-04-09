package com.app.service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.entity.Transaction;
import com.app.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public void processTransactionsFromPdf(MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            PDDocument document = PDDocument.load(inputStream);
            PDFTextStripper stripper = new PDFTextStripper();
            String pdfText = stripper.getText(document);
            document.close();
            System.out.println("PDF loaded successfully");
            String[] lines = pdfText.split("\\r?\\n");

            String remainingLines = "";

            // Copy remaining lines starting from the fourth line
            for (int i = 3; i < lines.length; i++) {
                remainingLines += " "+ lines[i];
            }
            List<Transaction> transactionList = extractTransactions(remainingLines);
            
           // transactionRepository.saveAll(transactionList);
            }

        }
    

    private static List<Transaction> extractTransactions(String transactionsData) {
        List<Transaction> transactionList = new ArrayList<>();

        // Split the transactions using a positive lookahead to find the date and time pattern
        String[] transactions = transactionsData.split("(?=\\s\\b(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{2}, \\d{4} \\d{2}:\\d{2} (?:am|pm))");

        // Process each transaction
        for (String transaction : transactions) {
            LocalDateTime dateTime = extractDateTime(transaction);
            String transactionId = extractTransactionId(transaction);
            double amount = extractAmount(transaction);
            String type = extractType(transaction);
            String details = extractDetails(transaction);

            // Create a Transaction object and add it to the list
            transactionList.add(new Transaction(transactionId, amount,dateTime, type, details));
        }

        return transactionList;
    }

    private static LocalDateTime extractDateTime(String transaction) {
    	transaction = transaction.trim();
    	Pattern pattern = Pattern.compile("\\b(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{2}, \\d{4} \\d{2}:\\d{2} (?:am|pm)");
        Matcher matcher = pattern.matcher(transaction);
        
        if (matcher.find()) {
            String matchedDateTime = matcher.group();
            matchedDateTime.trim();
            
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()  // Ignore case sensitivity
                    .appendPattern("MMM dd, yyyy hh:mm a")  // Append the pattern
                    .toFormatter(Locale.ENGLISH);  // Use English locale to parse month names
            try {
                return LocalDateTime.parse(matchedDateTime, formatter);
            } catch (DateTimeParseException e) {
                System.err.println("Failed to parse matched substring: " + matchedDateTime);
                e.printStackTrace();
                return null;
            }
        } else {
            System.err.println("No match found in input string: " + transaction);
            return null;
        }
    }


    private static String extractTransactionId(String transaction) {
        Pattern pattern = Pattern.compile("Transaction ID T(\\d+)");
        Matcher matcher = pattern.matcher(transaction);
        if (matcher.find()) {
            return matcher.group(1); // Return the matched group as a string
        } else {
            return null; // Or handle the case when ID is not found
        }
    }
    private static double extractAmount(String transaction) {
        // Define a pattern to match the amount preceded by "?"
    	Pattern pattern = Pattern.compile("\\?(\\d{1,3}(?:,\\d{3})*(?:\\.\\d{1,2})?)");


        // Create a matcher for the pattern
        Matcher matcher = pattern.matcher(transaction);

        // Check if the pattern is found in the transaction
        if (matcher.find()) {
            // Extract the matched amount string
            String amountStr = matcher.group(1);
            
            // Remove commas and parse the amount to double
            amountStr = amountStr.replace(",", "");
            System.out.println("Matched amount string: " + amountStr); // Debugging
            return Double.parseDouble(amountStr);
        } else {
            // If no amount is found, print a debug message
            System.out.println("Amount not found in transaction: " + transaction); // Debugging
            return -1;
        }
    }





    private static String extractType(String transaction) {
        if (transaction.contains("DEBIT")) {
            return "DEBIT";
        } else if (transaction.contains("CREDIT")) {
            return "CREDIT";
        } else {
            return "Unknown";
        }
    }

    private static String extractDetails(String transaction) {
        // Assuming details start after the amount
        int startIndex = transaction.indexOf("?");
        if (startIndex != -1) {
            return transaction.substring(startIndex);
        } else {
            return "Not found";
        }
    }
}
