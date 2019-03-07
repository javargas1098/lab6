/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author cristian
 */
public class Seat {
    
    private AtomicInteger row;
    private AtomicInteger col;
    
    public Seat(){
    }
    
    public Seat(AtomicInteger row, AtomicInteger col){
        this.row=row;
        this.col=col;
    }


    public int getRow() {
        return row.get();
    }


    public void setRow(int row) {
        this.row.set(row);
    }


    public int getCol() {
        return col.get();
    }

 
    public void setCol(int col) {
        this.col.set(col);;
    }
    
    @Override
    public String toString(){
        return this.row.get()+" "+this.col.get();
    }
}
