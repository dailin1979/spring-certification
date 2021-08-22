import ioc.bean.annotation.MyFirstAutoWired;
import ioc.bean.annotation.controller.ItemController;
import ioc.bean.annotation.service.ItemService;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class ItemControllerTest {


    @Test
    public void testItemController() throws Exception {
        ItemController itemController = new ItemController();
        Class<? extends ItemController> clazz = itemController.getClass();
//        try {
//            Class<?> clazz01 = Class.forName("ioc.bean.annotation.controller.ItemController");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Class<ItemController> aClass02 = ItemController.class;
        // create new object of itemservice
        ItemService itemService = new ItemService();

        //get all fields of class itemcontroller
        Field service = clazz.getDeclaredField("itemService");
        service.setAccessible(true); // able to get private fields or method

        // retrieve value of property by using getter methode
        String name = service.getName();

        // append the name of getter or setter method name
        String setterName = "set"+ name.substring(0, 1).toUpperCase() + name.substring(1);

        // inject object by using setter method

        Method method = clazz.getMethod(setterName, ItemService.class);

        //reflection
        method.invoke(itemController, itemService);

        System.out.println(itemController.getItemService());

    }

    @Test
    public void testAnnotation(){
        ItemController itemController = new ItemController();
        Class<? extends ItemController> clazz = itemController.getClass();
//       通过annotation就不需要自己创建对象
//        ItemService itemService = new ItemService();

        //获取所有的属性值
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            MyFirstAutoWired annotation = field.getAnnotation(MyFirstAutoWired.class);
            if(annotation!=null && annotation.annotationType()== MyFirstAutoWired.class){
                field.setAccessible(true);
                //获得属性的类型
                Class<?> type = field.getType();
                try {
                    Object instance = type.newInstance();
                    field.set(itemController, instance);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(itemController.getItemService());

    }
}
