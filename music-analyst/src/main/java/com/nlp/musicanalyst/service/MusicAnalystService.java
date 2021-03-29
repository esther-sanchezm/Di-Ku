package com.nlp.musicanalyst.service;

import com.nlp.musicanalyst.model.response.Analyst;

public interface MusicAnalystService {

    Analyst sentimentAnalyst(String text);
}
