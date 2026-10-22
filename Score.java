public class Score {
    private int totalPoints;
    private int earnInDay;
    private boolean requiredMet;
    private boolean extraMet;
    private static int earnRequired = 1;
    private static int earnExtra = 3;

    public Score() {
        totalPoints = 0;
        earnInDay = 0;
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

    public String toString() {
        return "Score: " + "totalPoints:" + totalPoints + ", total earned in a day:" + earnInDay;
    }

    public int calculatePointsInDay() {
        if (extraMet) {
            earnInDay += earnExtra;
        } else if (requiredMet) {
            earnInDay += earnRequired;
        }
        return earnInDay;
    }

    public void resetEarnInDay() {
        earnInDay = 0;
    }

    public int addTotalPoints() {
        totalPoints += earnInDay;
        return totalPoints;
    }
}
