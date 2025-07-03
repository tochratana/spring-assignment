package com.tochratana.restapi.repository;

import com.tochratana.restapi.domain.Courses;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Data
public class CoursesRepository {

    private List<Courses> courses;

    public CoursesRepository  (){
        courses = List.of(
                Courses.builder()
                        .id(UUID.randomUUID().toString())
                        .code("ISTAD-001")
                        .title("Spring Framework")
                        .price(12.50)
                        .status(true)        // lowercase field name
                        .build(),
                Courses.builder()
                        .id(UUID.randomUUID().toString())
                        .code("ISTAD-002")
                        .title("Next.js Framework")
                        .price(10.50)
                        .status(false)
                        .build(),
                Courses.builder()
                        .id(UUID.randomUUID().toString())
                        .code("ISTAD-003")
                        .title("TypeScript")
                        .price(10.50)
                        .status(false)
                        .build(),
                Courses.builder()
                        .id(UUID.randomUUID().toString())
                        .code("ISTAD-004")
                        .title("Java")
                        .price(10.50)
                        .status(false)
                        .build()
        );
    }
}
