package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.flywaydb.core.internal.jdbc.JdbcTemplate;

public class V1_0_0__CreatePostTable extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        JdbcTemplate template = new JdbcTemplate(context.getConnection());
        template.execute("CREATE TABLE posts (\n"
                + "id VARCHAR(36) PRIMARY KEY,\n"
                + "first_name VARCHAR(25),\n"
                + "last_name VARCHAR(50),\n"
                + "company VARCHAR(50),\n"
                + "address_id VARCHAR(36),\n"
                + "profession VARCHAR,\n"
                + "specialization VARCHAR,\n"
                + "description VARCHAR\n"
                + ");"
        );
    }
}
