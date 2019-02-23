package com.hcl.dmu.reg.dao;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.hcl.dmu.clientprocess.entity.CandidateClientProcessEntity;
import com.hcl.dmu.clientprocess.service.ClientProcessDetailsService;
import com.hcl.dmu.reg.entity.CandidateDetEntity;
import com.hcl.dmu.reg.service.CandaidateDetService;
import com.hcl.dmu.reg.vo.CandidateDet;
import com.hcl.dmu.reg.vo.ProfileSummaryVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CandaidateDetDAOImplTest {

	@MockBean
	private CandaidateDetDAO dao;
	
	@MockBean
	private CandidateDet candidateDet;
	
	@MockBean
	CandidateDetEntity candidateDetEntity;
	
	@MockBean
	ProfileSummaryVo profileSummaryVo;
	
	@MockBean
	CandidateClientProcessEntity clientEntity;
	
	@Autowired
	private CandaidateDetService candaidateDetService;
	
	@Autowired
	private ClientProcessDetailsService clientservice;

	@Test
	public void testInsertCandidateDetails() throws Exception {
		
		given(this.dao.insertCandidateDetails(candidateDet, null)).willReturn("mock");
		assertThat(candaidateDetService.insertCandidateDetails(candidateDet, null)).isEqualTo("adithya");

	}

	@Test
	public void testGetCandidateDetails() {
		given(this.dao.getCandidateDetails(1)).willReturn(Collections.EMPTY_LIST);
		assertThat(candaidateDetService.getAllCandidateDetails(1)).isEqualTo(null);

		
	}

	@Test
	public void testModifyCandidateDetails() throws Exception {
		
		given(this.dao.modifyCandidateDetails(candidateDet, null)).willReturn("mock");
		assertThat(candaidateDetService.modifyCandidateDetails(candidateDet, null)).isEqualTo("adithya");

	}

	@Test
	public void testFindById() {
		given(this.dao.findById(1l)).willReturn(candidateDetEntity);
		assertThat(candaidateDetService.findByCandidate(1l)).isEqualTo(candidateDetEntity);
	}

	@Test
	public void testChangeCandidateStatus() {
		given(this.dao.changeCandidateStatus(Arrays.asList(1L,2L,3L))).willReturn(1);
		assertThat(clientservice.insertClientProcessDetails(Arrays.asList(1L,2L,3L))).isEqualTo(clientEntity);
	}

	@Test
	public void testInitiateHackerRank() {
		given(this.dao.initiateHackerRank(Arrays.asList(1L,2L))).willReturn(1);
		assertThat(candaidateDetService.initiateHackerRank(Arrays.asList(1L,2L))).isEqualTo(clientEntity);
	}

	@Test
	public void testInsertProfileSummaryDetails() {
		given(this.dao.insertProfileSummaryDetails(profileSummaryVo, null)).willReturn("mock");
		assertThat(candaidateDetService.insertProfileSummaryDetails(profileSummaryVo, null)).isEqualTo("adithya");
	}

	@Test
	public void testGetProfileDetails() {
		
	}

	@Test
	public void testGetCandidateDetailsCount() {
		fail("Not yet implemented"); // TODO
	}

}
