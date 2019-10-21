package coupon.system.coupon.entites;

import java.util.NoSuchElementException;

public enum CouponStatus {
	ACTIVE, CANCALED, TERMINATED, EXPIRED;

	// returns next type
	public CouponStatus nextType() {
		if (ordinal() == values().length - 1)
			throw new NoSuchElementException();
		return values()[ordinal() + 1];
	}

}
