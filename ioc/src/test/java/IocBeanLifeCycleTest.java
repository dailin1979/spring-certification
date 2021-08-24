import ioc.bean.annotation.config.MySpringConfig;
import ioc.bean.annotation.service.ItemService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocBeanLifeCycleTest {
    @Test
    public  void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringConfig.class);
        ItemService bean = context.getBean(ItemService.class);
        System.out.println(bean);
        context.close();
    }
}
