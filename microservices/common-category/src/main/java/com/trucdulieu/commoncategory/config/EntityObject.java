package com.trucdulieu.commoncategory.config;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@MappedSuperclass
public class EntityObject {

    @Id
    // @GeneratedValue(generator = "UUID")
    // @org.hibernate.annotations.GenericGenerator(
    //     name = "UUID",
    //     strategy = "org.hibernate.id.UUIDGenerator"
    // )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonIgnore
    private final String organizationId = Constant.BASE_ORGANIZATION_ID;
    private String description;
}
