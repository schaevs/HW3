class MapIterator {
	public Element pairIt;
	
	public boolean equal(MapIterator other) {
		if (this.pairIt == other.pairIt)
			return true;
		return false;
	}
	
	MapIterator advance() {
		this.pairIt = (this.getNextE());
		return this;
	}
	
	// the test case wants this to be a Pair instead of an Element function
	Pair get() {
		return (Pair)(this.pairIt);
	}
	
	Pair getNext(){
	    return (Pair)((this.getNextE()));
	    
	}
	Element getNextE(){
	    Pair tempPair = this.get();
	    
	    return (Element)(tempPair.nextPair);
	}
		
	
	
}