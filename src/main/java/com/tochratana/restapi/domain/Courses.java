package com.tochratana.restapi.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Courses {
    private String code;
    private String id;
    private String title;
    private Double price;
    private Boolean status;
}
