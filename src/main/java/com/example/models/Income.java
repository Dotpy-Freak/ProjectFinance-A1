package com.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Income {

    private List<IncomeSource> sources = new ArrayList<>();

    public void addSource(String sourceName, double amount, int frequency) {
        if (sourceName == null || sourceName.isEmpty() || amount <= 0 || frequency <= 0) {
            throw new IllegalArgumentException("Invalid income source data.");
        }
        sources.add(new IncomeSource(sourceName, amount, frequency));
    }

    public boolean removeSource(String sourceName) {
        return sources.removeIf(source -> source.getSource().equalsIgnoreCase(sourceName));
    }

    public double getTotalIncome() {
        return sources.stream().mapToDouble(IncomeSource::getAdjustedAmount).sum();
    }

    public List<IncomeSource> getSources() {
        return Collections.unmodifiableList(sources);
    }

    public void clearSources() {
        sources.clear();
    }
}
