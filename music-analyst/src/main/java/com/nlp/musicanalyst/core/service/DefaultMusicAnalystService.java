package com.nlp.musicanalyst.core.service;

import com.nlp.musicanalyst.core.client.GeniusClient;
import com.nlp.musicanalyst.core.client.resource.search.SearchGeniusResource;
import com.nlp.musicanalyst.core.client.resource.search.response.hits.HitsTracksResource;
import com.nlp.musicanalyst.core.controller.model.response.Analyst;
import com.nlp.musicanalyst.core.controller.model.response.detail.DetailSentimentAnalyst;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import org.ejml.simple.SimpleMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Properties;

@Service
public class DefaultMusicAnalystService implements AnalystTextService {

    private static final String ANNOTATORS_KEY = "annotators";
    private static final double PERCENTAGE = 100d;
    private static final String SYMBOL_PERCENTAGE = "%";
    private static final int VERY_POSITIVE = 4;
    private static final int POSITIVE = 3;
    private static final int NEUTRAL = 2;
    private static final int NEGATIVE = 1;
    private static final int VERY_NEGATIVE = 0;

    @Value("${token}")
    private String GENIUS_TOKEN;

    @Autowired
    private GeniusClient geniusClient;

    private StanfordCoreNLP getPipelineStanfordCoreNLP(){
        Properties props = new Properties();
        props.setProperty(ANNOTATORS_KEY, "tokenize, ssplit, parse, sentiment");
        return new StanfordCoreNLP(props);
    }
    
    @Override
    public Analyst sentimentSongAnalyst(String artist, String song){
        String text = obtainLyrics(artist, song);
        return processSentimentAnalyst(text);
    }

    @Override
    public Analyst processSentimentAnalyst(String text) {
        Analyst sentimentAnalyst = new Analyst();
        // run all Annotators on the text
        Annotation annotation = getPipelineStanfordCoreNLP().process(text);

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

    private String obtainLyrics(String artist, String song) {
        SearchGeniusResource searchGeniusResource = this.geniusClient.search(GENIUS_TOKEN, artist);
        List<HitsTracksResource> listHits = searchGeniusResource.getResponse().getHits();
        Optional<HitsTracksResource> optionalHitsResponse = listHits.stream()
                .filter(search -> search.getTitle().equals(song))
                .findFirst();
        if (optionalHitsResponse.isPresent()) {
            String lyricsUrl = optionalHitsResponse.get().getUrl();
        } else {
            throw new NoSuchElementException();
        }
        return "";
    }

    private String parsePercentage(double value){
        return String.valueOf((double)Math.round(value * PERCENTAGE));
    }
}
