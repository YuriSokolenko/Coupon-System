package coupon.system.coupon.repositories;

import java.util.Collection;

import coupon.system.coupon.entites.Company;
import coupon.system.coupon.entites.Coupon;

public interface CustomCouponRepository {
	public abstract Collection<Coupon> findAllCouponByCompany(Company company);

}
