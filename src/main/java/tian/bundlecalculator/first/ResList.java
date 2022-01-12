package tian.bundlecalculator.first;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ResList {
    private List<String> allCategories = new ArrayList<>();
    private List<Integer> allNumbers = new ArrayList<>();
    private List<Map<Integer, Integer>> bundleListResult = new ArrayList<>();

    public void addCategoryItem(String order) {
        allCategories.add(order);
    }

    public void addNumberItem(Integer order) {
        allNumbers.add(order);
    }

    public void addBundleListItem(Map<Integer, Integer> order) {
        bundleListResult.add(order);
    }
}
