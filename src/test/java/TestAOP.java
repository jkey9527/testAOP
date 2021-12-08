import com.java.proxy.CglibFactory;
import com.java.proxy.UserProxy;
import com.java.service.UserService;
import com.java.service.UserServiceImpl;
import org.junit.Test;

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
}
