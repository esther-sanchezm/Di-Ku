package com.nlp.musicanalyst.core.controller;

import com.nlp.musicanalyst.core.controller.model.response.Analyst;
import com.nlp.musicanalyst.core.service.AnalystTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class DefaultMusicAnalystController implements MusicAnalystController {
    
    @Autowired
    private AnalystTextService analystTextService;

    @Override
    public ResponseEntity<Analyst> getSentimentAnalyst(String artist, String song) throws IOException {
       return new ResponseEntity<>(analystTextService.sentimentSongAnalyst(artist, song),HttpStatus.OK);
    }

}
