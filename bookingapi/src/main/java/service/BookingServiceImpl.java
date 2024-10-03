package service;

import entities.Booking;
import org.springframework.stereotype.Service;
import repository.BookingRespository;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRespository bookingRespository;

    public BookingServiceImpl(BookingRespository bookingRespository) {
        this.bookingRespository = bookingRespository;
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRespository.save(booking);
    }

    @Override
    public Booking findBookingById(Long id) {
        return bookingRespository.findById(id).orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking booking = bookingRespository.findById(id).orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
        booking.setId(bookingDetails.getId());
        booking.setDestination(bookingDetails.getDestination());
        booking.setOrigin(bookingDetails.getOrigin());
        booking.setFlightNumber(bookingDetails.getFlightNumber());
        booking.setDepartureTime(bookingDetails.getDepartureTime());
        return bookingRespository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        Booking booking = bookingRespository.findById(id).orElseThrow(()-> new RuntimeException("Reserva no encontrada"));
        bookingRespository.delete(booking);
    }
}
