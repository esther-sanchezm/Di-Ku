package com.nlp.musicanalyst.model.response;

import com.nlp.musicanalyst.model.response.detail.DetailSentimentAnalyst;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Analyst {
    
    private String generalSentiment; 
    
    private DetailSentimentAnalyst detailSentimentAnalyst;
    
    private String text;
}
