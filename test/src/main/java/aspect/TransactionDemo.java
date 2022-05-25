package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionDemo {

    @Pointcut(value = "execution (* aspect..*.*(..))")
    public void point() {

    }

    @Before(value="point()")
    public void before(){ System.out.println("transaction begin");
    }

    public void after(){ System.out.println("transaction commit");
    }
    @Around("point()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{ System.out.println("transaction begin");
        joinPoint.proceed();
        System.out.println("transaction commit");
    }
}
