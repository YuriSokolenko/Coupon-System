package coupon.system.coupon.entites;

public enum IncomeType {
	CUSTOMER_PURCHASE("Income from customer purchase"), COMPANY_NEW_COUPON(
			"Income of Company new coupon"), COMPANY_UPDATE_COUPON("Income from company coupon update");

	private String description;

	private IncomeType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
