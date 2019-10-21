package coupon.system.coupon.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import coupon.system.coupon.entites.Coupon;

@CrossOrigin
@Repository
public interface CouponRepositoryDAO extends JpaRepository<Coupon, Long> {
	// CustomCouponRepository {

	//
	// public abstract Collection<Coupon> getCouponByType(CouponType type);
	//
	// public abstract void removeCouponFromJoinTables(Coupon coup);
	//

	@Query(value = "SELECT * FROM Coupon c WHERE c.belong_to_company_id = :companyID ", nativeQuery = true)
	public abstract Collection<Coupon> findAllCouponByCompany(@Param("companyID") long id);

}
