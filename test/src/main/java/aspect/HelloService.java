package aspect;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

    public void say() {
        System.out.println("say hello");
    }
}
