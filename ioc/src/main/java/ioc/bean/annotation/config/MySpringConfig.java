package ioc.bean.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ioc.bean.annotation"})
public class MySpringConfig {

//    @Bean
//    public MyPostBeanProcessor myPostBeanProcessor(){
//        return new MyPostBeanProcessor();
//    }

}
