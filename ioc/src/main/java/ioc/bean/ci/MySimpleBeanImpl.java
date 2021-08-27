package ioc.bean.ci;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


public class MySimpleBeanImpl implements MySimpleBean{
    private Logger logger = LoggerFactory.getLogger(MySimpleBeanImpl.class);

    public MySimpleBeanImpl() {
        logger.info("[SimpleBeanImpl instantiation]");
    }

    @Override
    public String toString() {
        return "MySimpleBeanImpl { code: " + hashCode() + "}";
    }

}
