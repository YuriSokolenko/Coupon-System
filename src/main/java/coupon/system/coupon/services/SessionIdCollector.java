package coupon.system.coupon.services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionIdCollector {

	public static Map<String, HttpSession> clientsSessions = new HashMap<>();

}
