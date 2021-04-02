# Sentiment Analyst Musical
This project looks for songs and recovers the feeling they have that can be: ``very positive``, ``positive``, ``neutral``, ``negative`` or ``very negative``. 
Feeling attends only of lyrics.

## Process and retrieve song

Example of petition to process retrieve song. That song retrieve must be process before. 
```
    GET http://localhost:8118/song/{song}/artist/{artist}
```

## Dependencies
Important dependencies that use sentiment analyst musical.
* **Stanford core NLP**: use for sentiment analyst.
* **Genius API**: use for retrieve lyrics.

## How to build this project
#### Prerrequisites
- JDK 11
- Maven

#### Build
- Maven clean install
- Spring boot run

### Properties
Need genius token to search in **Genius**
```
    token: ${TOKEN_GENIUS}
```