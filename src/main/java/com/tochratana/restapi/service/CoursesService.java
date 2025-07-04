package com.tochratana.restapi.service;

import com.tochratana.restapi.dto.CoursesResponse;

import java.util.List;

public interface CoursesService {
    /**
     * Get All courses
     */
    List<CoursesResponse> getCoursesStatus(Boolean status);
    List<CoursesResponse> getCourses(Boolean status, String title);
    CoursesResponse getCoursesByCode(String code);
    CoursesResponse getCoursesById(String id);
}
