package com.app.pojos;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
  
  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;

 
}