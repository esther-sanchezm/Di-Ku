package com.nlp.musicanalyst.core.client.resource.search.response.hits;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HitsTracksResource {

    private String title;

    private Integer id;

    private String url;

}
