package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import dto.Department;
import dto.Student;

public class StudentDao 
{
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("persistence").createEntityManager();
	}
	public void saveStudent(int deptId,Student student)
	{
		EntityManager entityManager=getEntityManager();
		Department dbDepartment=entityManager.find(Department.class,deptId);
		if(dbDepartment!=null)
		{
			entityManager.getTransaction().begin();
			student.setDepartment(dbDepartment);
			entityManager.persist(student);
			entityManager.getTransaction().commit();
		}
		else
		{
			System.out.println("Invalid Department No");
		}
	}
	
	public void updateStudent(int studId,Student student)
	{
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class, studId);
		if(dbStudent!=null)
		{
			entityManager.getTransaction().begin();
			student.setId(studId);
			student.setDepartment(dbStudent.getDepartment());
			entityManager.merge(student);
			entityManager.getTransaction().commit();
		}
		else
		{
			System.out.println("Invalid student Id Provided");
		}
	}
	public void deleteStudent(int studId)
	{
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class,studId);	
		if(dbStudent!=null)
		{
			entityManager.getTransaction().begin();
			entityManager.remove(dbStudent);
			entityManager.getTransaction().commit();
		}
		else
		{
			System.out.println("Invalid student Id");
		}
	}
	public void fetchStudent(int studId)
	{
		EntityManager entityManager=getEntityManager();
		Student dbStudent=entityManager.find(Student.class,studId);	
		if(dbStudent!=null)
		{
			System.out.println(dbStudent);
		}
		else
		{
			System.out.println("Invalid student Id");
		}
	}

}
