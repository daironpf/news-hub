package com.news.hub.languageservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Node
public class Language {
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private String name;
    private String url;
    private String abbreviation;
    private String urlFlag;
    private Boolean status;
}
