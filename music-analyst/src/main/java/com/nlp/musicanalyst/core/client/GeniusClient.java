package com.nlp.musicanalyst.core.client;

import com.nlp.musicanalyst.core.client.resource.search.SearchGeniusResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "genius-client", url = "http://api.genius.com")
public interface GeniusClient {

    @GetMapping("/search?q={artist}")
    SearchGeniusResource search(@RequestParam String artist);


}
