package coupon.system.coupon.services;

import java.util.Collection;

import coupon.system.coupon.entites.Company;
import coupon.system.coupon.entites.Coupon;
import coupon.system.coupon.entites.Customer;

public interface AdminService {
	public void createCompany(Company company) throws CouponSystemException;

	public void removeCompany(Company company) throws CouponSystemException;

	public void updateCompany(Company company) throws CouponSystemException;

	public void createCustomer(Customer customer) throws CouponSystemException;

	// public void removeCustomer(Customer cust) throws CouponSystemException;

	// public void updateCustomer(Customer cust) throws CouponSystemException;

	public Customer getCustomer(String name) throws CouponSystemException;

	public Collection<Coupon> getAllCoupon() throws CouponSystemException;

	public Coupon getCoupon(long id) throws CouponSystemException;

	// public Collection<Customer> getAllCustomers() throws CouponSystemException;

	// public Collection<Income> viewIncomeByCompany(Company company);
	//
	// public Collection<Income> viewIncomeByCustomer(Customer customer);
	//
	// public Collection<Income> viewAllIncome();

}
