package coupon.system.coupon.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import coupon.system.coupon.entites.Company;
import coupon.system.coupon.entites.Coupon;
import coupon.system.coupon.entites.Customer;
import coupon.system.coupon.repositories.CompanyRepositoryDAO;
import coupon.system.coupon.repositories.CouponRepositoryDAO;
import coupon.system.coupon.repositories.CustomerRepositoryDAO;

@CrossOrigin
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	CompanyRepositoryDAO companyRepositoryDAO;

	@Autowired
	CustomerRepositoryDAO customerRepDAO;

	@Autowired
	CouponRepositoryDAO couponRepositoryDAO;

	public AdminServiceImpl() {

	}

	@Override
	public void createCompany(Company company) throws CouponSystemException {
		// validate if the company exist and if there is company with same name

		if (companyRepositoryDAO.existsById(company.getId())
				&& (companyRepositoryDAO.findByName(company.getName()) != null)) {
			throw new CouponSystemException("Company with the same name or ID already exist");
		} else {
			companyRepositoryDAO.save(company);
		}
	}

	// // delete company and all its coupons
	@Override
	public void removeCompany(Company company) throws CouponSystemException {

		companyRepositoryDAO.delete(company);

	}

	@Override
	public void updateCompany(Company company) throws CouponSystemException {
		companyRepositoryDAO.saveAndFlush(company);
	}

	public Optional<Company> getCompany(long id) throws CouponSystemException {
		return companyRepositoryDAO.findById(id);

	}

	public Collection<Company> getAllCompanies() throws CouponSystemException {
		return companyRepositoryDAO.findAll();
	}

	@Override
	public void createCustomer(Customer customer) throws CouponSystemException {

		if (!(customerRepDAO.existsById(customer.getId()))) {
			customerRepDAO.save(customer);
		} else {
			throw new CouponSystemException("Customer " + customer + " already exist!");
		}
	}

	public void removeCustomer(Customer cust) throws CouponSystemException {
		if (!customerRepDAO.existsById(cust.getId())) {

			customerRepDAO.delete(cust);
		} else {
			throw new CouponSystemException("Customer " + cust + " doensn`t exist!");

		}
	}

	public void updateCustomer(Customer cust) throws CouponSystemException {
		if (!customerRepDAO.existsById(cust.getId())) {
			customerRepDAO.save(cust);
		} else {
			throw new CouponSystemException("Customer " + cust + " doensn`t exist!");

		}
	}

	@Override
	public Customer getCustomer(String name) throws CouponSystemException {
		return customerRepDAO.findByName(name);
	}

	public Collection<Customer> getAllCustomers() throws CouponSystemException {
		return customerRepDAO.findAll();
	}

	@Override
	public Collection<Coupon> getAllCoupon() throws CouponSystemException {
		return couponRepositoryDAO.findAll();
	}

	// Return coupon by ID
	@Override
	public Coupon getCoupon(long id) throws CouponSystemException {
		return couponRepositoryDAO.findById(id).get();
	}
}
