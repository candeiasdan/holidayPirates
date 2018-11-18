package com.example.holidaypirates.postDetail;

import com.example.holidaypirates.postDetail.viewModel.CommentVM;
import com.example.holidaypirates.postDetail.viewModel.PhotoVM;
import com.example.holidaypirates.postDetail.viewModel.PostDetailVM;
import com.example.holidaypirates.postDetail.viewModel.UserVM;
import com.example.holidaypirates.posts.viewModel.PostVM;
import com.example.holidaypirates.repository.Repository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class DetailModel implements DetailMVP.Model {

    private final Repository repository;

    DetailModel(Repository repository) {
        this.repository = repository;
    }

    private Observable<List<PhotoVM>> getPhotosVMFromUser(final Long userId) {
        return repository.getUser(userId)
                .flatMap(user -> repository.getUserAlbums(user.getId())
                        .flatMap(albums -> repository.getAlbumPhotos(albums.get(0).getId())))
                .flatMap(photos -> Observable.fromIterable(photos)
                        .map(photo -> new PhotoVM(photo.getThumbnailUrl(), photo.getUrl()))
                        .toList()
                        .toObservable());
    }

    private Observable<List<CommentVM>> getCommentsVMForPost(final Long postId) {
        return repository.getCommentsForPost(postId)
                .flatMap(comments -> Observable.fromIterable(comments)
                        .map(comment -> new CommentVM(comment.getName(), comment.getEmail(), comment.getBody()))
                        .toList()
                        .toObservable());
    }

    @Override
    public Single<PostDetailVM> getPostDetails(PostVM post) {
        return Single.fromObservable(repository.getPost(post.getId())
                .flatMap(post1 -> Observable.zip(
                        Observable.just(post1),
                        repository.getUser(post1.getUserId()),
                        getCommentsVMForPost(post1.getId()),
                        getPhotosVMFromUser(post1.getUserId()),
                        ((post2, user, commentsVM, photosVm) -> {
                            PostDetailVM postDetail = new PostDetailVM(post1.getTitle(), post1.getBody());
                            postDetail.setUser(new UserVM(user.getUsername(), user.getWebsite()));
                            postDetail.setPhotos(photosVm);
                            postDetail.setComments(commentsVM);
                            return postDetail;
                        })
                )));
    }
}