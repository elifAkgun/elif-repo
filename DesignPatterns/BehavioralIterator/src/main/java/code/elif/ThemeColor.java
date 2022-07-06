package code.elif;

public enum ThemeColor {
    RED,
    WHITE,
    PINK,
    ORANGE,
    GREEN,
    BLUE;


    public static Iterator<ThemeColor> getIteration() {
        return new ThemeColorIterator();
    }

    private static class ThemeColorIterator implements Iterator<ThemeColor> {

        int position;

        public boolean hasNext() {
            return position < ThemeColor.values().length;
        }

        public ThemeColor next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("There is not any next element!");
            }
            return ThemeColor.values()[position++];
        }
    }
}

