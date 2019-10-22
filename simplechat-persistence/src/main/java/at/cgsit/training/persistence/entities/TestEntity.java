package at.cgsit.training.persistence.entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TestEntity
 *
 */
@Entity

public class TestEntity implements Serializable {

	
	private String vorname;
	private static final long serialVersionUID = 1L;

	public TestEntity() {
		super();
	}   
	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
   
}
