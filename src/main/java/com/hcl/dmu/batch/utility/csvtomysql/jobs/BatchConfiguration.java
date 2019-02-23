package com.hcl.dmu.batch.utility.csvtomysql.jobs;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.hcl.dmu.batch.utility.csvtomysql.listener.CustomItemReaderListener;
import com.hcl.dmu.batch.utility.csvtomysql.listener.CustomItemWriterListener;
import com.hcl.dmu.batch.utility.csvtomysql.listener.JobCompletionNotificationListener;
import com.hcl.dmu.batch.utility.csvtomysql.model.CandidateDet;
import com.hcl.dmu.batch.utility.csvtomysql.processor.CandidateDetItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private ApplicationContext appContext;
	@Autowired
	private CustomItemWriterListener customItemWriterListener;
	@Autowired
	private CustomItemReaderListener customItemReaderListener;

	@Value("${batchProfilePath}")
	private String batchProfilePath;

	// tag::readerwriterprocessor[]
	@Bean
	public FlatFileItemReader<CandidateDet> reader() {
		FlatFileItemReader<CandidateDet> reader = new FlatFileItemReader<>();
		
		
		Resource resource = appContext.getResource(batchProfilePath + "candidateDet.csv");
		reader.setResource(resource);
		reader.setLinesToSkip(1);
		reader.setLineMapper(new DefaultLineMapper<CandidateDet>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "name", "contactNo", "alternateNumber", "emailId", "primarySkill",
								"secondarySkill", "noticePeriod", "servingNoticePeriod", "currentCompany",
								"hrContactPerson", "expYears", "expMonths", "designation", "hclPosition", "referredBy",
								"modeOfInterview", "interviewDateTime", "currentCTC", "expectedCTC", "status",
								"comments", "hackerRankScore" });
						setIncludedFields(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21);
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<CandidateDet>() {
					{
						setTargetType(CandidateDet.class);

						/*
						 * SimpleDateFormat sdf = new
						 * SimpleDateFormat("yyyy-MM-dd");
						 * 
						 * final Map<Class, PropertyEditor> customEditors =
						 * Stream .of(new
						 * AbstractMap.SimpleEntry<>(Timestamp.class, new
						 * CustomDateEditor(sdf, false)))
						 * .collect(Collectors.toMap(Map.Entry::getKey,
						 * Map.Entry::getValue));
						 * setCustomEditors(customEditors);
						 */
					}
				});
			}
		});
		return reader;
	}

	@Bean
	public CandidateDetItemProcessor processor() {
		return new CandidateDetItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<CandidateDet> writer() {
		JdbcBatchItemWriter<CandidateDet> writer = new JdbcBatchItemWriter<>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<CandidateDet>());
		writer.setSql("INSERT INTO dmu_candidate_details" + "(name,contact_number,alternate_number,"
				+ "email_id,primary_skill,secondary_skill,notice_period,"
				+ "serving_notice_period,current_company,hr_contact_person,exp_years,"
				+ "exp_months,designation,hcl_position,"
				+ "referred_by,mode_of_interview,interview_date_time,current_ctc,"
				+ "expected_ctc,status,comments,hacker_rank) " + "VALUES(:name,:contactNo,:alternateNumber,"
				+ ":emailId,:primarySkill,:secondarySkill,:noticePeriod,"
				+ ":servingNoticePeriod,:currentCompany,:hrContactPerson,:expYears,"
				+ ":expMonths,:designation,:hclPosition,"
				+ ":referredBy,:modeOfInterview,STR_TO_DATE(:interviewDateTime,'%d-%m-%Y %H:%i:%s'),:currentCTC,"
				+ ":expectedCTC,:status,:comments,:hackerRankScore)");
		writer.setDataSource(dataSource);
		return writer;
	}
	// end::readerwriterprocessor[]

	// tag::jobstep[]

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<CandidateDet, CandidateDet> chunk(1).reader(reader())
				.processor(processor()).writer(writer()).listener(customItemReaderListener).listener(customItemWriterListener).allowStartIfComplete(true).build();
	}

	@Bean
	Job importUserJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener)
				.flow(step1()).end().build();
	}

	// end::jobstep[]
}
