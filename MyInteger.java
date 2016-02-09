class MyInteger extends Element {
	public MyInteger(){
		i = 0;
	}
	public MyInteger(int value){
		i = value;
	}
	public int Get(){
		return this.i;
	}
	public void Set(int val){
		this.i = val;
	}			
	public void Print(){
		System.out.print(" " + this.i + " ");
	}
}
