package hackFAF.homeworks;

import java.util.Collection;
public class CollsUtilsTH {
    private CollsUtilsTH() {
    }
    public static boolean containsBoth(final Collection<?> coll1, final Collection<?> coll2) {
        if(coll1 == null || coll2 == null){
            throw new NullPointerException("Null collection exception");
        }
        if (coll1.size() < coll2.size()) {
            for (final Object aColl1 : coll1) {
                if (coll2.contains(aColl1)) {
                    return true;
                }
            }
        } else {
            for (final Object aColl2 : coll2) {
                if (coll1.contains(aColl2)) {
                    return true;
                }
            }
        }
        return false;
    }
}