import ioc.bean.ci.MyComposedBean;
import ioc.bean.ci.MySimpleAppCfg;
import ioc.bean.lifecycle.config.MySpringConfig;
import ioc.bean.lifecycle.controller.PersonController;
import ioc.bean.si.AnotherComposedBean;
import ioc.bean.si.AnotherComposedBeanImpl;
import ioc.bean.si.AnotherSimpleAppCfg;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocBeanLifeCycleTest {


    private Logger logger = LoggerFactory.getLogger(IocBeanLifeCycleTest.class);


    @Test
    public  void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringConfig.class);
        PersonController bean = context.getBean("personController", PersonController.class);
        context.close();
    }

    @Test
    public void testDI01(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySimpleAppCfg.class);
        MyComposedBean composedBean = context.getBean(MyComposedBean.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            logger.info("Bean " + beanName + " of type "
                    + context.getBean(beanName).getClass().getSimpleName());
        }
        logger.info(composedBean.getCode());
        context.close();

    }

    @Test
    public void testSI() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AnotherSimpleAppCfg.class);
        AnotherComposedBean composedBean = ctx.getBean(AnotherComposedBean.class);
        for (String beanName : ctx.getBeanDefinitionNames()) {
            logger.info("Bean " + beanName + " of type "
                    + ctx.getBean(beanName).getClass().getSimpleName());
        }
        ctx.close();
    }
}
