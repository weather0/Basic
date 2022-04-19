package Pac0419.collection.generic;

public class Box<T> {
	T field; // 클래스의 부모클래스. Object: 숫자,string 다 됨

	public void setField(T field) {
		this.field = field;
	}
	
	public T getField() {
		return field;
	}

	
//	public void setField(Object field) {
//		
//	}

}
