package coupon.system.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import coupon.system.coupon.services.CouponSystemException;

@SpringBootApplication
@ServletComponentScan
public class CouponApplication {

	public static void main(String[] args) throws CouponSystemException {

		ConfigurableApplicationContext context = SpringApplication.run(CouponApplication.class, args);

	}
}
