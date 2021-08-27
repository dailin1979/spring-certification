package ioc.simple.container;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimpleIOC {
    private Map<String, Object> beanMap = new HashMap<>();

    public SimpleIOC(InputStream inputStream) throws Exception {
        loadBeans(inputStream);
    }

    public SimpleIOC(String location) throws Exception {
        loadBeans(location);
    }

    public Object getBean(String name) {
        Object bean = beanMap.get(name);
        if (null == bean) {
            throw new IllegalArgumentException("There is no bean with name:" + name);
        }
        return bean;
    }

    private void registerBean(String id, Object bean) {
        beanMap.put(id, bean);
    }

    private void loadBeans(InputStream inputStream) throws Exception {
        //利用DOM4J解析XML文件
        SAXReader reader = new SAXReader();

        Document document = reader.read(inputStream);
        //根目录beans
        Element rootElement = document.getRootElement();
        //迭代beans获取多个bean
        Iterator<Element> beansIter = rootElement.elementIterator();

        while(beansIter.hasNext()){
            //单个bean
            Element beanElement = beansIter.next();
            //id
            String id = beanElement.attributeValue("id");
            //完整的类名
            String className = beanElement.attributeValue("class");
            //通过className反射出一个对象
            Class<?> aClass = Class.forName(className);
            //获取无参数的构造器
            Constructor<?> constructor = aClass.getConstructor();
            //利用无参数的构造器创建实例
            Object o = constructor.newInstance();

            //迭代beans获取多个bean
            Iterator<Element> beanIter = beanElement.elementIterator();

            while(beanIter.hasNext()){
                Element property = beanIter.next();
                //属性名
                String fieldName = property.attributeValue("name");
                //属性值
                String fieldValue = property.attributeValue("value");
                //根据属性名获取属性对象
                Field field = aClass.getDeclaredField(fieldName);
                //属性的类型
                Class<?> fieldType = field.getType();
                //拼接set方法名
                String setMethodName = "set" + fieldName.substring(0,1).toUpperCase()+ fieldName.substring(1);
                //获取方法对象
                Method method = aClass.getMethod(setMethodName, fieldType);

                Object val = fieldValue;

                switch (fieldType.getName()){
                    case "int":
                    case "java.lang.Integer":
                        val = Integer.valueOf(fieldValue);
                        break;
                    case "boolean":
                    case "java.lang.Boolean":
                        val = Boolean.valueOf(fieldValue);
                        break;
                    case "char":
                    case "java.lang.Character":
                        val = fieldValue.charAt(0);
                        break;
                    case "long":
                    case "java.lang.Long":
                        val = Long.valueOf(fieldValue);
                        break;
                    case "double":
                    case "java.lang.Double":
                        val = Double.valueOf(fieldValue);
                        break;
                    case "float":
                    case "java.lang.Float":
                        val = Float.valueOf(fieldValue);
                        break;
                    case "byte":
                    case "java.lang.Byte":
                        val = Byte.valueOf(fieldValue);
                        break;
                    case "short":
                    case "java.lang.Short":
                        val = Short.valueOf(fieldValue);
                        break;
                }
                method.invoke(o,val);
            }
            registerBean(id, o);
        }

    }


    private void loadBeans(String location) throws Exception {
        // 加载xml配置文件

        ClassPathResource resource = new ClassPathResource(location);
        //利用DOM4J解析XML文件
        SAXReader reader = new SAXReader();

        //读取xml文件,获取到文档
        Document document = reader.read(resource.getInputStream());
        //根目录beans
        Element rootElement = document.getRootElement();
        //迭代beans获取多个bean
        Iterator<Element> beansIter = rootElement.elementIterator();

        while(beansIter.hasNext()){
            //单个bean
            Element beanElement = beansIter.next();
            //id
            String id = beanElement.attributeValue("id");
            //完整的类名
            String className = beanElement.attributeValue("class");
            //通过className反射出一个对象
            Class<?> aClass = Class.forName(className);
            //获取无参数的构造器
            Constructor<?> constructor = aClass.getConstructor();
            //利用无参数的构造器创建实例
            Object o = constructor.newInstance();
            //迭代bean获取property
            Iterator<Element> beanIter = beanElement.elementIterator();
            while (beanIter.hasNext()){
                Element property = beanIter.next();
                //属性名
                String fieldName = property.attributeValue("name");
                //属性值
                String fieldValue = property.attributeValue("value");
                //根据属性名获取属性对象
                Field field = aClass.getDeclaredField(fieldName);
                //属性的类型
                Class<?> fieldType = field.getType();
                //拼接set方法名
                String setMethodName = "set" + fieldName.substring(0,1).toUpperCase()+ fieldName.substring(1);
                //获取方法对象
                Method method = aClass.getMethod(setMethodName, fieldType);

                Object val = fieldValue;
                switch (fieldType.getName()){
                    case "int":
                    case "java.lang.Integer":
                        val = Integer.valueOf(fieldValue);
                        break;
                    case "boolean":
                    case "java.lang.Boolean":
                        val = Boolean.valueOf(fieldValue);
                        break;
                    case "char":
                    case "java.lang.Character":
                        val = fieldValue.charAt(0);
                        break;
                    case "long":
                    case "java.lang.Long":
                        val = Long.valueOf(fieldValue);
                        break;
                    case "double":
                    case "java.lang.Double":
                        val = Double.valueOf(fieldValue);
                        break;
                    case "float":
                    case "java.lang.Float":
                        val = Float.valueOf(fieldValue);
                        break;
                    case "byte":
                    case "java.lang.Byte":
                        val = Byte.valueOf(fieldValue);
                        break;
                    case "short":
                    case "java.lang.Short":
                        val = Short.valueOf(fieldValue);
                        break;
                }
                method.invoke(o,val);
            }
            registerBean(id, o);
        }

    }

}
