package javax.script;

/**
 * This class provides basic scripting functionality.
 *    
 * @author Wolfgang Kuehn
 */
public interface ScriptEngine {
    
    /**
     * Executes the specified script.
     * <b>Important</b>: In the current version the script must be a string literal.
     */
    public Object eval(String script);
    
    /**
     * Sets a key/value pair in the state of the ScriptEngine.
     * <b>Important</b>: In the current version the key must be a string literal.
     */
    public void put(String key, Object value);
}
