package com.itheima.mapper;

import com.itheima.pojo.course;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;

import java.util.List;

public interface courseMapper {
     List <course> findByschoolname(String schoolname);

     List<course> findBycId(int id);
     List<course> findall();
     void updateHours(@Param("hours") int hours, @Param("id") int id);
     void updateouto();
     void addcourse(course c);
}
