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
    ClientData clientData;
    Date date;
    Product product;
    Money money;

    @BeforeEach
    void setUp() {
        id = new Id("11");
        clientData = new ClientData(id,"aaaa");
        date  = new Date();
        reservation = new Reservation(id, Reservation.ReservationStatus.OPENED,clientData,date);
        product = new Product(new Id("newId"), money, "sfsdfsdf", ProductType.DRUG);
        money = new Money( new BigDecimal("1111111"));
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
        fail();
    }
    @Test
    void IfProduntIsntaddShoudReturnFalse(){
        assertFalse(reservation.contains(product));
    }

    @Test
    void IfProduntIsaddShoudReturnTrue(){
        reservation.add(product, 12);
        assertTrue(reservation.contains(product));
    }
    @Test
    void ifProductIsNotAvailableShouldApplyDiscount()
    {

    }
    @Test
    void itShoudlThrowErrorWhenTryinToClosedReservation()
    {
        reservation = new Reservation(id, Reservation.ReservationStatus.CLOSED, clientData, date);
        assertThrows(DomainOperationException.class, () -> reservation.add(product, 10));
    }

}