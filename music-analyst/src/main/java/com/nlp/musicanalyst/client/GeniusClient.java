package com.nlp.musicanalyst.client;

import com.nlp.musicanalyst.controller.model.request.Song;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "genius-client", url = "https://jsonplaceholder.typicode.com/")
public interface GeniusClient {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    void getToken(String username, String password);
    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    Song getLyrics(String song, String artist);
}
