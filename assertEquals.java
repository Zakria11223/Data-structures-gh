package project8;

/** Part of an Unit test class for CSC311 . */
public class assertEquals {
    // These are written inplace of the assertEquals method in JUnit
    public static <T> boolean assertEquals(T s1, T s2) {
        if (s1.equals(s2)) {
            System.out.println("Ok");
            return true;
        }
        System.out.println("not okay");
        return false;
    }
}
