package javascript;

public class Utils {

    /**
     * This method unifies the instructions lcmp, fcmp<op> and dcmp<op> with
     * op = (g|l).
     * It compares two numerical values. The value gORl must be 1 for (g)
     * or -1 for (l), otherwise 0.
     * If either value1 or value2 is NaN, then lg is returned.
     */
    public static int cmp(double value1, double value2, int gORl) {
        if (gORl != 0 && (Double.isNaN(value1) || Double.isNaN(value2))) return gORl;
        ScriptHelper.put("value1", value1);
        ScriptHelper.put("value2", value2);
        return ScriptHelper.evalInt("j2js.cmp(value1, value2)");
    }
    
}
