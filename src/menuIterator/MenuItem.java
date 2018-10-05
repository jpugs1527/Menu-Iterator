/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuIterator;

/**
 *
 * @author jordanpuglisi
 */
public class MenuItem {
    private String itemName;
    private String price;
    private int category;
    private boolean heartHealthy;
    
    public MenuItem(String itemName, String price, int category, boolean heartHealthy) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.heartHealthy = heartHealthy;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public String getPrice() {
        return price;
    }
    
    public int getCategory() {
        return category;
    }
    
    public boolean getHeartHealthy() {
        return heartHealthy;
    }
}
