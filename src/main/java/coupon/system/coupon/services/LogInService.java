package coupon.system.coupon.services;

import javax.servlet.http.HttpServletRequest;

import coupon.system.coupon.entites.Client;

public interface LogInService {
	public String login(Client client, HttpServletRequest r) throws CouponSystemException;

	public void logout(HttpServletRequest r, String sessionID) throws CouponSystemException;
}
