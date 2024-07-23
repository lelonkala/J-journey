package metricsconversions;

/**
 * 2024 July, my first Java project
 * @author Nombulelo Nkala
 */
import java.util.Scanner;

public class MetricsConversions {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean reconvert = true;
        
       while (reconvert)
       {
           //prompt user input, unit in text form
           System.out.print("Enter the unit you want to convert (Feet, Meters, Pounds, Kgs, Fahrenheit, Celsius): ");
           String unit = scanner.nextLine();
           
           //Asking the user to specify the conversion type
           System.out.println("Which conversion type do you want to use?");
            System.out.println("a. From Feet to Meters");
            System.out.println("b. From Meters to Feet");
            System.out.println("c. From Pounds to Kgs");
            System.out.println("d. From Kgs to Pounds");
            System.out.println("e. From Fahrenheit to Celsius");
            System.out.println("f. From Celsius to Fahrenheit");
            
            String type = scanner.nextLine();
            //calling of the validateConversion function
            boolean validConversion = validateConversion(unit, type);
            // checking if the conversion specified is an option or not
            if (!validConversion)
            {
                System.out.println("Invalid unit or conversion type. Please try again.");
                continue;
            }
            //prompt user for the quantity that must be converted
            System.out.println("Enter the quantity to be converted: ");
            double quantity = scanner.nextDouble();
            scanner.nextLine(); // newline character
            
            //calling the performConversion function where the conversions are being performed
            double result = performConversion(type, quantity);
            System.out.println("The result of the conversion is: "+ result + " "+ getTargetUnit(type));
            
            //Ask the user if he wants to perfom another conversion
            System.out.println("Do you want to perfom another Metrics conversion? (yes/no): ");
            String user = scanner.nextLine();
            
            //if the user says no, then terminate the program
            if(user.equalsIgnoreCase("no"))
            {
                reconvert = false;
            }
            

       }
        //display a thank you message
        System.out.println("Thank you for using the Metrics Conversion!");
    }


//calling of the validateConversion function
 public static boolean validateConversion(String Unit, String Ctype) {
        switch (Ctype.toLowerCase()) {
            case "a":
                return Unit.equalsIgnoreCase("Feet");
            case "b":
                return Unit.equalsIgnoreCase("Meters");
            case "c":
                return Unit.equalsIgnoreCase("Pounds");
            case "d":
                return Unit.equalsIgnoreCase("Kgs");
            case "e":
                return Unit.equalsIgnoreCase("Fahrenheit");
            case "f":
                return Unit.equalsIgnoreCase("Celsius");
            default:
                return false;
        }
    }

//converting
public static double performConversion(String Type, double quantity) {
        switch (Type.toLowerCase()) {
            case "a":
                return feetToMeters(quantity);
            case "b":
                return metersToFeet(quantity);
            case "c":
                return poundsToKgs(quantity);
            case "d":
                return kgsToPounds(quantity);
            case "e":
                return fahrenheitToCelsius(quantity);
            case "f":
                return celsiusToFahrenheit(quantity);
            default:
                return Double.MIN_VALUE;
        }
    }

 public static String getTargetUnit(String Type) {
        switch (Type.toLowerCase()) {
            case "a":
                return "Meters";
            case "b":
                return "Feet";
            case "c":
                return "Kgs";
            case "d":
                return "Pounds";
            case "e":
                return "Celsius";
            case "f":
                return "Fahrenheit";
            default:
                return "";
        }
    }

//feet to meters
  public static double feetToMeters(double feet) {
        return feet * 0.3048;
    }

//meters to feet
    public static double metersToFeet(double meters) {
        return meters / 0.3048;
    }

//pounds to kg
    public static double poundsToKgs(double pounds) {
        return pounds * 0.453592;
    }

//kg to pounds
    public static double kgsToPounds(double kgs) {
        return kgs / 0.453592;
    }

//fahrenheit to celcius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

//celsius to fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

}