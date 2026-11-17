import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;

public record Condition(
        Column column,
        @Nullable Column column2,
        Operator operator,
        @Nullable Param param
) {

    public String toSql() {
        return "%s.%s %s %s".formatted(
                column.table().nom(),
                column.columnName(),
                operator.getOperator(),
                getConditionRight()
        );
    }

    private String getConditionRight() {
        if (column2 != null) {
            return "%s.%s".formatted(column2.table().nom(), column2.columnName());
        } else if (param != null) {
            return param.toSql();
        } else {
            throw new RuntimeException();
        }
    }

    public static Condition of(final Column column,
                               final Column column2,
                               final Operator operator) {
        return new Condition(
                column,
                column2,
                operator,
                null
        );
    }

    public static Condition ofParam(final Column column,
                                    final Operator operator,
                                    final Param param) {
        return new Condition(
                column,
                null,
                operator,
                param
        );
    }

    public static Param param(final String name) {
        return new Param(name);
    }

    public static final class Param {

        private final String name;

        private Param(final String name) {
            this.name = name;
        }

        String toSql() {
            return Strings.CS.prependIfMissing(name, ":");
        }

        public String name() {
            return name;
        }

        public static Param of(final String name) {
            return new Param(StringUtils.removeStart(name, ':'));
        }
    }

}