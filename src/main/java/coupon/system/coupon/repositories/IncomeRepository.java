package coupon.system.coupon.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import coupon.system.coupon.entites.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {

	@Query(value = "SELECT * FROM income i WHERE i.id = :companyId ", nativeQuery = true)
	public Collection<Income> findAllById(@Param("companyId") long id);
}
