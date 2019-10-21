package coupon.system.coupon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import coupon.system.coupon.entites.Company;

@CrossOrigin
@Repository
public interface CompanyRepositoryDAO extends JpaRepository<Company, Long> {

	// @Query("SELECT CASE WHEN COUNT(c) > 0 THEN 'true' ELSE 'false' END FROM
	// Company c WHERE c.compName=:name")
	// public boolean existsByCompName(@Param("name") String compName);

	public Company findByName(String name);

	// public abstract void storeIncomeNewCoupon(Income income);
	//
	// public abstract void storeIncomeExistingCoupon(Income income);
	//
	// public abstract void viewIncomeByCompany(Company company);

	// public abstract Collection<Company> getAllCompanies();
	//
	// public abstract Collection<Coupon> getCoupons();
	//
	// public abstract long login(String compName, String password);
}
