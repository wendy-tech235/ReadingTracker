public class Score {
    private int totalPoints;
    private int earnInDay;
    private boolean requiredMet;
    private boolean extraMet;
    private static int earnRequired = 1;
    private static int earnExtra = 3;

    public Score() {
        this.totalPoints = 0;
        this.earnInDay = 0;
        requiredMet = false;
        extraMet = false;
    }

    public Score(int totalPoints, int earnInDay) {
        this.totalPoints = totalPoints;
        this.earnInDay = earnInDay;
        this.requiredMet = false;
        this.extraMet = false;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getEarnInDay() {
        return earnInDay;
    }

    public void setEarnInDay(int earnInDay) {
        this.earnInDay = earnInDay;
    }

    public boolean getRequiredMet(){
        return requiredMet;
    }

    public void setRequiredMet(boolean requiredMet){
        this.requiredMet = requiredMet;
    }

    public boolean getExtraMet(){
        return extraMet;
    }

    public void setExtraMet(boolean extraMet){
        this.extraMet = extraMet;
    }

    public String toString() {
        return "Score: " + "totalPoints:" + this.totalPoints + ", total earned in a day:" + this.earnInDay;
    }

    //precondition: score object has been initialized
    //postcondition: Increases daily points by 1 and returns the updated daily points
    public int calculatePointsInDay() {
        this.earnInDay += earnRequired;
        return this.earnInDay;
    }
    
    //extraPages is a nonnegative integer.
    //increases daily points by 3 times extraPages and returns the updated daily points
    public int calculateExtraPointsInDay(int extraPages) {
        this.earnInDay += extraPages * earnExtra;
        return this.earnInDay;
    }

    //precondition: score object has been initialized
    //postcondition: resets daily points to 0
    public void resetEarnInDay() {
        this.earnInDay = 0;
    }

    //precondition: score object has been initialized
    //postcondition: Adds daily points to total points and returns the updated total points
    public int addTotalPoints() {
        this.totalPoints += earnInDay;
        return this.totalPoints;
    }

    //precondition: score has to be a nonnegative integer and num has to be a nonnegative integer
    //postcondition: compares the score to num and prints out a message 
    //this is a static method because it does not care about the object but rather the values of score and num and calling it with the class itself without needing an object
    public static void calculateScoreStatus(int score, int num) {
        if (score > num) {
            System.out.println("You have exceeded your reading goal!");
        }else if (score == num) {
            System.out.println("You have met your reading goal!");
        }
    }
}

