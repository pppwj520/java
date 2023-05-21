package com.itheima.dao;

import com.itheima.pojo.Course;

import java.util.List;

public interface Coursemapper {
    public int addcourse(Course course);
    public Course findCourseByname(String name);
    public Course findCourseByid(int id);
    public void updateouto();
    public int updateouto1();
    public int updateCourse(Course course);
    public int deleteCourseByid(int id);
    List<Course> findAllCourse();

}
