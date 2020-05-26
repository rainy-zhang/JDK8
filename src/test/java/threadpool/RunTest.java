package threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 22:07
 */
public class RunTest {

    /**
     * 使用submit方法向线程池中提交任务
     */
    @Test
    public void submitTest() throws ExecutionException, InterruptedException {
        // 创建线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();
        // 向线程池中提交任务
        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(1000 * 5);
            return 2 * 5;
        });
        System.out.println("====");
        // 阻塞方法, 直到任务有返回值返回后才向下执行
        Integer num = future.get();
        System.out.println(num);
    }

    /**
     * 利用execute方法向线程池中提交任务
     */
    @Test
    public void executeTest() throws InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(() -> {
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行结果: xxx");
        });
        Thread.sleep(1000 * 10);
    }

}
