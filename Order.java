import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
    // instance variables
    private int orderNumber;
    private int orderTime;
    private DAY orderDay;
    private Customer customer;
    private List<Beverage> beverages;

    // constructor
    public Order(int orderTime, DAY orderDay, Customer customer) {
        this.orderNumber = generateRandomOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = customer;
        this.beverages = new ArrayList<>();
    }

    // method to generate a random order number
    int generateRandomOrderNumber() {
        Random rand = new Random();
        int randInt = rand.nextInt(99999) + 1;
        return randInt;
    }

    // overloaded method to add a new beverage to the order
    public void addNewBeverage(Beverage beverage) {
        beverages.add(beverage);
    }

    // overridden toString method
    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Order Number: ").append(orderNumber)
        			.append(", Time: ").append(orderTime)
                    .append(", Day: ").append(orderDay)
                    .append(", Customer: ").append(customer)
                    .append(", Beverages: ").append(beverages);
        return orderDetails.toString();
    }

    // overridden compareTo method based on order number
    @Override
    public int compareTo(Order otherOrder) {
        if (this.orderNumber > otherOrder.orderNumber) {
            return 1;
        } else if (this.orderNumber < otherOrder.orderNumber) {
            return -1;
        } else {
            return 0;
        }
    }
	@Override
	public boolean isWeekend() {
	    return orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY;
	}

	@Override
	public Beverage getBeverage(int num) {
		return beverages.get(num);	
		}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(coffee);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		Alcohol alcohol = new Alcohol(bevName, size, false);
		beverages.add(alcohol);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addPRotien);
		beverages.add(smoothie);
	}

	@Override
	public double calcOrderTotal() {
		double total = 0.0;
		for (int i = 0; i < beverages.size(); i++) {
		    Beverage beverage = beverages.get(i);
		    total += beverage.calcPrice();
		}
		return total;

	}

	
	@Override
	public int findNumOfBeveType(TYPE type) {
	    int bevType = 0;
	    for (int i = 0; i < beverages.size(); i++) {
	        Beverage beverage = beverages.get(i);
	        if (beverage.getBevType() == type) {
	            bevType++;
	        }
	    }
	    return bevType;
	}

    // getters and setters
	public int getOrderNo() {
		return this.orderNumber;
	}

	public void setOrderNo(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public DAY getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}

	// getter for a deep copy of the customer
    public Customer getCustomer() {
        return new Customer(customer);
    }

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Beverage> getBeverages() {
		return (ArrayList<Beverage>) beverages;
	}

	public void setBeverages(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}

	public int getTotalItems() {
		return this.beverages.size();

	}
}
