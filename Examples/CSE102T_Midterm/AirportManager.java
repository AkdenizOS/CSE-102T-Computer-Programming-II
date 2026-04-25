public class AirportManager {
    public static void main(String[] args) {

        Airport airport = new Airport(2, 2);

        DomesticFlight d1 = new DomesticFlight(101, 50, 1);
        DomesticFlight d2 = new DomesticFlight(102, 20, 2);
        DomesticFlight d3 = new DomesticFlight(103, 10, 3);
        DomesticFlight d4 = new DomesticFlight(104, 15, 4);

        InternationalFlight i1 = new InternationalFlight(201, 40, 15);
        InternationalFlight i2 = new InternationalFlight(202, 45, 10);
        InternationalFlight i3 = new InternationalFlight(203, 20, 10);

        try {
            airport.assignGate(d1);
            airport.assignGate(d2);
            airport.assignGate(d3); // Exception
            airport.assignGate(d4); // Should not even attempt this
        } catch (Exception ex) {
            System.out.println(ex); // DomesticFullException: Next available gate - 1
        }

        try {
            airport.assignGate(i1);
            airport.assignGate(i2);
            airport.assignGate(i3); // Exception
        } catch (Exception ex) {
            System.out.println(ex); // InternationalFullException: Next available gate - 0
        }

        System.out.println("International Flight Total Time (should be 55): " +
                i1.getTotalMinutesToDeparture());

        airport.updateTime(25);
        System.out.println("International Flight Total Time (should be 30): " +
                i1.getTotalMinutesToDeparture());

        airport.updateTime(-10);
        System.out.println("International Flight Total Time (should be 40): " +
                i1.getTotalMinutesToDeparture());

        System.out.println("Domestic Flight Time (should be 35): " +
                d1.getMinutesToDeparture());
    }
}
// You should not modify anything above this line

class DomesticFullException {
   private int gate;
   
   public DomesticFullException(int gate) {
      this.gate = gate;
   }
   
   public String toString() {
      return "DomesticFullException: Next available gate - " + gate;
   }
}

class InternationalFullException {
   private int gate;
   
   public InternationalFullException(int gate) {
      this.gate = gate;
   }
   
   public String toString() {
      return "InternationalFullException: Next available gate - " + gate;
   }
}