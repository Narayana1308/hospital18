package com.ty.one_to_many_hospital_branch_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_many_hospital_branch_dto.Address;
import com.ty.one_to_many_hospital_branch_dto.Branch;
import com.ty.one_to_many_hospital_branch_dto.Hospital;

public class BranchDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void saveBranch(Branch branch,int hospital_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Hospital hospital=entityManager.find(Hospital.class, hospital_id);
		if(hospital!=null) {
	    branch.setHospital(hospital);
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
		}
	}

	public void updateBranch(Branch branch, int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch branch2 = entityManager.find(Branch.class,id);
		if (branch2 != null) {
			branch2.setBranch_phone(branch.getBranch_phone());
			branch2.setHeadOfBranch(branch.getHeadOfBranch());
			entityTransaction.begin();
			entityManager.merge(branch2);
			entityTransaction.commit();
		}
	}

	public void deleteBranch(int branch_id,int address_id) {
		EntityManager entityManager =getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, branch_id);
		if(branch!=null) {
			AddressDao addressDao=new AddressDao();
			addressDao.deleteAddress(address_id);
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			
		}

	}
	public void getBranchOnId(int id) {
		EntityManager  entityManager=getEntityManager();
		//EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, id);
		if(branch!=null) {
			System.out.println(branch);
		}
		
	}
	public void getBranchAllDetails() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select branch from Branch branch");
		List<Branch> list=query.getResultList();
		System.out.println(list);
		
	}
}
