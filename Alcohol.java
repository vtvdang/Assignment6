public class Alcohol extends Beverage {
	
	
	//NEW: AVAILABLE ON WEEKEND
	
    //constants
    private static final double WEEKEND = 0.6;

    //additional instance variable
    private boolean weekend;

    //parametrized constructor
    public Alcohol(String name, SIZE size, boolean weekend) {
        super(name, size, TYPE.ALCOHOL);
        this.weekend = weekend;
    }

	//overridden toString method
    @Override
    public String toString() {
        return "Alcohol: " + super.toString() + "\nAvailable?: " + weekend + "\nPrice: $" + calcPrice();
    }

    //overridden equals method
    @Override
    public boolean equals(Object obj) {
    	 if (super.equals(obj) == true) {
             return true;
         }

        Alcohol alcohol = (Alcohol) obj;
        return weekend == alcohol.weekend;
    }

    //overridden calcPrice method
    @Override
    public double calcPrice() {
		double price = 0.0;
		price += super.getBasePrice();
		
		switch (super.getSize()) {
			case SMALL:	
				break;
			case MEDIUM: 
				price += super.getSizeUp();
				break;
			case LARGE: 
				price += 2*super.getSizeUp();
				break;
		}
		if (this.weekend) {
		    price += WEEKEND;
		}
		return price;
	}

    
    // getters and setters
    public boolean isOfferedInWeekend() {
        return weekend;
    }

    public void setOfferedInWeekend(boolean weekend) {
        this.weekend = weekend;
    }

}
