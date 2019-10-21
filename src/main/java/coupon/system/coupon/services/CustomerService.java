package coupon.system.coupon.services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coupon.system.coupon.entites.Coupon;
import coupon.system.coupon.entites.Customer;
import coupon.system.coupon.repositories.CouponRepositoryDAO;
import coupon.system.coupon.repositories.CustomerRepositoryDAO;

@Transactional
@Service("")
public class CustomerService implements CouponClientService {

	@Autowired
	CustomerRepositoryDAO customerRepDAO;

	@Autowired
	CouponRepositoryDAO couponRepositoryDAO;

	@Autowired
	IncomeServiceTemplate incomeRepository;
	private Customer currentCust;

	public CustomerService() {
	}

	// Adds Coupon to Customer
	public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
		// validation: if a coupon exist and what it amount is

		if (!couponRepositoryDAO.existsById(coupon.getId()) && coupon.getAmount() > 0) {
			// validate does has customer this coupon
			if (!((currentCust).getCoupons().contains(coupon))) {
				currentCust.getCoupons().add(coupon);
				coupon.setAmount(coupon.getAmount() - 1);

			}
		}
	}

	public Customer getCurrentCust() {
		return currentCust;
	}

	public void setCurrentCust(Customer currentCust) {
		this.currentCust = currentCust;
	}

	// Gets Customers Coupons
	public Collection<Coupon> getAllPurchasedCoupons() throws CouponSystemException {
		Collection<Coupon> custCoupons = new ArrayList<Coupon>();
		custCoupons = customerRepDAO.findCustomerCouponsById(currentCust.getId());
		for (Coupon c : custCoupons) {
			System.out.println(c);
		}
		return custCoupons;

	}

	// Gets All Customer Coupons By Type
	// public void getAllPurchasedCouponsByType(CouponType type) throws
	// CouponSystemException {
	// Collection<Coupon> custCoupons = new ArrayList<Coupon>();
	// custCoupons = customerDao.getCustomersCouponsByType(currentCust.getId(),
	// type);
	// for (Coupon c : custCoupons) {
	// System.out.println(c);
	// }
	// }

	// Gets All Customer Coupons By Price
	// public void getAllPurchasedCouponsByPrice(double price) throws
	// CouponSystemException {
	// Collection<Coupon> custCoupons = new ArrayList<Coupon>();
	// custCoupons = customerDao.getCustomersCouponsUpToPrice(currentCust.getId(),
	// price);
	// for (Coupon c : custCoupons) {
	// System.out.println(c);
	// }
	// }

}
