public record JoinTable(
        Table table,
        List<Condition> conditions
) {

    public String toSql() {
        return " JOIN %s on %s".formatted(
                table.toSql(),
                conditions.stream()
                        .map(Condition::toSql)
                        .collect(Collectors.joining(" AND "))
        );
    }

    public static JoinTable of(
            final Table table,
            final Condition... conditions
    ) {
        return new JoinTable(table, List.of(conditions));
    }

}