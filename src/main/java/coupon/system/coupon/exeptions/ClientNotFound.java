package coupon.system.coupon.exeptions;

public class ClientNotFound extends Exception {
	public ClientNotFound() {
		super();
	}

	public ClientNotFound(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ClientNotFound(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ClientNotFound(Throwable arg0) {
		super(arg0);
	}

	private static final long serialVersionUID = 1L;

}
