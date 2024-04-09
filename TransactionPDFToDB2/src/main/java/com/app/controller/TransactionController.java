package com.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.TransactionService;

import java.io.IOException;

@Controller
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/upload")
    public String showUploadForm() {
        return "upload-form";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please select a file to upload");
            return "redirect:/upload";
        }

        try {
            if (!file.getContentType().equals("application/pdf")) {
                redirectAttributes.addFlashAttribute("error", "Please upload a PDF file");
                return "redirect:/upload";
            }
            System.out.println("Erverthing is correct before transaction service");
            transactionService.processTransactionsFromPdf(file);
            System.out.println("after file upload to database");
            redirectAttributes.addFlashAttribute("message", "File uploaded successfully");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "Failed to upload file");
            e.printStackTrace();
        }

        return "redirect:/upload";
    }
}
