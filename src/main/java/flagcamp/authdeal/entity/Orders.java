package flagcamp.authdeal.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

  private static final long serialVersionUID = -6571020025726257848L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int orderId;

  @ManyToOne
  private Users buyer;
  @ManyToOne
  private Users seller;

  @OneToOne
  private Items item;

  private Timestamp orderDate;
  private Timestamp lastUpdateDate;
  private OrderStatus orderStatus;

  private boolean isPickUp;
  private String firstName;
  private String lastName;
  private String address;
  private String city;
  private String state;
  private String zipcode;
  private String country;

  public Orders() {
    this.orderDate = new Timestamp(System.currentTimeMillis());
    this.lastUpdateDate = new Timestamp(System.currentTimeMillis());
  }

  public Orders(Users buyer, Users seller, Items item, Timestamp orderDate,
      Timestamp lastUpdateDate, OrderStatus orderStatus, boolean isPickUp, String firstName,
      String lastName, String address, String city, String state, String zipcode,
      String country) {
    this.buyer = buyer;
    this.seller = seller;
    this.item = item;
    this.orderDate = orderDate;
    this.lastUpdateDate = lastUpdateDate;
    this.orderStatus = orderStatus;
    this.isPickUp = isPickUp;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zipcode = zipcode;
    this.country = country;
  }

  public Orders(int orderId, Users buyer, Users seller, Items item, Timestamp orderDate,
      Timestamp lastUpdateDate, OrderStatus orderStatus, boolean isPickUp, String firstName,
      String lastName, String address, String city, String state, String zipcode,
      String country) {
    this.orderId = orderId;
    this.buyer = buyer;
    this.seller = seller;
    this.item = item;
    this.orderDate = orderDate;
    this.lastUpdateDate = lastUpdateDate;
    this.orderStatus = orderStatus;
    this.isPickUp = isPickUp;
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zipcode = zipcode;
    this.country = country;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public Users getBuyer() {
    return buyer;
  }

  public void setBuyer(Users buyer) {
    this.buyer = buyer;
  }

  public Users getSeller() {
    return seller;
  }

  public void setSeller(Users seller) {
    this.seller = seller;
  }

  public Items getItem() {
    return item;
  }

  public void setItem(Items item) {
    this.item = item;
  }

  public Timestamp getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Timestamp orderDate) {
    this.orderDate = orderDate;
  }

  public Timestamp getLastUpdateDate() {
    return lastUpdateDate;
  }

  public void setLastUpdateDate(Timestamp lastUpdateDate) {
    this.lastUpdateDate = lastUpdateDate;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  public boolean isPickUp() {
    return isPickUp;
  }

  public void setPickUp(boolean pickUp) {
    isPickUp = pickUp;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Orders)) {
      return false;
    }
    Orders orders = (Orders) o;
    return getOrderId() == orders.getOrderId() &&
        isPickUp() == orders.isPickUp() &&
        Objects.equals(getOrderDate(), orders.getOrderDate()) &&
        Objects.equals(getLastUpdateDate(), orders.getLastUpdateDate()) &&
        getOrderStatus() == orders.getOrderStatus() &&
        Objects.equals(getFirstName(), orders.getFirstName()) &&
        Objects.equals(getLastName(), orders.getLastName()) &&
        Objects.equals(getAddress(), orders.getAddress()) &&
        Objects.equals(getCity(), orders.getCity()) &&
        Objects.equals(getState(), orders.getState()) &&
        Objects.equals(getZipcode(), orders.getZipcode()) &&
        Objects.equals(getCountry(), orders.getCountry());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getOrderId(), getOrderDate(), getLastUpdateDate(), getOrderStatus(), isPickUp(),
            getFirstName(), getLastName(), getAddress(), getCity(), getState(), getZipcode(),
            getCountry());
  }

  @Override
  public String toString() {
    return "Orders{" +
        "orderId=" + orderId +
        ", buyer=" + buyer +
        ", seller=" + seller +
        ", item=" + item +
        ", orderDate=" + orderDate +
        ", lastUpdateDate=" + lastUpdateDate +
        ", orderStatus=" + orderStatus +
        ", isPickUp=" + isPickUp +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", address='" + address + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", zipcode='" + zipcode + '\'' +
        ", country='" + country + '\'' +
        '}';
  }
}
