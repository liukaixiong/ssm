package spring.prototype;

import org.apache.commons.collections.Factory;
import org.apache.commons.collections.functors.PrototypeFactory;

/**
 * @author Liukx
 * @create 2018-03-22 16:27
 * @email liukx@elab-plus.com
 **/
public class PrototypeTest {

    public void runTest() {
        UserDTO userDTO = new UserDTO();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Factory instance = PrototypeFactory.getInstance(userDTO);
        }
        long time = System.currentTimeMillis() - startTime;
        System.out.println("clone 耗时 : " + time);
    }

    public void runTest2() {

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            UserDTO userDTO = new UserDTO();
        }
        long time = System.currentTimeMillis() - startTime;
        System.out.println("clone 耗时 : " + time);
    }


    public static void main(String[] args) {

        PrototypeTest t = new PrototypeTest();
        t.runTest();
        t.runTest2();
    }


}
