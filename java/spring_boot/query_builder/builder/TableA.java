public final class TableA {

    private TableA() {
        // utils class
    }

    public static Table table() {
        return new Table("table_a_db");
    }

    public static Column id() {
        return Column.of(table(), "id");
    }

    public static Column name() {
        return Column.of(table(), "name");
    }

    public static Column description() {
        return Column.of(table(), "description");
    }

    public static Column perimeter() {
        return Column.of(table(), "perimeter");
    }
}