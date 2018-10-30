package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.LoaiSP;
import model.value;

public class BIEUDODAO {
	public ArrayList<value> getAll() {
	     try {
	          LoaiSPDAO categoryDAO = new LoaiSPDAO();
	          SanPhamDAO productDAO = new SanPhamDAO();
	          ArrayList<value> list = new ArrayList<>();
	          for (LoaiSP category : categoryDAO.getlistLoaiSP()) {
	              list.add(new value(category.getTenLoai(),
	                   productDAO.getListSanPhamByMaSP(category.getMaLoai()).size()));
	          }
	          return list;
	     } catch (SQLException ex) {
	          Logger.getLogger(BIEUDODAO.class.getName()).log(Level.SEVERE, null, ex);
	     }
	     return null;
	}
public static void main(String[] args) {
	System.out.println(new BIEUDODAO().getAll());
	for(value v : new BIEUDODAO().getAll()) {
		System.out.println(v.getName()+"-"+v.getValue());
	}
}
}
