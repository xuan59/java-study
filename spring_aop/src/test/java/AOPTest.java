import com.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.saveUser();
        userService.updateUser(1001);
        userService.deleteUser();
    }
}
