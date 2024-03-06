package luis122448.utils;

//import static org.junit.jupiter.api.Assertions.*;
class StringUtilTest {

    //psvm
    public static void main(String[] args) {
        String result = StringUtil.repeat("hola", 2);

        assertEquals("holaholahola", result);
        // sout
//        System.out.println(result);
//        if(!result.equals("holaholahola")) {
//            throw new RuntimeException("Test failed");
//        }
    }

    private static void assertEquals(String actual, String specter) {
        if (!actual.equals(specter)) {
            throw new RuntimeException(actual + " is not equal to " + specter);
        }
    }

}