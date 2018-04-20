package com.cesarbassani.myapplication.mock;

import java.util.ArrayList;
import java.util.List;

public class Mock {

    public static List<String> getWeightMock() {
        List<String> lst = new ArrayList<>();
        lst.add("Grama");
        lst.add("Kg");
        lst.add("Arroba");
        lst.add("Tonelada");

        return lst;
    }
}
