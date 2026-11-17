public final class ExampleQuery {

    private ExampleQuery() {
       // Util class
    }

    public static QueryBuilder exampleQueryBuilder(final Object obj) {
       return new QueryBuilder()
             .select(
                   TableA.id(),
                   TableA.name(),
                   TableA.description()
             )
             .from(TableA.table())
             .join(JoinTable.of(
                         TableB.table(),
                         Condition.of(
                               TableA.id(),
                               TableB.tableAId(),
                               Operator.EQUAL
                         ),
                         Condition.of(
                               TableA.code(),
                               TableB.code(),
                               Operator.EQUAL
                         )
                   )
             ) 
             // .join() ... , multiple join allowed
             .whereAnds(
                   Condition.ofParam(
                         TableB.perimeter(),
                         Operator.EQUAL,
                         stringParam()),
                   Condition.ofParam(
                         TableB.tableAId(),
                         Operator.EQUAL,
                         idParam())
             )
             .parameter(stringParam(), "TEST")
             .parameter(idParam(), obj.getId().id());
    }

    private static Condition.Param stringParam() {
       return Condition.param("valueDb");
    }

    private static Condition.Param idParam() {
       return Condition.param("id");
    }

}