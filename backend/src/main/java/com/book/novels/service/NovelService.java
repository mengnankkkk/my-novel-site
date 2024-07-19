package com.book.novels.service;

import com.example.novels.model.Novel;
import com.example.novels.repository.NovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NovelService {

    @Autowired
    private NovelRepository novelRepository;

    public List<Novel> getAllNovels() {
        return novelRepository.findAll();
    }

    public Optional<Novel> getNovelById(Long id) {
        return novelRepository.findById(id);
    }

    public Novel createNovel(Novel novel) {
        return novelRepository.save(novel);
    }

    public Novel updateNovel(Long id, Novel novelDetails) {
        Novel novel = novelRepository.findById(id).orElseThrow(() -> new RuntimeException("Novel not found"));
        novel.setTitle(novelDetails.getTitle());
        novel.setAuthor(novelDetails.getAuthor());
        novel.setSummary(novelDetails.getSummary());
        novel.setCoverImage(novelDetails.getCoverImage());
        novel.setContent(novelDetails.getContent());
        return novelRepository.save(novel);
    }

    public void deleteNovel(Long id) {
        Novel novel = novelRepository.findById(id).orElseThrow(() -> new RuntimeException("Novel not found"));
        novelRepository.delete(novel);
    }
}
