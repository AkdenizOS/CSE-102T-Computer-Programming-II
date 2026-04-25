import java.util.*;

public class Assignment2 {
    public static void main(String[] args) {
        System.out.println("=== GLOBAL AIRPORT MANAGEMENT SYSTEM INITIALIZED ===\n");

        AirTrafficControl atc = new AirTrafficControl();

        // 1. Create Gates
        TerminalGate<CommercialFlight> gateA1 = new TerminalGate<>("A1");
        TerminalGate<CargoFlight> gateC1 = new TerminalGate<>("C1");

        // 2. Create Flights
        CommercialFlight commFlight = new CommercialFlight("TK1902", "Istanbul", 85.0);
        CargoFlight cargoFlight = new CargoFlight("FX11", "Memphis", 20.0); // Low fuel!
        EmergencyFlight medevac = new EmergencyFlight("LIFE-99", "Ankara", 40.0, "Organ Transport");

        atc.registerFlight(commFlight);
        atc.registerFlight(cargoFlight);
        atc.registerFlight(medevac);

        // 3. Passenger & Baggage Subsystem Test
        System.out.println("--- TESTING PASSENGER SECURITY & BOARDING ---");
        Passenger pass1 = new Passenger("TR-991", "Ahmet Yilmaz", Passenger.ECONOMY);
        pass1.addBaggage(new Baggage("BAG-A1", 20.5)); // Safe

        Passenger pass2 = new Passenger("US-882", "John Doe", Passenger.FIRST_CLASS);
        pass2.addBaggage(new Baggage("BAG-B1", 15.0)); // Safe

        Passenger pass3 = new Passenger("UK-773", "Jane Smith", Passenger.BUSINESS);
        pass3.addBaggage(new Baggage("BAG-C1", 105.0)); // Too Heavy! Fails security.

        // Process Security 
        atc.clearPassengerSecurity(pass1);
        atc.clearPassengerSecurity(pass2);
        atc.clearPassengerSecurity(pass3); // Fails

        System.out.println();
        // Dock and Board
        gateA1.dockFlight(commFlight);
        commFlight.queueForBoarding(pass1);
        commFlight.queueForBoarding(pass2);
        commFlight.queueForBoarding(pass3); // Rejected at gate

        System.out.println();
        // Execute Boarding - First class boards before Economy!
        commFlight.prepareForDeparture();

        // 4. Cargo Logistics Test
        System.out.println("\n--- TESTING CARGO LOGISTICS ---");
        gateC1.dockFlight(cargoFlight);
        cargoFlight.loadFreight(new CargoPayload("MFST-001", 50.0, false));
        cargoFlight.loadFreight(new CargoPayload("MFST-HAZ-002", 10.0, true)); // Hazmat
        cargoFlight.prepareForDeparture();

        // 5. Air Traffic Control Test (Priority Queues)
        System.out.println("\n--- TESTING AIR TRAFFIC CONTROL ---");
        
        // Flights releasing from gates and requesting takeoff
        atc.requestTakeoff(gateA1.releaseFlight());
        atc.requestTakeoff(gateC1.releaseFlight());
        
        // Takeoffs process sequentially (FIFO Queue)
        atc.processNextTakeoff();
        atc.processNextTakeoff();

        // Incoming Flights request landing (PriorityQueue)
        atc.requestLanding(commFlight);
        atc.requestLanding(cargoFlight);
        atc.requestLanding(medevac); // Arrives late but jumps the queue!

        // Landing Order Expected: Medevac (9999), Cargo (Hazmat + Low Fuel), CommFlight (Safe Fuel)
        System.out.println("\n>>> INITIATING LANDING SEQUENCE <<<");
        atc.processNextLanding();
        atc.processNextLanding();
        atc.processNextLanding();

        // 6. System Reporting (Stack)
        atc.printDailyAuditLog();
    }
}

//CODE HERE