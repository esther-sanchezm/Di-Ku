package com.nlp.musicanalyst.core.controller;

import com.nlp.musicanalyst.core.controller.model.response.Analyst;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public interface MusicAnalystController {
    
    @PostMapping("/song/{song}/artist/{artist}/sentiment-analyst")
    ResponseEntity<Analyst> processSentimentAnalyst(@PathVariable String artist, @PathVariable String song) throws IOException;

    @GetMapping("/song/{song}/artist/{artist}/sentiment-analyst")
    ResponseEntity<Analyst> getSentimentAnalyst(@PathVariable String artist, @PathVariable String song) throws IOException;
    
    @GetMapping("/song")
    ResponseEntity<List<Analyst>> findAllSentimentAnalyst(@RequestParam String artist, @RequestParam String song, @RequestParam String sentiment);
}
