package com.hcl.dmu.user.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.hcl.dmu.reg.dao.AbstractDAO;
import com.hcl.dmu.user.entity.RolesEntity;
import com.hcl.dmu.user.entity.UserEntity;
import com.hcl.dmu.user.vo.RolesVo;
import com.hcl.dmu.user.vo.UserVo;

@Repository
public class UserDaoImpl extends AbstractDAO implements UserDao{

	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private Mapper mapper;
	
	@Override
	public boolean login(UserVo userVo) {
		Session session = null;
		List<UserEntity> users=null;
		try {
		session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteria = builder
				.createQuery(UserEntity.class);
		Root<UserEntity> userRoot = criteria
				.from(UserEntity.class);
		criteria.select(userRoot);
		if(userVo.getUsername()!=null & userVo.getPassword()!=null & userVo.getRole()!=null){
			String username = userVo.getUsername();
			String password = userVo.getPassword();
			RolesVo role = userVo.getRole();
			@SuppressWarnings("unchecked")
			Query<RolesEntity> query = session.createQuery("FROM RolesEntity where id=:id");
			query.setParameter("id", role.getId());
			RolesEntity result = query.getSingleResult();
			Predicate p1 = builder.and(builder.equal(userRoot.get("username"), username));
			Predicate p2 = builder.and(builder.equal(userRoot.get("password"), password));
			Predicate p3 = builder.and(builder.equal(userRoot.get("rolesEntity"), result));
			criteria.where(p1,p2,p3);
			users = session.createQuery(criteria).getResultList();
		}else{
			return false;
		}
		if(users!=null && !users.isEmpty() && users.size()==1){
			return true;
		}else{
			return false;
		}
		
		}catch(Exception ex){
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<RolesVo> roles() {
		
		Session session = null;
		
		List<RolesVo> rolesVoList=null;
		RolesVo role = null;
		try {
			session = getSession();
			
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<RolesEntity> criteria = builder
					.createQuery(RolesEntity.class);
			Root<RolesEntity> rolesEntity = criteria
					.from(RolesEntity.class);
			criteria.select(rolesEntity);
			List<RolesEntity> rolesList = session.createQuery(criteria).getResultList();
			if(!rolesList.isEmpty()){
				rolesVoList = new ArrayList<>();
				for (RolesEntity re : rolesList) {
					role= new RolesVo();
					mapper.map(re,role);
					rolesVoList.add(role);
				}
			}else{
				rolesVoList = Collections.emptyList();
			}
			
			return rolesVoList;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return rolesVoList;
	}

	@Override
	public UserVo findByEmail(String usernameOrEmail) {
		Session session = null;
		List<UserEntity> users=null;
		UserVo userVo = null;
		try {
		session = getSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteria = builder
				.createQuery(UserEntity.class);
		Root<UserEntity> userRoot = criteria
				.from(UserEntity.class);
		criteria.select(userRoot);
		if(!StringUtils.isEmpty(usernameOrEmail)){
			Predicate p1 = builder.and(builder.equal(userRoot.get("username"), usernameOrEmail));
			criteria.where(p1);
			users = session.createQuery(criteria).getResultList();
			if(!CollectionUtils.isEmpty(users)){
				userVo = new UserVo();
				UserEntity userEntity = users.get(0);
				mapper.map(userEntity, userVo);
				return userVo;
			}
		}else{
			return userVo;
		}
		}catch(Exception ex){
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return userVo;
	}
}
