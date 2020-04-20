package model;

public class Post {
	private String text;
	private int id;
	private Tags tag;
	public Post(String text, int id, Tags tag) {
		this.text = text;
		this.id = id;
		this.tag = tag;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Tags getTag() {
		return tag;
	}
	public void setTag(Tags tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return id + " " + tag + " " + text;
	}
}
