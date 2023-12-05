public class Customer {
	
	//instance variables
	private String name;
    private int age;

    // parametrized constructor
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // copy constructor
    public Customer(Customer otherCustomer) {
        this.name = otherCustomer.name;
        this.age = otherCustomer.age;
    }

    // overridden toString method
    @Override
    public String toString() {
        return "Customer: " + name + "\nAge: " + age;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
