import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        final String START_CITY = "Toliatty";
        final String END_CITY = "Moscow";

        List<CityDistance> cities = getCities();

        int distance = calcDistance("Toliatty", "Moscow", cities);


    }

    private static int calcDistance(String startCity, String endCity, List<CityDistance> cities) {
        int min;
        String[] citiesAll = {"Toliatty", "Samara", "Demitrovgrad", "Ulianovsk", "Riazan", "Moscow"};
        List<CityDistance> result = new ArrayList<>();
        CityDistance minCityDistance = new CityDistance();
        int index = 0;
        int distance = 0;
        String minCity = citiesAll[0];
        for (String city : citiesAll) {
            min = 0;
            boolean isEnd = false;
            for (; index < cities.size(); index++) {
                if (cities.get(index).getFirstCity() != city) {
                    break;
                }
                if (min == 0 && cities.get(index).getFirstCity() == city) {
                    min = cities.get(index).getDistance();
                    minCityDistance.setFirstCity(cities.get(index).getFirstCity());
                    minCityDistance.setSecondCity(cities.get(index).getSecondCity());
                    minCityDistance.setDistance(cities.get(index).getDistance());
                } else if (cities.get(index).getFirstCity() == city) {
                    if (cities.get(index).getDistance() < min) {
                        min = cities.get(index).getDistance();
                        minCity = cities.get(index).getSecondCity();
                    }
                }
                if (cities.get(index).getSecondCity() == endCity) {
                    min = cities.get(index).getDistance();
                    isEnd = true;
                    break;
                }
            }
            if(minCity != cities.get(index + 1).getFirstCity()){
                city = minCity;
            }
            if (isEnd) {
                distance += min;
                System.out.println(city + ": " + distance);
            } else {
                distance += min;
                if(minCity != cities.get(index + 1).getFirstCity()){
                    while(minCity != cities.get(index + 1).getFirstCity()){
                        index++;
                    }
                }
            }
        }

        return 1;
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
