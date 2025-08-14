package discountproduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Main {

  public static Map<String, List<List<String>>> mapDiscounts(List<List<String>> discounts) {
    Map<String, List<List<String>>> discountMap = new HashMap<>();
    for (List<String> discount : discounts) {
      String id = discount.get(0);
      discountMap.computeIfAbsent(id, k -> new ArrayList<>()).add(discount);
    }
    return discountMap;
  }

  public static long getMinimumPrice(List<List<String>> products, List<List<String>> discounts) {
    Map<String, List<List<String>>> discountMap = mapDiscounts(discounts);
    int total = 0;

    for (List<String> product : products) {
      int productPrice = Integer.parseInt(product.get(0));
      int lowerPrice = productPrice;

      List<List<String>> applicableDiscounts = new ArrayList<>();
      for (int i = 1; i < product.size(); i++) {
        String key = product.get(i);
        if (discountMap.containsKey(key)) {
          applicableDiscounts.addAll(discountMap.get(key));
        }
      }

      for (List<String> discount : applicableDiscounts) {
        String type = discount.get(1);
        int value = Integer.parseInt(discount.get(2));
        int discountPrice = value;

        if ("1".equals(type))
          discountPrice = (int) Math.floor(productPrice * (1 - value / 100.0));
        else if ("2".equals(type))
          discountPrice = productPrice - value;

        if (discountPrice < lowerPrice)
          lowerPrice = discountPrice;
      }
      total += lowerPrice;
    }
    return total;
  }

  public static void main(String[] args) {

    Random r = new Random();
    Logger logger = Logger.getLogger(Main.class.getName());

    List<List<String>> products = new ArrayList<>();
    String[] discountIds = new String[500];
    IntStream.range(0, 500).forEach(i -> discountIds[i] = ("DIS" + i));

    IntStream.range(0, 2000).forEach(i -> {
      Double price = Math.floor(Math.random() * 1000) + 1;
      List<String> product = new ArrayList<>();
      product.add(price.toString().replaceAll("\\.0+$", ""));
      for (int j = 0; j < 3 + Math.floor(Math.random() * 3); j++) {
        String randId = discountIds[r.nextInt(discountIds.length)];
        product.add(randId);
      }
      products.add(product);
    });

    List<List<String>> discounts = new ArrayList<>();

    IntStream.range(0, 2000).forEach(i -> {
      String id = discountIds[r.nextInt(discountIds.length)];
      Integer type = r.nextInt(3);
      Integer value = r.nextInt(50) + 1;
      discounts.add(List.of(id, type.toString(), value.toString()));
    });

    long startTime = System.nanoTime();

    long minimumPrice = getMinimumPrice(products, discounts);

    long endTime = System.nanoTime();
    long duration = ((endTime - startTime) / 1000000);

    logger.info(() -> "Minimum Price: " + minimumPrice + ", Execution time: " + duration + "ms");

  }
}
