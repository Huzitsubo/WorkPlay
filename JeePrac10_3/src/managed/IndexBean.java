package managed;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.EmpLogic;
import model.Department;
import model.Employee;
import model.Job;

@Named
@RequestScoped
public class IndexBean {

	private Employee dispEmp;
	
	private model.Job 			job;
	private model.Department	department;
		
	private Map<String, String> jobItems;
	private Map<String, Long> depItems;
	
	@EJB
	EmpLogic db;
	
	@Inject
	transient Logger log; // ログの記録用

	
	@PostConstruct
	public void init(){
		dispEmp = new Employee();
		dispEmp.setDepartment(new Department());
		dispEmp.setJob(new Job());
	}
	
	public String next() {
		return null; // 画面再表示
	}
	

	public void actionGetEmp() {
		Employee emp = db.getEmp(dispEmp.getEmployeeId());
		if(emp != null){
			dispEmp = emp;
		}
	}
	
	public void actionCreateEmp() {
		//Employee emp = new Employee(id, fName, lName, mail, date, jobId, depId);// エンティティを生成
		try {
			db.createEmp(dispEmp);
			init();
		} catch (Exception e) {
			log.severe("★新規登録できない/" + dispEmp.getEmployeeId()); // 失敗
		}
	}
	
	public void actionUpdateEmp() {
		try {
			db.updateEmp(dispEmp);
			init();
		} catch (Exception e) {
			log.severe("★新規登録できない/" + dispEmp.getEmployeeId()); // 失敗
		}
	}
	
	public void actionRemoveEmp() {
		db.removeEmp(dispEmp);
		init();
	}
	
	/**
	 * 所属プルダウンメニュー用
	 * @return jobのMap
	 */
	public Map<String, String> getJobs() {
		List<Job> list = db.getAllJobs();
		jobItems = new LinkedHashMap<>();
		jobItems.put("", "");
		for (Job m : list) {
			jobItems.put(m.getJobTitle(),
					m.getJobId());
		}
		return jobItems;
	}
	
	/**
	 * 所属プルダウンメニュー用
	 * @return DepartmentのMap
	 */
	public Map<String, Long> getDeps() {
		List<Department> list = db.getAllDeps();
		depItems = new LinkedHashMap<>();
		depItems.put(" ", (long) 0);
		for (Department m : list) {
			depItems.put(m.getDepartmentName(),
					m.getDepartmentId());
		}
		return depItems;
	}



	public model.Job getJob() {
		return job;
	}

	public void setJob(model.Job job) {
		this.job = job;
	}

	public model.Department getDepartment() {
		return department;
	}

	public void setDepartment(model.Department department) {
		this.department = department;
	}

	public Employee getDispEmp() {
		return dispEmp;
	}

	public void setDispEmp(Employee dispEmp) {
		this.dispEmp = dispEmp;
	}
	
	
}
