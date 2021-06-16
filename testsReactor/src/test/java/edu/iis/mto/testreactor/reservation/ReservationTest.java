package edu.iis.mto.testreactor.reservation;

import edu.iis.mto.testreactor.money.Money;
import edu.iis.mto.testreactor.offer.DiscountPolicy;
import edu.iis.mto.testreactor.offer.Offer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;

import java.math.BigDecimal;
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
    void ConstrucotrIsWork()  {
        assertEquals( new ArrayList<>(), reservation.getReservedProducts());
        assertEquals( Reservation.ReservationStatus.OPENED, reservation.getStatus());
        assertEquals(clientData, reservation.getClientData());
        assertEquals(date, reservation.getCreateDate());

    }
    @Test
    void emptyOffer() {
        Offer return_offer = reservation.calculateOffer(discountPolicy);
        assertEquals(new Offer(new ArrayList<>(), new ArrayList<>()), return_offer);
    }
    @Test
    void shouldInvokeIsClosedOneceWhenAdding() {

    }
    @Test
    void ifProductIsAvailableShouldApplyDiscount()
    {

      //  doReturn(true).when(reservation.).termalCircuit(any(HeatingSettings.class));
    //    Assertions.assertThrows(OvenException.class, () -> oven.start(bakingProgram));
    }
    @Test
    void ifProductIsNotAvailableShouldApplyDiscount()
    {

    }
    @Test
    void itShoudlThrowErrorWhenTryinToClosedReservation()
    {
        reservation = new Reservation(id, Reservation.ReservationStatus.CLOSED, clientData, date);
        Money money = new Money( new BigDecimal("1111111"));
        Product product = new Product(new Id("newId"), money, "sfsdfsdf", ProductType.DRUG);

        assertThrows(DomainOperationException.class, () -> reservation.add(product, 10));
    }
    @Test
    void ShouldThrowExeptionWhenTrying()
    {

    }

}