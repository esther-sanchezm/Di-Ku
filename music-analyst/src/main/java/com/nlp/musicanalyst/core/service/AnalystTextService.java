package com.nlp.musicanalyst.core.service;

import com.nlp.musicanalyst.core.controller.model.response.Analyst;

import java.io.IOException;

public interface AnalystTextService {

    Analyst sentimentSongAnalyst(String artist, String song) throws IOException;

    Analyst processSentimentAnalyst(String text);

}
