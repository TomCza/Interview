package com.example.demo;

import java.sql.Date;

public class Bet {
  
    private String game;
    private Integer id;
    private Integer numbets;
    private double stake;
    private double returns;
    private Integer clientid;
    private Date date;
    
    
    //Getters
    public String getGame() {
        return game;
    }
    public void setGame(String newGame) {
        this.game = newGame;
    }
    public Integer getId() {
        return id;
    }
    public Integer getNumbets() {
        return numbets;
    }
    public double getStake() {
        return stake;
    }
    public double getReturns() {
        return returns;
    }
    public Integer getClientid() {
        return clientid;
    }
    public Date getDate() {
        return date;
    }

    //Setters
    public void setReturns(double returns) {
        this.returns = returns;
    }
    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }
    public void setDate(Date date) {
        this.date = date;
    }
 
    public void setStake(double stake) {
        this.stake = stake;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNumbets(Integer numbets) {
        this.numbets = numbets;
    }
    @Override
    public String toString() {
        return "Bet [clientid=" + clientid + ", date=" + date + ", game=" + game + ", id=" + id + ", numbets=" + numbets
                + ", returns=" + returns + ", stake=" + stake + "]";
    }

}
