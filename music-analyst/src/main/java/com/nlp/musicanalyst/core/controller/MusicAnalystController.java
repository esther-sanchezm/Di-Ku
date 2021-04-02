package com.nlp.musicanalyst.core.controller;

import com.nlp.musicanalyst.core.controller.model.response.Analyst;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public interface MusicAnalystController {


    @GetMapping("/song/{song}/artist/{artist}/sentiment-analyst")
    ResponseEntity<Analyst> getSentimentAnalyst(@PathVariable String artist, @PathVariable String song) throws IOException;
    
  }
