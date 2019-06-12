package com.yeahmama.tennis.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListUtils {

    public static String[] toArrayString(ArrayList<String> arrayList) {
        return Arrays.copyOf(arrayList.toArray(), arrayList.toArray().length, String[].class);
    }

}
