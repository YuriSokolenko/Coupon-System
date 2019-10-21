package coupon.system.coupon.entites;
import java.util.NoSuchElementException;

public enum CouponType {
RESTURANS, ELECTRICITY, FOOD, HEALTH, SPORTS, CAMPING, TRAVALLING;
	
	//returns next type 
	public CouponType nextType() {
		if(ordinal()==values().length-1)
			throw new NoSuchElementException();
		return values()[ordinal()+1];
	}
}
