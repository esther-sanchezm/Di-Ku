package com.nlp.musicanalyst.core.client.resource.search.response.hits.result;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultGeniusResource {
    private String title;

    private Integer id;

    private String url;
}
