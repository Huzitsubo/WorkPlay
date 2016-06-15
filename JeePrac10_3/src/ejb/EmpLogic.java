package ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Department;
import model.Employee;
import model.Job;

@Stateless
public class EmpLogic {
	@PersistenceContext
    private EntityManager em;

	// 追加
	public void createEmp(Employee emp) {
		em.persist(emp);
	}
	
	// 更新
	public void updateEmp(Employee emp) {
		em.merge(emp);
	}
	
	// 削除
	public void removeEmp(Employee emp) {
		em.remove(em.merge(emp));
	}
	
	// 参照
	public Employee getEmp(Long key) {
		return em.find(Employee.class, key);
	}
	
	public List<Job> getAllJobs() {
		return em.createQuery("SELECT c FROM Job c", Job.class).getResultList();
	}
	
	public List<Department> getAllDeps() {
		return em.createQuery("SELECT c FROM Department c", Department.class).getResultList();
	}

		
	
}
