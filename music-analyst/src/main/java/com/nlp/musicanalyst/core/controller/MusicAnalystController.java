package com.nlp.musicanalyst.core.controller;

import com.nlp.musicanalyst.core.controller.model.response.Analyst;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface MusicAnalystController {

    @PostMapping("/song/{artist}/{song}/sentiment-analyst")
    ResponseEntity<Analyst> processSentimentAnalyst(@PathVariable String artist, @PathVariable String song);

    @GetMapping("/song/{artist}/{song}/sentiment-analyst")
    ResponseEntity<Analyst> getSentimentAnalyst(@PathVariable String artist, @PathVariable String song);
    
    @GetMapping("/song")
    ResponseEntity<List<Analyst>> findAllSentimentAnalyst(@RequestParam String artist, @RequestParam String song, @RequestParam String sentiment);
}
