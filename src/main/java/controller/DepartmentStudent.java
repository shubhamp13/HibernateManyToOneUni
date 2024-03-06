package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.DepartmentDao;
import dao.StudentDao;
import dto.Department;
import dto.Student;

public class DepartmentStudent {
	public static void main(String[] args) {
		System.out.println("Enter Your Choice");
		System.out.println("1.Save The Department");
		System.out.println("2.Save The Student");
		System.out.println("3.Update The Department");
		System.out.println("4.Update The Student Details");
		System.out.println("5.Fetch The Department Details");
		System.out.println("6.Fetch The Student Details");
		System.out.println("7.Delete The Department Details");
		System.out.println("8.Delete The Student Details");
		System.out.println("9.Exit");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			Student student = new Student();
			StudentDao studentDao = new StudentDao();
			Department department = new Department();
			DepartmentDao departmentDao = new DepartmentDao();
			int choice = Integer.parseInt(bufferedReader.readLine());
			switch (choice) {
			case 1: {
				System.out.println("Enter Department Name");
				String deptName = bufferedReader.readLine();
				System.out.println("Enter department number");
				int deptNo = Integer.parseInt(bufferedReader.readLine());
				department.setDeptName(deptName);
				department.setDeptNo(deptNo);
				departmentDao.saveDepartment(department);
				System.out.println("Department Saved");
			}
				break;
			case 2: {
				System.out.println("Enter Department No in which You want to enroll");
				int deptNo = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Enter Student Name");
				String name = bufferedReader.readLine();
				System.out.println("Enter Student Id");
				int studId = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Enter Student Email id");
				String emailId = bufferedReader.readLine();
				System.out.println("Enter Student Address");
				String address = bufferedReader.readLine();
				System.out.println("Enter Student Phone No");
				long phNo = Long.parseLong(bufferedReader.readLine());
				student.setAddress(address);
				student.setEmailId(emailId);
				student.setId(studId);
				student.setPhNo(phNo);
				student.setName(name);
				studentDao.saveStudent(deptNo, student);
				System.out.println("Student Saved");
			}
				break;
			case 3: {
				System.out.println("Enter Department No to be updated");
				int deptNo = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Enter Department Name");
				String deptName = bufferedReader.readLine();
				department.setDeptName(deptName);
				departmentDao.updateDepartment(deptNo, department);
			}
				break;
			case 4: {
				System.out.println("Enter Student Id");
				int studId = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Enter Student Name");
				String name = bufferedReader.readLine();
				System.out.println("Enter Student Email id");
				String emailId = bufferedReader.readLine();
				System.out.println("Enter Student Address");
				String address = bufferedReader.readLine();
				System.out.println("Enter Student Phone No");
				long phNo = Long.parseLong(bufferedReader.readLine());
				student.setAddress(address);
				student.setEmailId(emailId);
				student.setPhNo(phNo);
				student.setName(name);
				studentDao.updateStudent(studId, student);
			}
			break;
			case 5: {
				System.out.println("Enter Department No to be fetched");
				int deptNo = Integer.parseInt(bufferedReader.readLine());
				departmentDao.fetchDepartment(deptNo);
			}
				break;
			case 6: {
				System.out.println("Enter Student Id No to be fetched");
				int studId = Integer.parseInt(bufferedReader.readLine());
				studentDao.fetchStudent(studId);
			}
				break;
			case 7: {
				System.out.println("Enter Department No to be deleted");
				int deptNo = Integer.parseInt(bufferedReader.readLine());
				departmentDao.deleteDepartment(deptNo);
			}
				break;
			case 8: {
				System.out.println("Enter Student Id No to be deleted");
				int studId = Integer.parseInt(bufferedReader.readLine());
				studentDao.deleteStudent(studId);
			}
				break;
			case 9: {
				return;
			}
			default: {
				System.out.println("Invalid Choice Please put from 1-9");
			}
				break;

			}

		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
