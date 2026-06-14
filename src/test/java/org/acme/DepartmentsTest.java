package org.acme;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DepartmentsTest {

    private Departments departments;

    @BeforeEach
    void setUp() {
        departments = new Departments();
    }

    @Test
    void testGetSecondRichestDepartmentWithProvidedData() {
        Map<String, List<Integer>> transactions = Map.of(
                "HR", List.of(5000, 2000, -1500),
                "Engineering", List.of(12000, -3000, 4000),
                "Marketing", List.of(8000, 2000, -1000),
                "Sales", List.of(15000, 5000, -2000, 3000)
        );

        Map<String, Integer> result = departments.getSecondRichestDepartment(transactions);

        // Sales: 21000, Engineering: 13000, Marketing: 9000, HR: 5500
        assertThat(result).hasSize(1);
        assertThat(result).containsKey("Engineering");
        assertThat(result.get("Engineering")).isEqualTo(13000);
    }

    @Test
    void testGetSecondRichestDepartmentWithNegativeBalance() {
        Map<String, List<Integer>> transactions = Map.of(
                "HR", List.of(1000, 550),
                "Engineering", List.of(2000, 3000),
                "Marketing", List.of(-1000, -500),
                "Sales", List.of(1500)
        );

        Map<String, Integer> result = departments.getSecondRichestDepartment(transactions);

        // Engineering: 5000, HR: 1550, Sales: 1500, Marketing: -1500
        assertThat(result).hasSize(1);
        assertThat(result).containsKey("HR");
        assertThat(result.get("HR")).isEqualTo(1550);
    }

    @Test
    void testGetSecondRichestDepartmentWithTwoDepartments() {
        Map<String, List<Integer>> transactions = Map.of(
                "Sales", List.of(1000),
                "Engineering", List.of(500)
        );

        Map<String, Integer> result = departments.getSecondRichestDepartment(transactions);

        assertThat(result).hasSize(1);
        assertThat(result).containsEntry("Engineering", 500);
    }

    @Test
    void testGetSecondRichestDepartmentWithEmptyTransactions() {
        Map<String, List<Integer>> transactions = Map.of(
                "HR", List.of(),
                "Engineering", List.of(),
                "Marketing", List.of()
        );

        assertThrows(IllegalArgumentException.class,
                () -> departments.getSecondRichestDepartment(transactions));
    }

    @Test
    void testGetSecondRichestDepartmentWithSingleDepartment() {
        Map<String, List<Integer>> transactions = Map.of(
                "Sales", List.of(1000, 2000)
        );

        Map<String, Integer> result = departments.getSecondRichestDepartment(transactions);

        assertThat(result)
            .hasSize(1)
            .containsKey("Sales");
    }

    @Test
    @Disabled
    void testGetSecondRichestDepartmentWithTieInSecondPlace() {
        Map<String, List<Integer>> transactions = Map.of(
                "Sales", List.of(15000, 5000),      // Sales: 20000 (richest)
                "Engineering", List.of(8000, 2000), // Engineering: 10000 (second)
                "HR", List.of(5000, 5000),          // HR: 10000 (second, tied)
                "Marketing", List.of(3000, 1000)    // Marketing: 4000
        );

        Map<String, Integer> result = departments.getSecondRichestDepartment(transactions);

        assertThat(result).hasSize(1);
        assertThat(result).containsEntry("Engineering", 10000);
    }
}