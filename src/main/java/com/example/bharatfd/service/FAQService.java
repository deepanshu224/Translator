package com.example.bharatfd.service;

import com.example.bharatfd.models.FAQ;
import com.example.bharatfd.repository.FAQRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FAQService {

    @Autowired
    private FAQRepository faqRepository;

    public List<FAQ> findAll(String en) {
        return faqRepository.findByLanguage(en);
    }

    @Transactional
    public FAQ save(FAQ faq) {
        return faqRepository.save(faq);
    }
}
