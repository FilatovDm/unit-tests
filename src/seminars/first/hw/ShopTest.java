package seminars.first.hw;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;

public class ShopTest {

    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */

    public ShopTest() {
    }

    public static void main(String[] args) {
        List<Product> foodBasket = new ArrayList();
        fillFoodBasket(foodBasket);
        Shop myShop = new Shop();
        myShop.setProducts(foodBasket);
        checkExpensiveProduct(myShop.getMostExpensiveProduct());
        checkBaskin(myShop);
        myShop.getSortedListProducts();
        checkSortBaskin(myShop);
    }

    public static void fillFoodBasket(List<Product> basket) {
        Product milk32 = new Product();
        milk32.setCost(50);
        milk32.setTitle("milk 3,2");
        basket.add(milk32);
        Product coffee = new Product();
        coffee.setCost(150);
        coffee.setTitle("ground coffee");
        basket.add(coffee);
        Product sugar = new Product();
        sugar.setCost(15);
        sugar.setTitle("cane sugar");
        basket.add(sugar);
    }

    public static void checkBaskin(Shop shop) {
        ((ListAssert)((ListAssert) Assertions.assertThat(shop.getProducts()).isNotEmpty())
                .hasSize(3)).doesNotHaveDuplicates();
        int sizeShop = shop.getProducts().size();

        for(int item = 0; item < sizeShop; ++item) {
            Assertions.assertThat(((Product)shop.getProducts().get(item)).getTitle())
                    .containsAnyOf(new CharSequence[]{"ground coffee", "milk 3,2", "cane sugar"});
        }

    }

    public static void checkExpensiveProduct(Product product) {
        Assertions.assertThat(product.getCost()).isEqualTo(150);
    }

    public static void checkSortBaskin(Shop shop) {
        int sizeShop = shop.getProducts().size();

        for(int item = 0; item < sizeShop - 1; ++item) {
            ((AbstractBooleanAssert)Assertions
                    .assertThat(((Product)shop.getProducts().get(item + 1))
                    .getCost() >= ((Product)shop.getProducts().get(item))
                    .getCost())
                    .as("цена позиции " + (item + 1) + " больше цены позиции " + (item + 2), new Object[0]))
                    .isTrue();
        }

    }
}




