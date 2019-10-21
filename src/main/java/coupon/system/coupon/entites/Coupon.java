package coupon.system.coupon.entites;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private Date starDate;
	private int amount;
	CouponType Type;
	private Date endDate;
	private String message;
	private double price;
	private String image;
	private CouponStatus status;

	@JsonBackReference
	@ManyToOne()
	private Company belongToCompany;

	// @JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REMOVE,
			CascadeType.REFRESH }, mappedBy = "coupons")
	// @JoinTable(name = "customer_coupons", joinColumns = { @JoinColumn(name =
	// "coupon_id") }, inverseJoinColumns = {
	// @JoinColumn(name = "customer_id") })

	private Collection<Customer> Customers;

	public Company getBelongToCompany() {
		return belongToCompany;
	}

	public void setBelongToCompany(Company belongToCompany) {
		this.belongToCompany = belongToCompany;
	}

	// c-tor
	public Coupon() {
	};

	public Coupon(long id, String title, Date starDate, Date endDate, int amount, CouponType type, String message,
			double price, String image, CouponStatus status) {
		this.id = id;
		this.title = title;
		this.starDate = starDate;
		this.amount = amount;
		this.Type = type;
		this.endDate = endDate;
		this.message = message;
		this.price = price;
		this.image = image;
		this.status = status;
	}

	public CouponStatus get_status() {
		return this.status;
	}

	public void set_status(CouponStatus _status) {
		this.status = _status;
	}

	// Setters and Getters:
	/**
	 * @return the _id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the _id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the _title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the _title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the _starDate
	 */
	public Date getStarDate() {
		return starDate;
	}

	/**
	 * @param starDate
	 *            the _starDate to set
	 */
	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	/**
	 * @return the _amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the _amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the type
	 */
	public CouponType getType() {
		return Type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(CouponType type) {
		this.Type = type;
	}

	/**
	 * @return the _endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the _endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the _message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the _message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the _price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the _price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the _image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the _image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", starDate=" + starDate + ", amount=" + amount + ", Type="
				+ Type + ", endDate=" + endDate + ", message=" + message + ", price=" + price + ", image=" + image
				+ ", status=" + status + "]";
	}

}
