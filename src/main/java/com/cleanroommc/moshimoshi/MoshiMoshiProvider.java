package com.cleanroommc.moshimoshi;

class MoshiMoshiProvider extends SecurityManager implements MoshiMoshi {

    static final MoshiMoshiProvider INSTANCE = new MoshiMoshiProvider();

    @Override
    public Class<?> getCaller() {
        return getClassContext()[1 + 1];
    }

    @Override
    public Class<?> getCallingClass(int depth) {
        return getClassContext()[1 + depth];
    }

    @Override
    public boolean isCalledBy(Class<?> clazz) {
        Class<?>[] classes = getClassContext();
        for (int i = 1 + 1; i < classes.length; i++) {
            if (classes[i] == clazz) {
                return true;
            }
        }
        return false;
    }

}
