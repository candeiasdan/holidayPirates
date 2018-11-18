package com.example.holidaypirates.postDetail.viewModel;

public class CommentVM {

    private String email;
    private String comment;

    public CommentVM(String name, String email, String comment) {
        this.email = email;
        this.comment = comment;
    }

    public String getEmail() {
        return email;
    }

    public String getComment() {
        return comment;
    }
}
