package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import dto.Department;

public class DepartmentDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("persistence").createEntityManager();
	}
	
	public void saveDepartment(Department department)
	{
		EntityManager entityManager=getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(department);
		entityManager.getTransaction().commit();
	}
	public void updateDepartment(int deptId,Department department)
	{
		EntityManager entityManager=getEntityManager();
		Department dbDepartment=entityManager.find(Department.class, deptId);
		if(dbDepartment!=null)
		{
			entityManager.getTransaction().begin();
			department.setDeptNo(deptId);
			entityManager.merge(department);
			entityManager.getTransaction().commit();
		}
		else
		{
			System.out.println("Invalid Department No Provided");
		}
	}
	public void deleteDepartment(int deptId)
	{
		EntityManager entityManager=getEntityManager();
		Department dbDepartment=entityManager.find(Department.class, deptId);
		if(dbDepartment!=null)
		{
			entityManager.getTransaction().begin();
			entityManager.remove(dbDepartment);
			entityManager.getTransaction().commit();
		}
		else
		{
			System.out.println("Invalid Department Number");
		}
	}
	public void fetchDepartment(int deptId)
	{
		EntityManager entityManager=getEntityManager();
		Department dbDepartment=entityManager.find(Department.class, deptId);
		if(dbDepartment!=null)
		{
			System.out.println(dbDepartment);
		}
		else
		{
			System.out.println("Invalid Department Number");
		}
	}
	
}
