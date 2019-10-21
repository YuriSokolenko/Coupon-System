package coupon.system.coupon.entites;

import coupon.system.coupon.services.ClientType;

public class Client {

	private String name;
	private String password;
	private ClientType clientType;

	public Client(String name, String password, ClientType clientType) {
		super();
		this.name = name;
		this.password = password;
		this.clientType = clientType;
	}

	public Client() {
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", password=" + password + ", clientType=" + clientType + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

}
