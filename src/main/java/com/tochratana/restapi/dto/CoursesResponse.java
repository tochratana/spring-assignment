package com.tochratana.restapi.dto;

import lombok.Builder;

@Builder
public record CoursesResponse (
        String id,
         String code,
         String title,
         double price,
         Boolean status
) {
}
