import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cityNum = 0;
        int roadNum = 0;
        int startCity = 0;
        int endCity = 0;
        cityNum = in.nextInt();
        roadNum = in.nextInt();
        startCity = in.nextInt();
        endCity = in.nextInt();
        int[] cityTeams = new int[cityNum];
        for (int i = 0; i < cityNum; i++) {
            cityTeams[i] = in.nextInt();
        }
        int[] citySumTeams = new int[cityNum];
        citySumTeams[startCity] = cityTeams[startCity];
        int[] citySumLenth = new int[cityNum];
        citySumLenth[startCity] = 0;
        int[] samePathNum = new int[cityNum];
        samePathNum[startCity] = 1;
        Map<Integer, Map<Integer, Integer>> roadToRoadMap = new HashMap<>();
        for (int i = 0; i < roadNum; i++) {
            int cityA = in.nextInt();
            int cityB = in.nextInt();
            int lenthAtoB = in.nextInt();
            if (roadToRoadMap.get(cityA) == null) {
                Map<Integer, Integer> roadToLenthMap = new HashMap<>();
                roadToLenthMap.put(cityB, lenthAtoB);
                roadToRoadMap.put(cityA, roadToLenthMap);
            } else {
                roadToRoadMap.get(cityA).put(cityB, lenthAtoB);
            }
            if (roadToRoadMap.get(cityB) == null) {
                Map<Integer, Integer> roadToLenthMap2 = new HashMap<>();
                roadToLenthMap2.put(cityA, lenthAtoB);
                roadToRoadMap.put(cityB, roadToLenthMap2);
            } else {
                roadToRoadMap.get(cityB).put(cityA, lenthAtoB);
            }
        }
        Set<Integer> hasArrayCitySet = new HashSet<>();
        hasArrayCitySet.add(startCity);
        if (roadToRoadMap.get(startCity) != null) {
            Map<Integer, Integer> roadToLenthMap = roadToRoadMap.get(startCity);
            for (Map.Entry<Integer, Integer> entry: roadToLenthMap.entrySet()) {
                citySumLenth[entry.getKey()] = entry.getValue() + citySumLenth[startCity];
                citySumTeams[entry.getKey()] = cityTeams[entry.getKey()] + citySumTeams[startCity];
            }
        }
        while (true) {
            int minLenth = 0;
            int seed = 0;
            for (int i = 0 ; i < citySumLenth.length; i++) {
                if (hasArrayCitySet.contains(i)) {
                    continue;
                }
                if (minLenth == 0 || citySumLenth[i] != 0 && citySumLenth[i] < minLenth) {
                    minLenth = citySumLenth[i];
                    seed = i;
                }
            }
            for (Integer before:hasArrayCitySet) {
                if (roadToRoadMap.get(before) != null && roadToRoadMap.get(before).get(seed) != null &&
                        roadToRoadMap.get(before).get(seed) == citySumLenth[seed] - citySumLenth[before]) {
                    samePathNum[seed] += samePathNum[before];
                }
            }
            hasArrayCitySet.add(seed);
            if (seed == endCity) {
                break;
            }
            if (roadToRoadMap.get(seed) != null) {
                Map<Integer, Integer> roadToLenthMap = roadToRoadMap.get(seed);
                for (Map.Entry<Integer, Integer> entry: roadToLenthMap.entrySet()) {
                    if (entry.getKey() == startCity) {
                        continue;
                    }
                    if (citySumLenth[entry.getKey()] == 0) {
                        citySumLenth[entry.getKey()] = entry.getValue() + citySumLenth[seed];
                        citySumTeams[entry.getKey()] = cityTeams[entry.getKey()] + citySumTeams[seed];
                    } else if (entry.getValue() + citySumLenth[seed] < citySumLenth[entry.getKey()]) {
                        citySumLenth[entry.getKey()] = entry.getValue() + citySumLenth[seed];
                        citySumTeams[entry.getKey()] = cityTeams[entry.getKey()] + citySumTeams[seed];
                    } else if (entry.getValue() + citySumLenth[seed] == citySumLenth[entry.getKey()]
                            && cityTeams[entry.getKey()] + citySumTeams[seed] > citySumTeams[entry.getKey()]) {
                        citySumTeams[entry.getKey()] = cityTeams[entry.getKey()] + citySumTeams[seed];
                    }
                }
            }
        }
        //第一个输出的为不同的路径数，不是最短路径长度！
        System.out.println(samePathNum[endCity] + " " + citySumTeams[endCity]);
    }
}