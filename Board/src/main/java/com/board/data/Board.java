package com.board.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_board")
public class Board {
	@Id
	private int id;
	@Column(name = "boardkind")
	private String boardkind;
	@Column(name = "adminemail")
	private String adminemail;
	@Column(name = "createdate")
	private Date date;
}
