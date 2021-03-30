package com.nlp.musicanalyst.controller;

import com.nlp.musicanalyst.controller.model.response.Analyst;
import com.nlp.musicanalyst.service.MusicAnalystService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DefaultMusicAnalystController implements MusicAnalystController {
    
    @Autowired
    private MusicAnalystService musicAnalystService;

    @Override
    public ResponseEntity<Analyst> processSentimentAnalyst( String artist, String song) {
        return new ResponseEntity<>(musicAnalystService.sentimentAnalyst(),HttpStatus.OK);
    }
    
   @Override
    public ResponseEntity<Analyst> getSentimentAnalyst(String artist, String song) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<List<Analyst>> findAllSentimentAnalyst(String artist, String song, String sentiment) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
