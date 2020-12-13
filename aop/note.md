Notes for spring aop by using aspectJ

1. 除了正常的spring依赖，还要加入下列依赖 
    <dependency>
    <groupId>aopalliance</groupId>
    <artifactId>aopalliance</artifactId>
    <version>1.0</version>
    </dependency>
    
  <dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.8.9</version>
  </dependency>
  
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
    <version>${spring.version}</version>
  </dependency>
  
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>${spring.version}</version>
  </dependency>

2. 在配置文件中，加入aop namespace

3. 基于注解的aop
1) 在配置文件中加入配置
告诉spring, AspectJ注解起作用: 自动为匹配的类生成代理对象
  <aop:aspectj-autoproxy></aop:aspectj-autoproxy>

2) 将横切关注点的代码抽象到切面的类中
i. 切面首先是ioc容器中的bean, 所有要加入@Component annotation.
ii. 切面类还需要@Aspect annotation

3) 在类中声明各个通知
i. 声明一个方法
ii. 在方法前加入@Before, @After等aspectJ提供的annotation

4) 可以在通知方法中声明一个类型为JoinPoint的参数，就可以访问到方法的细节信息，如名称和参数值
把这个类声明为一个切面: 需要把这个类放入ioc容器，在声明为一个切面
 @Aspect
 @Component
 public class LogginAspect {
 
声明该方法是前置通知，在目标方法开始之前执行
  @Before("execution(public Integer com.ld.aop.impl.ArithmeticCalculatorImpl.*(Integer, Integer))")
   public void beforeMethod(JoinPoint joinPoint){
     String name = joinPoint.getSignature().getName();
     List<Object> args = Arrays.asList(joinPoint.getArgs());
     System.out.println("the method " + name + " begins with " + args);
   }
 }
