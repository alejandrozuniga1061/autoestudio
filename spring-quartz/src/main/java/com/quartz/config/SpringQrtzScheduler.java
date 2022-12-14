package com.quartz.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

@Configuration
@EnableAutoConfiguration
public class SpringQrtzScheduler {

	Logger logger = LoggerFactory.getLogger(getClass());

	@PostConstruct
	public void init() {
		logger.info("Inicia...");
	}

	@Bean
	public SpringBeanJobFactory springBeanJobFactory(ApplicationContext applicationContext) {
		AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
		logger.debug("Configuring Job factory");

		jobFactory.setApplicationContext(applicationContext);
		return jobFactory;
	}

	@Bean
	public SchedulerFactoryBean scheduler(Trigger trigger, JobDetail job, DataSource quartzDataSource,
			ApplicationContext applicationContext) {

		SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
		schedulerFactory.setConfigLocation(new ClassPathResource("quartz.properties"));

		logger.debug("Configurando Scheduler...");
		schedulerFactory.setJobFactory(springBeanJobFactory(applicationContext));
		schedulerFactory.setJobDetails(job);
		schedulerFactory.setTriggers(trigger);
		schedulerFactory.setDataSource(quartzDataSource);

		return schedulerFactory;
	}

	@Bean
	public JobDetailFactoryBean jobDetail() {

		JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
		jobDetailFactory.setJobClass(SampleJob.class);
		jobDetailFactory.setName("Quartz_qscann_detail");
		jobDetailFactory.setDescription("Inicia job qscann..");
		jobDetailFactory.setDurability(true);
		return jobDetailFactory;
	}

	@Bean
	public SimpleTriggerFactoryBean trigger(JobDetail job) {

		SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
		trigger.setJobDetail(job);
		trigger.setRepeatInterval(10000);
		trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
		trigger.setName("Qrtz_qscann_Trigger");
		return trigger;
	}

	@Bean
	@QuartzDataSource
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource quartzDataSource() {
		return DataSourceBuilder.create().build();
	}

}