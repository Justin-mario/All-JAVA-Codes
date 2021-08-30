package classPratice;

public class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        setMonthlySalary ( monthlySalary );

    }
    public void setMonthlySalary(double monthlySalary){
        if (monthlySalary > 0){
            this.monthlySalary = monthlySalary;
        } else{
            System.out.println ("please provide a valid amount");
        }
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public  void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }
    public double calculateYearlySalary(){
        return getMonthlySalary () * 12;
    }
    public  double calculateIncrementYearlySalary(){
      return calculateYearlySalary () * 0.1;
    }

    public static void main(String[] args) {
        Employee employee = new Employee ("Evan","Eke",10000  );
        Employee employee1 = new Employee ( "Peter","Adeloije",200000 );
        System.out.printf ("%s %s %s %s %s",employee.getFirstName (), employee.getLastName (), employee.getMonthlySalary (),
                employee.calculateYearlySalary (),employee.calculateIncrementYearlySalary ());
        System.out.println ( );
        System.out.printf ("%s %s %s %s %s",employee1.getFirstName (), employee1.getLastName (), employee1.getMonthlySalary (),
                employee1.calculateYearlySalary (),employee1.calculateIncrementYearlySalary ());


    }
}
