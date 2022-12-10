package sussytech.api;

public final class Constants {

    private Constants() {/**/}

    /**
     * <p>
     * This is worth exactly one normal Item.
     * This Constant can be divided by many commonly used numbers such as
     * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 24, ... 64 or 81 without losing precision.
     * It is also small enough to be multiplied with larger Numbers.
     * <p/>
     * This is used to determine the amount of Material contained inside an item.
     * For example a nugget = M / 9 as it contains 1/9 of an ingot.
     */
    public static final long M = 3628800;
}
