import com.edu.Dao.StudentDao;
import com.edu.Entity.Hobby;
import com.edu.Entity.Student;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

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

    // 创建学生并创建其爱好
    @Test
    public void createStuHobby(){
        Student s=new Student();
        s.setName("小李");
        s.setAge(25);
        s.setPassword("xiaoli");

        // 创建泛型
        List<Hobby> hobbyList = new ArrayList<>();
        Hobby hobby1 = new Hobby();
        hobby1.setName("乒乓球");
        //绑定学生信息
        hobby1.setStudent(s);

        Hobby hobby2 = new Hobby();
        hobby2.setName("篮球");
        hobby2.setStudent(s);

        Hobby hobby3 = new Hobby();
        hobby3.setName("书法");
        hobby3.setStudent(s);

        // 将对象添加到泛型中
        hobbyList.add(hobby1);
        hobbyList.add(hobby2);
        hobbyList.add(hobby3);
        //绑定爱好信息
        s.setHobbyList(hobbyList);
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

    //查找所有用户
    @Test
    public void findAll(){
        List<Student> studentList = new ArrayList<>();
        // 调用StudentDao中方法查询所有用户并返回泛型列表
        studentList = sDao.getAll();
        Student s = new Student();
        // 循环取出studentList中的对象并打印学生姓名
        for (int i = 0; i < studentList.size(); i++) {
            s= studentList.get(i);
            System.out.println(s.getName());
        }
    }
}
