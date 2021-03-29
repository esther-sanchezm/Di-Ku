# Sentiment Analyst Musical
This project looks for songs and recovers the feeling they have that can be: ``very positive``, ``positive``, ``neutral``, ``negative`` or ``very negative``. 

## Operations

#### Process song

Example of petition to process song sentiment analyst. That operation retrieve sentiment analyst of that song.
```
    POST http://localhost:8118/song/{artist}/{song}
```
#### Retrieve song

Example of petition to retrieve song. That song retrieve must be process before. 
```
    GET http://localhost:8118/song/{artist}/{song}
```

```
    GET http://localhost:8118/song?artist={artist}&song={song}&sentiment={sentiment}
```

## How to build this project
#### Prerrequisites
- JDK 11
- Maven

#### Build
- Maven clean install
- Spring boot run
