import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author kangyouwei
 * @version 1.0.0
 * @date 2020/12/20 15:54
 */
public class Test01 {

    @Test
    public void test01() {
        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println(zbj);
    }
}
