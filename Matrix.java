class Matrix extends Sequence {
    
    Matrix(int rowsize, int colsize) {
        //constructor for creating a matrix with specific dimensions
        Sequence sqOfCol = new Sequence();
        //need to do for loop for this:
        int r, c;
        
        for (r=0; r<rowsize; r++){
            sqOfCol.add(new Sequence(),sqOfCol.sqCount())
            for(c=0;c<colsize;c++){
                // we're adding a new MyInt at the column that we just created
                (sqOfCol.get(sqOfCol.sqCount()-1)).add(new MyInt, (sqOfCol.get(sqOfCol.sqCount()-1)).(sqCount()-1));
            } 
        }
        
    }
    
    void Set(int rowsize, int colsize, int value) {
        
    }
    
    int Get(int rowsize, int colsize) {
        
    }
    
    Matrix Sum(Matrix mat) {
        
    }
    
    Matrix Product(Matrix mat) {
        
    }
    
    void Print() {
        
    }
    
}