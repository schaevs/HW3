class MapIterator{
	Element pairIt = new Element();
	
	public boolean equal(Pair other){
		if (this.pairIt == other.pairIt)
			return true;
		return false;
	}
	
	MapIterator advance(){
		this.pairIt = (this.pairIt).nextPair;
		return this;
	}
	
	Element get(){
		return pairIt;
	}
	
		
	
	
}