package com.nlp.musicanalyst.model.response.detail;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailSentimentAnalyst {

    private String veryPositive;

    private String positive;

    private String neutral;
    
    private String negative;

    private String veryNegative;
}
