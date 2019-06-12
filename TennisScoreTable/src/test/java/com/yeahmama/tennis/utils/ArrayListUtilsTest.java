package com.yeahmama.tennis.utils;

import org.junit.Test;

import java.util.ArrayList;

import static com.yeahmama.tennis.utils.ArrayListUtils.toArrayString;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrayListUtilsTest {

    @Test
    public void should_convert_array_list_to_array_string() {
        // Arrange
        ArrayList<String> arrayListString = new ArrayList<>();
        arrayListString.add("Something");

        // Act
        String[] arrayString = toArrayString(arrayListString);

        // Assert
        assertThat(arrayListString.get(0)).isEqualTo(arrayString[0]);
    }

}
