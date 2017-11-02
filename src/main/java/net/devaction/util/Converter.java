package net.devaction.util;

/**
 * @author Víctor Gil
 */
public class Converter{

    @SuppressWarnings("rawtypes")
    public static String toNiceString(Iterable iterable){
        StringBuilder stringBuilder = new StringBuilder("[\n");
        for (Object object : iterable){
            stringBuilder.append("    ");
            stringBuilder.append(object);
            stringBuilder.append("\n");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
