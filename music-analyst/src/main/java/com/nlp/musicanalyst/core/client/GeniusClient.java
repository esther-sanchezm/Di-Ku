package com.nlp.musicanalyst.core.client;

import com.nlp.musicanalyst.core.client.resource.search.SearchGeniusResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "genius-client", url = "https://api.genius.com")
public interface GeniusClient {

    String AUTH_TOKEN = "Authorization";

    @GetMapping("/search?q={song}")
    SearchGeniusResource search(@RequestHeader(AUTH_TOKEN) String authorizationHeader, @RequestParam String song);


}
