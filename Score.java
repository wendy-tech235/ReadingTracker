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

    public int calculatePointsInDay() {
        this.earnInDay += earnRequired;
        return this.earnInDay;
    }

    public int calculateExtraPointsInDay(int extraPages) {
        this.earnInDay += extraPages * earnExtra;
        return this.earnInDay;
    }

    public void resetEarnInDay() {
        this.earnInDay = 0;
    }

    public int addTotalPoints() {
        this.totalPoints += earnInDay;
        return this.totalPoints;
    }
}

