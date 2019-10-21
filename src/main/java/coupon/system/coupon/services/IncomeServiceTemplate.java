package coupon.system.coupon.services;

import java.util.Collection;

import coupon.system.coupon.entites.Income;

public interface IncomeServiceTemplate {

	public void storeIncome(Income income);

	public Collection<Income> viewAllIncome();

	public Collection<Income> viewIncomeByCustomer(long customerID);

	public Collection<Income> viewIncomeByCompany(long companyID);

}
