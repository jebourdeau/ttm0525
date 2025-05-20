//package initiativep.component;
//
//import org.flywaydb.core.Flyway;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//
//public class FlywayMigration implements ApplicationRunner {
//    private final Flyway flyway;
//    public FlywayMigration(Flyway flyway) {
//        this.flyway = flyway;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        flyway.migrate();
//    }
//}