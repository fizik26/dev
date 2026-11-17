public record Column(
        Table table,
        String columnName
) {

    public String toSql() {
        return "%s.%s".formatted(table.nom(), columnName);
    }

    public static Column of(final Table table, final String columnName) {
        return new Column(table, columnName);
    }

}