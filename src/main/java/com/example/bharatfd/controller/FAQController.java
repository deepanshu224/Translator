package com.example.bharatfd.controller;

import com.example.bharatfd.models.FAQ;
import com.example.bharatfd.service.FAQService;
import com.example.bharatfd.service.GoogleTranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/faqs")
public class FAQController {

    @Autowired
    private FAQService faqService;

    @Autowired
    private GoogleTranslateService translateService;

    @GetMapping(value="/lang",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FAQ> getFAQs(@RequestParam(name="lang") String targetLanguage) {
        List<FAQ> faqs = faqService.findAll("en"); // Assuming original language is "en"

        return faqs.stream().map(faq -> {
            faq.setQuestion(translateService.translateText(faq.getQuestion(), targetLanguage));
            faq.setAnswer(translateService.translateText(faq.getAnswer(), targetLanguage));
            return faq;
        }).collect(Collectors.toList());
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFAQ(@RequestBody FAQ faq) {
        return ResponseEntity.status(HttpStatus.OK).body(faqService.save(faq));
    }
}
