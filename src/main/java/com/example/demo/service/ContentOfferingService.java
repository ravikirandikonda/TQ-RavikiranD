package com.example.demo.service;

import com.example.demo.model.ContentOffering;
import com.example.demo.repository.ContentOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentOfferingService {
    @Autowired
    private ContentOfferingRepository contentOfferingRepository;

    public List<ContentOffering> getAllContentOfferings() {
        return contentOfferingRepository.findAll();
    }

    public ContentOffering getContentOfferingById(Long id) {
        return contentOfferingRepository.findById(id).orElse(null);
    }

    public ContentOffering saveContentOffering(ContentOffering contentOffering) {
        return contentOfferingRepository.save(contentOffering);
    }

    public void deleteContentOffering(Long id) {
        contentOfferingRepository.deleteById(id);
    }
}
