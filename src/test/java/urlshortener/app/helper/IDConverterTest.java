package urlshortener.app.helper;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IDConverterTest {
    @Test
    public void test_convertBase10ToBase62ID_ConvertsCorrectly() {
        // 1 converts to b
        long base10id = 1;
        IDConverter idConverter = new IDConverter();
        List<Character> listUnderTest = idConverter.convertBase10ToBase62ID(base10id);
        List<Character> expectedList = new ArrayList<>();
        expectedList.add('b');
        Assert.assertThat(listUnderTest,
                IsIterableContainingInOrder.contains(expectedList.toArray()));
        // 61 converts to 9
        base10id = 61;
        listUnderTest = idConverter.convertBase10ToBase62ID(base10id);
        expectedList = new ArrayList<>();
        expectedList.add('9');
        Assert.assertThat(listUnderTest,
                IsIterableContainingInOrder.contains(expectedList.toArray()));
        // 125 converts to [c,b]
        base10id = 125;
        listUnderTest = idConverter.convertBase10ToBase62ID(base10id);
        expectedList = new ArrayList<>();
        expectedList.add('c');
        expectedList.add('b');
        Assert.assertThat(listUnderTest,
                IsIterableContainingInOrder.contains(expectedList.toArray()));

    }

    @Test
    public void test_convertBase62ToBase10ID_ConvertsCorrectly() {
        IDConverter idConverter = new IDConverter();
        // b converts to 1
        List<Character> ids = new ArrayList<>();
        ids.add('b');
        long expectedID = 1;
        long actualID = idConverter.convertBase62ToBase10ID(ids);
        assertEquals(expectedID, actualID);
        // 9 converts to 61
        ids = new ArrayList<>();
        ids.add('9');
        expectedID = 61;
        actualID = idConverter.convertBase62ToBase10ID(ids);
        assertEquals(expectedID, actualID);
        // [c,b] converts to 125
        ids = new ArrayList<>();
        ids.add('c');
        ids.add('b');
        expectedID = 125;
        actualID = idConverter.convertBase62ToBase10ID(ids);
        assertEquals(expectedID, actualID);
    }
}
