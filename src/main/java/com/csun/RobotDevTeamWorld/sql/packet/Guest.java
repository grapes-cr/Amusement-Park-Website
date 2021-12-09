package com.csun.RobotDevTeamWorld.sql.packet;

public class Guest {
	
    private int id;
    private String LastName;
    private String FirstName;
    private String Address;
    private String City;

    public Guest() {
    }

    public Guest(int id, String LastName, String FirstName, String Address, String City) {
        this.id = id;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Address = Address;
        this.City = City;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    
    public String getAddress() {
        return Address;
    }
    
    public void setAddress(String Address) {
    	this.Address = Address;
    }
    
    public String getCity() {
        return City;
    }
    
    public void setCity(String City) {
    	this.City = City;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", Last mame='" + LastName + '\'' +
                ", First name='" + FirstName + '\'' +
                ", Address=" + Address + '\'' +
                ", Address=" + City +
                '}';
    }
}
