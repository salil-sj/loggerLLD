package com.lld.logger.loggerLLD.constants;

public enum LogLevel {
    INFO(1,"INFO"),
    DEBUG(2,"DEBUG"),
    WARN(3,"WARN"),
    ERROR(4,"ERROR"),
    HAZARD(5,"HAZARD");

    private final int level;
    private final String name;

    LogLevel(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
