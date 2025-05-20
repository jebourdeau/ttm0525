package db.migration;

import org.flywaydb.core.Flyway;
import org.springframework.boot.ApplicationArguments;

public class FlywayMigr {
    private Flyway flyway;

    public FlywayMigr (Flyway flyway){
        this.flyway = flyway;
    }
    @Override
    public void run(ApplicationArguments args)throws Exception{
    flyway.migrate();
    }

}
