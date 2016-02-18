package java.net;

/**
 * Class URL represents a Uniform Resource Locator, a pointer to a "resource" on the World Wide Web.
 */
public class URL {

    private String representation;
    
    /**
     * Creates a URL object from the String representation.
     */
    public URL(String spec) {
        if (!spec.matches("[a-z]+://.*")) {
            // TODO: Should throw a MalformedURLException.
            throw new RuntimeException("Protocol part is missing: " + spec);
        }
        representation = spec;
    }
    
    /**
     * Creates a URL by parsing the given spec within a specified context.
     */
    public URL(URL context, String spec) {
        if (spec.matches("[a-z]+://.*")) {
            // The spec is already absolute.
            representation = spec;
        } else {
            String base = context.toString();
            
            // Context URL is of the form <scheme>://<authority><path>?<query>#<fragment>
            // Strip into scheme, authority&path, query and fragment.
            String[] parts = base.split("://|\\?|#");
            String authorityAndPath = parts[1];
            // Strip last path component.
            int index = authorityAndPath.lastIndexOf('/');
            if (index != -1) {
                authorityAndPath = authorityAndPath.substring(0, index);
            }
            representation = parts[0] + "://" + authorityAndPath + '/' + spec;
        }
    }
    
    /**
     * Constructs a string representation of this URL.
     */
    public String toString() {
        return representation;
    }
    
}
