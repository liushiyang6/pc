package com.lsy.pc.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/7/19 10:52
 */
@Entity
@Table(name = "t_person_info")
@Getter
@Setter
public class PersonInfo extends BaseDO {



}
