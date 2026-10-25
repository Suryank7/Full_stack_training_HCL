# Java Streams Assignment

This project contains both tasks from the Java Streams handout.

## Files
- `src/EmployeeAnalytics.java` — Task 1, Q1 to Q12 and E1 to E3.
- `src/OrderSalesPipeline.java` — Task 2, R1 to R10, assertions, empty-list checks, and formatted report.

## Requirements
Use Java 17 or later. No external libraries are needed.

## Compile
Run these commands from the project folder:

```bash
javac -d out src/EmployeeAnalytics.java src/OrderSalesPipeline.java
```

## Run Task 1

```bash
java -cp out EmployeeAnalytics
```

## Run Task 2

```bash
java -ea -cp out OrderSalesPipeline
```

The `-ea` option enables Java assertions. The Task 2 program should finish with `All assertions passed.`

## Short explanations
- `filter`: keeps elements that match a condition.
- `map`: changes each element into another value.
- `flatMap`: flattens nested collections or streams into one stream.
- `reduce`: combines stream values into one result.
- `groupingBy`: groups elements by a key.
- `partitioningBy`: divides elements into the `true` and `false` groups.
- `toMap`: creates a map; duplicate keys need a merge function.
- `Optional`: represents a result that might not exist.
- `collectingAndThen`: applies a final operation to the result of a collector.
- `teeing`: runs two collectors on the same stream and combines their results.

For Task 1 Q9, `maxBy` returns an `Optional` because a group might not contain an element. `collectingAndThen` turns that optional result into a name or `"none"`.

For Task 1 E3, `map` is an intermediate operation. It is lazy, so the mapping function does not execute until a terminal operation is added.

For Task 2, cancelled orders are filtered by the `valid` helper method. The cancellation-rate calculation intentionally uses all orders because cancelled orders must be included in that calculation.
