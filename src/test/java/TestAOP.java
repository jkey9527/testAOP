import com.java.helper.UserServiceHelper;
import com.java.proxy.CglibFactory;
import com.java.proxy.UserProxy;
import com.java.service.UserService;
import com.java.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {

    @Test
    public void test1(){
        UserServiceImpl userService = new UserServiceImpl();
        UserProxy proxy = new UserProxy(userService);
        UserService us = (UserService) proxy.createProxy();
        us.add();
    }

    @Test
    public void test2(){
        UserServiceImpl userService = new UserServiceImpl();
        CglibFactory proxy = new CglibFactory(userService);
        UserServiceImpl us = (UserServiceImpl) proxy.createProxy();
        us.add();
    }

    @Test
    public void test3(){
        UserServiceImpl userService = new UserServiceImpl();
        CglibFactory proxy = new CglibFactory(userService);
        UserService us = (UserService) proxy.createProxy();
        us.add();
        us.update();
    }

    @Test
    public void test4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("proxy");
        userService.add();
    }

    @Test
    public void test5(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.add();
    }
}
