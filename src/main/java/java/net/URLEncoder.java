package java.net;

import javascript.ScriptHelper;

/**
 * Utility class for HTML form encoding.
 * 
 * @author Wolfgang Kuehn
 */
public class URLEncoder {

    /**
     * Translates a string into application/x-www-form-urlencoded format using a specific encoding scheme.
     * @param enc must be 'UTF-8'
     */
    public static String encode(String s, String enc) { // TODO: throws UnsupportedEncodingException
        //s = s.replaceAll(" ", "+");
        ScriptHelper.put("s", s); 
        s = (String) ScriptHelper.eval("encodeURIComponent(s)");
        return s;
    }

}
