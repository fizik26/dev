import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Getter;

public final class QueryBuilder {

    private final List<Column> columnsSelected;
    private final List<Table> fromTables;
    private final List<JoinTable> joinTables;
    private final List<Condition> whereAndConditions;
    private final Map<Column, QueryBuilder> whereAndEqualsSubSelectConditions;
    private final List<Order> orders;

    @Getter
    private final Map<String, Object> parameters;

    public QueryBuilder() {
        this.columnsSelected = new ArrayList<>();
        this.joinTables = new ArrayList<>();
        this.whereAndConditions = new ArrayList<>();
        this.whereAndEqualsSubSelectConditions = new HashMap<>();
        this.orders = new ArrayList<>();
        this.fromTables = new ArrayList<>();
        this.parameters = new HashMap<>();
    }

    public QueryBuilder select(final Column... columns) {
        Collections.addAll(this.columnsSelected, columns);
        return this;
    }

    public QueryBuilder from(final Table... tables) {
        Collections.addAll(this.fromTables, tables);
        return this;
    }

    public QueryBuilder join(final JoinTable... joins) {
        Collections.addAll(this.joinTables, joins);
        return this;
    }

    public QueryBuilder where(final Condition condition) {
        return whereAnds(condition);
    }

    public QueryBuilder whereAnds(final Condition... conditions) {
        Collections.addAll(this.whereAndConditions, conditions);
        return this;
    }

    public QueryBuilder order(final Order... ordersBy) {
        Collections.addAll(this.orders, ordersBy);
        return this;
    }

    public QueryBuilder parameter(final Condition.Param key, final Object value) {
        this.parameters.put(key.name(), value);
        return this;
    }

    public QueryBuilder andEqualsSubSelect(final Column column, final QueryBuilder queryBuilder) {
        this.whereAndEqualsSubSelectConditions.put(column, queryBuilder);
        this.parameters.putAll(queryBuilder.parameters);
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        buildSqlSelect(sb);
        buildSqlFrom(sb);
        buildSqlJoins(sb);
        buildSqlWhere(sb);
        buildSqlOrderBy(sb);

        return sb.toString();
    }

    private void buildSqlOrderBy(final StringBuilder sb) {
        if (orders.isEmpty()) {
            return;
        }
        sb.append(" ORDER BY ");
        sb.append(orders.stream()
                .map(Order::toSql)
                .collect(Collectors.joining(" , ")));
    }

    private void buildSqlWhere(final StringBuilder sb) {
        if (whereAndConditions.isEmpty()) {
            return;
        }
        sb.append(" WHERE ");
        sb.append(whereAndConditions.stream()
                .map(Condition::toSql)
                .collect(Collectors.joining(" AND ")));
        if (whereAndEqualsSubSelectConditions.isEmpty()) {
            return;
        }
        whereAndEqualsSubSelectConditions.forEach((Column column, QueryBuilder subQuery) -> sb
                .append(" AND %s = ( %s ) ".formatted(column.toSql(), subQuery.build())));
    }

    private void buildSqlJoins(final StringBuilder sb) {
        for (JoinTable joinTable : joinTables) {
            sb.append(joinTable.toSql());
        }
    }

    private void buildSqlFrom(final StringBuilder sb) {
        sb.append(" FROM ");
        sb.append(fromTables.stream()
                .map(Table::toSql)
                .collect(Collectors.joining(", ")));
    }

    private void buildSqlSelect(final StringBuilder sb) {
        sb.append("SELECT ");
        sb.append(columnsSelected.stream()
                .map(Column::toSql)
                .collect(Collectors.joining(", ")));
    }
}