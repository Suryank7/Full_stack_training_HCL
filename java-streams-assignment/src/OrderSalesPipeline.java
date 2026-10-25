import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderSalesPipeline {

    record OrderLine(String product, String category, int qty, BigDecimal unitPrice) {
        BigDecimal total() {
            return unitPrice.multiply(BigDecimal.valueOf(qty));
        }
    }

    record Order(int id, String customer, LocalDate date,
                 String status, List<OrderLine> lines) {
        BigDecimal total() {
            return lines.stream()
                    .map(OrderLine::total)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

    record SalesSummary(long orderCount, BigDecimal revenue) {
    }

    static OrderLine createLine(String product, String category, int quantity, int price) {
        return new OrderLine(product, category, quantity, BigDecimal.valueOf(price));
    }

    // Cancelled orders are removed here, so the rule is written only once.
    static Stream<Order> valid(List<Order> orders) {
        return orders.stream()
                .filter(order -> !order.status().equals("CANCELLED"));
    }

    static Optional<BigDecimal> averageOrderValue(List<Order> orders) {
        List<Order> validOrders = valid(orders).toList();

        if (validOrders.isEmpty()) {
            return Optional.empty();
        }

        BigDecimal totalRevenue = validOrders.stream()
                .map(Order::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal orderCount = BigDecimal.valueOf(validOrders.size());

        return Optional.of(totalRevenue.divide(orderCount, 2, RoundingMode.HALF_UP));
    }

    static Optional<Map.Entry<String, Long>> findBestSellingProduct(List<Order> orders) {
        Map<String, Long> productUnits = valid(orders)
                .flatMap(order -> order.lines().stream())
                .collect(Collectors.groupingBy(
                        OrderLine::product,
                        Collectors.summingLong(OrderLine::qty)
                ));

        return productUnits.entrySet().stream()
                .max(Map.Entry.comparingByValue());
    }

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Asha", LocalDate.parse("2026-01-05"), "DELIVERED",
                        List.of(
                                createLine("Laptop", "Electronics", 1, 50000),
                                createLine("Mouse", "Electronics", 2, 500)
                        )),
                new Order(2, "Ravi", LocalDate.parse("2026-01-12"), "DELIVERED",
                        List.of(
                                createLine("Book", "Books", 3, 400),
                                createLine("Pen", "Stationery", 10, 20)
                        )),
                new Order(3, "Asha", LocalDate.parse("2026-02-03"), "CANCELLED",
                        List.of(createLine("Phone", "Electronics", 1, 30000))),
                new Order(4, "Meera", LocalDate.parse("2026-02-10"), "DELIVERED",
                        List.of(
                                createLine("Book", "Books", 2, 400),
                                createLine("Laptop", "Electronics", 1, 50000)
                        )),
                new Order(5, "Ravi", LocalDate.parse("2026-02-18"), "DELIVERED",
                        List.of(
                                createLine("Mouse", "Electronics", 1, 500),
                                createLine("Pen", "Stationery", 5, 20)
                        ))
        );

        // R1: Total revenue from orders that are not cancelled.
        BigDecimal r1 = valid(orders)
                .map(Order::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // R2: Revenue per customer, sorted from highest to lowest.
        Map<String, BigDecimal> customerRevenue = valid(orders)
                .collect(Collectors.groupingBy(
                        Order::customer,
                        Collectors.reducing(
                                BigDecimal.ZERO, Order::total, BigDecimal::add
                        )
                ));

        LinkedHashMap<String, BigDecimal> r2 = customerRevenue.entrySet().stream()
                .sorted(Map.Entry.<String, BigDecimal>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (first, second) -> first,
                        LinkedHashMap::new
                ));

        // R3: Revenue from each category.
        Map<String, BigDecimal> r3 = valid(orders)
                .flatMap(order -> order.lines().stream())
                .collect(Collectors.groupingBy(
                        OrderLine::category,
                        TreeMap::new,
                        Collectors.reducing(
                                BigDecimal.ZERO, OrderLine::total, BigDecimal::add
                        )
                ));

        // R4: Number of units sold for each product.
        Map<String, Long> r4 = valid(orders)
                .flatMap(order -> order.lines().stream())
                .collect(Collectors.groupingBy(
                        OrderLine::product,
                        TreeMap::new,
                        Collectors.summingLong(OrderLine::qty)
                ));

        // R5: Product with the highest number of units sold.
        Optional<Map.Entry<String, Long>> r5 = findBestSellingProduct(orders);

        // R6: Revenue for each month, with months sorted.
        Map<YearMonth, BigDecimal> r6 = valid(orders)
                .collect(Collectors.groupingBy(
                        order -> YearMonth.from(order.date()),
                        TreeMap::new,
                        Collectors.reducing(
                                BigDecimal.ZERO, Order::total, BigDecimal::add
                        )
                ));

        // R7: Average value of a valid order.
        Optional<BigDecimal> r7 = averageOrderValue(orders);

        // R8: Percentage of cancelled orders out of all orders.
        long cancelledOrders = orders.stream()
                .filter(order -> order.status().equals("CANCELLED"))
                .count();

        double r8 = orders.isEmpty()
                ? 0.0
                : cancelledOrders * 100.0 / orders.size();

        // R9: Count delivered orders and add their revenue using teeing.
        SalesSummary r9 = orders.stream()
                .filter(order -> order.status().equals("DELIVERED"))
                .collect(Collectors.teeing(
                        Collectors.counting(),
                        Collectors.reducing(
                                BigDecimal.ZERO, Order::total, BigDecimal::add
                        ),
                        SalesSummary::new
                ));

        // R10: Distinct categories bought by each customer, sorted alphabetically.
        Map<String, List<String>> r10 = valid(orders)
                .collect(Collectors.groupingBy(
                        Order::customer,
                        TreeMap::new,
                        Collectors.flatMapping(
                                order -> order.lines().stream()
                                        .map(OrderLine::category),
                                Collectors.collectingAndThen(
                                        Collectors.toCollection(TreeSet::new),
                                        ArrayList::new
                                )
                        )
                ));

        // Check the answers. Run this program with java -ea to enable assertions.
        assert r1.compareTo(BigDecimal.valueOf(103800)) == 0 : "R1 failed";

        assert r2.get("Asha").compareTo(BigDecimal.valueOf(51000)) == 0 : "R2 Asha failed";
        assert r2.get("Meera").compareTo(BigDecimal.valueOf(50800)) == 0 : "R2 Meera failed";
        assert r2.get("Ravi").compareTo(BigDecimal.valueOf(2000)) == 0 : "R2 Ravi failed";

        assert r3.get("Electronics").compareTo(BigDecimal.valueOf(101500)) == 0 : "R3 Electronics failed";
        assert r3.get("Books").compareTo(BigDecimal.valueOf(2000)) == 0 : "R3 Books failed";
        assert r3.get("Stationery").compareTo(BigDecimal.valueOf(300)) == 0 : "R3 Stationery failed";

        assert r4.get("Laptop") == 2L : "R4 Laptop failed";
        assert r4.get("Mouse") == 3L : "R4 Mouse failed";
        assert r4.get("Book") == 5L : "R4 Book failed";
        assert r4.get("Pen") == 15L : "R4 Pen failed";

        assert r5.isPresent() : "R5 product is missing";
        assert r5.get().getKey().equals("Pen") && r5.get().getValue() == 15L : "R5 failed";

        assert r6.get(YearMonth.of(2026, 1)).compareTo(BigDecimal.valueOf(52400)) == 0 : "R6 January failed";
        assert r6.get(YearMonth.of(2026, 2)).compareTo(BigDecimal.valueOf(51400)) == 0 : "R6 February failed";

        assert r7.isPresent() && r7.get().compareTo(BigDecimal.valueOf(25950)) == 0 : "R7 failed";
        assert Math.abs(r8 - 20.0) < 0.0001 : "R8 failed";
        assert r9.orderCount() == 4 : "R9 count failed";
        assert r9.revenue().compareTo(BigDecimal.valueOf(103800)) == 0 : "R9 revenue failed";

        assert r10.get("Asha").equals(List.of("Electronics")) : "R10 Asha failed";
        assert r10.get("Meera").equals(List.of("Books", "Electronics")) : "R10 Meera failed";
        assert r10.get("Ravi").equals(List.of("Books", "Electronics", "Stationery")) : "R10 Ravi failed";

        // Empty-list checks for R1, R5, and R7.
        List<Order> emptyOrders = List.of();

        BigDecimal emptyRevenue = valid(emptyOrders)
                .map(Order::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Optional<Map.Entry<String, Long>> emptyBestProduct =
                findBestSellingProduct(emptyOrders);

        Optional<BigDecimal> emptyAverage = averageOrderValue(emptyOrders);

        assert emptyRevenue.compareTo(BigDecimal.ZERO) == 0 : "Empty R1 failed";
        assert emptyBestProduct.isEmpty() : "Empty R5 failed";
        assert emptyAverage.isEmpty() : "Empty R7 failed";

        // Print the report using the calculated results.
        System.out.println("========== ORDER SALES REPORT ==========");
        System.out.println(String.format("R1 Total revenue: %s", r1));
        System.out.println(String.format("R2 Revenue per customer: %s", r2));
        System.out.println(String.format("R3 Revenue per category: %s", r3));
        System.out.println(String.format("R4 Units sold per product: %s", r4));
        System.out.println(String.format("R5 Best-selling product: %s",
                r5.map(entry -> entry.getKey() + " (" + entry.getValue() + ")")
                        .orElse("none")));
        System.out.println(String.format("R6 Monthly revenue: %s", r6));
        System.out.println(String.format("R7 Average order value: %s",
                r7.map(BigDecimal::toPlainString).orElse("N/A")));
        System.out.println(String.format("R8 Cancellation rate: %.0f%%", r8));
        System.out.println(String.format("R9 Delivered order count: %d, revenue: %s",
                r9.orderCount(), r9.revenue()));
        System.out.println(String.format("R10 Categories per customer: %s", r10));
        System.out.println("All assertions passed.");
    }
}
