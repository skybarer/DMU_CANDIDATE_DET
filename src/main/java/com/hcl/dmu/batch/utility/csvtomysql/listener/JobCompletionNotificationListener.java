package com.hcl.dmu.batch.utility.csvtomysql.listener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.hcl.dmu.batch.utility.csvtomysql.model.CandidateDet;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger LOG = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
	private final JdbcTemplate jdbcTemplate;

	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			LOG.info("!!! JOB FINISHED! Time to verify the results");

			List<CandidateDet> results = jdbcTemplate.query(
					"SELECT alternate_number,comments,contact_number,current_ctc,current_company,"
							+ "designation,email_id,exp_months,exp_years,expected_ctc,hacker_rank,hcl_position,hr_contact_person,"
							+ "interview_date_time,mode_of_interview,name,notice_period,primary_skill,referred_by,"
							+ "secondary_skill,serving_notice_period,status FROM dmu_candidate_details",
					new RowMapper<CandidateDet>() {
						@Override
						public CandidateDet mapRow(ResultSet rs, int row) throws SQLException {
							Long alternateNo = rs.getLong(1);
							String comments = rs.getString(2);
							Long contactNo = rs.getLong(3);
							String currentCTC = rs.getString(4);
							String currentCompany = rs.getString(5);
							String designation = rs.getString(6);
							String emailId = rs.getString(7);
							Long expMonths = rs.getLong(8);
							Long expYears = rs.getLong(9);
							String expectedCTC = rs.getString(10);
							Double hackerRankScore = rs.getDouble(11);
							String hclPositionRole = rs.getString(12);
							String hrContactPerson = rs.getString(13);
							String interviewDateTime = rs.getString(14);
							String modeOfInterview = rs.getString(15);
							String name = rs.getString(16);
							String noticePeriod = rs.getString(17);
							String primarySkill = rs.getString(18);
							String referedBy = rs.getString(19);
							String secondarySkill = rs.getString(20);
							String servingNoticePeriod = rs.getString(21);
							String status = rs.getString(22);

							return new CandidateDet(name, contactNo, alternateNo, emailId, primarySkill, secondarySkill,
									noticePeriod, servingNoticePeriod, currentCompany, hrContactPerson, expYears,
									expMonths, designation, hclPositionRole, referedBy, modeOfInterview,
									interviewDateTime, currentCTC, expectedCTC, status, comments, hackerRankScore);
						}
					});

			for (CandidateDet candidateDet : results) {
				LOG.info("Found <" + candidateDet + "> in the database.");
			}

		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {
			
			System.out.println(" Job failed with following exceptions file is moved to errors folder.");
			List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
			for (Throwable th : exceptionList) {
				System.err.println("exception :" + th.getLocalizedMessage());

			}
		}
	}
}
