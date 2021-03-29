package com.nlp.musicanalyst.controller;

import com.nlp.musicanalyst.model.response.Analyst;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface MusicAnalystController {


    ResponseEntity<Analyst> sentimentAnalyst(String text);

}
