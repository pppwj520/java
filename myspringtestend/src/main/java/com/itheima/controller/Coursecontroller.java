package com.itheima.controller;

import com.itheima.pojo.Course;
import com.itheima.pojo.user;
import com.itheima.service.CourseService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;



@Controller
public class Coursecontroller {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/login")
    public String login(user u,HttpSession session){
        user t = courseService.login(u);
        if(t!=null){
            String email = t.getEmail();
            session.setAttribute("email",email);
            return "redirect:/allcourse";
        }else {
            return "defeat";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            return "login";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("msg","系统错误");
            return "login";
        }
    }
    @RequestMapping(value = "/addcourse",method = RequestMethod.POST)
    public String addcouse(Course c,ModelAndView modelAndView) throws IOException {
        String name = c.getName();
        String schoolname = c.getSch().getSchoolname();
        int flag = -1;
       try {
           Course cm = courseService.findCourseByname(name);
           if(cm == null){
               if(schoolname.equals("计算机学院")){
                   c.setSchool(1);
                   flag = 1;
               } else if (schoolname.equals("外国语学院")) {
                   c.setSchool(2);
                   flag = 1;
               }
           }else {
               System.out.println(cm.getName());
               flag = 0;
           }
       }catch (Exception e){
           e.printStackTrace();
       }
        System.out.println("用户名 : " +c.getName());
        System.out.println("文件名字 : "+ c.getImg());

        //获取上传文件的名称
        String originalFilename = c.getImg().getOriginalFilename();

        System.out.println("上传的文件的名称是 : "+originalFilename);
        if(originalFilename.isEmpty()){
            originalFilename = "111.png";
        }
        String Imgpath = "/picture1/" + originalFilename;
        c.setImgurl(Imgpath);

        System.out.println(c.getSchool());

        if(!originalFilename.equals("111.png")) {
            c.getImg().transferTo(new File("D:\\javaweb\\myspringtestplus\\src\\main\\webapp" + Imgpath));
        }
        System.out.println(c.getImgurl());

        if(flag == 1){
           courseService.addcourse(c);
           System.out.println("添加成功");
           modelAndView.addObject("c",c);
           return "redirect:/allcourse";
       }else{
           System.out.println("添加失败");
           return "defeat";
       }
    }

    @RequestMapping("/toaddcourse")
    public String toaddcourse(){
        return "addcourse";
    }
    @RequestMapping("/")
    public String intt(){
        return "login";
    }
    //所有课程信息
    @RequestMapping("/allcourse")
    public String list(Model model){
        List<Course> courses = courseService.findAllCourse();
        for (Course c:courses) {
            if(c.getSchool()==1){
                c.setSchoolname("计算机学院");
            } else if (c.getSchool()==2) {
                c.setSchoolname("外国语学院");
            }
        }
        model.addAttribute("courses",courses);
        return "allcourse";
    }
    //修改课程
    @RequestMapping("/toupdatecourse")
    public String toupdatecourse(Model model,int id){
        Course course = courseService.findCourseByid(id);
        System.out.println(course);
        model.addAttribute("course",course);
        return "updatecourse";
    }
    @RequestMapping("/updatecourse")
    public String updatecourse(Model model,Course course) throws IOException {
        System.out.println(course);
        if(course.getSchoolname().equals("计算机学院")){
            course.setSchool(1);
        } else if (course.getSchoolname().equals("外国语学院")) {
            course.setSchool(2);
        }

        System.out.println("文件名字 : "+ course.getImg());

        //获取上传文件的名称
        String originalFilename = course.getImg().getOriginalFilename();

        System.out.println("上传的文件的名称是 : "+originalFilename);

        if(originalFilename.isEmpty()){
            originalFilename = "111.png";
        }

        String Imgpath = "/picture1/" + originalFilename;
        course.setImgurl(Imgpath);


        System.out.println(course.getSchool());

        if(!originalFilename.equals("111.png")) {
            course.getImg().transferTo(new File("D:\\javaweb\\myspringtestplus\\src\\main\\webapp" + Imgpath));
        }

        System.out.println(course.getImgurl());

        courseService.updateCourse(course);
        Course courses = courseService.findCourseByid(course.getId());
        model.addAttribute("courses",courses);
        return "redirect:/allcourse";
    }
    //删除
    @RequestMapping("/del/{courseid}")
    public String deletecourse(@PathVariable("courseid")int id){
    courseService.deleteCourseByid(id);
    courseService.updateouto1();
    System.out.println("删除成功！");
    return "redirect:/allcourse";
    }
}
