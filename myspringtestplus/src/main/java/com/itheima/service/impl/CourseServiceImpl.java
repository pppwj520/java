package com.itheima.service.impl;
import com.itheima.dao.Coursemapper;
import com.itheima.pojo.Course;
import com.itheima.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

//    public boolean saveRegister(Course course, MultipartFile file){
//        if (file != null){
//            // 原始文件名
//            String originalFileName = file.getOriginalFilename();
//            // 获取图片后缀
//            String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
//            // 生成图片存储的名称，UUID 避免相同图片名冲突，并加上图片后缀
//            String fileName = UUID.randomUUID().toString() + suffix;
//            // 图片存储路径
//            String filePath = constans.IMG_PATH + fileName;
//            File saveFile = new File(filePath);
//            try {
//                // 将上传的文件保存到服务器文件系统
//                file.transferTo(saveFile);
//                // 记录服务器文件系统图片名称
//                course.setCoursepic(fileName);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        // 持久化 user
//        return coursemapper.updateCourse(course) >0;
//    }

}
