package test.productDto;

public class productDto {
	private int num;
	private String photo;
	private String title;
	private String price;
	private int quantity;
	private String content;
	private String regdate;
	
	public productDto() {}

	public productDto(int num, String photo, String title, String price, int quantity, String content, String regdate) {
		this.num = num;
		this.photo = photo;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
		this.content = content;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
