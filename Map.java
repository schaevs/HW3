class Map extends Element{
	
	Pair head;
	public int position = 0;
	
	//6.4
	public MapIterator find(MyChar key){
		MapIterator findIt = new MapIterator();
		findIt = this.begin();
		/*
		while((findIt.pairIt).key != key){
			if ((findIt.pairIt).nextPair == null || (findIt.pairIt).nextPair instanceof MyDummy)
				return this.end();
			findIt.advance();
		}
		*/
		// took this forloop from the test file bc obviously it works lol
		MapIterator it1 = this.begin();
		while (!it1.equal(this.end())) {
			if((it1.get().key).Get() == key.Get()) {
				return it1;
			}
			it1.advance();
		}
		return this.end();
	}
	
	//6.3
	public void add(Pair inval){
		if ((this.head) == null){
			inval.nextPair = new MyDummy();
			this.head = inval;
		}
	
		else if ( (inval.key).c < (((Pair)(this.head)).key).c ){
		    inval.nextPair = this.head;
		    this.head = inval;
		}
		else{
			MapIterator addIt = new MapIterator();
			//addIt = this.begin();
			/*
			while ( (!((addIt.pairIt).nextPair instanceof MyDummy))
			    && inval.key <= ((Pair)((addIt.pairIt).nextPair)).key) {
				addIt.advance();
			}
			inval.nextPair = addIt.pairIt.nextPair;
			addIt.pairIt.nextPair = inval;	
			*/
			//Pair placeHolder;
			//finding the right place
			//while (addIt.get())
			for (addIt = this.begin(); !(addIt.getNextE() instanceof MyDummy) ; addIt.advance() ){
		        if ( ((addIt.getNext()).key).c > (inval.key).c )
		            break;
		    }
		    inval.nextPair = (addIt.get()).nextPair;
		    (addIt.get()).nextPair = inval;
		    
			
			/*while (!addIt.equal(this.end())) {
			    //placeHolder = addIt.get();
			    if ( ((addIt.get()).nextPair != null) && !((addIt.get()).nextPair instanceof MyDummy)) {
			        if( (inval.key).Get() <= (  ((Pair)((addIt.get()).nextPair)).key ).Get() )
			            addIt.advance();
			    }
			    else {
			        break;
			    }
		    }
		    inval.nextPair = (addIt.get()).nextPair;
		    (addIt.get()).nextPair = inval;*/
		}	
	}
	
	public int length(){
	    int len = 0;
	    MapIterator it1 = this.begin();
		while (!it1.equal(this.end())) {
			len++;
			it1.advance();
		}
		return len;
	}
	
	//6.2
	public void Print(){
		MapIterator printIt = new MapIterator();
		System.out.print("[ ");
		for (printIt = this.begin(); !printIt.equal(this.end()); printIt.advance()){
                
                ((Pair)(printIt.pairIt)).Print();
                System.out.print(" ");
		}
		System.out.print("]");
	}
	
	MapIterator begin(){
		MapIterator bMapIt = new MapIterator();
		bMapIt.pairIt = this.head; 
		return bMapIt;
	}
	MapIterator end(){
		MapIterator it = new MapIterator();
		for (it = this.begin(); 
		    !(it.getNextE() instanceof MyDummy);
		    it.advance() 
		){
		    
		}
		it.pairIt = it.getNextE();
		
		/*if (this.dum == false){
			while ((it.get()).nextPair != null){
				it.pairIt = (it.getNext());
			}
			((Pair)(it.pairIt)).nextPair = new MyDummy();
			this.dum = true;
		}
		
		else{
			while(!((it.getNextE()) instanceof MyDummy)){
				it.pairIt = it.getNextE();
			}
		}*/
		
		return it;
	}	
}