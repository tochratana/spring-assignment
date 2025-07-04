package com.tochratana.restapi.service.impl;

import com.tochratana.restapi.domain.Courses;
import com.tochratana.restapi.dto.CoursesResponse;
import com.tochratana.restapi.repository.CoursesRepository;
import com.tochratana.restapi.service.CoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CoursesServiceImpl implements CoursesService {
    private final CoursesRepository coursesRepository;

    @Override
    public List<CoursesResponse> getCoursesStatus(Boolean status) {
        return coursesRepository.getCourses().stream()
                .filter(c -> status == null || c.getStatus().equals(status))
                .map(this::toDto)
                .toList();
    }

    @Override
    public List<CoursesResponse> getCourses(Boolean status, String title) {
        return coursesRepository.getCourses().stream()
                .filter(c -> (status == null || c.getStatus().equals(status)) &&
                        (title  == null || c.getTitle()
                                .toLowerCase()
                                .contains(title.toLowerCase())))
                .map(this::toDto)
                .toList();
    }

    @Override
    public CoursesResponse getCoursesByCode(String code) {
        return coursesRepository.getCourses().stream()
                .filter(courses -> courses.getCode().equals(code))
                .map(this::toDto)
                .findFirst()
                .orElseThrow(()->new RuntimeException("Can't find courses " + code));
    }

    @Override
    public CoursesResponse getCoursesById(String id) {
        return coursesRepository.getCourses().stream()
                .filter(courses -> Objects.equals(courses.getId(), id))
                .map(this::toDto)
                .findFirst()
                .orElseThrow(()->new RuntimeException("Error"));
    }

    /* TODO mapper*/
    private CoursesResponse toDto(Courses c) {
        return CoursesResponse.builder()
                .id(c.getId())
                .code(c.getCode())
                .title(c.getTitle())
                .price(c.getPrice())
                .status(c.getStatus())
                .build();
    }
}
