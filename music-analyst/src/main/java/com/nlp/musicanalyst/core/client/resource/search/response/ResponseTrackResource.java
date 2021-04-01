package com.nlp.musicanalyst.core.client.resource.search.response;

import com.nlp.musicanalyst.core.client.resource.search.response.hits.HitsTracksResource;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseTrackResource {

    private List<HitsTracksResource> hits;
}
