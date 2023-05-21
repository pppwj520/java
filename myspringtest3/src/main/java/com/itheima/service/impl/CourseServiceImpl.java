package com.itheima.service.impl;
import com.itheima.dao.Coursemapper;
import com.itheima.pojo.Course;
import com.itheima.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private Coursemapper coursemapper;
    @Override
    public int addcourse(Course course) {
        coursemapper.updateouto();
        return coursemapper.addcourse(course);
    }

    @Override
    public Course findCourseByname(String name) {

        return coursemapper.findCourseByname(name);
    }

    @Override
    public Course findCourseByid(int id) {
        return coursemapper.findCourseByid(id);
    }

    @Override
    public int updateCourse(Course course) {
        return coursemapper.updateCourse(course);
    }

    @Override
    public int deleteCourseByid(int id) {
        return coursemapper.deleteCourseByid(id);
    }

    @Override
    public List<Course> findAllCourse() {
        return coursemapper.findAllCourse();
    }

    @Override
    public int updateouto1() {
        return coursemapper.updateouto1();
    }

}
