import com.edu.Dao.StudentDao;
import com.edu.Entity.Student;
import org.junit.Test;

import java.sql.SQLOutput;

// 测试类
public class StudentDaoTest {
    // 创建操作接口对象
    StudentDao sDao = new StudentDao();

    //测试新增用户
    @Test
    public void createStu(){
        // 创建学生对象
        Student s = new Student();
        // 设置该对象属性
        s.setName("小丽");
        s.setAge(19);
        s.setPassword("xiaoli");
        // 调用Dao保存对象，写入MySQL
        sDao.save(s);
    }

    // 根据学号（主键）查找用户
    @Test
    public void findOne(){
        // 调用StudentDao查找用户
        Student s=sDao.getOne(3L);
        System.out.println(s.getName());
    }

    // 更新用户信息
    @Test
    public void update(){
        // 先从表中查找存在的用户
        Student s = sDao.getOne(3L);
        // 修改用户属性
        s.setAge(22);
        // 利用StudentDao更新
        sDao.update(s);
    }

    // 删除用户信息
    @Test
    public void remove(){
        // 调用StudentDao根据学号删除信息
        sDao.delete(3L);
    }
}
