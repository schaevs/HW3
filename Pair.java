class Pair extends Element{
	public MyChar value;
	public MyChar key;
	
	public Element nextPair;
	public Pair(){	}
	
	
	public Pair(char keyArg, int valArg){
		((MyInteger)(this.value)).i = valArg;
		(char)(this.key).i = keyArg;
	}
	public Pair(char keyArg, char valArg){
		(this.value).i = valArg;
		(this.key).i = keyArg;		
	}
	
}