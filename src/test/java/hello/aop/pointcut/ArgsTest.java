package hello.aop.pointcut;

import hello.aop.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class ArgsTest {

    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    private AspectJExpressionPointcut pointcut(String expression) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(expression);
        return pointcut;
    }

    @Test
    void args() {
        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isFalse();
        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void argsVsExecution() {
        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isTrue();

        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isTrue();
        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isFalse();
        assertThat(pointcut("").matches(helloMethod, MemberServiceImpl.class)).isFalse();
    }
}
