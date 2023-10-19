package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.models.TableModel;
import ru.geekbrains.lesson5.presenters.BookingPresenter;
import ru.geekbrains.lesson5.presenters.Model;
import ru.geekbrains.lesson5.presenters.View;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateUIShowTables();

        view.reservationTable(new Date(), 1, "Ольга"); //1001
        view.reservationTable(new Date(), 1, "Ольга");//1002
        view.reservationTable(new Date(), 2, "Ольга");//1003
        view.reservationTable(new Date(), 2, "Ольга");//1004
        view.reservationTable(new Date(), 3, "Ольга");//1005
        view.reservationTable(new Date(), 3, "Ольга");//1006
        view.reservationTable(new Date(), 4, "Ольга");//1007
        view.reservationTable(new Date(), 4, "Ольга");//1008
        view.reservationTable(new Date(), 5, "Ольга");//1009
        view.reservationTable(new Date(), 5, "Ольга");//1010

        view.changeReservationTable(1001, new Date(), 1, "Андрей");
       view.changeReservationTable(1002, new Date(), 1, "Андрей");
       view.changeReservationTable(1003, new Date(), 1, "Андрей");
       view.changeReservationTable(1005, new Date(), 3, "Андрей");
        view.changeReservationTable(1004, new Date(), 2, "Андрей");
        view.changeReservationTable(1009, new Date(), 4, "Андрей");

    }
}
