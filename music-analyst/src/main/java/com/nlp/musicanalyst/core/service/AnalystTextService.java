package com.nlp.musicanalyst.core.service;

import com.nlp.musicanalyst.core.controller.model.response.Analyst;

public interface AnalystTextService {

    Analyst sentimentSongAnalyst(String artist, String song, String token);

    Analyst processSentimentAnalyst(String text, String token);

}
