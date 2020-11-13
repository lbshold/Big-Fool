package top.lconcise.config;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池.
 *
 * @author liusj
 * @date 2020/11/13
 */
public class AsyncThreadPoolConfig {

    public ThreadPoolTaskExecutor asyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(50);
        executor.setQueueCapacity(25);
        executor.setKeepAliveSeconds(100);
        executor.setThreadNamePrefix("asyncThreadPool");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);

        // 4种拒绝策略
        // AbortPolicy策略： 丢弃任务，并抛出异常
        // CallerRunsPolicy策略： 由调用现场处理该任务
        // DiscardOldestPolicy策略： 丢弃最早被放入到线程队列的任务，将新提交的任务放入到线程队列末端
        // DiscardPolicy策略: 直接丢弃新的任务，不抛异常
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        executor.initialize();

        return executor;
    }
}
