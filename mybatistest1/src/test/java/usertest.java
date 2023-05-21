import com.itheima.pojo.course;
import com.itheima.mapper.courseMapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

public class usertest  {
    @Test
    public void userFindByidtset()throws Exception{
        String resources ="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        courseMapper coursemapper = sqlSession.getMapper(courseMapper.class);


        List<course> cm = coursemapper.findBycId(2);
        for (course it:cm) {
            System.out.println(it.toString());
        }

        sqlSession.close();
    }
    @Test
    public void userFindtest() throws Exception{
        String name = "计算机学院";
        String resources ="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        courseMapper coursemapper = sqlSession.getMapper(courseMapper.class);


        List<course> cm = coursemapper.findByschoolname(name);
        for (course it:cm) {
            System.out.println(it.toString());
        }

        sqlSession.close();

    }
    @Test
    public void updatetest()throws Exception{
        int id = 3;
        String resources ="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        courseMapper coursemapper = sqlSession.getMapper(courseMapper.class);

        try {
            coursemapper.updateHours(40, id);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        List<course> cm = coursemapper.findBycId(id);
        for (course it:cm) {
            System.out.println(it.toString());
        }

        sqlSession.close();
    }
    @Test
    public void addcoursetest()throws Exception{
        int hours = 32,school = 1;
        String name = "大数据存储";
        String resources ="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        courseMapper coursemapper = sqlSession.getMapper(courseMapper.class);

        course c = new course();
        c.setName(name);
        c.setHours(hours);
        c.setSchool(school);

        try {
            coursemapper.updateouto();
            coursemapper.addcourse(c);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }

        sqlSession.close();
    }
    @Test
    public void userFindall() throws Exception{
        String name = "计算机学院";
        String resources ="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        courseMapper coursemapper = sqlSession.getMapper(courseMapper.class);


        List<course> cm = coursemapper.findall();
        for (course it:cm) {
            System.out.println(it.toString());
        }

        sqlSession.close();

    }
}
