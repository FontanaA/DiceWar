public class Die {
    //instance variables
    public int sideNumber;
    public int randNum;

    public Die(int sideNumber) {
        this.sideNumber = sideNumber;
    }
    //returnNum(); generates a random number between 0 and sideNumber
    public int returnNum() {
        randNum = (int) (Math.random() * sideNumber + 1);
        return(randNum);
    }
}

class LoadedDie extends Die {
    public LoadedDie(int sideNumber) {
        super(sideNumber);
    }
    //loadedDie overrides returnNum()
    public int returnNum() {
        if((Math.random() * 6 + 1) >= (sideNumber/2)){
            randNum = (int) (Math.random() * sideNumber + 1);
            if(randNum <= sideNumber/2) {
                randNum += 2;
            }
        } else{
            randNum = (int) (Math.random() * sideNumber + 1);
        }
        return(randNum);
    }
}