package com.nssol.controller;

import java.util.concurrent.ScheduledFuture;

import com.nssol.service.BatchService;
import com.nssol.task.BatchTask;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.nssol.common.Constant.*;

@RestController
@Api(tags = { "Operatioms about Batch Info" })
public class BatchController {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Autowired
    private BatchService batchService;

    /**
     * 在ScheduledFuture中有一个cancel可以停止定时任务。
     */
    private ScheduledFuture<?> poImportFuture;
    private ScheduledFuture<?> refreshTableauFuture;
    private ScheduledFuture<?> backUpBaggingAndMetalcheckFuture;
    @Autowired
    private BatchTask batchTask;


    /**
     * ThreadPoolTaskScheduler：线程池任务调度类，能够开启线程池进行任务调度。
     * ThreadPoolTaskScheduler.schedule()方法会创建一个定时计划ScheduledFuture，在这个方法需要添加两个参数，Runnable（线程接口类） 和CronTrigger（定时任务触发器）
     * @return
     */
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @ApiOperation(value = "设置PoBatch", notes = "设置PoBatch", produces = "application/json")
    @RequestMapping(value = "/setPoImport", method = RequestMethod.POST)
    public void setPoImport(@RequestParam("cron") String cron) {
        batchService.setBasicInfo(PO_IMPORT, cron);
        if (poImportFuture != null) {
            poImportFuture.cancel(true);
            System.out.println("poImport已停止");
        }
        if (!cron.isEmpty() && cron != null) {
            poImportFuture = threadPoolTaskScheduler.schedule(new BatchRunner(PO_IMPORT), new CronTrigger(cron));
            System.out.println("poImport已启用");
        }
    }

    @ApiOperation(value = "设置TableauBatch", notes = "设置TableauBatch", produces = "application/json")
    @RequestMapping(value = "/setRefreshTableau", method = RequestMethod.POST)
    public void setRefreshTableau(@RequestParam("cron") String cron) {
        batchService.setBasicInfo(Metalcheck_Report, cron);
        if (refreshTableauFuture != null) {
            refreshTableauFuture.cancel(true);
            System.out.println("refreshTableau已停止");
        }
        if (!cron.isEmpty() && cron != null) {
            refreshTableauFuture = threadPoolTaskScheduler.schedule(new BatchRunner(Metalcheck_Report), new CronTrigger(cron));
            System.out.println("refreshTableau已启用");
        }
    }

    @ApiOperation(value = "设置备份batch", notes = "设置备份batch", produces = "application/json")
    @RequestMapping(value = "/setbackUpBaggingAndMetalcheck", method = RequestMethod.POST)
    public void setbackUpBaggingAndMetalcheck(@RequestParam("cron") String cron) {
        batchService.setBasicInfo(BackUpBatch, cron);
        if (backUpBaggingAndMetalcheckFuture != null) {
            backUpBaggingAndMetalcheckFuture.cancel(true);
            System.out.println("backUpBaggingAndMetalcheck已停止");
        }
        if (!cron.isEmpty() && cron != null) {
            backUpBaggingAndMetalcheckFuture = threadPoolTaskScheduler.schedule(new BatchRunner(BackUpBatch), new CronTrigger(cron));
            System.out.println("backUpBaggingAndMetalcheck已启用");
        }
    }


    /**
     * 创建一个线程，给定时任务调用
     */
    public class BatchRunner implements Runnable {
        private String batchName;

        public BatchRunner(String batchName) {
            this.batchName = batchName;
        }

        public void run() {
            switch (this.batchName) {
                case PO_IMPORT:
                    batchTask.poImport();
                    break;
                case Metalcheck_Report:
                    batchTask.refreshTableau();
                    break;
                case BackUpBatch:
                    try {
                        batchTask.backUpBaggingAndMetalcheck();
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                    break;
                default:
            }
        }

    }

    public class ThreadRunner implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println("开始执行batch");
                String batch = batchService.getBasicInfo(PO_IMPORT);
                if(batch != null){
                    setPoImport(batch);
                }
                batch = batchService.getBasicInfo(Metalcheck_Report);
                if(batch != null){
                    setRefreshTableau(batch);
                }
                batch = batchService.getBasicInfo(BackUpBatch);
                if(batch != null){
                    setbackUpBaggingAndMetalcheck(batch);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Component
    public class BatchApplicationRunner implements ApplicationRunner {
        @Override
        public void run(ApplicationArguments applicationArguments) throws Exception {
            Thread thread = new Thread(new ThreadRunner());
            thread.start();
        }
    }
}