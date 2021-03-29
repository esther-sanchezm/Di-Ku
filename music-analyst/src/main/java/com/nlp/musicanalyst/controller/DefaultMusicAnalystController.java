package com.nlp.musicanalyst.controller;

import com.nlp.musicanalyst.model.response.Analyst;
import com.nlp.musicanalyst.service.MusicAnalystService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DefaultMusicAnalystController implements MusicAnalystController {
    
    @Autowired
    private MusicAnalystService musicAnalystService;
    
    @Override
    @PostMapping("/text/sentiment-analyst")
    public ResponseEntity<Analyst> sentimentAnalyst(@RequestBody String text) {
        return new ResponseEntity<>(musicAnalystService.sentimentAnalyst(text),HttpStatus.OK);
    }

}
