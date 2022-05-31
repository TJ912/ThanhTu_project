package com.example.magic_rotate;

import java.util.ArrayList;

public class LoadQuestion {
    public ArrayList<Question> loadQuestion(){
        ArrayList<Question> list=new ArrayList<>();
        list.add(new Question("Đây là tên một quốc gia","VIETNAM"));
        list.add(new Question("Đây là tên một loại nước uống","NUOCMIA"));
        list.add(new Question("Đây là tên một món ăn","COMCHIEN"));
        list.add(new Question("Đây là tên một tỉnh thành","THANHHOA"));
        list.add(new Question("Đây là tên một quốc gia","HANQUOC"));
        list.add(new Question("Đây là tên một địa điểm nổi tiếng","DALAT"));
        list.add(new Question("Đây là tên một loại xe","VINFAST"));
        return list;
    }
}
