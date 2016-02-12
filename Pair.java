class Pair extends Element{
	public Element value;
	public MyChar key;
	public Sequence seqVal;
	
	public Element nextPair;
	
	public Pair() {	}
	
	public Pair(MyChar keyArg, Element elm) {
	    (this.value) = elm;
		(this.key) = keyArg;		
	}
	
	public void Print(){
	        System.out.print("(");
			(this.key).Print();
			System.out.print(" ");
			(this.value).Print();
			System.out.print(")");
	}
	
	/*
	public Pair(MyChar keyArg, MyInteger valArg){
		((MyInteger)(this.value)).i = valArg;
		(char)(this.key).i = keyArg;
	}
	
	public Pair(MyChar keyArg, MyChar valArg){
		(this.value).i = valArg;
		(this.key).i = keyArg;		
	}
	
	public Pair(MyChar keyArg, Sequence seqVal){
			
	}
	*/
}