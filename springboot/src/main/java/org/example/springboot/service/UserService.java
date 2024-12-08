package org.example.springboot.service;
import org.example.springboot.entity.Student;
import org.example.springboot.entity.Teacher;
import org.example.springboot.entity.UserAccount;
import org.example.springboot.exception.CustomerException;
import org.example.springboot.mapper.TeacherMapper;
import org.example.springboot.mapper.StudentMapper;
import org.example.springboot.mapper.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserAccountMapper userMapper;
    TeacherMapper teacherMapper;
    StudentMapper studentMapper;
    public UserAccount login(UserAccount user) {
        String username=user.getUsername() ;//账号名
        String password=user.getPassword() ;
        UserAccount dbUser =userMapper.selectByUsername(username);//先查有没有这个账号
        if(dbUser==null){
            throw new CustomerException("500","账号不存在");
        }   
        Integer userId  = userMapper.selectIdByUsernameAndPassword(username, password);
        if (userId == null) {
            throw new CustomerException("500", "无法获取用户ID");
        }
        dbUser.setUserId(userId);
        String identity = dbUser.getIdentity();
        //加一段把dbUser的user_id设置为从前端输入(username和密码)这样的user对应的users表中的id
        if ("teacher".equalsIgnoreCase(identity)) {

            Teacher teacher = teacherMapper.selectById(userId);
            // 验证teacher是否为空
            if (teacher == null) {
                throw new CustomerException("500", "教师信息不存在");
            }
            return teacher; // 直接返回Teacher对象
        } else if ("student".equalsIgnoreCase(identity)) {

            Student student = studentMapper.selectById(userId);
            // 验证student是否为空
            if (student == null) {
                throw new CustomerException("500", "学生信息不存在");
            }
            return student; // 直接返回Student对象
        }
        throw new CustomerException("500", "未知的用户身份");



//        String password =user.getPassword() ;//密码
//        if (!dbUser.getPassword().equals(password)) {
//            throw new CustomerException("500","账号密码错误");
//        }
//        if(dbUser.getIdentity()==null|| dbUser.getIdentity().isEmpty()){
//            throw new CustomerException("500","角色名不能为空");
//        }
//
//        String Identity=user.getIdentity() ;
//        if (!dbUser.getIdentity().equals(Identity)) {
//            throw new CustomerException("500", "用户角色不匹配");
//        }
//        Integer userId  = userMapper.selectIdByUsernameAndPassword(username, password);
//        if (userId == null) {
//            throw new CustomerException("500", "无法获取用户ID");
//        }
//        dbUser.setUserId(userId);
////这里我想进一步通过上面的userid和identity,在teachers/students表中查询到一些用户具体信息
//        if ("teacher".equals(dbUser.getIdentity().toLowerCase())) {
//            //可以在teacher对应的mapper里面查询吗？
//            Teacher teacherInfo = teacherMapper.selectById(userId);
//            dbUser.setTeacherInfo(teacherInfo);//如何设置？
//        } else if ("student".equals(dbUser.getIdentity().toLowerCase())) {
//            Student studentInfo = studentMapper.selectById(userId);
//            dbUser.setStudentInfo(studentInfo);//？
//        }
//
//return dbUser ;
    }

//    public UserAccount register(UserAccount user) {
//        String username=user.getUsername() ;//账号名
//
//        UserAccount dbUser =userMapper.selectByUsername(username);//先查有没有这个账号
//        if(dbUser!=null){
//            throw new CustomerException("500","账号已存在，请更换别的账号");
//        }
//        if(user.getPassword()==null||user.getPassword().isEmpty()){
//            throw new CustomerException("500","密码不能为空");
//        }
//        if(user.getUsername()==null|| user.getUsername().isEmpty()){
//            throw new CustomerException("500","账号名不能为空");
//        }
//userMapper.insert(user);
//return user ;
    }




