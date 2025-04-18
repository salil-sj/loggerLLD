
# Improvements in Logger LLD

## 1. Configuration Management

### 🧠 Intuition:
Currently, log levels and handler configurations (e.g., console logger, error logger) are hardcoded into the system. This makes the logger rigid and hard to adapt to different environments (dev, test, prod) or change behavior at runtime.

### 💡 Solution:
Introduce a configuration mechanism that reads from an external file (like `logger.properties`, `config.yaml`, or `.json`). This file can define:
- The minimum log level to be printed.
- The order and type of handlers (Console, File, etc.).
- Output formatting styles.

This makes the logger more **flexible**, **extensible**, and **environment-independent**.

```Java
# logger.properties
log.level=INFO
log.handlers=console,file
log.file.path=app.log

```

```Java
package com.lld.logger.config;

import com.lld.logger.loggerLLD.handlers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoggerConfigLoader {

    public static AbstractLogger loadLoggerChain() throws IOException {
        Properties props = new Properties();
        InputStream input = LoggerConfigLoader.class.getClassLoader().getResourceAsStream("logger.properties");

        if (input == null) throw new RuntimeException("Could not find logger.properties");

        props.load(input);

        LogLevel minLevel = LogLevel.fromString(props.getProperty("log.level"));
        String handlersConfig = props.getProperty("log.handlers");

        // Build logger chain based on config
        AbstractLogger head = null;
        AbstractLogger current = null;

        for (String handler : handlersConfig.split(",")) {
            AbstractLogger newLogger = null;

            switch (handler.trim().toLowerCase()) {
                case "console":
                    newLogger = new InfoLogger(minLevel.getLevel()); // You can make specific class per level too
                    break;
                case "file":
                    String path = props.getProperty("log.file.path");
                    newLogger = new FileLogger(minLevel.getLevel(), path);
                    break;
                // Add more handlers here
                default:
                    throw new RuntimeException("Unknown handler: " + handler);
            }

            if (head == null) {
                head = newLogger;
            } else {
                current.setNextLogger(newLogger);
            }

            current = newLogger;
        }

        return head;
    }
}

```

---

## 2. Thread Safety

### 🧠 Intuition:
In a multi-threaded environment, if multiple threads log messages simultaneously without synchronization, it may lead to:
- Jumbled or interleaved log outputs in the console or file.
- File corruption or inconsistent data in persistent log storage.

### ❌ Without Synchronization:
```plaintext
[INFO] Sta[ERROR] Dat[INFO] Req[ERROR] Disk
rted         abase      uest     Failure
```

### ✅ With Synchronization:
```plaintext
[INFO] Started
[INFO] Request
[ERROR] Database
[ERROR] Disk Failure
```

### 💡 Solution:
To maintain log message order and avoid data corruption:
- Use `synchronized` blocks around logging code.
- Use `ReentrantLock` for more control if needed.
- For high-performance applications, use an **asynchronous logging approach**:
  - Logging threads write to a shared queue.
  - A single background thread consumes the queue and writes logs sequentially.

This balances correctness and performance.

---

