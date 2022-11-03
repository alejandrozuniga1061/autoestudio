package com.quartz.config;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@DisallowConcurrentExecution
@Component
public class SampleJob implements Job {

	Logger logger = LoggerFactory.getLogger(getClass());

	public void execute(JobExecutionContext context) throws JobExecutionException {

		logger.info("Nombre {} ** termina @ {}", context.getJobDetail().getKey().getName(), context.getFireTime());

		try {
			Thread.sleep(200000);
			logger.info("Eliminar________" +context.getScheduler().deleteJob(new JobKey("Quartz_qscann_detail")));
		} catch (InterruptedException | SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}