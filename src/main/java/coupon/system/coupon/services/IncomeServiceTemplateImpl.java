package coupon.system.coupon.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coupon.system.coupon.entites.Income;
import coupon.system.coupon.repositories.IncomeRepository;

@Service
public class IncomeServiceTemplateImpl implements IncomeServiceTemplate {

	@Autowired
	IncomeRepository incomeRepository;

	public IncomeServiceTemplateImpl() {
		super();
	}

	@Override
	public void storeIncome(Income income) {
		incomeRepository.save(income);

	}

	@Override
	public Collection<Income> viewAllIncome() {
		return incomeRepository.findAll();
	}

	@Override
	public Collection<Income> viewIncomeByCustomer(long customerID) {

		return incomeRepository.findAllById(customerID);
	}

	@Override
	public Collection<Income> viewIncomeByCompany(long companyID) {
		return incomeRepository.findAllById(companyID);
	}

}
