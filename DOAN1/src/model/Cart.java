package model;

import java.util.HashMap;
import java.util.Map.Entry;



public class Cart {
	private HashMap<String, Item> cartItem;

	 public Cart() {
	        cartItem = new HashMap<>();
	    }
	 
	    public Cart(HashMap<String, Item> cartItem) {
	        this.cartItem = cartItem;
	    }
	 
	    public HashMap<String, Item> getCartItem() {
	        return cartItem;
	    }
	 
	    public void setCartItem(HashMap<String, Item> cartItem) {
	        this.cartItem = cartItem;
	    }
	//insert to cart
	public void plusToCart(String key,Item item) {
		boolean check = cartItem.containsKey(key);
		if(check) {
		int soluong_cu = item.getSoLuong();
		item.setSoLuong(soluong_cu +1);
		cartItem.put(key,item);
		}
		else {
			cartItem.put(key,item); 
		}
	}
	public void subToCart(String key,Item item) {
		boolean check = cartItem.containsKey(key);
		if(check) {
			int soluong_cu = item.getSoLuong();
			if(soluong_cu <=1) {
				cartItem.remove(key);
				
			}else {
				item.setSoLuong(soluong_cu -1);
				cartItem.put(key,item);
			}
		}
	}
	public void removeToCart(String key) {
		boolean check = cartItem.containsKey(key);
		if(check) {
			cartItem.remove(key);
		}
	}
	public int countItem() {
		return cartItem.size();
	}
	public double totalCart() {
		double count =0;
		//count = price *soluong
		for(Entry<String, Item> list : cartItem.entrySet()) {
			count += list.getValue().getSanpham().getGiaSP() * list.getValue().getSoLuong();
		}
		return count;
	}
	
}
