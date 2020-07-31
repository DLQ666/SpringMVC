package com.dlq.rest.crud.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dlq.rest.crud.bean.Department;
import com.dlq.rest.crud.bean.Employee;
import com.dlq.rest.crud.dao.DepartmentDao;
import com.dlq.rest.crud.dao.EmployeeDao;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
public class EmpController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	/**
	 * <a>查询全部列表
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/emps")
	public String getAll(Map<String,Object> map) {
		Collection<Employee> emps = employeeDao.getAll();
		map.put("emps", emps);
		return "list";
	}
	
	/**
	 * <a>跳转到添加页面
	 * @return
	 */
	@RequestMapping(value="emp",method=RequestMethod.GET)
	public String toAdd(Map<String, Object> map) {
		//获取所有部门信息
		Collection<Department> depts = departmentDao.getDepartments();
		//创建存储性别gender的信息
		Map<String ,String> genders = new HashMap<>();
		genders.put("1", "男");
		genders.put("0", "女");
		map.put("depts", depts);
		map.put("genders", genders);
		//form标签有自动回显的功能，会在页面中能够默认获取request作用域中command属性的值
		//map.put("command", new Employee());
		//若在<form:form>设置了modelAttribute，就可以自定义回显对象的属性名
		map.put("emp", new Employee());
		return "edit";
	}
	
	/**
	 *  <a>添加员工信息
	 * @param employee
	 * @return
	 */
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String addEmp(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	/**
	 * <a>获取到要回显的数据，跳转到修改页面，并回显
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String toUpdate(@PathVariable("id")Integer id,Map<String,Object> map) {
		// 获取要修改的员工信息
		Employee emp = employeeDao.get(id);
		// 获取所有的部门信息，供用户选择
		Collection<Department> depts = departmentDao.getDepartments();
		// 创建存储性别gender的信息
		Map<String, String> genders = new HashMap<>();
		genders.put("1", "男");
		genders.put("0", "女");
		map.put("emp", emp);
		map.put("depts", depts);
		map.put("genders", genders);
		return "edit";
	}
	
	/**
	 * <a>修改员工信息
	 */
	@RequestMapping(value = "/emp", method = RequestMethod.PUT)
	private String updateEmp(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	/**
	 * <a>删除员工信息
	 */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String deleteEmp(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
}