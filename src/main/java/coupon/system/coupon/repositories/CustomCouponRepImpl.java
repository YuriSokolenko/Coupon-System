package coupon.system.coupon.repositories;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import coupon.system.coupon.entites.Company;
import coupon.system.coupon.entites.Coupon;

@Repository
@Transactional(readOnly = true)
public class CustomCouponRepImpl implements CustomCouponRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Collection<Coupon> findAllCouponByCompany(Company company) {

		Query query = entityManager
				.createNativeQuery("SELECT * FROM coupon_system.coupon where belong_to_company_id=?");
		query.setParameter(1, company.getId());
		List<Coupon> listResult = query.getResultList();
		return listResult;

	}

}
