public final class UrlUtility {

    private UrlUtility() {
    }

    /**
     *
     * @param string The string to be made safe
     * @return  The same string but without any spaces / special characters
     */
    public static String urlMaker(String string) {
        return string.toLowerCase().replaceAll("[^A-Za-z]+", "");
    }

}
