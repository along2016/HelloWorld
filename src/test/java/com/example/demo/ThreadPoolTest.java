package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadPoolTest {
    private static final int THREAD_NUM = 15;
    // 任务执行时间
    private static final int TASK_EXEC_TIME = 4;

    @Autowired
    private ThreadPoolExecutor executor;

    @Test
    public void test(){
        for(int i = 0; i < THREAD_NUM; i++){
            executor.execute(new TestTask());
            System.out.println("当前线程池中的活跃线程数：" + executor.getActiveCount());
            System.out.println("当前线程池中的完成任务数：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    class TestTask implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(TASK_EXEC_TIME * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
