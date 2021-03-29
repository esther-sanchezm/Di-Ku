package com.nlp.musicanalyst.controller;

import com.nlp.musicanalyst.service.MusicAnalystService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultMusicAnalystController implements MusicAnalystController {
    
    private MusicAnalystService musicAnalystService;
    
    @Autowired
    public DefaultMusicAnalystController(){
    }

    @Override
    @GetMapping("/text/{text}/sentiment-analyst")
    public String sentimentAnalyst(@PathVariable String text) {
        return musicAnalystService.sentimentAnalyst(text);
    }

}
