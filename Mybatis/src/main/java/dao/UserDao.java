package dao;

/*
*
* 通过session来对数据库进行操作
* 各种操作的第一个参数是User.xml文件的命名空间+对应的操作id
* */

import entity.SessionBean;
import entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class UserDao {
    /*设置为静态就不需要每次new了*/
    private static SqlSession session;
    static {
        session= SessionBean.getSession();
    }
    public static List<User> findAll(){
        return  session.selectList("jing.findAll");
    }

    public static User findUserById(int id){
        return session.selectOne("jing.findUserById",id);
    }
    public static List<User> findUserByName(String string){
        return session.selectList("jing.findUserByName",string);
    }
    public static  void insertUser(User user){
        session.insert("jing.insertUser",user);
        session.commit();
    }
    public static void deleteUserById(int i){
        session.delete("jing.deleteUserById",i);
    }
    public static void updateUser(User user){
        session.update("jing.updateUser",user);
        session.commit();
    }

}
