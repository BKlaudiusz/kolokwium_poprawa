package edu.iis.mto.testreactor.reservation;

import edu.iis.mto.testreactor.offer.DiscountPolicy;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {
    @Mock
    Reservation reservation;
    @Mock
    DiscountPolicy discountPolicy;

    Reservation.ReservationStatus reservationStatus;
    List<ReservationItem> items = List.of(ReservationItem(Product(new Id(),)));


    @Test
    void ifdiscountPolicyIsNull()
    {
        fail();
    }
    @Test
    void ifListItemIsEmptyShoudReturnEmppyOffer()
    {
        
    }



}