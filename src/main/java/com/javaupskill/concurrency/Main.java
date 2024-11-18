package com.javaupskill.concurrency;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        threads();
//        executorService();
//        synchronizedAndAtomic();
//        scheduledExecutorService();
//        syncCollections();
//        future();

//        deadlock();

        ReentrantLock fork = new ReentrantLock();
        ReentrantLock knife = new ReentrantLock();
        AtomicBoolean isOneHungry = new AtomicBoolean(true);
        AtomicBoolean isTwoHungry = new AtomicBoolean(true);

        Runnable runnable1 = () -> {
          fork.lock();
          System.out.println("[T1] One is hungry, took fork");
          while (isTwoHungry.get()) {
              System.out.println("[T1] Two is hungry as well! I surrender fork");
              fork.unlock();

              try {
                  System.out.println("[T1] I wait 1 second and try again. Maybe two already ate");
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }

              fork.lock();
          }
          System.out.println("[T1] I can finally eat!");
          knife.lock();
          System.out.println("eating...");
          knife.unlock();
          fork.unlock();
          isOneHungry.set(false);
        };

        Runnable runnable2 = () -> {
            knife.lock();
            System.out.println("[T2] One is hungry, took knife");
            while (isOneHungry.get()) {
                System.out.println("[T2] Two is hungry as well! I surrender knife");
//                isTwoHungry.set(false); // this is a solution!
                knife.unlock();

                try {
                    System.out.println("[T2] I wait 1 second and try again. Maybe two already ate");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                knife.lock();
            }
            System.out.println("[T2] I can finally eat!");
            fork.lock();
            System.out.println("eating...");
            knife.unlock();
            fork.unlock();
            isTwoHungry.set(false);
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private static void deadlock() throws InterruptedException {
        final String fork = "fork";
        final String knife = "knife";

        Runnable runnable1 = () -> {
          synchronized (fork) {
              System.out.println("I took fork");

              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
              synchronized (knife) {
                  System.out.println("I took knife");
              }
              System.out.println("I left knife");
          }
          System.out.println("I left fork");
        };

        Runnable runnable2 = () -> {
            synchronized (knife) {
                System.out.println("I took knife");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (fork) {
                    System.out.println("I took fork");
                }
                System.out.println("I left fork");
            }
            System.out.println("I left knife");
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        // solution (one of the): Thread t2 = new Thread(runnable1);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("program finished.");
    }

    private static void future() throws InterruptedException {
        int waitingTime = 3000;

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> textFuture = executorService.submit(() -> {
            try {
                Thread.sleep(waitingTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "test";
        });

        if (!textFuture.isDone()) {
            System.out.println("loading....");
        }

        System.out.println("before future -> tasks executed on thread 0 in this dead time");

        try {
            System.out.println(textFuture.get(waitingTime * 2, TimeUnit.MILLISECONDS));
        } catch (ExecutionException e) {
            System.out.println("some error occurred");
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            System.out.println("did not finish in time");
            throw new RuntimeException(e);
        } finally {
            System.out.println("after future");
            executorService.shutdown();
        }

//        Callable<Integer> integerCallable = () -> {
//            System.out.println("callable");
//            return 3;
//        };
//        Thread callableThread = new Thread(new FutureTask<>(integerCallable));
    }

    private static void syncCollections() throws InterruptedException {
        Collection<Integer> intList = Collections.synchronizedCollection(new ArrayList<>());
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
//        Collections.synchronizedMap(new HashMap<>());
//        List<Integer> intList = new ArrayList<>();

        Runnable addToList = () -> {
//            synchronized (intList) { // alternative, if we want to use a normal collection
                intList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
//            }
        };

        Thread thread1 = new Thread(addToList);
        Thread thread2 = new Thread(addToList);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(intList);
        System.out.println(intList.size());
    }

    private static void scheduledExecutorService() {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        Calculator calculator = new Calculator(0);

        Runnable runnable = () ->
        {
            IntStream.range(0, 1000).forEach(number -> scheduledExecutorService.execute(calculator::increment));
            System.out.println(calculator.getSum());
        };

        ScheduledFuture<?> handler = scheduledExecutorService.scheduleAtFixedRate(runnable, 2, 2, TimeUnit.SECONDS);

        scheduledExecutorService.schedule( () ->
                {
                    handler.cancel(true);
                    scheduledExecutorService.shutdown();
                    System.out.println("exit 0");
                }, 10, TimeUnit.SECONDS
        );
    }

    private static void synchronizedAndAtomic() throws InterruptedException {
        Calculator calculator = new Calculator(0);
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        IntStream.range(0, 1000)
                .forEach(number ->  {
                    executorService.execute(calculator::increment);
                    executorService.execute(calculator::incrementSum2);
                });
        executorService.shutdown();
        // threads aforementioned are interrupted and exited after shutdown is completed
        // it doesn't wait for all the threads to finish their work
        // solution? wait for them
        executorService.awaitTermination(4, TimeUnit.SECONDS);

        System.out.println(calculator.getSum());
        System.out.println(calculator.getSum2().get());
    }

    private static void executorService() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable task1 = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("sleep not finished");
                throw new RuntimeException(e);
            }
            System.out.println("1");
        };
        Runnable task2 = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("sleep not finished");
                throw new RuntimeException(e);
            }
            System.out.println("2");
        };
        Runnable task3 = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("sleep not finished");
                // log sleep not finished error
                throw new RuntimeException(e);
            }
            System.out.println("3");
        };

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.shutdown();

        // TODO: why isn't the exception thrown here in thread 0
        // TODO: why is shutdown called before awaitTermination
        boolean isExecutorFinished = executorService.awaitTermination(3, TimeUnit.SECONDS);
        if (!isExecutorFinished) {
            // log error
            executorService.shutdownNow();
        }

        System.out.println("after shutdown");
    }

    private static void threads() throws InterruptedException {
        //        System.out.println("Before sleep");
//        Thread.sleep(2000);
//        System.out.println("After sleep");

        MyThread thread1 = new MyThread();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);

        System.out.println("Before start");

        thread1.start();
        thread2.start();
//        thread1.run();
//        thread2.run();

        // process all we want until threads are finished
//        System.out.println("intermediary work");

        thread1.join(); // block thread0 (the main one) until thread1 finishes
        thread2.join(1000); // block thread0 (the main one) until thread2 finishes

        System.out.println("After start"); // process using thread1 resource
//        for (int i = 0; i < 1000; i++)
//            System.out.println("After start");
    }
}
