class Map extends Element{
	
	Pair head;
	boolean dum = 0;
	
	
	//6.4
	public MapIterator find(MyChar key){
		MapIterator findIt = new MapIterator();
		findIt = this.begin();
		while((findIt.pairIt).key != key){
			if ((findIt.pairIt).nextPair == null || (findIt.pairIt).nextPair instanceof MyDummy)
				return this.end();
			findIt.advance();
		}
		return findIt;
	}
	
	//6.3
	public void add(Pair inval){
		if (this.head == null)
			this.head = inval;
		
		else{
			MapIterator addIt = new MapIterator();
			addIt = this.begin();
			while(inval.key <= ((addIt.pairIt).nextPair).key && !((addIt.pairIt).nextPair instanceof MyDummy)){
				addIt.advance();
			}
			inval.nextPair = addIt.pairIt.nextPair;
			addIt.pairIt.nextPair = inval;	
		}	
	}
	
	//6.2
	public void Print(){
		MapIterator printIt = new MapIterator();
		System.out.print("[ ");
		for (printIt = this.begin(); !printIt.equal(this.end()); printIt.advance()){
			System.out.print("(");
			((printIt.pairIt).key).Print();
			System.out.print(" ");
			((printIt.pairIt).value).Print();	
			System.out.print(") ");			
		}
		System.out.print("]");
	}
	
	MapIterator begin(){
		MapIterator bMapIt = new MapIterator;
		bMapIt.pairIt = this.head; 
		return bMapIt;
	}
	MapIterator end(){
		MapIterator it = new MapIterator();
		
		(Pair)(it.pairIt) = this.head;
		
		if (this.dum == false){
			while ((it.pairIt).nextPair != null){
				it.pairIt = (it.pairIt).nextPair;
			}
			(it.pairIt).nextPair = new MyDummy();
			this.dum = true;
		}
		
		else{
			while(!(((it.pairIt).nextPair) instanceof MyDummy)){
				it.pairIt = (it.pairIt).nextPair;
			}
		}
		it.pairIt = (it.pairIt).nextPair;
		return it;
	}	
}