package com.post.hub.languageservice.controller;

import com.post.hub.languageservice.dto.LanguageRequest;
import com.post.hub.languageservice.dto.LanguageResponse;
import com.post.hub.languageservice.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/languages")
public class LanguageController {
    private final LanguageService languageService;

    @PostMapping
    public ResponseEntity<LanguageResponse> createLanguage(@RequestBody LanguageRequest languageRequest){
        return new ResponseEntity<>(languageService.addLanguage(languageRequest),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LanguageResponse>> getAllLanguage(){
        return new ResponseEntity<>(languageService.getAllLanguage(),HttpStatus.OK);
    }

    @GetMapping("{languageId}")
    public ResponseEntity<LanguageResponse> getLanguage(@PathVariable("languageId") String languageId){
        LanguageResponse languageResponse = languageService.findLanguageById(languageId);
        return new ResponseEntity<>(languageResponse, HttpStatus.FOUND);
    }

    @DeleteMapping("{languageId}")
    public ResponseEntity<String> deleteLanguage(@PathVariable("languageId") String languageId) {
        return new ResponseEntity<>(languageService.deleteLanguageById(languageId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<LanguageResponse> updateLanguage(@RequestBody LanguageResponse languageResponse) {
        return new ResponseEntity<>(languageService.updateLanguage(languageResponse),HttpStatus.OK);
    }
}
