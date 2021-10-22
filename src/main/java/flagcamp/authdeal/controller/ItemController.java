package flagcamp.authdeal.controller;

import flagcamp.authdeal.dao.*;
import flagcamp.authdeal.entity.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ItemController {
  @Autowired
  private ItemDao itemDao;

  @Autowired
  private UserDao userDao;

  @Autowired
  private MessageDao messagesDao;

  @Autowired
  private OrdersDao ordersDao;

  @RequestMapping(value = "/items", method = RequestMethod.GET)
  public List<Items> fetchAllItems() {
    return itemDao.findAllItems();
  }

  @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
  public Items fetchItemByID(@PathVariable(value = "itemId") int itemId){
    return itemDao.findItemById(itemId);
  }

  @RequestMapping(value = "/items", method = RequestMethod.POST)
  public Items postItem(@RequestBody Items item) {
    return itemDao.addItem(item);
  }

//  @RequestMapping(value = "/items", method = RequestMethod.POST)
//  public Items postItem(@RequestBody Map<String,Object> json) {
//    Items newItem = new Items();
//    Users seller = userDao.findUserById((String)json.get("userName"));
//    newItem.setUsers(seller);
//    newItem.setItemName((String)json.get("itemName"));
//    newItem.setPrice((float) json.get("price"));
//    newItem.setPicture((String) json.get("picture"));
//    newItem.setItemCondition((ItemCondition) json.get("itemCondition"));
//    newItem.setDescription((String) json.get("description"));
//    newItem.setSold(false);
//    newItem.setZipcode((int)json.get("zipcode"));
//    return itemDao.addItem(newItem);
//  }

  @RequestMapping(value = "/items/{itemId}",method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable(value = "itemId") int itemId) {
    itemDao.deleteItem(itemId);
  }

  @RequestMapping(value ="/seller/{sellId}/items", method = RequestMethod.GET)
  public Map<String,Object> sellAndItsItems(@PathVariable(value = "sellId") String sellId){
    Map<String,Object> map = new HashMap<>();
    Users seller = userDao.findUserById(sellId);
    if(seller!=null){
      map.put("seller",seller);
      map.put("items",itemDao.findItemsBySellId(sellId));
    }
    return map;
  }
  @RequestMapping(value ="/seller/{sellId}/dashboard", method = RequestMethod.GET)
  public Map<String,Object> sellDashboard(@PathVariable(value = "sellId") String sellId) {
    Map<String, Object> map = new HashMap<>();
    Users seller = userDao.findUserById(sellId);
    if (seller != null) {
      map.put("seller", seller);
      map.put("items", itemDao.findItemsBySellId(sellId));
      map.put("massage",messagesDao.FindAllMassageByUser(sellId));
      map.put("order",ordersDao.findOrdersBySellerId(sellId));
    }
    return map;
  }
}
