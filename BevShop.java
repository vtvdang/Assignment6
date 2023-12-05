import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BevShop implements BevShopInterface {
    private int numOfAlcoholDrinks;
    private List<Order> orders;
	private Order currentOrder;

    public BevShop() {
        this.numOfAlcoholDrinks = 0;
        this.orders = new ArrayList<>();
        
    }

    @Override
    public boolean validTime(int time) {
        if (time >= MIN_TIME && time <= MAX_TIME) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean eligibleForMore() {
        if (numOfAlcoholDrinks < MAX_ORDER_FOR_ALCOHOL) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean validAge(int age) {
        if (age >= MIN_AGE_FOR_ALCOHOL) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
            currentOrder = new Order(time, day, new Customer(customerName, customerAge));
            orders.add(currentOrder);
    }

    @Override
    public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
            currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup); 
        
    }

    @Override
    public void processAlcoholOrder(String bevName, SIZE size) {
        if (eligibleForMore()) {
            currentOrder.addNewBeverage(bevName, size);
            numOfAlcoholDrinks++;
        }
    }

    @Override
    public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
            currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
       
    }
    
    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
			return i;
            }
        }
        return -1;
    }

    
    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0.0;
    }

    @Override
    public double totalMonthlySale() {
        double totalSale = 0.0;
        for (Order order : orders) {
            totalSale += order.calcOrderTotal();
        }
        return totalSale;
    }
    
    @Override
    public void sortOrders() {
        Collections.sort(orders);
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }
    


    @Override
    public String toString() {
        StringBuilder salesReport = new StringBuilder();
        salesReport.append("Sales Report:\n\n");
        salesReport.append("All Orders:\n");
        
        //prints all the orders
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            salesReport.append(order).append("\n");
        }
        //prints monthly sales
        salesReport.append("Total Monthly Sales: $").append(totalMonthlySale());
        return salesReport.toString();
    }
    
    
    //getters and setters
    public Order getCurrentOrder() {
		return currentOrder;
	}
    public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public int getNumOfAlcoholDrink() {
		return numOfAlcoholDrinks;
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	public Object totalNumOfMonthlyOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isMaxFruit(int fruits) {
		if(fruits > MAX_FRUIT) {
			return true;
		}
		else 
		return false;
	}

	
	
}
