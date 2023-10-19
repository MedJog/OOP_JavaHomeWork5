package ru.geekbrains.lesson5.models;

import ru.geekbrains.lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {


    private Collection<Table> tables;

    /**
     * Получить все столики
     *
     * @return
     */
    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate Дата бронирования
     * @param tableNo         номер столика
     * @param name            Имя
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : loadTables()) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика.");
    }
    /**
     * TODO: Разработать самостоятельно
     * Изменить бронь столика
     * @param oldReservation номер старого резерва (для снятия)
     * @param reservationDate дата резерва столика
     * @param tableNo номер столика
     * @param name Имя
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        for (Table table : tables){
            var tableReservations = table.getReservations();
            for (Reservation reservation : tableReservations){
                if (reservation.getId() == oldReservation) {
                    System.out.println("-------------------------------------");
                    System.out.println("История бронирования столика " + table.getNo());
                    System.out.println(table.getReservations().toString());
                    System.out.println();
                    System.out.print("Бронь номер " + oldReservation + " будет удалена.");
                    table.getReservations().remove(reservation);
                    System.out.println();
                    System.out.println("Оставшиеся: " + table.getReservations().toString());
                    System.out.println();
                }
            }
        }
        System.out.println("Забронировать столик " + tableNo);
        System.out.println("На имя " + name);
        System.out.println(reservationDate);
        return reservationTable(reservationDate, tableNo, name);
    }
}
