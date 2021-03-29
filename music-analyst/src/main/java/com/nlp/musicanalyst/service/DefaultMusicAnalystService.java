package com.nlp.musicanalyst.service;

import com.nlp.musicanalyst.model.response.Analyst;
import com.nlp.musicanalyst.model.response.detail.DetailSentimentAnalyst;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import org.ejml.simple.SimpleMatrix;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class DefaultMusicAnalystService implements MusicAnalystService {

    private static final String ANNOTATORS_KEY = "annotators";
    private static final double PERCENTAGE = 100d;
    private static final String SYMBOL_PERCENTAGE = "%";
    private static final int VERY_POSITIVE = 4;
    private static final int POSITIVE = 3;
    private static final int NEUTRAL = 2;
    private static final int NEGATIVE = 1;
    private static final int VERY_NEGATIVE = 0;


    private StanfordCoreNLP getPipelineStanfordCoreNLP(String annotators){
        Properties props = new Properties();
        props.setProperty(ANNOTATORS_KEY, annotators);
        return new StanfordCoreNLP(props);
    }
    
    @Override
    public Analyst sentimentAnalyst(String text){
        Analyst sentimentAnalyst = new Analyst();
        // run all Annotators on the text
        Annotation annotation = getPipelineStanfordCoreNLP( "tokenize, ssplit, parse, sentiment").process(text);
        
        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            // this is the parse tree of the current sentence
            Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
            SimpleMatrix simpleMatrix = RNNCoreAnnotations.getPredictions(tree);
            sentimentAnalyst = Analyst.builder()
                    .text(text)
                    .generalSentiment(sentence.get(SentimentCoreAnnotations.SentimentClass.class))
                    .detailSentimentAnalyst(DetailSentimentAnalyst.builder()
                            .veryPositive(parsePercentage(simpleMatrix.get(VERY_POSITIVE)))
                            .positive(parsePercentage(simpleMatrix.get(POSITIVE)))
                            .neutral(parsePercentage(simpleMatrix.get(NEUTRAL)))
                            .negative(parsePercentage(simpleMatrix.get(NEGATIVE)))
                            .veryNegative(parsePercentage(simpleMatrix.get(VERY_NEGATIVE)))
                            .build())
            .build();
        }
        
        return sentimentAnalyst;
    }
    
    private String parsePercentage(double value){
        return String.valueOf(Math.round(value) * PERCENTAGE).concat(SYMBOL_PERCENTAGE);
    }
}
