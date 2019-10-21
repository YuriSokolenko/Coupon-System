package coupon.system.coupon.exeptions;

public class CredentialsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CredentialsException() {
		super();
	}

	public CredentialsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public CredentialsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CredentialsException(String arg0) {
		super(arg0);
	}

	public CredentialsException(Throwable arg0) {
		super(arg0);
	}

}
