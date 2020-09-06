package it.maranzana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaFlatArrayVersion {

    private static Object[] flattenAlgo(Object obj){
        List<Object> returnflatten = new ArrayList<>();
        if(obj instanceof Object[])
            for(Object o : (Object[])obj)
                returnflatten.addAll(
                        Arrays.asList(flattenAlgo(o))
                );
        else
            returnflatten.add(obj);
        return returnflatten.toArray();
    }

    private static Stream<Object> flattenStream(Object[] obj){
        return Arrays.stream(obj)
                .flatMap(o ->
                        o instanceof Object[] ?
                                flattenStream((Object[]) o) :
                                Stream.of(o));
    }

    public static void test() {

        System.out.println("JAVA: flatten an array of arbitrarily nested arrays of integers into a flat array of integers. e.g. [[1,2,[3]],4] -> [1,2,3,4].");

        Object[] a = {3};
        Object[] b = {1,2, a};
        Object[] c = {b, 4};

        System.out.println("flatten using Algo: " + Arrays.asList(flattenAlgo(c)));

        System.out.println("flatten using Stream: " + Arrays.asList(flattenStream(c).toArray()));

    }

}
