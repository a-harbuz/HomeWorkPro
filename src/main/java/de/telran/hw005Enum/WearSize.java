package de.telran.hw005Enum;

public enum WearSize {
    XS, S, M, L, XL;

    public static boolean isSize(String size) {
        for (WearSize elem : WearSize.values()) {
            if (elem.toString().equals(size)) return true;

        }
        return false;
    }

}
