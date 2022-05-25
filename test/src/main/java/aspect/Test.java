package aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("aspect")
@Configuration
@EnableAspectJAutoProxy
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
        HelloService helloService = context.getBean(HelloService.class);
        helloService.say();
        System.out.println("\n");
    }

}
