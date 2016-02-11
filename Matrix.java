class Matrix extends Sequence {
    public int r,c;
    public Sequence matrixSq = new Sequence();
    Matrix(int rowsize, int colsize) {
        //constructor for creating a matrix with specific dimensions

        r = rowsize;
        c = colsize;
        //System.out.println("in constructor");
        for (int j=0; j<rowsize; j++) {
            //for every row we have, link a new sequence for columns
            Sequence sqOfCol = new Sequence();
            matrixSq.add(new Sequence(), j);
            //System.out.println("Boo");
            
            for(int k=0; k<colsize; k++) {
                //for every sqOfCol we create, add a new Integer to initialize the matrix
                ((Sequence)(matrixSq.index(matrixSq.sqCount()-1))).add(new MyInteger(), 
                ((Sequence)(matrixSq.index(matrixSq.sqCount()-1))).sqCount());
            }
        }
    }
    
    void Set(int rowsize, int colsize, int value) {
        //given a matrix and its dimensions, insert a value at a specific place
        
        //using Set function from MyInteger
        //using Index function from Sequence (bc Matrix is Sequence)
        //(((MyInteger)((this.matrixSq).getLink(rowsize)).n1).index(colsize)).Set(value);
        /*( 
            (MyInteger) 
            (
                (
                    (Sequence) (
                        (Sequence)(this.matrixSq).index(rowsize)
                ).index(colsize)
                )
            )
        )
        .Set(value);*/
        //System.out.println("in Set()");

        ( (MyInteger) ((Sequence)((this.matrixSq).index(rowsize))).index(colsize) 
          ).Set(value);
        
    }
    
    int Get(int rowsize, int colsize) {
        //Link getLink = new Link();
        //int i=0, j=0;
        //for (getLink = this.head; i<rowsize; i++){
          //  getLink = getLink.nextLink;
        //}
        //Sequence intermediateSq = new Sequence();
        //intermediateSq = (Sequence)(getLink.n1);
        
        //for (getLink = intermediateSq.head; j<colsize; j++){
        //    getLink = getLink.nextLink;
        //}
        //System.out.println("in Get()");

        return (( (MyInteger) ((Sequence)((this.matrixSq).index(rowsize))).index(colsize) 
          )).i;
    }
    
    Matrix Sum(Matrix mat) {
        int x = mat.r;
        int y = mat.c;
        
        Matrix sumMatrix = new Matrix(x, y);
        //System.out.println("Made sumMatrix. \n cs: " + cs + "rs: " + rs);
        //System.out.println("in Sum()");

        for (int j = 0; j < x; j++){
            for (int k = 0; k < y; k++){
                //System.out.println("Summed index "+j+", "+ k);
                sumMatrix.Set(j,k,((this.Get(j,k))+(mat.Get(j,k))));
            }
        }
        return sumMatrix;
    }
    
    Matrix Product(Matrix mat) {
        //System.out.println("in Product()");
        boolean validProd = false;
        Matrix prodMatrix = new Matrix(this.r, mat.c);
        
        if (mat.r != this.c) {
            System.out.println("Matrix dimensions incompatible for Product");
            System.exit(1);
        }
        
        else { //if the dimensions match, then multiplication is ok
            validProd = true;
            int collectiveSum = 0;
            
            //algorithm for: C = AB for an n x m matrix A and an m x p matrix B
            //For i from 1 to n:
            for (int i = 0; i < this.r; i++) {
                //For j from 1 to p:
                for (int j = 0; j < mat.c; j++) {
                    //Let Sum=0
                    collectiveSum = 0;
                    //For k from 1 to m:
                    for (int k = 0; k < this.c; k++) {
                        //Set sum <- sum + Aik x Bkj
                        collectiveSum = collectiveSum + (this.Get(i,k) * mat.Get(k,j));
                        //Set Cij <- sum
                        prodMatrix.Set(i, j, collectiveSum);
                    }
                }
            }
        }
        
        /* for (int j = 0; j < x; j++){
            for (int k = 0; k < y; k++){
                prodMatrix.Set(k,j,((this.Get(j,k))*(mat.Get(k,j))));
                //System.out.println("product=" + prodMatrix.Get(j,k));
            }
        } */
        
        return prodMatrix;
    }
    
    void Print() {
        int x = 0;
        int y = 0;
        for (x=0; x < this.r; x++){
            System.out.print("[");
            for (y = 0; y < this.c; y++){
               System.out.print(" "+ this.Get(x,y));
            }
            System.out.print(" ]");
            System.out.print("\n");
        }
    }

}