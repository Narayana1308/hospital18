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


public class HospitalDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void saveHospital(Hospital hospital) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();	
		entityManager.persist(hospital);
		entityTransaction.commit();
		
	}
	public void updateHospital(Hospital hospital,int id) {
		EntityManager  entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Hospital hospital1=entityManager.find(Hospital.class, id);
		if(hospital1!=null) {
			hospital1.setHospital_address(hospital.getHospital_address());
			hospital1.setHospital_phone(hospital.getHospital_phone());
		    entityTransaction.begin();
		    entityManager.merge(hospital1);
		    entityTransaction.commit();
		}else {
			System.out.println("data is does not exist");
		}
	}
	public void deleteHospital(int hospital_id,int branch_id,int address_id) {
     EntityManager entityManager=getEntityManager();
     EntityTransaction entityTransaction=entityManager.getTransaction();
     Hospital hospital=entityManager.find(Hospital.class, hospital_id);
     if(hospital!=null) {
    	 BranchDao branchDao=new BranchDao();
    	 branchDao.deleteBranch(branch_id,address_id);
    	 entityTransaction.begin();
    	 entityManager.remove(hospital);
    	 entityTransaction.commit();
     }else {
    	 System.out.println("data does  not exist");
     }
		
	}
	public void getHospital_Details_On_id(int id) {
		EntityManager entityManager=getEntityManager();
		Hospital hospital=entityManager.find(Hospital.class, id);
		System.out.println(hospital);
	}
	public void get_All_Hospital_Details() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select hospital from Hospital hospital");
		List<Hospital> list=query.getResultList();
		System.out.println(list);
	}

}
