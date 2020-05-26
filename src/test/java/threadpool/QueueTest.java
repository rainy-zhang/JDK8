package threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author: zhangyu
 * @Description:
 * @Date: in 2019/12/22 15:57
 */
public class QueueTest {

    @Test
    public void arrayBlockingQueue() throws InterruptedException {
        // 基于数组的有界阻塞队列
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
        for (int i = 0; i < 20; i++) {
            queue.put(i);
        }
    }

    @Test
    public void linkedBlockingQueue() throws InterruptedException {
        // 基于链表实现的有界/无界队列, 当不指定参数时, 默认值为int的最大值, 可以当成无界队列使用
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        for (int i = 0; i < 20; i++) {
            queue.put(i);
        }
    }

    @Test
    public void synchronousQueue() throws InterruptedException {
        // 同步移交队列
        SynchronousQueue queue = new SynchronousQueue();

        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("插入成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//        new Thread(() -> {
//            try {
//                queue.take();
//                System.out.println("删除成功");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

        Thread.sleep(1000L * 60);
    }

}
