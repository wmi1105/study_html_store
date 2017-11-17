package org.ellen.domain;

public class ItemVO {

	private int ino;
	private String iname;
	private String item;
	private int price;
	private String img;
	private String img_info;

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImg_info() {
		return img_info;
	}

	public void setImg_info(String img_info) {
		this.img_info = img_info;
	}

	@Override
	public String toString() {
		return "ItemVO [ino=" + ino + ", iname=" + iname + ", item=" + item + ", price=" + price + ", img=" + img
				+ ", img_info=" + img_info + "]";
	}

}
