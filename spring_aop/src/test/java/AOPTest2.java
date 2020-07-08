import com.aop.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean2.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.saveUser();

    }
}
