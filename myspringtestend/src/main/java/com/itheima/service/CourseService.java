package com.itheima.service;

import com.itheima.pojo.Course;
import com.itheima.pojo.user;

import java.util.List;

public interface CourseService {
    int addcourse(Course course);
    Course findCourseByname(String name);
    Course findCourseByid(int id);
    user login(user u);
    int updateCourse(Course course);
    int deleteCourseByid(int id);
    List<Course> findAllCourse();
    int updateouto1();
}
