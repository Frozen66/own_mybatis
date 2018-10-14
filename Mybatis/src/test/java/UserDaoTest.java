import dao.UserDao;
import entity.User;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test_findAll() throws Exception{
        List<User> user=UserDao.findAll();
        for(User user1:user){
            System.out.println("id:"+user1.getId()+" name:" + user1.getName() + " password:" + user1.getPassword());
        }
    }

    @Test//测试单例查找
    public void test_findUserById() throws Exception {
        User user = UserDao.findUserById(2);
        System.out.println("id:" + user.getId() + " name:" + user.getName() + " password:" + user.getPassword());
    }

    @Test
    public void test_findUserByName() throws Exception{
        List<User> user =UserDao.findUserByName("j");
        for (User u:user){
            System.out.println("id:"+u.getId()+" name:"+u.getName()+" password:"+u.getPassword());
        }
    }
    @Test
    public void test_insertUser() throws Exception{
        User user=new User();
        user.setName("园媛");
        user.setPassword("11111");
        UserDao.insertUser(user);

    }
    @Test
    public void test_deleteUserById() throws Exception{
        UserDao.deleteUserById(11);
        test_findAll();

    }

    @Test
    public void test_updateUser() throws Exception{
        User user=new User();
        user.setId(17);
        user.setName("夏美");
        user.setPassword("123456");
        UserDao.updateUser(user);

    }
}
