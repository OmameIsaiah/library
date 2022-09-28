package com.library.app.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SushiOrderManager {

    public  ArrayList<SushiOrder> request= null;
    public SushiOrderManager() {
        /* initialize class state */
        request= new ArrayList<>();
    }

    public void addOrder(ArrayList<SushiOrder> request) {
        /* add request to current batch of orders */
        for(int i= 0; i< request.size(); i++){
            this.request.add(request.get(i));
            if(request.get(i).getSeatId()==1){
                c1Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==2){
                c2Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==3){
                c3Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==4){
                c4Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==5){
                c5Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==6){
                c6Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==7){
                c7Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==8){
                c8Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==9){
                c9Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==10){
                c10Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==11){
                c11Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==12){
                c12Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==13){
                c13Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==14){
                c14Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==15){
                c15Orders= request.get(i).getMenuItemIds().size();
            }else if(request.get(i).getSeatId()==16){
                c16Orders= request.get(i).getMenuItemIds().size();
            }
            //System.out.println(i);
        }
        totalCustomers= this.request.size();
    }
    public static int getMaxItemNumber(ArrayList<SushiOrder> request){
        int num= 0;
        for(int i= 0; i< request.size(); i++){
            if(request.get(i).menuItemIds.size() > num){
                num = request.get(i).menuItemIds.size();
            }
        }
        return num;
    }
    public int counter=1;
    public int totalCustomers=1;
    public int maxCustomers=16;
    public int c1Orders=0;
    public int c2Orders=0;
    public int c3Orders=0;
    public int c4Orders=0;
    public int c5Orders=0;
    public int c6Orders=0;
    public int c7Orders=0;
    public int c8Orders=0;
    public int c9Orders=0;
    public int c10Orders=0;
    public int c11Orders=0;
    public int c12Orders=0;
    public int c13Orders=0;
    public int c14Orders=0;
    public int c15Orders=0;
    public int c16Orders=0;

    public int c1Items=1;
    public int c2Items=1;
    public int c3Items=1;
    public int c4Items=1;
    public int c5Items=1;
    public int c6Items=1;
    public int c7Items=1;
    public int c8Items=1;
    public int c9Items=1;
    public int c10Items=1;
    public int c11Items=1;
    public int c12Items=1;
    public int c13Items=1;
    public int c14Items=1;
    public int c15Items=1;
    public int c16Items=1;


    public SushiItem nextItem() {
        SushiItem item= null;
        // return next roll object in the format
        // new SushiItem(/seatId/ 1, /menuItemId/ "tuna");
        // or null if no order is pending

        //int numberOfSeats = request.size();
        //ArrayList<SushiOrder> orderedRequest= new ArrayList<>();
        //System.out.println("Orders: "+ orderedRequest);
        System.out.println("Maximum Item Numbers: "+ getMaxItemNumber(request));

        if(counter>=totalCustomers){
            counter=1;
        }else{
            System.out.println("Here 1");
            if(counter==1){
                System.out.println("Here 2");
                if(request.get(1)==null
                        && request.get(2)==null
                        && request.get(3)==null
                        && request.get(4)==null
                        && request.get(5)==null
                        && request.get(6)==null
                        && request.get(7)==null
                        && request.get(8)==null
                        && request.get(9)==null
                        && request.get(10)==null
                        && request.get(11)==null
                        && request.get(12)==null
                        && request.get(13)==null
                        && request.get(14)==null
                        && request.get(15)==null
                        && request.get(16)==null){
                    item= null;
                    System.out.println("Here 3");
                }else{
                    System.out.println("Here 4");
                    System.out.println("First Seat ID: "+request.get(1).getSeatId());
                    if(request.get(1).getSeatId()==1){
                        System.out.println("Here 5");
                        if(c1Orders>0){
                            System.out.println("Here 6");
                            item = new SushiItem(1, request.get(1).menuItemIds.get(c1Items));
                            request.get(1).menuItemIds.remove(c1Items);
                            --c1Orders;
                            ++c1Items;
                            ++counter;
                        }else{
                            System.out.println("Here 7");
                            item= null;
                            c1Items=1;
                        }
                    }else if(request.get(1).getSeatId()==2){
                        System.out.println("Here 5");
                        if(c2Orders>0){
                            System.out.println("Here 6");
                            item = new SushiItem(2, request.get(1).menuItemIds.get(c1Items));
                            request.get(1).menuItemIds.remove(c1Items);
                            --c1Orders;
                            ++c1Items;
                            ++counter;
                        }else{
                            System.out.println("Here 7");
                            item= null;
                            c1Items=1;
                        }
                    }else if(request.get(1).getSeatId()==3){
                        System.out.println("Here 5");
                        if(c3Orders>0){
                            System.out.println("Here 6");
                            item = new SushiItem(3, request.get(1).menuItemIds.get(c1Items));
                            request.get(1).menuItemIds.remove(c1Items);
                            --c1Orders;
                            ++c1Items;
                            ++counter;
                        }else{
                            System.out.println("Here 7");
                            item= null;
                            c1Items=1;
                        }
                    }




                }
            }

        }







        return item;
    }

    public static void main(String[] args) {
        ArrayList<SushiOrder> request = new ArrayList<>(
                Arrays.asList(
                        new SushiOrder(1, // seatId for this order
                                new ArrayList<>(Arrays.asList(
                                        new String[] {
                                                // menuItemIds for this order
                                                "tuna", "california", "avocado"
                                        }
                                ))
                        ),
                        new SushiOrder(3,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {"avocado"}
                                ))
                        ),
                        new SushiOrder(2,
                                new ArrayList<>(Arrays.asList(
                                        new String[] {
                                                "salmon", "tuna", "crab", "scallop"
                                        }
                                ))
                        )
                )
        );
        SushiOrderManager manager= new SushiOrderManager();
        manager.addOrder(request);
        for(int i=0; i<getMaxItemNumber(request); i++){
            //manager.nextItem();
            System.out.println(manager.nextItem());
        }



    }
}