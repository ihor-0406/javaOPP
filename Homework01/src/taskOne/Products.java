package taskOne;

public class Products {
	private String type;
	private String name;
	private int count;
	private double price ;
	
	public Products(String type, String name, int count, double price) {
		super();
		this.type = type;
		this.name = name;
		this.count = count;
		this.price = price;
	}

	public Products() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return count;
	}

	public void setWeight(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [type=" + type + ", name=" + name + ", count=" + count + ", price=" + price+"$" + "]";
	}
	
	
}

