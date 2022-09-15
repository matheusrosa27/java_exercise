package model.services;

import model.entities.Invoice;
import model.entities.CarRental;

public class RentalService {
    private Double pricePerDay;
    private Double pricePerHour;
    public Tax taxService;

    public RentalService(Double pricePerDay, Double pricePerHour, Tax taxService) {
        super();
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        long t1 = carRental.getStart().getTime();
        long t2 = carRental.getFinish().getTime();

        double hours = (double) (t2-t1)/1000/60/60;

        double basicPayment;
        if (hours <= 12.0){
            basicPayment = Math.ceil(hours) * pricePerHour;
        } else {
            basicPayment = Math.ceil(hours/24) * pricePerDay;
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }
}
