class MyChar extends Element {
	public MyChar(){
		c = '0';
	}
	public MyChar(char value){
		c = value;
	}
	
	
	public char Get(){
		return this.c;
	}
	public void Set(char val){
		this.c = val;
	}
	public void Print(){
		System.out.print("'" + this.c + "'");
	}
}