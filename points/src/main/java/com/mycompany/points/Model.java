/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.points;
import java.util.ArrayList;
/**
 *
 * @author q
 */
public class Model {

    /**
     * @param args the command line arguments
     */
    ArrayList<MyPoint> myPoints = new ArrayList<>();
    ArrayList<IObserver> observers = new ArrayList<>();

    void refresh(){
        for(IObserver o: observers){
            o.refresh();
        }
    }

    public void addObserver(IObserver o){
        observers.add(o);
    }
    public void addPoints(MyPoint mp){
        myPoints.add(mp);
        refresh();
    }

    public void move(MyPoint mp){
        myPoints.get(myPoints.size()-1).move(mp.getX(),mp.getY());
        refresh();
    }

    public ArrayList<MyPoint> getMyPoints() {
        return myPoints;
    }

}
