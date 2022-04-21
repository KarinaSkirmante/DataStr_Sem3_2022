package dataStr;

public class MyHeapNode<Type> {
	private Type elementValue;
	private MyHeapNode leftCh = null;
	private MyHeapNode rightCh = null;
	private MyHeapNode parent = null;
	public Type getElementValue() {
		return elementValue;
	}
	public void setElementValue(Type elementValue) {
		if(elementValue!=null)
			this.elementValue = elementValue;
		else
			this.elementValue  =(Type) new Object();
	}
	public MyHeapNode getLeftCh() {
		return leftCh;
	}
	public void setLeftCh(MyHeapNode leftCh) {
		this.leftCh = leftCh;
	}
	public MyHeapNode getRightCh() {
		return rightCh;
	}
	public void setRightCh(MyHeapNode rightCh) {
		this.rightCh = rightCh;
	}
	public MyHeapNode getParent() {
		return parent;
	}
	public void setParent(MyHeapNode parent) {
		this.parent = parent;
	}
	
	public MyHeapNode(Type elementValue)
	{
		setElementValue(elementValue);
	}
	public MyHeapNode(Type elementValue, MyHeapNode parent)
	{
		setElementValue(elementValue);
		setParent(parent);
	}
	@Override
	public String toString() {
		return ""+elementValue;
	}
	
	

}
