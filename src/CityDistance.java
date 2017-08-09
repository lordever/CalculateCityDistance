public class CityDistance {
    private String firstCity;
    private String secondCity;
    private int distance;

    public CityDistance() {
    }

    public CityDistance(String firstCity, String secondCity, int distance) {
        this.firstCity = firstCity;
        this.secondCity = secondCity;
        this.distance = distance;
    }

    public String getFirstCity() {
        return firstCity;
    }

    public void setFirstCity(String firstCity) {
        this.firstCity = firstCity;
    }

    public String getSecondCity() {
        return secondCity;
    }

    public void setSecondCity(String secondCity) {
        this.secondCity = secondCity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "CityDistance{" +
                ", firstCity='" + firstCity + '\'' +
                ", secondCity='" + secondCity + '\'' +
                ", distance=" + distance +
                '}';
    }
}
