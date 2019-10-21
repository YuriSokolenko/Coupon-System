package coupon.system.coupon.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import coupon.system.coupon.entites.Coupon;
import coupon.system.coupon.entites.Customer;

@Repository
public interface CustomerRepositoryDAO extends JpaRepository<Customer, Long> {

	// @Query("SELECT CASE WHEN COUNT(c) > 0 THEN 'true' ELSE 'false' END FROM
	// Customer c WHERE c.custName=:name")

	// public boolean existsByName(@Param("name") String custName);

	@Query(value = "SELECT * FROM customer c WHERE c.name = :customerName", nativeQuery = true)
	public Customer findByName(@Param("customerName") String name);

	public void save(Coupon coupon);

	@Query(value = "SELECT * FROM customer_coupons c WHERE c.customer_id = :customerID ", nativeQuery = true)
	public abstract Collection<Coupon> findCustomerCouponsById(@Param("customerID") long id);

	// public void storeIncome(Income income);

	// public abstract Collection<Customer> getAllCustomers();
	//
	// public abstract Collection<Coupon> getCoupons();

}
