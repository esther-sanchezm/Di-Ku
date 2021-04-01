package com.nlp.musicanalyst.core.service;

import com.nlp.musicanalyst.core.controller.model.response.Analyst;

public interface AnalystTextService {

    Analyst sentimentSongAnalyst(String artist, String song);

    Analyst processSentimentAnalyst(String text);

}
