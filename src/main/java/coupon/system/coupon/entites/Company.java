package coupon.system.coupon.entites;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	private String name;
	private String password;
	private String email;

	@OneToMany(mappedBy = "belongToCompany", cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH })
	@JsonManagedReference
	private Collection<Coupon> coupons = new ArrayList<>();

	public Collection<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(Collection<Coupon> coupons) {
		this.coupons = coupons;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company() {
		super();
	}

	public Company(long id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	// getters
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String password() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	// setters
	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCompanyName(String companyName) {
		this.name = companyName;
	}

	@Override
	public String toString() {
		return ("Company id=" + id + ", compName=" + name + ", password=" + password + ", email=" + email);
	}

	public String getPassword() {
		return this.password;
	}
}