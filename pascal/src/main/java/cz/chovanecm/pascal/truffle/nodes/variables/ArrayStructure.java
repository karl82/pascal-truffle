package cz.chovanecm.pascal.truffle.nodes.variables;

/**
 * Created by chovamar on 2/6/17.
 */
public class ArrayStructure {
    private final int lowerBound;
    private final int upperBound;
    private final Class<?> clazz;
    private Object array;

    public ArrayStructure(int lowerBound, int upperBound, Class<?> clazz) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        int length = upperBound + 1 - lowerBound;
        this.clazz = clazz;
        if (clazz == long.class) {
            array = new long[length];
        } else if (clazz == boolean.class) {
            array = new boolean[length];
        } else if (clazz == double.class) {
            array = new double[length];
        } else if (clazz == String.class) {
            array = new String[length];
        } else {
            array = new Object[length];
        }
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void writeLong(int index, long value) {
        ((long[]) (this.array))[index - lowerBound] = value;
    }

    public void writeString(int index, String value) {
        ((String[]) (this.array))[index - lowerBound] = value;
    }

    public void writeDouble(int index, double value) {
        ((double[]) (this.array))[index - lowerBound] = value;
    }

    public void writeBoolean(int index, boolean value) {
        ((boolean[]) (this.array))[index - lowerBound] = value;
    }


    public Object read(int index) {
        //TODO: conditionprofile ?
        if (clazz == long.class) {
            return ((long[]) (this.array))[index - lowerBound];
        } else if (clazz == boolean.class) {
            return ((boolean[]) (this.array))[index - lowerBound];
        } else if (clazz == double.class) {
            return ((double[]) (this.array))[index - lowerBound];
        } else {
            return ((String[]) (this.array))[index - lowerBound];
        }
    }

    public Object getArray() {
        return array;
    }
}
