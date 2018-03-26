/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendat.daos;

import com.tiendat.dtos.IdolDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dragneol
 */
public class IdolDAO implements Serializable {

    public List<IdolDTO> createDummyIdol() {
        List<IdolDTO> idols = new ArrayList<>();
        IdolDTO idol1 = new IdolDTO("Laura Takizawa", "img/takizawa.jpg", 83, 58, 84);
        idols.add(idol1);
        IdolDTO idol2 = new IdolDTO("Tsubasa Anami", "img/anami.jpg", 90, 60, 89);
        idols.add(idol2);
        IdolDTO idol3 = new IdolDTO("Ria Sakurai", "img/sakurai.jpg", 80, 56, 82);
        idols.add(idol3);
        IdolDTO idol4 = new IdolDTO("Yuzuki Tina", "img/tina.jpg", 84, 58, 83);
        idols.add(idol4);
        IdolDTO idol5 = new IdolDTO("Ameri Ichinose", "img/ichinose.jpg", 85, 51, 85);
        idols.add(idol5);
        IdolDTO idol6 = new IdolDTO("Ngọc Trinh", "img/ngoctrinh.jpg", 84, 58, 93);
        idols.add(idol6);
        IdolDTO idol7 = new IdolDTO("Diễm My 9X", "img/diemmy.jpg", 82, 64, 90);
        idols.add(idol7);
        IdolDTO idol8 = new IdolDTO("Tâm Tít", "img/tamtit.jpg", 84, 62, 89);
        idols.add(idol8);
        IdolDTO idol9 = new IdolDTO("Nhã Phương", "img/nhaphuong.jpg", 84, 65, 93);
        idols.add(idol9);
        IdolDTO idol10 = new IdolDTO("Angela Phương Trinh", "img/phuongtrinh.jpeg", 84, 57, 93);
        idols.add(idol10);
        return idols;
    }
}
