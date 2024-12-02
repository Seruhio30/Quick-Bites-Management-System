package com.seruhioCode30.quickbites.util;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FlywayRepairRunner implements CommandLineRunner {

    private final Flyway flyway;

    @Autowired
    public FlywayRepairRunner(Flyway flyway) {
        this.flyway = flyway;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running Flyway repair...");
        flyway.repair();
        System.out.println("Flyway repair completed.");
    }
}

