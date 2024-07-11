package org.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
  private int id;
  private String userName;
  private String password;
  private String email;
  private String phone;
  private String status;
  private String createTime;
  private String realName;
  private String position;
  private String sex;
  private String idCard;
  private String image;
  private org.example.entity.User User;

  public void setUser(User user1) {
    this.User=user1;
  }
}
