package com.tochratana.restapi.controller;

import com.tochratana.restapi.dto.CoursesResponse;
import com.tochratana.restapi.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CoursesService coursesService;

    /* 1️⃣  /api/v1/courses?status=true
          Matches ONLY when _title_ is absent */
    @GetMapping(params = "status")
    public List<CoursesResponse> byStatus(
            @RequestParam(required = false) Boolean status) {

        return coursesService.getCoursesStatus(status);
    }

    /* 2️⃣  /api/v1/courses?status=true&title=spring
           Matches ONLY when BOTH params are present */
    @GetMapping
    public List<CoursesResponse> byStatusAndTitle(
            @RequestParam Boolean status,
            @RequestParam String  title) {

        return coursesService.getCourses(status, title);
    }

    @GetMapping("/search/{code}")
    public CoursesResponse getCoursesByCode(@PathVariable String code){
        return coursesService.getCoursesByCode(code);
    }

    @GetMapping("/{id}")
    public CoursesResponse getCoursesById(@PathVariable String id){
        return coursesService.getCoursesById(id);
    }


}