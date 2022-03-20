package com.cleanroommc.moshimoshi;

public interface MoshiMoshi {

    static MoshiMoshi seek() {
        return MoshiMoshiProvider.INSTANCE;
    }

    /**
     * @return the Class of the Caller. Equivalent to {@link MoshiMoshi#getCallingClass(int 1)}
     */
    Class<?> getCaller();

    /**
     * @param depth 0 = callee's class, 1 = caller's class, etc.
     * @return the Class of the method which is (depth) levels above the current method.
     */
    Class<?> getCallingClass(int depth);

    /**
     * @param clazz Class to search for in callers
     * @return true if the given class is one of the calling classes
     */
    boolean isCalledBy(Class<?> clazz);

}
