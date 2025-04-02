package daay7;

import java.util.concurrent.*;

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            // Simulate task execution
            System.out.println("Task " + taskId + " is executing.");
            Thread.sleep(1000); // Simulate work by sleeping for 1 second
            System.out.println("Task " + taskId + " is complete.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class CountdownTimerExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfTasks = 5;  // Number of tasks to execute
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfTasks);  // Executor to manage threads
        CountDownLatch latch = new CountDownLatch(numberOfTasks);  // Countdown latch initialized with number of tasks

        // Submitting tasks to executor service
        for (int i = 1; i <= numberOfTasks; i++) {
            int taskId = i;
            executorService.submit(() -> {
                try {
                    new Task(taskId).run();
                } finally {
                    latch.countDown(); // Decrement the latch count when the task is finished
                }
            });
        }

        // Main thread will wait until latch count reaches zero
        System.out.println("Main thread is waiting for all tasks to complete...");
        latch.await();  // This blocks until countDown() is called enough times (i.e., all tasks complete)
        System.out.println("All tasks are completed! Main thread can proceed.");

        // Shutdown executor service
        executorService.shutdown();
    }
}
