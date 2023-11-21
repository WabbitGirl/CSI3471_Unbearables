package Controller;

import UI.UINavigator;

public class GuestControllerImpl implements GuestController {

    private UINavigator uiNavigator;

    //Constructor to set the UINavigator instance
    public GuestControllerImpl(UINavigator uiNavigator) {
        this.uiNavigator = uiNavigator;
    }

    public void onSearchCruises() {

        System.out.println("Searching Cruises");
    }

    public void onViewReservation() {

        System.out.println("Viewing Reservation");
    }

    public void onCancelReservation() {

        System.out.println("Cancelling Reservation");
    }

    public void onModifyReservation() {

        System.out.println("Modifying Reservation");
    }

    public void onViewProfile() {
        //ProfileControllerImpl.onViewProfile();
        uiNavigator.showCard(UINavigator.PROFILE_PAGE);
        System.out.println("Viewing Profile");
    }
}