package com.kb_hackathon.plovo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUploadImgRes {
    private String uploadImg;
    private Timestamp date;
    private String distance;
    private String time;
    private String weight;
    private String mName;
    private String profileImg;
}
