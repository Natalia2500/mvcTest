/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dao.CategoryTable;
import model.dao.EmployeeTable;
import model.dao.MenuTable;
import model.dao.UtilityTable;
import model.dao.OrderTable;
import model.dao.ProductTable;
import model.dao.ReceiptTable;
import model.dao.SupplierTable;

import model.dao.Table;
import model.entity.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 
 */
public class ControllerForView implements IControllerForView {
    
    private Map<String, Table> tableMap = new HashMap<>();
    private static ControllerForView instance = null;
    
    public static IControllerForView getInstance(){
        if(instance == null){
            instance=new ControllerForView();
        }
        return instance;
    }
    
    public ControllerForView(){
        tableMap.put("product", new ProductTable());
        tableMap.put("receipt", new ReceiptTable());
        tableMap.put("order", new OrderTable());
        tableMap.put("supplier", new SupplierTable());
        tableMap.put("category", new CategoryTable());
        tableMap.put("employee", new EmployeeTable());
        tableMap.put("menu", new MenuTable());
        tableMap.put("utility", new UtilityTable());
    }

    @Override
    public boolean save(HashMap<String, Object> entityMap, String tableName){ 
        Table entityTable = this.tableMap.get(tableName);
        Entity entity = (Entity)entityTable.constructEntityFromMap(entityMap);
        boolean res = entityTable.save(entity);
        return res;
    }


    @Override
    public boolean update(HashMap<String, Object> entityMap, String tableName) {
        Table entityTable = this.tableMap.get(tableName);
        Entity entity = (Entity)entityTable.constructEntityFromMap(entityMap);
        boolean res = entityTable.update(entity);
        return res;
    }


    @Override
    public boolean delete(HashMap<String, Object> entityMap, String tableName) {
        Table entityTable = this.tableMap.get(tableName);
        Entity entity = (Entity)entityTable.constructEntityFromMap(entityMap);
        boolean res = entityTable.delete(entity);
        return res;
    }
    
    @Override
    public ArrayList getAll(String tableName){
        
        Table entityTable = this.tableMap.get(tableName);
        ArrayList<Entity> resList = entityTable.getAll();
        ArrayList<HashMap<String,Object>> res  = new ArrayList<HashMap<String,Object>>();
        for(Entity entity : resList){
            res.add(entity.map());
        }
        return res;
    }

    @Override
    public ArrayList<HashMap<String, Object>> getFrom(Object searchParam, String paramName, String tableName) {
        Table entityTable = this.tableMap.get(tableName);
        ArrayList<Entity> resList = entityTable.getFrom(searchParam, paramName);
        ArrayList<HashMap<String,Object>> res  = new ArrayList<HashMap<String,Object>>();
        for(Entity entity : resList){
            res.add(entity.map());
        }
        return res;
    }
 
}
