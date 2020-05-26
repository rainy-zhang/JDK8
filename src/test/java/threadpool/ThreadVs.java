package threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 15:33
 */
public class ThreadVs {

    @Test
    public void newHandler() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> {
                System.out.println("开始处理文档...");
                try {
                    Thread.sleep(1000L * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束! ");
            });
        }

        Thread.sleep(100000);
    }


    @Test
    public void oldHandler() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("开始处理文档...");
                try {
                    Thread.sleep(1000L * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束! ");
            }).start();
        }

        Thread.sleep(1000 * 50);
    }

}
