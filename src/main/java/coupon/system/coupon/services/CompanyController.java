package coupon.system.coupon.services;

import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import coupon.system.coupon.entites.Client;
import coupon.system.coupon.entites.Company;
import coupon.system.coupon.entites.Coupon;
import coupon.system.coupon.entites.Income;
import coupon.system.coupon.entites.IncomeType;

@Transactional
@RestController
@CrossOrigin
@RequestMapping("/secured/company-service")
public class CompanyController {

	@Autowired
	IncomeServiceTemplate incomeService;

	@Autowired
	CompanyService companyService;

	private Income income;

	@RequestMapping(value = "createCoupon", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCoupon(@RequestBody Coupon coupon, HttpServletRequest request) throws CouponSystemException {

		Company currentCompany = getCurrentCompanyFromSession(request);
		companyService.setCurrentCompany(currentCompany);

		// setting income
		income.setAmount(100);
		income.setDate(new Date());
		income.setDescription(IncomeType.COMPANY_NEW_COUPON.name());
		income.setName(currentCompany.getName());
		incomeService.storeIncome(income);
		companyService.createCoupon(coupon);
	}

	@RequestMapping(value = "removeCoupon", method = RequestMethod.POST)
	public void removeCoupon(@RequestBody Coupon coupon, HttpServletRequest request) throws CouponSystemException {
		companyService.setCurrentCompany(getCurrentCompanyFromSession(request));
		companyService.removeCoupon(coupon);
	}

	@RequestMapping(value = "updateCoupon", method = RequestMethod.POST)
	public void updateCoupon(@RequestBody Coupon coupon, HttpServletRequest request) throws CouponSystemException {
		Company currentCompany = getCurrentCompanyFromSession(request);
		companyService.setCurrentCompany(currentCompany);
		// setting income
		income.setAmount(10);
		income.setDate(new Date());
		income.setDescription(IncomeType.COMPANY_UPDATE_COUPON.name());
		income.setName(currentCompany.getName());
		incomeService.storeIncome(income);
		companyService.updateCoupon(coupon);
	}

	@RequestMapping(value = "getCompanyCoupons", method = RequestMethod.GET)
	public Collection<Coupon> getAllCompanyCoupons(HttpServletRequest request) throws CouponSystemException {
		System.out.println("In GetCompanyCoupon");
		// get session:
		Company currentCompany = getCurrentCompanyFromSession(request);

		companyService.setCurrentCompany(currentCompany);
		System.out.println("Current Company is: " + currentCompany);
		return companyService.getAllCompanyCoupons();

	}

	@RequestMapping(value = "getCompanyCouponById", method = RequestMethod.GET)
	public Coupon getCoupon(@RequestBody long id, HttpServletRequest request) throws CouponSystemException {
		Company currentCompany = getCurrentCompanyFromSession(request);

		companyService.setCurrentCompany(currentCompany);
		System.out.println("Current Company is: " + currentCompany);
		return companyService.getCoupon(id);
	}

	@RequestMapping(value = "viewIncomeByCompany", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Income> viewIncomeByCompany(@RequestBody Company company, HttpServletRequest request) {
		Company currentCompany = getCurrentCompanyFromSession(request);
		companyService.setCurrentCompany(currentCompany);
		return incomeService.viewIncomeByCompany(currentCompany.getId());
	}

	/**
	 * Private method to get current Company from session attribute
	 * 
	 * @param request
	 * @return Current logged in Company
	 */
	private Company getCurrentCompanyFromSession(HttpServletRequest request) {
		HttpServletRequest httpRequest = request;
		String sessionID = httpRequest.getParameter("id");
		System.out.println(sessionID + " Session ID in getCompanyCOUPON!");
		HttpSession session = SessionIdCollector.clientsSessions.get(sessionID);
		System.out.println(" I succeed to get session from MAP! " + session.getId());
		// get currentCompany
		Client clientAttribute = (Client) session.getAttribute(LogInServiceImpl.LOGGED_IN_USER);
		System.out.println(" Logged in Client in CompanyController method: " + clientAttribute);
		Company currentCompany = companyService.companyRepDAO.findByName(clientAttribute.getName());
		return currentCompany;
	}

}
