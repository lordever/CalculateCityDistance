import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<CityDistance> cities = getCities();
        calcDistance("Toliatty", "Moscow", cities);
    }

    private static int calcDistance(String firstCity, String secondCity, List<CityDistance> cities) {
        if (isValidList(cities, firstCity) && isValidList(cities, secondCity)) {
            String citiesName[] = {"Toliatty", "Samara", "Demitrovgrad", "Ulianovsk", "Riazan", "Moscow"};//выбрать в бд
            int sizeList = citiesName.length;
            int min = 0;
            int index = findIndex(cities, firstCity);
            int distance = 0;
            String lastName = null;
            for (CityDistance city : cities) {
                if(Objects.equals(city.getFirstCity(), firstCity)){
                    lastName = city.getSecondCity();
                    if (min < city.getDistance()) {
                        min = city.getDistance();
                    }
                }
                else{
                    firstCity = city.getFirstCity();
                    lastName = city.getSecondCity();
                }
            }
        }
        else{
            System.out.println("Error");
        }

        return 1;

    }

    private static boolean isValidList(List<CityDistance> cities, String city) {
        boolean isValid = false;
        for (CityDistance cityDistance : cities) {
            if (Objects.equals(cityDistance.getFirstCity(), city)
                    || Objects.equals(cityDistance.getSecondCity(), city)) {
                isValid = true;
            }
        }
        return isValid;
    }

    private static int findIndex(List<CityDistance> cities, String city){
        int index = 0;
        for(int i=0; i < cities.size(); i++){
           if(Objects.equals(cities.get(i).getFirstCity(), city)){
                index = i;
                break;
           }
        }
        return index;
    }

    private static List<CityDistance> getCities() {
        List<CityDistance> cities = new ArrayList<>();

        CityDistance tolSam = new CityDistance("Toliatty", "Samara", 1);
        CityDistance tolDem = new CityDistance("Toliatty", "Demitrovgrad", 2);
        CityDistance tolUl = new CityDistance("Toliatty", "Ulianovsk", 3);
        CityDistance samRiazan = new CityDistance("Samara", "Riazan", 6);
        CityDistance samUl = new CityDistance("Samara", "Ulianovsk", 2);
        CityDistance demUl = new CityDistance("Demitrovgrad", "Ulianovsk", 3);
        CityDistance demRiazan = new CityDistance("Demitrovgrad", "Riazan", 4);
        CityDistance demMoscow = new CityDistance("Demitrovgrad", "Moscow", 6);
        CityDistance ulMoscow = new CityDistance("Ulianovsk", "Moscow", 5);
        CityDistance riazanMoscow = new CityDistance("Riazan", "Moscow", 2);
        CityDistance riazanUl = new CityDistance("Riazan", "Ulianovsk", 3);

        cities.add(tolSam);
        cities.add(tolDem);
        cities.add(tolUl);
        cities.add(samRiazan);
        cities.add(samUl);
        cities.add(demUl);
        cities.add(demRiazan);
        cities.add(demMoscow);
        cities.add(ulMoscow);
        cities.add(riazanMoscow);
        cities.add(riazanUl);

        return cities;
    }
}
