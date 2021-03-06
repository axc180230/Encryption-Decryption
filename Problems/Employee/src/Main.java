class Employee {

    String name;
    int salary;
    String address;

    final static String unknown = "unknown";

    public Employee() {
        this.name = unknown;
        this.salary = 0;
        this.address = unknown;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        this.address = unknown;
    }

    public Employee(String name, int salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }
}