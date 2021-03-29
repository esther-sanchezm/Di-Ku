package com.nlp.musicanalyst.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public interface MusicAnalystController {
   
    
    String sentimentAnalyst(String text);

}
