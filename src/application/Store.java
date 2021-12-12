package application;

public class Store {
  private static Integer priceTotal=0 ;

public static Integer getPriceTotal() {
	return priceTotal;
}

public static void setPriceTotal(Integer priceTotal) {
	Store.priceTotal = priceTotal;
}
}
