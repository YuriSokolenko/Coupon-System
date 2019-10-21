package coupon.system.coupon.services;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import coupon.system.coupon.entites.Company;
import coupon.system.coupon.entites.Coupon;
import coupon.system.coupon.entites.Customer;
import coupon.system.coupon.entites.Income;

@CrossOrigin
@RestController
@RequestMapping("/secured/admin-service")
public class AdminController {

	private HttpSession session;

	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@Autowired
	IncomeServiceTemplate incomeService;

	@RequestMapping(value = "createCompany", method = RequestMethod.POST)
	public void createCompany(@RequestBody Company company) throws CouponSystemException {

		adminServiceImpl.createCompany(company);
	}

	@RequestMapping(value = "removeCompany", method = RequestMethod.POST)
	public void removeCompany(@RequestBody Company company) throws CouponSystemException {
		adminServiceImpl.removeCompany(company);
	}

	@RequestMapping(value = "createCustomer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody Customer customer) throws CouponSystemException {
		adminServiceImpl.createCustomer(customer);
	}

	@RequestMapping(value = "removeCustomer", method = RequestMethod.POST)
	public void removeCustomer(@RequestBody Customer cust) throws CouponSystemException {
		adminServiceImpl.removeCustomer(cust);
	}

	@RequestMapping(value = "updateCustomer", method = RequestMethod.POST)
	public void updateCustomer(@RequestBody Customer cust) throws CouponSystemException {
		adminServiceImpl.updateCustomer(cust);
	}

	@RequestMapping(value = "updateCompany", method = RequestMethod.POST)
	public void updateCompany(@RequestBody Company company) throws CouponSystemException {
		adminServiceImpl.updateCompany(company);
	}

	@RequestMapping(value = "getCustomer", method = RequestMethod.POST)
	public Customer getCustomer(@RequestBody String name) throws CouponSystemException {
		return adminServiceImpl.getCustomer(name);
	}

	@RequestMapping(value = "getAllCoupon", method = RequestMethod.POST)
	public Collection<Coupon> getAllCoupon() throws CouponSystemException {

		return adminServiceImpl.getAllCoupon();
	}

	@RequestMapping(value = "getCouponById", method = RequestMethod.GET)
	public Coupon getCoupon(@RequestBody long id, HttpServletRequest request) throws CouponSystemException {

		return adminServiceImpl.getCoupon(id);
	}

	@RequestMapping(value = "getAllCompanies", method = RequestMethod.GET)
	public Collection<Company> getAllCompanies() throws CouponSystemException {
		return adminServiceImpl.getAllCompanies();
	}

	@RequestMapping(value = "getAllCustomers", method = RequestMethod.GET)
	public Collection<Customer> getAllCustomers() throws CouponSystemException {
		return adminServiceImpl.getAllCustomers();
	}

	@RequestMapping(value = "viewIncomeByCompany", method = RequestMethod.GET)
	public Collection<Income> viewIncomeByCompany(Company company) {
		return incomeService.viewIncomeByCompany(company.getId());

	}

	@RequestMapping(value = "viewAllIncome", method = RequestMethod.GET)
	public Collection<Income> viewAllIncome() {
		return incomeService.viewAllIncome();

	}

	@RequestMapping(value = "viewTotalIncomeByCompany", method = RequestMethod.POST)
	public double viewTotalIncomeByCompany(long id) {
		Collection<Income> income = incomeService.viewIncomeByCompany(id);
		double totalIncome = 0;
		for (Income inc : income) {
			totalIncome = inc.getAmount();
		}
		return totalIncome;
	}

	@RequestMapping(value = "viewTotalIncomeByCustomer", method = RequestMethod.POST)
	public double viewTotalIncomeByCustomer(long id) {
		Collection<Income> income = incomeService.viewIncomeByCustomer(id);
		double totalIncome = 0;
		for (Income inc : income) {
			totalIncome = inc.getAmount();
		}
		return totalIncome;
	}

}