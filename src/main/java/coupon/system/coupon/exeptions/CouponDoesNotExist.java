package coupon.system.coupon.exeptions;

public class CouponDoesNotExist extends Exception {
	/**
	 * Exception class for Coupon System
	 */
	private static final long serialVersionUID = 1L;

	public CouponDoesNotExist() {
		super();
	}

	public CouponDoesNotExist(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CouponDoesNotExist(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CouponDoesNotExist(String arg0) {
		super(arg0);
	}

	public CouponDoesNotExist(Throwable arg0) {
		super(arg0);
	}

}
