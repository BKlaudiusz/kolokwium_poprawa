package edu.iis.mto.testreactor.reservation;

import edu.iis.mto.testreactor.money.Money;
import edu.iis.mto.testreactor.offer.DiscountPolicy;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ReservationTest {
    @Mock
    Reservation reservation;
    @Mock
    DiscountPolicy discountPolicy;

    Reservation.ReservationStatus reservationStatus;


    @Test
    void shouldInvokeIsClosedOneceWhenAdding() {

        Money money = new Money(100, "EUR");
        Product product = new Product(Id.generate(), money, "Tshirt",ProductType.STANDARD);

        reservation.add(product, 1);

        verify(reservation, times(1)).isClosed();
        InOrder in = inOrder(reservation);
        in.verify(reservation).isClosed();
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