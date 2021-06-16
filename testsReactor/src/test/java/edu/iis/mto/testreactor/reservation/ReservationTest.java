package edu.iis.mto.testreactor.reservation;

import edu.iis.mto.testreactor.money.Money;
import edu.iis.mto.testreactor.offer.DiscountPolicy;
import edu.iis.mto.testreactor.offer.Offer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ReservationTest {
    Reservation reservation;
    @Mock
    DiscountPolicy discountPolicy;

    Reservation.ReservationStatus reservationStatus;

    Id id;
    Reservation.ReservationStatus status;
    ClientData clientData;
    Date date;

    @BeforeEach
    void setUp() {
        id = new Id("11");
        clientData = new ClientData(id,"aaaa");
        date  = new Date();
        reservation = new Reservation(id, Reservation.ReservationStatus.OPENED,clientData,date);
    }
    @Test
    void emptyOffer() throws ParseException {
        Offer return_offer = reservation.calculateOffer(discountPolicy);
        assertEquals(new Offer(new ArrayList<>(), new ArrayList<>()), return_offer);
    }


    @Test
    void shouldInvokeIsClosedOneceWhenAdding() {

    }

    @Test
    void ifdiscountPolicyIsNull()
    {
        fail();
    }
    @Test
    void ifListItemIsEmptyShoudReturnEmppyOffer()
    {

    }
    @Test
    void ifProductIsAvailableShouldApplyDiscount()
    {

    }
    @Test
    void ifProductIsNotAvailableShouldApplyDiscount()
    {

    }
    @Test
    void itShoudlThrowErrorWhenTryinToClosedReservation()
    {

    }
    @Test
    void ShouldThrowExeptionWhenTrying()
    {

    }

}