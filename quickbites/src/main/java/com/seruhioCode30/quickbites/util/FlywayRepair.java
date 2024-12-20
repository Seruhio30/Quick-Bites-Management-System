package com.seruhioCode30.quickbites.util;

import org.flywaydb.core.Flyway;

public class FlywayRepair {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/quickBites_management_system", "root", "&eruhioDesu1983")
                .load();

        // Repara el historial de migraciones
        flyway.repair();
        System.out.println("Flyway repair ejecutado correctamente.");
    }
}

