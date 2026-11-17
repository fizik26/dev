public record Order(
        Column column,
        OrderType orderType
) {

    public static Order of(final Column column, final OrderType orderType) {
        return new Order(column, orderType);
    }

    public String toSql() {
        return "%s %s".formatted(column.toSql(), orderType.name());
    }
}