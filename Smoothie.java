public class Smoothie extends Beverage {
    //constants
    private final double PROTEIN = 1.5;
    private final double FRUIT = 0.5;

    //instance variables
    private int numOfFruits;
    private boolean hasProteinPowder;

    // parametrized constructor
    public Smoothie(String name, SIZE size, int numOfFruits, boolean hasProteinPowder) {
        super(name, size, TYPE.ALCOHOL);
        
        this.numOfFruits = numOfFruits;
        this.hasProteinPowder = hasProteinPowder;
    }

    // Overridden toString method
    @Override
    public String toString() {
        return "Smoothie: " + super.toString() + "\nProtein Added? " + hasProteinPowder + "\nNumber of Fruits: " + numOfFruits + "\nPrice: $" + calcPrice();
    }

    // Overridden equals method
    @Override
    public boolean equals(Object obj) {
    	 if (super.equals(obj) == true) {
             return true;
         }
    	 
        Smoothie smoothie = (Smoothie) obj;
        boolean sameNumOfFruits = numOfFruits == smoothie.numOfFruits;
        boolean sameProteinPowder = hasProteinPowder == smoothie.hasProteinPowder;
        return sameNumOfFruits && sameProteinPowder;
    }

    // overridden calcPrice method
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
		if (this.hasProteinPowder) {
		    price += PROTEIN;
		}
		
		price += this.numOfFruits * this.FRUIT;
		return price;
    }
    
    // getters and setters
    public int getNumOfFruits() {
        return numOfFruits;
    }

    public void setNumberOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    public boolean getAddProtein() {
        return hasProteinPowder;
    }

    public void setHasProteinPowder(boolean hasProteinPowder) {
        this.hasProteinPowder = hasProteinPowder;
    }


}
