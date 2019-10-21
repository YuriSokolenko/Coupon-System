package coupon.system.coupon.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coupon.system.coupon.entites.Company;
import coupon.system.coupon.entites.Coupon;
import coupon.system.coupon.entites.Income;
import coupon.system.coupon.repositories.CompanyRepositoryDAO;
import coupon.system.coupon.repositories.CouponRepositoryDAO;
import coupon.system.coupon.repositories.CustomerRepositoryDAO;
import coupon.system.coupon.repositories.IncomeRepository;

@Service
public class CompanyService implements CouponClientService {

	@Autowired
	CompanyRepositoryDAO companyRepDAO;

	@Autowired
	CustomerRepositoryDAO customerRepDAO;

	@Autowired
	CouponRepositoryDAO couponRepositoryDAO;

	@Autowired
	IncomeRepository incomeRepository;

	private Company currentCompany;

	public void storeIncome(Income income) {
		incomeRepository.save(income);
	}

	// CRU(D)

	public Company getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(Company currentCompany) {
		this.currentCompany = currentCompany;
	}

	// Receives coupon bean and creates coupon in DB
	public void createCoupon(Coupon coup) throws CouponSystemException {

		// validation if the coupon exist
		if (!couponRepositoryDAO.existsById(coup.getId())) {
			System.out.println("Current Company is: " + currentCompany);
			coup.setBelongToCompany(currentCompany);

			couponRepositoryDAO.save(coup);
		} else {
			throw new CouponSystemException("This coupon is already exist");
		}
	}

	// Removes coupon from DB
	public void removeCoupon(Coupon coup) throws CouponSystemException {
		if (!couponRepositoryDAO.existsById(coup.getId())) {
			couponRepositoryDAO.delete(coup);
		}
	}

	// Updates coupon in DB
	public void updateCoupon(Coupon coup) throws CouponSystemException {
		coup.setBelongToCompany(currentCompany);
		couponRepositoryDAO.save(coup);
	}

	// Getters:

	// Return coupon by ID
	public Coupon getCoupon(long id) throws CouponSystemException {
		return couponRepositoryDAO.findById(id).get();
	}

	// Returns all Coupons of Company
	public Collection<Coupon> getAllCompanyCoupons() throws CouponSystemException {
		return couponRepositoryDAO.findAllCouponByCompany(currentCompany.getId());
	}

}