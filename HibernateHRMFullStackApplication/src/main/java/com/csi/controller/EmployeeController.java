package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeService employeeServiceImpl = new EmployeeServiceImpl();

	String SIGHUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String EDITDATA_PAGE = "/edit.jsp";
	String SHOWDATA_PAGE = "/show.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String redirect = "";

		String empName = request.getParameter("empname");
		String action = request.getParameter("action");

		if (action.equals("signup") && empName != null) {
			String empAddress = request.getParameter("empaddress");
			long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));
			double empSalary = Double.valueOf(request.getParameter("empsalary"));
			String empGender = request.getParameter("empgender");
			long empUID = Long.valueOf(request.getParameter("empuid"));
			String empPanCardNumber = request.getParameter("emppancardnumber");
			int age = Integer.valueOf(request.getParameter("empage"));
			Date empDOBDate = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				empDOBDate = simpleDateFormat.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String empEmailId = request.getParameter("empemailid");
			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee(empName, empAddress, empContactNumber, empSalary, empGender, age, empUID,
					empPanCardNumber, empDOBDate, empEmailId, empPassword);

			employeeServiceImpl.signUp(employee);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {

			String empEmailId = request.getParameter("empemailid");
			String empPassword = request.getParameter("emppassword");

			if (employeeServiceImpl.signIn(empEmailId, empPassword)) {

				request.setAttribute("empList", employeeServiceImpl.getAllData());
				redirect = SHOWDATA_PAGE;

			} else {
				request.setAttribute("massage", "Invalid credietian please try again !!!");
				redirect = SIGNIN_PAGE;

			}

		} else if (action.equals("edit_form")) {
			redirect = EDITDATA_PAGE;

		} else if (action.equals("edit")) {
			int empId = Integer.valueOf(request.getParameter("empid"));
			String employeeName = request.getParameter("empname");

			String empAddress = request.getParameter("empaddress");
			long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));
			double empSalary = Double.valueOf(request.getParameter("empsalary"));
			String empGender = request.getParameter("empgender");
			long empUID = Long.valueOf(request.getParameter("empuid"));
			String empPanCardNumber = request.getParameter("empaddress");
			int age = Integer.valueOf(request.getParameter("empage"));
			Date empDOBDate = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				empDOBDate = simpleDateFormat.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String empEmailId = request.getParameter("empemailid");
			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee(empName, empAddress, empContactNumber, empSalary, empGender, age, empUID,
					empPanCardNumber, empDOBDate, empEmailId, empPassword);
			employeeServiceImpl.updateData(empId, employee);

			request.setAttribute("empList", employeeServiceImpl.getAllData());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deletedatabyid")) {

			int empid = Integer.valueOf(request.getParameter("empId"));
			employeeServiceImpl.deleteDataById(empid);
			request.setAttribute("empList", employeeServiceImpl.getAllData());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deletealldata")) {

			employeeServiceImpl.deleteAllData();
			request.setAttribute("empList", employeeServiceImpl.getAllData());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyid")) {

			request.setAttribute("empList", employeeServiceImpl.getAllData().stream()
					.sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyname")) {

			request.setAttribute("empList", employeeServiceImpl.getAllData().stream()
					.sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbysalary")) {

			request.setAttribute("empList", employeeServiceImpl.getAllData().stream()
					.sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbygender")) {

			request.setAttribute("empList", employeeServiceImpl.getAllData().stream()
					.sorted(Comparator.comparing(Employee::getEmpGender)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbydob")) {

			request.setAttribute("empList", employeeServiceImpl.getAllData().stream()
					.sorted(Comparator.comparing(Employee::getEmpDOB)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyage")) {

			request.setAttribute("empList", employeeServiceImpl.getAllData().stream()
					.sorted(Comparator.comparingInt(Employee::getEmpAge)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbyid")) {

			int empId = Integer.valueOf(request.getParameter("empid"));

			request.setAttribute("empList", employeeServiceImpl.getAllData().stream()
					.filter(emp -> emp.getEmpId() == empId).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbyname")) {
			String name = request.getParameter("empname");
			request.setAttribute("empList", employeeServiceImpl.getAllData().stream()
					.filter(emp -> emp.getEmpName().equals(name)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbycontactnumber")) {

			long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));
			request.setAttribute("empList", employeeServiceImpl.getAllData().stream()
					.filter(emp -> emp.getEmpContactNumber() == empContactNumber).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("searchbyemailid")) {
			
			String empEmailId=request.getParameter("empemailid");
			
			request.setAttribute("empList", employeeServiceImpl.getAllData().stream().filter(emp->emp.getEmpEmailId().equals(empEmailId)).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("searchbyanyinput")) {
			
			String input=request.getParameter("input");
			List<Employee> employees=new ArrayList<Employee>();
			
			
			for(Employee employee:employeeServiceImpl.getAllData()) {
		      if (String.valueOf(employee.getEmpId()).equals(input)
		    		  ||employee.getEmpName().equals(empName)
		    		  ||employee.getEmpEmailId().equals(input)
		    		  ||employee.getEmpPanCardNumber().equals(input)
		    		  ||String.valueOf(employee.getEmpContactNumber()).equals(input)
		    		  ||String.valueOf(employee.getEmpUID()).equals(input))
		    		  
		    	  employees.add(employee); 
	 
			}
			request.setAttribute("empList", employees);
			redirect=SHOWDATA_PAGE; 

		} else if (action.equals("searchbyuid")) {

			long empUID=Long.valueOf(request.getParameter("empuid"));
			
			request.setAttribute("empList", employeeServiceImpl.getAllData().stream().filter(emp->emp.getEmpUID()==empUID).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;
			
		} else if (action.equals("searchbypancard")) {
			
			String empPanCardNumber=request.getParameter("emppancardnumber");
			request.setAttribute("empList", employeeServiceImpl.getAllData().stream().filter(emp->emp.getEmpPanCardNumber().equals(empPanCardNumber)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbysalary")) {
			
			double empSalary=Double.valueOf(request.getParameter("empsalary"));
			
			request.setAttribute("empList", employeeServiceImpl.getAllData().stream().filter(emp->emp.getEmpSalary()==empSalary).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirect);
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
