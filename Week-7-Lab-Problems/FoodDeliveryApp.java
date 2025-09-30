class DeliveryCalculator {
    double calculateDelivery(double distance) {
        double cost = distance * 10;
        System.out.println("Basic Delivery: Distance = " + distance + " km, Cost = Rs." + cost);
        return cost;
    }

    double calculateDelivery(double distance, double priorityFee) {
        double cost = (distance * 10) + priorityFee;
        System.out.println("Premium Delivery: Distance = " + distance + " km, Priority Fee = Rs." + priorityFee + ", Total = Rs." + cost);
        return cost;
    }

    double calculateDelivery(double distance, int orders) {
        double baseCost = distance * 10;
        double discount = orders * 5;
        double cost = baseCost - discount;
        if(cost < 0) cost = 0;
        System.out.println("Group Delivery: Distance = " + distance + " km, Orders = " + orders +", Discount = Rs." + discount + ", Total = Rs." + cost);
        return cost;
    }

    double calculateDelivery(double distance, double discountPercent, double freeLimit) {
        double baseCost = distance * 10;
        if(baseCost >= freeLimit) {
            System.out.println("Festival Special: Free delivery! Order above Rs." + freeLimit);
            return 0;
        }
        double discount = (baseCost * discountPercent) / 100;
        double cost = baseCost - discount;
        System.out.println("Festival Special: Distance = " + distance + " km, Discount = " + discountPercent + "%, Total = Rs." + cost);
        return cost;
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        DeliveryCalculator dc = new DeliveryCalculator();
        dc.calculateDelivery(5);
        dc.calculateDelivery(5, 50.0);
        dc.calculateDelivery(10, 3);
        dc.calculateDelivery(8, 20.0, 100.0);
    }
}
