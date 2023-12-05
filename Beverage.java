public abstract class Beverage {
   
    //instance variables
    private String name;
    private TYPE type;
    private SIZE size;
    
    //constant variables
   	//price of all bevs
       private static final double BASE_PRICE = 2.0;
       private static final double SIZE_UP_PRICE = 1.0;

    //parametrized constructor
    public Beverage(String name,  SIZE size, TYPE type) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    //abstract method for calculating bev price
    public abstract double calcPrice();

    //overridden toString method
    @Override
    public String toString() {
        return "Beverage: " + name + ", size: " + size;
    }

    //overridden equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Beverage beverage = (Beverage) obj;
        return name.equals(beverage.name) && type.equals(beverage.type) && size.equals(beverage.size);
    }
 

    //getters and setters
    public String getBevName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TYPE getBevType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }
    
    public double getBasePrice() {
		return BASE_PRICE;
    }
		
	public double getSizeUp() {
		return SIZE_UP_PRICE;
	
	}
}
