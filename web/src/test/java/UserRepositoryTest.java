import com.etf.sql.UserDao;
import com.etf.controller.WebApplication;
import com.etf.meta.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: etf
 * @Date: 2020-05-15 16:41
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class UserRepositoryTest {


    @Resource
    private UserDao userRepository;

    @Test
    public void test() {
        Date data = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(data);

        userRepository.save(new User("aa", "aa123456", "aa@126.com", "aa", formattedDate));
        userRepository.save(new User("bb", "bb123456", "bb@126.com", "bb", formattedDate));
        userRepository.save(new User("cc", "cc123456", "cc@126.com", "cc", formattedDate));

        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "bb@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa"));
    }
}
