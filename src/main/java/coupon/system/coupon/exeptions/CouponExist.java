package coupon.system.coupon.exeptions;

public class CouponExist extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CouponExist() {
		super();
	}

	public CouponExist(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CouponExist(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CouponExist(String arg0) {
		super(arg0);
	}

	public CouponExist(Throwable arg0) {
		super(arg0);
	}

}
