package com.example.demo.controller;

import com.example.demo.model.ContentOffering;
import com.example.demo.service.ContentOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/content")
public class ContentOfferingController {

    @Autowired
    private ContentOfferingService contentOfferingService;

    @GetMapping
    public String getAllContentOfferings(Model model) {
        List<ContentOffering> contentOfferings = contentOfferingService.getAllContentOfferings();
        model.addAttribute("contentOfferings", contentOfferings);
        return "home";
    }

    @GetMapping("/new")
    public String showAddContentForm(Model model) {
        model.addAttribute("contentOffering", new ContentOffering());
        return "addContent";
    }

    @PostMapping("/add")
    public String addContentOffering(@RequestParam("title") String title,
                                     @RequestParam("description") String description,
                                     @RequestParam("price") BigDecimal price,
                                     @RequestParam("file") MultipartFile file) throws IOException {
        ContentOffering contentOffering = new ContentOffering();
        contentOffering.setTitle(title);
        contentOffering.setDescription(description);
        contentOffering.setPrice(price);
        contentOffering.setFile(file.getBytes());
        contentOfferingService.saveContentOffering(contentOffering);
        return "redirect:/content";
    }

    @GetMapping("/delete/{id}")
    public String deleteContentOffering(@PathVariable Long id) {
        contentOfferingService.deleteContentOffering(id);
        return "redirect:/content";
    }
}
