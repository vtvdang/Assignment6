public class Coffee extends Beverage {
	
	
	//NEW: SHOTS AND SYRUP
	
    //constant variables
    private final double EXTRA_SHOT = 0.5;
    private final double EXTRA_SYRUP = 0.5;

    //instance variables
    private boolean extraShot;
    private boolean extraSyrup;

    //parametrized constructor
    public Coffee(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
        super(name, size, TYPE.COFFEE);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    //overridden toString method
    @Override
    public String toString() {
        return "Coffee: " + super.toString() + ", Extra Shot? " + extraShot + ", Extra Syrup? " + extraSyrup + ", Price: $" + calcPrice();
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
				price += 2 * super.getSizeUp();
				break;
		}
		
		if (this.extraShot) {
		    price += this.EXTRA_SHOT;
		}

		if (this.extraSyrup) {
		    price += EXTRA_SYRUP;
		}

		return price;
	}


    //overridden equals method
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj) == true) {
            return true;
        }

        Coffee coffee = (Coffee) obj;
        return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
    }

    //getters and setters
    public boolean getExtraShot() {
        return extraShot;
    }

    public void setHasExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    public void setHasExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }

	

}
