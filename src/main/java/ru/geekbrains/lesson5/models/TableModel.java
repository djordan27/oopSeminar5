package ru.geekbrains.lesson5.models;

import ru.geekbrains.lesson5.presenters.Model;
import ru.geekbrains.lesson5.views.BookingView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {


    private Collection<Table> tables;

    /**
     * Получение списка всех столиков
     * @return
     */
    public Collection<Table> loadTables(){
        if (tables == null){
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
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя клиента
     * @return Номер брони
     */
    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table : tables) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
    }

    /**TODO: Разработать метод самостоятельно в рамках домашнего задания
     * Поменять бронь столика
     * @return
     */
    @Override
    public int changeRereservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        Table myTable = new Table();
        myTable.getReservations().remove(oldReservation);
        for (Table table : tables)
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
                }
        return -1;
    }
    //    public int changeReservationTable(Date reservationDate, int tableNo, String name, Reservation reservation){
//        return -1;
//        //TODO: Для создания нового резерва столика стоит воспользоваться уже
//        // существующим методом reservationTable
//    }

}
