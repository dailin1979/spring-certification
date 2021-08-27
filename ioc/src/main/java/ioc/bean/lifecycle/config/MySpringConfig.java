package ioc.bean.lifecycle.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ioc.bean.lifecycle"})
public class MySpringConfig {

//    @Bean
//    public MyPostBeanProcessor myPostBeanProcessor(){
//        return new MyPostBeanProcessor();
//    }



}
