public record Table(
        String nom
) {

    public String toSql() {
        return "%s %s".formatted(nom, nom);
    }

    public static Table of(final String nom) {
        return new Table(nom);
    }

}