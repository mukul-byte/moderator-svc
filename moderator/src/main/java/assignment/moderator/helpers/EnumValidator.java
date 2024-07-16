package assignment.moderator.helpers;

public class EnumValidator {

    public static <E extends Enum<E>> E getEnumValue(String value, Class<E> enumClass) {
        if (value == null) {
            return null;
        }

        for (E enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.name().equals(value)) {
                return enumConstant;
            }
        }

        return null;
    }
}