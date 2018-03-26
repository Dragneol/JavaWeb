/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendat.dtos;

import java.io.Serializable;

/**
 *
 * @author Dragneol
 */
public class IdolDTO implements Serializable {

    private String name, imgUrl;
    private int boob, wip, hip;

    public IdolDTO(String name, String imgUrl, int boob, int wip, int hip) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.boob = boob;
        this.wip = wip;
        this.hip = hip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getBoob() {
        return boob;
    }

    public void setBoob(int boob) {
        this.boob = boob;
    }

    public int getWip() {
        return wip;
    }

    public void setWip(int wip) {
        this.wip = wip;
    }

    public int getHip() {
        return hip;
    }

    public void setHip(int hip) {
        this.hip = hip;
    }

}
