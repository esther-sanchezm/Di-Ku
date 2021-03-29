package com.nlp.musicanalyst.service;

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

    private static final String SENTIMENT = "sentiment";
    private static final String ANNOTATORS = "annotators";
    
    private StanfordCoreNLP pipeline;
    
    public void DefaultMusicAnalystService() {
        Properties props = new Properties();
        props.setProperty(ANNOTATORS, SENTIMENT);
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    }
    
    @Override
    public String sentimentAnalyst(String text){
        StringBuilder listSentimentAnalyst = new StringBuilder();
        // run all Annotators on the text
        Annotation annotation = pipeline.process(text);

        for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
            // this is the parse tree of the current sentence
            String sentimentType = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
            listSentimentAnalyst.append(sentimentType);
        }
        
        return listSentimentAnalyst.toString();
    }
    
}
