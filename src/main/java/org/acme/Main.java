package org.acme;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Integer>> transactions = Map.of(
                "HR", List.of(5000, 2000, -1500),
                "Engineering", List.of(12000, -3000, 4000),
                "Marketing", List.of(8000, 2000, -1000),
                "Sales", List.of(15000, 5000, -2000, 3000)
        );

        System.out.println(getSecondRichestDepartment(transactions));
    }

    private static Map<String, Integer> getSecondRichestDepartment(Map<String, List<Integer>> transactions) {
        //TODO return department name and its total balance
        return Map.of();
    }
}