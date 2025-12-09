# aeglemon

**Project Summary**
- **Purpose**: A lightweight CLI for collecting/representing monitoring metrics and mapping them to dashboard-ready status colors.
- **CLI Entrypoint**: `aeglemon` — implemented in `src/main/java/com/aegle/monitor/AegleMonitorMain.java` using `picocli`.
- **Commands**: `AeglemonCommand` enum contains `refresh` and `generate`.
- **Core Model**: `Metric` (`name`, `env`, `timestamp`, `site`) in `src/main/java/com/aegle/monitor/Metric.java`.
- **Environments**: `Environment` enum (`develop`, `staging`, `prod`) in `src/main/java/com/aegle/monitor/Environment.java`.
- **Status Subsystem**: `MetricStatus` interface returns `StatusColor` (`Empty`, `White`, `Red`, `Yellow`, `Green`). Implementations:
	- `BooleanStatus`: boolean → `Green`/`Red`.
	- `TrileanStatus`: uses `StatusTrileon` (`Green`, `Red`, `Unset`) → `Green`/`Red`/`Empty`.
	- `ThresholdStatus`: placeholder — `getColorStatus()` not implemented yet.
	- `ThresholdLimitException`: custom exception for threshold violations.
- **Libraries**: SLF4J for logging, `picocli` for CLI parsing, Lombok for boilerplate.
- **Build**: Maven project (`pom.xml` at repo root).

**Quick Start**
- **Build**: Run the Maven package goal to produce a JAR.
	```bash
	mvn -q package
	```
- **Run (example)**: Replace `<your-jar>.jar` with the produced artifact name.
	```bash
	java -jar target/<your-jar>.jar generate -e prod
	```

**Notable Files**
- `src/main/java/com/aegle/monitor/AegleMonitorMain.java`: CLI entrypoint.
- `src/main/java/com/aegle/monitor/AeglemonCommand.java`: supported commands.
- `src/main/java/com/aegle/monitor/Metric.java`: metric model.
- `src/main/java/com/aegle/monitor/status/*`: status types and colors.

**Current Gaps & Suggested TODOs**
- **Implement**: `ThresholdStatus.getColorStatus()` — add threshold logic and tests.
- **Tests**: Expand unit tests for status mapping and CLI behavior (some tests exist under `test/`).
- **Docs**: Add examples demonstrating the `refresh` and `generate` commands and packaging guidance.

If you'd like, I can implement the `ThresholdStatus` logic and add tests, or run `mvn package` now to verify the build.