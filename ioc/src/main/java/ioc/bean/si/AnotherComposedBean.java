package ioc.bean.si;


import ioc.bean.ci.MySimpleBean;

public interface AnotherComposedBean {

    MySimpleBean getSimpleBean();

    Boolean isComplex();
}
