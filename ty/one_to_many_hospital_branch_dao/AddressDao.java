package com.ty.one_to_many_hospital_branch_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.one_to_many_hospital_branch_dto.Address;
import com.ty.one_to_many_hospital_branch_dto.Branch;

public class AddressDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void saveAddress(Address address,int branch_id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, branch_id);
		if(branch!=null) {
			address.setBranch(branch);
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
		}
		
	}
	public void updateAddress(Address address,int id) {
		EntityManager entityManager =getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Address address1=entityManager.find(Address.class, id);
		if(address1!=null) {
			address1.setRoad_Num(address.getRoad_Num());
			address1.setPincode(address.getPincode());
			entityTransaction.begin();
			entityManager.merge(address1);
			entityTransaction.commit();
		}
		
	}
	public void deleteAddress(int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Address address=entityManager.find(Address.class, id);
		if(address !=null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
		}
	}
    public void getAddressDetailsOnId(int id) {
     EntityManager entityManager=getEntityManager();
     Address address=entityManager.find(Address.class, id);
     if(address!=null) {
    	 System.out.println(address);
     }
     else {
    	 System.out.println("data is not exist");
     }
    }
    public void getAllAddress_Details() {
    	EntityManager entityManage=getEntityManager();
    	Query query=entityManage.createQuery("select add from Address add");
    	List<Address> list =query.getResultList();
    	System.out.println(list);
    	
    }
}
